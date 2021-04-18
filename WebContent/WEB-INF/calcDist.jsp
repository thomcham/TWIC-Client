<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calcule de la distance entre deux villes</title>
</head>
<body>

	<p>
		<a href="liste">Liste des villes.</a>
	</p>

	<form method="post" action="">
		<select name="numVille1">
			<c:forEach var="i" begin="0" end="${ sessionScope.nbVilles}" step="1">
				<option value=${ i }>${ sessionScope.liste[i].nomCommune}</option>
			</c:forEach>
		</select> <select name="numVille2">
			<c:forEach var="i" begin="0" end="${ sessionScope.nbVilles}" step="1">
				<option value=${ i }>${ sessionScope.liste[i].nomCommune}</option>
			</c:forEach>
		</select> <input type="submit" name="calcul" />
		
		<p>Distance entre  ${ sessionScope.v1.nomCommune } et ${ sessionScope.v2.nomCommune } :</p>

		<p>d = ${ empty sessionScope.dist? '***' : sessionScope.dist  }km</p>

	</form>



</body>
</html>