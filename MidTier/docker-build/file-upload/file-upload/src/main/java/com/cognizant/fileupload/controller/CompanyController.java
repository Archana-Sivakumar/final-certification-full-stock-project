package com.cognizant.fileupload.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.fileupload.model.Company;
import com.cognizant.fileupload.service.CompanyService;


@RestController
public class CompanyController {

	
	 private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
	 
	@Autowired
    private CompanyService companyService;
	
	 @GetMapping("/company")
	 public List<Company> getAllCompanies() {
		 return companyService.getAllCompanies();
	 }
	 
	 @PostMapping("/add-company")
		public boolean addCompany(@RequestBody Company company) {
			
			LOGGER.info("Start");
			LOGGER.info("End");
			
			return companyService.addCompany(company);
	}
}
