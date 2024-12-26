<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Absents</title>
    <style>
        h1 {
            text-align: center;
            margin-top: 10px;
            margin-bottom:30px;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
             box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #008ecf;
            color: #fff;
        }
        input[type="checkbox"] {
            margin-left: 5px;
        }

        button {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            display: block;
            margin: 20px auto;
            width: 140px;
            height:40px;
            font-size:18px;
            }
		#date {
		    width:300px; /* Ajustez la largeur du champ de saisie */
		    padding: 8px;
		    margin-bottom: 10px;
		    box-sizing: border-box;
		    background: #eee;
		    border: none;
		    border-radius: 10px;
		    padding: 12px 15px;
		    margin-left:120px;
		    height:50px;
		    font-size:18px;
		    
		}
       .search-button {
		    margin-right:20px;
		    margin-left:500px;
		    padding: 16px;
		    background-color: #008ecf;
		    color: #fff;
		    border: none;
		    border-radius: 15px;
		    cursor: pointer;
		    width:50px;
		    height:50px;
		    margin-top:-60px;
		    margin-bottom:50px;
		    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
		}
		
		.search-button:hover {
		    background-color:#007bff;
		}
		
		.search-button .ion-icon {
		    font-size: 20px;
		}
		/*
   
    </style>
</head>
<body>
<div class="main">
        <div class="topbar">
                <div class="toggle">
                    <ion-icon name="menu-outline"></ion-icon>
                </div>
            </div>
<h1>Liste des Absents</h1>
<form action="Servlettoutstagiaireabscent" method="post">
        <input type="date" id="date" name="dateInput">
    			<button class="search-button">
        			<ion-icon class="ion-icon" name="search-outline"></ion-icon>
    			</button>
</form>
<c:choose>
    <c:when test="${afficherTable == true}">
    <table>
		        <thead>
		            <tr>
		                <th>Nom</th>
		                <th>Prénom</th>
		                <th>Absent</th>
		            </tr>
		        </thead>
		        <tbody>
		<c:forEach var="stagiaire" items="${stagiaires}" varStatus="loop">
    <tr>
        <td>${stagiaire.nom}</td>
        <td>${stagiaire.prenom}</td>
        <td>
            <c:if test="${fn:contains(listdesabscents, stagiaire.id_stagiaire)}">
    			<input type="checkbox" name="absents" value="${stagiaire.id_stagiaire}" checked />
			</c:if>
			<c:if test="${not fn:contains(listdesabscents, stagiaire.id_stagiaire)}">
			    <input type="checkbox" name="absents" value="${stagiaire.id_stagiaire}" />
			</c:if>
        </td>
    </tr>
</c:forEach>
     </tbody>
</table>
    </c:when>
    <c:when test="${afficherTable == false}">
    <form action="TraitementAbscent" method="post">
		    <table>
		        <thead>
		            <tr>
		                <th>Nom</th>
		                <th>Prénom</th>
		                <th>Absent</th>
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach var="stagiaire" items="${stagiaires}" varStatus="loop">
		                <tr>
		                    <td>${stagiaire.nom}</td>
		                    <td>${stagiaire.prenom}</td>
		                    <td>
		                        <input type="checkbox" name="absents" value="${stagiaire.id_stagiaire}" />
		                    </td>
		                </tr>
		            </c:forEach>
		        </tbody>
		    </table>
		    <button type="submit">Valider</button>
		</form>
</c:when>
<c:otherwise></c:otherwise>
</c:choose>
</div>
</body>
</html>
