import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import Index from "./Pages/Index";
import Page from "./Pages/Page";
import Page2 from "./Pages/Page2";
import './App.css';

function App() {
  return (
    <BrowserRouter>
        <Routes>
          <Route path="/" element={<Index />} />
          <Route path="/page" element={<Page />} />
          <Route path="/paginasInternas" element={<Page2 />} />
          <Route path="*" element={<Navigate to="/" replace={true} />} exact={true} />
        </Routes>
    </BrowserRouter>
      
  );
}

export default App;
