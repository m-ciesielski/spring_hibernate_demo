<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="com.jdbc.demo.domain.Driver"
%>

<html>
<head><title>Drivers</title></head>
<body>
  <jsp:useBean id="driverEM" class="com.jdbc.demo.services.DriverEntityManager" scope="application" />
  <table>
  <tr>
       <td>ID</td>
       <td>Imie</td>
       <td>Nazwisko</td>
  </tr>
  <%
       for (Driver driver: driverEM.getAll() ){
            out.println("<tr><td>" + driver.getId() + "</td>" + "<td>" + driver.getFirstName() + "</td>"+
                        "<td>" + driver.getLastName() + "</td>" + "</tr>");
       }
  %>
  </table>

  <form name=add_driver_form action="<%=application.getContextPath() %>/driver" method="post">
      Id:</td><td><input type="text" name="id" required/></td></tr>
      Imie:</td><td><input type="text" name="first-name" required/></td></tr>
      Nazwisko:</td><td><input type="text" name="last-name" required/></td></tr>
       </td><td><input type="submit" value="Submit"></td></tr>
      </form>
</body>
</html>