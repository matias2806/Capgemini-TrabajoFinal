package com.capgemini.TrabajoFinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.TrabajoFinal.model.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno,Long> {

	//List<Alumno> findByName(String nombre);
	
	
}
