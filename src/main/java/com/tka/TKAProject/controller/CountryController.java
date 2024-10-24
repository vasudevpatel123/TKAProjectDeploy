package com.tka.TKAProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.TKAProject.entity.Country;
import com.tka.TKAProject.service.CountryService;

@RestController
@RequestMapping("countryAPI")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	
	@PostMapping("addCountry")
	public ResponseEntity<String> addCountry(@RequestBody Country country) {
		
		String message = countryService.addCountry(country);
		return ResponseEntity.ok(message);
		
	}
	
	@PutMapping("updateCountry/{cId}")
	public ResponseEntity<String> updateCountry(@RequestBody Country country,@PathVariable int cId) {
		String message = countryService.updateCountry(country,cId);
		return ResponseEntity.ok(message);
	}
	
	@DeleteMapping("deleteCountry/{cId}")
	public ResponseEntity<String> deleteCountry(@PathVariable int cId){
		String message = countryService.deleteCountry(cId);
		return ResponseEntity.ok(message);
	}

	@GetMapping("getAllCouuntry")
	public ResponseEntity<List<Country>> getAllCountry(){
		List<Country> list = countryService.getAllCountry();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("getParticularCountry/{cId}")
	public ResponseEntity<Country> getParticularCountry(@PathVariable int cId) {
		Country country = countryService.getParticularCountry(cId);
		return ResponseEntity.ok(country);
	}
	
}
