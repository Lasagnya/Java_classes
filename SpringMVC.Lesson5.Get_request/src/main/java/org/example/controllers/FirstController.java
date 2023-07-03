package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
	@GetMapping("/hello")
	public String helloPage(@RequestParam(value = "name") String name,		//обязательно ждёт параметры. Ошибка, если их нет.
							@RequestParam(value = "surname", required = false) String surname) {//при таком параметре не обязательны, будут null лежать.
		System.out.println(name + " " + surname);
		return "first/hello";
	}

	@GetMapping("/goodbye")
	public String goodbyePage() {
		return "first/goodbye";
	}
}
