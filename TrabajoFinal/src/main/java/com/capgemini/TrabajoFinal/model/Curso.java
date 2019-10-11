package com.capgemini.TrabajoFinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long idCurso;//pk
	 private String nombreCurso;//pk
	 private int idProfesor;//pk
	 
	public long getIdCurso() {
		return idCurso;
	}
	
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	public int getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public Curso(long idCurso, String nombreCurso, int idProfesor) {
		super();
		this.idCurso = idCurso;
		this.nombreCurso = nombreCurso;
		this.idProfesor = idProfesor;
	}

	public Curso() {
		super();
	}
	
	 
	 
}
