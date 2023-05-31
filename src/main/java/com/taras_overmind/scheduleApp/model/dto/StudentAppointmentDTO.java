package com.taras_overmind.scheduleApp.model.dto;

import lombok.Data;

@Data
public class StudentAppointmentDTO {
    private String number;
    private String subject;
    private String subject_type;
    private String lecturer_name;
    private String link;
}
