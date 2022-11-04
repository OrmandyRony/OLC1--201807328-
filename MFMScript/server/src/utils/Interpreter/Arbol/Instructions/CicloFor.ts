import { Instruccion } from "../Abstract/Instruccion";
import Arbol from "../Symbol/Three";
import tablaSimbolo from "../Symbol/SymbolTable";
import Tipo, { DataType } from "../Symbol/Type";
import SymbolTable from "../Symbol/SymbolTable";
import cloneDeep from "lodash/cloneDeep";

export default class CicloFor extends Instruccion {
  private operacion: Instruccion;
  private listaInstrucciones: Instruccion[];

  constructor(
    operacion: Instruccion,
    listaInstrucciones: Instruccion[],
    linea: number,
    columna: number
  ) {
    super(new Tipo(DataType.INDEFINIDO), linea, columna);
    this.operacion = operacion;
    this.listaInstrucciones = listaInstrucciones;
  }

  public interpretar(arbol: Arbol, tabla: tablaSimbolo) {
    while (cloneDeep(this.operacion).interpretar(arbol, tabla)) {
      const tablaLocal = new SymbolTable(tabla);

      for (let i of cloneDeep(this.listaInstrucciones)) {
        i.interpretar(arbol, tablaLocal);
      }
    }

    return null;
  }
}
