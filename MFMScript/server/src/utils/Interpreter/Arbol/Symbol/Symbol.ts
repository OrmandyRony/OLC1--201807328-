import Tipo from "./Type";

export default class Symbol {
    private tipo: Tipo;
    private identificador: String;
    private valor: any;

    /**
     *  Datos que se almacenaran
     * @param tipo {Tipo}
     * @param identificador {String}
     * @param valor {any}
     */
    constructor(tipo: Tipo, identificador: String, valor?: any) {
        this.tipo = tipo;
        this.identificador = identificador;
        this.valor = valor;
    }

    /**
     * getTipo
     */
    public getTipo(): Tipo {
        return this.tipo;
    }

    /**
     * setTipo
     */
    public setTipo(value: Tipo) {
        this.tipo = value;
    }

    /**
     * getIdentificador
     */
    public getIdentificador(): String {
        return this.identificador;
    }

    /**
     * setIdentificador
     */
    public setIdentificador(value: String) {
        this.identificador = value;
    }

    /**
     * getValor
     */
    public getValor(): any {
        return this.valor;
    }

    /**
     * setValor
     */
    public setValor(value: any) {
        this.valor = value;
    }

}