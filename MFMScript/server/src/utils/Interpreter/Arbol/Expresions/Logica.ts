import { Instruccion } from '../Abstract/Instruccion';
import Arbol from '../Symbol/Three';
import tablaSimbolo from '../Symbol/SymbolTable';
import Tipo, {DataType} from '../Symbol/Type';

export default class Logica extends Instruccion {
  operacionIzq: Instruccion;
  operacionDer: Instruccion;
  tipo: tipoOp;
  

  constructor(tipo: tipoOp, opIzq: Instruccion, opDer: Instruccion, fila: number, columna: number) {
    super(new Tipo(DataType.INDEFINIDO), fila, columna);
    this.tipo = tipo;
    this.operacionIzq = opIzq;
    this.operacionDer = opDer;
  }

    interpretar(arbol: Arbol, tabla: tablaSimbolo) {
        const validTypesOperations = [DataType.BOOLEAN]
        let valueDer = this.operacionDer.interpretar(arbol, tabla);
        
        if (this.tipo === tipoOp.NOT) {
            console.log("iNTENTANDO INTERPRETAR");
            this.tipoDato = new Tipo(DataType.BOOLEAN);  
            return !(valueDer);
        }
        
        let valueIzq = this.operacionIzq.interpretar(arbol, tabla);

        if (validTypesOperations.includes(this.operacionIzq.tipoDato.getTipo())
            && validTypesOperations.includes(this.operacionDer.tipoDato.getTipo())) {
                
            if (this.tipo === tipoOp.OR){      
                this.tipoDato = new Tipo(DataType.BOOLEAN);  
                return valueIzq || valueDer;
            } else if (this.tipo === tipoOp.AND) {
                this.tipoDato = new Tipo(DataType.BOOLEAN);  
                return valueIzq && valueDer;
            } 
        }  else {
            return null;
        }
    }  
}

export enum tipoOp{
    AND,
    OR,
    NOT
}