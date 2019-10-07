package com.capgemini.TrabajoFinal.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.TrabajoFinal.model.Alumno;
import com.capgemini.TrabajoFinal.repository.AlumnoRepository;
import com.capgemini.TrabajoFinal.service.ConexcionConMySql;


@Controller
public class AlumnoController {
	
	//private static final Logger log = LoggerFactory.getLogger(AlumnoController.class);
	
	
	
	@Autowired
	private AlumnoRepository alumRepository;
	
	@GetMapping("/altaAlumno")
	public String altaAlumno(Model model) {
		model.addAttribute("alumno", new Alumno());
		//System.out.println("llego");
		return "altaAlumno";
	}
	
	
	@PostMapping("/altaAlumno")
    public String alumnoSubmit(@ModelAttribute Alumno alumno) {
		///alumRepository.save(alumno);  No salio lo dejo por las dudas
		
		// Instancias la clase que hemos creado anteriormente
		 ConexcionConMySql SQL = new ConexcionConMySql();
		// Llamas al método que tiene la clase y te devuelve una conexión
		 Connection conn = SQL.conectarMySQL();
		// Query que usarás para hacer lo que necesites
		 String sSQL =   "";
		
		// Query
		sSQL =  "INSERT INTO alumnos (idCurso, nombre, apellido, DNI, telefono, mail) VALUES ('"+alumno.getIdCurso()+"','"+alumno.getNombre()+"','"+alumno.getApellido()+"','"
		+alumno.getDNI()+"','"+alumno.getTelefono()+"','"+alumno.getMail()+"')";
		// PreparedStatement
		try {
			PreparedStatement pstm = conn.prepareStatement(sSQL);
			int retorno = pstm.executeUpdate();
			
			if(retorno == 1) {
				System.out.println("Se cargo correctamente al alumno");
			}
			conn.close();
		}catch(SQLException e) {
			
		}catch(Exception w) {
			
		}finally {
			
		}
		
        return "finDelForm";
    }
	
}
