import React from 'react'

import './header.css';

const Header = (props) => {
    return(
        <div>
            <header>
                
                <nav className="navbar navbar-expand-lg navbar-light bg-primary" style={{padding : "0px 0px"}}>
                    <ul className="nav navbar-nav d-md-down">
                        <li className="nav-item">
                        <span className="nav-link">
                            <h4  className="text-light1 ml-2">Wedding Registration</h4>
                        </span>
                        </li>
                    </ul>
                </nav>
            </header>
        </div>
        )
}
export default Header