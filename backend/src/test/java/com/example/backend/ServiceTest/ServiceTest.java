package com.example.backend.ServiceTest;

import com.example.backend.model.Customer;
import com.example.backend.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private CustomerService customerService;

    List<Customer> customerTestList = new ArrayList<Customer>(
            Arrays.asList(
                    // Valid Cameroon
                    new Customer(31, "EMILE CHRISTIAN KOUKOU DIKANDA HONORE", "(237) 697151594"),
                    new Customer(32, "MICHAEL MICHAEL", "(237) 677046616"),
                    // Invalid Cameroon
                    new Customer(33, "ARREYMANYOR ROLAND TABOT", "(237) 6A0311634"),
                    new Customer(33, "SUGAR STARRK BARRAGAN", "(237) 6780009592"),

                    // Valid Ethiopia
                    new Customer(23, "Filimon Embaye", "(251) 914701723"),
                    new Customer(24, "ABRAHAM NEGASH", "(251) 911203317"),
                    // Invalid Ethiopia
                    new Customer(22, "shop23 sales", "(251) 9773199405"),
                    new Customer(25, "ZEKARIAS KEBEDE", "(251) 9119454961"),

                    // Valid Morocco
                    new Customer(1, "Yosaf Karrouch", "(212) 698054317"),
                    new Customer(4, "Chouf Malo", "(212) 691933626"),
                    // Invalid Morocco
                    new Customer(0, "Walid Hammadi", "(212) 6007989253"),
                    new Customer(2, "Younes Boutikyad", "(212) 6546545369"),

                    // Valid Mozamabique
                    new Customer(7, "Edunildo Gomes Alberto", "(258) 847651504"),
                    new Customer(8, "Walla's Singz Junior", "(258) 846565883"),
                    // Invalid Mozambique
                    new Customer(10, "Tanvi Sachdeva", "(258) 84330678235"),
                    new Customer(12, "Solo Dolo", "(258) 042423566"),

                    // Valid Uganda
                    new Customer(20, "pt shop 0901 Ultimo", "(256) 3142345678"),
                    // Invalid Uganda
                    new Customer(15, "JACKSON NELLY", "(256) 775069443"),
                    new Customer(16, "Kiwanuka Budallah", "(256) 7503O6263")
            )
    );
    @Test
    void cameroonTest(){

        // Toggling between validity to get list size for Cameroon
        List<Customer> validCameroon = customerService.filteredCustomers(customerTestList, "Cameroon", "valid");
        assertThat(validCameroon.size(), is(2));
        List<Customer> invalidCameroon = customerService.filteredCustomers(customerTestList, "Cameroon", "invalid");
        assertThat(invalidCameroon.size(), is(2));

    }
    @Test
    void ethiopiaTest(){

        // Toggling between validity to get list size for Ethiopia
        List<Customer> validEthiopia = customerService.filteredCustomers(customerTestList, "Ethiopia", "valid");
        assertThat(validEthiopia.size(), is(2));
        List<Customer> invalidEthiopia = customerService.filteredCustomers(customerTestList, "Ethiopia", "invalid");
        assertThat(invalidEthiopia.size(), is(2));

    }
    @Test
    void moroccoTest(){

        // Toggling between validity to get list size for Morocco
        List<Customer> validMorocco = customerService.filteredCustomers(customerTestList, "Morocco", "valid");
        assertThat(validMorocco.size(), is(2));
        List<Customer> invalidMorocco = customerService.filteredCustomers(customerTestList, "Morocco", "invalid");
        assertThat(invalidMorocco.size(), is(2));

    }
    @Test
    void mozambiqueTest(){

        // Toggling between validity to get list size for Mozambique
        List<Customer> validMozambique = customerService.filteredCustomers(customerTestList, "Mozambique", "valid");
        assertThat(validMozambique.size(), is(2));
        List<Customer> invalidMozambique = customerService.filteredCustomers(customerTestList, "Mozambique", "invalid");
        assertThat(invalidMozambique.size(), is(2));

    }
    @Test
    void ugandaTest(){

        // Toggling between validity to get list size for Uganda
        List<Customer> validUganda = customerService.filteredCustomers(customerTestList, "Uganda", "valid");
        assertThat(validUganda.size(), is(1));
        List<Customer> invalidUganda = customerService.filteredCustomers(customerTestList, "Uganda", "invalid");
        assertThat(invalidUganda.size(), is(2));

    }
    @Test
    void countryStateTest(){

        // misspelling country name
        List<Customer> wrongCountry = customerService.filteredCustomers(customerTestList, "iganda", "valid");
        assertThat(wrongCountry.size(), is(0));
//      ----------------------------------------->
//        // misspelling state
        List<Customer> wrongState = customerService.filteredCustomers(customerTestList, "Uganda", null);
        assertThat(wrongState.size(), is(3));

    }
    @Test
    void listTotalTest(){

        // Total number of customers entered
        List<Customer> all = customerService.filteredCustomers(customerTestList, null, null);
        assertThat(all.size(), is(19));

    }
}
