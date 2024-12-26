<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,700&display=swap" rel="stylesheet">
  <title>MAIL CODE VALIDATOR</title>
 <style> 
 *{
    box-sizing:border-box;
    margin:0;
    padding:0;
    font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
  }
  body{
    display:flex;
    align-items: center;
    justify-content:center;
    height:100vh;
    width:100%;
    padding:10px 20px;
    background:#EBF0F5;
  }
  .container {
    width: 400px; 
    margin: auto; 
    background: #fff;
    padding: 20px 10px;
    border-radius: 4px;
    box-shadow: 2px 2px 15px #C8D0D8;
    display: flex;
    flex-direction: column;
    gap: 30px;
  }
  .header{
    display:flex;
    flex-direction:column;
    align-items: center;
    gap:30px;
  }
  .header h1{
    color:gray;
    font-size:30px;
  }
  .input{
    display:flex;
    flex-direction: column;
    align-items: center;
  }
  .input p{
    font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
    font-size:16px;
    font-weight:500;
    color:gray;
    margin:5px 0;
  }
  .input b{
    font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
    font-size:14.5px;
    margin:0 0 20px 0;
  }
  .btn {
    width:100%;
    text-align: center;
  }
  .btn button {
    font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
    width: 100%;
    color: #fff;
    font-size: 17px;
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
  .inputs{
    display:flex;
    align-items: center;
    justify-content: center;
    flex-direction: row;
    column-gap: 10px;
    margin-bottom:10px;
  }
  .inputs input{
    font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
    height: 45px;
    width: 42px;
    border-radius: 6px;
    outline: none;
    font-size: 1.125rem;
    font-weight:900;
    text-align: center;
    border: 1px solid #ddd;
  }
  
  .inputs input:focus {
    box-shadow: 0 1px 0 rgba(0, 0, 0, 0.1);
  }
  .inputs input::-webkit-inner-spin-button,
  .inputs input::-webkit-outer-spin-button {
    display: none;
  }
 </style>
</head>
<body>
    <div class="container">
        <form action="verifierCode" method="post">
            <section class="header">
                <h1 style="font-family: 'Montserrat', sans-serif">Vérification</h1>
                <img src="profile.png" width="100px">
            </section>
            <section class="input">
                <p>Veuillez entrer le code envoyé par email</p><br>
                <div class="inputs">
                    <input type="number" name="code1" />
                    <input type="number" name="code2" disabled />
                    <input type="number" name="code3" disabled />
                    <input type="number" name="code4" disabled />
                </div>
                <c:if test="${not empty errorMessage}">
                    <p style="color: red;">${errorMessage}</p>
                </c:if>
            </section>
            <br>
            <section class="btn">
                <button type="submit" >Valider</button>
            </section>
        </form>
        </div>
  <script>
 const inputs = document.querySelectorAll("input"),
 button = document.querySelector("button");


inputs.forEach((input, index1) => {
 input.addEventListener("keyup", (e) => {
   
   const currentInput = input,
     nextInput = input.nextElementSibling,
     prevInput = input.previousElementSibling;
   if (currentInput.value.length > 1) {
     currentInput.value = "";
     return;
   }

   if (nextInput && nextInput.hasAttribute("disabled") && currentInput.value !== "") {
     nextInput.removeAttribute("disabled");
     nextInput.focus();
   }


   if (e.key === "Backspace") {
     inputs.forEach((input, index2) => {
       if (index1 <= index2 && prevInput) {
         input.setAttribute("disabled", true);
         input.value = "";
         prevInput.focus();
       }
     });
   }
   if (!inputs[3].disabled && inputs[3].value !== "") {
     button.classList.add("active");
     return;
   }
   button.classList.remove("active");
 });
});
window.addEventListener("load", () => inputs[0].focus());
 </script>
</body>
</html>