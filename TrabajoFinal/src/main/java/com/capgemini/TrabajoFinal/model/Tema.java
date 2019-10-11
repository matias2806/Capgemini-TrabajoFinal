package com.capgemini.TrabajoFinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tema {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTema;
	private String nombreDelCurso; //pk
	private int idCurso;//pk
	
	public long getIdTema() {
		return idTema;
	}
	
	public void setIdTema(long idTema) {
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

	public Tema(long idTema, String nombreDelCurso, int idCurso) {
		super();
		this.idTema = idTema;
		this.nombreDelCurso = nombreDelCurso;
		this.idCurso = idCurso;
	}

	public Tema() {
		super();
	}
	
	


	
}
