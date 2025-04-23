package com.example.intento1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="site")
public class site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteID", nullable = false)
    private Integer id;

    @Column(name = "SiteName", length = 255)
    private String siteName;

    @ManyToOne
    @JoinColumn(name = "LocationID")
    private location location;

    @Column(name = "InstallationDate")
    private LocalDate InstallationDate;

    @Column(name = "Latitude", length = 45)
    private String latitude;

    @Column(name = "Longitude", length = 45)
    private String longitude;

}
