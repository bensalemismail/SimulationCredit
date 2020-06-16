package com.bensalem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bensalem.ws.OpperationsStub;
import com.bensalem.ws.OpperationsStub.Capital;
import com.bensalem.ws.OpperationsStub.CapitalResponse;
import com.bensalem.ws.OpperationsStub.Duree;
import com.bensalem.ws.OpperationsStub.DureeResponse;

/**
 * Servlet implementation class DureeServlet
 */
public class DureeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DureeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OpperationsStub stub = new OpperationsStub();
		Duree d = new Duree();
		double annuiteValue = Double.parseDouble(request.getParameter("inputAnnuiteD"));
		double capitalValue = Double.parseDouble(request.getParameter("inputCapitalD"));
		double tauxValue = (Double.parseDouble(request.getParameter("inputTauxD")))*0.01;
		double taux = (Double.parseDouble(request.getParameter("inputTauxD")));
		d.setA(annuiteValue);
		d.setC(capitalValue);
		d.setT(tauxValue);
		
		
		DureeResponse resp = stub.duree(d);
		double repDuree = resp.get_return();
		
		session.setAttribute("dureerepD", repDuree);
		
		session.setAttribute("capitalrepD", capitalValue);
		session.setAttribute("tauxrepD", taux);
		session.setAttribute("annuiterepD", annuiteValue);
		response.sendRedirect("Duree.jsp");
		//this.getServletContext().getRequestDispatcher( "Duree.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	doGet(request, response);
	}

}
