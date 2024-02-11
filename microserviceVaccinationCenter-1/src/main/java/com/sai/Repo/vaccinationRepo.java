package com.sai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.model.VaccinationCenter;

@Repository
public interface vaccinationRepo extends JpaRepository<VaccinationCenter,Integer> {

}
