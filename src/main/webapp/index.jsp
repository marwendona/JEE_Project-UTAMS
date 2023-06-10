<%@ page import="tn.iit.model.Enseignant, tn.iit.controller.AjouteEnseignantController  , java.util.List"
         language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<a href="ajoutEnseignant.jsp">Ajouter Enseignant</a>

<table>
    <thead>
    <tr>
        <th>id</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tEnseignant}" var="e" varStatus="status">
        <tr>
            <td>${e.id}</td>
            <td>${e.nom}</td>
            <td>${e.prenom}</td>
            <td>

                <a href="Delete?id=${e.id}">Supp</a>
                <a href="Update?pos=${status.index}" class=" btn edit">Modif</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>

</html>