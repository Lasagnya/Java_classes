package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/first")
public class FirstController {
	@GetMapping("/hello")
	public String helloPage(@RequestParam(value = "name") String name,							//обязательно ждёт параметры. Ошибка, если их нет.
							@RequestParam(value = "surname", required = false) String surname,	//при таком параметре не обязательны, будут null лежать.
							Model model) {
		model.addAttribute("message", name + " " + surname);
		return "first/hello";
	}

	@GetMapping("/goodbye")
	public String goodbyePage() {
		return "first/goodbye";
	}


	@GetMapping("/calculator")
	public String calculatorPage(@RequestParam(value = "a") String a_,
								 @RequestParam(value = "b") String b_,
								 @RequestParam(value = "action") String action,
								 Model model) {
		Integer a = Integer.parseInt(a_);
		Integer b = Integer.parseInt(b_);
		switch(action) {
			case "multiplication":
				model.addAttribute("result", a*b);
				break;
			case "addition":
				model.addAttribute("result", a+b);
				break;
			case "subtraction":
				model.addAttribute("result", a-b);
				break;
			case "division":
				model.addAttribute("result", a/b);
				break;
		}
		return "/first/calculator";
	}
}
