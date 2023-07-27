<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Ajouté avec Succès</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
    <style>
        .card-body {
            background: white !important;
        }

        .card form {
            background: white !important;
        }

        .card {
            background: white !important;
            box-shadow: 0 5px 25px rgba(1 1 1 / 15%);
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
        
       
        
        
    </style>
</head>
<body>
    <header id="header">
        <a href="<%=request.getContextPath()%>/index" class="logo">Mini Annuaire</a>
        <nav class="navigation">
            <a href="<%=request.getContextPath()%>/newD">Insérer Département</a>
            <a href="<%=request.getContextPath()%>/newF">Insérer Filière</a>
            <a href="<%=request.getContextPath()%>/newE">Insérer Étudiant</a>
        </nav>
    </header>

    <section>
        <div class="row">
            <div class="col-lg-7 mx-auto">
                <div class="card mt-2 mx-auto p-4 bg-light">
                    <div class="card-body bg-light">
                        <div class="container">
                            <form action="insertD" method="post">
                                <div class="controls">
                                    <div class="row">
                                        <c:if test="${not empty successMessage}">
                                        <div class="col-md-12">
                                        <div class="alert alert-success" role="alert">
										  <strong>Succès!</strong> ${successMessage}
										</div>
										</div>
										</c:if>
										<c:if test="${empty successMessage}">
										    <div class="col-md-12">
										        <div class="alert alert-danger" role="alert">
										            <strong>Erreur!</strong> Étudiant n'est pas ajouté avec succès !
										        </div>
										    </div>
										</c:if>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mt-3">
                                           <a href="<%=request.getContextPath()%>/index" type="button" style="color:white;" class="btn btn-danger btn-send pt-2 btn-block">Retour</a>
                                        </div>
                                    	<div class="col-md-6 mt-3">
                                            <a href="<%=request.getContextPath()%>/newE" class="btn btn-primary btn-send pt-2 btn-block" >Insérer Nouveau</a>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
