package com.taras_overmind.scheduleApp.controller;

import com.taras_overmind.scheduleApp.model.dto.StudentAppointmentDTO;
import com.taras_overmind.scheduleApp.model.service.StudentAppointmentService;
import com.taras_overmind.scheduleApp.repository.CustomQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    CustomQueries customQueries;
    @Autowired
    StudentAppointmentService service;
    @GetMapping("/smthing")
    public String getString(){
        return "abcdefghijklmnopqrstuvwxyz";
    }
    @GetMapping("/student")
    public List<StudentAppointmentDTO> getSubjects(String group_name, int weekDay){
        return service.getStudentAppointment(group_name, weekDay);
    }

    @GetMapping("/faculties")
    public List<String> getFaculties(){
        return customQueries.getFaculties();
    }

    @GetMapping("/groups")
    public List<String> getGroups(String faculty_name){
        return customQueries.getGroups(faculty_name);
    }

}
