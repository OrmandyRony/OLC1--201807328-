import React, { useState } from "react";
import NavBar from "../Components/NavBar";

function Page() {
    const [ pageInterna, setPageInterna ] = useState(<></>)
    
    return (
        <>
            <NavBar setPage = {setPageInterna}/>
            {
                pageInterna
            }
        </>
    )
}

export default Page;