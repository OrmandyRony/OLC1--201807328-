func _potenciaManual_(_base_, _exponenete_ ){
	var _i_ float64 = 0
	var _acumulado_ float64 = 0
	for _i_ := 0; _i_  < _exponente_-1; _i_++ {
	_acumulado_ = _acumulado_+_acumulado_
}
	fmt.Print(_acumulado_)
	fmt.Println(" Esta es la potencia Manual")

}
