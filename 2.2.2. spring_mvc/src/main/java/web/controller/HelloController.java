package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller //аннотация-наследник от @Component
public class HelloController {

	@GetMapping(value = "/")//связка метода с ссылкой, откуда обращаются к этому методу
	//то есть, если юзер делает get к этой странице, то он "попадает" в этот метод
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("----------------------------------------------");
		messages.add(new Date().toString());
		messages.add("----------------------------------------------");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by aug'20 ");
		messages.add("Something else");
		messages.add("----------------------------------------------");
		model.addAttribute("messages", messages);
		return "index";
	}
	/*методов может быть несколько в контроллере. Чаще всего - один метод - один URL.
	И чаще всего метод возвращает String (JSON возможно). Название метода может быть любым.*/
	
}