package com.cognizant.fileupload.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cognizant.fileupload.model.Company;


@Service
public interface CompanyService {
     
	public List<Company> getAllCompanies();
	
	public boolean addCompany(Company company);
}
