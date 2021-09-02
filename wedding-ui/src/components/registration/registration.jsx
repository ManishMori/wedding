import React, { useState } from "react";

import FormControl from "react-bootstrap/FormControl";
import Card from "react-bootstrap/Card";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Form from "react-bootstrap/Form";
import FloatingLabel from "react-bootstrap/esm/FloatingLabel";
import { InputGroup, Spinner, Toast, ToastContainer } from "react-bootstrap";

import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

import RegistrationService from "../../services/registration/RegistrationService";

export default function Registration() {
  const firstName = useFormInput("");
  const lastName = useFormInput("");
  const email = useFormInput("");
  const gender = useFormInput("");
  const password = useFormInput("");
  const confirmPassword = useFormInput("");

  const spouseId = useFormInput("");

  const [isLoading, setLoading] = useState(false);
  const [buttonValue, setButtonValue] = useState("Register");

  const [dateOfBirth, setDateOfBirth] = useState(new Date());
  const [dateOfMarriage, setDateOfMarriage] = useState(new Date());

  const [adharcard, setAdharcard] = useState(null);
  const [marriagePicture, setMarriagePicture] = useState(null);

  const [show, setShow] = useState(false);
  const [variant, setVariant] = useState("");
  const [responseMessage, setResponseMessage] = useState("");

  const handleRegistration = (event) => {
    event.preventDefault();

    setLoading(true);
    setButtonValue(" Savig...");

    let f = new Intl.DateTimeFormat("en");

    const formData = new FormData();
    formData.append("firstName", firstName.value);
    formData.append("lastName", lastName.value);
    formData.append("email", email.value);
    formData.append("gender", gender.value);
    formData.append("password", password.value);
    formData.append("DOB", f.format(dateOfBirth));
    formData.append("marriageDate", f.format(dateOfMarriage));

    if (spouseId.value !== "") {
      formData.append("partnerUserId.id", spouseId.value);
    }

    formData.append("documentAadhar", adharcard);
    formData.append("documentMariagePicture", marriagePicture);


    firstName.setValue('');
    lastName.setValue('');
    email.setValue('');
    gender.setValue('');
    password.setValue('');
    confirmPassword.setValue('');

    spouseId.setValue('');

    setAdharcard(null)
    setMarriagePicture(null)

    RegistrationService.userRegistration(formData)
      .then((response) => {
        console.log(JSON.stringify(response.data));
        console.log(response.status);
        console.log(response.statusText);
        console.log(response.headers);
        console.log(response.config);

        setShow(true);
        if (response.status === 200) {
          setVariant("success");
          setResponseMessage(
            "You Registration are Successfull! For wedding registration login in your account with username and password."
          );
        } else {
          setVariant("danger");
          setResponseMessage(
            "You Registration Failed! Please try again or contact support."
          );
        }
        setButtonValue("Register");
        setLoading(false);
      })
      .catch((error) => {
        console.error(error);

        setButtonValue("Register");
        setLoading(false);

        setShow(true);
        setVariant("danger");
        setResponseMessage(
          "You Registration Failed! Please try again or contact support."
        );
      });
  };

  return (
    <React.Fragment>
      <Card.Body>
        <p className="text-warning">
          <b>Sign Up</b>
        </p>
        <form onSubmit={handleRegistration}>
          <Row>
            <Col xs={6}>
              <FloatingLabel
                controlId="floatingInput"
                label="First Name"
                className="mb-3"
              >
                <FormControl
                  type="text"
                  required
                  aria-label="FirstName"
                  aria-describedby="basic-addon1"
                  placeholder="First Name"
                  autoComplete="firstName"
                  name="firstName"
                  {...firstName}
                />
              </FloatingLabel>
            </Col>

            <Col xs={6}>
              <FloatingLabel
                controlId="floatingInput"
                label="Last Name"
                className="mb-3"
              >
                <FormControl
                  type="text"
                  required
                  aria-label="LastName"
                  aria-describedby="basic-addon1"
                  placeholder="Last Name"
                  autoComplete="lastName"
                  name="lastName"
                  {...lastName}
                />
              </FloatingLabel>
            </Col>
          </Row>

          <Row>
            <Col xs={6}>
              <FloatingLabel
                controlId="floatingInput"
                label="Email address"
                className="mb-3"
              >
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
              </FloatingLabel>
            </Col>
            <Col xs={6}>
              <FloatingLabel controlId="floatingSelect" label="Gender">
                <Form.Select
                  aria-label="Floating label select example"
                  {...gender}
                >
                  <option value="1">Male</option>
                  <option value="2">Female</option>
                  <option value="3">Other</option>
                </Form.Select>
              </FloatingLabel>
            </Col>
          </Row>

          <Row>
            <Col xs={6}>
              <FloatingLabel
                controlId="floatingInput"
                label="Password"
                className="mb-3"
              >
                <FormControl
                  type="password"
                  required
                  aria-label="Password"
                  aria-describedby="basic-addon1"
                  placeholder="Password"
                  name="password"
                  {...password}
                />
              </FloatingLabel>
            </Col>

            <Col xs={6}>
              <FloatingLabel
                controlId="floatingInput"
                label="Confirm Password"
                className="mb-3"
              >
                <FormControl
                  type="password"
                  required
                  aria-label="ConfirmPassword"
                  aria-describedby="basic-addon1"
                  placeholder="Confirm Password"
                  name="confirmPassword"
                  {...confirmPassword}
                />
              </FloatingLabel>
            </Col>
          </Row>

          <Row>
            <Col xs={6}>
              <p className="text-light">Date of Birth</p>
              <DatePicker
                selected={dateOfBirth}
                onChange={(date) => setDateOfBirth(date)}
              />
            </Col>

            <Col xs={6}>
              <p className="text-light">Date of Marriage</p>
              <DatePicker
                selected={dateOfMarriage}
                onChange={(date) => setDateOfMarriage(date)}
                dateFormat="MM/dd/yyyy"
              />
            </Col>
          </Row>
          <br />

          <Row className="mb-3">
            <Col>
              <Form.Label htmlFor="basic-url" className="text-light">
                If your spouse already register with this system.
              </Form.Label>
              <InputGroup className="mb-3">
                <InputGroup.Text id="basic-addon3">
                  Spouse Registration Id
                </InputGroup.Text>
                <FormControl
                  aria-label="SpouseId"
                  aria-describedby="basic-addon1"
                  placeholder="Enter spouse Id"
                  autoComplete="spouseId"
                  name="spouseId"
                  {...spouseId}
                />
              </InputGroup>
            </Col>
          </Row>

          <Row>
            <Col>
              <Form.Group className="position-relative mb-3">
                <Form.Label className="text-light">Upload Aadharcard</Form.Label>
                <Form.Control
                  type="file"
                  required
                  name="file"
                  onChange={(event) => {
                    setAdharcard(event.target.files[0]);
                  }}
                />
              </Form.Group>
            </Col>
          </Row>

          <Row>
            <Col>
              <Form.Group className="position-relative mb-3">
                <Form.Label className="text-light">
                  Upload Marriage Picture
                </Form.Label>
                <Form.Control
                  type="file"
                  required
                  name="file"
                  onChange={(event) => {
                    setMarriagePicture(event.target.files[0]);
                  }}
                />
              </Form.Group>
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
