package com.taras_overmind.scheduleApp.model.service;

import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
import com.taras_overmind.scheduleApp.model.dto.LecturerDTO;
import com.taras_overmind.scheduleApp.model.enums.WeekDay;
import com.taras_overmind.scheduleApp.repository.CustomQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LecturerAppointmentService {
    @Autowired
        private CustomQueries customQueries;

    public List<LecturerAppointmentDTO> getLecturerAppointment(String email, int weekDay){
        var list = customQueries.getAppointmentsByLecturerAndWeekDay(email.toLowerCase(), weekDay);
        List<LecturerAppointmentDTO> resultList=new ArrayList<>();
        LecturerAppointmentDTO lecturerAppointmentDTO;
        for(var l: list){
            lecturerAppointmentDTO = new LecturerAppointmentDTO();
            lecturerAppointmentDTO.setId(l.get(0));
            lecturerAppointmentDTO.setNumber(l.get(1));
            lecturerAppointmentDTO.setSubject(l.get(2));
            lecturerAppointmentDTO.setSubject_type(l.get(3));
            lecturerAppointmentDTO.setGroups(l.get(4));
            lecturerAppointmentDTO.setLink(l.get(5));
            resultList.add(lecturerAppointmentDTO);
        }
        return resultList;
    }
    public LecturerDTO getLecturerByEmail(String email){
        var list=customQueries.getLecturerByEmail(email).get(0);
        return new LecturerDTO(list.get(0), list.get(1), list.get(2));

    }
}
