package com.sujal.DigitalJavaAssessment.resource;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sujal.DigitalJavaAssessment.dto.AccountPOJO;
import com.sujal.DigitalJavaAssessment.dto.CustomerAccountPOJO;
import com.sujal.DigitalJavaAssessment.dto.CustomerPOJO;
import com.sujal.DigitalJavaAssessment.model.Account;
import com.sujal.DigitalJavaAssessment.model.Customer;
import com.sujal.DigitalJavaAssessment.service.AccountService;
import com.sujal.DigitalJavaAssessment.util.ApiConstant;
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
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @InjectMocks
    private AccountController accountController;

    @Mock
    private AccountService accountService;

    private MockMvc mockMvc;

    private CustomerAccountPOJO customerAccountPOJO;
    private CustomerPOJO customerPOJO;
    private AccountPOJO accountPOJO;
    private Customer customer;
    private Account account;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders
                .standaloneSetup(accountController)
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
        customerPOJO.setMessage(ApiConstant.SUCCESS);

        accountPOJO = new AccountPOJO();
        accountPOJO.setAccount(account);
        accountPOJO.setStatusCode(200);
        accountPOJO.setMessage(ApiConstant.SUCCESS);
    }

    @Test
    public void testGetCustomersWithNoContent() throws Exception {
        Mockito.when(accountService.getAccount("12345")).thenReturn(Optional.ofNullable(null));
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/12345")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andReturn();

        Mockito.verify(accountService).getAccount("12345");
    }

    @Test
    public void testGetCustomersWithContent() throws Exception {
        Mockito.when(accountService.getAccount("01223455")).thenReturn(Optional.of(accountPOJO));
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/01223455")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Mockito.verify(accountService).getAccount("01223455");
    }

    @Test
    public void testSaveCustomerWithSuccess() throws Exception {
        Mockito.when(accountService.save(account)).thenReturn(Optional.ofNullable(null));

        mockMvc.perform(MockMvcRequestBuilders.post("/accounts")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(account)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Mockito.verify(accountService).save(account);
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
