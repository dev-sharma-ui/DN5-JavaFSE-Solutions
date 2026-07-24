function Employee(props) {
  return (
    <div>
      <h2>Employee Details</h2>

      <p><strong>ID:</strong> {props.id}</p>
      <p><strong>Name:</strong> {props.name}</p>
      <p><strong>Department:</strong> {props.department}</p>
      <p><strong>Salary:</strong> ₹{props.salary}</p>
    </div>
  );
}

export default Employee;