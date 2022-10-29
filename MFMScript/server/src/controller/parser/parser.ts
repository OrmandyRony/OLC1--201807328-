import { Response, Request } from "express";
import Errores from '../../utils/Interpreter/Arbol/Exceptions/Error';
import Three from "../../utils/Interpreter/Arbol/Symbol/Three";
import SymbolTable from "../../utils/Interpreter/Arbol/Symbol/SymbolTable";
import { Instruccion } from "../../utils/Interpreter/Arbol/Abstract/Instruccion";

export let listaErrores: Array<Errores> = [];

export const parse = (req: Request & unknown, res: Response): void => {
    listaErrores = new Array<Errores>();
    let parser = require('../../utils/Interpreter/Arbol/analizador');
    const { peticion } = req.body;

    try { 
      let ast = new Three(parser.parse(peticion));
      var tabla = new SymbolTable();
      ast.settablaGlobal(tabla);
      for (let i of ast.getinstrucciones()) {
        if (i instanceof Errores) {
          listaErrores.push(i);
          ast.actualizaConsola((<Errores>i).returnError());
        }
        var resultador = i instanceof Instruccion ? i.interpretar(ast, tabla) : new Errores("ERROR SEMANTICO", "no se puede ejecutar la instruccion", 0, 0);
        if (resultador instanceof Errores) {
          listaErrores.push(resultador);
          ast.actualizaConsola((<Errores>resultador).returnError());
        }        
      }
      res.json({ consola: ast.getconsola(), errores: listaErrores, simbolos: [] });
    } catch (err) {
        console.log(err)
        res.json({ consola: '', error: err, errores: listaErrores, simbolos: [] });
    }
}