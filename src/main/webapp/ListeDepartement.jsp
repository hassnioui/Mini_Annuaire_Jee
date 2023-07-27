<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<title>Liste Départements</title>
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

.active {
        
        color :#25bcdf ;
        
        }

.navigation a:hover {

    color: #25bcdf;

}

</style>


</head>

<body>


	<header id="header">

        <a href="<%=request.getContextPath()%>/index" class="logo">Mini Annuiare</a>

        <nav class="navigation">

            <a href="<%=request.getContextPath()%>/listD">Liste Départements</a>
            <a href="<%=request.getContextPath()%>/listF">Liste Filières</a>
            <a href="<%=request.getContextPath()%>/listE">Liste Étudiants</a>
        </nav>
    </header>
	<br>

<section>
	<div class="row">
		<div class="container">
			<h3 class="text-center">Liste Départements</h3>
			<hr>
			<form class="form-inline d-flex justify-content-center md-form form-sm mt-0" action="searchD" method="GET">
    			<input class="form-control form-control-sm ml-3 w-75" type="text" name="nom" placeholder="Recherche" aria-label="Search" required>
    			<button class="btn btn-primary m-3" type="submit"><i class="fas fa-search"></i></button>
			</form>   
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nom</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${not empty departements}">
					<c:forEach var="departement" items="${departements}">

						<tr>
							<td>${departement.id}</td>
							<td>${departement.nom}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty departements}">
    					<tr>
        				<td colspan="2" class="text-center">Aucun résultat trouvé</td>
    					</tr>
				</c:if>
				</tbody>

			</table>
		</div>
	</div>
</section>
</body>
</html>
