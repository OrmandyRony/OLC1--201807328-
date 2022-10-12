/* Analizador lexico */
package analizadores;
import java_cup.runtime.*;

/* Seccion de declaraciones*/
%%
%public
%class AnalizadorLexico
%ignorecase
%cup
%char
%line
%column
%unicode

/* Definiciones regulares o reglas de traduccion*/
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
Numero = {Digito}{Digito}* | {Digito}+(\.{Digito}+)
AscciMayusculas = (6[5-9]|[7-8][0-9]|90)
AscciMinusculas = (9[7-9]|1[0-1][0-9]|12[0-2])
AscciLetras = {AscciMayusculas} | {AscciMinusculas}
Caracter = ("'" [^] "'" | ("\'\${" {AscciLetras} "}\'")) // '${111}'
Cadena = "\"" [^\"]* "\"" 
Boolean = "verdadero" | "falso"
Asignacion = "->"

%%


<YYINITIAL> {Id}            {System.out.println("Se reconocio inicio"); return new Symbol(sym.NOMBRE); }

/* Keywords */
<YYINITIAL> "inicio"        { System.out.println("Se reconocio inicio"); return new Symbol(sym.INICIO); }
<YYINITIAL> "fin"           { System.out.println("Se reconocio fin"); return new Symbol(sym.FIN); }
<YYINITIAL> "ingresar"      { System.out.println("Se reconocio ingresar"); return new Symbol(sym.INGRESAR); }

<YYINITIAL> "como"          { System.out.println("Se reconocio como"); return new Symbol(sym.COMO); }
<YYINITIAL> "con_valor"     { System.out.println("Se reconocio con_valor"); return new Symbol(sym.CON_VALOR); }

<YYINITIAL> {Asignacion}    { System.out.println("Se reconocio con_valor"); return new Symbol(sym.ASIGNACION); }
<YYINITIAL> {Variable}      { System.out.println("Se reconocio variable"); return new Symbol(sym.VARIABLE); }

/* Metodo */
<YYINITIAL> {
    "metodo"            { System.out.println("Se reconocio metodo"); return new Symbol(sym.METODO);}
    "con_parametros"    { System.out.println("Se reconocio con_parametros"); return new Symbol(sym.CON_PARAMETROS);}
    "fin_metodo"        { System.out.println("Se reconocio fin_metodo"); return new Symbol(sym.FIN_METODO);}
}

/* Funciones */
<YYINITIAL> {
    "funcion"       { System.out.println("Se reconocio metodo"); return new Symbol(sym.FUNCION);}
    /* Nombre */
    /* Tipo_dato */
    /* Con parametros */
    "fin_funcion"   { System.out.println("Se reconocio metodo"); return new Symbol(sym.FIN_FUNCION);}
}

/* Ejecucion */
<YYINITIAL> "ejecutar"      { System.out.println("Se reconocio la ejecucion"); return new Symbol(sym.EJECUTAR); }


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
<YYINITIAL> ";"         { System.out.println("Se reconocio punto y coma"); return new Symbol(sym.PUNTO_COMA); }
<YYINITIAL> ","         { System.out.println("Se reconocio coma"); return new Symbol(sym.COMA); }

/* Operadores relacionales */
<YYINITIAL> {
    "mayor"           { return new Symbol(sym.MAYOR); }
    "menor"           { return new Symbol(sym.MENOR); }
    "mayor_o_igual"   { return new Symbol(sym.MAYOR_O_IGUAL); }
    "menor_o_igual"   { System.out.println("Se reconocio Menor o igual "); return new Symbol(sym.MENOR_O_IGUAL); }
    "es_igual"        { System.out.println("Se reconocio es igual"); return new Symbol(sym.ES_IGUAL); }
    "es_diferente"    { return new Symbol(sym.ES_DIFERENTE); }

    /* Caracter */


    /* whitespace */
    {WhiteSpace}  { /* ignore */ }

    /* Commentss */
    {Comment} { System.out.println("Se reconocio el comentario");/*ignore*/}

}

/* Operadores logicos */
<YYINITIAL> {
    "or"        {return new Symbol(sym.OR);}
    "and"       {return new Symbol(sym.AND);}
    "not"       {return new Symbol(sym.NOT);}
}


/* Condicionales */
<YYINITIAL> {
    /* Condicional Si */
    "si"                { System.out.println("Se reconocio el Si"); return new Symbol(sym.SI); }
    "fin_si"            { System.out.println("Se reconocio el FinSi"); return new Symbol(sym.FIN_SI); }
    "o_si"              { return new Symbol(sym.O_SI); }
    "entonces"          { return new Symbol(sym.ENTONCES); }
    "de_lo_contrario"   { return new Symbol(sym.DE_LO_CONTRARIO); }
    /* Seleccion Multiple */
    "segun"             { System.out.println("Se reconocio Segun"); return new Symbol(sym.SEGUN); }
    /* usada tambien en el ciclo para*/
    "hacer"             { System.out.println("Se reconocio Hacer"); return new Symbol(sym.HACER); }
    "\¿"                 { System.out.println("Se reconocio ¿"); return new Symbol(sym.INTERROGACION_ABRE); }
    "\?"                 { System.out.println("Se reconocio ?"); return new Symbol(sym.INTERROGACION_CIERRA); }
    "fin_segun"         { System.out.println("Se reconocio fin_segun"); return new Symbol(sym.FIN_SEGUN); }
}

/* Ciclos */
<YYINITIAL> {
    /* Para */
    "para"                { System.out.println("Se reconocio el Para"); return new Symbol(sym.PARA); }
    "hasta"               { System.out.println("Se reconocio hasta"); return new Symbol(sym.HASTA); }
    /* Hacer*/
    "con incremental"     { System.out.println("Se reconocio: con incremental"); return new Symbol(sym.CON_INCREMENTAL); }
    "fin_para"            { System.out.println("Se reconocio el fin para"); return new Symbol(sym.FIN_PARA); }

    /* Mientras*/
    "mientras"                { System.out.println("Se reconocio el mientras"); return new Symbol(sym.MIENTRAS); }
    "fin_mientras"            { System.out.println("Se reconocio el fin_mientras"); return new Symbol(sym.FIN_MIENTRAS); }

    /* Repetir hasta */
    "repetir"           { System.out.println("Se reconocio el repetir"); return new Symbol(sym.REPETIR); }
    "hasta_que"         { System.out.println("Se reconocio el hasta_que"); return new Symbol(sym.HASTA_QUE); }
}

/* Retorno */
<YYINITIAL> "retornar" { System.out.println("Se reconocio el repetir"); return new Symbol(sym.RETORNAR); }

/* Impresion */
<YYINITIAL> {
    /* Imprimir sin salto de linea */
    "imprimir"              { System.out.println("Se reconocio\"imprimir\""); return new Symbol(sym.IMPRIMIR); }
    /* Imprimir con salto de linea */
    "imprimir_nl"           { System.out.println("Se reconocio\"imprimir_nl\""); return new Symbol(sym.IMPRIMIR_NL); }
        
}

/* Simbolos aritmeticos*/
<YYINITIAL>{

    "-"           { return new Symbol(sym.RESTA); }
    "+"           { return new Symbol(sym.SUMA); }
    "/"           { return new Symbol(sym.DIVISION); }
    "*"           { return new Symbol(sym.MULTIPLICACION); }
"potencia"        { return new Symbol(sym.POTENCIA); }
    "mod"      { return new Symbol(sym.MODULO); }
    "("           { return new Symbol(sym.PARENTECIS_ABRE); }
    ")"           { return new Symbol(sym.PARENTECIS_CIERRA); }
    "["           { return new Symbol(sym.CORCHETE_ABRE); }
    "]"           { return new Symbol(sym.CORCHETE_CIERRA); }

}


.   {
        System.out.println("Error Lexico : " +yytext() + " Linea: " + (yyline + 1) + 
        " Columna: " + (yycolumn + 1));

    }


