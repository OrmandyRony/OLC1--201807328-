"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Symbol {
    /**
     *  Datos que se almacenaran
     * @param tipo {Tipo}
     * @param identificador {String}
     * @param valor {any}
     */
    constructor(tipo, identificador, valor) {
        this.tipo = tipo;
        this.identificador = identificador;
        this.valor = valor;
    }
    /**
     * getTipo
     */
    getTipo() {
        return this.tipo;
    }
    /**
     * setTipo
     */
    setTipo(value) {
        this.tipo = value;
    }
    /**
     * getIdentificador
     */
    getIdentificador() {
        return this.identificador;
    }
    /**
     * setIdentificador
     */
    setIdentificador(value) {
        this.identificador = value;
    }
    /**
     * getValor
     */
    getValor() {
        return this.valor;
    }
    /**
     * setValor
     */
    setValor(value) {
        this.valor = value;
    }
}
exports.default = Symbol;
