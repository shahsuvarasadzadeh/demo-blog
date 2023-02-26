package com.example.demoblog.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "UserRa")
@Data
@AllArgsConstructor
public class UserRa {

    @Id
    private Long id;
    private String name;
}
