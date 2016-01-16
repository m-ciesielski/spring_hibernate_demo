<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Dodawanie Kierowcy</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" crossorigin="anonymous"></script>
<script src="<%= request.getContextPath() %>/js/utils.js"></script>
<script src="<%= request.getContextPath() %>/js/address.js"></script>
<script src="<%= request.getContextPath() %>/js/driver.js"></script>
<script type="text/javascript">

        $(document).ready(function(){
          //Append context path to all AJAX requests
          var ctx = "${pageContext.request.contextPath}";
          generateAddressSelectList(0, ctx);
        });


</script>
</head>

<body>

<nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="/">java_ee_demo</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/drivers.jsp">Kierowcy</a></li>
                <li class="inactive"><a href="${pageContext.request.contextPath}/vehicles.jsp">Pojazdy</a></li>
              </ul>
            </div><!--/.nav-collapse -->
          </div><!--/.container-fluid -->
        </nav>

  <form name="add_driver_form" id="add_driver_form" modelAttribute="addDriverForm" data-toggle="validator" onsubmit="return addDriver('${pageContext.request.contextPath}');">
      <div class="form-group">
        <label for="firstName">Imie:</label>
        <input type="text" class="form-control" name="firstName"  path="firstName" id="firstName" required="true" />
      </div>
      <div class="form-group">
        <label for="lastName">Nazwisko:</label>
        <input type="text" class="form-control" id="lastName"  path="lastName" name="lastName" required="true" />
      </div>
      <div class="form-group">
              <label for="pesel">Pesel:</label>
              <input type="text" class="form-control" id="pesel"  path="pesel" pattern="\d{11}" minlength="11" maxlength="11" data-error="pesel musi miec dokładnie 11 znaków." name="pesel" required="true" />
            </div>
            <div class="form-group">
              <label for="salary">Pensja:</label>
              <div class="input-group">
                  <span class="input-group-addon">zł</span>
                  <input type="number" class="form-control" id="salary" name="salary"  path="salary" />
              </div>
             </div>
            <div class="form-group">
              <label for="salaryBonus">Premia:</label>
              <div class="input-group">
                  <span class="input-group-addon">zł</span>
                  <input type="number" class="form-control" id="salaryBonus" name="salaryBonus"  path="salaryBonus" />
              </div>
            </div>
      <div class="form-group">
        <label for="addressId">Adres:</label>
        <select name="addressId" id="addressId"  path="addressId" class="form-control">
        </select>
      </div>
      <div class="checkbox">
        <label><input type="checkbox" checked="checked"  path="available" id="available" name="available"/>Dostepny</label>
      </div>

        <button type="submit" class="btn btn-success">Dodaj</button>
        <a class="btn btn-warning" href="${pageContext.request.contextPath}/drivers.jsp">Anuluj</a>
  </form>
</body>
</html>