package com.tectoro.mvc.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tectoro.mvc.dto.PaginationDto;
import com.tectoro.mvc.service.CountryService;

@RestController
@RequestMapping(value = "/api/")
public class TestingController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping(value = "get-countries")
	public List<PaginationDto> getCountries()	{
		return countryService.getPaginatedDataOfCountries();
	}
}
