import Simbolo from './Symbol';

export default class SymbolTable {
  private tablaAnterior: SymbolTable | any;
  private tablaActual: Map<String, Simbolo>;

  constructor(anterior?: SymbolTable) {
    this.tablaAnterior = anterior;
    this.tablaActual = new Map<String, Simbolo>();
  }

  public getValor(id: String): any{
    let valor = this.tablaActual.get(id);
    if (!valor) {
      let actual : SymbolTable = this.getAnterior();

      while (actual && !valor) {
        valor = actual.getValor(id);
        actual = actual.getAnterior();
      }
    }
    return valor;
  }

  public setValor(id: String, valor: Simbolo, declaration = true): any{
    if (declaration) {
      this.tablaActual.set(id, valor);
    } else {
      let actual: SymbolTable = this
      let oldValue = null

      // Busqueda del entorno de la tabla, las tabla da error si no se usan sus metododos nativos
      while(actual){
        if(actual.getTabla().get(id)){
          oldValue = actual.getTabla().get(id);
          actual.getTabla().delete(id);
          actual.getTabla().set(id, valor);
          break;
        }
        actual = actual.getAnterior();
      }
      if(!oldValue) console.log('Error la variable no existe')
    }
    
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