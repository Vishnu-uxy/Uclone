package com.user.service.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    @NotNull
    private String username;
    
    @Column
    @NotNull
    private String firstName; // Fixed typo "fisrstName" to "firstName"
    
    @Column
    @NotNull
    private String lastName;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{9,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, one special character, and be at least 9 characters long."
        )
    @NotNull
    private String password;
    
    
    
  
}
