import React from "react";


function Tabla(props) {

    return (
        <>
             <table class="table table-dark">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Tipo de Error</th>
            <th scope="col">Descripcion</th>
            <th scope="col">Linea</th>
            <th scope="col">Columna</th>
          </tr>
        </thead>
        <tbody id="tabla">
        
        </tbody>
      </table>
        </>
    )
}

export default Tabla;