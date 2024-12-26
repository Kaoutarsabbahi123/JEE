<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
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

/* =============== Navigation ================ */
.navigation {
  position: fixed;
  width: 250px;
  height: 100%;
  background: var(--blue);
  border-left: 10px solid var(--blue);
  transition: width 0.5s;
  overflow: hidden;
}
.navigation.active {
  width: 80px;
}

.navigation ul {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
}

.navigation ul li {
  position: relative;
  width: 100%;
  list-style: none;
  border-top-left-radius: 30px;
  border-bottom-left-radius: 30px;
}

.navigation ul li:hover,
.navigation ul li.hovered {
  background-color: var(--white);
}
  .navigation ul li.active{
    background-color: white;
    color:#008ecf;
  }
  .navigation ul li.active a{
    color:#008ecf;
  }
.navigation ul li:nth-child(1) {
  margin-bottom: 40px;
}

.navigation ul li a {
  position: relative;
  display: block;
  width: 100%;
  display: flex;
  text-decoration: none;
  color: var(--white);
}
.navigation ul li:hover a,
.navigation ul li.hovered a {
  color: var(--blue);
}

.navigation ul li a .icon {
  position: relative;
  display: block;
  min-width: 60px;
  height: 60px;
  line-height: 75px;
  text-align: center;
}
.navigation ul li a .icon ion-icon {
  font-size: 1.75rem;
}

.navigation ul li a .title {
  position: relative;
  display: block;
  padding: 0 10px;
  height: 60px;
  line-height: 60px;
  text-align: start;
  white-space: nowrap;
}

/* --------- curve outside ---------- */
.navigation ul li:hover a::before,
.navigation ul li.hovered a::before {
  content: "";
  position: absolute;
  right: 0;
  top: -50px;
  width: 50px;
  height: 50px;
  background-color: transparent;
  border-radius: 50%;
  box-shadow: 35px 35px 0 10px var(--white);
  pointer-events: none;
}
.navigation ul li:hover a::after,
.navigation ul li.hovered a::after {
  content: "";
  position: absolute;
  right: 0;
  bottom: -50px;
  width: 50px;
  height: 50px;
  background-color: transparent;
  border-radius: 50%;
  box-shadow: 35px -35px 0 10px var(--white);
  pointer-events: none;
}
  .navigation ul li.active a::before{
    content: "";
    position: absolute;
    right: 0;
    top: -50px;
    width: 50px;
    height: 50px;
    background-color: transparent;
    border-radius: 50%;
    box-shadow: 35px 35px 0 10px white;
  }
  .navigation ul li.active a::after {
    content: "";
    position: absolute;
    right: 0;
    bottom: -50px;
    width: 50px;
    height: 50px;
    background-color: transparent;
    border-radius: 50%;
    box-shadow: 35px -35px 0 10px white;
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
  padding: 0 10px;
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


@media (max-width: 991px) {
  .navigation {
    left: -300px;
  }
  .navigation.active {
    width: 300px;
    left: 0;
  }
  .main {
    width: 100%;
    left: 0;
  }
  .main.active {
    left: 300px;
  }
}

@media (max-width: 480px) {
  .navigation {
    width: 100%;
    left: -100%;
    z-index: 1000;
  }
  .navigation.active {
    width: 100%;
    left: 0;
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
    <div class="container">
        <div class="navigation">
            <ul>
                <li>
                	<a href="info.jsp">
                		<span class="icon">
                			 <ion-icon name="person-outline"></ion-icon>
                		</span>
                		<span class="title"><p> ${utilisateur.nom} ${utilisateur.prenom}</p></span>
                	</a>
                </li>
                <li> 
                    <a href="Statistique" >
                        <span class="icon">
                            <ion-icon name="home-outline"></ion-icon>
                        </span>
                        <span class="title">Acceuil</span>
                    </a>
                </li>

                <li>
                    <a href="StagiaireServlet" id="stagiaires-link">
                        <span class="icon">
                            <ion-icon name="people-outline"></ion-icon>
                        </span>
                        <span class="title">Stagiaires</span>
                    </a>
                </li>

				<li> 
				    <c:if test="${sessionScope.userRole eq 'superadmin' or sessionScope.userRole eq 'chefdrh'}">
                    <a href="Stageservlet">
                        <span class="icon">
                            <ion-icon name="briefcase-outline"></ion-icon>
                        </span>
                        <span class="title">Stages</span>
                    </a>
                    </c:if>
                </li>
                <li> 
                    <c:if test="${sessionScope.userRole eq 'admin'}">
                    <a href="Stageservlet">
                        <span class="icon">
                            <ion-icon name="briefcase-outline"></ion-icon>
                        </span>
                        <span class="title">Stages</span>
                    </a>
                    </c:if>
                </li>
                <li> 
                    <c:if test="${sessionScope.userRole eq 'superadmin' or sessionScope.userRole eq 'chefdrh'}">
                    <a href="EncadrantServlet">
                        <span class="icon">
                            <ion-icon name="school-outline"></ion-icon>
                        </span>
                        <span class="title">Encadrants</span>
                    </a>
                    </c:if>
                </li>
                 <li>
                    <a href="abscent.jsp">
                        <span class="icon">
                            <ion-icon name="close-circle-outline"></ion-icon>
                        </span>
                        <span class="title">L'abscence</span>
                    </a>
                </li>
                <li>
                    <a href="email.jsp">
                        <span class="icon">
                            <ion-icon name="mail-outline"></ion-icon>
                        </span>
                        <span class="title">Email</span>
                    </a>
                </li>
                <li class="role-dependent" data-role="superadmin">
                    <c:if test="${sessionScope.userRole eq 'superadmin'}">
                    <a href="UtilisateurServlet" id="utilisateurs-link">
                        <span class="icon">
                            <ion-icon name="people-circle-outline"></ion-icon>
                        </span>
                        <span class="title">Utilisateurs</span>
                    </a>
                    </c:if>
                </li>
                <li>
                    <a href="Login.jsp">
                        <span class="icon">
                            <ion-icon name="log-out-outline"></ion-icon>
                        </span>
                        <span class="title">Sign Out</span>
                    </a>
                </li>
            </ul>
        </div>
      </div>
      <script>
      document.addEventListener('DOMContentLoaded', function() {
    	    const listItems = document.querySelectorAll('.navigation ul li');

    	    listItems.forEach(item => {
    	        item.addEventListener('click', function() {
    	            listItems.forEach(li => {
    	                li.classList.remove('active');
    	            });
    	            this.classList.add('active');
    	        });
    	    });
    	});
  </script>
</body>
</html>