package com.taras_overmind.scheduleApp.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class LecturerAppointmentDTO {
    private String number;
    private String subject;
    private String subject_type;
    private String groups;
    private String link;
}
