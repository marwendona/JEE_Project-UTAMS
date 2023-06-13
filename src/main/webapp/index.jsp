<%@ page import="tn.iit.model.Enseignant, tn.iit.controller.AjouteEnseignantController, java.util.List" language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des enseignants</title>
    <!-- Inclure les fichiers CSS de Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <!-- Inclure la feuille de style personnalisée -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="container">

    <h1>Liste des enseignants</h1>

    <a href="ajoutEnseignant.jsp" class="btn btn-primary">Ajouter Enseignant</a>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Institut</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tEnseignant}" var="e" varStatus="status">
            <tr>
                <td>${e.id}</td>
                <td>${e.nom}</td>
                <td>${e.prenom}</td>
                <td>${e.institut}</td>
                <td>
                    <button href="Update?id=${status.index}" class="invisible">Mon bouton invisible</button>
                    <a href="Delete?idens=${e.id}" class="btn btn-danger">Supprimer</a>
                    <a href="Update?idens=${e.id}" class="btn btn-primary edit">Modifier</a>
                    <a href="EditAutorisationController?idens=${e.id}" class="btn btn-secondary">Afficher autorisation</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<!-- Inclure les fichiers JavaScript de Bootstrap -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi4+Nsz"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNVQ8bc"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>