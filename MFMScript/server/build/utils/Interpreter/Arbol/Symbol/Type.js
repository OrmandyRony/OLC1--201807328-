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
    DataType[DataType["CHAR"] = 2] = "CHAR";
    DataType[DataType["BOOLEAN"] = 3] = "BOOLEAN";
    // EL TIPO DE DATO BOOLEAN SE EXTIENDEN A DOS
    DataType[DataType["TRUE"] = 4] = "TRUE";
    DataType[DataType["FALSE"] = 5] = "FALSE";
    DataType[DataType["DECIMAL"] = 6] = "DECIMAL";
    DataType[DataType["IDENTIFICADOR"] = 7] = "IDENTIFICADOR";
    DataType[DataType["INDEFINIDO"] = 8] = "INDEFINIDO";
})(DataType = exports.DataType || (exports.DataType = {}));
