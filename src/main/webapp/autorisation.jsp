<%@ page import="tn.iit.model.Enseignant, tn.iit.controller.EditAutorisationController, java.util.List" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détails enseignant</title>
    <!-- Inclure les fichiers CSS de Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <!-- Inclure la feuille de style personnalisée -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div>
<br>
<br>

    <a href="index.jsp" class="btn btn-secondary">Retour</a>
    <a href="ajoutAutorisation.jsp" class="btn btn-primary ml-2">Ajouter Autorisation</a>


</div>

    <div class="container mt-4">
        <div class="form-group">
            <label for="nom"><strong>Nom :</strong></label>
            <span>${enseignant.nom}</span>
        </div>
        <div class="form-group">
            <label for="prenom"><strong>Prénom :</strong></label>
            <span>${enseignant.prenom}</span>
        </div>
        <div class="form-group">
            <label for="institut"><strong>Institut :</strong></label>
            <span>${enseignant.institut}</span>
        </div>
    </div>

    <div class="container mt-4">
        <table class="table">
            <thead>
                <tr>
                    <th>idAutorisation</th>
                    <th>nbHeurSemaine</th>
                    <th>date</th>
                    <th>action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${tAutorisation}" var="e" varStatus="status">
                    <tr>
                        <td>${e.idAutorisation}</td>
                        <td>${e.nbHeurSemaine}</td>
                        <td>${e.date}</td>
                        <td>
                            <a href="DeleteAutorisatioController?idauto=${e.idAutorisation}" class="btn btn-danger mr-2">Supprimer</a>
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