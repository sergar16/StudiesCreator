<%--
  Created by IntelliJ IDEA.
  User: Logitech
  Date: 02.06.15
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Main</title>

  <script type="text/javascript" src="<c:url value="/resources/js/tableeditor.js" />"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
</head>

<body>

<h2 align="center"> Admin Condition Options</h2>


<c:url value="/j_spring_security_logout" var="logoutUrl" />

<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
  <input type="hidden"
         name="${_csrf.parameterName}"
         value="${_csrf.token}" />
</form>

<script>
  function formSubmit() {
    document.getElementById("logoutForm").submit();
  }
</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
  <h2>
    Welcome : ${pageContext.request.userPrincipal.name} | <a
          href="javascript:formSubmit()"> Logout</a>
  </h2>
</c:if>


<div class="container-fluid">
  <div class="row text-center">
    <div class="col-md-6">
      <table id="dataKeyTable" class="table" border="1">
        <caption><h1>Names</h1></caption>
        <th> Key</th>
        <th></th>
        <c:forEach items="${names}" var="cell">
          <tr>
            <td align="left"><input  type="text" value="${cell.name}"></td>
            <td>
              <button type="button" class="close" aria-label="Close"><span
                      aria-hidden="true">&times;</span>
              </button>
            </td>
            <td>
              <button type="button" class="add" aria-label="Close"><span
                      aria-hidden="true">&times;</span>
              </button>
            </td>
            <td><button type="button" class="btn btn-default" aria-label="Left Align">
              <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
            </button></td>
          </tr>
        </c:forEach>
      </table>

      <input type="button" value="delete" onclick="deleteRow('dataKeyTable')" style="width:100px;height:100px">
      <input type="button" class="increment-button" value="add" onclick="addRow('dataKeyTable')"
             style="width:100px;height:100px">

    </div>

    <!--  Sources-->
    <div class="col-md-6">
      <table id="dataSourceTable" class="table" border="1">
        <caption><h1>Available Values</h1></caption>

        <th> Source</th>
        <th></th>
        <c:forEach items="${values}" var="cell">

          <tr>
            <td align="left"><input type="text" value="${cell.value}"></td>
            <td>
              <button type="button" class="close" aria-label="Close"><span
                      aria-hidden="true">&times;</span>
              </button>
            </td>
          </tr>
        </c:forEach>
      </table>

      <input type="button" value="delete" onclick="deleteRow('dataSourceTable')" class="bu">


      <input type="button" value="add" onclick="addRow('dataSourceTable')" class="increment-button">
    </div>


    </div>
  </div>
</div>
</body>

</html>

