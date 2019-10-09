package com.capgemini.TrabajoFinal.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.capgemini.TrabajoFinal.model.Tema;

public class pruebaTablas {
	
	private List<Tema> listaTemas;
	public Tema tema;
	
	/*@GetMapping("/all")
	public String showAll(Model model) {
	    model.addAttribute("temas", bookService.findAll());
	    return "books/allBooks";
	}*/
}
