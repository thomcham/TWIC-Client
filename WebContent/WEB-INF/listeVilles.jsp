<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>
</head>
<body>

<p><a href="calc">Calcul de la distance entre deux villes.</a></p>

	<h1>Liste des villes de France</h1>
	
	<table  border="1">
    <tr>
        <th>Nom</th>
        <th>Code Postal</th>

    </tr>
    
	<c:forEach var="i" begin="0" end="${ sessionScope.nbVilles - 1}" step="1">
    	<tr>
        	<td><a href="details?numero=${ i }">${ sessionScope.liste[i].nomCommune}</a></td>
        	<td>${ sessionScope.liste[i].codePostal}</td>
    	</tr>
	</c:forEach>

</table>

</body>
</html>