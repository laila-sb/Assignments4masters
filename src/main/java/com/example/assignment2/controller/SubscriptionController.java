package com.example.assignment2.controller;

import com.example.assignment2.model.Subscription;
import com.example.assignment2.repository.SubscriptionRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class SubscriptionController {

    @Value("${server.port}")
    private int serverPort;


    private static final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired  // in order to use the repo in the controller class
    private SubscriptionRepository subscriptionRepository;

    @GetMapping("/mysubs")
    public List<Subscription> getAllSubscriptions() {
        try {
            logger.info("Retrieving all subscriptions");
            return subscriptionRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving all subscriptions", e);
        }
    }

    @GetMapping("/mysubs/active")
    public List<Subscription> getAllActiveSubscriptions() {
        try {
            logger.info("Retrieving all active subscriptions");
            return subscriptionRepository.findAll().stream()
                    .filter(subscription -> "active".equals(subscription.getMembership())) // active membership filter
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving active subscriptions", e);
        }
    }

    @PostMapping("/add/sub")
    public ResponseEntity<Subscription> sub(@RequestBody Subscription subscription) {
        subscriptionRepository.save(subscription);
        logger.info("A new subscription saved to the DB");
        return ResponseEntity.ok(subscription);

    }

    public <T> ResponseEntity<String> deleteSubscriptionByIdentifier(@PathVariable T identifier) {
        try {
            if (identifier instanceof Long subId) {
                if (subscriptionRepository.existsById(subId)) {
                    subscriptionRepository.deleteById(subId);
                    logger.warn("Deleted Subscription with ID: {}", subId);
                    return ResponseEntity.ok("Subscription with ID: " + subId + " deleted successfully");
                } else {
                    logger.warn("Subscription with ID: {} not found", subId);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subscription with ID: " + subId + " not found");
                }
            } else if (identifier instanceof String subName) {
                List<Subscription> subs = subscriptionRepository.findBySubName(subName);
                if (!subs.isEmpty()) {
                    subscriptionRepository.deleteAll(subs);
                    logger.warn("Deleted Subscription with name: {}", subName);
                    return ResponseEntity.ok("Subscription with name: " + subName + " deleted successfully");
                } else {
                    logger.warn("Subscription with name: {} not found", subName);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subscription with name: " + subName + " not found");
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid identifier type");
            }
        } catch (Exception e) {
            logger.error("Error deleting subscription", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting subscription");
        }

    }

    @DeleteMapping("/mysubs/delete/{identifier}")
    public ResponseEntity<String> deleteSubscription(@PathVariable String identifier) {
            try {
                Long subId = Long.parseLong(identifier);
                return deleteSubscriptionByIdentifier(subId); // call generic method
            } catch (NumberFormatException e) {
                // If parsing fails, treat identifier as a String (for name)
                return deleteSubscriptionByIdentifier(identifier); // call generic method

            }
        }

    @PostConstruct
    public void init(){
        log.info("Server port: {}", serverPort);
    }
}
