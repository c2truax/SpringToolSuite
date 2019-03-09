package com.codingdojo.lecture.controllers;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeCtrl {
	@RestMapping("/")
	public List<String> rootRoute() {
		List<String> myList = new ArrayList<String>(
				Arrays.asList("Christopher", "Henry"));
		return myList;
	}
	
	
	@RestMapping("/home")
	public String home() {
		return "Hello everyone!";
	}
}
