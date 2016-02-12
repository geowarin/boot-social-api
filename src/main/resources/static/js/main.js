const LoginForm = () => (
    <form action="/signin/twitter" method="post">
        <h1>Please login</h1>
        <button type="submit">Login</button>
    </form>
);

const LogoutComponent = (props) => (
    <div>
        <h2>Your name is {props.name}</h2>
        <button onClick={props.logout}>Logout</button>
    </div>
);

class Main extends React.Component {

    constructor(...args) {
        super(...args);
        this.state = {name: null};
    }

    componentDidMount() {
        fetch('/api/session', {credentials: 'same-origin'})
            .then(res => res.json())
            .then(session => this.setState({name: session.name}));
    }

    logout() {
        console.log("logout");
        fetch('/api/session', {method: 'delete', credentials: 'same-origin'})
            .then(res => this.setState({name: null}));
    }

    render() {
        const profile = this.state.name ?
            <LogoutComponent name={this.state.name} logout={() => this.logout()}/> :
            <LoginForm />;
        return (
            <div>
                {profile}
            </div>
        )
    }
}

ReactDOM.render(<Main />, document.getElementById('container'));