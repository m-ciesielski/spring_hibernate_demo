<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="com.jdbc.demo.domain.Vehicle"
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
<jsp:useBean id="vehicles" class="com.jdbc.demo.services.VehicleEntityManager" scope="application" />

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
                <li class="active"><a href="vehicles.jsp">Drivers</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li>
                <li><a href="../navbar-static-top/">Static top</a></li>
                <li><a href="../navbar-fixed-top/">Fixed top</a></li>
              </ul>
            </div><!--/.nav-collapse -->
          </div><!--/.container-fluid -->
        </nav>

  <table class="table table-hover" id="vehicles_table">
  <thead>
      <tr>
           <td>ID</td>
           <td>Marka</td>
           <td>Typ</td>
           <td>Silnik</td>
           <td>VIN</td>
           <td>KM</td>
           <td>Przebieg</td>
      </tr>
  </thead>

  <c:forEach var="vehicle" items="${vehicles.all}">
          <tr>
              <td>${vehicle.id}</td>
              <td>${vehicle.brand}</td>
              <td>${vehicle.type}</td>
              <td>${vehicle.engine}</td>
              <td>${vehicle.VIN}</td>
              <td>${vehicle.horsepower}</td>
              <td>${vehicle.horsepower}</td>

                <td><button class="btn btn-primary edit_button">Edytuj</button></td>
              <form name="delete_vehicle_form" action="vehicles" method="post">
                <input type="hidden" class="form-control" name="id" id="id" value="${vehicle.id}">
                <td><button type=submit method=post name="delete" value="true" class="btn btn-danger">Usuñ</button></td>
              </form>
          </tr>
  </c:forEach>
  </table>

  <form name="add_vehicle_form" action="vehicles" method="post" role="form">
      <div class="form-group">
        <label for="first-name">Marka:</label>
        <input type="text" class="form-control" name="brand" id="brand">
      </div>
      <div class="form-group">
        <label for="last-name">Typ:</label>
        <input type="text" class="form-control" id="type" name="type">
      </div>
      <div class="form-group">
        <label for="pesel">Silnik:</label>
        <input type="text" class="form-control" id="engine" name="engine">
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