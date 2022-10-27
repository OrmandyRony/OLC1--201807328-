import Arbol from '../Symbol/Three';
import tablaSimbolo from '../Symbol/SymbolTable';
import Tipo from '../Symbol/Type'

export abstract class Instruccion {
    public tipoDato: Tipo;
    public linea: number;
    public columna: number;

    constructor(tipoDato: Tipo, linea: number, columna: number) {
        this.tipoDato = tipoDato;
        this.linea = linea;
        this.columna = columna;
    }

    abstract interpretar(arbol: Arbol, tabla: tablaSimbolo): any;
}
