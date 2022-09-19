package analizadores;
import java_cup.runtime.Symbol; 

%%
%class Lexico
%public
%line
%char
%cup
%unicode
%column
%ignorecase

%init{
    yyline = 1;
    yychar = 1;
%init}

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
AscciMayusculas = (6[5-9]|[7-8][0-9]|90)
AscciMinusculas = (9[7-9]|1[0-1][0-9]|12[0-2])
AscciLetras = {AscciMayusculas} | {AscciMinusculas}
Caracter = ("'" [^] "'" | ("\'\${" {AscciLetras} "}\'")) // '${111}'
Cadena = "\"" [^\"]* "\"" 
Boolean = "verdadero" | "falso"
Asignacion = "->"

%%


/* Keywords */
<YYINITIAL> "inicio"        { return new Symbol(sym.INICIO,yyline,yychar, yytext()); }
<YYINITIAL> "fin"           { return new Symbol(sym.FIN, yyline, yychar, yytext()); }
<YYINITIAL> "ingresar"      {return new Symbol(sym.INGRESAR, yyline, yychar, yytext()); }

<YYINITIAL> "como"          {return new Symbol(sym.COMO, yyline, yychar, yytext()); }
<YYINITIAL> "con_valor"     {return new Symbol(sym.CON_VALOR, yyline, yychar, yytext()); }

<YYINITIAL> {Asignacion}    {return new Symbol(sym.ASIGNACION, yyline, yychar, yytext()); }
<YYINITIAL> {Variable}      {return new Symbol(sym.VARIABLE, yyline, yychar, yytext()); }

/* Metodo */
<YYINITIAL> {
    "metodo"            {return new Symbol(sym.METODO, yyline, yychar, yytext());}
    "con_parametros"    {return new Symbol(sym.CON_PARAMETROS, yyline, yychar, yytext());}
    "fin_metodo"        {return new Symbol(sym.FIN_METODO, yyline, yychar, yytext());}
}

/* Funciones */
<YYINITIAL> {
    "funcion"       {return new Symbol(sym.FUNCION, yyline, yychar, yytext());}
    /* Nombre */
    /* Tipo_dato */
    /* Con parametros */
    "fin_funcion"   {return new Symbol(sym.FIN_FUNCION, yyline, yychar, yytext());}
}

/* Ejecucion */
<YYINITIAL> "ejecutar"      { return new Symbol(sym.EJECUTAR, yyline, yychar, yytext()); }


/* Tipos de dato */
<YYINITIAL> { 
    "boolean"           { return new Symbol(sym.BOOLEAN, yyline, yychar, yytext()); }
    "numero"            { return new Symbol(sym.NUMERO, yyline, yychar, yytext()); }
    "caracter"          { return new Symbol(sym.CARACTER, yyline, yychar, yytext()); }
    "cadena"            { return new Symbol(sym.CADENA, yyline, yychar, yytext()); }
}

/* Literales */
<YYINITIAL> {Numero}    { return new Symbol(sym.LIT_NUMERO, yyline, yychar, yytext()); }
<YYINITIAL> {Caracter}  { return new Symbol(sym.LIT_CARACTER, yyline, yychar, yytext()); }
<YYINITIAL> {Cadena}    { return new Symbol(sym.LIT_CADENA, yyline, yychar, yytext()); }
<YYINITIAL> {Boolean}   { return new Symbol(sym.LIT_BOOLEAN, yyline, yychar, yytext()); }
<YYINITIAL> ";"         { return new Symbol(sym.PUNTO_COMA); }
<YYINITIAL> ","         { return new Symbol(sym.COMA, yyline, yychar, yytext()); }

/* Operadores relacionales */
<YYINITIAL> "mayor"    { return new Symbol(sym.MAYOR, yyline, yychar, yytext()); }

<YYINITIAL> {

    
    "menor"           { return new Symbol(sym.MENOR, yyline, yychar, yytext()); }
    "mayor_o_igual"   { return new Symbol(sym.MAYOR_O_IGUAL, yyline, yychar, yytext()); }
    "menor_o_igual"   { return new Symbol(sym.MENOR_O_IGUAL, yyline, yychar, yytext()); }
    "es_igual"        { return new Symbol(sym.ES_IGUAL, yyline, yychar, yytext()); }
    "es_diferente"    { return new Symbol(sym.ES_DIFERENTE, yyline, yychar, yytext()); }

    /* Caracter */


    /* whitespace */
    {WhiteSpace}  { /* ignore */ }

    /* Commentss */
    {Comment} { /*ignore*/ }

}

/* Operadores logicos */
<YYINITIAL> {
    "or"        {return new Symbol(sym.OR, yyline, yychar, yytext());}
    "and"       {return new Symbol(sym.AND, yyline, yychar, yytext());}
    "not"       {return new Symbol(sym.NOT, yyline, yychar, yytext());}
}


/* Condicionales */
<YYINITIAL> {
    /* Condicional Si */
    "si"                { return new Symbol(sym.SI, yyline, yychar, yytext()); }
    "fin_si"            { return new Symbol(sym.FIN_SI, yyline, yychar, yytext()); }
    "o_si"              { return new Symbol(sym.O_SI, yyline, yychar, yytext()); }
    "entonces"          { return new Symbol(sym.ENTONCES, yyline, yychar, yytext()); }
    "de_lo_contrario"   { return new Symbol(sym.DE_LO_CONTRARIO, yyline, yychar, yytext()); }
    /* Seleccion Multiple */
    "segun"             { return new Symbol(sym.SEGUN, yyline, yychar, yytext()); }
    /* usada tambien en el ciclo para*/
    "hacer"             { return new Symbol(sym.HACER, yyline, yychar, yytext()); }
    "\¿"                { return new Symbol(sym.INTERROGACION_ABRE, yyline, yychar, yytext()); }
    "\?"                { return new Symbol(sym.INTERROGACION_CIERRA, yyline, yychar, yytext()); }
    "fin_segun"         { return new Symbol(sym.FIN_SEGUN, yyline, yychar, yytext()); }
}

/* Ciclos */
<YYINITIAL> {
    /* Para */
    "para"                { return new Symbol(sym.PARA, yyline, yychar, yytext()); }
    "hasta"               { return new Symbol(sym.HASTA, yyline, yychar, yytext()); }
    /* Hacer*/
    "con incremental"     { return new Symbol(sym.CON_INCREMENTAL, yyline, yychar, yytext()); }
    "fin_para"            { return new Symbol(sym.FIN_PARA, yyline, yychar, yytext()); }

    /* Mientras*/
    "mientras"            { return new Symbol(sym.MIENTRAS, yyline, yychar, yytext()); }
    "fin_mientras"        { return new Symbol(sym.FIN_MIENTRAS, yyline, yychar, yytext()); }

    /* Repetir hasta */
    "repetir"           { return new Symbol(sym.REPETIR, yyline, yychar, yytext()); }
    "hasta_que"         { return new Symbol(sym.HASTA_QUE, yyline, yychar, yytext()); }
}

/* Retorno */
<YYINITIAL> "retornar" { return new Symbol(sym.RETORNAR, yyline, yychar, yytext()); }

/* Impresion */
<YYINITIAL> {
    /* Imprimir sin salto de linea */
    "imprimir"              { return new Symbol(sym.IMPRIMIR, yyline, yychar, yytext()); }
    /* Imprimir con salto de linea */
    "imprimir_nl"           { return new Symbol(sym.IMPRIMIR_NL, yyline, yychar, yytext()); }
        
}

/* Simbolos aritmeticos*/
<YYINITIAL>{

    "-"           { return new Symbol(sym.RESTA, yyline, yychar, yytext()); }
    "+"           { return new Symbol(sym.SUMA, yyline, yychar, yytext()); }
    "/"           { return new Symbol(sym.DIVISION, yyline, yychar, yytext()); }
    "*"           { return new Symbol(sym.MULTIPLICACION, yyline, yychar, yytext()); }
"potencia"        { return new Symbol(sym.POTENCIA, yyline, yychar, yytext()); }
    "mod"         { return new Symbol(sym.MODULO, yyline, yychar, yytext()); }
    "("           {  return new Symbol(sym.PARENTECIS_ABRE, yyline, yychar, yytext()); }
    ")"           { return new Symbol(sym.PARENTECIS_CIERRA, yyline, yychar, yytext()); }
    "["           { return new Symbol(sym.CORCHETE_ABRE, yyline, yychar, yytext()); }
    "]"           { return new Symbol(sym.CORCHETE_CIERRA, yyline, yychar, yytext()); }

}


.   {
        System.out.println("Error Lexico : " +yytext() + " Linea: " + yyline + 
        " Columna: " + yycolumn);

    }
