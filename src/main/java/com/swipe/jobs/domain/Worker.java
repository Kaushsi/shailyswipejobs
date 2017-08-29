package com.swipe.jobs.domain;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Worker {

	private Integer rating;
	
	private Boolean isActive;
	
	@Valid
	private List<String> certificates = null;
	
	@Valid
	private List<String> skills = null;
	
	@Valid
	private JobSearchAddress jobSearchAddress;

	private String transportation;

	private Boolean hasDriversLicense;

	@Valid
	private List<Availability> availability = null;

	private String phone;

	private String email;

	@Valid
	private Name name;

	private Integer age;

	private String guid;

	private Integer userId;

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<String> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<String> certificates) {
		this.certificates = certificates;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public JobSearchAddress getJobSearchAddress() {
		return jobSearchAddress;
	}

	public void setJobSearchAddress(JobSearchAddress jobSearchAddress) {
		this.jobSearchAddress = jobSearchAddress;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public Boolean getHasDriversLicense() {
		return hasDriversLicense;
	}

	public void setHasDriversLicense(Boolean hasDriversLicense) {
		this.hasDriversLicense = hasDriversLicense;
	}

	public List<Availability> getAvailability() {
		return availability;
	}

	public void setAvailability(List<Availability> availability) {
		this.availability = availability;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
