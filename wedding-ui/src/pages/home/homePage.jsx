import React, { useState } from "react";
import { Card, Tab, Tabs } from "react-bootstrap";

import Header from "../../components/header/header";
import Login from "../../components/login/login";
import Registration from "../../components/registration/registration";

import "./home.css";

const Home = (props) => {
  const [key, setKey] = useState("registration");

  return (
    <div
      id="mainDiv"
      style={{
        backgroundImage: "url('images/2.png')",
        backgroundPosition: "center",
        backgroundRepeat: "no-repeat",
        backgroundSize: "cover",
      }}
    >
      <Header />
      <main role="main" className="inner cover">
        <main className="main d-flex align-items-center">
          <div className="container">
            <div className="row">
              <div className="col-md-6 mx-auto">
                <div className="card-group">
                  <Card
                    style={{
                      marginTop: "3%",
                      marginBottom: "3%",
                      background: "rgba(0,0,0,0.8)",
                    }}
                  >
                    <Card.Header>
                      <Tabs
                        id="controlled-tab-example"
                        activeKey={key}
                        onSelect={(k) => setKey(k)}
                        className="mb-3"
                      >
                        <Tab
                          eventKey="login"
                          title="Login"
                          tabClassName="text-danger"
                        >
                          <Login />
                        </Tab>
                        <Tab
                          eventKey="registration"
                          title="Regitration"
                          tabClassName="text-danger"
                        >
                          <Registration />
                        </Tab>
                      </Tabs>
                    </Card.Header>
                  </Card>
                </div>
              </div>
            </div>
          </div>
        </main>
      </main>
    </div>
  );
};

export default Home;
