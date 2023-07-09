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
	public String calculatorPage(@RequestParam(value = "a") int a,
								 @RequestParam(value = "b") int b,
								 @RequestParam(value = "action") String action,
								 Model model) {
		double result = 0;
		boolean correct = true;
		switch(action) {
			case "multiplication":
				result = a*b;
				break;
			case "addition":
				result = a+b;
				break;
			case "subtraction":
				result = a-b;
				break;
			case "division":
				if (b == 0) {
					correct = false;
					break;
				}
				result = a/(double)b;
				break;
			default:
				correct = false;
		}
		if(correct)
			model.addAttribute("result", result);
		else model.addAttribute("result", "Incorrect input");
		return "/first/calculator";
	}
}
