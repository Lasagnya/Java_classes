package org.example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "item")
public class Item {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@Column(name="item_name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person owner;

	public Item() {
	}

	public Item(String name, Person owner) {
		this.name = name;
		this.owner = owner;
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

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", name='" + name + '\'' +
				", owner=" + owner +
				'}';
	}
}
