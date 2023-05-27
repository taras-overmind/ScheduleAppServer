package com.taras_overmind.scheduleApp.controller;

import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
import com.taras_overmind.scheduleApp.model.service.LecturerAppointmentService;
import com.taras_overmind.scheduleApp.repository.CustomQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LecturerController {
    @Autowired
    CustomQueries customQueries;

    @Autowired
    LecturerAppointmentService lecturerAppointmentService;

    @GetMapping("/lecturer")
    List<LecturerAppointmentDTO> getLecturerAppointment(Long lecturer_id, int weekDay){
        return lecturerAppointmentService.getLecturerAppointment(lecturer_id, weekDay);
    }

}
