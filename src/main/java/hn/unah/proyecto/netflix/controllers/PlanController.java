package hn.unah.proyecto.netflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.proyecto.netflix.models.Plan;
import hn.unah.proyecto.netflix.services.impl.PlanImpl;

@RestController
@RequestMapping("/api/planes")
public class PlanController {

    @Autowired
    PlanImpl planImpl;

    @GetMapping("/obtener")
    public Iterable<Plan> obtenerPlanes() {
        return planImpl.obtenerPlanes(); 
    }
    
}
