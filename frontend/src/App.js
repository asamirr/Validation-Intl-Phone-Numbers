import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Row } from 'react-bootstrap';
import TodoApp from './phoneList';
import './App.css';
// import Pagination from 'react-bootstrap/Pagination'

function App() {
  return (
    <div className="App">
      <Container>
        <Row className="mx-auto">
          <h3 class="display-4" style={{textAlign:"center"}}>Jumia Validation</h3> 
        </Row>
        <Row>
          <TodoApp/>
        </Row>
      </Container>
    </div>
  );
}

export default App;