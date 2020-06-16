package com.bensalem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bensalem.model.Credit;

public class Compte {
	
	public static LinkedList<Credit> getAllCredits(int id) {
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		LinkedList<Credit> list = null;
		int idClient;
		
		try {

			//try {
			//	Class.forName("com.mysql.jdbc.Driver");
			//} catch (ClassNotFoundException e) {
			//	e.printStackTrace();
		//	}
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SimulationDB", "root", "16065003m5db3");
			con = DBConnection.createConnection();
			if(con!=null) {
			statement = con.createStatement();
			resultSet = statement
					.executeQuery("select * from Tcredit  ");
			list = new LinkedList<Credit>();
			
			while (resultSet.next()) // Until next row is present otherwise it return false
			{
				idClient = resultSet.getInt("client");	 // fetch the values present in database
				//System.out.println(idClient +" "+id);

				if (idClient == id) {
					Credit c = new Credit();
					c.setAnnuite(resultSet.getDouble("annuiteCredit"));
					c.setCapital(resultSet.getDouble("capitalCredit"));
					c.setTaux(resultSet.getDouble("tauxCredit"));
					c.setDuree(resultSet.getInt("dureeCredit"));
					c.setDate(resultSet.getString("dateCredit"));
					list.add(c);
				}
			}
		}else {
			System.out.println("Erreur de connexion dans Compte.java");
		}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return list;
	}

}
