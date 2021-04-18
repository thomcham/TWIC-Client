<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details de la ville</title>
</head>
<body>

	<h2>Detail de la ville ${ sessionScope.ville.nomCommune} :</h2>
	<h4>Code Postal : ${ sessionScope.ville.codePostal}</h4>
	<h4>Libelle : ${ sessionScope.ville.libelleAcheminement}</h4>
	<h4>Ligne : ${ sessionScope.ville.ligne}</h4>
	<h4>Latitude : ${ sessionScope.ville.latitude}</h4>
	<h4>Longitude : ${ sessionScope.ville.longitude}</h4>

	<h2>Modifer les informations de la ville</h2>

		<form method="post" action="">
			<input type="hidden" name="code" id="code" value="${ sessionScope.ville.codeCommune}" required /> <br>
		<label for="nom">Nom : </label>
			<input type="text" name="nom" id="nom" value="${ sessionScope.ville.nomCommune}" required /><br>
		<label for="codePostal">Code postal : </label>
			<input type="text" name="codePostal" id="codePostal" value="${ sessionScope.ville.codePostal}" required/><br>
		<label for="lib">Libelle : </label>
			<input type="text" name="lib" id="lib" value="${ sessionScope.ville.libelleAcheminement}" required/><br>
		<label for="ligne">Ligne : </label>
			<input type="text" name="ligne" id="ligne" value="${ sessionScope.ville.ligne}" required/><br>
		<label for="lat">Latitude : </label>
			<input type="text" name="lat" id="lat" value="${ sessionScope.ville.latitude}" required/><br>
		<label for="lon">Logitude : </label>
			<input type="text" name="lon" id="lon" value="${ sessionScope.ville.longitude}" required/><br>
			 
			<input type="submit" name="uptdate" value="Modifer" />
		</form>

	<p><a href="liste">Retour</a></p>
	
</body>
</html>