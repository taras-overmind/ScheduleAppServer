package com.taras_overmind.scheduleApp.model.service;

import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
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

    public List<LecturerAppointmentDTO> getLecturerAppointment(Long lecturer_id, int weekDay){
        var list = customQueries.getAppointmentsByLecturerAndWeekDay(lecturer_id, weekDay);
        List<LecturerAppointmentDTO> resultList=new ArrayList<>();
        LecturerAppointmentDTO lecturerAppointmentDTO;
        for(var l: list){
            lecturerAppointmentDTO = new LecturerAppointmentDTO();
            lecturerAppointmentDTO.setNumber(l.get(0));
            lecturerAppointmentDTO.setSubject(l.get(1));
            lecturerAppointmentDTO.setSubject_type(l.get(2));
            lecturerAppointmentDTO.setGroups(l.get(3));
            lecturerAppointmentDTO.setLink(l.get(4));
            resultList.add(lecturerAppointmentDTO);
        }
        return resultList;
    }
}
