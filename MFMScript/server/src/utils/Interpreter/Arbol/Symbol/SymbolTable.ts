// El tipo de dato Map es como un linkenlist en typeScript, es una tabla hash

import { StringIterator } from 'lodash';
import Simbolo from './Symbol';

export default class SymbolTable {
    private tablaAnterior: SymbolTable | any;
    private tablaActual: Map<String, Simbolo>;

    /**
     * 
     * @param anterior 
     */
    constructor(anterior?: SymbolTable) {
        this.tablaAnterior = anterior;
        this.tablaActual = new Map<String, Simbolo>;

    }

    /**
     * 
     * @param id {String}
     * @returns 
     */
    public getValor(id: String): any {
        let valor = this.tablaActual.get(id);
        return valor;
    }

    /**
     * setValor
     */
    public setValor(id: String, valor: Simbolo): any {
        this.tablaActual.set(id, valor);
        console.log(id + " - " + this.tablaActual.get(id)?.getValor());
        return null;
    }

    public getAnterior() {
        return this.tablaAnterior;
    }

    public setAnterior(anterior: SymbolTable) {
        this.tablaAnterior = anterior;
    }

    public getTabla() {
        return this.tablaActual;
    }

    public setTabla(Tabla: Map<String, Simbolo>) {
        this.tablaActual = Tabla;
    }
}
