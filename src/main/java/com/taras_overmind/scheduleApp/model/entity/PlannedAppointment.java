package com.taras_overmind.scheduleApp.model.entity;

import com.taras_overmind.scheduleApp.model.enums.WeekDay;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class PlannedAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @NotNull
    private WeekDay weekDay;
    @NotNull
    @NotEmpty
    private int number;
    @NotEmpty
    @NotNull
    @ManyToOne
    private Lecturer lecturer;
    @NotEmpty
    @NotNull
    @ManyToOne
    private Subject subject;
    @NotEmpty
    @NotNull
    private String info;
}
