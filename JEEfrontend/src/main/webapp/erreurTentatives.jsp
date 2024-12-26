<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>échec</title>
  <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,700&display=swap" rel="stylesheet">
  <style>
  *{
    box-sizing:border-box;
    margin:0;
    padding:0;
  }
    body {
      display:flex;
      align-items: center;
      justify-content:center;
      height:100vh;
      width:100%;
      text-align: center;
      padding: 40px;
      background:#EBF0F5;
    }
    h1 {
      color: red;
      font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
      font-weight: 900;
      font-size: 40px;
      margin-bottom: 10px;
    }
    p {
      color: #404F5E;
      font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
      font-size: 20px;
      margin: 0;
    }
    .icon {
      max-width: 900px; 
      margin-bottom: 20px;
    }
    .card {
      background: white;
      padding: 60px;
      border-radius: 4px;
      box-shadow: 2px 4px 10px #C8D0D8;
      display: inline-block;
      margin: 0 auto;
    }
  </style>
</head>
<body>
  <div class="card">
    <div class="icon">
      <img src="cancel.png" alt="Votre icône" />
    </div>
    <h1>Erreur de Tentatives</h1>
    <p>Vous avez dépassé le nombre maximum de tentatives autorisées
    <br> Veuillez contacter le support technique pour obtenir de l'aide.</p>
  </div>
</body>
</html>
