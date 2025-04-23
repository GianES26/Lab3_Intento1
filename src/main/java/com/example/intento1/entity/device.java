package com.example.intento1.entity;

import jakarta.persistence.*;
public class device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeviceID", nullable = false)
    private Integer id;

    @Column(name = "DeviceName", length = 255)
    private String deviceName;

    @Column(name = "DeviceType", length = 255)
    private String deviceType;

    @Column(name = "Model", length = 255)
    private String model;

    @Column(name = "SerialNumber", length = 255)
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private site site;

}
