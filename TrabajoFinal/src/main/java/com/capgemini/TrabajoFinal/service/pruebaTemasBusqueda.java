package com.capgemini.TrabajoFinal.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class pruebaTemasBusqueda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ConexcionConMySql mySQL= new ConexcionConMySql();
			Connection conn = mySQL.conectarMySQL();
			PreparedStatement ex = conn.prepareStatement("SELECT * FROM proyectofinalmatias.tema");
			
			 ResultSet rs = ex.executeQuery();
			while(rs.next()) {
				String id = rs.getString("idTema");
				String nombreTema = rs.getString("nombreDelCurso");
				String idCurso = rs.getString("idCurso");
				
				System.out.println(id + nombreTema + idCurso);

			}
			
			
			 conn.close();
		}catch(Exception e)
		{
			System.out.println("entro error");
			System.out.println(e.getMessage());
		}
		
	}
	
}








