package com.taras_overmind.scheduleApp.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class GroupAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull
    @NotEmpty
    private GroupOfStudents groupOfStudents;
    @NotNull
    @NotEmpty
    @ManyToOne
    private PlannedAppointment plannedAppointment;
}
