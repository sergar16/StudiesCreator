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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Studies List</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/text-field.css" />"/>
</head>
<body>
<jsp:include page="header.jsp"/>


<div class="container-fluid">
    <div class="row text-center">
        <div class="col-md-4">
            <table id="dataStudiesTable" class="table" border="1">

                <th>Studies</th>
                <th></th>
                <th align="center">
                    <button id="saveStudies" type="button" class="btn btn-default btn-lg">
                        <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
                    </button>
                </th>
                <c:forEach items="${studies}" var="cell">
                    <tr id="${cell.id}">
                        <td align="left"><input id="key${cell.id}" class="inputtext" type="text" value="${cell.name}">
                        </td>

                        <td>
                            <form action=<c:url value="/user/edit/${cell.id}"/>>
                                <input type="submit" id="${cell.id}" value="edit"/>
                            </form>
                        </td>

                        <td>
                            <button data-id="${cell.id}" id="${cell.id}" type="button" class="close add"
                                    aria-label="Close"
                                    style="-webkit-transform: rotateZ(45deg);float: none"
                                    onclick="addRow('dataStudiesTable')"><span
                                    aria-hidden="true">&times;</span>
                            </button>
                        </td>

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

    </div>
</div>

</body>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-2.1.4.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/tableEditor.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/studiesWebService.js" />"></script>
</html>

