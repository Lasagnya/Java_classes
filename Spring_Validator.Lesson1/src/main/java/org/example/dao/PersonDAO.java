package org.example.dao;

import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
	private final JdbcTemplate jdbcTemplate;

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
		int[] argTypes = new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR};
		jdbcTemplate.update("insert into person(name, age, email) values(?, ?, ?)",
				new Object[]{person.getName(), person.getAge(), person.getEmail()}, argTypes);
	}

	public void update(int id, Person updatedPerson) {
		int[] argTypes = new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.INTEGER};
		jdbcTemplate.update("update person set name=?, age=?, email=? where id=?",
				new Object[]{updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), id}, argTypes);
	}

	public void delete(int id) {
		jdbcTemplate.update("delete from person where id = ?", new Object[]{id}, new int[]{Types.INTEGER});
	}

	//Тест производительности пакетной вставки

	public void testMultipleUpdate() {
		List<Person> people = create1000People();
		long before = System.currentTimeMillis();
		for (Person person: people) {
			int[] argTypes = new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR};
			jdbcTemplate.update("insert into person(name, age, email) values(?, ?, ?)",
					new Object[]{person.getName(), person.getAge(), person.getEmail()}, argTypes);
		}
		long after = System.currentTimeMillis();
		System.out.println("Time: " + (after - before));
	}

	public void testBatchUpdate() {
		List<Person> people = create1000People();
		long before = System.currentTimeMillis();
		jdbcTemplate.batchUpdate("insert into person(name, age, email) values(?, ?, ?)",
				new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, people.get(i).getName());
						ps.setInt(2, people.get(i).getAge());
						ps.setString(3, people.get(i).getEmail());
					}

					@Override
					public int getBatchSize() {
						return people.size();
					}
				});
		long after = System.currentTimeMillis();
		System.out.println("Time: " + (after - before));
	}

	private List<Person> create1000People() {
		List<Person> people = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			people.add(new Person(i+1 ,"Name"+i, 30, "test"+i + "mail.com"));
		}
		return people;
	}
}
