package com.capgemini.TrabajoFinal.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ConexcionConMySql mySQL= new ConexcionConMySql();
			Connection conn = mySQL.conectarMySQL();
			PreparedStatement ex = conn.prepareStatement("SELECT * FROM proyectofinalmatias.alumnos");
			
			 ResultSet rs = ex.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("idAlumno");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellido");
				String telefono= rs.getString("telefono");
				System.out.println(id + nombre + apellido + telefono);

			}
			
			
			 conn.close();
		}catch(Exception e)
		{
			System.out.println("entro error");
			System.out.println(e.getMessage());
		}
		
	}

}
