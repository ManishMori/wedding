import React from "react";
import { Card, Col, Container, Row } from "react-bootstrap";

import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

import Header from "../../components/header/header";
import sendCertificate from "../../solana/sendCertificate";

const Dashboard = (props) => {
  
  const user = JSON.parse(localStorage.getItem("user"));
  const printDocument = () => {
    sendCertificate.sendCertificate().then((response) => { 
      const signature = response 
      const input = document.getElementById('divToPrint');
      html2canvas(input)
        .then((canvas) => {
          const imgData = canvas.toDataURL('image/png');
          const pdf = new jsPDF({orientation: "landscape"});
          pdf.addImage(imgData, 'JPEG', 10, 10);
          pdf.output('dataurlnewwindow');
          pdf.save(signature+".pdf");
        });
      });
  }

  return (
    <div>
      <Header />
      <main role="main" className="inner cover">
        <main className="main d-flex align-items-center">
        <div className="mb5">
        <button onClick={printDocument}>Print</button>
      </div>
          <div className="container">
            <div className="row">
              <div className="col-md-10 mx-auto">
                <Card
                id="divToPrint"
                  className="mt-5"
                  style={{
                    height: "500px",
                    backgroundImage: "url('images/cert-bg.jpg')",
                    backgroundPosition: "center",
                    backgroundRepeat: "no-repeat",
                    backgroundSize: "100% 100%",
                    fontStyle: "oblique",
                    fontFamily: "serif",
                  }}
                >
                  <Card.Body>
                      <Container>
                          <Row>
                            <Col className="text-center pt-4">
                                <h1 className="display-3 text-dark "> Certificate of Marriage </h1>
                            </Col>
                          </Row>

                          <Row>
                            <Col xs={1}></Col>
                            <Col xs={10} className="text-center pt-4">
                                <h3 className="text-dark "> {user.firstName} {user.lastName} and Partner Name </h3>
                            </Col>
                          </Row>

                          <Row>
                            <Col xs={1}></Col>
                            <Col xs={10} className="text-center pt-4">
                                <h5 className="text-dark"> {user.marriageDate.month} {user.marriageDate.dayOfMonth}, {user.marriageDate.year} </h5>
                            </Col>
                          </Row>

                          <Row>
                            <Col xs={12} className="text-center pt-4">
                                <img src="/images/ring-3.png" height="100px" width="100px" alt="ring"></img>
                            </Col>
                          </Row>

                          <Row>
                            <Col xs={1} className="pt-5"></Col>
                            <Col xs={5} className="text-center pt-5">
                                <h5 className="text-dark"> Partner-1 ContractID.......... </h5>
                            </Col>
                            <Col xs={5} className="text-center pt-5">
                                <h5 className="text-dark"> Partner-2 ContractID.......... </h5>
                            </Col>
                          </Row>
                      </Container>
                  </Card.Body>
                </Card>
              </div>
            </div>
          </div>
        </main>
      </main>
    </div>
  );
};

export default Dashboard;
