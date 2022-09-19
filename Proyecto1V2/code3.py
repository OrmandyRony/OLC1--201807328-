_variable1_ = 5
_variable2_ = 50
_v1_ = "esta es una cadena"
_v2_ = "esta es una cadena"
_v3_ = "esta es una cadena"
_curso1_ = "olc"
_curso2_ = "olc"
_curso3_ = "olc"
_pi1_ = 3
_pi2_ = 3.1
_pi3_ = 3.14
_pi4_ = 3.141
_anio1_ = 1
_anio2_ = 9
_anio3_ = 4
_anio4_ = 5
_variableNeg_ = 54.0
_encabezado1_ = "Universidad San Carlos de Guatemala...;"
_encabezado2_ = "Escuela de Ciencias y Sistemas\nSegundo semestre\n"
_flag1_ = verdadero
_flag2_ = falso
_name1_ = 'f'
_name2_ = 'e'
_name3_ = 'r'
_name4_ = 'n'
_name6_ = 'n'
_name5_ = 'a'
_name7_ = '${100}'
_name8_ = '${111}'
_operaciones1Basica_ = 1+1
_operaciones1Basica2_ = _operaciones1Basica_+_operaciones1Basica_
_operaciones1Intermedia_ = 15+9*8+200/8*3+9
_operaciones1Avanzadas1_ = 15+9*8+200/8*3+9
_operaciones1Avanzadas2_ = 30**22.2-2.2+2
_operaciones1Avanzadas3_ = 30**2+2
_operaciones1Avanzadas4_ = 30**10-8+9-4*2-1+2
_operaciones1Avanzadas6_ = 5*8 % 1+5+6
_operacionRela1_ = 5+5 > 5
_operacionRela3_ = _operaciones1Basica_ > 8
_operacionRela3_ = _operaciones1Basica_+6 >= 8
_operacionRela3_ = _operaciones1Basica_+6 <= 8
_operacionRela4_ = _operaciones1Basica_ == 8
_operacionRela5_ = _operaciones1Basica_ == _operaciones1Basica_
_operacionRela6_ = _operaciones1Basica_ == _operaciones1Basica_+1
_operacionRela7_ = _operaciones1Basica_ == _operaciones1Basica_*8+5
_operacionRela5_ = _operaciones1Basica_ !=_operaciones1Basica_
_operLogica_ = 'c'
_v1_ = "esta es la cadena numero 1"
_v2_ = "estas cadenas deben ser diferentes"
_v3_ = "estas cadenas deben ser diferentes"
_curso1_ = "Organizacion de lenguajes y compiladores 1"
_curso2_ = "Organizacion de lenguajes y compiladores 1"
_curso3_ = "Organizacion de lenguajes y compiladores 1"
_curso1_ = "Organizacion de lenguajes y compiladores 1"
_curso2_ = "Organizacion de lenguajes y compiladores 1"
_curso3_ = "Organizacion de lenguajes y compiladores 1"
print(_encabezado1_+"\n")
print(_encabezado2_+"\n")
print("...")
print(_anio1_)
print(_anio2_)
print(_anio3_)
print(_anio4_)
print("."+"\n")
print(_v3_+"\n")
if _v1_ == _v2_:
	print("Al parecer no funciona la asignacion"+"\n")
	while (_variable1_ >= 5*5+8/2):
	print(_variable1_)
	_variable1_ = _variable1_+1


if _v1_ == _v2_:
	print("no tiene que imprimir este mensaje"+"\n")
else: 
				print("este print es un ejemplo")

if _v1_ == _v2_:
	print("no tiene que imprimir este mensaje"+"\n")
elif _v1_ == _v2_:
	if _v1_ == 13:
	print("mensaje de prueba"+"\n")

	if _v1_ == 14:
	print("mensaje de prueba"+"\n")

else: 
					print("este print es un ejemplo"+"\n")

_varB_ = falso
if _varB_:
	print("Estas definiendo bien los valores"+"\n")
	_varaux_ = _variable1_ % 2
	if _varaux_:
	elif 0 == 0:
	print("el valor es mayor a 0 y menos a 2"+"\n")

	elif 2 == 0:
	print("el valor es mayor a 2"+"\n")

else: 
						print("nose"+"\n")


def _potenciaManual_(_base_, _exponenete_ ):
	_i_ = 0
	_acumulado_ = 0
	for _i_ in range(0, _exponente_-1):
	_acumulado_ = _acumulado_+_acumulado_

	print(_acumulado_)
	print(" Esta es la potencia Manual"+"\n")

def _potenciaFuncion_(_base_, _exponente_ ):
	_potencia_ = _base_**_exponente_
	return _potencia_
def _metodo_1_():
	print("estamos entrando al metodo 1"+"\n")
	print(" Esta es la potencia Funcion"+"\n")

