package com.bensalem.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bensalem.bean.ClientBean;

public class DBConnection {

	public static Connection createConnection() {

		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/SimulationDB";

		String username = "root"; //
		String password = "16065003m5db3";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Printing connection object " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	public String authenticateUser(ClientBean loginBean)
	 {
	 
	String email = loginBean.getEmail(); //Keeping user entered values in temporary variables.
	 String password = loginBean.getPassword();
	 
	Connection con = null;
	 Statement statement = null;
	 ResultSet resultSet = null;
	 
	String emailDB = "";
	 String passwordDB = "";
	 
	try
	 {
	 con = DBConnection.createConnection(); //establishing connection
	 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
	 resultSet = statement.executeQuery("select mailClient,mdpClient from Tclient"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
	 
	while(resultSet.next()){
	  emailDB = resultSet.getString("mailClient"); //fetch the values present in database
	  passwordDB = resultSet.getString("mdpClient");
	 
	   if(email.equals(emailDB) && password.equals(passwordDB))
	   {
	      return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
	   }
	 }
	 }
	 catch(SQLException e){
	 e.printStackTrace();
	 }
	 return "Invalid user credentials"; // Just returning appropriate message otherwise
	 }
	 

	public static void main(String[] args) throws SQLException {

		 
		    
	}

}
