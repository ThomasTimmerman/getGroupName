<<<<<<< .merge_file_6hYwmL
import React, { Component } from "react";
import { Link } from "react-router-dom";

class WelcomeComponent extends Component {
  render() {
    return (
      <>
        <h1>Welcome!</h1>
        <div className="container">
          Welcome {this.props.match.params.name}. You can manage your demos{" "}
          <Link to="/FileUpload">here</Link>.
        </div>
      </>
    );
  }
}

export default WelcomeComponent;
=======
import React, {Component} from 'react'
import {Link} from 'react-router-dom'


class WelcomeComponent extends Component {
    render() {
        return (
            <>
                <h1>Welcome!</h1>
                <div className="container">
                    Welcome {this.props.match.params.name}. 
                    You can manage your demos <Link to="/demodrop">here</Link>.
                </div>
                
            </>
        )        
    }

}


export default WelcomeComponent
>>>>>>> .merge_file_mkw5x2
