package com.cognizant.fileupload.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="stock_price")
public class StockPrice {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="sp_id")
	private int id;
	
	@Column(name="sp_company_code")
	private long companyCode;
	
	
	@Column(name="sp_stock_exchange_name")
	private String stockExchangeName;
	
	
	@Column(name="sp_current_price")
	private long currentPrice;
	
	
	
	@Column(name="sp_date")
	private Date date;
	
	
	@Column(name="sp_time")
	private Time time;
	

	
	public StockPrice() {
		super();
	}


	


	public StockPrice(int id, long companyCode, String stockExchangeName, long currentPrice, Date date,
			Time time) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.stockExchangeName = stockExchangeName;
		this.currentPrice = currentPrice;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(long currentPrice) {
		this.currentPrice = currentPrice;
	}

	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Time getTime() {
		return time;
	}


	public void setTime(Time time) {
		this.time = time;
	}


	public long getCompanyCode() {
		return companyCode;
	}



	public void setCompanyCode(long companyCode) {
		this.companyCode = companyCode;
	}



	public String getStockExchangeName() {
		return stockExchangeName;
	}



	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}





	@Override
	public String toString() {
		return "StockPrice [id=" + id + ", companyCode=" + companyCode + ", stockExchangeName=" + stockExchangeName
				+ ", currentPrice=" + currentPrice + ", date=" + date + ", time=" + time + "]";
	}


	
}