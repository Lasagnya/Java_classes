package com.example.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="username")
	private String username;

	@Column(name="year_of_birth")
	private int year_of_birth;

	@Column(name="password")
	private String password;

	public Person() {
	}

	public Person(String username, int year_of_birth) {
		this.username = username;
		this.year_of_birth = year_of_birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getYear_of_birth() {
		return year_of_birth;
	}

	public void setYear_of_birth(int year_of_birth) {
		this.year_of_birth = year_of_birth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", username='" + username + '\'' +
				", year_of_birth=" + year_of_birth +
				", password='" + password + '\'' +
				'}';
	}
}
