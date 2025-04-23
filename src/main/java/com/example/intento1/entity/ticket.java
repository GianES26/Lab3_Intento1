package com.example.intento1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="ticket")
public class ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private site site;

    @ManyToOne
    @JoinColumn(name = "TechnicianID")
    private technician technician;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "OpenedDate")
    private LocalDateTime openedDate;

    @Column(name = "ClosedDate")
    private LocalDateTime closedDate;

}
