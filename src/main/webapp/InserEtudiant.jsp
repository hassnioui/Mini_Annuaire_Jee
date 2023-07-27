<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Insérer Étudiant</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
    
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
                            <form action="insertE" method="post">
                                <div class="controls">
                                    <div class="row">
                                    <c:if test="${not empty successMessage}">
                                        <div class="col-md-12">
                                        <div class="alert alert-success" role="alert">
										  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										  <strong>Success!</strong> ${successMessage}
										</div>
										</div>
									</c:if>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="CNE">CNE</label>
                                                <input id="CNE" type="text" name="CNE" class="form-control" placeholder="Veuillez entrer le CNE" required="required">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="Nom">Nom</label>
                                                <input id="Nom" type="text" name="nom" class="form-control" placeholder="Veuillez entrer le Nom" required="required">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="Prenom">Prénom</label>
                                                <input id="Prenom" type="text" name="prenom" class="form-control" placeholder="Veuillez entrer le Prénom" required="required">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
									        <div class="form-group">
									            <label for="departement">Départements</label>
									            <select name="departement" id="departement" class="form-control" required="required">
									            		<option disabled selected>---- Choisis une option ----</option>
									                <c:forEach var="departement" items="${departements}">
									                    <option value="${departement.nom}">${departement.nom}</option>
									                </c:forEach>
									            </select>
									        </div>
									    </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
									        <div class="form-group">
									            <label for="filiere">Filières</label>
									            <select name="filiere" class="form-control" required="required">
									            		<option disabled selected>---- Choisis une option ----</option>
									                <c:forEach var="filiere" items="${filieres}">
									                    <option value="${filiere.nom}">${filiere.nom}</option>
									                </c:forEach>
									            </select>
									        </div>
									    </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="telephone">Téléphone</label>
                                                <input id="telephone" type="text" name="telephone" class="form-control" placeholder="Veuillez entrer le Téléphone" required="required">
                                            </div>
                                        </div>
                                        <div class="col-md-6 mt-3">
                                            <a href="<%=request.getContextPath()%>/index" type="button" style="color:white;" class="btn btn-danger btn-send pt-2 btn-block">Retour</a>
                                        </div>
                                        <div class="col-md-6 mt-3">
                                            <input type="submit" class="btn btn-primary btn-send pt-2 btn-block" value="Ajouter">
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
