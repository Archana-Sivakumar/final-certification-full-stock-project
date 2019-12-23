package com.cognizant.fileupload.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.fileupload.model.StockPrice;


public interface StockRepository extends JpaRepository<StockPrice, Integer> {

	
	@Query(nativeQuery=true,value="select min(sp_date) from stock_price")
	public Date getMinDate();
	
	@Query(nativeQuery=true,value="select max(sp_date) from stock_price")
	public Date getMaxDate();
	
	@Query(nativeQuery=true,value="select * from stock_price where sp_company_code=?1")
	public List<StockPrice> getStock(long companyCode);
}
