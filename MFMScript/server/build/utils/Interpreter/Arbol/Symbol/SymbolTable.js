"use strict";
// El tipo de dato Map es como un linkenlist en typeScript, es una tabla hash
Object.defineProperty(exports, "__esModule", { value: true });
class SymbolTable {
    /**
     *
     * @param anterior
     */
    constructor(anterior) {
        this.tablaAnterior = anterior;
        this.tablaActual = new Map;
    }
    /**
     *
     * @param id {String}
     * @returns
     */
    getValor(id) {
        let valor = this.tablaActual.get(id);
        return valor;
    }
    /**
     * setValor
     */
    setValor(id, valor) {
        var _a;
        this.tablaActual.set(id, valor);
        console.log(id + " - " + ((_a = this.tablaActual.get(id)) === null || _a === void 0 ? void 0 : _a.getValor()));
        return null;
    }
    getAnterior() {
        return this.tablaAnterior;
    }
    setAnterior(anterior) {
        this.tablaAnterior = anterior;
    }
    getTabla() {
        return this.tablaActual;
    }
    setTabla(Tabla) {
        this.tablaActual = Tabla;
    }
}
exports.default = SymbolTable;
