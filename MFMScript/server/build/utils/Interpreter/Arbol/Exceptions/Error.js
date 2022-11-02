"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Error {
    constructor(tipo, descripcion, fila, columna) {
        this.tipoError = tipo;
        this.descripcion = descripcion;
        this.fila = fila;
        this.columna = columna;
    }
    getDescripcion() {
        return this.descripcion;
    }
    getTipoError() {
        return this.tipoError;
    }
    getcolumna() {
        return this.columna;
    }
    getFila() {
        return this.fila;
    }
    returnError() {
        return ('Se obtuvo: ' +
            this.tipoError +
            ' descripcion:{' +
            this.descripcion +
            '} en la fila: ' +
            this.fila +
            ' en la columna: ' +
            this.columna +
            '\n');
    }
}
exports.default = Error;
