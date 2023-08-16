package org.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotEmpty(message = "Name should not be empty")
	@Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
	@Column(name = "name")
	private String name;

	@Min(value = 0, message = "Age should be greater than 0")
	@Max(value = 150, message = "Age should be less than 150")
	@Column(name = "age")
	private int age;

	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Email should be valid")
	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "owner")
	private List<Item> items;

	public Person() {
	}

	public Person(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
