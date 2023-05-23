package com.taras_overmind.scheduleApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping("/smthing")
    public String getString(){
        return "abcdefghijklmnopqrstuvwxyz";
    }
}
