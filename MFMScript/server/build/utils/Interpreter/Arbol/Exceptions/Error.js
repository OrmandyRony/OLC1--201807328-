"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Error {
    constructor(tipoError, descripcion, fila, columna) {
        this.tipoError = tipoError;
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
    getFila() {
        return this.fila;
    }
    /**
     * returnError
     */
    returnError() {
        return ('Se obtuvo: ' +
            this.tipoError +
            ' descripcion:{' +
            this.descripcion +
            '} en la fila: ' +
            this.fila +
            ' en la columana: ' +
            this.columna + '/n');
    }
}
exports.default = Error;
