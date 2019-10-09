package com.capgemini.TrabajoFinal.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.TrabajoFinal.model.Tema;
import com.capgemini.TrabajoFinal.service.ConexcionConMySql;

@Controller
public class TemaController {

	private List<Tema> listaTemas;
	public Tema tema;

	@GetMapping("/busquedaCursos")
	public String cargaPantallaBusqueda(Model model) {
		model.addAttribute("aBuscar", new Tema());
		return "busquedaCursos";
	}

	@PostMapping("/busquedaCursos")
	public String alumnoSubmit(@ModelAttribute List<Tema> listaTemas) {
		
		ConexcionConMySql SQL = new ConexcionConMySql();
		Connection conn = SQL.conectarMySQL();
		String sSQL = "";

		sSQL = "SELECT * FROM proyectofinalmatias.tema;";
		// PreparedStatement
		try {
			PreparedStatement pstm = conn.prepareStatement(sSQL);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				String id = rs.getString("idTema");
				String nombreTema = rs.getString("nombreDelCurso");
				int idCurso = rs.getInt("idCurso");

				tema.setIdCurso(Integer.parseInt(id));
				tema.setNombreDelCurso(nombreTema);
				tema.setIdTema(idCurso);

				listaTemas.add(tema);
			}
			conn.close();
		} catch (SQLException e) {
		} catch (Exception w) {
		} finally {
		}

		return "muestraTabla"; // despues cambiarlo por home
	}

	/*
	 * ACA TE RECORRIA LA TABLA PERO SOLO SIRVE PARA UN ELEMENTO
	 * 
	 * @GetMapping("/busquedaCursos") public String cargaPantallaBusqueda(Model
	 * model) { model.addAttribute("aBuscar", new Tema()); return "busquedaCursos";
	 * }
	 * 
	 * 
	 * @PostMapping("/busquedaCursos") public String alumnoSubmit(@ModelAttribute
	 * Tema tema) {
	 * 
	 * ConexcionConMySql SQL = new ConexcionConMySql(); Connection conn =
	 * SQL.conectarMySQL(); String sSQL = "";
	 * 
	 * sSQL = "SELECT * FROM proyectofinalmatias.tema;"; // PreparedStatement try {
	 * PreparedStatement pstm = conn.prepareStatement(sSQL); ResultSet rs=
	 * pstm.executeQuery();
	 * 
	 * while(rs.next()) { String id = rs.getString("idTema"); String nombreTema =
	 * rs.getString("nombreDelCurso"); int idCurso = rs.getInt("idCurso");
	 * 
	 * tema.setIdCurso(Integer.parseInt(id)); tema.setNombreDelCurso(nombreTema);
	 * tema.setIdTema(idCurso);
	 * 
	 * }
	 * 
	 * conn.close(); }catch(SQLException e) {
	 * 
	 * }catch(Exception w) {
	 * 
	 * }finally {
	 * 
	 * }
	 * 
	 * 
	 * return "muestraTabla"; //despues cambiarlo por home }
	 */
}
