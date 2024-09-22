package com.example.assignment2.Controller;

import com.example.assignment2.model.Subscription;
import com.example.assignment2.repository.SubscriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SubscriptionController {


    @Autowired  // in order to use the repo in the controller class
    private SubscriptionRepository subscriptionRepository;

    @GetMapping("/mysubs")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

//    @PostMapping("/sub")
//    public ResponseEntity<Subscription> sub(@RequestParam String subName, @RequestParam String subType) {
//        return ResponseEntity.ok(new Subscription());
//
//    }
    @DeleteMapping
private void deleteSubscription(@PathVariable int sub_id){
    }
}
