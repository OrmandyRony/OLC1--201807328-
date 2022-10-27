"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.parse = exports.listaErrores = void 0;
const Error_1 = __importDefault(require("../../utils/Interpreter/Arbol/Exceptions/Error"));
const SymbolTable_1 = __importDefault(require("../../utils/Interpreter/Arbol/Symbol/SymbolTable"));
const Three_1 = __importDefault(require("../../utils/Interpreter/Arbol/Symbol/Three"));
const fs = require('fs');
const parse = (req, res) => {
    console.log('Si llega');
    exports.listaErrores = new Array();
    let parser = require('../../utils/Interpreter/Arbol/analizador');
    console.log("Despues\n\n");
    console.log(req.body);
    const { peticion } = req.body;
    try {
        //console.log(parser.parse(peticion));
        let ast = new Three_1.default(parser.parse(peticion));
        var tabla = new SymbolTable_1.default();
        ast.setTablaGlobal(tabla);
        for (let i of ast.getInstrucciones()) {
            if (i instanceof Error_1.default) {
                exports.listaErrores.push(i);
                ast.actualizarConsola(i.returnError());
            }
            var resultado = i.interpretar(ast, tabla);
            console.log(ast);
            if (resultado instanceof Error_1.default) {
                exports.listaErrores.push(resultado);
                ast.actualizarConsola(resultado.returnError());
            }
        }
        //console.log(resultado);
        res.json({ consola: ast.getConsola(), errores: exports.listaErrores, simbolos: [] });
    }
    catch (err) {
        console.log(err);
        res.json({ consola: '', error: err, errores: exports.listaErrores, simbolos: [] });
    }
};
exports.parse = parse;
