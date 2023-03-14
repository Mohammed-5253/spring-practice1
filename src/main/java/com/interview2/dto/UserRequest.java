package com.interview2.dto;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Service
public class UserRequest {
    @Nonnull
    private String name;
    @Nonnull
    private String email;
    @Nonnull
    private String password;
}