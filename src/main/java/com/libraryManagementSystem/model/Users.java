package com.libraryManagementSystem.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "UserName cannot be null")
    private String userName;
    @NotNull(message = "Choose a Password")
    private String password;
    @NotNull(message = "Email cannot be null")
    @Email(message = "Please Enter a valid email")
    private String email;
    @NotNull(message = "Memebership Expiry cannot be null")
    private String expiryDate;

    public Users() {
		super();
	}

	public Users(int userId, @NotNull(message = "Name cannot be null") String name,
			@NotNull(message = "UserName cannot be null") String userName,
			@NotNull(message = "Choose a Password") String password,
			@NotNull(message = "Email cannot be null") @Email(message = "Please Enter a valid email") String email,
			@NotNull(message = "Memebership Expiry cannot be null") String expiryDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.expiryDate = expiryDate;
	}

	public Users(@NotNull(message = "Name cannot be null") String name,
			@NotNull(message = "UserName cannot be null") String userName,
			@NotNull(message = "Choose a Password") String password,
			@NotNull(message = "Email cannot be null") @Email(message = "Please Enter a valid email") String email,
			@NotNull(message = "Memebership Expiry cannot be null") String expiryDate) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.expiryDate = expiryDate;
	}

	public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
