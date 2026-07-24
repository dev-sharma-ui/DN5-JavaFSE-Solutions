import Employee from "./components/Employee";

function App() {
  return (
    <>
      <h1>Exercise 4 - Props Demo</h1>

      <Employee
        id={101}
        name="Rahul Sharma"
        department="Java FSE"
        salary={50000}
      />
    </>
  );
}

export default App;