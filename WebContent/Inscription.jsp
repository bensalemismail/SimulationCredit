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

<title>Inscription</title>

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

<%
if (session.getAttribute("error") != null) {
%>
<script>alert("Cet email est déjà utilisé. Essayer un aure email.");</script>
<%}
session.removeAttribute("error");
%>
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









	<section id="skills" style="height: 733px;">
		<div class="container">
			<div class="row">



				<div class="col-lg-10 mx-auto">
					<h1 class=" text-center font-weight-bold">Inscrivez-vous et
						simulez votre crédit librement.</h1>
					<div class="divider-custom divider-light ">
						<div class="divider-custom-line bg-mycolor3"></div>
						<div class="divider-custom-icon">
							<i class="fas fa-star text-mycolor3"></i>
						</div>
						<div class="divider-custom-line bg-mycolor3"></div>
					</div>
					<!--  -->



					<div class="container col-8 rounded border border-mycolor3 ">

						<form class="m-4 mt-3 needs-validation" method="POST"
							action="SignUpServlet" novalidate>
							<div class="form-row">
								<div class="form-group col">
									<input type="text" class="form-control" name="prenomSU"
										placeholder="Entrez votre prénom" required>
									<div class="invalid-feedback">Prénom est obligatoire.</div>
									<div class="valid-feedback">Valid input.</div>
								</div>
								<div class="form-group col">
									<input type="text" class="form-control" name="nomSU"
										placeholder="Entrez votre nom" required>
									<div class="invalid-feedback">Nom est obligatoire.</div>
									<div class="valid-feedback">Valid input.</div>
								</div>
							</div>

							<div class="form-group">
								<input type="email" class="form-control" name="emailSU"
									placeholder="Entrez votre email" required>
								<div class="invalid-feedback">Veuillez entrer un email
									valide.</div>
								<div class="valid-feedback">Valid input.</div>
							</div>
							
							
								<div class="form-group ">
									<input type="password" id="mdp1" class="form-control" name="password1SU"
										placeholder="Entrez votre mot de passe" required>
									<div class="invalid-feedback">Veuillez entrer votre mot
										de passe.</div>
									<div class="valid-feedback">Valid input.</div>
								</div>
							

							<div class="form-group">
								<input type="text" class="form-control" name="adresseSU"
									placeholder="Entrez votre adresse" required>
								<div class="invalid-feedback">Veuillez entrer votre
									adresse</div>
								<div class="valid-feedback">Valid input.</div>
							</div>
							<div class="form-row">
								<div class="form-group col">
									<input type="text" class="form-control" name="villeSU"
										placeholder="Entrez votre ville ..." required>
									<div class="invalid-feedback">Veuillez entrer votre
										ville.</div>
									<div class="valid-feedback">Valid input.</div>
								</div>
								<div class="form-group col">
									<input type="tel" class="form-control" name="phoneSU"
										placeholder="Entrez votre numéro de téléphone" required>
									<div class="invalid-feedback">Saisie invalide.</div>
									<div class="valid-feedback">Valid input.</div>
								</div>
							</div>
							<div class=" form-group row justify-content-around ">
								<input type="reset" class="mt-3 col-5 btn btn-outline-mycolor3"
									id="" value="Effacer" /> <input type="submit"
									class="mt-3 col-5 btn btn-outline-mycolor3 text-black" id=""
									value="s'inscrire" />
							</div>
							<div class="text-muted text-center">
								Dejà membre ? <a class="text-mycolor3" href="Connexion.jsp">Connectez-vous</a>
							</div>

						</form>







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
