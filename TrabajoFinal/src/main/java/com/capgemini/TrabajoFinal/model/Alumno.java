package com.capgemini.TrabajoFinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;//pk
	
	private long idCurso;//pk
	private String nombre;
	private String apellido;
	private long DNI;
	
	@NotNull(message="El precio es obligatorio")
	private long telefono;
	private String mail;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public long getDNI() {
		return DNI;
	}
	public void setDNI(long dNI) {
		DNI = dNI;
	}
	
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", idCurso=" + idCurso + ", getNombre()=" + getNombre() + ", getApellido()="
				+ getApellido() + ", getDNI()=" + getDNI() + ", getTelefono()=" + getTelefono() + ", getMail()="
				+ getMail() + "]";
	}
	
	
	
}
