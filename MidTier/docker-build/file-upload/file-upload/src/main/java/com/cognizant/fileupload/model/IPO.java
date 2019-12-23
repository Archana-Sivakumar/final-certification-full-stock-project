package com.cognizant.fileupload.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ipo")
public class IPO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="ipo_id")
	@NotNull
	private int id;
	
	@NotNull
	@Column(name="ipo_price")
	private double price;
	
	
	@NotNull
	@Column(name="ipo_total_share")
	private double totalShare;
	
	@NotNull
	@Column(name="ipo_date_time")
	private Date dateTime;
	
	@NotNull
	@Column(name="ipo_remarks")
	private String remarks;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "co_id")
	private Company company;
	

	public IPO() {
		super();
	}


	public IPO(@NotNull int id, @NotNull double price, @NotNull double totalShare, @NotNull @NotNull Date dateTime,
			@NotNull String remarks, Company company) {
		super();
		this.id = id;
		this.price = price;
		this.totalShare = totalShare;
		this.dateTime = dateTime;
		this.remarks = remarks;
		this.company = company;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getTotalShare() {
		return totalShare;
	}


	public void setTotalShare(double totalShare) {
		this.totalShare = totalShare;
	}


	public Date getDateTime() {
		return dateTime;
	}


	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "IPO [id=" + id + ", price=" + price + ", totalShare=" + totalShare + ", dateTime=" + dateTime
				+ ", remarks=" + remarks + ", company=" + company + "]";
	}
	
	
}
