# Pseudo-Parser
## Tabla de contenido
* [Abstract](#abstract)
* [Compilador](#compilador)
    * [Estructura de un compilador](#estructura-de-un-compilador)
        * [Análisis](#análisis)
* 

* [Referencias](#referencias)


## Abstract
Este proyecto es un traductor de pseudocodigo a los lenguajes Python y Golang, utilizando como fundamentos las dos primeras fases del compilador el proyecto se realizo en el lenguaje Java con las herramientas JFlex y Cup. 

**Palabras clave:**  *Python, Golang, Java, JFlex y Cup*

----

## Compilador
Un compilador es un programa que puede leer un lenguaje (el lenguaje fuente) y traducilo en un programa equivalente  en otro lenguaje (lenguaje destino).

### Estructura de un compilador
El compilador los podemos dividir en dos procesos el de analisis y el de sintesis, sin embargo para este  proyecto solo nos enfocaremos en el proceso de analisis.

#### Análisis
Divide el programa fuente en componentes e impone una estructura gramaticas sobre ellas. De este proceso podemos obtener tres fases: analisis léxico, sintáctico y semántico.

Para este proyecto solo haremos uso del analisi lexico y sintactico.

**Análisis Léxico:**
El analizador léxico reconoce el flujo de caracteres que componene el programa fuente y los agrupa en secuencias significativadas, conocidas como *lexemas*.

Para esta fase se usara la herramienta [JFlex](https://www.jflex.de/).

**Análisis Sintáctico:**
El parser (analizador sintáctico) utiliza los primeros componentes de los tokens producidos por el analizador de léxico para crear una representación intermedia en forma de árbol que describa la estructura gramatical del flujo de tokens.

Para esta fase se usara la herramienta [CUP](http://www2.cs.tum.edu/projects/cup/).

## Sintaxis Pseudo-Parser

### Conjunto de caracteres
El conjunto basico de caracteres fuente de Pseudo-Parser incluye los caracteres:

- Letras minusculas y mayusculas del alfabeto latino basico: ```a-aA-Z```
- Cifras decimales: ```0-9```
- Caracteres graficos: ```! " # % & ' ( ) * + , - . / : ; < = > ? [ \ ] ^ _ { | } ~```

### Palabras Reservadas
- inicio
- fin
- si
- o_si
- de_lo_contrario
- fin_si
- segun
- de_lo_contrario
- para
- fin_para
- hasta
- hacer
- mientras
- fin_mientras
- repetir
- hasta_que
- retornar
- metodo
- fin_metodo
- funcion
- fin_funcion
- ejecutar
- imprimir
- mod

### Operadores

- aritmética: ```+, -, *, /,%```
- asignación: ```=```
- lógica booleana : ```!, &&,||```
- prueba de igualdad:``` ==,!=```
- funciones de llamada: ```( )```
- incremento y decremento : ++,--
selección de miembros : .,->
- relaciones de orden : ```<, <=, >,>=```
- secuenciación:,
agrupación de subexpresiones :( )

### Tipos de datos

#### Carácter
Un carácter dentro de una comilla simple. Es posible ingresar el código ascii (únicamente se usarán los ascii de caracteres del alfabeto)

```C
'o'
'L'
'${70}'='F'
```

#### Número
1. Conjunto de dígitos que tienen una única vez el carácter punto dentro del conjunto de caracteres.
2. Conjunto de solo dígitos.
```C
10.02
11.1
56.0
105.152
4568
5
94
```

#### Cadena
Conjunto de caracteres dentro de comillas dobles
```C
“Esta es una cadena”

“hola mundo”

“organización de
lenguajes y compiladores
1” 
```

#### Boolean
Tipo de dato verdadero o falso.

```Python
Verdadero
Falso

```

<span style="color:orange">orange</span>  
<span style="color:lime">lime</span>  
<font color='red'>rojo</font>

## Referencias
<dl compact="compact">
<dt><a name="dragonbook">[1]</a> 
</dt><dd>A. Aho, R. Sethi, and J. Ullman, 
<i>Compilers: Principles, Techniques, and Tools</i>, 
Addison-Wesley Publishing,
Reading, MA, 
1986.
</dl>