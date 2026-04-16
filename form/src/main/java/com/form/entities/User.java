package com.form.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank (message = "Name is required")
    private String userName;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email id is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8,message = "Password must be 8 digit")
    private String password;
    
}
