<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="enseignant" class="tn.iit.model.Enseignant" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="enseignant"/>
	<div class="container">
		<h1>Inscription - Récapitulatif</h1>
		<div class="form-group">
			<%--@declare id="nom"--%><label for="nom">Nom :</label>
			<span>${enseignant.nom}</span>
		</div>
		
		<div class="form-group">
			<%--@declare id="prenom"--%><label for="prenom">Prénom :</label>
			<span>${enseignant.prenom}</span>
		</div>
		
		<div class="form-group">
			<a href="ajoutEnseignant.jsp" >Corriger</a>
			<a href="AjouteEnseignantController"  >Valider</a>
		</div>
	</div>

</body>
</html>