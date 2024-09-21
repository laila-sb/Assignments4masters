package com.example.assignment2.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SubscriptionController {
    @PostMapping("/sub")
    public String sub(){
        return "sub";

    }

    @GetMapping("/sub")
    public String sub2(){
        return "sub2";
    }
}
