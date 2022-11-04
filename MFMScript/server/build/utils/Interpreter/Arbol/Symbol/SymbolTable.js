"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const Symbol_1 = __importDefault(require("./Symbol"));
const Type_1 = __importStar(require("../Symbol/Type"));
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
                    console.log("Valor viejo: ", oldValue === null || oldValue === void 0 ? void 0 : oldValue.getvalor());
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
    setValorIncremento(id, declaration = true) {
        if (declaration) {
        }
        else {
            let actual = this;
            let oldValue = null;
            // Busqueda del entorno de la tabla, las tabla da error si no se usan sus metododos nativos
            while (actual) {
                if (actual.getTabla().get(id)) {
                    oldValue = actual.getTabla().get(id);
                    const incremento = Number(Number(oldValue === null || oldValue === void 0 ? void 0 : oldValue.getvalor()) + 1);
                    actual.getTabla().delete(id);
                    actual.getTabla().set(id, new Symbol_1.default(new Type_1.default(Type_1.DataType.ENTERO), id, incremento));
                    break;
                }
                actual = actual.getAnterior();
            }
            if (!oldValue)
                console.log('Error la variable no existe');
        }
        return null;
    }
    setValorDecremento(id, declaration = true) {
        if (declaration) {
        }
        else {
            let actual = this;
            let oldValue = null;
            // Busqueda del entorno de la tabla, las tabla da error si no se usan sus metododos nativos
            while (actual) {
                if (actual.getTabla().get(id)) {
                    oldValue = actual.getTabla().get(id);
                    const decremento = Number(Number(oldValue === null || oldValue === void 0 ? void 0 : oldValue.getvalor()) - 1);
                    actual.getTabla().delete(id);
                    actual.getTabla().set(id, new Symbol_1.default(new Type_1.default(Type_1.DataType.ENTERO), id, decremento));
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
