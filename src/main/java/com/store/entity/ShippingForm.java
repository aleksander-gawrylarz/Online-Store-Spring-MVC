package com.store.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class ShippingForm {
	
	@NotNull(message="is required")
	private String firstName;
	
	@NotNull(message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message="not a valid email pattern")
	private String email;
	
	@NotNull(message="is required")
	@Pattern(regexp="[0-9]{9}", message="enter 9 digits")
	private String phoneNumber;
	
	@NotNull(message="is required")
	private String streetAddress;
	
	@NotNull(message="is required")
	private String city;
	
	@NotNull(message="is required")
	@Pattern(regexp="^[0-9]{2}-[0-9]{3}$", message="valid pattern is 'xx-xxx'")
	private String postalCode;
	
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
