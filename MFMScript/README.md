[comment]: # (Documentacion tecnica del proyecto 2 de Organizacion de Lenguajes y Compiladores)
# MFMScript
## Tabla de contenido

## Abstract
MFMScript es un lenguaje de programacion de alto nivel y case insensitive, creado para las personas que se inician en el arte de la programacion.


Para facilitar el acceso a este lenguaje se usa herramientas de desarrollo web por el lado del frontend se usa el framework Angular y por el lado del backend se usa NodeJs.

Para el analisis del lenguaje MFMScript se utiliza la herramienta Jison.

**Palabras clave:**  *lenguaje de programacion de alto nivel, case insensitive, JavaScript, Angular, NodeJs y Jison*

## Herramientas requeridas
- Jison: Generador de analizadores léxicos y sintácticos.
- Nodejs: Es un entorno en tiempo de ejecución, multiplataforma, capaz de ejecutar javascript fuera de un explorador.
- Ubuntu 22.04 o Windows 10 o superior: Sistema operativo.
- Visual Studio Code: Es un editor de código ligero pero poderoso. Viene con soporte integrado para JavaScript, Nodejs, entre otros.

## Empezando
### Clone este repositorio

```Bash
git clone https://github.com/OrmandyRony/OLC1--201807328-.git

```

## Compilador
Un compilador es un programa que puede leer un lenguaje (el lenguaje fuente) y traducilo en un programa equivalente  en otro lenguaje (lenguaje destino).

## Análisis
Divide el programa fuente en componentes e impone una estructura gramaticas sobre ellas. De este proceso podemos obtener tres fases: analisis léxico, sintáctico y semántico.

**Análisis Léxico:**
El analizador léxico reconoce el flujo de caracteres que componene el programa fuente y los agrupa en secuencias significativadas, conocidas como *lexemas*.


**Análisis Sintáctico:**
El parser (analizador sintáctico) utiliza los primeros componentes de los tokens producidos por el analizador de léxico para crear una representación intermedia en forma de árbol que describa la estructura gramatical del flujo de tokens.

## Sintaxis MFMScript

### Conjunto de caracteres
El conjunto basico de caracteres fuente de Pseudo-Parser incluye los caracteres:

- Letras minusculas y mayusculas del alfabeto latino basico: ```a-aA-Z```
- Cifras decimales: ```0-9```
- Caracteres graficos: ```! " # % & ' ( ) * + , - . / : ; < = > ? [ \ ] ^ _ { | } ~```

### Comentarios
Los comentarios son una forma elegante de indicar que función tiene cierta sección del código que se ha escrito simplemente para dejar algún mensaje en específico. El lenguaje soporta dos tipos de comentarios que son los siguientes:

#### Comentarios de una línea
Estos comentarios deberán comenzar con ```//``` y terminar con un salto de línea.
#### Comentarios de una línea
Estos comentarios deberán comenzar con ``/*`` y terminar con ``*/``.

**Ejemplo**
``` C
// Este es un comentario de una línea
/*
Este es un comentario Multilínea
Para este lenguaje
*/
```

### Operadores
