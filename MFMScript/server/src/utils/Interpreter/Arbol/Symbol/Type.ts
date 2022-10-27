export default class Type {
    private tipo: DataType;

    constructor(tipo: DataType) {
        this.tipo = tipo;
    }

    /**
     * getTipo
     */
    public getTipo(): DataType {
        return this.tipo;
    }

    /**
     * setTipo
     */
    public setTipo(tipo: DataType): void {
        this.tipo = tipo;
    }
}

/**
 * Datos que se guardan en la tabla de simbolos
 * Nos sirve para saber que estamos operando
 */
export enum DataType {
    ENTERO,
    CADENA,
    IDENTIFICADOR,
    INDEFINIDO
}