package com.example.intento1.controller;

import com.example.intento1.entity.technician;
import com.example.intento1.repository.technicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class appController {

    @Autowired
    private technicianRepository technicianRepository;


    @GetMapping("tecnicos/lista")
    public String listaTecnicos(Model model) {
        List<technician> tecnicosLista = technicianRepository.findAll();
        model.addAttribute("tecnicosLista", tecnicosLista);
        return "technicianList";
    }

    @GetMapping("tecnicos/nuevo")
    public String nuevoEmpleado(Model model) {
        model.addAttribute("tecnico", new technician());
        return "technicianForm";
    }

    @GetMapping("tecnicos/editar")
    public String editarEmpleado(@RequestParam("id") Integer id, Model model) {
        Optional<technician> tecnicoOpt = technicianRepository.findById(id);
        if (tecnicoOpt.isPresent()) {
            technician tecnico = tecnicoOpt.get();
            model.addAttribute("tecnico", tecnico);

            return "technicianForm";
        } else {
            return "redirect:/employee";
        }
    }


    @PostMapping("tecnicos/guardar")
    public String guardarEmpleado(technician tecnico, RedirectAttributes attr) {

        if(tecnico.getId() == null || tecnico.getId() == 0){
            attr.addFlashAttribute("msg", "Tecnico" + tecnico.getFirstName() + tecnico.getLastName() + "creado exitosamente");
        }
        else {
            attr.addFlashAttribute("msg", "Tecnico" + tecnico.getFirstName() + tecnico.getLastName() + "actualizado exitosamente");
        }


        technicianRepository.save(tecnico);
        return "redirect:/tecnicos/lista";

    }

    @GetMapping("estadisticas")
    public String estadisticas(Model model) {

        model.addAttribute("estadisticas", technicianRepository.estadisticas());

        return "estadisticas";

    }

}
