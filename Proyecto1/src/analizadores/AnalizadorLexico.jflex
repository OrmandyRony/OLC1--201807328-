/* Analizador lexico */
package analizadores;
import java_cup.runtime.*;

%%
%public
%class AnalizadorLexico
%ignorecase
%cup
%char
%line
%column
%unicode

/* Definiciones regulares*/
DeLim = \t|\r|\n|\f|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {DeLim} | [ \t\f]

/* Comments */
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {DeLim}?
Comment = {TraditionalComment} | {EndOfLineComment}


Digito = [0-9]
Letra = [a-zA-Z]
Id =  {Letra}({Letra}|{Digito})*
Variable =  "_" {Id} "_"
Numero = [1-9]{Digito}* | {Digito}+(\.{Digito}+)
AscciMayusculas = (6[5-9]|[7-8][0-9]|90)
AscciMinusculas = (9[7-9]|1[0-1][0-9]|12[0-2])
AscciLetras = {AscciMayusculas} | {AscciMinusculas}
Caracter = ("'" [^] "'" | ("\'\${" {AscciLetras} "}\'")) // '${111}'
Cadena = "\"" [^\"]* "\"" // Esto esta malo 
Boolean = "verdadero" | "falso"
Asignacion = "->"

%%

/* Keywords */
<YYINITIAL> "inicio"        { System.out.println("Se reconocio inicio"); return new Symbol(sym.INICIO); }
<YYINITIAL> "fin"           { System.out.println("Se reconocio fin"); return new Symbol(sym.FIN); }
<YYINITIAL> "ingresar"      { System.out.println("Se reconocio ingresar"); return new Symbol(sym.INGRESAR); }
<YYINITIAL> {Variable}      { System.out.println("Se reconocio variable"); return new Symbol(sym.VARIABLE); }
<YYINITIAL> "como"          { System.out.println("Se reconocio como"); return new Symbol(sym.COMO); }
<YYINITIAL> "con_valor"     { System.out.println("Se reconocio con_valor"); return new Symbol(sym.CON_VALOR); }
<YYINITIAL> {Asignacion}    { System.out.println("Se reconocio con_valor"); return new Symbol(sym.ASIGNACION); }

/* Tipos de dato */
<YYINITIAL> { 
    "boolean"           { return new Symbol(sym.BOOLEAN); }
    "numero"            { System.out.println("Se reconocio numero"); return new Symbol(sym.NUMERO); }
    "caracter"          { return new Symbol(sym.CARACTER); }
    "cadena"            { return new Symbol(sym.CADENA); }
}

/* Literales */
<YYINITIAL> {Numero}    { System.out.println("Se reconocio literalNumero"); return new Symbol(sym.LIT_NUMERO); }
<YYINITIAL> {Caracter}  { System.out.println("Se reconocio el LITERAL caracter"); return new Symbol(sym.LIT_CARACTER); }
<YYINITIAL> {Cadena}    { System.out.println("Se reconocio el LITERAL CADENA: " + yytext()); return new Symbol(sym.LIT_CADENA); }
<YYINITIAL> {Boolean}   { System.out.println("Se reconocio el LITERAL booleana"); return new Symbol(sym.LIT_BOOLEAN); }
<YYINITIAL> ";" { System.out.println("Se reconocio punto y coma"); return new Symbol(sym.PUNTO_COMA); }


/* Operadores */
<YYINITIAL> {
"mayor"           { return new Symbol(sym.MAYOR); }
"menor"           { return new Symbol(sym.MENOR); }
"mayor_o_igual"   { return new Symbol(sym.MAYOR_O_IGUAL); }
"menor_o_igual"   { return new Symbol(sym.MENOR_O_IGUAL); }
"es_igual"        { return new Symbol(sym.ES_IGUAL); }
"es_diferente"    { return new Symbol(sym.ES_DIFERENTE); }

/* Caracter */


/* whitespace */
{WhiteSpace}  { /* ignore */ }

/* Commentss */
{Comment} { System.out.println("Se reconocio el comentario");/*ignore*/}

}


.   {
        System.out.println("Error Lexico : " +yytext() + " Linea: " + (yyline + 1) + 
        " Columna: " + (yycolumn + 1));

    }


