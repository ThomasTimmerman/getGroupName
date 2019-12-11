import React, { Component } from "react";

class SignupComponent extends Component {
  constructor(props) {
    super(props);
    this.state = { name: "", email: "", password: "" };
  }

  signupClicked() {
    this.props.history.push(`/login`);
  }

  handleChange = event => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = event => {
    event.preventDefault();
    var user = {
      name: this.state.name,
      email: this.state.email,
      password: this.state.password
    };
    fetch("http://localhost:8081/api/user", {
      method: "post",
      body: JSON.stringify(user),
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      }
    }).then(function(response) {
      return response;
    });
    this.props.history.push(`/login`);
  };

  render() {
    return (
      <div>
        <h3>Add User</h3>
        <form>
          <input
            type="text"
            placeholder="Name"
            name="name"
            onChange={this.handleChange}
          />
          <br />
          <input
            type="text"
            placeholder="Email"
            name="email"
            onChange={this.handleChange}
          />
          <br />
          <input
            type="password"
            placeholder="Password"
            name="password"
            onChange={this.handleChange}
          />
          <br />
          <button onClick={this.handleSubmit}>Sign Up</button>
        </form>
      </div>
    );
  }
}

export default SignupComponent;
