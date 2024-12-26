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
    margin-left:30px;
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

       
        .modal {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            justify-content: center;
            align-items: center;
        }

        .modal-content {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            position: relative;
            max-width: 600px; 
		    width: 100%;
		    max-height: 80vh; 
		    overflow-y: auto; 
		    box-sizing: border-box;
        }

        .close {
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
        }
          .btn {
            display: inline-block;
            padding: 8px 16px;
            font-size: 14px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            outline: none;
            border: none;
            border-radius: 4px;
            width:100px;
            height:45px;
            transition: background-color 0.3s;
            font-size:18px;
            margin-left:80px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
         .btn-primary {
            background-color: #4BAE4F;
            color: #fff;
        }

        .btn-primary:hover {
            background-color: #23C629;
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
.modal-content {
    background-color: #fff;
    padding: 40px; 
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    position: relative;
    max-width: 900px; 
    width: 100%;
    max-height: 80vh; 
    overflow-y: auto; 
    box-sizing: border-box;
}
.modal-content form {
    display: grid;
    grid-template-columns: repeat(2, 1fr); 
    grid-gap: 10px; 
}


.modal-content label {
    display: block;
    margin-bottom: 5px;
}

.modal-content input {
    width: calc(100% - 10px); 
    padding: 8px;
    margin-bottom: 10px;
    box-sizing: border-box;
    background: #eee;
    border: none;
    border-radius: 10px;
    padding: 12px 15px;
    margin: 8px 0;
    height:50px;
    font-size:18px;
}


.modal-content button {
    width: 60%;
    padding: 10px;
    background-color: #4BAE4F;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 20px;
    margin-left:-130px;
    
}

.modal-content button:hover {
    background-color: #23C629;
}

.modal-content input:hover {
    transform: scale(101%);
}
.close {
            position: absolute;
            top: 2px;
            right: 10px;
            font-size: 30px;
            color: #555;
            cursor: pointer;
        }

       .close:hover {
            color: #333;
        }
        .modal-content h1 {
    text-align: center;
    margin-bottom: 20px; 
    color: #000 ;
}
img {
   display:inline-block;
   width: 40px; 
   height: 40px; 
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
 .checkbox-container label {
        display: block;
        margin-bottom: 10px;
    }

    .checkbox-container input[type="checkbox"] {
        width: 16px;
        height: 16px;
        margin-right: 5px;
    }
.modal-supp {
    display: none;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0,0,0,0.4);
    justify-content: center;
    align-items: center;
}

.modal-content-supp {
    background-color: #fefefe;
    margin: 15% auto;
    border-radius: 8px;
    padding: 20px;
    border: 1px solid #888;
    width: 500px;
    height:200px;
    font-size:20px;
    
}
.modal-content-supp p{
margin-left:22px;
}
#confirmButton {
    background-color: #4CAF50; 
    color: white;
    border: none;
    padding: 10px;
    margin: 5px;
    border-radius: 4px;
    width:100px;
    height:45px;
    transition: background-color 0.3s;
    font-size:20px;
    margin-left:80px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    margin-top:50px;
}

#confirmButton:hover {
    background-color: #45a049; 
}
#suppbutton {
    background-color:red; 
    color: white;
    border: none;
    padding: 10px;
    margin: 5px;
    border-radius: 4px;
    width:100px;
    height:45px;
    transition: background-color 0.3s;
    font-size:20px;
    margin-left:100px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

#suppbutton:hover {
    background-color: #E82020; 
} 
.close-supp {
    margin-left:450px;
    font-size: 30px;
    color: #555;
    cursor: pointer;
    line-height: 1px; 
}

.close-supp:hover,
.close-supp:focus {
    color: black;
    text-decoration: none;
}   
select {
    width: calc(100% - 10px);
    padding: 12px 15px;
    margin: 8px 0;
    box-sizing: border-box;
    background: #eee;
    border: none;
    border-radius: 10px;
    height: 50px;
    font-size: 18px;
}


select option {
    font-size: 18px;
    background: #eee;
    border: none;
    border-radius: 10px;
}
 #probsupp{
    display: none;
    justify-content: center;
    align-items: center;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.8);
    z-index: 1000; 
    padding-left:200px;
    padding-top:1px;
}
.popup-content{
   background-color: #fff;
    padding: 20px;
    width: 500px;
    height:200px;
    text-align: center;
    border-radius: 5px;
    position: relative;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /
}
	.imgsupp {
		   display:inline-block;
		   width: 20px; 
		   height: 20px; 
		}
		.imgerreur{
		   display:inline-block;
		   margin-top:-9px;
		   width: 80px; 
		   height: 80px; 
		   margin-bottom:30px;
		}
		.suppression-message{
		font-size:18px;
		}
		.designicon{
		width: 20px; 
		height: 20px;
		}
		
         .modal-content-affectation {
    display: flex;
    flex-direction: column; 
    align-items: center;
    background-color: #fff;
    padding: 40px; 
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 750px; 
    max-height: 80vh;
    overflow-x: auto; 
}
.modal-content-affectation button {
    width: 40%;
    padding: 10px;
    background-color: #4BAE4F;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 20px;
    margin-left:160px;
    
}
.modal-content-affectation input {
    width:300px;
    padding: 8px;
    margin-bottom: 10px;
    box-sizing: border-box;
    background: #eee;
    border: none;
    border-radius: 10px;
    padding: 12px 15px;
    margin: 8px 0;
    height:50px;
    font-size:18px;
    
}

.modal-content-affectation button:hover {
    background-color: #23C629;
}
.close-affecté {
    margin-left:500px;
    font-size: 30px;
    color: #555;
    cursor: pointer;
    line-height: 1px; 
}

.close-affecté:hover,
.close-affecté":focus {
    color: black;
    text-decoration: none;
}   
.checkbox-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
}

.checkbox-container label {
    flex-basis: calc(50% - 10px); 
    margin-bottom: 10px; 
    box-sizing: border-box; 
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
    			 <button class="btn btn-primary" id="addButton"> Ajouter</button>
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
                    <th scope="col" colspan="3">Actions</th>
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
							         <td><span><a href="#" class="editerbutton" data-id="${stage.id_stage}">
							         <img src="e.png" class="designicon"/></a></td>
				                      <td><a href="#" data-id="${stage.id_stage}" class="supprimerbutton"><img src="s.png" class="designicon"/></a> </td> 
				                       <td><a href="#" data-id="${stage.id_stage}" class="affecterbutton"><img src="m.png" class="designicon"/></a> </td> 
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
    <div class="modal" id="myModal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h1>Ajouter un Stage</h1>
            <form action="AjoutStage" method="post" >
                <label>
                    <input type="text" placeholder="Sujet" name="sujet" />
                </label>
                <label>
                    <input type="Date" placeholder="Date_debut" name="Date_debut" />
                </label>
                <label>
                    <input type="Date" placeholder="Date_fin" name="Date_fin" />
                </label>
               <select id="ListeEncadrant" name="ListeEncadrant">
				    <c:forEach var="enc" items="${encadrants}">
				        <option  value="${enc.id_emp}">${enc.nom}${enc.prenom}</option>
				    </c:forEach>
				</select>
         		 <select id="Listedivision" name="Listedivision">
				    <c:forEach var="divi" items="${divisions}">
				        <option  value="${divi.id_div}">${divi.nom_div}</option>
				    </c:forEach>
				</select>
				<select id="votreListetype" name="votreListetype">
				        <option  value="PFA">PFA</option>
				        <option  value="PFE">PFE</option>
				        <option  value="INITIATION">INITIATION</option>
				        <option  value="OBSERVATION">OBSERVATION</option>
				</select>
                <br>
                <input type="hidden" name="source" value="ajouter">
                <button style="margin-top: 9px">Valider</button> 
            </form>
        </div>
    </div>
</div>
<!-- Modal pour l'ajout -->
    <div class="modal" id="editmodal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h1>Editer un Stage</h1>
            <form action="AjoutStage" method="post" >
                <label>
                    <input type="text" placeholder="Sujet" name="sujet" id="sujet" />
                </label>
                <label>
                    <input type="Date" placeholder="Date_debut" name="Date_debut" id="Date_debut" />
                </label>
                <label>
                    <input type="Date" placeholder="Date_fin" name="Date_fin" id="Date_fin"/>
                </label>
                 <select id="ListeEncadrant" name="ListeEncadrant">
				    <c:forEach var="enc" items="${encadrants}">
				        <option  value="${enc.id_emp}">${enc.nom}${enc.prenom}</option>
				    </c:forEach>
				</select>
         		 <select id="Listedivision" name="Listedivision">
				    <c:forEach var="divi" items="${divisions}">
				        <option  value="${divi.id_div}">${divi.nom_div}</option>
				    </c:forEach>
				</select>
				<select id="votreListetype" name="votreListetype">
				        <option  value="PFA">PFA</option>
				        <option  value="PFE">PFE</option>
				        <option  value="INITIATION">INITIATION</option>
				        <option  value="OBSERVATION">OBSERVATION</option>
				</select>
                <br>
                <input type="hidden" name="source" value="editer">
                 <input type="hidden" placeholder="ID" name="id" id="id" />
                <button style="margin-top: 9px">Valider</button> 
            </form>
        </div>
    </div>
<div id="confirmationModal" class="modal-supp">
    <div class="modal-content-supp">
        <span class="close-supp" onclick="hideConfirmation()">&times;</span>
        <p>Voulez-vous vraiment supprimer cet élément ?</p>
        <button id="confirmButton">Oui</button>
        <button onclick="hideConfirmation()" id="suppbutton">Non</button>
    </div>
</div>
<div class="popup" id="probsupp">
      <div class="popup-content">
       <span class="close-supp" onclick="closePopupvalidation()">&times;</span>
        <div class="imgbox">
          <img src="cancel.png" alt="" class="imgerreur">
        </div>
        <c:if test="${not empty messageSuppression}">
                <p class="suppression-message" id="errorMessageElement">${messageSuppression}</p>
         </c:if>
      </div>
    </div>
      <div class="modal" id="affectationModal">
    <div class="modal-content-affectation">
        <span class="close-affecté" onclick="closeaffecteModal()">&times;</span>
        <h1>Liste des stagiaires</h1>
        <form action="TraitementAffectation" method="post">
            <div class="checkbox-container">
                <c:forEach var="nouveaustagiaire" items="${nouveaustagiaires}" varStatus="loop">
                    <label>
                        <input type="checkbox" name="affecter" value="${nouveaustagiaire.id_stagiaire}" />
                        ${nouveaustagiaire.nom} ${nouveaustagiaire.prenom}
                    </label>
                </c:forEach>
            </div>
            <br>
            <input type="hidden" name="idstage" id="idstage" />
            <button style="margin-top: 9px">Valider</button>
        </form>
    </div>
</div>
 <script>
  document.getElementById('addButton').addEventListener('click', function () {
    document.getElementById('myModal').style.display = 'flex';
  });

  var editerButtons = document.getElementsByClassName('editerbutton');
  for (var i = 0; i < editerButtons.length; i++) {
    editerButtons[i].addEventListener('click', function (event) {
      
      var row = event.target.closest('tr');
      console.log(row);
      
      var id=row.cells[0].innerText;
      var sujet = row.cells[1].innerText;
      var date_debut = row.cells[2].innerText;
      var date_fin = row.cells[3].innerText;
 
      
      document.getElementById('id').value=id;
      document.getElementById('sujet').value = sujet;
      document.getElementById('Date_debut').value = date_debut;
      document.getElementById('Date_fin').value = date_fin;
     
      document.getElementById('editmodal').style.display = 'flex';
    });
  }

  function closeModal() {
    document.getElementById('myModal').style.display = 'none';
    document.getElementById('editmodal').style.display = 'none';
  }

  window.onclick = function (event) {
    if (event.target == document.getElementById('myModal')) {
      closeModal();
    } else if (event.target == document.getElementById('editmodal')) {
      closeModal();
    }
  }
  var affecterbuttons = document.getElementsByClassName('affecterbutton');
  for (var i = 0; i < affecterbuttons.length; i++) {
	  affecterbuttons[i].addEventListener('click', function (event) {
      
      var row = event.target.closest('tr');
      
      var id=row.cells[0].innerText;
      
      document.getElementById('idstage').value=id;
     
      document.getElementById('affectationModal').style.display = 'flex';
    });
  }
  function closeAbsentModal() {
      document.getElementById('affectationModal').style.display = 'none';
  }

  window.onclick = function (event) {
      if (event.target == document.getElementById('affectationModal')) {
          closeAbsentModal();
      }
  }
  document.addEventListener('DOMContentLoaded', function () {
      var supprimerButtons = document.querySelectorAll('.supprimerbutton');

      supprimerButtons.forEach(function (button) {
          button.addEventListener('click', function (event) {
              event.preventDefault(); 

              var stageid = button.getAttribute('data-id');
              showConfirmationModal( stageid);
          });
      });

      function showConfirmationModal( stageid) {
          
          document.getElementById('confirmationModal').style.display = 'block';

          
          document.getElementById('confirmButton').addEventListener('click', function () {
              redirectToSuppressionServlet( stageid);
          });
      }

      function redirectToSuppressionServlet( stageid) {
          
          window.location.href = '/JEEfrontend/SupprimerStage?id=' + stageid;
      }
  });
  function hideConfirmation() {
	    document.getElementById('confirmationModal').style.display = 'none';
	}
function closePopupvalidation() {
    document.getElementById('probsupp').style.display = 'none';
       
        window.location.href = '/JEEfrontend/servletstage';
    
}
document.addEventListener('DOMContentLoaded', function () {
	   var messageSuppression = '<c:if test="${not empty messageSuppression}">${messageSuppression}</c:if>';
	      if (messageSuppression) {
	          document.getElementById('probsupp').style.display = 'flex';
	      }
});

</script>

</body>
</html>
