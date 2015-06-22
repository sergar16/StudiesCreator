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
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/text-field.css" />"/>


</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container-fluid">
    <div class="row text-center">
        <div class="col-md-6">
            <table id="dataNameTable" class="table" border="1">
                <th>
                    <h3>Names
                        <button  type="button" class="close add"
                                aria-label="Close"
                                style="-webkit-transform: rotateZ(45deg);float: none"
                                onclick="addRow('dataNameTable')"><span
                                aria-hidden="true">&times;</span>
                        </button>
                    </h3>
                </th>
                <th></th>
                <th align="center">

                </th>
                <c:forEach items="${names}" var="cell">
                    <tr id="${cell.id}">
                        <td align="left"><input type="text" class="inputtext" value="${cell.name}"></td>

                        <td>
                            <button data-id="${cell.id}" id="w${cell.id}" type="button" class="close" aria-label="Close"
                                    style="float: none"><span
                                    aria-hidden="true">&times;</span>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>


        </div>

        <!--  Values-->
        <div class="col-md-6">
            <table id="dataValueTable" class="table" border="1">

                <th align="center">
                    <h3>Values
                        <button type="button" class="close add"
                                aria-label="Close"
                                style="-webkit-transform: rotateZ(45deg);float: none"
                                onclick="addRow('dataValueTable')"><span
                                aria-hidden="true">&times;</span>
                        </button>
                    </h3>
                </th>
                <th></th>
                <th align="center">

                </th>
                <c:forEach items="${values}" var="cell">

                    <tr id="${cell.value}">
                        <td align="left"><input type="text" value="${cell.value}"></td>

                        <td>
                            <button data-id="${cell.value}" type="button" class="close" aria-label="Close"
                                    style="float: none"><span
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
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-2.1.4.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/tableEditor.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/conditionWebService.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>

</html>

