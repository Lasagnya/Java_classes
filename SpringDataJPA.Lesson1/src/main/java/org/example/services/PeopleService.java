package org.example.services;

import org.example.models.Person;
import org.example.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)			//все публичные методы будут автоматически иметь аннотацию
public class PeopleService {

	private final PeopleRepository peopleRepository;

	@Autowired
	public PeopleService(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}

	public List<Person> findAll() {
		return peopleRepository.findAll();
	}

	public Person findOne(int id) {
		Optional<Person> foundPerson = peopleRepository.findById(id);
		return foundPerson.orElse(null);
	}

	@Transactional(readOnly = false)
	public void save(Person person) {
		peopleRepository.save(person);
	}

	@Transactional
	public void update(int id, Person updatedPerson) {
		updatedPerson.setId(id);
		peopleRepository.save(updatedPerson);			//для добавления и обновление сущности используется один метод save
	}

	@Transactional
	public void delete(int id) {
		peopleRepository.deleteById(id);
	}
}
