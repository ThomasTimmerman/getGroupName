import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import AuthenticatedRoute from "./AuthenticatedRoute.jsx";
import LoginComponent from "./LoginComponent.jsx";
import ErrorComponent from "./ErrorComponent.jsx";
import HeaderComponent from "./HeaderComponent.jsx";
import LogoutComponent from "./LogoutComponent.jsx";
import WelcomeComponent from "./WelcomeComponent.jsx";
import SignupComponent from "./SignupComponent.jsx";

class TodoApp extends Component {
  render() {
    return (
      <div className="TodoApp">
        <Router>
          <>
            <HeaderComponent />
            <section class="section-1"></section>
            <div className="centered on-top inlog-box">
              <Switch>
                <Route path="/" exact component={LoginComponent} />
                <Route path="/login" component={LoginComponent} />
                <Route path="/signup" component={SignupComponent} />
                <AuthenticatedRoute
                  path="/welcome/:name"
                  component={WelcomeComponent}
                />
                <AuthenticatedRoute
                  path="/logout"
                  component={LogoutComponent}
                />

                <Route component={ErrorComponent} />
              </Switch>
            </div>
          </>
        </Router>
      </div>
    );
  }
}

export default TodoApp;
