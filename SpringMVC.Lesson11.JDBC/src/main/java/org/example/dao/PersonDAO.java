package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@Component
public class PersonDAO {
	private static int PEOPLE_COUNT = 0;
	private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "postgres";
	private static Connection connection;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Person> index() {
		return people;
	}

	public Person show(int id) {
	//	return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
		return new Person();
	}

	public void save(Person person) {
		person.setId(++PEOPLE_COUNT);
		people.add(person);
	}

	public void update(int id, Person updatedPerson) {
//		Person personToBeUpdated = show(id);
//		personToBeUpdated.setName(updatedPerson.getName());
//		personToBeUpdated.setAge(updatedPerson.getAge());
//		personToBeUpdated.setEmail(updatedPerson.getEmail());
	}

	public void delete(int id) {
		people.removeIf(person -> person.getId() == id);
	}
}
