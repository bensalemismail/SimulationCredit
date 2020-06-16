package com.bensalem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bensalem.ws.OpperationsStub;
import com.bensalem.ws.OpperationsStub.Annuite;
import com.bensalem.ws.OpperationsStub.AnnuiteResponse;

/**
 * Servlet implementation class AnnuiteServlet
 */
public class AnnuiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnnuiteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		OpperationsStub stub = new OpperationsStub();
		Annuite a = new Annuite();
		double capitalValue = Double.parseDouble(request.getParameter("inputCapital"));
		int dureeValue = Integer.parseInt(request.getParameter("inputDuree"));
		double taux = (Double.parseDouble(request.getParameter("inputTaux")));
		double tauxValue = (Double.parseDouble(request.getParameter("inputTaux"))) * 0.01;
		a.setC(capitalValue);
		a.setN(dureeValue);
		a.setT(tauxValue);
		System.out.println("capital = " + capitalValue);
		System.out.println(dureeValue);
		System.out.println(tauxValue);

		AnnuiteResponse resp = stub.annuite(a);
		double repAnnuite = resp.get_return();
		System.out.println(repAnnuite);

		session.setAttribute("anuiterepA", repAnnuite);

		session.setAttribute("capitalrep", capitalValue);
		session.setAttribute("tauxrep", taux);
		session.setAttribute("dureerep", dureeValue);
		response.sendRedirect("Annuite.jsp");
		// this.getServletContext().getRequestDispatcher("Annuite.jsp").forward(
		// request, response );

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
