# Gramaticas (Analisis)

Assign: Anonymous
Date: September 10, 2022
Status: In progress

# Gramaticas Pseudocodigo

*iniciar → **INICIO*** *lista_instrucciones **FIN*** 
                 | **I*NICIO FIN***

*lista_instrucciones → lista_instrucciones instrucciones*
                                        | *instrucciones*

*instrucciones → declaracion*

| *declaracion1*
| *asignacion*
| *condicionales*
| *imprimir*
| *ciclos*

## Operaciones basicas

Reconoce suma, resta, multiplicacion, divicion,  potencia, modulo y parentesis:

*expresion_aritmetica → expresion_aritmetica **SUMA** expresion_aritmetica*
| *expresion_aritmetica **RESTA** expresion_aritmetica*
| *expresion_aritmetica **MULTIPLICACION** expresion_aritmetica*
| *expresion_aritmetica **DIVISION** expresion_aritmetica*

| *expresion_aritmetica **POTENCIA CORCHETE_ABRE** expresion_aritmetica CORCHETE_CIERRA*
| *expresion_aritmetica **MODULO** expresion_aritmetica*

| ***PARENTECIS_ABRE** expresion_aritmetica **PARENTECIS_CIERRA***
| ***LIT_NUMERO***

|**LIT_CADENA**

|**LIT_CARACTER**

|**VARIABLE**

## Operadores relacionales

operadoradores_relacionales →**MAYOR**
| **MENOR
| MAYOR_O_IGUAL
| MENOR_O_IGUAL
| ES_IGUAL
| ES_DIFERENTE**

expresion_comparacion → expresion_aritmetica operadores_relacionales expresion_aritmetica

## Operadores logicos

operadors_logicos → 

**OR**
| **AND**
| **NOT**

expresion_logica → expresion_comparacion operador_logico expresion_comparacion

considerar que la expresion logica puede venir varas veces

## Declaraciones de variables

### Declaracion multiple de variables

*declaracion1 →* ***INGRESAR*** *var tipo_valor* ***PUNTO_COMA***

*var → var **COMA VARIABLE***

 **| *VARIABLE***

*tipo_valor → **COMO CARACTER CON_VALOR LIT_CARACTER*
| *COMO CADENA CON_VALOR LIT_CADENA*
| *COMO BOOLEAN CON_VALOR LIT_BOOLEAN***

### Declaracion de variables con operaciones basicas

*declaracion →* ***INGRESAR*** *var   **COMO NUMERO CON_VALOR** expresion_aritmetica **PUNTO_COMA***

## Asignacion de variables

*asignacion*  → *var* **ASIGNACION** *expresion* **PUNTO_COMA**

*expresion → expresion_aritmetica*
                     | ***LIT_BOOLEAN***

## Condicionales

Condicional `si` y seleccion multiple

condicionales →SI expresion_booleana ENTONCES instrucciones FIN_SI

| SI expresion_booleana ENTONCES instrucciones DE_LO_CONTRARIO instrucciones FIN_SI
| SI expresion_booleana ENTONCES instrucciones osi DE_LO_CONTRARIO instrucciones FIN_SI
| SEGUN expresion_aritmetica HACER casos FIN_SEGUN

```
/* Considerar operadores logicos */
```

expresion_booleana → expresion_booleana operador_relacionales expresion_aritmetica
| expresion_aritmetica

*casos → casos **INTERROGACION_ABRE** expresion_aritmetica **INTERROGACION_CIERRA ENTONCES** instrucciones*
| ***INTERROGACION_ABRE** expresion_aritmetica **INTERROGACION_CIERRA ENTONCES** instrucciones*
| ***DE_LO_CONTRARIO ENTONCES** instrucciones*

*osi* → *osi **O_SI** expresion_booleana **ENTONCES** instrucciones*
| ***O_SI** expresion_booleana **ENTONCES** instrucciones*

## Ciclos

Contiene la gramatica de los ciclos *para, mientras y repetir:*

*ciclos* → ***PARA VARIABLE ASIGNACION** expresion_aritmetica **HASTA** expresion_aritmetica **HACER** intrucciones **FIN_PARA***
| ***PARA VARIABLE ASIGNACION** expresion_aritmetica **HASTA** expresion_aritmetica **HACER**  **FIN_PARA***

|***PARA VARIABLE ASIGNACION** expresion_aritmetica **HASTA** expresion_aritmetica **CON_INCREMENTAL** expresion_aritmetica  **HACER**  intrucciones **FIN_PARA***

| ***MIENTRAS** expresion_booleana **HACER** instrucciones **FIN_MIENTRAS***
| ***MIENTRAS** expresion_booleana **HACER** **FIN_MIENTRAS***
| ***REPETIR** instrucciones **HASTA_QUE** expresion_booleana*
| ***REPETIR** **HASTA_QUE** expresion_booleana*

## Retorno

retorno → RETORNAR  expresion_aritmetica

|expresion_booleana

## Metodo

metodo → **METODO NOMBRE** instrucciones **FIN_METODO**
| **METODO NOMBRE CON_PARAMETROS** instrucciones **FIN_METODO**

## Funciones

funciones → **FUNCION NOMBRE** tipo_dato instrucciones **FIN_FUNCION**
| **FUNCION NOMBRE** tipo_dato **CON_PARAMETROS** instrucciones **FIN_FUNCION**

tipo_dato → **BOOLEAN**
| **NUMERO**
| **CARACTER**
| **CADENA**

## LLamada de funciones y metodos

ejecutar → **EJECUTAR NOMBRE PARENTECIS_ABRE PARENTECIS_CIERRA PUNTO_COMA**

## Impresion

imprimir → **IMPRIMIR** literal_booleana **PUNTO_COMA**
| **IMPRIMIR_NL** literal_booleana **PUNTO_COMA**