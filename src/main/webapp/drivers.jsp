<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Kierowcy</title>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
	crossorigin="anonymous"></script>
<!-- bootbox.js at 4.4.0 -->
<script
	src="https://rawgit.com/makeusabrew/bootbox/f3a04a57877cab071738de558581fbc91812dce9/bootbox.js"></script>

<script src="js/utils.js"></script>
<script src="js/address.js"></script>
<script src="js/driver.js"></script>

<script type="text/javascript">

        $(document).ready(function(){
        	var ctx = "${pageContext.request.contextPath}";
            generateDriversTable(ctx);
        });


</script>

</head>

<body>

	<!-- Static navbar -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">JEE Servlet Demo</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="drivers">Kierowcy</a></li>
					<li class="inactive"><a href="vehicles">Pojazdy</a></li>
					<li class="inactive"><a href="clients">Klienci</a></li>
					<li class="inactive"><a href="transports">Transporty</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</nav>

	<a href="${pageContext.request.contextPath}/drivers/add" class="btn btn-success">Dodaj kierowcę</a>

	<table class="table table-hover" id="drivers_table">
		<thead>
			<tr>
				<td>ID</td>
				<td>Imie</td>
				<td>Nazwisko</td>
				<td>PESEL</td>
				<td>Pensja</td>
				<td>Premia</td>
				<td>Adres</td>
				<td>Edycja</td>
				<td>Usuwanie</td>
			</tr>
		</thead>
	</table>
</body>
</html>
