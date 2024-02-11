package com.sai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sai.Repo.vaccinationRepo;
import com.sai.entity.Citizen;
import com.sai.entity.RequiredResponse;
import com.sai.model.VaccinationCenter;


@RestController
public class VaccinationController {
	
	@Autowired 
	 private RestTemplate restTemplate; 
	
	
	@Autowired
	private vaccinationRepo repo;
	
	
	@PostMapping("/add") 
	 public VaccinationCenter addVaccinationCenterDetails(@RequestBody VaccinationCenter newVaccination) 
	 { 
		VaccinationCenter add=repo.save(newVaccination); 
	  return add; 
	 } 
	 @GetMapping("/get/{id}") 
	 public VaccinationCenter getVaccinationRecord(@PathVariable int id) 
	 { 
		 VaccinationCenter getOneRecord=repo.findById(id).get(); 
	  return getOneRecord; 
	 } 
	 
	 
	 
	 @GetMapping("/getData/{id}") 
	 public ResponseEntity<RequiredResponse> getdata(@PathVariable int id) 
	 { 
	  RequiredResponse requiredResponse=new RequiredResponse(); 
	   
	  // This is for VaccinationCenter Center Details 
	  VaccinationCenter center=repo.findById(id).get(); 
	  requiredResponse.setCenter(center); 
	   
	 // Then Get citizen registered to Vaccination Details 
	 List<Citizen> listOfCitizens=restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id,List.class); 
	 requiredResponse.setCitizen(listOfCitizens);  
	 return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK); 
	   
	   
	 } 
	 
	 
}
