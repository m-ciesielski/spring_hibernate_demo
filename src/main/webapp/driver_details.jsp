<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Edycja Kierowcy</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" crossorigin="anonymous"></script>
<script src="<%= request.getContextPath() %>/js/utils.js"></script>
<script src="<%= request.getContextPath() %>/js/address.js"></script>
<script src="<%= request.getContextPath() %>/js/driver.js"></script>
</head>
<script type="text/javascript">

        $(document).ready(function(){
          //Append context path to all AJAX requests
          var ctx = "${pageContext.request.contextPath}";
          var url = window.location.href;
          var driverId = url.substr(url.lastIndexOf('/') + 1);
          fillDriverEditForm(driverId, ctx);
        });


</script>
<body>

<!-- Static navbar -->
        <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="/">logistics_mgmt</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}//drivers">Kierowcy</a></li>
                <li class="inactive"><a href="${pageContext.request.contextPath}//vehicles">Pojazdy</a></li>
              </ul>
            </div><!--/.nav-collapse -->
          </div><!--/.container-fluid -->
        </nav>

  <form name="driver_edit_form" id="driver_edit_form" data-toggle="validator" disabled>
      <input type="hidden" path="id" id="driverId" name="id"/>
      <div class="form-group">
        <label for="firstName">Imie:</label>
        <input type="text" class="form-control" name="firstName"  path="firstName" id="firstName" disabled />
      </div>
      <div class="form-group">
        <label for="lastName">Nazwisko:</label>
        <input type="text" class="form-control" id="lastName"  path="lastName" name="lastName" disabled />
      </div>
      <div class="form-group">
        <label for="pesel">Pesel:</label>
        <input type="text" class="form-control" id="pesel"  path="pesel" data-minlength="11" data-error="pesel musi miec dokładnie 11 znaków." data-maxlength="11" name="pesel" disabled />
      </div>
      <div class="form-group">
        <label for="salary">Pensja:</label>
        <input type="text" class="form-control" id="salary" name="salary"  path="salary" disabled />
       </div>
      <div class="form-group">
        <label for="salaryBonus">Premia:</label>
        <input type="text" class="form-control" id="salaryBonus" name="salaryBonus"  path="salaryBonus" disabled />
      </div>
      <div class="form-group">
        <label for="addressId">Adres:</label>
        <select name="addressId" id="addressId"  path="addressId" class="form-control" disabled>
          <c:forEach var="address" items="${addresses}">
              <option value=${address.id}>${address.street} ${address.houseNumber}, ${address.town}, ${address.country}</option>
          </c:forEach>
        </select>
      </div>
      <div class="checkbox">
        <label><input type="checkbox" checked="checked"  path="available" id="available" name="available" disabled/>Dostepny</label>
      </div>
      
        <a class="btn btn-success" href="${pageContext.request.contextPath}//drivers.jsp">Przejdź do listy kierowców</a>
  </form>
</body>
</html>