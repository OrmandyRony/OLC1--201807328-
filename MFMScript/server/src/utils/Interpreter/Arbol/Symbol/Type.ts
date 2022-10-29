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
    BOOLEAN,
    DECIMAL,
    IDENTIFICADOR,
    INDEFINIDO
}