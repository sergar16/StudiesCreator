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
  <%--<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>--%>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/tableeditor.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/conditionwebservice.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>--%>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/css/text-field.css" />"/>

  <style>

  </style>
</head>

<body>




<!-- csrt for log out-->





<jsp:include page="header.jsp"/>

<div class="container-fluid">
  <div class="row text-center">
    <div class="col-md-6">
      <table id="dataNameTable" class="table" border="1">
        <th> <h3>Names</h3></th>
        <th></th>
        <c:forEach items="${names}" var="cell">
          <tr id="${cell.id}">
            <td align="left"><input  type="text" class="inputtext" value="${cell.name}"></td>
            <td>
              <button data-id="${cell.id}" id="w${cell.id}" type="button" class="close add" aria-label="Close"
                      style="-webkit-transform: rotateZ(45deg);float: none" onclick="addRow('dataNameTable')" ><span
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
      <button id="savename">Save</button>

    </div>

    <!--  Sources-->
    <div class="col-md-6">
      <table id="dataValueTable" class="table" border="1">

        <th> <h3>Available Values</h3></th>
        <th></th>
        <c:forEach items="${values}" var="cell">

          <tr>
            <td align="left"><input type="text" value="${cell.value}"></td>
            <td>
              <button data-id="${cell.id}" id="w${cell.id}" type="button" class="close add" aria-label="Close"
                      style="-webkit-transform: rotateZ(45deg);float: none" onclick="addRow('dataValueTable')" ><span
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
      <button id="savevalue">Save</button>


    </div>


    </div>
  </div>
</div>
</body>

</html>

