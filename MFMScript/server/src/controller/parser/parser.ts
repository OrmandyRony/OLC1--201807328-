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
    console.log(peticion);

    try { 
      //const returnThree = parser.parse(peticion);
      console.log("Parser");
      console.log(parser.parse(peticion));
      let ast = new Three(parser.parse(peticion));
      var tabla = new SymbolTable();
      ast.setTablaGlobal(tabla);

      // Se recorre el array de instrucciones
      for (let i of ast.getinstrucciones()) {
        if (i instanceof Errores) {
          listaErrores.push(i);
          ast.actualizaConsola((<Errores>i).returnError());
        }
        //console.log("LISTA DE ERRRORES");
        //console.log(listaErrores);
        // 
        var resultador = i instanceof Instruccion ? i.interpretar(ast, tabla) : new Errores("ERROR SEMANTICO", "no se puede ejecutar la instruccion", 0, 0);
        if (resultador instanceof Errores) {
          listaErrores.push(resultador);
          ast.actualizaConsola((<Errores>resultador).returnError());
        }
        //console.log("LISTA DE ERRRORES--------------------");
        //console.log(listaErrores);        
      }
      const arbolGrafo = ast.getTree("ast");
      //console.log(arbolGrafo);
      res.json({ consola: ast.getconsola(), arbol: arbolGrafo, errores: listaErrores, simbolos: [] });
    } catch (err) {
        console.log(err)
        res.json({ consola: '', error: err, errores: listaErrores, simbolos: [] });
    }
}