/**

    Organizacion de lenguajes y compiladores 1 
    Segundo semestre 2022
    Universidad San Carlos de Guatemala

****/

//Seccion de declaraciones

int varible_1; // asignacion listo
double varible_2; // 
boolean varible_3;
char varible_4;
string varible_5; // Declaracion multiple
int varible_1, varible_11;
double varible_2, varible_22;
boolean varible_3, varible_33;
char varible_4, varible_44;
string varible_5, varible_55;
int var_1 = 12;
int tm1_,tmp2_,tmp3_,tmp4_ = 12+5;
double var_2 = 15.02;
double var_2_1 = 2022.00;
double var_2_2 = 0.10;
double var_2_3 = 1.0;
double var_2_4 = 51.1589462625459;
boolean var_3 = true;
boolean var_3_1 = false;
char var_4_1 = 'a';
char var_4_2 = '2';
char var_4_3 = 'W';
char var_4_4 = '@';
char var_4_5 = '!';
char var_4_6 = '%';
char var_4_7 = '/';
string var_5_1 = "Hola";
string var_5_2 = "Mundo";
string var_5_3 = "este es un mensaje @";
string var_5_4 = "Organizacion de lenguajes y compiladores
1";
string var_5_5 = "Compiladores\n1";
string var_5_6 = "Compiladores\\1\\";
string var_5_7 = "compiladores\"1\"";
string var_5_8 = "\tCompiladores 1";
string var_5_9 = "\'compiladores 1\'";

//Seccion de asignaciones

var_1= (1)+2-3+4-5+6-7+8-9;
var_1= (1+2+3+4)+(5+6+7+8+9);
var_1= -1+2*3+4*8/8%(5789);

var_3= 5+5-8+6*8+1/7%9>45+6;
var_3= 6+4-7+9*8*9/7%9<45+6;
var_3= (7+3)-8+6*8+6/7%9>=45+6;
var_3= 8+2-7+9*8-9/7%9<=45+6;

//Casteos
int v_5= (int)"hola";
string v_1= (string)12%8;
char v_3= (char)true;
char v_4= (char)'A';

division():string{
    string v_2= (string)12.25+1.20;
    string v_3= (string)true;
    string v_4= (string)'A';
    return "olc1";
    mivar= tolower("QWERT"+" ")+"1+5";
    mivar= toupper("QWERT"+" ")+"hola!";
    boolean v_2= (boolean)12.25;   
    string a_1=typeof(15);
    string a_2=typeof(15+6.5);
    string a_3=typeof('a');
    string a_4=typeof(true);
    string a_5=typeof("dsafdsa");
    string a_5=tostring("melmv");
    string a_5=tostring(15);
    string a_5=tostring(15.23+9.02);
    string a_5=tostring(true);
}

Multiplicacion(int numero1, int numero2):int{
    if(Universidad=="usac"){
        var_1= -1+2*3+4*8/8^(2);
        var_2=1.2+78.1+89.000;
        double  val1= round(5.800);
        val1= round(5.800+1.2+0.5);
        println("tricentenadira");
        if(Universidad=="usac"){
            println("tricentenadira");
            if(Universidad=="usac"){
                println("tricentenadira");
                if(Universidad=="usac"){
                    println("tricentenadira");
                    char v_1= (char)12;
                    char v_2= (char)12.25;
                }
            }
        }
    }
    //este es otro if pero con condicion logica
    if(anio==2022+22 || semestre=="Segundo"||4>2){
        println("Usac!!!!");
        boolean v_5= (boolean)"hola";
        if(var_1>= var_2){
            println("Usac!!!!");
            char v_5= (char)"hola";
        }   
    }else{
        var_1= 1+var_1++;
        println("sale en otro semestre :( ");
    }
     //otra condicion booleanda
    if( suma(1,2)==3 && 45+56==12){
        println("Esta bien");
        var_1--;
    }elif(suma(1,3)==4|| "Universidad"=="usac"){
        println("Esta es otra suma");
        boolean v_4= (boolean)'A';
        vector1.pop();
    }elif(suma(1,4)==4+1){
        edades.push(50-89*4);
        println("Esta es otra suma");
        lista.pop();
        switch(edad){
            case 18: 
                println("mayoria de eddad en guatemala");
                string v_5= (string)"hola"+" usac";
                break;
            case /*Este mensaje no tendria que dar error porque se omite desde el anlaisis lexico*/ 21:
                // Este es la mayoria de edad en otro pais
                println("mayoria de edad en us");
                int v_1= (int)12+1;
                break;
            default:
                //instrucciones si no se da a complir la conidcion
                var_3 = ("usac"=="usac")? 1:4+5;
                int var_23 = ("usac"=="usac")? 1:4+5;
                break;
        }
    }
    boolean v_1= (boolean)((12*8)+(5*8));
    string resultado=numero1*numero2;
    return resultado;
    return 4+5*8/9-18/1+1;
    edades.pop();
}

saludo(String nombre):void{
    do {
        do {
            var_3= "compi 1 "+" usac" != "compi "+"1";
            var_3 = (5+6>48)? 1+1:45;   
            do {
                while(edad<100){
                    --var_1;
                    println("Hola "+nombre);
                    println("Segundo semestre 2022");
                    ++var_1;
                    edad++;
                    //otra condicion booleanda
                    if( suma(1,2)==3 && 45+56==12){
                        println("Esta bien");
                        var_1--;
                    }elif(suma(1,3)==4|| "Universidad"=="usac"){
                        println("Esta es otra suma");
                        boolean v_4= (boolean)'A';
                    }elif(suma(1,4)>4+1){
                        println("Esta es otra suma");
                    }else{
                        var_1++;
                        articulos.pop();
                        boolean v_3= (boolean)true==true;
                    }
                }
                for (int x=0; x<45+8;x++){
                    var_3 = (5+6>48+9/8)? 1:4+5;
                    continue;
                    edades.push(1+50);
                    println("Hola mundo!!!");
                }
                for (x=0; x>=45+8;x+2){
                    int v_2= (int)12.25;
                    int v_3= (int)true;
                    int v_4= (int)'A';
                     for (x=0; x>=45+8;x+2){
                        int v_2= (int)12.25;
                        int v_3= (int)true;
                        int v_4= (int)'A';
                        continue;
                    }
                }
            } while(lenguaje=="Type"+"Script");
    } while(lenguaje=="Type"+"Script");
   } until(lenguaje=="Type"+"Script");
}
Multiplicacion(1+1,58/8);
var_3= "compi 1 "== "compi "+"1";
holamundo();
run main();