package com.cognizant.signup.model;


import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	@Column(name = "us_name")
	private String userName;

	@Column(name = "us_password")
	private String password;
	
	@Column(name = "us_email")
	private String email;
	
	@Column(name = "us_mobile_no")
	private long mobileNumber;
	
	@Column(name = "us_confirm_status")
    private boolean confirmStatus; 
	
	@Column(name="us_raw_password")
	private String rawPassword;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "ur_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
    private Set<Role> roleList;
	
	public Users() {
		super();
		
	}

	
	


	public Users(int id, String userName, String password, String email, long mobileNumber, boolean confirmStatus,
			String rawPassword, Set<Role> roleList) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.confirmStatus = confirmStatus;
		this.rawPassword = rawPassword;
		this.roleList = roleList;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(boolean confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
	
	
	public String getRawPassword() {
		return rawPassword;
	}





	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}





	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}





	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", confirmStatus=" + confirmStatus + ", rawPassword=" + rawPassword
				+ ", roleList=" + roleList + "]";
	}


	

	



	
	
}
