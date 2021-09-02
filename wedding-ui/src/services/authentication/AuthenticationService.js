import { Component } from 'react';
import axios from 'axios';

class AuthenticationService extends Component {
    registerSuccessfulLogin(user, token) {
    localStorage.setItem('user', JSON.stringify(user))
    localStorage.setItem('token', token)
    
    this.setupAxiosInterceptors(user.accessToken)
}

    setupAxiosInterceptors(token) {
        axios.interceptors.request.use(
            (config) => {
                if (this.isUserLoggedIn()) {
                    config.headers.authorization = token
                }
                return config
            }
        )
    }
}

export default new AuthenticationService()