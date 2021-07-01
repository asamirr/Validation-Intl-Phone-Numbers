package com.example.backend.controller;
import java.util.List;

import com.example.backend.service.CustomerService;
import com.example.backend.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public List<Customer> getCustomers(@RequestParam(name="country", required = false) String country,
                                       @RequestParam(name="valid", required = false) String valid){

        List<Customer> customers = customerService.getAllCustomers();
        return customerService.filteredCustomers(customers, country, valid);
    }

}



//import com.example.backend.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
////@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//@CrossOrigin
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping(value = "/list")
//    public ResponseEntity<List<String>> getAllValidPhoneNumbers() {
//        return ResponseEntity.ok(customerService.getAllValidPhoneNumbers());
//    }
//
//
//}