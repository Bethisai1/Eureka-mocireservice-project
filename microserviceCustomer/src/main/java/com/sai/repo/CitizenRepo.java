package com.sai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sai.model.Citizen;
@Repository
public interface CitizenRepo extends JpaRepository<Citizen, java.lang.Integer> {

	public List<Citizen> findByVaccinationCenterId(Integer id);

}
