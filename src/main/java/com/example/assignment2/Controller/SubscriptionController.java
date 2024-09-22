package com.example.assignment2.Controller;

import com.example.assignment2.model.Subscription;
import com.example.assignment2.repository.SubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SubscriptionController {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired  // in order to use the repo in the controller class
    private SubscriptionRepository subscriptionRepository;

    @GetMapping("/mysubs")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @PostMapping("/add/sub")
    public ResponseEntity<Subscription> sub(@RequestBody Subscription subscription) {
        subscriptionRepository.save(subscription);
        return ResponseEntity.ok(subscription);

    }
    @DeleteMapping("/subs/{sub_id}")
    private void deleteSubscription(@PathVariable Long sub_id){
        if (subscriptionRepository.existsById(sub_id)) {
            subscriptionRepository.deleteById(sub_id);
            logger.info("Deleted Subscription with ID: {}", sub_id);
        }else{
            logger.error("Subscription with ID: {} not found", sub_id);
        }
    }
}
