package com.example.backend.service;


import com.example.backend.model.Customer;
import com.example.backend.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return all;
    }


    public List<Customer> filteredCustomers(List<Customer> customers, String countryFilter, String stateFilter) {
        Country country = this.countryNum(countryFilter);
        State valid = this.stateNum(stateFilter);

        if (country == Country.Unkown && valid == State.DontCare)
            return customers;

        List<Customer> filteredList = new ArrayList<Customer>();
        customers.forEach(customer -> {

            String countryCodeRegex = this.getCountryCodeRegex(country);
            if (customer.getPhone().matches(countryCodeRegex)) {
                if (this.checkRowValidity(customer, country, valid))
                    filteredList.add(customer);
            }
        });

        return filteredList;
    }

    // If it's correct for a given country
    public boolean isValid(Customer customer, Country country) {
        String countryRegex = this.getCountryRegex(country);
        if (customer.getPhone().matches(countryRegex))
            return true;
        return false;
    }

    public State stateNum(String valid) {
        if (valid != null) {
            if (valid.equals("valid"))
                return State.Valid;
            else if (valid.equals("invalid"))
                return State.Invalid;
        }
        return State.DontCare;
    }

    public Country countryNum(String country) {
        if (country != null) {
            if (country.equals("Cameroon")) return Country.Cameroon;
            else if (country.equals("Ethiopia")) return Country.Ethiopia;
            else if (country.equals("Morocco")) return Country.Morocco;
            else if (country.equals("Mozambique")) return Country.Mozambique;
            else if (country.equals("Uganda")) return Country.Uganda;
        }
        return Country.Unkown;
    }

    public boolean checkRowValidity(Customer customer, Country country, State valid) {
        if (valid != State.DontCare) {
            boolean okayPhone = this.isValid(customer, country);
            if ((valid == State.Valid && okayPhone) || (valid == State.Invalid && !okayPhone))
                return true;
        } else {
            return true;
        }
        return false;
    }

    private String getCountryRegex(Country country) {
        final String CameroonValidRegex = "\\(237\\)\\ ?[2368]\\d{7,8}$";
        final String EthiopiaValidRegex = "\\(251\\)\\ ?[1-59]\\d{8}$";
        final String MoroccoValidRegex = "\\(212\\)\\ ?[5-9]\\d{8}$";
        final String MozambiqueValidRegex = "\\(258\\)\\ ?[28]\\d{7,8}$";
        final String UgandaValidRegex = "\\(256\\)\\ ?[2368]\\d{9}$";
        switch (country) {
            case Cameroon:
                return CameroonValidRegex;
            case Ethiopia:
                return EthiopiaValidRegex;
            case Morocco:
                return MoroccoValidRegex;
            case Mozambique:
                return MozambiqueValidRegex;
            case Uganda:
                return UgandaValidRegex;
            default:
                return "";
        }
    }

    private String getCountryCodeRegex(Country country) {
        final String cameroonRegex = "^\\(237\\).*$";
        final String ethiopiaRegex = "^\\(251\\).*$";
        final String moroccoRegex = "^\\(212\\).*$";
        final String mozambiqueRegex = "^\\(258\\).*$";
        final String ugandaRegex = "^\\(256\\).*$";
        switch (country) {
            case Cameroon:
                return cameroonRegex;
            case Ethiopia:
                return ethiopiaRegex;
            case Morocco:
                return moroccoRegex;
            case Mozambique:
                return mozambiqueRegex;
            case Uganda:
                return ugandaRegex;
            default:
                return "";
        }


    }
}

enum Country {
    Cameroon,
    Ethiopia,
    Morocco,
    Mozambique,
    Uganda,
    Unkown,
}

enum State {
    Valid,
    Invalid,
    DontCare
}
