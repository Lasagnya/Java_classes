package org.example.controllers;

import jakarta.validation.Valid;
import org.example.dao.PersonDAO;
import org.example.models.Person;
import org.example.services.ItemService;
import org.example.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
	private final PeopleService peopleService;
	private final ItemService itemService;
	private final PersonDAO personDAO;

	@Autowired
	public PeopleController(PeopleService peopleService, ItemService itemService, PersonDAO personDAO) {
		this.peopleService = peopleService;
		this.itemService = itemService;
		this.personDAO = personDAO;
	}

	@GetMapping()
	public String index(Model model) {
		//model.addAttribute("people", peopleService.findAll());
		personDAO.testNPlus1();
		return "people/index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", peopleService.findOne(id));
		return "people/show";
	}

	@GetMapping("/new")
	public String newPerson(Model model) {
		model.addAttribute("person", new Person());
		return "/people/new";
	}

	@PostMapping()
	public String create(@ModelAttribute("person") @Valid Person person,
						 BindingResult bindingResult) {			//объект с ошибками
		if (bindingResult.hasErrors())
			return "people/new";				//поля будут с теми ошибочными значениями, которые ввели
		peopleService.save(person);
		return "redirect:/people";
	}

	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") int id) {
		model.addAttribute("person", peopleService.findOne(id));
		return "people/edit";
	}

	@PatchMapping("/{id}")
	public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
		if (bindingResult.hasErrors())
			return "people/edit";
		peopleService.update(id, person);
		return "redirect:/people";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		peopleService.delete(id);
		return "redirect:/people";
	}
}
