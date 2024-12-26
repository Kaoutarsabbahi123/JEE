<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,700&display=swap" rel="stylesheet">
  <title>Modify password</title>
  <style>
  * {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
    font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
  }
  
  body {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
    width: 100%;
    padding: 10px 20px;
    background:#EBF0F5;
  }
  
  .container {
    width: 400px;
    margin: auto;
    background: #fff;
    padding: 20px 10px;
    border-radius: 4px;
    box-shadow: 2px 2px 8px #C8D0D8;
    display: flex;
    flex-direction: column;
    gap: 20px;
  }
  
  .header {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 20px;
  }
  
  .header h1 {
    color: gray;
  }
  
  .input {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  .input p {
    font-size: 15px;
    font-weight: 500;
    color: gray;
    margin: 5px 0;
  }
  
  .inputs {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: row;
    column-gap: 10px;
  }
  
  .inputs input {
    height: 45px;
    width: 300px;
    border-radius: 6px;
    outline: none;
    font-size: 1rem;
    font-weight: 200;
    text-align: center;
    border: none;
    background: #eee;
    margin-bottom:18px;
  }
  
  .inputs input::placeholder {
    text-align: left;
    padding-left: 5px;
    color: gray; 
  }
  .inputs input:hover {
    border: 2px solid black;
}
  
  .btn {
    width: 100%;
    text-align: center;
  }
  
  .btn button {
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
  .input-group {
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    .input-group input {
      height: 45px;
      width: 300px;
      border-radius: 6px;
      outline: none;
      font-size: 1rem;
      font-weight: 200;
      text-align: center;
      border: none;
      background: #eee;
      margin-bottom: 18px;
    }

    .input-group input:hover {
      border: 2px solid black;
    }

    .input-group .error-message {
      color: red;
      font-size: 14px;
      text-align: center;
    }
  </style>
</head>
<body>
  <div class="container">
  <form action="reinitialiser_mdp" method="post">
    <section class="header"> 
      <img src="mot-de-passe.png"/>
      <h1>Création de Mot de Passe</h1>
    </section>
    <section class="input">
      <div class="input-group">
        <input type="password" id="password" placeholder="Nouveau mot de passe" name="nv_mdp"/>
      </div>
      <div class="input-group">
        <input type="password" id="confirmPassword" placeholder="Confirmez votre mot de passe"/>
        <span id="confirmPasswordError" class="error-message"></span>
      </div>
    </section>
    <section class="btn">
      <button id="confirmButton">Confirmer</button>
    </section>
    </form>
  </div>
  <script>
    document.getElementById('confirmButton').addEventListener('click', function() {
      var password = document.getElementById('password').value;
      var confirmPassword = document.getElementById('confirmPassword').value;

     
      document.getElementById('confirmPasswordError').textContent = '';

     
    if (password !== confirmPassword) {
 
       
        document.getElementById('confirmPasswordError').textContent = 'Les mots de passe ne correspondent pas.';
      }
    });
  </script>
</body>
</html>
