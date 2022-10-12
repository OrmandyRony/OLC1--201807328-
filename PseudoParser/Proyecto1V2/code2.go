package main

import (
	"fmt"
	"math"
)
func _potenciaManual_(_base_float64, _exponente_float64 ){
	var _i_ float64 = 0
	var _acumulado_ float64 = 0
	for _i_ := 0; _i_  < _exponente_-1; _i_++ {
	_acumulado_ = _acumulado_+_acumulado_
}
	fmt.Println(" Esta es la potencia Manual")
	fmt.Print(_acumulado_)
	fmt.Println("")

}

func _potenciaFuncion_(_base_float64, _exponente_float64 ) float64 {
	var _potencia_ float64 = _base_**_exponente_
	fmt.Println(" Esta es la potencia Manual pero con una funcion")
	fmt.Print(_potencia_)
	return _potencia_
}

func _metodo_1_(){
	fmt.Println("estamos entrando al metodo 1")
	_potenciaManual_(3*1+4/2, 3+2 )
	fmt.Println(" Esta es la potencia Funcion")
	fmt.Println("FIN del metodo1")

}

func main() {
	var _variable1_ float64 = 5
	var _variable2_ float64 = 50
	var _v1_  = "esta es una cadena"
	var _v2_  = "esta es una cadena"
	var _v3_  = "esta es una cadena"
	var _curso1_  = "olc"
	var _curso2_  = "olc"
	var _curso3_  = "olc"
	var _pi1_ float64 = 3
	var _pi2_ float64 = 3.1
	var _pi3_ float64 = 3.14
	var _pi4_ float64 = 3.141
	var _anio1_ float64 = 1
	var _anio2_ float64 = 9
	var _anio3_ float64 = 4
	var _anio4_ float64 = 5
	var _variableAntesNeg_ float64 = 5.0
	var _encabezado1_  = "Universidad San Carlos de Guatemala...;"
	var _encabezado2_  = "Escuela de Ciencias y Sistemas\nSegundo semestre\n"
	var _flag1_ bool = True
	var _flag2_ bool = False
	var _name1_  = 'f'
	var _name2_  = 'e'
	var _name3_  = 'r'
	var _name4_  = 'n'
	var _name6_  = 'n'
	var _name5_  = 'a'
	var _name7_  = 'd'
	var _name8_  = 'o'
	var _operaciones1Basica_ float64 = 1+(1)
	var _operaciones1Basica2_ float64 = _operaciones1Basica_+_operaciones1Basica_
	var _operaciones1Intermedia_ float64 = 15+(9*8)+200/8*3+9
	var _operaciones1Avanzadas1_ float64 = ((15+9)*8+200/8*3+9)
	var _operaciones1Avanzadas2_ float64 = (1**1+2)**22.2-2.2-15+(2)
	var _operaciones1Avanzadas3_ float64 = (30**2)+(2)
	var _operaciones1Avanzadas4_ float64 = (30**10-8+9-4*2-1)+(2)
	var _operaciones1Avanzadas5_ float64 = 30**10-8+9-4*2-1+(15/(1**1+2))
	var _operaciones1Avanzadas6_ float64 = (5*8) % (1+5+6)
	var _operaciones1Avanzadas7_ float64 = (5*8) % ((5+3)**8)
	var _operaciones1Avanzadas8_ float64 = (5*8) % ((5+(2**2*2))**8)
	var _operacionRela1_ float64 = "mas de 60 Plox"
	var _operacionRela3_ bool = _operaciones1Basica_ > 8
	var _operacionRela31_ bool = (_operaciones1Basica_+6) >= 8
	var _operacionRela32_ bool = (_operaciones1Basica_+6) <= 8
	var _operacionRela4_ bool = _operaciones1Basica_ == 8
	var _operacionRela33_ bool = (_operaciones1Basica_+6) < 8
	var _operacionRela5_ bool = _operaciones1Basica_ == _operaciones1Basica_
	var _operacionRela6_ bool = _operaciones1Basica_ == _operaciones1Basica_+1
	var _operacionRela7_ bool = _operaciones1Basica_ == (_operaciones1Basica_)*(8+5)
	var _operacionRela51_ bool = _operaciones1Basica_ !=_operaciones1Basica_
	_v1_ = "esta es la cadena numero 1"
	_v2_ = "estas cadenas deben ser diferentes"
	_v3_ = "estas cadenas deben ser diferentes"
	_curso1_ = "Organizacion de lenguajes y compiladores 1"
	_curso2_ = "Organizacion de lenguajes y compiladores 1"
	_curso3_ = "Organizacion de lenguajes y compiladores 1"
	fmt.Print(_operaciones1Basica_)
	fmt.Println("")
	fmt.Print(_operaciones1Basica2_)
	fmt.Println("")
	fmt.Print(_operaciones1Intermedia_)
	fmt.Println("")
	fmt.Print(_operaciones1Avanzadas1_)
	fmt.Println("")
	fmt.Print(_operaciones1Avanzadas2_)
	fmt.Println("")
	fmt.Print(_operaciones1Avanzadas3_)
	fmt.Println("")
	fmt.Print(_operaciones1Avanzadas4_)
	fmt.Println("")
	fmt.Print(_operaciones1Avanzadas5_)
	fmt.Println("")
	fmt.Print(_operaciones1Avanzadas6_)
	fmt.Println("")
	fmt.Print(_operaciones1Avanzadas7_)
	fmt.Println("")
	fmt.Print(_operaciones1Avanzadas8_)
	fmt.Println("")
	fmt.Print(_operacionRela1_)
	fmt.Println("")
	fmt.Print(_operacionRela3_)
	fmt.Println("")
	fmt.Print(_operacionRela3_)
	fmt.Println("")
	fmt.Print(_operacionRela3_)
	fmt.Println("")
	fmt.Print(_operacionRela4_)
	fmt.Println("")
	fmt.Print(_operacionRela31_)
	fmt.Println("")
	fmt.Print(_operacionRela5_)
	fmt.Println("")
	fmt.Print(_operacionRela6_)
	fmt.Println("")
	fmt.Print(_operacionRela7_)
	fmt.Println("")
	fmt.Print(_operacionRela5_)
	fmt.Println("")
	fmt.Print(_encabezado1_)
	fmt.Print(_encabezado2_)
	fmt.Print("...")
	fmt.Print(_anio1_)
	fmt.Print(_anio2_)
	fmt.Print(_anio3_)
	fmt.Print(_anio4_)
	fmt.Println(".")
	fmt.Println((_v3_))
	fmt.Print(_name1_)
	fmt.Print(_name2_)
	fmt.Print(_name3_)
	fmt.Print(_name4_)
	fmt.Print(_name5_)
	fmt.Print(_name6_)
	fmt.Print(_name7_)
	fmt.Print(_name8_)
	fmt.Print(".")
	fmt.Print(_variable1_)
	fmt.Println("")
	fmt.Print(_variable2_)
	fmt.Println("")
	fmt.Print(_v1_)
	fmt.Println("")
	fmt.Print(_v2_)
	fmt.Println("")
	fmt.Print(_v3_)
	fmt.Println("")
	fmt.Print(_curso1_)
	fmt.Println("")
	fmt.Print(_curso2_)
	fmt.Println("")
	fmt.Print(_curso3_)
	fmt.Println("")
	fmt.Print(_pi1_)
	fmt.Println("")
	fmt.Print(_pi2_)
	fmt.Println("")
	fmt.Print(_pi3_)
	fmt.Println("")
	fmt.Print(_pi4_)
	fmt.Println("")
	fmt.Print(_anio1_)
	fmt.Println("")
	fmt.Print(_anio2_)
	fmt.Println("")
	fmt.Print(_anio3_)
	fmt.Println("")
	fmt.Print(_anio4_)
	fmt.Println("")
	fmt.Print(_variableAntesNeg_)
	fmt.Println("")
	fmt.Print(_flag1_)
	fmt.Println("")
	fmt.Print(_flag2_)
	fmt.Println("")
	if (True == True){
		fmt.Println("El if esta correcto")
	}else{ 
					fmt.Println("no tiene que imprimir este mensaje, error en instruccion if")
	}
	if (_v1_ == _v2_){
		fmt.Println("Al parecer no funciona la asignacion, restame puntos en el if")
		for true {
	if(_variable1_ >= 5*5+8/2){
	break
	}
		fmt.Print(_variable1_)
		_variable1_ = _variable1_+1
	}
	}
	if (_v1_ == _v2_){
		fmt.Println("no tiene que imprimir este mensaje, error en instruccion if")
	}else{ 
						fmt.Print("INTRUCCION IF con Else esta correcta")
	}
	if (_v1_ == _v2_){
		fmt.Println("no tiene que imprimir este mensaje,error en l aintruccion if")
	}	elif( _v1_ == 13){
		fmt.Println("no tiene que imprimir este mensaje,error en l aintruccion if")
	}
		elif( _v1_ == 14){
		fmt.Println("no tiene que imprimir este mensaje,error en l aintruccion if")
	}
	}else{ 
							fmt.Println("Instruccion if con else if esta correcta")
	}
	var _varB_ bool = False
	var _varaux_ float64 = 2
	if (_varB_){
		fmt.Println("Estas definiendo mal los valores")
		var _varaux_ float64 = _variable1_ % 2
		switch  _varaux_{
	case 0:
	fmt.Println("el valor es mayor a 0 y menos a 2")
	
	
	case 2:
	fmt.Println("el valor es mayor a 2")
	
	
	
	
	}
	_metodo_1_()
	fmt.Print("El fibonacci de 5 es ")
	fmt.Println(".")
	
}