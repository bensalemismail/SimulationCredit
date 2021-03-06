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

<title>Simulation de crédit</title>

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


			<%
				if (session.getAttribute("emailClient") == null) {
			%>
			<span> <a href="Connexion.jsp">
					<button class="btn btn-outline-secondary">Se connecter</button>
			</a>
			</span>
			<%
				}

				else {
			%>
			<form action="SaveCreditDureeServlet" method="POST">
				<input type="submit"
					class=" btn btn-outline-secondary" id="calculer"
					name="calculer" value="Enregistrer" />
			</form>
			<div class="form-row">


				<form action="CompteServlet" method="POST" class="col">
					<button class="btn btn-outline-secondary">Mon compte</button>
				</form>
				<form action="LogoutServlet" method="POST" class="col">
					<button class="btn btn-outline-secondary">Déconnextion</button>
				</form>

			</div>
			<%
				}
			%>


		</div>
		</div>
	</nav>









	<section id="skills" style="height: 733px;">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 mx-auto">
					<%
						if (session.getAttribute("prenomClient") != null && session.getAttribute("nomClient") != null) {
					%>
					<h1 class=" text-center font-weight-bold">Bienvenue cher
						${prenomClient} ${nomClient}</h1>
					<%
						} else {
					%>
					<h1 class=" text-center font-weight-bold">Bienvenue cher
						client</h1>
					<%
						}
					%>
					<div class="divider-custom divider-light ">
						<div class="divider-custom-line bg-mycolor3"></div>
						<div class="divider-custom-icon">
							<i class="fas fa-star text-mycolor3"></i>
						</div>
						<div class="divider-custom-line bg-mycolor3"></div>
					</div>
					<!--  -->



					<div class="container ">

						<ul class="nav  mt-4 mb-4 d-flex justify-content-center"
							id="pills-tab" role="tablist">
							<li class="col-4 nav-item"><a
								class=" nav-link  myitem btn btn-outline-mycolor3"
								id="pills-home-tab" href="Annuite.jsp">Annuité</a></li>
							<li class="col-4 nav-item"><a
								class=" nav-link myitem  btn btn-outline-mycolor3"
								id="pills-profile-tab" href="Capital.jsp">Capital</a></li>
							<li class="col-4 nav-item"><a
								class=" nav-link myitem active btn btn-outline-mycolor3"
								id="pills-contact-tab" href="Duree.jsp">Durée</a></li>

						</ul>
						<!-- <div class="tab-pane fade" id="pills-duree" role="tabpanel" aria-labelledby="pills-contact-tab">
                                <div class=""> -->
						<form id="formDuree" action="DureeServlet"
							class="needs-validation" method="POST" novalidate>
							<div class="form-group row">
								<label for="inputAnnuiteD" class="col-3 col-form-label">Entrez
									votre Anuité :</label>
								<div class="col-9">
									<%
										if (session.getAttribute("annuiterepD") != null) {
									%>
									<input type="number" class="form-control " id="inputAnnuiteD"
										name="inputAnnuiteD" value=${annuiterepD } step="any" placeholder="Annuité" required>
										<%}else{ %>
										<input type="number" class="form-control " id="inputAnnuiteD"
										name="inputAnnuiteD"  step="any" placeholder="Annuité" required>
										<%} %>
									<div class="invalid-feedback">Ce champ est obligatoire.</div>
									<div class="valid-feedback">Valid input.</div>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputCapitalD" class="col-3 col-form-label">Entrez
									votre capitale :</label>
								<div class="col-9">
								<%
										if (session.getAttribute("capitalrepD") != null) {
									%>
									<input type="number" class="form-control" id="inputCapitalD"
										name="inputCapitalD" value=${capitalrepD } step="any" placeholder="Capitale"
										required>
										<%}else{ %>
										<input type="number" class="form-control" id="inputCapitalD"
										name="inputCapitalD"  step="any" placeholder="Capitale"
										required>
										<%} %>
									<div class="invalid-feedback">Ce champ est obligatoire.</div>
									<div class="valid-feedback">Valid input.</div>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputTauxD" class="col-3 col-form-label">Spécifiez
									un taux en (%) :</label>
								<div class="col-9">
								<%
										if (session.getAttribute("tauxrepD") != null) {
									%>
									<input type="number" class="form-control" id="inputTauxD"
										name="inputTauxD" value=${tauxrepD } placeholder="Taux en %" min="1" max="100"
										required>
										<%}else{ %>
										<input type="number" class="form-control" id="inputTauxD"
										name="inputTauxD" placeholder="Taux en %" min="1" max="100"
										required>
										<%} %>
									<div class="invalid-feedback">Le taux doit être compris
										entre 1 et 100.</div>
									<div class="valid-feedback">Valid input.</div>
								</div>
							</div>
							<div class=" form-group row justify-content-around">
								<input type="submit"
									class="mt-3 col-5 btn btn-outline-mycolor3 text-black"
									id="calculerD" value="Calculer" />
								
							</div>

							<%
								if (session.getAttribute("dureerepD") != null) {
							%>

							<div class="alert alert-mycolor3" role="alert">
								<h4 class="alert-heading">Well done!</h4>
								<hr>
								<h5>Durée = ${dureerepD}</h5>
							</div>


							<%
								}
							%>

						</form>
						<!--   </div>  
                            </div> -->


					</div>


				</div>

			</div>
		</div>
		</div>
	</section>

	<!-- Footer -->
	<footer class="py-2 bg-mycolor3">
		<div class="container d-flex justify-content-center">
			<p class=" text-white">2019 &copy; BENSALEM Ismail</p>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom JavaScript for this theme -->
	<script src="js/scrolling-nav.js"></script>

	<script>
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Fetch all the forms we want to apply custom Bootstrap validation styles to
						var forms = document
								.getElementsByClassName('needs-validation');

						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {

										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');

									}, false);
								});
					}, false);
		})();
	</script>
</body>

</html>
