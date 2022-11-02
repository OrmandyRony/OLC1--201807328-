"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class SymbolTable {
    constructor(anterior) {
        this.tablaAnterior = anterior;
        this.tablaActual = new Map();
    }
    getValor(id) {
        let valor = this.tablaActual.get(id);
        if (!valor) {
            let actual = this.getAnterior();
            while (actual && !valor) {
                valor = actual.getValor(id);
                actual = actual.getAnterior();
            }
        }
        return valor;
    }
    setValor(id, valor, declaration = true) {
        if (declaration) {
            this.tablaActual.set(id, valor);
        }
        else {
            let actual = this;
            let oldValue = null;
            // Busqueda del entorno de la tabla, las tabla da error si no se usan sus metododos nativos
            while (actual) {
                if (actual.getTabla().get(id)) {
                    oldValue = actual.getTabla().get(id);
                    actual.getTabla().delete(id);
                    actual.getTabla().set(id, valor);
                    break;
                }
                actual = actual.getAnterior();
            }
            if (!oldValue)
                console.log('Error la variable no existe');
        }
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
