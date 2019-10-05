package com.capgemini.TrabajoFinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.TrabajoFinal.model.Alumno;


@Controller
public class AlumnoController {
	
	@GetMapping("/altaAlumno")
	public String altaAlumno(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "altaAlumno";
	}
	
	@PostMapping("/altaAlumno")
    public String choriSubmit(@ModelAttribute Alumno alumno) {
        return "finDelForm";
    }
	
}
