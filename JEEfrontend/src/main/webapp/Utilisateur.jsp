<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Liste des �l�ments</title>
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
   width: 20px; 
   height: 20px;
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
                <form action="Searchutilisateur" method="post" style="display: flex; align-items: center;">
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
                    <th scope="col">ID_login</th>
                    <th scope="col">CIN</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Pr�nom</th>
                    <th scope="col">role</th>
                    <th scope="col">Date_naissance</th>
                    <th scope="col">Adresse</th>
                    <th scope="col">Email</th>
                    <th scope="col">T�l�phone</th>
                    <th scope="col">mot_passe</th>
                    <th scope="col" colspan="2">Actions</th>
                </tr>
            </thead>
            <tbody>
            <c:if test="${not empty utilisateurs}">
                        <c:set var="itemsPerPage" value="10" />
                        <c:set var="totalItems" value="${fn:length(utilisateurs)}" />
                        <c:set var="totalPages" value="${(totalItems + itemsPerPage - 1) / itemsPerPage}" />
                        <c:set var="currentPage" value="${empty param.page ? 1 : param.page}" />
                        <c:set var="startIndex" value="${(currentPage - 1) * itemsPerPage}" />
                        <c:set var="endIndex" value="${(startIndex + itemsPerPage < totalItems) ? (startIndex + itemsPerPage) : totalItems}" />
                        <c:forEach var="index" begin="${startIndex + 1}" end="${endIndex}">
                            <c:set var="utilisateur" value="${utilisateurs[index - 1]}" />
		                     <tr>
		                     <td class="${not empty keyword && fn:containsIgnoreCase(utilisateur.id_login, keyword) ? 'highlight' : ''}">
								        ${utilisateur.id_login}
								    </td>
								    <td class="${not empty keyword && fn:containsIgnoreCase(utilisateur.cin, keyword) ? 'highlight' : ''}">
								        ${utilisateur.cin}
								    </td>
								    <td class="${not empty keyword && fn:containsIgnoreCase(utilisateur.nom, keyword) ? 'highlight' : ''}">
								        ${utilisateur.nom}
								    </td>
							         <td class="${not empty keyword && fn:containsIgnoreCase(utilisateur.prenom, keyword) ? 'highlight' : ''}">
								            ${utilisateur.prenom}
								        </td>
								        <td class="${not empty keyword && fn:containsIgnoreCase(utilisateur.role, keyword) ? 'highlight' : ''}">
								            ${utilisateur.role}
								        </td>
								        <td class="${not empty keyword && fn:containsIgnoreCase(utilisateur.dat_naiss, keyword) ? 'highlight' : ''}">
								            ${utilisateur.dat_naiss}
								        </td>
								        <td class="${not empty keyword && fn:containsIgnoreCase(utilisateur.adresse, keyword) ? 'highlight' : ''}">
								            ${utilisateur.adresse}
								        </td>
									        <td class="${not empty keyword && fn:containsIgnoreCase(utilisateur.email, keyword) ? 'highlight' : ''}">
									            ${utilisateur.email}
									        </td>
									        <td class="${not empty keyword && fn:containsIgnoreCase(utilisateur.tel, keyword) ? 'highlight' : ''}">
									            ${utilisateur.tel}
									        </td>
									        <td  class="${not empty keyword && fn:containsIgnoreCase(utilisateur.mot_passe, keyword) ? 'highlight' : ''}">
								        ${utilisateur.mot_passe}
								    </td>
							         <td style="border:none"><span><a href="#" class="editerbutton" data-id="${utilisateur.id_login}">
							         <img src="e.png"/></a></td>
				                      <td><a href="#" data-id="${utilisateur.id_login}" class="supprimerbutton"><img src="s.png"/></a> </td> 
			      </tr>
   				</c:forEach>
                    </c:if>
                </tbody>
            </table>

            <!-- Pagination -->
            <div class="pagination">
                <c:if test="${not empty utilisateurs}">
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
            <h1>Ajouter un utilisateur</h1>
            <form action="Ajoututilisateur" method="post" >
                <label>
                    <input type="text" placeholder="Id" name="id" />
                </label>
                <label>
                    <input type="text" placeholder="CIN" name="cin" />
                </label>
                <label>
                    <input type="text" placeholder="Nom" name="Nom" />
                </label>
                <label>
                    <input type="text" placeholder="Pr�nom" name="Prenom" />
                </label>
                <label>
                    <input type="text" placeholder="Adresse" name="adresse"/>
                </label>
         		<label>
                    <input type="text" placeholder="T�l�phone" name="telephone" />
                </label>
                <label>
                    <input type="date" placeholder="Date de naissance" name="datnaiss" />
                </label>

                <label>
                    <input type="email" placeholder="Email" name="email"/>
                </label>

                <label>
                    <input type="password" placeholder="mot de passe" name="mot_passe" />
                </label>
                <label>
                    <input type="text" placeholder="role" name="role" />
                </label>
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
            <h1>Editer un Utilisateur</h1>
            <form action="Ajoututilisateur" method="post" >
                 <label>
                    <input type="text" placeholder="Id" name="id" id="id"/>
                </label>
                <label>
                    <input type="text" placeholder="CIN" name="cin" id="cin"/>
                </label>
                <label>
                    <input type="text" placeholder="Nom" name="Nom" id="nom"/>
                </label>
                <label>
                    <input type="text" placeholder="Pr�nom" name="Prenom" id="prenom"/>
                </label>
                <label>
                    <input type="text" placeholder="Adresse" name="adresse" id="adresse"/>
                </label>
         		<label>
                    <input type="text" placeholder="T�l�phone" name="telephone" id="telephone"/>
                </label>
                <label>
                    <input type="date" placeholder="Date de naissance" name="datnaiss" id="datnaiss"/>
                </label>

                <label>
                    <input type="email" placeholder="Email" name="email" id="email"/>
                </label>
				<label>
                    <input type="password" placeholder="mot de passe" name="mot_passe" id="mot_passe" />
                </label>
                <label>
                    <input type="text" placeholder="role" name="role" id="role" />
                </label>
                <br>
                <input type="hidden" name="source" value="editer">
                <button style="margin-top: 9px">Valider</button> 
            </form>
        </div>
    </div>
<div id="confirmationModal" class="modal-supp">
    <div class="modal-content-supp">
        <span class="close-supp" onclick="hideConfirmation()">&times;</span>
        <p>Voulez-vous vraiment supprimer cet �l�ment ?</p>
        <button id="confirmButton">Oui</button>
        <button onclick="hideConfirmation()" id="suppbutton">Non</button>
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
      var cin = row.cells[1].innerText;
      var nom = row.cells[2].innerText;
      var prenom = row.cells[3].innerText;
      var role = row.cells[4].innerText;
      var datNaiss = row.cells[5].innerText;
      var adresse = row.cells[6].innerText;
      var email = row.cells[7].innerText;
      var telephone = row.cells[8].innerText;
      var mot_passe =row.cells[9].innerText;
      
      document.getElementById('id').value=id;
      document.getElementById('cin').value = cin;
      document.getElementById('nom').value = nom;
      document.getElementById('prenom').value = prenom;
      document.getElementById('datnaiss').value = datNaiss;
      document.getElementById('adresse').value = adresse;
      document.getElementById('mot_passe').value = mot_passe;
      document.getElementById('role').value = role;
      document.getElementById('email').value = email;
      document.getElementById('telephone').value = telephone;

      
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
  document.addEventListener('DOMContentLoaded', function () {
      var supprimerButtons = document.querySelectorAll('.supprimerbutton');

      supprimerButtons.forEach(function (button) {
          button.addEventListener('click', function (event) {
              event.preventDefault(); 

              var utilisateurid = button.getAttribute('data-id');
              console.log(utilisateurid);
              showConfirmationModal(utilisateurid);
          });
      });

      function showConfirmationModal(utilisateurid) {
          
          document.getElementById('confirmationModal').style.display = 'block';

          
          document.getElementById('confirmButton').addEventListener('click', function () {
              redirectToSuppressionServlet(utilisateurid);
          });
      }

      function redirectToSuppressionServlet(utilisateurid) {
          
          window.location.href = '/JEEfrontend/Supprimerutilisateur?id=' +utilisateurid;
      }
  });
  function hideConfirmation() {
	    document.getElementById('confirmationModal').style.display = 'none';
	}
</script>

</body>
</html>
