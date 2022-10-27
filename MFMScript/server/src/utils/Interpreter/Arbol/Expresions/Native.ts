import { Instruccion } from "../Abstract/Instruccion";
import Three from "../Symbol/Three";
import SymbolTable from "../Symbol/SymbolTable";
import Type, { DataType } from "../Symbol/Type";

export default class Nativo extends Instruccion {
    valor: any;

    constructor(tipoDato: Type, valor: any, fila: number, columna: number) {
        super(tipoDato, fila, columna);
        this.valor = valor;
    }

    interpretar(arbol: Three, tabla: SymbolTable) {
        if (this.tipoDato.getTipo() === DataType.ENTERO) {
            return this.valor;
        } else if(this.tipoDato.getTipo() === DataType.CADENA) {
            return this.valor.toString();
        }
    }
}