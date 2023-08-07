package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "director")
public class Director {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@OneToMany(mappedBy = "director", cascade = CascadeType.PERSIST)
	private List<Movie> movies;
}
