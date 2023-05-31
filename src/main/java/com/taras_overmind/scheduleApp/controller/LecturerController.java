package com.taras_overmind.scheduleApp.controller;

import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
import com.taras_overmind.scheduleApp.model.dto.LecturerDTO;
import com.taras_overmind.scheduleApp.model.entity.PlannedAppointment;
import com.taras_overmind.scheduleApp.model.service.LecturerAppointmentService;
import com.taras_overmind.scheduleApp.repository.CustomQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LecturerController {
    @Autowired
    CustomQueries customQueries;

    @Autowired
    LecturerAppointmentService lecturerAppointmentService;

    @GetMapping("/lecturer")
    List<LecturerAppointmentDTO> getLecturerAppointment(String email, int weekDay){
        return lecturerAppointmentService.getLecturerAppointment(email, weekDay);
    }
    @GetMapping("/lecturer_data")
    LecturerDTO geLecturerByEmail(String email){
        return lecturerAppointmentService.getLecturerByEmail(email.toLowerCase());
    }
    @PostMapping("/lecturer/update/link")
    void setNewLinkById(@RequestBody LecturerAppointmentDTO lecturerAppointmentDTO){
        System.out.println(lecturerAppointmentDTO);
        PlannedAppointment plannedAppointment =  customQueries.findById(Long.parseLong(lecturerAppointmentDTO.getId())).get();
        plannedAppointment.setInfo(lecturerAppointmentDTO.getLink());
        customQueries.save(plannedAppointment);
    }

}
