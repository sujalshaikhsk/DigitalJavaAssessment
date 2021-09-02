package com.sujal.DigitalJavaAssessment.resource;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sujal.DigitalJavaAssessment.dto.CustomerAccountPOJO;
import com.sujal.DigitalJavaAssessment.dto.CustomerPOJO;
import com.sujal.DigitalJavaAssessment.model.Account;
import com.sujal.DigitalJavaAssessment.model.Customer;
import com.sujal.DigitalJavaAssessment.service.CustomerService;
import com.sujal.DigitalJavaAssessment.util.StringConstant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    private MockMvc mockMvc;

    private CustomerAccountPOJO customerAccountPOJO;
    private CustomerPOJO customerPOJO;
    private Customer customer;
    private Account account;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders
                .standaloneSetup(customerController)
                .build();

        customerAccountPOJO = new CustomerAccountPOJO();
        customer = new Customer();
        customer.setCustomerid("123");
        customer.setTitle("Mx");
        customer.setFirstname("test");
        customer.setLastname("testlastname");
        customer.setGender("Non-Binary");

        account = new Account();
        account.setAccountno("01223455");
        account.setBsb("923100");
        account.setBalance(100D);
        account.setName("SM");
        account.setCustomer(customer);

        Set<Account> accounts = new HashSet<>();
        accounts.add(account);
        //customer.setAccounts(accounts);

        BeanUtils.copyProperties(customer, customerAccountPOJO);

        customerPOJO = new CustomerPOJO();
        customerPOJO.setCustomerList(Arrays.asList(customer));
        customerPOJO.setStatusCode(200);
        customerPOJO.setMessage(StringConstant.SUCCESS);
    }

    @Test
    public void testGetCustomersWithNoContent() throws Exception {
        Mockito.when(customerService.getCustomers()).thenReturn(Optional.ofNullable(null));
        mockMvc.perform(MockMvcRequestBuilders.get("/customers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andReturn();

        Mockito.verify(customerService).getCustomers();
    }

    @Test
    public void testGetCustomersWithContent() throws Exception {
        Mockito.when(customerService.getCustomers()).thenReturn(Optional.of(customerPOJO));
        mockMvc.perform(MockMvcRequestBuilders.get("/customers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Mockito.verify(customerService).getCustomers();
    }

    @Test
    public void testSaveCustomerWithSuccess() throws Exception {
        Mockito.when(customerService.save(customer)).thenReturn(Optional.ofNullable(null));

        mockMvc.perform(MockMvcRequestBuilders.post("/customers")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(customer)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Mockito.verify(customerService).save(customer);
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
