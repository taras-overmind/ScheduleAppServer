package com.taras_overmind.scheduleApp.controller;

import com.taras_overmind.scheduleApp.repository.CustomQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    CustomQueries customQueries;
    @GetMapping("/smthing")
    public String getString(){
        return "abcdefghijklmnopqrstuvwxyz";
    }
    @GetMapping("/subjects")
    public List<List<String>> getSubjects(Long group_id, int weekDay){
        return customQueries.getAppointmentsByGroupAndWeekDay(group_id, weekDay);
    }

}
