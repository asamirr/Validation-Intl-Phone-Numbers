package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    @Autowired
    private ConfigUtility configUtility;

    public boolean validate(String phoneNumber)
    {
        //split to get the country code
        if (phoneNumber==null || phoneNumber.isEmpty() || !phoneNumber.contains(")"))
        {
            return false;
        }

        String countryCode = phoneNumber.substring(1, phoneNumber.indexOf(")"));
        if(countryCode==null || countryCode.isEmpty())
        {
            return false;
        }

        String regex=configUtility.getProperty(countryCode);
        if(regex==null || regex.isEmpty())
        {
            return false;
        }

        // validate with the expression
        return phoneNumber.matches(regex);
    }

}