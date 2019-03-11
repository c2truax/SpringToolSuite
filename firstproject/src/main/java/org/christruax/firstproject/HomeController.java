package org.christruax.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HomeController {

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}
	@RequestMapping("")
	public String hello() {
		return "Hello Chris";
	}
	@RequestMapping("/world")
	public String world() {
		return "Annotations are Awesome!";
	}
}
