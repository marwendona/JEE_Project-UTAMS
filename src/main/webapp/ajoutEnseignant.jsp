<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Enseignant</title>
</head>
<body>

<jsp:useBean id="enseignant" class="tn.iit.model.Enseignant" scope="session"></jsp:useBean>
	<form method="post" action="verif.jsp">
		<div class="form-group">
			<label for="nom">Nom :</label>
			<input type="text" class="form-control" name="nom" id="nom" value='${enseignant.nom }' required>
		</div>
		<div class="form-group">
			<label for="prenom">Prenom :</label>
			<input type="text" class="form-control" name="prenom" id="prenom" value='${enseignant.prenom }' required>
		</div>
	
		
		<button type="submit" class="btn btn-primary btn-block">Valider</button>
	</form>


</body>
</html>