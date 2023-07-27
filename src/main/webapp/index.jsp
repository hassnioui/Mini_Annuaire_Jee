<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<style>

@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');

* {

    font-family: 'Poppins', sans-serif;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    scroll-behavior: smooth;

}


::-webkit-scrollbar {
    width: 10px;
}

::-webkit-scrollbar-track {
    background: #f1f1f1;
}

::-webkit-scrollbar-thumb {
    background: #888;
}

::-webkit-scrollbar-thumb:hover {
    background: #555;
}

section {

    padding: 100px 200px;

    
}
header {

    width: 100%;
    position: fixed;
    z-index: 1000;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 200px;
    transition: all 0.3s ease;
    background-color: #1e2d3b;
}


.logo {

    text-decoration: none;
    color: #25bcdf;
    font-weight: 700;
    font-size: 1.8em;
    text-transform: uppercase;
    margin-left: 10px;

}

.navigation a {

    text-decoration: none;
    color: #fff;
    font-weight: 500;
    font-size: 1.2em;
    padding-left: 30px;

}



.navigation a:hover {

    color: #25bcdf;

}

.title {

    display: flex;
    justify-content: center;
    color: #25bcdf;
    font-weight: 800;
    margin-bottom: 30px;
    font-size: 2.2em;

}

.content {

    display: flex;
    justify-content: center;
    flex-direction: row;
    flex-wrap: wrap;

}

.card {

    background-color: #fff;
    width: 21.30em;
    box-shadow: 0 5px 25px rgba(1 1 1 / 15%);
    border-radius: 10px;
    padding: 25px;
    margin: 15px;
    transition: 0.7s ease;

}

.card:hover {

    transform: scale(1.1);

}

.icon {

    font-size: 8em;
    color: #25bcdf;
    text-align: center;

}

.info {

    text-align: center;

}

.info p {


    text-align: justify;

}

.info h3 {

    color: #25bcdf;
    font-weight: 700;
    font-size: 1.2em;
    margin: 10px;

}



</style>


<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
        <link rel="stylesheet" href="style.css">
</head>
        <title>Mini Annuiare</title>
</head>

<body>

    <header id="header">

        <a href="<%=request.getContextPath()%>/index" class="logo">Mini Annuiare</a>

        <nav class="navigation">

            <a href="<%=request.getContextPath()%>/newD">Menu Aministration</a>
            <a href="<%=request.getContextPath()%>/listE">Menu Utilisation</a>
        </nav>
    </header>

    <section class="cards" id="services">

        <div class="content">
	<a style="text-decoration: none; color:black;" href="<%=request.getContextPath()%>/newD">
            <div class="card">

                <div class="icon">
                    <i class="fas fa-user-cog"></i>
                </div>

                <div class="info">

                    <h3> Administartion </h3>

                    <p>Effectuez facilement l'insertion d'étudiants, départements et des filières.</p>

                </div>

            </div>
	</a>
	<a style="text-decoration: none; color:black;" href="<%=request.getContextPath()%>/listE">
            <div class="card">

                <div class="icon">
                    <i class="fas fa-user"></i>
                </div>

                <div class="info">

                    <h3> Utilisation </h3>

                    <p>Consultez facilement la liste complète des étudiants, des départements et des filières.</p>

                </div>

            </div>
	</a>
        </div>

    </section>
</body>

</html>