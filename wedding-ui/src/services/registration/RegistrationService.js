import axios from 'axios';

class RegistrationService {

  userRegistration(formData) {
    const config = {
      headers: {
        'content-type': 'multipart/form-data',
      }
    };
    return axios.post("http://localhost:8090/registration", formData, config)
  }

}

export default new RegistrationService();