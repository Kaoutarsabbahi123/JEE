<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,700&display=swap" rel="stylesheet">
<style>
* {
    box-sizing: border-box;
}

body {
    font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: -20px 0 50px;
    margin-top: 20px;
    background:#EBF0F5;
}
.img-container {
    text-align: center;
    margin-top: -100px;
    position: relative; 
}

.img-container img { 
    margin-bottom: 30px;
}

.connect {
    margin-top: 0;
    padding-top: 0;
}
h1 {
    font-size: 37px;
    font-weight: bold;
    margin: 0;
    margin-bottom:16px;
}
p {
    font-size: 14px;
    font-weight: 100;
    line-height: 20px;
    letter-spacing: .5px;
    margin-bottom:40px;
}

span {
    font-size: 12px;
}

a {
    color: #0e263d;
    font-size: 14px;
    text-decoration: none;
    margin: 6px 0;
}
.container {
    background: #fff;
    border-radius: 25px;
    box-shadow: 30px 14px 28px rgba(0, 0, 5, .2), 0 10px 10px rgba(0, 0, 0, .2);
    position: relative;
    overflow: hidden;
    opacity: 85%;
    width: 60vw;
    width: 900px;
    max-width: 100%;
    min-height: 650px;
    transition: 333ms;   
}
.form-container form {
    background: #fff;
    display: flex;
    flex-direction: column;
    padding:  0 50px;
    height: 100%;
    justify-content: center;
    align-items: center;
    text-align: center;
}
.form-container input {
    background: #eee;
    border: none;
    border-radius: 10px;
    padding: 12px 15px;
    margin: 8px 0;
    width: 100%;
}
.form-container input:hover {
    transform: scale(101%);
}
button {
    border-radius: 10px;
    box-shadow: 0 1px 1px ;
    border: 1px solid #008ecf;
    background: #008ecf;
    color: #fff;
    font-size: 12px;
    font-weight: bold;
    padding: 12px 45px;
    letter-spacing: 1px;
    text-transform: uppercase;
    transition: transform 80ms ease-in;
}
button:active {
    transform: scale(.95);
}
button:focus {
    outline: none;
}
button.ghost {
    background: transparent;
    border-color: #fff;
}
.form-container {
    position: absolute;
    top: 0;
    height: 100%;
    transition: all .6s ease-in-out;
}
.sign-up-container {
    left: 0;
    width: 50%;
    height: 100%;
    z-index: 1;
    opacity: 0;
    display: flex; 
    flex-direction: column; /* Aligner les éléments en colonne */
    justify-content: center; /* Centrer les éléments verticalement */
}

/* Ajouter ces styles pour les éléments internes */
.sign-up-container form {
    width: 100%;
}

.sign-up-container form label {
    width: 100%;
    height:48px;
    margin-bottom:8px;
}

.sign-up-container button {
    width: 50%;
    margin-top: 11px;
}

.sign-in-container {
    left: 0;
    width: 50%;
    z-index: 2;
}
.sign-in-container form label {
    width: 100%;
    height:48px;
    margin-bottom:8px;
}
.overlay-container {
    position: absolute;
    top: 0;
    left: 50%;
    width: 50%;
    height: 100%;
    overflow: hidden;
    transition: transform .6s ease-in-out;
    z-index: 100;
}

.overlay {
    background: #ff416c;
    background: linear-gradient(to right, #008ecf, #008ecf) no-repeat 0 0 / cover;
    color: #fff;
    position: relative;
    left: -100%;
    height: 100%;
    width: 200%;
    transform: translateY(0);
    transition: transform .6s ease-in-out;
}

.overlay-panel {
    position: absolute;
    top: 0;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 0 40px;
    height: 100%;
    width: 50%;
    text-align: center;
    transform: translateY(0);
    transition: transform .6s ease-in-out;
}

.overlay-right {
    right: 0;
    transform: translateY(0);
}

.overlay-left {
    transform: translateY(-20%);
}

/* Move signin to right */
.container.right-panel-active .sign-in-container {
    transform: translateY(100%);
}

/* Move overlay to left */
.container.right-panel-active .overlay-container {
    transform: translateX(-100%);
}

/* Bring signup over signin */
.container.right-panel-active .sign-up-container {
    transform: translateX(100%);
    opacity: 1;
    z-index: 5;
}

/* Move overlay back to right */
.container.right-panel-active .overlay {
    transform: translateX(50%);
}


.container.right-panel-active .overlay-left {
    transform: translateY(0);
}


.container.right-panel-active .overlay-right {
    transform: translateY(20%);
}
</style>
<script>
document.addEventListener('DOMContentLoaded', function() {
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');
    const signUpForm = document.querySelector('.sign-up-container form');

    signUpButton.addEventListener('click', function() {
        container.classList.add('right-panel-active');
        signUpForm.reset();
        resetValidationStyles(signUpForm);
    });

    signInButton.addEventListener('click', function() {
        container.classList.remove('right-panel-active');
    });

    signUpForm.addEventListener('submit', function(event) {
        if (!validateForm(signUpForm)) {
            event.preventDefault();
        }
    });
});

function validateForm(form) {
    let isValid = true;
    resetValidationStyles(form);

    form.querySelectorAll('input').forEach(function(input) {
        if (!input.value.trim()) {
            isValid = false;
            setInvalidStyle(input);
        } else {
            setValidStyle(input);
        }

        // Validation de l'email
        if (input.type === 'email' && !validateEmail(input.value)) {
            isValid = false;
            setInvalidStyle(input);
        }
    });

    return isValid;
}

function validateEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function setInvalidStyle(input) {
    input.style.border = '2px solid red';
}

function setValidStyle(input) {
    input.style.border = '2px solid green';
}

function resetValidationStyles(form) {
    form.querySelectorAll('input').forEach(function(input) {
        input.style.border = '';
    });
}
</script>
</head>
<body>
<section>
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form action="Inscription" method="Post">
                <h1>Inscrivez-vous</h1>
                <label>
                    <input type="text" placeholder="CIN" name="cin" id="cin"/>
                </label>
                <span id="cinError" class="error"></span>

                <label>
                    <input type="text" placeholder="Nom" name="Nom" id="nom"/>
                </label>
                <span id="nomError" class="error"></span>

                <label>
                    <input type="text" placeholder="Prénom" name="Prenom" id="prenom"/>
                </label>
                <span id="prenomError" class="error"></span>

                <label>
                    <input type="text" placeholder="Adresse" name="adresse" id="adresse"/>
                </label>
                <span id="adresseError" class="error"></span>

                <label>
                    <input type="text" placeholder="Téléphone" name="telephone" id="telephone"/>
                </label>
                <span id="telephoneError" class="error"></span>

                <label>
                    <input type="date" placeholder="Date de naissance" name="datnaiss" id="datnaiss"/>
                </label>
                <span id="datnaissError" class="error"></span>

                <label>
                    <input type="email" placeholder="Email" name="email" id="email"/>
                </label>
                <span id="emailError" class="error"></span>

                <label>
                    <input type="text" placeholder="Établissement" name="etablissement" id="etablissement"/>
                </label>
                <span id="etablissementError" class="error"></span>

                <label>
                    <input type="text" placeholder="Filière" name="filiere" id="filiere"/>
                </label>
                  <input type="hidden" name="verificationSource" value="inscriptionstagiaire" />
                <span id="filiereError" class="error"></span>
                <button style="margin-top: 9px">S'inscrire</button> 
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form action="Authentifier" method="post">
                <div class="img-container">
                    <img src="account.png" alt="Account Image"/>
                </div>
                <h1 class="connect">Se connecter</h1>
                <label>
                    <input type="email" placeholder="Email" name="email"/>
                </label>
                <label>
                    <input type="password" placeholder="Mot de passe" name="password"/>
                </label>
                <c:if test="${not empty errorMessage}" style="margin-bottom:2px;">
                    <p style="color: red;">${errorMessage}</p>
                </c:if>
                <a href="envoyerEmail.jsp">Mot de passe oublié?
                </a>
                <button type="submit">Se connecter</button>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Connectez-vous</h1>
                    <p>Connectez-vous ici si vous avez déjà un compte...</p>
                    <button class="ghost mt-5" id="signIn">Connectez-vous</button>
                </div>
                <div class="overlay-panel overlay-right small-text">
                    <h1>Êtes-vous stagiaire?</h1>
                    <button class="ghost" id="signUp">Inscrivez-vous</button>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
