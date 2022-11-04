import { Instruccion } from '../Abstract/Instruccion';
import Arbol from '../Symbol/Three';
import Simbolo from '../Symbol/Symbol';
import tablaSimbolo from '../Symbol/SymbolTable';
import Tipo, {DataType} from '../Symbol/Type';


/**
 * tipo Identificador = valor
 */
export default class Funciones extends Instruccion {
    private id: String;
    private listaParametros: Instruccion[];

    private tipo: Tipo;
    private valor: Instruccion;
    private listaInstrucciones: Instruccion[];

    constructor(
        id: String, 
        listaParametros: Instruccion[],
        tipo: Tipo, 
        listaInstrucciones: Instruccion[],
        linea: number, 
        columna: number
        ) {
        super(new Tipo(DataType.INDEFINIDO), linea, columna);
        this.id = id;
        this.listaParametros = listaParametros;
        this.tipo = tipo;
        this.listaInstrucciones = listaInstrucciones;
        // console.log("Declarando ------")
    }

    public interpretar(arbol: Arbol, tabla: tablaSimbolo) {
        tabla.setValor(this.id, new Simbolo(this.tipo, this.id, this.valor.interpretar(arbol, tabla)));
        return null;
    }
}