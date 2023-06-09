package com.taras_overmind.scheduleApp.model.entity;

import javax.persistence.*;

import com.taras_overmind.scheduleApp.model.enums.UserRole;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private UserRole role;

    @Email
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private boolean enabled;

    public User(@NotNull @NotEmpty String username,
                @NotNull @NotEmpty String password,
                @NotNull @NotEmpty UserRole role,
                @NotNull @NotEmpty @Email String email) {
        this.username = username;
        this.password = password;
        this.role= role;
        this.email = email;

    }

    public User() {
    }
}
