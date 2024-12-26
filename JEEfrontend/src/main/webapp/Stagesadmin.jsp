<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Liste des éléments</title>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script  src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,700&display=swap" rel="stylesheet">
    <style>
        .container-stag {
            max-width: 800px;
            margin-left: 5px;
            background-color: #fff;
            padding: 20px;
            font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        .text-right {
            text-align: right;
        }
table {
    border-collapse: separate;
    border-spacing: 0;
    width: 100%;
    background-color: #fff;
    border-radius: 8px;
    overflow: hidden;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.6);
    font-size:16px;
    margin-left:200px;
}

th,
td {
    padding: 10px;
    text-align: left;
    line-height: 1.4;
}

thead {
    background-color: #f2f2f2;
    border-bottom: 2px solid #ddd; 
}

thead th {
    font-weight: bold;
    color: #000;
    border: none;
}

tbody tr:nth-child(even) {
    background-color: #f9f9f9;
}

tbody td {
    border: none;
}


tbody tr:not(:last-child) {
    border-bottom: 1px solid #ddd;
}

tbody tr:last-child {
    border-bottom: none;
}

        .action-buttons button {
            margin-right: 5px;
        }

.action-buttons button {
    margin-right: 5px;
}


.editerbutton img {
    width: 20px;
    height: 20px;
}


td:last-child {
    border: none;
}

        .action-buttons button {
            margin-right: 5px;
        }

        

		 .search-bar {
		    display: flex;
		    align-items: center;
		    width: 700px; 
		    margin-left:300px;
		    margin-top:-29px;
		    margin-bottom:40px;
		}
		
		.search-input {
		    flex: 1; 
		    padding: 10px;
		    font-size: 16px;
		    border: 1px solid #ccc;
		    border-radius: 15px;
		    width:500px;
		    height:50px;
		    margin-right: 5px;
		    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); 
		}
		
		.search-button {
		    margin-right:20px;
		    margin-left:-27px;
		    padding: 16px;
		    background-color: #008ecf;
		    color: #fff;
		    border: none;
		    border-radius: 15px;
		    cursor: pointer;
		    height:50px;
		    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
		}
		
		.search-button:hover {
		    background-color:#007bff;
		}
		
		.search-button .ion-icon {
		    font-size: 20px;
		}
	




		.pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
            margin-left:450px;
            border-radius: 4px;
        }

        .pagination a {
            color: #008ecf;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color 0.3s;
            border: 1px solid #ddd;
            margin: 0 5px;
        }

        .pagination a.active {
            background-color: #008ecf;
            color: white;
        }

        .pagination a:hover:not(.active) {
            background-color: #008ecf;
            color: white;
        }
        .highlight {
           background-color: #B2E1F5;
}
    </style>
</head>

<body>
<div class="main">
        <div class="topbar">
                <div class="toggle">
                    <ion-icon name="menu-outline"></ion-icon>
                </div>
            </div>
    <div class="container-stag">
        <!-- Barre de recherche -->
           <div class="search-bar">
                <form action="SearchStage" method="post" style="display: flex; align-items: center;">
    			<input type="text" class="search-input" placeholder="Rechercher..." name="keyword">
    			<button class="search-button">
        			<ion-icon class="ion-icon" name="search-outline"></ion-icon>
    			</button>
    			</form>
     		</div>
        <table>
            <thead style="background-color: #f9f9f9; color: #000;">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Sujet</th>
                    <th scope="col">Date_debut</th>
                    <th scope="col">Date_fin</th>
                    <th scope="col">Division</th>
                    <th scope="col">Encadrant</th>
                    <th scope="col">Statut</th>
                    <th scope="col">Type</th>
                </tr>
            </thead>
            <tbody>
            <c:if test="${not empty stages}">
                        <c:set var="itemsPerPage" value="10" />
                        <c:set var="totalItems" value="${fn:length(stages)}" />
                        <c:set var="totalPages" value="${(totalItems + itemsPerPage - 1) / itemsPerPage}" />
                        <c:set var="currentPage" value="${empty param.page ? 1 : param.page}" />
                        <c:set var="startIndex" value="${(currentPage - 1) * itemsPerPage}" />
                        <c:set var="endIndex" value="${(startIndex + itemsPerPage < totalItems) ? (startIndex + itemsPerPage) : totalItems}" />
                        <c:forEach var="index" begin="${startIndex + 1}" end="${endIndex}">
                            <c:set var="stage" value="${stages[index - 1]}" />
		                     <tr>
		                     <td class="${not empty keyword && fn:containsIgnoreCase(stage.id_stage, keyword) ? 'highlight' : ''}">
								        ${stage.id_stage}
								    </td>
								    <td class="${not empty keyword && fn:containsIgnoreCase(stage.sujet, keyword) ? 'highlight' : ''}">
								        ${stage.sujet}
								    </td>
								    <td class="${not empty keyword && fn:containsIgnoreCase(stage.date_debut, keyword) ? 'highlight' : ''}">
								        ${stage.date_debut}
								    </td>
							         <td class="${not empty keyword && fn:containsIgnoreCase(stage.date_fin, keyword) ? 'highlight' : ''}">
								            ${stage.date_fin}
								        </td>
								        <td class="${not empty keyword && fn:containsIgnoreCase(stage.division.nom_div, keyword) ? 'highlight' : ''}">
								            ${stage.division.nom_div}
								        </td>
								        <td class="${not empty keyword && fn:containsIgnoreCase(stage.encadrant.nom, keyword)&& fn:containsIgnoreCase(stage.encadrant.prenom, keyword) ? 'highlight' : ''}">
								            ${stage.encadrant.nom} ${stage.encadrant.prenom}
								        </td>
								        <td class="${not empty keyword && fn:containsIgnoreCase(stage.statut, keyword) ? 'highlight' : ''}">
								            ${stage.statut}
								        </td>
									        <td class="${not empty keyword && fn:containsIgnoreCase(stage.type, keyword) ? 'highlight' : ''}">
									            ${stage.type}
									        </td>
			      </tr>
   				</c:forEach>
                    </c:if>
                </tbody>
            </table>

            <!-- Pagination -->
            <div class="pagination">
                <c:if test="${not empty stages}">
                    <c:forEach var="page" begin="1" end="${totalPages}">
                        <c:url value="" var="pageUrl">
                            <c:param name="page" value="${page}" />
                        </c:url>
                        <a href="${pageUrl}" class="${page eq currentPage ? 'active' : ''}">${page}</a>
                    </c:forEach>
                </c:if> 
    </div>
   </div>
   </div>
</body>
</html>
