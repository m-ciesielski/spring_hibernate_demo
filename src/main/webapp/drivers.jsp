<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="com.jdbc.demo.domain.Driver"
import="com.jdbc.demo.domain.Address"
%>


<html>

<head>
<title>Drivers</title>
<html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>


<SCRIPT LANGUAGE="JavaScript">
$(document).ready(function () {
    $(".edit_button").on("click", function () {
        //get row id
        var $this = $(this).closest('tr').children();
        
        var rowid = $this.eq(0).text();
        $("#editRow").text(rowid);
        console.log(rowid)

        $("#popupEdit").alert("open");
    });

    $(".popupbutton").on("click", function () {
        $("#popupEdit").alert("close");
    });

});
</script>

</head>

<body>
<jsp:useBean id="drivers" class="com.jdbc.demo.services.DriverEntityManager" scope="application" />
<jsp:useBean id="addresses" class="com.jdbc.demo.services.AddressEntityManager" scope="application" />

 <div data-role="popup" id="popupEdit" data-theme="a" class="ui-corner-all" data-dismissible="false">
        <div class="ui-content">
            <p>You are editing the row with ID: <strong id="editRow"></strong>
            </p>
            <hr />
            <label for="txtID">ID:</label>
            <input type="text" name="txtID" id="txtID" value="" />
            <label for="txtName">Name:</label>
            <input type="text" name="txtName" id="txtName" value="" />
            <fieldset class="ui-grid-a">
                <div class="ui-block-a">
                    <input type="button" value="OK" data-theme="b" class="popupbutton" />
                </div>
                <div class="ui-block-b">
                    <input type="button" value="Cancel" data-theme="a" class="popupbutton" />
                </div>
            </fieldset>
        </div>
  </div>

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

                <td><button class="btn btn-primary edit_button">Edytuj</button></td>
              <form name="delete_driver_form" action="driver" method="post">
                <input type="hidden" class="form-control" name="id" id="id" value="${driver.id}">
                <td><button type=submit method=post name="delete" value="true" class="btn btn-danger">Usuń</button></td>
              </form>
          </tr>
  </c:forEach>
  </table>

  <form name="add_driver_form" action="driver" method="post" role="form">
      <div class="form-group">
        <label for="first-name">Imie:</label>
        <input type="text" class="form-control" name="first-name" id="first-name">
      </div>
      <div class="form-group">
        <label for="last-name">Nazwisko:</label>
        <input type="text" class="form-control" id="last-name" name="last-name">
      </div>
      <div class="form-group">
        <label for="pesel">Pesel:</label>
        <input type="text" class="form-control" id="pesel" name="pesel">
      </div>
      <div class="form-group">
        <label for="address-id">Adres:</label>
        <select name="address-id">
          <c:forEach var="address" items="${addresses.all}">
              <option value=${address.id}>${address.street} ${address.houseNumber}, ${address.town}, ${address.country}</option>
          </c:forEach>
        </select>
      </div>
      <div class="checkbox">
        <label><input type="checkbox" checked="true" id="available" name="available">Dostepny</label>
      </div>
      
        <button type="submit" class="btn btn-default">Submit</button>
  </form>

  
<!-- Use the following button code for the new window -->

<form>
<input type=button value="Open the Popup Window" onClick="javascript:popUp('testfile.html')">
</form>

<!-- Generated at http://www.csgnetwork.com/puhtmlwincodegen.html -->
</body>
</html>