"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.DataType = void 0;
class Type {
    constructor(tipo) {
        this.tipo = tipo;
    }
    getTipo() {
        return this.tipo;
    }
    setTipo(tipo) {
        this.tipo = tipo;
    }
}
exports.default = Type;
var DataType;
(function (DataType) {
    DataType[DataType["ENTERO"] = 0] = "ENTERO";
    DataType[DataType["CADENA"] = 1] = "CADENA";
    DataType[DataType["BOOLEAN"] = 2] = "BOOLEAN";
    DataType[DataType["DECIMAL"] = 3] = "DECIMAL";
    DataType[DataType["IDENTIFICADOR"] = 4] = "IDENTIFICADOR";
    DataType[DataType["INDEFINIDO"] = 5] = "INDEFINIDO";
})(DataType = exports.DataType || (exports.DataType = {}));
