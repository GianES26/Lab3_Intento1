package com.example.intento1.repository;

import com.example.intento1.dao.cantidadIntervencionesPorSitioDto;
import com.example.intento1.entity.technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface technicianRepository extends JpaRepository<technician, Integer> {

    @Query(value= """
            select site.SiteName as NombreSitio, count(ticket.TicketID) as CuentaTicketID
            from ticket
            join site on ticket.SiteID = site.SiteID
            group by site.SiteID
            order by site.SiteID;""", nativeQuery = true)
    List<cantidadIntervencionesPorSitioDto> estadisticas();



}
