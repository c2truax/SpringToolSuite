package org.christruax.hellohuman;

import org.christruax.hellohuman.HellohumanApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HumanController {
	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}
	@RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String name, Model model) {
		if(name == null) {
			name = "human";
			model.addAttribute("humanName", name);
		} else {
			model.addAttribute("humanName", name);
		}
        return "index.jsp";
    }
	
}