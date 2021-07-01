// import React from 'react';
// import { Container } from 'react-bootstrap';
import axios from 'axios';

const apiBaseURL = "http://localhost:8080/";

const getCustomers = ({country, valid}) => {
    let url = '/customers';
    //get to know which country to filter
    if(country && country !== "all"){
        url = `${url}?country=${country}`;
    }
    
    // Then according to the country, get the state
    if(valid && valid !== "all"){
        if(country && country !== "all"){
            url = `${url}&valid=${valid}`;            
        }
        else{
            url = `${url}?valid=${valid}`;
        }
    }
    return axios.get(`${apiBaseURL}/${url}`);
};
export default getCustomers;