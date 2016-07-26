package com.codecool.fightclub.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// @DateTimeFormat(pattern="yyyy-/MM-/dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull
	@Past
	private Date birthDate;

	@NotEmpty
	@Email
	private String emailAddress;

	@Size(min = 1, max = 30)
	private String firstName;

	@Size(min = 1, max = 30)
	private String lastName;

	@Size(min = 1, max = 30)
	private String password;

	@Size(min = 1, max = 30)
	private String userName;

	@NotNull
	private Gender gender;

	@Phone
	private String phoneNumber;

	@Size(min = 1, max = 30)
	private String country;

	@Size(min = 1, max = 30)
	private String city;

	@Size(min = 1, max = 30)
	private String address;

	// @Size(min=4, max=6)
	private int zipcode;

	private String image;

	public User() {
	}

	public User(int id, Date birthDate, String emailAddress, String firstName, String lastName, String password,
			String userName, Gender gender, String phoneNumber, String country, String city, String address,
			int zipcode, String image) {
		super();
		this.id = id;
		this.birthDate = birthDate;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.userName = userName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.city = city;
		this.address = address;
		this.zipcode = zipcode;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", birthDate=" + birthDate + ", emailAddress=" + emailAddress + ", firstName="
				+ firstName + ", lastName=" + lastName + ", password=" + password + ", userName=" + userName
				+ ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", country=" + country + ", city=" + city
				+ ", address=" + address + ", zipcode=" + zipcode + ", image=" + image + "]";
	}

}