package com.example.assignment2.controller;

import com.example.assignment2.model.Subscription;
import com.example.assignment2.repository.SubscriptionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(SubscriptionController.class)
public class SubscriptionControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubscriptionRepository subscriptionRepository;

    @Test
    public void getAllSubscriptions_sucess() throws Exception {


        Subscription firstSubscription = new Subscription();
            firstSubscription.setSub_id(1L);
            firstSubscription.setSub_name("First Subscription");
            firstSubscription.setSub_type("Health");
            firstSubscription.setMembership("active");

        Subscription secondSubscription = new Subscription();
            secondSubscription.setSub_id(2L);
            secondSubscription.setSub_name("Second Subscription");
            secondSubscription.setSub_type("Entertainment");
            secondSubscription.setMembership("active");

    }
}
