import React, { useRef, useState } from "react";
import NavBar from "../Components/NavBar";
import Tabla from "../Components/Tabla";
import Editor2 from "../Components/Editor";
import Service from "../Services/Service";
import TextEditor from "@monaco-editor/react";
import { Graphviz } from 'graphviz-react';
import { saveAs } from "file-saver";
import { json } from "react-router-dom";

function Index() {
    const [myValue, setMyValue] = useState('');

    const [tab, setTab] = useState('');
    const [ value, setValue ] = useState("")
    const [ response, setResponse ] = useState("")
    const [ arbolito, setArbolito ] = useState(`graph {
        }`);

  const [contentMarkdown, setContentMarkdown] = useState('');
  const editorRef = useRef(null);

    const changeText = (valueA) => {
        setValue(valueA)
    }

    const handlerPostParse = () => {
        Service.parse(value)
        .then(({consola, arbol}) => {
            
            setResponse(consola);
        })

    }

    const handlerGetServerInfo = () => {
        Service.ping()
        .then((response) => {
            setResponse(JSON.stringify(response))
        })
    }

    const handlerClear = () => {
        setResponse("")
    }

    const handleEditorDidMount = ( editor, monaco ) => {
        editorRef.current = editor;
    }
    
    var tala = document.getElementById("tabla"); 
    const handleSave = () => {
        Service.parse(editorRef.current.getValue())
        .then(({consola, arbol, errores}) => {
            console.log(errores);
            setArbolito(arbol);

            let tabla = "";
            let i = 1;
        
            for (let err of errores) {
                tabla = "<tr>\n";
                tabla += `\t<th scope="row">${i}</th>\n`
                tabla += `\t<td>${err.tipoError}</td>\n`
                tabla += `\t<td>${err.descripcion}</td>\n`  
                tabla += `\t<td>${err.fila}</td>\n`  
                tabla += `\t<td>${err.columna}</td>\n`
                tabla += "</tr>\n";  

            }
            
            console.log(tabla);
            
            setResponse(JSON.stringify(errores) + "\n"+ consola);
            tala.innerHTML = tabla;
        })

    }



    const createFile = () => {
        const blob = new Blob([ editorRef.current.getValue() ], {type: 'text/plain;charset=utf-8'})
        saveAs(blob, 'mi-archivo.txt');
    }

    const readFile= ( e ) => {
        const file = e.target.files[0];

        if ( !file ) return;

        const fileReader = new FileReader();
        fileReader.readAsText( file );

        fileReader.onload = () => {
            console.log( fileReader.result );
            setMyValue(fileReader.result );
        }
        
        fileReader.onerror = () => {
            console.log( fileReader.error );
        }
    }

    const buttonTraducir = <button type="button" class="btn btn-outline-success" onClick={handleSave}>Run</button>
    const buttonVivo = <button type="button" class="btn btn-outline-warning" onClick={handlerGetServerInfo}>Traducir</button>
    const buttonLimpiar = <button type="button" class="btn btn-outline-danger" onClick={handlerClear}>Clean</button>
    const guardarArchivo =  <button type="button" class="btn btn-outline-warning" onClick={ createFile }>Guardar</button>;
    const entrada =  <input type="file" multiple={ false } onChange={ readFile }></input>;
   
    return (
        <>
            <NavBar entradaA={entrada}  guardar={guardarArchivo} com={buttonTraducir} limpi={buttonLimpiar} />
  
            <TextEditor

            height='50vh'
            theme='vs-dark'
            defaultLanguage='java'
            value= { myValue }
            onChange={(value) => setContentMarkdown(value)}
            onMount={handleEditorDidMount}
            />
            <Editor2  value={response} rows={10}/>
            <Graphviz dot={arbolito} 

                options = {{zoom: true, height:1500, width:1800}}
            />
            <Tabla/>
        </>
    )
}

export default Index;