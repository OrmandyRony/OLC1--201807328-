
import { Response, Request } from "express";
import Errores from "../../utils/Interpreter/Arbol/Exceptions/Error";
import SymbolTable from "../../utils/Interpreter/Arbol/Symbol/SymbolTable";
import Three from "../../utils/Interpreter/Arbol/Symbol/Three";

export let listaErrores: Array<Errores>

const fs = require('fs')

export const parse = (req: Request & unknown, res: Response): void => {
    console.log('Si llega');
    listaErrores = new Array<Errores>();
    let parser = require('../../utils/Interpreter/Arbol/analizador');
    console.log("Despues\n\n");
    console.log(req.body);
    const { peticion } = req.body;

    try {
        //console.log(parser.parse(peticion));
        let ast = new Three(parser.parse(peticion));
        var tabla = new SymbolTable();
        ast.setTablaGlobal(tabla);

        for (let i of ast.getInstrucciones()) {
            if (i instanceof Errores) {
                listaErrores.push(i);
                ast.actualizarConsola((<Errores>i).returnError());
            }

            var resultado = i.interpretar(ast, tabla);
            console.log(ast);
            if (resultado instanceof Errores) {
                listaErrores.push(resultado);
                ast.actualizarConsola((<Errores>resultado).returnError());
            }
        
            
        }
        //console.log(resultado);
        res.json({ consola: ast.getConsola(), errores: listaErrores, simbolos: []})
    } catch (err) {
        console.log(err);
        res.json({ consola: '', error: err, errores: listaErrores, simbolos: [] });
    }
}