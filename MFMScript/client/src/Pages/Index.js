import React, { useRef, useState } from "react";
import NavBar from "../Components/NavBar";
import Editor2 from "../Components/Editor";
import Service from "../Services/Service";
import TextEditor from "@monaco-editor/react";

function Index() {
    const [ value, setValue ] = useState("")
    const [ response, setResponse ] = useState("")


  const [contentMarkdown, setContentMarkdown] = useState('');
  const editorRef = useRef(null);

    const changeText = (valueA) => {
        setValue(valueA)
    }

    const handlerPostParse = () => {
        Service.parse(value)
        .then(({consola}) => {
            setResponse(consola)
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
    
    const handleSave = () => {
        Service.parse(editorRef.current.getValue())
        .then(({consola}) => {
            setResponse(consola)
        })

    }

    const buttonTraducir = <button type="button" class="btn btn-outline-success" onClick={handleSave}>Run</button>
    const buttonVivo = <button type="button" class="btn btn-outline-warning" onClick={handlerGetServerInfo}>Traducir</button>
    const buttonLimpiar = <button type="button" class="btn btn-outline-danger" onClick={handlerClear}>Clean</button>

    return (
        <>
            <NavBar com={buttonTraducir} limpi={buttonLimpiar} />

            <TextEditor

            height='50vh'
            theme='vs-dark'
            defaultLanguage='java'
            value='// Welcome at MFMScript'
            onChange={(value) => setContentMarkdown(value)}
            onMount={handleEditorDidMount}
            />
            <Editor2  value={response} rows={10}/>
        </>
    )
}

export default Index;