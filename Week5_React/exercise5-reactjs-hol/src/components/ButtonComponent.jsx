function ButtonComponent() {

    function handleClick() {
        alert("Hello from React!");
    }

    return (
        <div>
            <button onClick={handleClick}>
                Click Me
            </button>
        </div>
    );
}

export default ButtonComponent;