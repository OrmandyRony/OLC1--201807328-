import React from "react";
import Index from "../Pages/Index";
import Page from "../Pages/Page";

function NavBar(props) {

    return (
        <>
            <nav class="navbar navbar-expand-lg navbar-light bg-light" >
            <a class="navbar-brand" href="/">MFMScript</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                    File
                    </a>
                    <div class="dropdown-menu">
                    <a class="dropdown-item" onClick={() => props.setPage(<Index/>)}>Open File</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="">Save</a>
                    </div>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                    Report
                    </a>
                    <div class="dropdown-menu">
                    <a class="dropdown-item" onClick={() => props.setPage(<Index/>)}>Bug Reports</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="">AST</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="">Symbol Table</a>
                    </div>
                </li>

                </ul>
                {props.com}
                <div >
                {props.limpi}
                </div>
                
            </div>
            </nav>
        </>
    )
}

export default NavBar;