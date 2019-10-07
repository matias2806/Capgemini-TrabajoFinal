package com.capgemini.TrabajoFinal.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capgemini.TrabajoFinal.model.Profesor;

public class LogInController {
	
	@GetMapping("/logIn")
	public String cargaLogIn(Model model) {
		model.addAttribute("prof", new Profesor());
		System.out.println("llego");
		return "logIn";
	}
}
