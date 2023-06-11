<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<form method="post" action="Update" class="container mt-4">
    <input type="hidden" name="pos" value="${pos}">
    <div class="form-group">
        <label for="nom"><strong>Nom:</strong></label>
        <input type="text" name="nom" class="form-control" value="${enseignant.nom}">
    </div>
    <div class="form-group">
        <label for="prenom"><strong>Prenom:</strong></label>
        <input type="text" name="prenom" class="form-control" value="${enseignant.prenom}">
    </div>
    
    <input type="submit" value="Valider" class="btn btn-success">
</form>



</body>
</html>