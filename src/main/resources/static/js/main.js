const Main = () => (
    <div>
        <h1>Hello lol</h1>
        <form action="/signin/twitter" method="post">
            <button type="submit">Login</button>
        </form>
    </div>
);

fetch('/api/session', {credentials: 'same-origin'})
    .then(res => res.json())
    .then((r) => console.log(r));
//fetch('/signin/twitter', {method: 'post'})
//    .then(res => res.json())
//    .then((r) => console.log(r));


ReactDOM.render(<Main />, document.getElementById('container'));