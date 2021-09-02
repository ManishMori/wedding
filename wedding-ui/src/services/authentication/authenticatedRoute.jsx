import React from 'react'
import AuthenticationService from './AuthenticationService';
import Login from '../login/loginPage';
// import { Redirect, Route } from 'react-router-dom';

// const AuthenticatedRoute = ({ component: Component, ...rest }) => (
//     <Route 
//         {...rest} render={
//                             props => AuthenticationService.isUserLoggedIn() ? 
//                                 ( <Component {...props} /> ) : 
//                                 ( <Redirect to={{ pathname: "/" }} /> ) 
//                         } 
//     /> 
// );

class AuthenticatedRoute extends React.Component {
    render() {

        let { as: Comp, ...props } = this.props;
        return AuthenticationService.isUserLoggedIn() ? <Comp {...props} /> : <Login />;
    }
}

export default AuthenticatedRoute