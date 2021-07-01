import React from 'react';
import { Container, Row, table, Col} from 'react-bootstrap';
import './App.css';
import phoneAPI from './phoneAPI.js';

const filter = ["valid", "invalid"];
const countries = ["Cameroon", "Ethiopia", "Morocco", "Mozambique", "Uganda"];
// const [posts, setPosts] = useState([]);
// const [loading, setLoading] = useState(false);
// const [currentPage, setCurrentPage] = useState(1);
// const [postsPerPage, setPostsPerPage] = useState(10);

export default class CustomerList extends React.Component {
    state = {
      customers: [],
      country:'all',
      validity:'all'
      
    }
    
    changeCountry = (e) => {
      const country = e.target.value;
      this.setState({ country });
      phoneAPI({country,valid:this.state.validity}).then(res => {
        const customers = res.data;
        this.setState({ customers });
      });
    }
  
    changeValidity = (e) => {
      const validity = e.target.value;
      this.setState({ validity });
      phoneAPI({valid:validity,country:this.state.country}).then(res => {
        const customers = res.data;
        this.setState({ customers });
      })
    }
    componentDidMount() {
        phoneAPI({}).then(res => {
          const customers = res.data;
          this.setState({ customers });
        })
    }
  
    render() {
      return (
        <Container>
            <Row>
              <Col>
                  <select class="country" onChange={this.changeCountry}>
                      <option value="all">All Customers</option>
                      {
                          countries.map(country=>{
                              return (<option key={country} value={country}>
                                  {country}
                              </option>)
                          })
                      }
                  </select>
              </Col>
              <Col>
                  <select class="status" onChange={this.changeValidity}>
                      <option value="all">All Customers</option>
                      {
                          filter.map(status=>{
                              return (<option key={status} value={status}>
                                  {status}
                              </option>)
                          })
                      }
                  </select>
              </Col>
          </Row>
          <Row>
  
          </Row>
          <Row>
            <table class="table table-borderless table-dark">
            <caption>List of users</caption>
              <thead class="thead-dark">
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Phone</th>
                </tr>
              </thead>
              <tbody>
              {
                this.state.customers.map(customer=>{
                  return (
                    <tr key={customer.id}>
                      <td>{customer.id}</td>
                      <td>{customer.name}</td>
                      <td>{customer.phone}</td>
                    </tr>
                  )
                })
              }
              </tbody>
            </table>
          </Row>
        </Container>
      )
    }
  }