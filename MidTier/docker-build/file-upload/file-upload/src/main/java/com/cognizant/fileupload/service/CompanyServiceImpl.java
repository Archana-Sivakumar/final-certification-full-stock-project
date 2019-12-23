package com.cognizant.fileupload.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.fileupload.controller.FileController;
import com.cognizant.fileupload.model.Company;
import com.cognizant.fileupload.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}
	
	
	@Override
	public boolean addCompany(Company company) {
		
		LOGGER.info("Start");
		
		companyRepository.save(company);
		
		LOGGER.info("End");
		return true;
	}
}
