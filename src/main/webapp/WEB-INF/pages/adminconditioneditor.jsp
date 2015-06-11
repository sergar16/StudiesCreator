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
  <title>Admin Condition Options</title>
  <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/tableeditor.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/conditionwebservice.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>

  <style>

  </style>
</head>

<body>

<div class="container-fluid">
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Studies Creator</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
          <li><a href="#">Link</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${pageContext.request.userPrincipal.name}<span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">

              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li class="divider"></li>
              <li><a href="#">Separated link</a></li>
              <li class="divider"></li>
              <li><a href="#">One more separated link</a></li>
            </ul>
          </li>
        </ul>
        <form class="navbar-form navbar-left" role="search">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#">Link</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> ${pageContext.request.userPrincipal.name} <span class="caret"></span></a>
            <ul class="dropdown-menu" role="menu">
              <li>
                <c:url value="/j_spring_security_logout" var="logoutUrl" />
                <c:if test="${pageContext.request.userPrincipal.name != null}">

                     <a href="javascript:formSubmit()"> Logout</a>

                </c:if>
                <form action="${logoutUrl}" method="post" id="logoutForm">
                  <input type="hidden"
                         name="${_csrf.parameterName}"
                         value="${_csrf.token}" />
                </form></li>
              <li><a href="#">Action</a></li>
              <li><a href="#">Another action</a></li>
              <li><a href="#">Something else here</a></li>
              <li class="divider"></li>
              <li><a href="#">Separated link</a></li>
            </ul>
          </li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
  </nav>
</div>

<h2 align="center"> Admin Condition Options</h2>




<!-- csrt for log out-->







<div class="container-fluid">
  <div class="row text-center">
    <div class="col-md-6">
      <table id="dataNameTable" class="table" border="1">
        <caption><h1>Names</h1></caption>
        <th> Key</th>
        <th></th>
        <c:forEach items="${names}" var="cell">
          <tr>
            <td align="left"><input  type="text" value="${cell.name}"></td>
            <td>
              <button data-id="${cell.id}" id="w${cell.id}" type="button" class="close" aria-label="Close" style="-webkit-transform: rotateZ(45deg);float: none" ><span
                      aria-hidden="true">&times;</span>
              </button>
            </td>
            <td>
              <button data-id="${cell.id}" id="w${cell.id}" type="button" class="close" aria-label="Close" style="float: none" ><span
                      aria-hidden="true">&times;</span>
              </button>
            </td>
          </tr>
        </c:forEach>
      </table>

    </div>

    <!--  Sources-->
    <div class="col-md-6">
      <table id="dataValueTable" class="table" border="1">
        <caption><h1>Available Values</h1></caption>

        <th> Source</th>
        <th></th>
        <c:forEach items="${values}" var="cell">

          <tr>
            <td align="left"><input type="text" value="${cell.value}"></td>
            <td>
              <button data-id="${cell.id}" id="w${cell.id}" type="button" class="close" aria-label="Close" style="-webkit-transform: rotateZ(45deg);float: none" ><span
                      aria-hidden="true">&times;</span>
              </button>
            </td>
            <td>
              <button data-id="${cell.id}" id="w${cell.id}" type="button" class="close" aria-label="Close" style="float: none" ><span
                      aria-hidden="true">&times;</span>
              </button>
            </td>
          </tr>
        </c:forEach>
      </table>


    </div>


    </div>
  </div>
</div>
</body>

</html>

