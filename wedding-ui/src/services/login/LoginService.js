import axios from 'axios';

class LoginService {

  userLogin(loginDetails) {
    const config = {
      headers: {
        'content-type': 'application/x-www-form-urlencoded',
      }
    };
    return axios.post("http://localhost:8090/login", loginDetails, config)
  }

}

export default new LoginService();