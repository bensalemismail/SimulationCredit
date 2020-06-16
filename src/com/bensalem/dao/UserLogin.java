package com.bensalem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bensalem.model.Client;

public class UserLogin {

	public static Client validateUser(String email, String password) {

		Client client = new Client();
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String emailDB = "";
		String passwordDB = "";

		try {

			con = DBConnection.createConnection();
			if(con!= null) {
			statement = con.createStatement();
			resultSet = statement
					.executeQuery("select * from Tclient");

			while (resultSet.next()) // Until next row is present otherwise it return false
			{
				emailDB = resultSet.getString("mailClient"); // fetch the values present in database
				passwordDB = resultSet.getString("mdpClient");

				if (email.equals(emailDB) && password.equals(passwordDB)) {
					client.setAdresse(resultSet.getString("adresseClient"));
					client.setTelephone(resultSet.getString("phoneClient"));
					client.setVille(resultSet.getString("villeClient"));
					client.setMail(resultSet.getString("mailClient"));
					client.setPrenom(resultSet.getString("prenomClient"));
					client.setNumeroClient(resultSet.getInt("numClient"));
					client.setNom(resultSet.getString("nomClient"));
					System.out.println(client);
				}
			}
		}else {
			System.out.println("Erreur de connexion dans UserLogin.java");
		}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return client;
	}
	
	

	

}
