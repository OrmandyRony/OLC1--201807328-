export default class Type {
    private tipo: DataType;
  
    constructor(tipo: DataType) {
      this.tipo = tipo;
    }
    public getTipo(): DataType {
      return this.tipo;
    }
    public setTipo(tipo: DataType): void {
      this.tipo = tipo;
    }
}
  
export enum DataType {
  ENTERO,
  CADENA,
  CHAR,
  BOOLEAN,
  // EL TIPO DE DATO BOOLEAN SE EXTIENDEN A DOS
  TRUE,
  FALSE,
  DECIMAL,
  IDENTIFICADOR,
  INDEFINIDO
}