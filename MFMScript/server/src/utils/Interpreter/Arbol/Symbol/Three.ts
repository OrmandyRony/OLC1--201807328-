import { update } from "lodash";
import { Instruccion } from "../Abstract/Instruccion";
import Errores from "../Exceptions/Error";
import tablaSimbolo from "./SymbolTable";

export default class Three {
    private instrucciones: Array<Instruccion>;
    private errores: Array<Errores>;
    private consola: String;
    private tablaGlobal: tablaSimbolo;

    constructor(instrucciones: Array<Instruccion>) {
        this.instrucciones = instrucciones;
        this.consola = '';
        this.tablaGlobal = new tablaSimbolo();
        this.errores = new Array<Errores>();
    }

    /**
     * getConsola
     */
    public getConsola(): String {
        return this.consola;
    }

    /**
     * setConsola
     */
    public setConsola(value: String) {
        this.consola = value;
    }

    /**
     * 
     * actulizarConsola
     * Ejemplo si tenemos dos impresciones en cada impresion la actualizamos
     */
    public actulizarConsola(uptoDate: String) {
        this.consola = `${this.consola}${update}\n`;
    }

    /**
     * getInstrucciones
     */
    public getInstrucciones(): Array<Instruccion> {
        return this.instrucciones;
    }

    /**
     * setInstrucciones
     */
    public setInstrucciones(value: Array<Instruccion>) {
        this.instrucciones = value;
    }

    /**
     * getErrores
     */
    public getErrores(): Array<Errores> {
        return this.errores;
    }

    /**
     * setErrores
     */
    public setErrores(value: Array<Errores>) {
        this.errores = value;
    }

    /**
     * getTablaGlobal
     */
    public getTablaGlobal(): tablaSimbolo {
        return this.tablaGlobal;
    }

    /**
     * setTablaGlobal
     */
    public setTablaGlobal(value: tablaSimbolo) {
        this.tablaGlobal = value;
    }
}