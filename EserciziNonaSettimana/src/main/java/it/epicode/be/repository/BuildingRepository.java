package it.epicode.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.be.model.Building;

public interface BuildingRepository  extends JpaRepository<Building,Long>{

}
