%{
    //codigo js
    const nativo = require('./Expresions/Native');
    const Tipo = require('./Symbol/Type');
    const impresion = require('./Instructions/imprimir');
%}
%lex 


%options case-insensitive 
//inicio analisis lexico
%%

<<EOF>>                     return 'EOF';
.                           return 'INVALID'

/lex

%start INIT
//Inicio de la gramatica
//Definicion de gramatica
%%

INIT: 
;

