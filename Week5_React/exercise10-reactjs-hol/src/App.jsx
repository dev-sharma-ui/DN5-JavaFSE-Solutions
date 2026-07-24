function App() {

  const employees = [
    { id: 101, name: "Rahul", department: "Java" },
    { id: 102, name: "Ankit", department: "React" },
    { id: 103, name: "Priya", department: "Python" },
    { id: 104, name: "Neha", department: "Testing" },
  ];

  return (
    <div style={{ textAlign: "center" }}>
      <h1>Exercise 10 - Employee List</h1>

      <ul style={{ listStyle: "none" }}>
        {employees.map((employee) => (
          <li key={employee.id}>
            {employee.id} - {employee.name} - {employee.department}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;