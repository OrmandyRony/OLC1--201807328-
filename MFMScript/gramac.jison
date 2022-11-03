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
    const asignacion = require('./Instructions/Asignacion');
    const { Nodo } = require('./Symbol/Three')
%}
%lex 


%options case-insensitive 
//inicio analisis lexico
%%

/* Palabras Reservadas*/

// Tipos de datos
'int'           return 'INT';
'double'        return 'DOUBLE';
'boolean'       return 'BOOLEAN';
'char'          return 'CHAR';
'string'        return 'STRING';



/* cierrre */

"print"      return 'RESPRINT';
"entero"        return 'RESINT'; // replazado
"if"            return 'RESIF';
"else"          return 'RESELSE';
"while"      return 'RESWHILE';

/* Operaciones aritmeticas */
"+"             return 'MAS';
"-"             return 'MENOS';
"*"             return 'POR';
"/"             return 'DIVIDIDO';
'^'             return 'POTENCIA';
'%'             return 'MODULO';


/* Operadores Logicos */
'||' return "OR";
'&&' return "AND";
'!' return "NOT";


/* Operaciones relacionales */
// Operadores relacionales
'==' return 'IGUAL';
'!=' return 'DIFERENTE';
'>' return 'MAYOR_QUE';
'<' return 'MENOR_QUE';
'>=' return 'MAYOR_IGUAL';
'<=' return 'MENOR_IGUAL';



";"             return 'PTCOMA';
"("             return 'PARABRE';
")"             return 'PARCIERRA';
"{"             return 'LLAVIZQ';
"}"             return 'LLAVDER';
","             return 'COMA';

[ \r\t]+ { }
\n {}
"//".*                              // comentario simple línea
[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/] // comentario multiple líneas


/* Literales */
[0-9]+("."[0-9]+)\b             return 'DECIMAL';
[0-9]+                          return 'ENTERO';
[A-Za-z]+["_"0-9A-Za-z]*        return 'IDENTIFICADOR';
\"[^\"]*\"                      { yytext=yytext.substr(1,yyleng-2); return 'CADENA'; }
"true"                          return 'TRUE';            
"false"                         return 'FALSE';
\'[^]\'                         return 'CARACTER';


<<EOF>>                         return 'EOF';
.                               return 'INVALID'

/lex

// PRESEDENCIAS
%left 'OR'
%left 'AND' 
%left 'POR' 'DIVIDIDO'  'POTENCIA' 'MODULO'
%left 'MAS' 'MENOS'
%left 'MAYOR_QUE' 'MENOR_QUE' 'MAYOR_IGUAL' 'MENOR_IGUAL' 'IGUAL' 'DIFERENTE'
%right 'NOT'


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
        $$ = {
                returnInstruction: [$1],
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
    | ASIGNACION            {$$=$1;} 
    | IFINS                 {$$=$1;}
    | DECLARACION           {
        $$={
            returnInstruction: $1.returnInstruction, 
            nodeInstruction: (new Nodo("INSTRUCCION")).generateProduction([$1.nodeInstruction]) 
        };
    }
    | INVALID               {controller.listaErrores.push(new errores.default('ERROR LEXICO',$1,@1.first_line,@1.first_column));}
    | error  PTCOMA         {controller.listaErrores.push(new errores.default(`ERROR SINTACTICO`,"Se esperaba token",@1.first_line,@1.first_column));}
;

/* Asignacion */
ASIGNACION :
    IDENTIFICADOR IGUAL EXPRESION PTCOMA 
                            {$$ = new asignacion.default($1, $3, @1.first_line, @1.first_column);}
;

/* While */
WHILEINS:
    RESWHILE PARABRE EXPRESION_LOGICA PARCIERRA LLAVIZQ INSTRUCCIONES LLAVDER
            {$$ = new mientras.default($3, $6, @1.first_line, @1.first_column)}
;
/*If ins*/
IFINS:
    SIMPLEIF                {$$ = $1;}                            
    | RESIF PARABRE EXPRESION_LOGICA PARCIERRA LLAVIZQ INSTRUCCIONES LLAVDER ELSEIFSINS RESELSE LLAVIZQ INSTRUCCIONES LLAVDER 
                            {$$=new ifIns.default($3,$6,$8,$11,@1.first_line,@1.first_column);} 
;

SIMPLEIF:
    RESIF PARABRE EXPRESION_LOGICA PARCIERRA LLAVIZQ INSTRUCCIONES LLAVDER 
                            {$$=new ifIns.default($3,$6, undefined, undefined, @1.first_line, @1.first_column);}
;

ELSEIFSINS :
    ELSEIFSINS RESELSE SIMPLEIF 
                                                {$1.push($3); $$=$1;}
  | RESELSE SIMPLEIF  
                                                {$$=[$2];;}
;

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

/*Declaraciones */
DECLARACION:

    INT IDENTIFICADORES IGUAL EXPRESIONES PTCOMA {
        console.log("Reconozco entero--------------");
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.ENTERO), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2.nodeInstruction, 'igual', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    DOUBLE IDENTIFICADORES IGUAL EXPRESIONES PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.DECIMAL), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, 'igual', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    BOOLEAN IDENTIFICADORES IGUAL EXPRESIONES PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.BOOLEAN), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, 'igual', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    CHAR IDENTIFICADORES IGUAL EXPRESIONES PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.CARACTER), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, 'igual', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    STRING IDENTIFICADORES IGUAL EXPRESIONES PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2.returnInstruction, new Tipo.default(Tipo.DataType.CADENA), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, 'igual', $4.nodeInstruction, 'ptcoma'])
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



IMPRIMIBLE:
    EXPRESIONES {$$=$1;}  
;

IMPRIMIR : 
    RESPRINT PARABRE IMPRIMIBLE PARCIERRA PTCOMA {
        $$={
            returnInstruction:  new impresion.default($3.returnInstruction, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('IMPRIMIR')).generateProduction([$3.nodeInstruction])
        }

    }
;

/* EXPRESIONES  Y LITERALES */
EXPRESIONES: 
    EXPRESION {$$=$1;}
    | EXPRESION_LOGICA {$$=$1;}
    | EXPRESION_RELACIONAL {$$=$1;}
;

EXPRESION : 
    EXPRESION MAS EXPRESION {
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
    | IDENTIFICADOR {
        $$={
            returnInstruction: new nativo.default(new Tipo.default(Tipo.DataType.IDENTIFICADOR), $1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction(['IDENTIFICADOR'])
        }
    }
    | LITERALES {console.log("Buscando literal");$$=$1; }
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
        console.log("Encontre un CARACTER-----------------------------------------");
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

EXPRESION_RELACIONAL :
    EXPRESION MAYOR_QUE EXPRESION {$$ = new relacional.default(relacional.tipoOp.MAYOR, $1, $3, @1.first_line, @1.first_column);}
    |
    EXPRESION MENOR_QUE EXPRESION {$$ = new relacional.default(relacional.tipoOp.MENOR_QUE, $1, $3, @1.first_line, @1.first_column);}
    |
    EXPRESION MAYOR_IGUAL EXPRESION {$$ = new relacional.default(relacional.tipoOp.MAYOR_IGUAL, $1, $3, @1.first_line, @1.first_column);}
    |
    EXPRESION MENOR_IGUAL EXPRESION {$$ = new relacional.default(relacional.tipoOp.MENOR_IGUAL, $1, $3, @1.first_line, @1.first_column);}
    |
    EXPRESION IGUAL EXPRESION {$$ = new relacional.default(relacional.tipoOp.IGUAL, $1, $3, @1.first_line, @1.first_column);}
    |
    EXPRESION DIFERENTE EXPRESION {$$ = new relacional.default(relacional.tipoOp.DIFERENTE, $1, $3, @1.first_line, @1.first_column);}
    |
    PARABRE EXPRESION_RELACIONAL PARCIERRA {$$=$1;}
;

// eSRO HAY QUYE HACERO RECURSIVO
EXPRESION_LOGICA :
    EXPRESION_RELACIONAL OR EXPRESION_RELACIONAL {$$ = new logica.default(logica.tipoOp.OR, $1, $3, @1.first_line, @1.first_column);}
    |
    EXPRESION_RELACIONAL AND EXPRESION_RELACIONAL {$$ = new logica.default(logica.tipoOp.AND, $1, $3, @1.first_line, @1.first_column);}
    |
    NOT EXPRESION_RELACIONAL {$$ = new logica.default(logica.tipoOp.NOT, null, $2, @1.first_line, @1.first_column);}
;