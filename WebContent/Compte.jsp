<%@page import="java.util.LinkedList"%>
<%@page import="com.bensalem.model.Credit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Mon compte</title>

<link rel="icon" href="bank-building32.png" type="image/ico" />
<!-- Bootstrap core CSS -->
<link href="Custum/bensalem.css" rel="stylesheet">

<!-- Font Awesome -->
<link rel="stylesheet" href="css/all.min.css">

<!-- Custom styles for this template -->
<link href="css/scrolling-nav.css" rel="stylesheet">
<link rel="stylesheet" href="css/styling.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">


</head>

<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-mycolor3 fixed-top"
		id="mainNav">
		<div class="container justify-content-between">
			<a
				class="mr-5 navbar-brand font-weight-bold text-white js-scroll-trigger "
				href="Annuite.jsp"> <i class="fas fa-university"></i> Simulation
				de crédit
			</a>








		</div>
		
	</nav>

	<div class="jumbotron jumbotron-fluid bg-mycolor3">
		<div class="container">
			<h1 class="display-4 text-center text-uppercase font-weight-bold text-white">${nomClient}
				${prenomClient }</h1>
			<p class="lead text-center  text-white">${adresseClient }
				${villeClient }<br />${emailClient }<br />${phoneClient}</p>
			
		</div>
	</div>




	<!-- <section style="height: 733px;"> -->


		<div class="container ">


			<table class="table table-hover table-bordered ">
				<thead>
					<tr>
						<th scope="col" class="text-mycolor3 text-center">Annuite</th>
						<th scope="col" class="text-mycolor3 text-center">Capital</th>
						<th scope="col" class="text-mycolor3 text-center">Taux</th>
						<th scope="col" class="text-mycolor3 text-center">Durée</th>
						<th scope="col" class="text-mycolor3 text-center">Date</th>

					</tr>
				</thead>
				<tbody>
					
					<%
					if (session.getAttribute("allCredits") != null) {
						LinkedList<Credit> l = (LinkedList<Credit>)session.getAttribute("allCredits");
						System.out.println(l);
						for(Credit c : l){
					%>		
					
					
					<tr>
						<td class="text-center"><%=c.getAnnuite() %> </td>
						<td class="text-center"><%=c.getCapital() %></td>
						<td class="text-center"><%=c.getTaux() %></td>
						<td class="text-center"><%=c.getDuree() %></td>
						<td class="text-center"><%=c.getDate() %></td>
					</tr>

<%
						}
					}else{
					
%>
					<tr>
					<td colspan="5" class="text-center">Vous avez pas encore simuler aucun crédit.</td>
					</tr>

<%} %>









				</tbody>
			</table>

		</div>

	<!-- </section> -->
	

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom JavaScript for this theme -->
	<script src="js/scrolling-nav.js"></script>


</body>

</html>
