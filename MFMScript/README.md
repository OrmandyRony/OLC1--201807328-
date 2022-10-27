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
### Comandos
```Bash
npm init -y # Inicializar el proyecto
npm i --save-dev typescript ts-node nodemon # instalacion dependencias de desarrollo, y creacion de carpeta node modules
npx tsc --init # iniciar el proyecto de typescript crea el archivo de configuracion de las reglas que vamos usar en ts
npm i --save express dotenv morgan cors body-parser config lodash #jison // dependencias glbales morgan para verificar el trafico
npm i --save-dev @types/express @types/cors @types/morgan @types/node @types/config @types/lodash # copy rimraf // para usar los tipos de cada una de las dependencias

```

## Diagramas
[Diagrama de clases](https://lucid.app/documents/view/819f7438-04b5-4b21-8f68-741c820ca911)

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


## Recuperacion de errores
se opto por el punto coma 

## Referencias
<dl compact="compact">
<dt>
<a name="dragonbook">[1]</a> 
</dt>
<dd>
A. Aho, R. Sethi, and J. Ullman, 
<i>Compilers: Principles, Techniques, and Tools</i>, 
Addison-Wesley Publishing,
Reading, MA, 
1986.
</dd>
</dl>

<dl compact="compact">
    <dt>
        <a name="manualcup" href="http://www2.cs.tum.edu/projects/cup/docs.php#intro">[2]</a> 
    </dt>
    <dd>
    <i> CUP User's Manual<i>
Michael Petter, Technische Universität München
Scott E. Hudson
Graphics Visualization and Usability Center
Georgia Institute of Technology
    </dd>
</dl>

<dl compact="compact">
    <dt>
        <a name="proyecto 2">[4]</a> 
    </dt>
    <dd>
    <i>Proyecto 1,<i>
Universidad San Carlos de Guatemala
Facultad de Ingeniería
Escuela de Ciencias y Sistemas
Organización de Lenguajes y Compiladores 1
    </dd>
</dl>
