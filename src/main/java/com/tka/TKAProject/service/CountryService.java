package com.tka.TKAProject.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.TKAProject.dao.CountryDAO;
import com.tka.TKAProject.entity.Country;

@Service
public class CountryService {
	
	@Autowired
	CountryDAO countryDao;

	public String addCountry(Country country) {
		// TODO Auto-generated method stub
		String message = countryDao.addCountry(country);
		
		if(Objects.isNull(message)) {
			message = "Country is Not added...";
		}
		
		return message;
	}

	public String updateCountry(Country country, int cId) {
		// TODO Auto-generated method stub
		String message = countryDao.updateCountry(country,cId);
		return message;
	}

	public String deleteCountry(int cId) {
		// TODO Auto-generated method stub
		String message = countryDao.deleteCountry(cId);
		return message;
	}

	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		List<Country> list = countryDao.getAllCountry();
		return list;
	}

	public Country getParticularCountry(int cId) {
		// TODO Auto-generated method stub
		Country country = countryDao.getParticularCountry(cId);
		return country;
	}

}
