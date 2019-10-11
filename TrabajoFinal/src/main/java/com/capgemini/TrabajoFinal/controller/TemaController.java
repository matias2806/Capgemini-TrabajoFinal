package com.capgemini.TrabajoFinal.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.TrabajoFinal.model.Curso;
import com.capgemini.TrabajoFinal.model.Tema;
import com.capgemini.TrabajoFinal.service.ConexcionConMySql;

@Controller
public class TemaController {
	
	public List<Curso> listaCurso ;
	public List<Tema> listaTema ;
	public Tema tema;

	@GetMapping("/busquedaCursos")
	public String cargaPantallaBusqueda(Model model) {
		ConexcionConMySql SQL = new ConexcionConMySql();
		Connection conn = SQL.conectarMySQL();
		String sSQL = "";
		sSQL = "SELECT * FROM proyectofinalmatias.cursos;";
		listaCurso = new ArrayList<Curso>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sSQL);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				long idCurso = rs.getInt("idCurso");
				String nombreCurso = rs.getString("nombreDelCurso");
				int idProfesor = rs.getInt("idProfesor");
				Curso cur = new Curso(idCurso, nombreCurso, idProfesor);
				
				listaCurso.add(cur);
			}
			System.out.println(listaCurso.toString());
			
			model.addAttribute("cursos", listaCurso);
			conn.close();
		} catch (SQLException e) {
		} catch (Exception w) {
		} finally {
		}
		
		model.addAttribute("aBuscar",  new Curso() );
		return "busquedaCursos";
	}

	@PostMapping("/busquedaCursos")
	public String alumnoSubmit(@ModelAttribute Curso aBuscar, Model model) {
		//System.out.println("id"+aBuscar.getIdCurso());
		//System.out.println("nombre"+aBuscar.getNombreCurso());
		//me guarda en el nombre el Id de ese curso no se por que de ahi en mas sigo
		listaTema = new ArrayList<Tema>();
		ConexcionConMySql SQL = new ConexcionConMySql();
		Connection conn = SQL.conectarMySQL();
		String sSQL = "";
		
		sSQL = "select * from temas where idCurso="+aBuscar.getNombreCurso()+";";
		// PreparedStatement
		//System.out.println("antes del try");
		try {
			PreparedStatement pstm = conn.prepareStatement(sSQL);
			ResultSet rs = pstm.executeQuery();
			//System.out.println("antes del while");
			while (rs.next()) {
				long idTema = rs.getInt("idTema");
				String nombreCurso = rs.getString("nombreDelCurso");
				int idCurso = rs.getInt("idCurso");
				Tema tema = new Tema(idTema, nombreCurso, idCurso);
				//System.out.println("en wl while");
				listaTema.add(tema);
			}
			//System.out.println("desp del while");
			//System.out.println(listaCurso.toString());
			if(!(listaTema.isEmpty())) {
				model.addAttribute("listadoDeTemas",listaTema);
				return "muestraTabla";
			}
			
			//model.addAttribute("cursos", listaCurso);
			conn.close();
		} catch (SQLException e) {
		} catch (Exception w) {
		} finally {
		}
		//System.out.println("no entre a ningun catch");
		return "busquedaCursos"; // despues cambiarlo por home
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
