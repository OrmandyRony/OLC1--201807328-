import { Instruccion } from "../Abstract/Instruccion";
import Arbol from "../Symbol/Three";
import tablaSimbolo from "../Symbol/SymbolTable";
import Tipo, { DataType } from "../Symbol/Type";

export default class Aritmetico extends Instruccion {
  operacionIzq: Instruccion;
  operacionDer: Instruccion;
  tipo: tipoOp;

  constructor(
    tipo: tipoOp,
    opIzq: Instruccion,
    opDer: Instruccion,
    fila: number,
    columna: number
  ) {
    super(new Tipo(DataType.INDEFINIDO), fila, columna);
    this.tipo = tipo;
    this.operacionIzq = opIzq;
    this.operacionDer = opDer;
  }

  interpretar(arbol: Arbol, tabla: tablaSimbolo) {
    if (this.tipo === tipoOp.SUMA) {
      let valueIzq = this.operacionIzq.interpretar(arbol, tabla);
      let valueDer = this.operacionDer.interpretar(arbol, tabla);

      if (this.operacionIzq.tipoDato.getTipo() === DataType.ENTERO) {
        if (this.operacionDer.tipoDato.getTipo() === DataType.ENTERO) {
          this.tipoDato.setTipo(DataType.ENTERO);
          return Number(valueIzq) + Number(valueDer);
        } else if (this.operacionDer.tipoDato.getTipo() === DataType.CADENA) {
          this.tipoDato.setTipo(DataType.CADENA);
          return `${valueIzq.toString()}${valueDer.toString()}`;
        }
      }
      
    } else if (this.tipo === tipoOp.RESTA) {
      let valueIzq = this.operacionIzq.interpretar(arbol, tabla);
      let valueDer = this.operacionDer.interpretar(arbol, tabla);

      if (this.operacionIzq.tipoDato.getTipo() === DataType.ENTERO) {
        if (this.operacionDer.tipoDato.getTipo() === DataType.ENTERO) {
          this.tipoDato.setTipo(DataType.ENTERO);
          return Number(valueIzq) - Number(valueDer);
        }
      }
    } else if (this.tipo === tipoOp.MULTIPLICACION) {
      let valueIzq = this.operacionIzq.interpretar(arbol, tabla);
      let valueDer = this.operacionDer.interpretar(arbol, tabla);

      if (this.operacionIzq.tipoDato.getTipo() === DataType.ENTERO) {
        if (this.operacionDer.tipoDato.getTipo() === DataType.ENTERO) {
          this.tipoDato.setTipo(DataType.ENTERO);
          return Number(valueIzq) * Number(valueDer);
        }
      }
    } else if (this.tipo === tipoOp.DIVISION) {
      let valueIzq = this.operacionIzq.interpretar(arbol, tabla);
      let valueDer = this.operacionDer.interpretar(arbol, tabla);

      if (this.operacionIzq.tipoDato.getTipo() === DataType.ENTERO) {
        if (this.operacionDer.tipoDato.getTipo() === DataType.ENTERO) {
          this.tipoDato.setTipo(DataType.ENTERO);
          return Number(valueIzq) / Number(valueDer);
        }
      }
    }

    return null;
  }
}

export enum tipoOp {
  SUMA,
  RESTA,
  DIVISION,
  MULTIPLICACION,
  // Sin adjuntar interpretacion
  POTENCIA,
  MODULO

}
