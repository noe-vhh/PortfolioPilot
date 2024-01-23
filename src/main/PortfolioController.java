package com.yourname.portfoliopilot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, PortfolioPilot!";
    }
}