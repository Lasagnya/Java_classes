package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "year_of_production")
	private int year_of_production;

	@ManyToOne
	@JoinColumn(name = "director_id", referencedColumnName = "id")
	private Director director;
}
