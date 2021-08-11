package it.epicode.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be.model.Building;
@Repository
public interface BuildingRepository  extends JpaRepository<Building,Long>{

}
