package com.example.assignment2.controller;

import com.example.assignment2.model.Subscription;
import com.example.assignment2.repository.SubscriptionRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@WebMvcTest(SubscriptionController.class)    //used to simulate actual http behaviour
public class SubscriptionControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean //to mock repo and inject into controller
    private SubscriptionRepository subscriptionRepository;

    @Test
    public void getAllSubscriptions_success() throws Exception {  //creating mock data

        val firstSubscription = new Subscription();
            firstSubscription.setSub_id(1L);
            firstSubscription.setSub_name("First Subscription");
            firstSubscription.setSub_type("Health");
            firstSubscription.setMembership("active");

        val secondSubscription = new Subscription();
            secondSubscription.setSub_id(2L);
            secondSubscription.setSub_name("Second Subscription");
            secondSubscription.setSub_type("Entertainment");
            secondSubscription.setMembership("active");

            //mock call of mock repo
            when(subscriptionRepository.findAll()).thenReturn(List.of(firstSubscription, secondSubscription));
            // simulate get req and validate response
            mockMvc.perform(get("/mysubs"))
                    .andExpect(status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();

    }
}
