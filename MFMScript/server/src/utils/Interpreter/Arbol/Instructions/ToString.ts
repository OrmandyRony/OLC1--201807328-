import { Instruccion } from "../Abstract/Instruccion";
import Arbol from "../Symbol/Three";
import tablaSimbolo from "../Symbol/SymbolTable";
import Tipo, { DataType } from "../Symbol/Type";

export default class ToString extends Instruccion {
  tipoDa: Instruccion;

  constructor(
    tipoDa: Instruccion,
    fila: number,
    columna: number
  ) {
    super(new Tipo(DataType.INDEFINIDO), fila, columna);
    this.tipoDa= tipoDa;
  }

  interpretar(arbol: Arbol, tabla: tablaSimbolo) {
    if (this.tipoDa.tipoDato.getTipo() === DataType.ENTERO) {
        const valor = this.tipoDa.interpretar(arbol, tabla) + "";
        return valor;
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.DECIMAL) {
        const valor = this.tipoDa.interpretar(arbol, tabla) + "";
        return valor;
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.CADENA) {
        const valor = this.tipoDa.interpretar(arbol, tabla) + "";
        return valor;
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.CHAR) {
        const valor = this.tipoDa.interpretar(arbol, tabla) + "";
        return valor;
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.BOOLEAN) {
        const valor = this.tipoDa.interpretar(arbol, tabla) + "";
        return valor;
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.TRUE) {
        const valor = this.tipoDa.interpretar(arbol, tabla) + "";
        return valor;
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.FALSE) {
        const valor = this.tipoDa.interpretar(arbol, tabla) + "";
        return valor;
    }

    return null;
  }
}
