package com.bensalem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bensalem.dao.UserSignUp;
import com.bensalem.model.Client;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Client newClient = new Client();
		String nomInputForm = request.getParameter("nomSU");
		String prenomInputForm = request.getParameter("prenomSU");
		String mailInputForm = request.getParameter("emailSU");
		String passwordInputForm = request.getParameter("password1SU");
		String adresseInputForm = request.getParameter("adresseSU");
		String villeInputForm = request.getParameter("villeSU");
		String phoneInputForm = request.getParameter("phoneSU");
		newClient.setNom(nomInputForm);
		newClient.setPrenom(prenomInputForm);
		newClient.setMail(mailInputForm);
		newClient.setMotdepasse(passwordInputForm);
		newClient.setAdresse(adresseInputForm);
		newClient.setVille(villeInputForm);
		newClient.setTelephone(phoneInputForm);
		boolean exist = UserSignUp.isExist(mailInputForm);

		if (!exist) {
			boolean check = UserSignUp.registerClient(newClient);

			if (check) {
				HttpSession session = request.getSession(true);

				response.sendRedirect("Connexion.jsp");

			}
		} else {

			HttpSession error = request.getSession();
			error.setAttribute("error", "Error");
			response.sendRedirect("Inscription.jsp");
			

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
