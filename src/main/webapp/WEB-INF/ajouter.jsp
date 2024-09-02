<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 30/08/2024
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%
    String message = (String) request.getAttribute("message");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> titre </title>
</head>
<body>
<main>
    <jsp:include page="component/nav.jsp"/>


    <p><%= message != null ? message : "ajouter un chien"%></p>
    <form action="/ajouter" method="post">
        <label for="nom">Nom du chien</label>
        <input type="text" id="nom" name="nom"
               required
        >
        <label for="race">Race</label>
        <input type="text" id="race" name="race"
               required
        >
        <label for="dateDeNaissance">date de naissance </label>
        <input type="date" id="dateDeNaissance" name="dateDeNaissance" required>
        <button>send</button>

    </form>
</main>
</body>
</html>
