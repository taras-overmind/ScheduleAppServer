package com.taras_overmind.scheduleApp.controller;

import com.taras_overmind.scheduleApp.repository.CustomQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LecturerController {
    @Autowired
    CustomQueries customQueries;


}
