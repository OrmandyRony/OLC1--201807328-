import Editor from "@monaco-editor/react";
import { useRef, useState } from "react";


export default  function App() {

  const [contentMarkdown, setContentMarkdown] = useState('');
  const editorRef = useRef(null);

  const handleEditorDidMount = ( editor, monaco ) => {
    editorRef.current = editor;
  }

  const handleSave = () => {
    console.log(editorRef.current.getValue())
  }
  
  return (
    <div style={{width: '50%', margin: 'auto'}}>
      <button onClick={handleSave}>Save</button>
      <Editor 
        height='90vh'
        theme='vs-dark'
        defaultLanguage='markdown'
        value='## Welcome'
        onChange={(value) => setContentMarkdown(value)}
        onMount={handleEditorDidMount}
      />
    </div>
  );
}