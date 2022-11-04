import { Instruccion } from "../Abstract/Instruccion";
import Arbol from "../Symbol/Three";
import tablaSimbolo from "../Symbol/SymbolTable";
import Tipo, { DataType } from "../Symbol/Type";
import SymbolTable from "../Symbol/SymbolTable";
import cloneDeep from "lodash/cloneDeep";

export default class CicloFor extends Instruccion {
  private declaracion: Instruccion;
  private condicion: Instruccion;
  private actualizacion: Instruccion;


  private listaInstrucciones: Instruccion[];

  constructor(
    declaracion: Instruccion,
    condicion: Instruccion,
    actualizacion: Instruccion,
    listaInstrucciones: Instruccion[],
    linea: number,
    columna: number
  ) {
    super(new Tipo(DataType.INDEFINIDO), linea, columna);
    this.declaracion = declaracion;
    this.condicion = condicion;
    this.actualizacion = actualizacion;
    this.listaInstrucciones = listaInstrucciones;
  }

  public interpretar(arbol: Arbol, tabla: tablaSimbolo) {

    this.declaracion.interpretar(arbol, tabla);
    while (cloneDeep(this.condicion).interpretar(arbol, tabla)) {
      const tablaLocal = new SymbolTable(tabla);

      for (let i of cloneDeep(this.listaInstrucciones)) {
        i.interpretar(arbol, tablaLocal);
      }
      this.actualizacion.interpretar(arbol, tabla);
      
    }

    return null;
  }
}
