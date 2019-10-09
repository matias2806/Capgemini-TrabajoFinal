package com.capgemini.TrabajoFinal.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.TrabajoFinal.model.Profesor;
import com.capgemini.TrabajoFinal.service.ConexcionConMySql;

@Controller
public class LogInController {
	
	
	
	//to get login form page
	@RequestMapping(value="/logIn", method=RequestMethod.GET)
	public String getLoginForm() {
		return "logIn";
	}
	
	
	
	@RequestMapping(value="/logIn", method=RequestMethod.POST)
	public String login(@ModelAttribute(name="prof")Profesor prof, Model model) {
		
		
		ConexcionConMySql SQL = new ConexcionConMySql();
		Connection conn = SQL.conectarMySQL();
		String sSQL = "";

		sSQL = "SELECT * FROM proyectofinalmatias.profesor;";
		// PreparedStatement
		System.out.println("a fuera del try");
		try {
			PreparedStatement pstm = conn.prepareStatement(sSQL);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				String mail = rs.getString("mail");
				String clave = rs.getString("clave");
				System.out.println("---------------");
				System.out.println("BD mail= "+mail);
				System.out.println("BD pw= "+clave);
				System.out.println("prof mail= "+prof.getMail());
				System.out.println("prof pw= "+prof.getPassword());
				
				//if(prof.getMail() == mail && prof.getPassword() == clave) {
				if(mail.equals(prof.getMail()) && clave.equals(prof.getPassword())) {
					return "home";
				}
			}
			
			conn.close();
		} catch (SQLException e) {
		} catch (Exception w) {
		} finally {
		}

		return "logIn"; // despues cambiarlo por home
	}
	
	/*
	//checking for login credentials
	@RequestMapping(value="/logIn", method=RequestMethod.POST)
	public String login(@ModelAttribute(name="prof")Profesor prof, Model model) {
		String mail= prof.getMail();
		String password = prof.getPassword();
		
		if("admin".equals(mail) && "admin".equals(password)) {
			return "home";
		}
		else {
			System.out.println ("Entra error");
			
			model.addAttribute("invalidCredentials", true);
			return "logIn";
		}
	}*/
	
	
	
}
