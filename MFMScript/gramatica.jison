/**
*   Gramatica del lenguaje MFMScript
*/

/**
*   Definicion lexica
*/


%lex

%options case-insensitive

%%

/* Definiciones regulares o reglas de traduccion*/
DeLim = \t|\r|\n|\f|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {DeLim} | [ \t\f]

/* Comments */
TraditionalComment   = "/*" [^] ~"*/" | "/*" "*"+ "/" //Tener cuidado con este
EndOfLineComment     = "//" {InputCharacter}* {DeLim}?
Comment = {TraditionalComment} | {EndOfLineComment}


Digito = [0-9]
Letra = [a-zA-Z]
Id =  {Letra}({Letra}|{Digito}|"_")*
Variable =  "_" {Id} "_"
Numero = {Digito}{Digito}* | {Digito}+(\.{Digito}+)
Caracter = ("'" [^] "'" | ("\'\${" {AscciLetras} "}\'")) // '${111}'
Cadena = "\"" [^\"]* "\"" 
Boolean = "verdadero" | "falso"
Asignacion = "->"

/* Palabras reservadas */

// Tipos de datos
'int' return 'INT';
'double' return 'DOUBLE';
'boolean' return 'BOOLEAN';
'char' return 'CHAR';
'string' return 'STRING';

// Simbolos aritmeticos
'+' return 'SUMA';
'-' return 'RESTA'; // o negacion unaria
'*' return 'MULTIPLICACION';
'/' return 'DIVISION';
'^' return 'POTENCIA';
'%' return 'MODULO';

// Operadores relacionales
'==' return 'IGUAL';
'!=' return 'DIFERENTE';
'>' return 'MAYOR';
'<' return 'MENOR';
'>=' return 'MAYOR_IGUAL';
'<=' return 'MENOR_IGUAL';

// Operador ternario
'?' return "TERNARIO";

// Operadores Logicos
'||' return "OR";
'&&' return "AND";
'!' return "NOT";

// Signos de agrupacion
'(' return "PARENTECIS_ABRE";
')' return "PARENTECIS_CIERRA";

// Caracteres de finalizacion
';' return "PUNTO_COMA";

// Caracteres encapsulamiento de sentencias
'{' return "LLAVE_ABRE";
'}' return "LLAVE_CIERRA";

// Caracteres encapsulamiento de vectores
'[' return "CORCHETE_ABRE";
']' return "CORCHETE_CIERRA";

// Condicionales
'if' return "SI";
'else'return "DE_LO_CONTRARIO";
'elif'return 'O_SI';
'switch'return 'SEGUN';
'case' return "CASO";
'default' return 'DEFAULT';

// Ciclos
'while' return "WHILE";
'for' return "FOR";
'do' return "DO";
'until' return 'UNTIL';

// Sentencias de transferencia
'break' return "BREAK";
'continue' return "CONTINUE";
'return' return 'RETURN';

// Dos puntos
':' return 'DOS_PUNTOS';

// Print
'print' return 'PRINT';
'println' return 'PRINTLN';

// toLower
'toLower' return 'TO_LOWER';

// toUpper
'toUpper' return 'TO_UPPER';

// Round
'round' return 'ROUND';






















"Evaluar"			return 'REVALUAR';
";"					return 'PTCOMA';
"("					return 'PARIZQ';
")"					return 'PARDER';
"["					return 'CORIZQ';
"]"					return 'CORDER';

"+"					return 'MAS';
"-"					return 'MENOS';
"*"					return 'POR';
"/"					return 'DIVIDIDO';


/* Espacios en blanco */
[ \r\t]+			{}
\n					{}


[0-9]+("."[0-9]+)?\b  	return 'DECIMAL';
[0-9]+\b				return 'ENTERO';

<<EOF>>				return 'EOF';

.					{ console.error('Este es un error léxico: ' + yytext + ', en la linea: ' + yylloc.first_line + ', en la columna: ' + yylloc.first_column); }
/lex
