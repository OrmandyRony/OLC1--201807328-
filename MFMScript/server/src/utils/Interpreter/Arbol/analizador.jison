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

">"             return 'MAYOR_QUE';

"||"            return 'OR';
"-"             return 'MENOS';
"="             return 'IGUAL';
"+"             return 'MAS';
";"             return 'PTCOMA';
"("             return 'PARABRE';
")"             return 'PARCIERRA';
"{"             return 'LLAVIZQ';
"}"             return 'LLAVDER';


[ \r\t]+ { }
\n {}


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

// rEVISAR PRESENDENCIAS
%left 'MAS' 'MENOS'
%left 'MAYOR_QUE'
%left 'OR'


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
    INT IDENTIFICADOR IGUAL EXPRESION PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2, new Tipo.default(Tipo.DataType.ENTERO), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, 'identificador', 'igual', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    DOUBLE IDENTIFICADOR IGUAL EXPRESION PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2, new Tipo.default(Tipo.DataType.DECIMAL), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, 'identificador', 'igual', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    BOOLEAN IDENTIFICADOR IGUAL EXPRESION PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2, new Tipo.default(Tipo.DataType.BOOLEAN), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, 'identificador', 'igual', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    CHAR IDENTIFICADOR IGUAL EXPRESION PTCOMA {
        console.log("Soy un char ------------");
        $$={
            returnInstruction: new declaracion.default($2, new Tipo.default(Tipo.DataType.CARACTER), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, 'igual', $4.nodeInstruction, 'ptcoma'])
        }
    }
    |
    STRING IDENTIFICADOR IGUAL EXPRESION PTCOMA {
        $$={
            returnInstruction: new declaracion.default($2, new Tipo.default(Tipo.DataType.CADENA), $4.returnInstruction, @1.first_line, @1.first_column), 
            nodeInstruction: (new Nodo('Declaracion')).generateProduction([$1, $2, 'igual', $4.nodeInstruction, 'ptcoma'])
        }
    }
;

IMPRIMIBLE:
    EXPRESION {$$=$1;}  
    | EXPRESION_LOGICA {$$=$1;}  
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
    | IDENTIFICADOR {
        $$={
            returnInstruction: new nativo.default(new Tipo.default(Tipo.DataType.IDENTIFICADOR), $1, @1.first_line, @1.first_column),
            nodeInstruction: (new Nodo('EXPRESION')).generateProduction(['IDENTIFICADOR'])
        }
    }
    /* LITERALES */
    | ENTERO {
        // console.log("Encontre un entero-----------------------------------------");
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
;

// eSRO HAY QUYE HACERO RECURSIVO
EXPRESION_LOGICA :
    EXPRESION_LOGICA OR EXPRESION_RELACIONAL {$$ = new logica.default(logica.tipoOp.OR, $1, $3, @1.first_line, @1.first_column);}
    | EXPRESION_RELACIONAL                       {$$ = $1;}
;