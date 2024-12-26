<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Envoyer un e-mail</title>
  <style>

    .form-email {
      background-color: #ffffff;
      padding: 20px;
      max-width: 600px;
      width: 100%;
      height:900px;
      padding-top:60px;
      margin-left:350px;
    }

    h2 {
      text-align: center;
      margin-bottom: 30px;
      color: #333333;
      font-size:35px;
    }

    label {
      display: block;
      margin-bottom: 20px;
      color: #555555;
      font-size:20px;
    }

    input, textarea {
      width: 100%;
      padding: 10px;
      margin-bottom: 16px;
      box-sizing: border-box;
      border: 1px solid #dddddd;
      border-radius: 4px;
    }

    button {
      background-color: #3498db;
      color: white;
      padding: 12px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 18px;
      width: 100%;
      box-sizing: border-box;
    }

    button:hover {
      background-color: #2980b9;
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
  <form action="Emailparuser" method="post" class="form-email">
    <h2>Envoyer un e-mail</h2>

    <label for="email">Adresse e-mail :</label>
    <input type="email" id="email" name="email" required>

    <label for="subject">Sujet :</label>
    <input type="text" id="subject" name="subject" required>

    <label for="message">Message :</label>
    <textarea id="message" name="message" rows="6" required></textarea>

    <button type="submit">Envoyer</button>
  </form>
  </div>
</body>
</html>
