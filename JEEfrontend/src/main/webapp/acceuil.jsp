<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Acceuil</title>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="navbar.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script  src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <style>
    /* =========== Google Fonts ============ */
@import url("https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap");

/* =============== Globals ============== */
* {
  font-family: "Ubuntu", sans-serif;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

:root {
  --blue: #008ecf;
  --white: #fff;
  --gray: #f5f5f5;
  --black1: #222;
  --black2: #999;
}

body {
  min-height: 100vh;
  overflow-x: hidden;
}

.container {
  position: relative;
  width: 100%;
}

/* ===================== Main ===================== */
.main {
  position: absolute;
  width: calc(100% - 300px);
  left: 250px;
  min-height: 100vh;
  background: var(--white);
  transition: 0.5s;
}
.main.active {
  width: calc(100% - 80px);
  left: 80px;
}

.topbar {
  width: 100%;
  height: 60px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.toggle {
  width: 60px;
  height: 60px;
  display: flex;
   justify-content: center;
  align-items: center;
  font-size: 2.5rem;
  cursor: pointer;
}



/* ======================= Cards ====================== */
.cardBox {
  position: relative;
  width: 100%;
  padding: 20px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-gap: 30px;
}

.cardBox .card {
  position: relative;
  background: var(--white);
  padding: 30px;
  border-radius: 20px;
  display: flex;
  justify-content: space-between;
  cursor: pointer;
  box-shadow: 0 7px 25px rgba(0, 0, 0, 0.08);
}

.cardBox .card .numbers {
  position: relative;
  font-weight: 500;
  font-size: 2.5rem;
  color: var(--blue);
}

.cardBox .card .cardName {
  color: var(--black2);
  font-size: 1.1rem;
  margin-top: 5px;
}

.cardBox .card .iconBx {
  font-size: 3.5rem;
  color: var(--black2);
}

.cardBox .card:hover {
  background: var(--blue);
}
.cardBox .card:hover .numbers,
.cardBox .card:hover .cardName,
.cardBox .card:hover .iconBx {
  color: var(--white);
}

/* ====================== Responsive Design ========================== */
@media (max-width: 991px) {
  .main {
    width: 100%;
    left: 0;
  }
  .main.active {
    left: 300px;
  }
  .cardBox {
    grid-template-columns: repeat(2, 1fr);
  }
}


@media (max-width: 480px) {
  .cardBox {
    grid-template-columns: repeat(1, 1fr);
  }
  .cardHeader h2 {
    font-size: 20px;
  }
  .toggle {
    z-index: 10001;
  }
  .main.active .toggle {
    color: #fff;
    position: fixed;
    right: 0;
    left: initial;
  }
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
            <div class="cardBox">
    			<div class="card">
        			<div>
            			<div class="numbers">${nbrStagiairenouveau}</div>
            			<div class="cardName">Nouveaux Stagiaires</div>
        			</div>
        		<div class="iconBx">
            		<ion-icon name="people-outline"></ion-icon>
        		</div>
    			</div>

    			<div class="card">
        			<div>
            			<div class="numbers">${nbrStagiaireencours}</div>
            			<div class="cardName">Stagiaires en cours</div>
        			</div>
        			<div class="iconBx">
            			<ion-icon name="time-outline"></ion-icon>
        			</div>
    			</div>
    			
    			<div class="card">
        			<div>
            			<div class="numbers">${nbrStagiairearchive}</div>
            			<div class="cardName">Stagiaires En archive</div>
        			</div>
        			<div class="iconBx">
            			<ion-icon name="archive-outline"></ion-icon>
        			</div>
    			</div>
    			
    			<div class="card">
        			<div>
            			<div class="numbers">${nbrStageaffecte}</div>
            			<div class="cardName">Stages Affectés</div>
        			</div>
        			<div class="iconBx">
           				 <ion-icon name="briefcase-outline"></ion-icon>
        			</div>
    			</div>

    			<div class="card">
        			<div>
            			<div class="numbers">${nbrStagenonaffecte}</div>
            			<div class="cardName">Stages Non Affectés</div>
        			</div>
					<div class="iconBx">
            			<ion-icon name="alert-circle-outline"></ion-icon>
        			</div>
    			</div>

    			<div class="card">
        			<div>
            			<div class="numbers">${nbrempaffecte}</div>
            			<div class="cardName">Encadrants Affectés</div>
        			</div>
        			<div class="iconBx">
           				 <ion-icon name="people-circle-outline"></ion-icon>
        			</div>
    			</div>

   			 <div class="card">
        			<div>
            			<div class="numbers">${nbrempnonaffecte}</div>
            			<div class="cardName">Encadrants Non Affectés</div>
        			</div>
        	<div class="iconBx">
            		<ion-icon name="alert-circle-outline"></ion-icon>
       		 </div>
    		</div>
		</div>
		</div>

</body>
</html>