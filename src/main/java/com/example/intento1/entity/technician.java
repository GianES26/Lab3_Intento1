package com.example.intento1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="technician")
public class technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID", nullable = false)
    private Integer id;

    @Column(name = "FirstName", length = 100, nullable = false)
    private String firstName;

    @Column(name = "LastName", length = 100, nullable = false)
    private String lastName;

    @Column(name = "Dni", length = 8, nullable = false)
    private String dni;

    @Column(name = "Phone", length = 9, nullable = false)
    private String phone;

    @Column(name = "Age", nullable = false)
    private Integer age;

}
