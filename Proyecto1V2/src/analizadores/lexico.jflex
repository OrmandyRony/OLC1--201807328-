package analizadores;
import java_cup.runtime.Symbol; 
import java.util.ArrayList;

%%
%class Lexico
%public
%line
%char
%cup
%unicode
%column
%ignorecase

%{
    public ArrayList<ErrorLexico> ErroresLexicos; 
%}

%init{
    yyline = 1;
    ErroresLexicos = new ArrayList();
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
<YYINITIAL> "inicio"        { return new Symbol(sym.INICIO,yyline,yycolumn + 1, yytext()); }
<YYINITIAL> "fin"           { return new Symbol(sym.FIN, yyline, yycolumn + 1, yytext()); }
<YYINITIAL> "ingresar"      {return new Symbol(sym.INGRESAR, yyline, yycolumn + 1, yytext()); }

<YYINITIAL> "como"          {return new Symbol(sym.COMO, yyline, yycolumn + 1, yytext()); }
<YYINITIAL> "con_valor"     {return new Symbol(sym.CON_VALOR, yyline, yycolumn + 1, yytext()); }

<YYINITIAL> {Asignacion}    {return new Symbol(sym.ASIGNACION, yyline, yycolumn + 1, yytext()); }
<YYINITIAL> {Variable}      {return new Symbol(sym.VARIABLE, yyline, yycolumn + 1, yytext()); }

/* Metodo */
<YYINITIAL> {
    "metodo"            {return new Symbol(sym.METODO, yyline, yycolumn + 1, yytext());}
    "con_parametros"    {return new Symbol(sym.CON_PARAMETROS, yyline, yycolumn + 1, yytext());}
    "fin_metodo"        {return new Symbol(sym.FIN_METODO, yyline, yycolumn + 1, yytext());}
}

/* Funciones */
<YYINITIAL> {
    "funcion"       {return new Symbol(sym.FUNCION, yyline, yycolumn + 1, yytext());}
    /* Nombre */
    /* Tipo_dato */
    /* Con parametros */
    "fin_funcion"   {return new Symbol(sym.FIN_FUNCION, yyline, yycolumn + 1, yytext());}
}

/* Ejecucion */
<YYINITIAL> "ejecutar"      { return new Symbol(sym.EJECUTAR, yyline, yycolumn + 1, yytext()); }


/* Tipos de dato */
<YYINITIAL> { 
    "boolean"           { return new Symbol(sym.BOOLEAN, yyline, yycolumn + 1, yytext()); }
    "numero"            { return new Symbol(sym.NUMERO, yyline, yycolumn + 1, yytext()); }
    "caracter"          { return new Symbol(sym.CARACTER, yyline, yycolumn + 1, yytext()); }
    "cadena"            { return new Symbol(sym.CADENA, yyline, yycolumn + 1, yytext()); }
}

/* Literales */
<YYINITIAL> {Numero}    { return new Symbol(sym.LIT_NUMERO, yyline, yycolumn + 1, yytext()); }
<YYINITIAL> {Caracter}  { return new Symbol(sym.LIT_CARACTER, yyline, yycolumn + 1, yytext()); }
<YYINITIAL> {Cadena}    { return new Symbol(sym.LIT_CADENA, yyline, yycolumn + 1, yytext()); }
<YYINITIAL> {Boolean}   { return new Symbol(sym.LIT_BOOLEAN, yyline, yycolumn + 1, yytext()); }
<YYINITIAL> ";"         { return new Symbol(sym.PUNTO_COMA); }
<YYINITIAL> ","         { return new Symbol(sym.COMA, yyline, yycolumn + 1, yytext()); }

/* Operadores relacionales */
<YYINITIAL> "mayor"    { return new Symbol(sym.MAYOR, yyline, yycolumn + 1, yytext()); }

<YYINITIAL> {

    
    "menor"           { return new Symbol(sym.MENOR, yyline, yycolumn + 1, yytext()); }
    "mayor_o_igual"   { return new Symbol(sym.MAYOR_O_IGUAL, yyline, yycolumn + 1, yytext()); }
    "menor_o_igual"   { return new Symbol(sym.MENOR_O_IGUAL, yyline, yycolumn + 1, yytext()); }
    "es_igual"        { return new Symbol(sym.ES_IGUAL, yyline, yycolumn + 1, yytext()); }
    "es_diferente"    { return new Symbol(sym.ES_DIFERENTE, yyline, yycolumn + 1, yytext()); }

    /* Caracter */


    /* whitespace */
    {WhiteSpace}  { /* ignore */ }

    /* Commentss */
    {Comment} { /*ignore*/ }

}

/* Operadores logicos */
<YYINITIAL> {
    "or"        {return new Symbol(sym.OR, yyline, yycolumn + 1, yytext());}
    "and"       {return new Symbol(sym.AND, yyline, yycolumn + 1, yytext());}
    "not"       {return new Symbol(sym.NOT, yyline, yycolumn + 1, yytext());}
}

/* Condicionales */
<YYINITIAL> {
    /* Condicional Si */
    "si"                { return new Symbol(sym.SI, yyline, yycolumn + 1, yytext()); }
    "fin_si"            { return new Symbol(sym.FIN_SI, yyline, yycolumn + 1, yytext()); }
    "o_si"              { return new Symbol(sym.O_SI, yyline, yycolumn + 1, yytext()); }
    "entonces"          { return new Symbol(sym.ENTONCES, yyline, yycolumn + 1, yytext()); }
    "de_lo_contrario"   { return new Symbol(sym.DE_LO_CONTRARIO, yyline, yycolumn + 1, yytext()); }
    /* Seleccion Multiple */
    "segun"             { return new Symbol(sym.SEGUN, yyline, yycolumn + 1, yytext()); }
    /* usada tambien en el ciclo para*/
    "hacer"             { return new Symbol(sym.HACER, yyline, yycolumn + 1, yytext()); }
    "\¿"                { return new Symbol(sym.INTERROGACION_ABRE, yyline, yycolumn + 1, yytext()); }
    "\?"                { return new Symbol(sym.INTERROGACION_CIERRA, yyline, yycolumn + 1, yytext()); }
    "fin_segun"         { return new Symbol(sym.FIN_SEGUN, yyline, yycolumn + 1, yytext()); }
}

/* Ciclos */
<YYINITIAL> {
    /* Para */
    "para"                { return new Symbol(sym.PARA, yyline, yycolumn + 1, yytext()); }
    "hasta"               { return new Symbol(sym.HASTA, yyline, yycolumn + 1, yytext()); }
    /* Hacer*/
    "con incremental"     { return new Symbol(sym.CON_INCREMENTAL, yyline, yycolumn + 1, yytext()); }
    "fin_para"            { return new Symbol(sym.FIN_PARA, yyline, yycolumn + 1, yytext()); }

    /* Mientras*/
    "mientras"            { return new Symbol(sym.MIENTRAS, yyline, yycolumn + 1, yytext()); }
    "fin_mientras"        { return new Symbol(sym.FIN_MIENTRAS, yyline, yycolumn + 1, yytext()); }

    /* Repetir hasta */
    "repetir"           { return new Symbol(sym.REPETIR, yyline, yycolumn + 1, yytext()); }
    "hasta_que"         { return new Symbol(sym.HASTA_QUE, yyline, yycolumn + 1, yytext()); }
}

/* Retorno */
<YYINITIAL> "retornar" { return new Symbol(sym.RETORNAR, yyline, yycolumn + 1, yytext()); }

/* Impresion */
<YYINITIAL> {
    /* Imprimir sin salto de linea */
    "imprimir"              { return new Symbol(sym.IMPRIMIR, yyline, yycolumn + 1, yytext()); }
    /* Imprimir con salto de linea */
    "imprimir_nl"           { return new Symbol(sym.IMPRIMIR_NL, yyline, yycolumn + 1, yytext()); }
        
}

/* Simbolos aritmeticos*/
<YYINITIAL>{

    "-"           { return new Symbol(sym.RESTA, yyline, yycolumn + 1, yytext()); }
    "+"           { return new Symbol(sym.SUMA, yyline, yycolumn + 1, yytext()); }
    "/"           { return new Symbol(sym.DIVISION, yyline, yycolumn + 1, yytext()); }
    "*"           { return new Symbol(sym.MULTIPLICACION, yyline, yycolumn + 1, yytext()); }
"potencia"        { return new Symbol(sym.POTENCIA, yyline, yycolumn + 1, yytext()); }
    "mod"         { return new Symbol(sym.MODULO, yyline, yycolumn + 1, yytext()); }
    "("           {  return new Symbol(sym.PARENTECIS_ABRE, yyline, yycolumn + 1, yytext()); }
    ")"           { return new Symbol(sym.PARENTECIS_CIERRA, yyline, yycolumn + 1, yytext()); }
    "["           { return new Symbol(sym.CORCHETE_ABRE, yyline, yycolumn + 1, yytext()); }
    "]"           { return new Symbol(sym.CORCHETE_CIERRA, yyline, yycolumn + 1, yytext()); }

}


.   {
        ErroresLexicos.add(new ErrorLexico("Léxico", "Caracter no válido detectado: " + yytext(), yyline + "", (yycolumn + 1) + ""));
        
    }
