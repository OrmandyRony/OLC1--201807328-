import { Instruccion } from "../Abstract/Instruccion";
import Arbol from "../Symbol/Three";
import tablaSimbolo from "../Symbol/SymbolTable";
import Tipo, { DataType } from "../Symbol/Type";

export default class TypeOf extends Instruccion {
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
        return "Int";
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.DECIMAL) {
        return "Double";
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.CADENA) {
        return "String";
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.CHAR) {
        return "CHAR";
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.BOOLEAN) {
        return "BOOLEAN"; /*deberia retornar un new symbol*/
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.TRUE) {
        return "TRUE"; /*deberia retornar un new symbol*/
    } else if (this.tipoDa.tipoDato.getTipo() === DataType.FALSE) {
        return "FALSE"; /*deberia retornar un new symbol*/
    }

    return null;
  }
}
