import { Instruccion } from '../Abstract/Instruccion';
import Arbol from '../Symbol/Three';
import Simbolo from '../Symbol/Symbol';
import tablaSimbolo from '../Symbol/SymbolTable';
import Tipo, {DataType} from '../Symbol/Type';


/**
 * tengo que busacar la variable y asignarle su valor
 * tipo Identificador = valor
 */
export default class Asignacion extends Instruccion {
    private id: String;
    private valor: Instruccion;

    constructor(id: String, valor: Instruccion, linea: number, columna: number) {
        super(new Tipo(DataType.INDEFINIDO), linea, columna);
        this.id = id;
        this.valor = valor;
        console.log("Declarando ------")
    }

    public interpretar(arbol: Arbol, tabla: tablaSimbolo) {

        tabla.setValorDecremento(this.id, false);
        return null;
    }
}