package hn.unah.proyecto.netflix.repositorys;

import org.springframework.data.repository.CrudRepository;

import hn.unah.proyecto.netflix.models.Plan;

public interface PlanRepository extends CrudRepository<Plan, Integer> {
    
}
