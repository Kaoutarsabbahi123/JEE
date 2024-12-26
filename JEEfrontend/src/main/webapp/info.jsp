<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mon Profil</title>
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,700&display=swap" rel="stylesheet">
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <style>
       
        h1, h2, h3, h4, p, margin, padding, img, figure, figcaption, li, ul {
            margin: 0;
            padding: 0;
            border: 0;
        }
     
        .profile {
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #fff;
            padding: 20px;
            max-width: 900px;
            font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
            line-height: 1.6;
            color: #333;
            margin-left: 100px;
        }

        .container-profile {
            text-align: center;
            margin-right: 200px;
            margin-top: -250px;
        }

        .container-profile img {
    width: 150px;
    height: 150px;
    border-radius: 50%; 
    margin-bottom: 10px;
    border: 4px solid #008ecf; 
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.4); 
}
        .container-info {
            margin-top: 20px;
        }

        h4 {
            color: #008ecf;
            margin-bottom: 15px;
            padding-bottom: 5px;
            font-size: 30px;
            font-family:  Geneva, Verdana, sans-serif;
        }

        .container-info div {
            margin-bottom: 15px;
        }

        .nom {
            font-weight: bold;
            font-size: 1.1em;
            color: #555;
        }

       
        .labels {
            display: inline-block;
            width: 150px;
            font-weight: bold;
            margin-bottom: 5px;
            color: #333; 
        }

        
        .values {
            margin-left: 90px; 
            color: #555; 
            font-size: 1.1em;
        }

        .infos {
            font-size: 17px;
            margin-left: 30px;
        }

        .lien {
            font-size: 15px;
        }
    
    #passwordModal {
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
    padding-left:600px;
    padding-top:200px;
}

#passwordModal .modal-content {
    background-color: #fff;
    padding: 20px;
    max-width: 400px;
    text-align: center;
    border-radius: 5px;
    position: relative;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); 
}


        #passwordModal h2 {
            color: #333;
            margin-bottom: 30px;
             font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
        }

        #passwordModal label {
            display: block;
            margin-bottom: 10px;
            color: #555;
        }

        #passwordModal input {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
            height: 45px;
            border-radius: 6px;
            outline: none;
            font-size: 1rem;
            font-weight: 200;
            text-align: center;
            border: none;
            background: #eee;
        }

        #passwordModal input::placeholder {
            text-align: left;
            padding-left: 13px;
            color: gray;
             font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
        }

        #passwordModal input:hover {
            border: 2px solid black;
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
         .btn {
    text-align: center;
    width: 200px;
    color: #fff;
    font-size: 15px;
    font-weight: 700;
    border: none;
    height: 40px;
    cursor: pointer;
    border-radius: 4px;
    background: #008ecf;
    transition: all 0.2s ease;
}
        button.active {
            background: #4070f4;
            pointer-events: auto;
        }
        form button:hover {
    background: #0e4bf1;
  }

        .popup-link {
            color: #007BFF;
            text-decoration: underline;
            cursor: pointer;
        }
        .error-message {
      color: red;
      font-size: 14px;
      text-align: center;
    }
    #success{
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
    padding-left:600px;
    padding-top:200px;
}
.popup-content{
   background-color: #fff;
    padding: 20px;
    max-width: 400px;
    text-align: center;
    border-radius: 5px;
    position: relative;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /
}
.imgbox{
    text-align: center;
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
    <div class="profile">
        <div class="container-profile">
            <img src="user.png"
                alt="Profile Image">
            <br><span class="nom">${utilisateur.nom} ${utilisateur.prenom}<br>
             <a href="#" class="popup-link" onclick="openPopup()">Changer mot de passe</a>
             </span>
        </div>
        <div class="container-info">
            <div>
                <h4>Informations Personnelles</h4>
            </div>
            <div class="infos">
                <div><label class="labels">Nom </label><span class="values">${utilisateur.nom}</span></div>
                <div><label class="labels">Prénom </label><span class="values">${utilisateur.prenom}</span></div>
                <div><label class="labels">CIN </label><span class="values">${utilisateur.cin}</span></div>
                <div><label class="labels">Adresse </label><span class="values">${utilisateur.adresse}</span></div>
                 <div><label class="labels">Date de naissance</label><span class="values">${utilisateur.dat_naiss}</span></div>
                <div><label class="labels">Email personnel </label><span class="values">${utilisateur.email}</span></div>
                <div><label class="labels">Login </label><span class="values">${utilisateur.id_login}</span></div>  
                <div><label class="labels">Téléphone </label><span class="values">${utilisateur.tel}</span></div>
            </div>
        </div>
    </div>
    </div>
    <div class="modal" id="passwordModal">
        <div class="modal-content">
            <span class="close" onclick="closePopup()">&times;</span>
            <h2>Changer le mot de passe</h2>
            <form method="post" action="changer_mdp">
                <input type="password" id="currentPassword" name="currentPassword" placeholder="Ancien mot de passe" required>
                <input type="password" id="newPassword" name="newPassword" placeholder="Nouveau mot de passe" required>
                <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirmer mot de passe" required>
                 <span id="confirmPasswordError" class="error-message"></span>
                 <c:if test="${not empty errorMessage}">
                <p class="error-message">${errorMessage}</p>
                 </c:if>
                <button type="submit" class="btn" id="confirm">Valider</button>
            </form>
        </div>
    </div>
    <div class="popup" id="success">
      <div class="popup-content">
       <span class="close" onclick="closePopupvalidation()">&times;</span>
        <div class="imgbox">
          <img src="check.png" alt="" class="img">
        </div>
         <c:if test="${not empty successMessage}">
                <p class="success-message">${successMessage}</p>
           </c:if>
      </div>
    </div>
     <%Boolean monAttribut = (Boolean)request.getSession().getAttribute("success");
   if (monAttribut == null) {
      monAttribut = false; 
 }
   request.getSession().setAttribute("success",monAttribut);
    String mot_passe=(String)request.getSession().getAttribute("mot_passe");%>
   <script>
   
    function openPopup() {
        document.getElementById('passwordModal').style.display = 'block';
    }

   
    function closePopup() {
        document.getElementById('passwordModal').style.display = 'none';
    }

    function openPopupvalidation() {
        document.getElementById('passwordModal').style.display = 'none';
        document.getElementById('success').style.display = 'block';
    }
    function closePopupvalidation() {
        document.getElementById('success').style.display = 'none';
    }
    document.getElementById('confirm').addEventListener('click', function (event) {
        var password = document.getElementById('newPassword').value;
        var confirmPassword = document.getElementById('confirmPassword').value;
        var currentPassword = document.getElementById('currentPassword').value;

       
        document.getElementById('confirmPasswordError').textContent = '';

        if (currentPassword.trim() === '' || password.trim() === '' || confirmPassword.trim() === '') {
            document.getElementById('confirmPasswordError').textContent = 'Veuillez remplir tous les champs obligatoires.';
            event.preventDefault(); 
            return false;
        }

        if (password !== confirmPassword) {
            
            document.getElementById('confirmPasswordError').textContent = 'Les mots de passe ne correspondent pas.';
            event.preventDefault(); 
            return false;
        }

        var sessionPassword = '<%= mot_passe %>'; 
        console.log(sessionPassword);

        if (currentPassword !== sessionPassword) {
            document.getElementById('confirmPasswordError').textContent = 'Ancien mot de passe incorrect.';
            event.preventDefault(); 
            return false;
        }

    });

    var success =<%= monAttribut %>;
    console.log(success);
    
    if (success) {
        openPopupvalidation();
    }
    </script>
</body>
</html>
