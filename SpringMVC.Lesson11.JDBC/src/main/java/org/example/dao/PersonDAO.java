package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
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

	public List<Person> index(){
		List<Person> people = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();	//сам SQL-запрос
			String SQL = "SELECT * FROM Person";
			ResultSet resultSet = statement.executeQuery(SQL);

			while (resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setName(resultSet.getString("name"));
				person.setAge(resultSet.getInt("age"));
				person.setEmail(resultSet.getString("email"));
				people.add(person);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return people;
	}

	public Person show(int id) {
	//	return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
		return new Person();
	}

	public void save(Person person) {
		try {
			Statement statement = connection.createStatement();
			String SQL = String.format("insert into person values(%d, '%s', %d, '%s')", ++PEOPLE_COUNT, person.getName(), person.getAge(), person.getEmail());
			statement.executeUpdate(SQL);		//ничего не возвращает
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(int id, Person updatedPerson) {
//		Person personToBeUpdated = show(id);
//		personToBeUpdated.setName(updatedPerson.getName());
//		personToBeUpdated.setAge(updatedPerson.getAge());
//		personToBeUpdated.setEmail(updatedPerson.getEmail());
	}

	public void delete(int id) {
		//people.removeIf(person -> person.getId() == id);
	}
}
