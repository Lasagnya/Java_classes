package org.example.dao;

import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class PersonDAO {
	private final JdbcTemplate jdbcTemplate;

	private static int PEOPLE_COUNT = 0;

	@Autowired
	public PersonDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Person> index(){
		//return jdbcTemplate.query("select * from person", new PersonMapper());		//с собственным RowMapper
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
	}

	public Person show(int id) {
		return jdbcTemplate.query("select * from person where id=?", new Object[]{id}, new int[]{Types.INTEGER}, new BeanPropertyRowMapper<>(Person.class))
				.stream().findAny().orElse(null);
	}

	public void save(Person person) {
		int[] argTypes = new int[]{Types.INTEGER, Types.VARCHAR, Types.INTEGER, Types.VARCHAR};
		jdbcTemplate.update("insert into person values(?, ?, ?, ?)",
				new Object[]{++PEOPLE_COUNT, person.getName(), person.getAge(), person.getEmail()}, argTypes);
	}

	public void update(int id, Person updatedPerson) {
		int[] argTypes = new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.INTEGER};
		jdbcTemplate.update("update person set name=?, age=?, email=? where id=?",
				new Object[]{updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), id}, argTypes);
	}

	public void delete(int id) {
		jdbcTemplate.update("delete from person where id = ?", new Object[]{id}, new int[]{Types.INTEGER});
	}
}
