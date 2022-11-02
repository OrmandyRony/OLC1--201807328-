"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.Nodo = void 0;
const SymbolTable_1 = __importDefault(require("./SymbolTable"));
const Graphviz_1 = require("../../../Graphviz");
const ts_graphviz_1 = require("ts-graphviz");
class Three {
    constructor(production) {
        this.instrucciones = production.returnInstruction;
        this.consola = '';
        this.tablaGlobal = new SymbolTable_1.default();
        this.errores = new Array();
        this.raiz = production.nodeInstruction;
        this.graphIndex = 0;
    }
    /**
     * getRaiz
     */
    getRaiz() {
        return this.raiz;
    }
    getconsola() {
        return this.consola;
    }
    setconsola(value) {
        this.consola = value;
    }
    actualizaConsola(uptodate) {
        this.consola = `${this.consola}${uptodate}\n`;
    }
    getinstrucciones() {
        return this.instrucciones;
    }
    setinstrucciones(value) {
        this.instrucciones = value;
    }
    getErrores() {
        return this.errores;
    }
    seterrores(value) {
        this.errores = value;
    }
    gettablaGlobal() {
        return this.tablaGlobal;
    }
    setTablaGlobal(value) {
        this.tablaGlobal = value;
    }
    buildTree(padre, nodoPadre, digraph) {
        const nodos = padre.getHijos();
        console.log(nodos);
        for (let i = 0; i < nodos.length; i++) {
            const nodo = nodos[i];
            const node = new Graphviz_1.CNode(this.graphIndex++, nodo.getValor());
            digraph.addNode(node);
            const edge = new Graphviz_1.CEdge([nodoPadre, node], "");
            digraph.addEdge(edge);
            this.buildTree(nodo, node, digraph);
        }
    }
    getTree(name) {
        const digraph = new Graphviz_1.CDigraph(name);
        const actual = this.raiz;
        const node = new Graphviz_1.CNode(this.graphIndex++, actual.getValor());
        digraph.addNode(node);
        this.buildTree(actual, node, digraph);
        this.graphIndex = 0;
        return (0, ts_graphviz_1.toDot)(digraph);
    }
}
exports.default = Three;
class Nodo {
    constructor(valor) {
        this.valor = valor;
        this.hijos = [];
    }
    getValor() {
        return this.valor;
    }
    setValor(valor) {
        this.valor = valor;
    }
    setHijos(hijos) {
        this.hijos = hijos;
    }
    setPadre(padre) {
        this.padre = padre;
    }
    getPadre() {
        return this.padre;
    }
    getHijos() {
        return this.hijos;
    }
    generateProduction(labels) {
        labels.forEach(element => {
            (typeof element === "string" && this.hijos.push(new Nodo(element)))
                ||
                    (element instanceof Nodo && this.hijos.push(element));
        });
        return this;
    }
}
exports.Nodo = Nodo;
