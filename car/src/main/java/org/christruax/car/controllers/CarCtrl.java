package org.christruax.car.controllers;

import java.util.List;

import javax.validation.Valid;

import org.christruax.car.models.Car;
import org.christruax.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
public class CarCtrl {
	@Autowired
	private CarService cS;

	@GetMapping("/cars")
	public String index(Model model) {
		List<Car> cars = cS.getAllCars();
		model.addAttribute("allCars", cars);
		return "/cars/index.jsp";
	}
	
	@GetMapping("/cars/new")
	public String newCar(@ModelAttribute("carObj") Car car) {
//		model.addAttribute("carObj", new Car());
		return "/cars/new.jsp";
	}
	@PostMapping("/cars")
	public String createCar(@Valid @ModelAttribute("carObj") Car car, BindingResult result) {
		if(result.hasErrors()) {
			// show error messages
			return "/cars/new.jsp";
		} else {
			cS.createOrUpdateCar(car);
			return "redirect:/cars";
		}
		
	}
	
	@GetMapping("/cars/{id}")
	public String showCar(@PathVariable("id") Long id, Model model) {
		Car c = cS.getCarById(id);
		
		model.addAttribute("car", c);
		
		return "/cars/show.jsp";
	}
	@GetMapping("/cars/{id}/edit")
	public String editCar(@PathVariable("id") Long id, Model model) {
		Car c = cS.getCarById(id);
		
		model.addAttribute("car", c);
		
		return "/cars/edit.jsp";
	}
	@PutMapping("/cars/{id}")
	public String editCar(@Valid @ModelAttribute("car") Car car, BindingResult result) {
		if(result.hasErrors()) {
			// show error messages
			return "/cars/edit.jsp";
		} else {
			cS.createOrUpdateCar(car);
			return "redirect:/cars";
		}
	}
	@DeleteMapping("/cars/{id}")
	public String deleteCar(@PathVariable("id") Long id) {
		cS.removeCarById(id);
		return "redirect:/cars";
	}
	
}
