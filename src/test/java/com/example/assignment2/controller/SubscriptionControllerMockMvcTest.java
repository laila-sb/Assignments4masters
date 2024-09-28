package com.example.assignment2.controller;

import com.example.assignment2.model.Subscription;
import com.example.assignment2.repository.SubscriptionRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(SubscriptionController.class)    //used to simulate actual http behaviour
public class SubscriptionControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean //to mock repo and inject into controller
    private SubscriptionRepository subscriptionRepository;

    @Test
    public void getAllSubscriptions_then_AllSubscriptionsReturned() throws Exception {  //creating mock data

        val firstSubscription = new Subscription();
            firstSubscription.setSubId(1L);
            firstSubscription.setSubName("First Subscription");
            firstSubscription.setSubType("Health");
            firstSubscription.setMembership("active");

        val secondSubscription = new Subscription();
            secondSubscription.setSubId(2L);
            secondSubscription.setSubName("Second Subscription");
            secondSubscription.setSubType("Entertainment");
            secondSubscription.setMembership("active");

            //mock call of mock repo
            when(subscriptionRepository.findAll()).thenReturn(List.of(firstSubscription, secondSubscription));
            //  mvc request builder, simulate get req and validate response
            mockMvc.perform(get("/mysubs"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.length()").value(2))
                    .andExpect(jsonPath("$[0].subName").value("First Subscription"))
                    .andExpect(jsonPath("$[0].subType").value("Health"))
                    .andExpect(jsonPath("$[0].membership").value("active"))
                    .andExpect(jsonPath("$[1].subName").value("Second Subscription"))
                    .andExpect(jsonPath("$[1].subType").value("Entertainment"))
                    .andExpect(jsonPath("$[1].membership").value("active"));
    }
    @Test
    public void getAllSubscriptions_emptyListReturned() throws Exception {
        when(subscriptionRepository.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/mysubs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

    }

    @Test
    public void getAllSubscription_invalidEndpoint() throws Exception { // no need to mock the repo, controller will never reach it
        mockMvc.perform(get("/invalidEndpoint"))
                .andExpect(status().isNotFound());
    }
}
