%{
    //codigo js, importaciones
 
%}
%lex 


%options case-insensitive 
//inicio analisis lexico
%%

"imprimir"      return 'RESPRINT';
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

%start INIT
//Inicio de la gramatica
//Definicion de gramatica
%%

// $1 es un arreglo $1 es lo que obtenemos al final
INIT: INSTRUCCIONES EOF {return $1;}
;

// $$ ES COMO UN RETURN #$2 Es la instruccion 2
INSTRUCCIONES : INSTRUCCIONES INSTRUCCION {$1.push($2); $$=$1;}
              | INSTRUCCION {$$=[$1];}
;

INSTRUCCION : IMPRIMIR                {$$=$1;} 
        | INVALID               {;} /* Errores lexicos*/
        | error  PTCOMA         {;} /*Errores sintacticos, se intenta recuperar cada punto como*/
;

// INTRUCCION IMPRIMIR
IMPRIMIR : 
    RESPRINT PARABRE EXPRESION PARCIERRA PTCOMA {;}
;

EXPRESION : ENTERO
    | CADENA
;