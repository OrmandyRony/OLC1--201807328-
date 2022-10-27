export default class Error {
    private tipoError: String;
    private descripcion: String;
    private fila: number;
    private columna: number;

    constructor(tipoError: String, descripcion: String, fila: number, columna: number) {
        this.tipoError = tipoError;
        this.descripcion = descripcion;
        this.fila = fila;
        this.columna = columna;
    }

    public getDescripcion(): String {
        return this.descripcion;
    }

    public getTipoError(): String {
        return this.tipoError;
    }

    public getFila(): number {
        return this.fila;
    }

    /**
     * returnError
     */
    public returnError(): String {
        return (
            'Se obtuvo: ' +
            this.tipoError +
            ' descripcion:{' +
                this.descripcion +
            '} en la fila: ' +
                this.fila +
                ' en la columana: ' +
            this.columna + '/n'
        );
    }
}