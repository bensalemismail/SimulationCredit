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
import com.bensalem.ws.OpperationsStub.Capital;
import com.bensalem.ws.OpperationsStub.CapitalResponse;

/**
 * Servlet implementation class CapitalServlet
 */
public class CapitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapitalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OpperationsStub stub = new OpperationsStub();
		Capital c = new Capital();
		double annuiteValue = Double.parseDouble(request.getParameter("inputAnnuiteC"));
		int dureeValue = Integer.parseInt(request.getParameter("inputDureeC"));
		double taux = (Double.parseDouble(request.getParameter("inputTauxC")));
		double tauxValue = (Double.parseDouble(request.getParameter("inputTauxC")))*0.01;
		c.setA(annuiteValue);
		c.setN(dureeValue);
		c.setT(tauxValue);
		
		CapitalResponse resp = stub.capital(c);
		double repCapital = resp.get_return();
		System.out.println(repCapital);
		
		session.setAttribute("capitalrepC", repCapital);
		
		session.setAttribute("annuiterepC", annuiteValue);
		session.setAttribute("dureerepC", dureeValue);
		session.setAttribute("tauxrepC", taux);
		response.sendRedirect("Capital.jsp");
		//this.getServletContext().getRequestDispatcher("Annuite.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
