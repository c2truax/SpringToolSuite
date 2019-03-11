package org.christruax.routingpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/coding")
public class CodingController {
	public static void main(String[] args) {
		SpringApplication.run(RoutingpracticeApplication.class, args);
	}
	@RequestMapping("")
	public String hello() {
		return "Hello Coding Dojo!";
	}
	@RequestMapping("python")
	public String python() {
		return "Python/Django was awesome!";
	}
	@RequestMapping("java")
	public String java() {
		return "Java/Spring is better!";
	}
}
