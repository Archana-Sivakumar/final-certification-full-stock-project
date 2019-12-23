package com.cognizant.fileupload.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="stock_exchange")
public class StockExchange {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="se_id")
	private int id;
	
	
	@Column(name="se_name")
	private String stockExchangeName;
	

	@Column(name="se_brief")
	private String brief;
	
	
	@Column(name="se_address")
	private String address;
	
	
	@Column(name="se_remarks")
	private String remarks;
	
	public StockExchange() {
		super();
		
	}


	public StockExchange(int id,  String stockExchangeName, String brief,
			 String address, String remarks) {
		super();
		this.id = id;
		this.stockExchangeName = stockExchangeName;
		this.brief = brief;
		this.address = address;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStockExchangeName() {
		return stockExchangeName;
	}



	public void setStockExchangeName(String stockExchangeName) {
		this.stockExchangeName = stockExchangeName;
	}



	public String getBrief() {
		return brief;
	}



	public void setBrief(String brief) {
		this.brief = brief;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	@Override
	public String toString() {
		return "StockExchange [id=" + id + ", stockExchangeName=" + stockExchangeName + ", brief=" + brief
				+ ", address=" + address + ", remarks=" + remarks + "]";
	}



	
}
