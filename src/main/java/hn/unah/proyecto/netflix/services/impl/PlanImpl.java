package hn.unah.proyecto.netflix.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.proyecto.netflix.models.Plan;
import hn.unah.proyecto.netflix.repositorys.PlanRepository;
import hn.unah.proyecto.netflix.services.PlanService;

@Service
public class PlanImpl implements PlanService{
    @Autowired
    PlanRepository planRepository;

    @Override
    public Iterable<Plan> obtenerPlanes() {
        return planRepository.findAll();
    }


    
}
