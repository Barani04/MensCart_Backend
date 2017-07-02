package com.niit.menscart_backend.model;

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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name="user")
@Component
public class User {
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int userId;
	/*@Size(min=5, max=10, message="The username must be between 5 to 10 characters..")*/
	private String userName;
	private String firstName;
	private String lastName;
	/*@Pattern(regexp="[0-9].+@+\\..",message="Invalid Email format")*/
	private String emailId;
	/*@Size(min=5, max=10, message="The password must be between 5 to 10 characters..")
	@NotNull (message="password must not be empty")*/
	private String password;
	/*@Size(min=10,max=10,message="Contact number must be 10 digits")
	@Pattern(regexp="[0-9]",message="Contact number should only be numbers")*/
	private String contactNo;
	private String address;
	private boolean enabled;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private Role role;

	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
