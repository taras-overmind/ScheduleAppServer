package com.taras_overmind.scheduleApp.model.service;

import com.taras_overmind.scheduleApp.model.dto.LecturerAppointmentDTO;
import com.taras_overmind.scheduleApp.model.dto.StudentAppointmentDTO;
import com.taras_overmind.scheduleApp.repository.CustomQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentAppointmentService {

    @Autowired
    private CustomQueries customQueries;

    public List<StudentAppointmentDTO> getStudentAppointment(String group_name, int weekDay){
        var list = customQueries.getAppointmentsByGroupAndWeekDay(group_name, weekDay);
        List<StudentAppointmentDTO> resultList=new ArrayList<>();
        StudentAppointmentDTO studentAppointmentDTO;
        for(var l: list){
            studentAppointmentDTO = new StudentAppointmentDTO();
            studentAppointmentDTO.setNumber(l.get(0));
            studentAppointmentDTO.setSubject(l.get(1));
            studentAppointmentDTO.setSubject_type(l.get(2));
            studentAppointmentDTO.setLecturer_name(l.get(3));
            studentAppointmentDTO.setLink(l.get(4));
            resultList.add(studentAppointmentDTO);
        }
        return resultList;
    }
}
