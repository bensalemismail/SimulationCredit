package com.bensalem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bensalem.bean.ClientBean;
import com.bensalem.dao.DBConnection;
import com.bensalem.dao.UserLogin;
import com.bensalem.model.Client;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mailInputForm = request.getParameter("emailLogin");
		String passwordInputForm = request.getParameter("passwordLogin");

		Client client = UserLogin.validateUser(mailInputForm, passwordInputForm);

		if (client.getMail() != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("villeClient",client.getVille() );
			session.setAttribute("adresseClient", client.getAdresse());
			session.setAttribute("phoneClient",client.getTelephone() );
			session.setAttribute("emailClient", client.getMail());
			session.setAttribute("prenomClient", client.getPrenom());
			session.setAttribute("idClient", client.getNumeroClient());
			session.setAttribute("nomClient", client.getNom());
			//System.out.println("Srvlet :" + client);
			response.sendRedirect("Annuite.jsp");
			//this.getServletContext().getRequestDispatcher("Annuite.jsp").forward( request, response );
		} else {
			HttpSession errorLogin = request.getSession();
			errorLogin.setAttribute("errorLogin", "errorLogin");
			response.sendRedirect("Connexion.jsp");
			//this.getServletContext().getRequestDispatcher("Connexion.jsp").forward( request, response );
		}

	}
	
		
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request, response);

}
	}
