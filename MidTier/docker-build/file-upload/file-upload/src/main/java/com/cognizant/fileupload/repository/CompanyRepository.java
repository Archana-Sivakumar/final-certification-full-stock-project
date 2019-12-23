package com.cognizant.fileupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.fileupload.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

	public Company findByCompanyCode(long companyCode);
}
