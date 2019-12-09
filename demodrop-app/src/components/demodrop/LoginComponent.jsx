import React, {Component} from 'react'
import AuthenticationService from './AuthenticationService'

class LoginComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            username: 'getgroupname',
            password: '',
            hasLoginFailed: false,
            showSuccesMessage: false
        }

        this.handleChange = this.handleChange.bind(this)
        this.loginClicked = this.loginClicked.bind(this)

    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]
                    : event.target.value
            }
        )
    }

    loginClicked() {
        if (this.state.username === 'getgroupname' && this.state.password === 'dummy') {
            AuthenticationService.registerSuccesfulLogin(this.state.username, this.state.password)
            this.props.history.push(`/welcome/${this.state.username}`)

        }
        else {
            console.log('Failed')
            this.setState({ showSuccesMessage: false })
            this.setState({ hasLoginFailed: true })
        }
    }

    render() {
        return (
            <div>
    
                <div className="container box-background">
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                    {this.state.showSuccesMessage && <div>Login Succesful</div>}
                    <input type="text" class="form-control margin-top-20" placeholder="User Name" name="username" value={this.state.username} onChange={this.handleChange} />
                    <input type="password" class="form-control margin-top-20" placeholder="Password" name="password" value={this.state.password} onChange={this.handleChange} />
                    <button className="btn btn-outline-light btn-lg btn-block margin-top-20" onClick={this.loginClicked}>Login</button>
                </div>
            </div>
        )
    }
}    

export default LoginComponent