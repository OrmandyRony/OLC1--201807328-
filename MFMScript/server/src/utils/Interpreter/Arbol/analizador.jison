%{
    //codigo js
    const controller = require('../../../controller/parser/parser');
    const errores = require('./Exceptions/Error');
    const nativo = require('./Expresions/Native');
    const aritmetico = require('./Expresions/Aritmetica');
    const relacional = require('./Expresions/Relacional');
    const logica = require('./Expresions/Logica');
    const Tipo = require('./Symbol/Type');
    const impresion = require('./Instructions/Imprimir');    
    const declaracion = require('./Instructions/Declaracion')
%}
%lex 


%options case-insensitive 
//inicio analisis lexico
%%
"imprimir"      return 'RESPRINT';
"entero"        return 'RESINT';

">"             return 'MAYOR_QUE';

"||"            return 'OR';

"="             return 'IGUAL';
"+"             return 'MAS';
";"             return 'PTCOMA';
"("             return 'PARABRE';
")"             return 'PARCIERRA';


[ \r\t]+ { }
\n {}
\"[^\"]*\"                  { yytext=yytext.substr(1,yyleng-2); return 'CADENA'; }
[0-9]+                      return 'ENTERO';
[A-Za-z]+["_"0-9A-Za-z]*    return 'IDENTIFICADOR';

<<EOF>>                     return 'EOF';
.                           return 'INVALID'

/lex

%left 'MAS'
%left 'MAYOR_QUE'

%start INIT
//Inicio
//Definicion de gramatica
%%

INIT: INSTRUCCIONES EOF     {return $1;}
;

INSTRUCCIONES : 
    INSTRUCCIONES INSTRUCCION   {$1.push($2); $$=$1;}
    | INSTRUCCION               {$$=[$1];}
;

INSTRUCCION :
    IMPRIMIR                {$$=$1;}
    | DECLARACION           {$$=$1;}
    | INVALID               {controller.listaErrores.push(new errores.default('ERROR LEXICO',$1,@1.first_line,@1.first_column));}
    | error  PTCOMA         {controller.listaErrores.push(new errores.default(`ERROR SINTACTICO`,"Se esperaba token",@1.first_line,@1.first_column));}
;

DECLARACION:
    RESINT IDENTIFICADOR IGUAL EXPRESION PTCOMA {$$=new declaracion.default($2, new Tipo.default(Tipo.DataType.ENTERO), $4, @1.first_line, @1.first_column);}
;

IMPRIMIBLE:
    EXPRESION {$$=$1;}  
    | EXPRESION_RELACIONAL {$$=$1;}  
    | EXPRESION_LOGICA {$$=$1;}  
;

IMPRIMIR : 
    RESPRINT PARABRE IMPRIMIBLE PARCIERRA PTCOMA {$$=new impresion.default($3,@1.first_line,@1.first_column);}
;

EXPRESION : 
    EXPRESION MAS EXPRESION {$$ = new aritmetico.default(aritmetico.tipoOp.SUMA, $1, $3, @1.first_line, @1.first_column);}
    | IDENTIFICADOR {$$ = new nativo.default(new Tipo.default(Tipo.DataType.IDENTIFICADOR), $1, @1.first_line, @1.first_column);}
    | ENTERO {$$= new nativo.default(new Tipo.default(Tipo.DataType.ENTERO),$1, @1.first_line, @1.first_column);}
    | CADENA {$$= new nativo.default(new Tipo.default(Tipo.DataType.CADENA),$1, @1.first_line, @1.first_column);}
;

EXPRESION_RELACIONAL :
    EXPRESION MAYOR_QUE EXPRESION {$$ = new relacional.default(relacional.tipoOp.MAYOR, $1, $3, @1.first_line, @1.first_column);}
;

EXPRESION_LOGICA :
    EXPRESION_RELACIONAL OR EXPRESION_RELACIONAL {$$ = new logica.default(logica.tipoOp.OR, $1, $3, @1.first_line, @1.first_column);}
;