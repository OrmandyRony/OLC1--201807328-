%{
    const controller = require('../../../controller/parser/parser');
    const errores = require('./Exceptions/Error');
    const nativo = require('./Expresions/Native');
    const aritmetico = require('./Expresions/Aritmetica');
    const relacional = require('./Expresions/Relacional');
    const logica = require('./Expresions/Logica');
    const Tipo = require('./Symbol/Type');
    const impresion = require('./Instructions/Imprimir');    
    const ifIns = require('./Instructions/IfIns');    
    const declaracion = require('./Instructions/Declaracion')
    const mientras = require('./Instructions/Mientras');
    const doWhile = require('./Instructions/DoWhile');
    const doUntil = require('./Instructions/DoUntil');
    const cicloFor = require('./Instructions/CicloFor');
    const asignacion = require('./Instructions/Asignacion');
    const sugar = require('./Instructions/SyntacticSugar');
    const sugarDecremento = require('./Instructions/Decremento');
    const { Nodo } = require('./Symbol/Three')
%}
%lex 


%options case-insensitive 
//inicio analisis lexico
%%
\s+											// se ignoran espacios en blanco
"//".*										// comentario simple línea
[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]			// comentario multiple líneas
/* Palabras Reservadas*/

// Tipos de datos
'int'           return 'INT';
'double'        return 'DOUBLE';
'boolean'       return 'BOOLEAN';
'char'          return 'CHAR';
'string'        return 'STRING';



/* cierrre */
/* Imprimir */
"print"(ln)?         return 'RESPRINT';


/* Condicionales */
"if"            return 'RESIF';
"else"          return 'RESELSE';
'elif'          return 'RES_ELIF';

/*Ciclos*/
"while"         return 'RESWHILE';
'for'           return "RES_FOR";
'do'            return "RES_DO";
'until'         return 'RES_UNTIL';

/* incremento y decremento*/
"++"             return 'INCREMENTO';
"--"             return 'DECREMENTO';

/* Operaciones aritmeticas */
"+"             return 'MAS';
"-"             return 'MENOS';
"*"             return 'POR';
"/"             return 'DIVIDIDO';
'^'             return 'POTENCIA';
'%'             return 'MODULO';




/* Operaciones relacionales */
'<='            return 'MENOR_IGUAL';
'>='            return 'MAYOR_IGUAL';
">"             return 'MAYOR_QUE';
'<'             return 'MENOR_QUE';
"=="            return 'IGUAL';
'!='            return 'DIFERENTE';

/*  */
'='             return 'ASIGNACION';

/* Operadores Logicos */
'||'            return "OR";
'&&'            return "AND";
'!'             return "NOT";



";"             return 'PTCOMA';
"("             return 'PARABRE';
")"             return 'PARCIERRA';
"{"             return 'LLAVIZQ';
"}"             return 'LLAVDER';
","             return 'COMA';

[ \r\t]+ { }
\n {}


/* Literales */
[0-9]+("."[0-9]+)\b             return 'DECIMAL';
[0-9]+                          return 'ENTERO';
"true"                          return 'TRUE';            
"false"                         return 'FALSE';
[A-Za-z]+["_"0-9A-Za-z]*        return 'IDENTIFICADOR';
\"[^]*\"                      { yytext=yytext.substr(1,yyleng-2); return 'CADENA'; }

\'[^]\'                         return 'CARACTER';


<<EOF>>                         return 'EOF';
.                               return 'INVALID'

/lex

// rEVISAR PRESENDENCIAS
%left 'OR'
%left 'AND' 
%right 'NOT'
%left 'IGUAL' 'DIFERENTE' 'MENOR_QUE' 'MENOR_IGUAL'  'MAYOR_QUE' 'MAYOR_IGUAL'  
%left 'MAS' 'MENOS'
%left 'POR' 'DIVIDIDO'  
%left 'POTENCIA' 'MODULO'




%start INIT
//Inicio
//Definicion de gramatica
%%

INIT: INSTRUCCIONES EOF     {
        return {
            returnInstruction: $1.returnInstruction, 
            nodeInstruction: (new Nodo("INIT")).generateProduction([$1.nodeInstruction, 'EOF'])            
        };
    }
;

INSTRUCCIONES : 
    INSTRUCCIONES INSTRUCCION   {        
        $$={
            returnInstruction: [...$1.returnInstruction, $2.returnInstruction], 
            nodeInstruction: (new Nodo("Instrucciones")).generateProduction([$1.nodeInstruction,  $2.nodeInstruction]) 
        };
    }
    | INSTRUCCION               {
        $$={
            returnInstruction: [$1.returnInstruction],
            nodeInstruction: (new Nodo("Instrucciones")).generateProduction([$1.nodeInstruction])
        };
    }
;

IDENTIFICADORES: 
    IDENTIFICADORES COMA  IDENTIFICADOR {
        $$={
            returnInstruction: [...$1.returnInstruction, $3.returnInstruction], 
            nodeInstruction: (new Nodo('DECLARACION_MULTIPLE')).generateProduction([$1.nodeInstruction, (new Nodo('IDENTIFICADOR')).generateProduction([$3])])
        }
    }
    | 
    IDENTIFICADOR  {
        console.log("Un identificador");
        $$ = {
                returnInstruction: $1,
                nodeInstruction: (new Nodo('IDENTIFICADOR')).generateProduction([$1])
            }
        }
        
;


INSTRUCCION :
    IMPRIMIR                {
        $$={
            returnInstruction: $1.returnInstruction, 
            nodeInstruction: (new Nodo("INSTRUCCION")).generateProduction([$1.nodeInstruction]) 
        };
    }                
    | WHILEINS              {$$=$1;}
    | DO_WHILE_INS          {$$=$1;}
    | DO_UNTIL_INS          {$$=$1;}
    | FOR_INS               {$$=$1;}
    | REASIGNACION          {$$=$1;} // cuidado con esta clase
    | IFINS                 {$$=$1;}
    | DECLARACION           {
        $$={
            returnInstruction: $1.returnInstruction, 
            nodeInstruction: (new Nodo("INSTRUCCION")).generateProduction([$1.nodeInstruction]) 
        };
    }
    | SUGAR_SINTACTIC       {$$=$1;}
    | INVALID               {controller.listaErrores.push(new errores.default('ERROR LEXICO',$1, @1.first_line, @1.first_column));}
    | error  PTCOMA         {console.log("ERRORES", @1.first_line, @1.first_column); controller.listaErrores.push(new errores.default(`ERROR SINTACTICO`,"Se esperaba token", @1.first_line, @1.first_column));}
;

/* Azucar sintactica */
SUGAR_SINTACTIC:
    IDENTIFICADOR INCREMENTO PTCOMA  {
        console.log("Azucar++");
        $$={
            returnInstruction: new sugar.default($1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('Incremento')).generateProduction([$1 + "++"])
        }
    }
    |
    IDENTIFICADOR DECREMENTO PTCOMA {
        console.log("Azucar");
        $$={
            returnInstruction: new sugarDecremento.default($1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('Decremento')).generateProduction([$1 + "--"])
        }
    }
    |
    IDENTIFICADOR INCREMENTO   {
        console.log("Azucar++");
        $$={
            returnInstruction: new sugar.default($1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('Incremento')).generateProduction([$1 + "++"])
        }
    }
    |
    IDENTIFICADOR DECREMENTO  {
        console.log("Azucar");
        $$={
            returnInstruction: new sugarDecremento.default($1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('Decremento')).generateProduction([$1 + "--"])
        }
    }
;

/*CICLOS*/
/* While */
WHILEINS:
    RESWHILE PARABRE EXPRESIONES PARCIERRA LLAVIZQ INSTRUCCIONES LLAVDER {
        $$={
            returnInstruction: new mientras.default($3.returnInstruction, $6.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo("WHILE")).generateProduction(["WHILE","(", $3.nodeInstruction, ")", "{", $6.nodeInstruction, "}"]) 
        }
    }
;

FOR_INS:
    RES_FOR PARABRE DECLARACION EXPRESIONES PTCOMA SUGAR_SINTACTIC PARCIERRA LLAVIZQ INSTRUCCIONES LLAVDER {
        console.log("reconi el for--------------------------------------");
        $$={
            returnInstruction: new cicloFor.default($3.returnInstruction, $4.returnInstruction, $6.returnInstruction, $9.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo("FOR_INS")).generateProduction(["FOR","(", $3.nodeInstruction, $4.nodeInstruction, $6.nodeInstruction,")", "{", $9.nodeInstruction, "}"]) 
        }
    }
;

/* Do while */
DO_WHILE_INS:
    RES_DO LLAVIZQ INSTRUCCIONES LLAVDER RESWHILE PARABRE EXPRESIONES PARCIERRA PTCOMA {
        console.log("Detecte un dowhile");
        $$={
            returnInstruction: new doWhile.default($7.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo("DO_WHILE")).generateProduction(["DO","{", $3.nodeInstruction, "}", "WHILE","{", $7.nodeInstruction, "}"]) 
        }
    }
;

/* Do until */
DO_UNTIL_INS:
    RES_DO LLAVIZQ INSTRUCCIONES LLAVDER RES_UNTIL PARABRE EXPRESIONES PARCIERRA PTCOMA {
        console.log("Detecte un doUNTIL");
        $$={
            returnInstruction: new doUntil.default($7.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo("DO_WHILE")).generateProduction(["DO","{", $3.nodeInstruction, "}", "UNTIL","{", $7.nodeInstruction, "}"]) 
        }
    }
;

/*CONDICIONALES*/
/*If ins*/
IFINS:
    SIMPLEIF                {$$ = $1;}
    | /*Else if*/
    RESIF PARABRE EXPRESIONES PARCIERRA LLAVIZQ INSTRUCCIONES LLAVDER  RESELSE LLAVIZQ INSTRUCCIONES LLAVDER {
        // console.log("Soy un else if");
        $$={
            returnInstruction: new ifIns.default($3.returnInstruction, $6.returnInstruction, undefined, $10.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo("ELSE_IF")).generateProduction(["IF","(", $3.nodeInstruction, ")", "{", $6.nodeInstruction, "}", "ELSE", "{", $10.nodeInstruction, "}"]) 
        }
    }                            
    | 
    RESIF PARABRE EXPRESIONES PARCIERRA LLAVIZQ INSTRUCCIONES LLAVDER ELSEIFSINS RESELSE LLAVIZQ INSTRUCCIONES LLAVDER {
        // console.log("Soy un else ELIF if");
        // console.log($8);
        $$={
            returnInstruction: new ifIns.default($3.returnInstruction, $6.returnInstruction, $8.returnInstruction, $11.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo("SIMPLE_IF")).generateProduction(["IF","(", $3.nodeInstruction, ")", "{", $6.nodeInstruction, "}", $8.nodeInstruction, "ELSE", "{", $11.nodeInstruction, "}"]) 
        }
    }
;

SIMPLEIF:
    RESIF PARABRE EXPRESIONES PARCIERRA LLAVIZQ INSTRUCCIONES LLAVDER  {
        $$={
            returnInstruction: new ifIns.default($3.returnInstruction, $6.returnInstruction, undefined, undefined, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo("SIMPLE_IF")).generateProduction(["IF","(", $3.nodeInstruction, ")", "{", $6.nodeInstruction, "}"]) 
        }
    }
;

// ELIF
SIMPLE_ELIF:
    RES_ELIF PARABRE EXPRESIONES PARCIERRA LLAVIZQ INSTRUCCIONES LLAVDER  {

        $$={
            returnInstruction: new ifIns.default($3.returnInstruction, $6.returnInstruction, undefined, undefined, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo("SIMPLE_IF")).generateProduction(["ELIF","(", $3.nodeInstruction, ")", "{", $6.nodeInstruction, "}"]) 
        }
    }
;

ELSEIFSINS :
    ELSEIFSINS SIMPLE_ELIF{        
        $$={
            returnInstruction: [...$1.returnInstruction, $2.returnInstruction], 
            nodeInstruction: (new Nodo("SABER")).generateProduction([$1.nodeInstruction,  $2.nodeInstruction]) 
        };
    }
    | 
    SIMPLE_ELIF  {
        $$={
            returnInstruction: [$1.returnInstruction],
            nodeInstruction: (new Nodo("MOTON_ELSE_IF")).generateProduction([$1.nodeInstruction])
        };
    }
                                                
                                             /*   {$$=[$1];}*/
;

/*
ELSEIFSINS :
    ELSEIFSINS RESELSE SIMPLEIF 
                                                {$1.push($3); $$=$1;}
  | RESELSE SIMPLEIF  
                                                {$$=[$2];;}
;
*/
/* TipoS de dato */
/*
TIPO_DATO: 
    INT             {$$ = $1;}
    | DOUBLE        {$$ = $1;}
    | BOOLEAN       {$$ = $1;}
    | CHAR          {$$ = $1;}    
    | STRING        {$$ = $1;}
;
*/

/* Asignacion cambiarle nombre a reasinacion */
REASIGNACION 
    :
    IDENTIFICADOR ASIGNACION EXPRESION PTCOMA {
        $$={
            returnInstruction: new asignacion.default($1, $3.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('REASIGNACION')).generateProduction([$1, 'ASIGNACION', $3.nodeInstruction, 'ptcoma'])
        }
    }
;

/*Declaraciones */
DECLARACION:

    INT IDENTIFICADORES ASIGNACION EXPRESION PTCOMA {
        console.log("Declarando entero");
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.ENTERO), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2.nodeInstruction, 'ASIGNACION', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    DOUBLE IDENTIFICADORES ASIGNACION EXPRESION PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.DECIMAL), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, 'ASIGNACION', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    BOOLEAN IDENTIFICADORES ASIGNACION EXPRESIONES PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.BOOLEAN), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, 'ASIGNACION', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    CHAR IDENTIFICADORES ASIGNACION EXPRESION PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.CARACTER), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, 'ASIGNACION', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    STRING IDENTIFICADORES ASIGNACION EXPRESION PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.CADENA), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, 'ASIGNACION', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    // Declarasion sin asignacion
    INT IDENTIFICADORES PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.ENTERO),  new nativo.default(new Tipo.default(Tipo.DataType.ENTERO), 0, @1.first_line, @1.first_column), @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, (new Nodo('VALOR_POR_DEFECTO')).generateProduction(['0']), 'ptcoma'])
        }
    }
    |
    DOUBLE IDENTIFICADORES PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.DECIMAL),  new nativo.default(new Tipo.default(Tipo.DataType.DECIMAL), 0.0, @1.first_line, @1.first_column), @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, (new Nodo('VALOR_POR_DEFECTO')).generateProduction(['0.0']), 'ptcoma'])
        }
    }
    |
    BOOLEAN IDENTIFICADORES PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.BOOLEAN),  new nativo.default(new Tipo.default(Tipo.DataType.boolean), true, @1.first_line, @1.first_column), @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, (new Nodo('VALOR_POR_DEFECTO')).generateProduction(['true']), 'ptcoma'])
        }
    }
    |
    CHAR IDENTIFICADORES PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.CARACTER),  new nativo.default(new Tipo.default(Tipo.DataType.CARACTER), '0', @1.first_line, @1.first_column), @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, (new Nodo('VALOR_POR_DEFECTO')).generateProduction(['\'0\'']), 'ptcoma'])
        }
    }
    |
    STRING IDENTIFICADORES PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.CADENA),  new nativo.default(new Tipo.default(Tipo.DataType.CADENA), "", @1.first_line, @1.first_column), @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, (new Nodo('VALOR_POR_DEFECTO')).generateProduction(['""']), 'ptcoma'])
        }
    }
;


IMPRIMIR : 
    RESPRINT PARABRE EXPRESIONES PARCIERRA PTCOMA {
        $$={
            returnInstruction:  new impresion.default($3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('IMPRIMIR')).generateProduction([$3.nodeInstruction])
        }

    }
;

/* EXPRESIONES  Y LITERALES */
EXPRESIONES
    : 
    EXPRESION {$$=$1;}
    | 
    EXPRESION_LOGICA {$$=$1;}
    | 
    EXPRESION_RELACIONAL {$$=$1;}
;

EXPRESION : 
    EXPRESION MAS EXPRESION {
         //console.log("declaracion suma");
        $$={
            returnInstruction: new aritmetico.default(aritmetico.tipoOp.SUMA, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction([$1.nodeInstruction, 'SUMA', $3.nodeInstruction])
        }
    }
    | EXPRESION MENOS EXPRESION {
        $$={
            returnInstruction: new aritmetico.default(aritmetico.tipoOp.RESTA, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction([$1.nodeInstruction, 'MENOS', $3.nodeInstruction])
        }
    }
    | EXPRESION POR EXPRESION {
        $$={
            returnInstruction: new aritmetico.default(aritmetico.tipoOp.MULTIPLICACION, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction([$1.nodeInstruction, 'POR', $3.nodeInstruction])
        }
    }
    | EXPRESION DIVIDIDO EXPRESION {
        $$={
            returnInstruction: new aritmetico.default(aritmetico.tipoOp.DIVISION, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction([$1.nodeInstruction, 'DIVISION', $3.nodeInstruction])
        }
    }
    | EXPRESION POTENCIA EXPRESION {
        $$={
            returnInstruction: new aritmetico.default(aritmetico.tipoOp.POTENCIA, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction([$1.nodeInstruction, 'POTENCIA', $3.nodeInstruction])
        }
    }
    | EXPRESION MODULO EXPRESION {
        $$={
            returnInstruction: new aritmetico.default(aritmetico.tipoOp.MODULO, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction([$1.nodeInstruction, 'MODULO', $3.nodeInstruction])
        }
    }
    |
    PARABRE EXPRESION PARCIERRA { 
        $$={
            returnInstruction: $2.returnInstruction,
            nodeInstruction: $2.nodeInstruction
        }
    }
    | IDENTIFICADOR {
        $$={
            returnInstruction: new nativo.default(new Tipo.default(Tipo.DataType.IDENTIFICADOR), $1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction(['IDENTIFICADOR'])
        }
    }
   | LITERALES {$$=$1; }
;

LITERALES: 
    | ENTERO {
        console.log("Encontre un entero-----------------------------------------");
        $$={
            returnInstruction: new nativo.default(new Tipo.default(Tipo.DataType.ENTERO),$1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction(['ENTERO'])
        }
    }
    | DECIMAL {
        // console.log("Encontre un decimal-----------------------------------------");
        $$={
            
            returnInstruction: new nativo.default(new Tipo.default(Tipo.DataType.DECIMAL), $1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction(['DECIMAL'])
        }
    }
    | CADENA {
        $$={
            returnInstruction: new nativo.default(new Tipo.default(Tipo.DataType.CADENA),$1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction(['CADENA'])
        }
    }
    | CARACTER {
        $$={
            returnInstruction: new nativo.default(new Tipo.default(Tipo.DataType.CARACTER),$1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction(['CARACTER'])
        }
    }
    | TRUE {
        $$={
            
            returnInstruction: new nativo.default(new Tipo.default(Tipo.DataType.TRUE), $1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction(['TRUE'])
        }
    }
    | FALSE {
        $$={
            
            returnInstruction: new nativo.default(new Tipo.default(Tipo.DataType.FALSE), $1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction(['FALSE'])
        }
    }
;

EXPRESION_RELACIONAL
    :
    EXPRESION MAYOR_QUE EXPRESION {
        $$={
            returnInstruction: new relacional.default(relacional.tipoOp.MAYOR, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION_RELACIONAL')).generateProduction([$1.nodeInstruction, 'MAYOR_QUE', $3.nodeInstruction])
        }
    }
    |
    EXPRESION MENOR_QUE EXPRESION {
        console.log("Detecto una expresion relacional");
        $$={
            returnInstruction: new relacional.default(relacional.tipoOp.MENOR, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION_RELACIONAL')).generateProduction([$1.nodeInstruction, 'MENOR_QUE', $3.nodeInstruction])
        }
    }
    |
    EXPRESION MAYOR_IGUAL EXPRESION {
        $$={
            returnInstruction: new relacional.default(relacional.tipoOp.MAYOR_IGUAL, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION_RELACIONAL')).generateProduction([$1.nodeInstruction, 'MAYOR_IGUAL', $3.nodeInstruction])
        }
    }
    |
    EXPRESION MENOR_IGUAL EXPRESION {
        $$={
            returnInstruction: new relacional.default(relacional.tipoOp.MENOR_IGUAL, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION_RELACIONAL')).generateProduction([$1.nodeInstruction, 'MENOR_IGUAL', $3.nodeInstruction])
        }
    }
    |
    EXPRESION IGUAL EXPRESION {
        $$={
            returnInstruction: new relacional.default(relacional.tipoOp.IGUAL, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION_RELACIONAL')).generateProduction([$1.nodeInstruction, 'IGUAL', $3.nodeInstruction])
        }
    }
    |
    EXPRESION DIFERENTE EXPRESION {
        $$={
            returnInstruction: new relacional.default(relacional.tipoOp.DIFERENTE, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION_RELACIONAL')).generateProduction([$1.nodeInstruction, 'DIFERENTE', $3.nodeInstruction])
        }
    }
    |
    PARABRE EXPRESION_RELACIONAL PARCIERRA { 
        $$={
            returnInstruction: $2.returnInstruction,
            nodeInstruction: $2.nodeInstruction
        }
    }
;

// eSRO HAY QUYE HACERO RECURSIVO
EXPRESION_LOGICA
    :
    EXPRESION_RELACIONAL OR EXPRESION_RELACIONAL {
        $$={
            returnInstruction: new logica.default(logica.tipoOp.OR, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION_LOGICA')).generateProduction([$1.nodeInstruction, 'OR', $3.nodeInstruction])
        }
    }
    |
    EXPRESION_RELACIONAL AND EXPRESION_RELACIONAL {
        $$={
            returnInstruction: new logica.default(logica.tipoOp.AND, $1.returnInstruction, $3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION_LOGICA')).generateProduction([$1.nodeInstruction, 'AND', $3.nodeInstruction])
        }
    }
    |

    NOT EXPRESION_RELACIONAL {
        $$={
            returnInstruction: new logica.default(logica.tipoOp.NOT, null, $2.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION_LOGICA')).generateProduction(['NOT', $2.nodeInstruction])
        }
    }
;