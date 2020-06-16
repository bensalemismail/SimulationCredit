package com.bensalem.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bensalem.dao.SaveCredit;
import com.bensalem.model.Credit;

/**
 * Servlet implementation class SaveCreditServlet
 */
public class SaveCreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCreditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
HttpSession session = request.getSession();
if(session.getAttribute("capitalrep") != null && session.getAttribute("tauxrep")!= null && session.getAttribute("anuiterepA") !=null 
&& session.getAttribute("dureerep")!=null) {
		Credit c = new Credit();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date d = new Date();
		 String dateA = dateFormat.format(d);
		 double capitalA = (double)session.getAttribute("capitalrep");
		 double tauxA = (double)session.getAttribute("tauxrep");
		 double annuiteA = (double)session.getAttribute("anuiterepA");
		 int dureeA = (int)session.getAttribute("dureerep");
		 
		 int numeroClient = (int)session.getAttribute("idClient");
		 c.setDate(dateA);c.setCapital(capitalA);c.setTaux(tauxA);c.setAnnuite(annuiteA);c.setDuree(dureeA);c.setClientnum(numeroClient);
		 boolean check = SaveCredit.saveNewCredit(c);
		 if(check) {
			 //System.out.println("Srvlet :"+c);
			  response.sendRedirect("Annuite.jsp");
			 // this.getServletContext().getRequestDispatcher("Annuite.jsp").forward( request, response );
		 }else {
			 System.out.println("ERROR !!");
			 response.sendRedirect("Annuite.jsp");
		 }
	}else {
		response.sendRedirect("Annuite.jsp");
	}
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}
