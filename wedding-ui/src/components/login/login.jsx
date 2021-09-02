import React, { useState } from "react";

import FormControl from "react-bootstrap/FormControl";
import Card from "react-bootstrap/Card";
import { Col, InputGroup, Row, Spinner, Toast, ToastContainer } from "react-bootstrap";
import LoginService from "../../services/login/LoginService";

import { navigate } from "@reach/router";
import AuthenticationService from "../../services/authentication/AuthenticationService";

export default function Login() {

  const email = useFormInput("");
  const password = useFormInput("");

  const [isLoading, setLoading] = useState(false);
  const [buttonValue, setButtonValue] = useState("Login");

  const [show, setShow] = useState(false);
  const [variant, setVariant] = useState("");
  const [responseMessage, setResponseMessage] = useState("");

  const handleLogin = (event) => {
    event.preventDefault();
    
    email.setValue('');
    password.setValue('');

    setLoading(true);
    setButtonValue(" Loading...");
    
    var formData = new FormData();
    formData.append("username", email.value);
    formData.append("password", password.value);
    LoginService.userLogin(formData)
      .then((response) => {
        if(response.status === 200) {
          AuthenticationService.registerSuccessfulLogin(response.data, response.headers)
          navigate('/dashboard');
        } else {
          setVariant("danger");
          setResponseMessage(
            "Username or Password Incorrect! Please try again or contact support."
          );
        }
        setLoading(false);
        setButtonValue("Login");
      }).catch((error) => {
        
        setShow(true);
        setVariant("danger");
        setResponseMessage(
          "You Login Failed! Please try again or contact support."
        );
        console.error(error);
        setLoading(false);
        setButtonValue("Login");
      });
  };

  return (
    <React.Fragment>
      <Card.Body>
        <p className="text-warning">
          <b>Sign In</b>
        </p>
        <form onSubmit={handleLogin}>
          <Row>
            <Col>
              <InputGroup className="mb-3">
                <InputGroup.Text id="basic-addon1">
                  <i className="icon-user"></i>
                </InputGroup.Text>
                <FormControl
                  type="email"
                  required
                  aria-label="Email"
                  aria-describedby="basic-addon1"
                  placeholder="Email"
                  autoComplete="email"
                  name="email"
                  {...email}
                />
              </InputGroup>
            </Col>
          </Row>

          <Row>
            <Col>
              <InputGroup className="mb-3">
                <InputGroup.Text id="basic-addon1">
                  <i className="icon-lock"></i>
                </InputGroup.Text>
                <FormControl
                  type="password"
                  required
                  aria-label="Password"
                  aria-describedby="basic-addon1"
                  placeholder="Password"
                  name="password"
                  {...password}
                />
              </InputGroup>
            </Col>
          </Row>

          <div className="row mt-4">
            <div className="col-6">
              <button
                type="submit"
                className="btn btn-primary px-4"
                id="btnSave"
              >
                {isLoading && (
                  <Spinner
                    as="span"
                    animation="grow"
                    size="sm"
                    role="status"
                    aria-hidden="true"
                  />
                )}
                {buttonValue}
              </button>
            </div>
          </div>
        </form>
      </Card.Body>

    <ToastContainer className="p-3 text-light" position="middle-center">
        <Toast
          onClose={() => {
            setShow(false);
          }}
          show={show}
          className="d-inline-block m-1"
          bg={variant}
        >
          <Toast.Header>
            <strong className="me-auto">Wedding Registration</strong>
          </Toast.Header>
          <Toast.Body className="text-white">{responseMessage}</Toast.Body>
        </Toast>
      </ToastContainer>
    </React.Fragment>
  );
}

const useFormInput = (initialValue) => {
  const [value, setValue] = useState(initialValue);

  const handleChange = (e) => {
    setValue(e.target.value);
  };
  return {
    value,
    onChange: handleChange,
    setValue
  };
};
