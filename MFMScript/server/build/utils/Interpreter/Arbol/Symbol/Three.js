"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const SymbolTable_1 = __importDefault(require("./SymbolTable"));
class Three {
    constructor(instrucciones) {
        this.instrucciones = instrucciones;
        this.consola = '';
        this.tablaGlobal = new SymbolTable_1.default();
        this.errores = new Array();
    }
    /**
     * getConsola
     */
    getConsola() {
        return this.consola;
    }
    /**
     * setConsola
     */
    setConsola(value) {
        this.consola = value;
    }
    /**
     *
     * actulizarConsola
     * Ejemplo si tenemos dos impresciones en cada impresion la actualizamos
     */
    actualizarConsola(uptoDate) {
        this.consola = `${this.consola}${uptoDate}\n`;
    }
    /**
     * getInstrucciones
     */
    getInstrucciones() {
        return this.instrucciones;
    }
    /**
     * setInstrucciones
     */
    setInstrucciones(value) {
        this.instrucciones = value;
    }
    /**
     * getErrores
     */
    getErrores() {
        return this.errores;
    }
    /**
     * setErrores
     */
    setErrores(value) {
        this.errores = value;
    }
    /**
     * getTablaGlobal
     */
    getTablaGlobal() {
        return this.tablaGlobal;
    }
    /**
     * setTablaGlobal
     */
    setTablaGlobal(value) {
        this.tablaGlobal = value;
    }
}
exports.default = Three;
