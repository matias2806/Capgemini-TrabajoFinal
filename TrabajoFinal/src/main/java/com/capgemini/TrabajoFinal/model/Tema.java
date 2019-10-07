package com.capgemini.TrabajoFinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tema {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idTema;
	private String nombreDelCurso; //pk
	private int idCurso;//pk
	
	public String getIdTema() {
		return idTema;
	}
	
	public void setIdTema(String idTema) {
		this.idTema = idTema;
	}

	public String getNombreDelCurso() {
		return nombreDelCurso;
	}
	public void setNombreDelCurso(String nombreDelCurso) {
		this.nombreDelCurso = nombreDelCurso;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}


	
}
