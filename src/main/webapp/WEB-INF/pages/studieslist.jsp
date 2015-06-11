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
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin DCM Options</title>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/tableeditor.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/studieswebservice.js" />"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
</head>
<body>



<div class="container-fluid">
    <div class="row text-center">
        <div class="col-md-4">
            <table id="dataStudiesTable" class="table" border="1">
                <caption><h1>Studies</h1></caption>
                <th> Key</th>
                <th></th>
                <c:forEach items="${studies}" var="cell">
                    <tr id="{cell.id}">
                        <td align="left"><input id="key${cell.id}" type="text" value="${cell.name}"></td>
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
</body>
</html>

