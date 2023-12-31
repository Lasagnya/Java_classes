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
		Person person = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from person where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			person = new Person();
			person.setId(resultSet.getInt("id"));
			person.setName(resultSet.getString("name"));
			person.setAge(resultSet.getInt("age"));
			person.setEmail(resultSet.getString("email"));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return person;
	}

	public void save(Person person) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into person values(?, ?, ?, ?)");
			preparedStatement.setInt(1, ++PEOPLE_COUNT);
			preparedStatement.setString(2, person.getName());
			preparedStatement.setInt(3, person.getAge());
			preparedStatement.setString(4, person.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(int id, Person updatedPerson) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update person set name=?, age=?, email=? where id=?");
			preparedStatement.setString(1, updatedPerson.getName());
			preparedStatement.setInt(2, updatedPerson.getAge());
			preparedStatement.setString(3, updatedPerson.getEmail());
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void delete(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from person where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
