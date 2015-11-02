<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="com.jdbc.demo.domain.Vehicle"
%>


<html>

<head>
<title>Drivers</title>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>

</head>

<body>
<jsp:useBean id="vehicles" class="com.jdbc.demo.services.VehiclesEntityManager" scope="application" />

<!-- Static navbar -->
        <nav class="navbar navbar-default">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">JEE Servlet Demo</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="drivers.jsp">Drivers</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li>
                <li><a href="../navbar-static-top/">Static top</a></li>
                <li><a href="../navbar-fixed-top/">Fixed top</a></li>
              </ul>
            </div><!--/.nav-collapse -->
          </div><!--/.container-fluid -->
        </nav>

  <table class="table table-hover">
  <thead>
      <tr>
           <td>ID</td>
           <td>Imie</td>
           <td>Nazwisko</td>
           <td>PESEL</td>
           <td>Pensja</td>
           <td>Premia</td>
           <td>Adres</td>
      </tr>
  </thead>

  <c:forEach var="driver" items="${drivers.all}">
          <tr>
              <td>${driver.id}</td>
              <td>${driver.firstName}</td>
              <td>${driver.lastName}</td>
              <td>${driver.PESEL}</td>
              <td>${driver.salary}</td>
              <td>${driver.salaryBonus}</td>
              <td>${driver.address.street} ${driver.address.houseNumber}, ${driver.address.town}, ${driver.address.country}</td>

              <form name=add_driver_form action="driver" method="post">
                <td><button type=submit method=post class="btn btn-primary">Edytuj</button></td>
              </form>
              <form name=delete_driver action="driver" method="post">
                <td><button type=submit method=post name="delete" class="btn btn-danger">Usuñ</button></td>
              </form>
          </tr>
  </c:forEach>
  </table>

  <form name=add_driver_form action="driver" method="post">
      Imie:</td><td><input type="text" name="first-name" required/></td></tr>
      Nazwisko:</td><td><input type="text" name="last-name" required/></td></tr>
      PESEL:</td><td><input type="text" name="pesel" required/></td></tr>
      Adres:</td><td>
      <select name="address-id">
        <c:forEach var="address" items="${addresses.all}">
            <option value=${address.id}>${address.street} ${address.houseNumber}, ${address.town}, ${address.country}</option>
        </c:forEach>
      </select>
      </td></tr>
      <div class="checkbox">
        <label><input type="checkbox" value="available">Dostepny</label>
      </div>
       </td><td><input type="submit" value="Submit"></td></tr>
  </form>
</body>
</html>