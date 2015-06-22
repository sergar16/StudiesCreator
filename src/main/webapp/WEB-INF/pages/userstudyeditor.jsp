<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <title>Study Editor</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/text-field.css" />"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<p id="study" class='hidden' data-id="${study.id}"></p>
<h4>${study.name}</h4>

<table id="Conditions" align="left" border="1" style="margin-right: 30px">
    <caption><h1>Conditions</h1></caption>
    <th>name</th>
    <th> value</th>
    <th></th>
    <th></th>
    <c:forEach items="${study.conditions}" var="cell">
        <tr id="${study.id}">
            <td align="left">
                <select name="name" class="names">
                    <c:forEach var="item" items="${names}">
                        <option value="${item.name}" ${item.name == cell.name ? 'selected="selected"' : ''}>${item.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td align="left"><select name="value" class="values">
                <c:forEach var="item" items="${values}">
                    <option value="${item.value}" ${item.value == cell.value ? 'selected="selected"' : ''}>${item.value}</option>
                </c:forEach>
            </select>
            </td>
            <td>
                <button data-id="${cell.id}" id="w${cell.id}" type="button" class="close add" aria-label="Close"
                        style="-webkit-transform: rotateZ(45deg);float: none" onclick="addRow('Conditions')"><span
                        aria-hidden="true">&times;</span>
                </button>
            </td>
            <td>
                <button data-id="${cell.id}" id="w${cell.id}" type="button" class="close destroy" aria-label="Close"
                        style="float: none"><span
                        aria-hidden="true">&times;</span>
                </button>
            </td>

        </tr>
    </c:forEach>
</table>


<table id="DCM" border="1">
    <caption><h1>DCM</h1></caption>
    <th>key</th>
    <th>source</th>
    <th>sampling period</th>
    <th></th>
    <th align="center">`
    </th>
    <c:forEach items="${study.dcm}" var="cell">

        <tr>
            <td align="left">
                <select name="keys" class="keys">
                    <c:forEach var="item" items="${enabledKeys}">
                        <option value="${item.keyValue}" ${item.keyValue == cell.key ? 'selected="selected"' : ''}>${item.keyValue}</option>
                    </c:forEach>
                </select>
            </td>

            <td align="left"><select name="sources" class="sources">
                <c:forEach var="item" items="${enabledSources}">
                    <option value="${item.source}" ${item.source == cell.source ? 'selected="selected"' : ''}>${item.source}</option>
                </c:forEach>
            </select>

            </td>
            <td align="left"><select name="sampling-periods" class="samplings">
                <c:forEach var="item" items="${enabledSamplingPeriods}">
                    <option value="${item.samplingPeriod}" ${item.samplingPeriod == cell.samplingPeriod ? 'selected="selected"' : ''}>${item.samplingPeriod}</option>
                </c:forEach>
            </select>
            </td>
            <td>
                <button data-id="${cell.id}" id="${cell.id}" type="button" class="close add" aria-label="Close"
                        style="-webkit-transform: rotateZ(45deg);float: none" onclick="addRow('DCM')"><span
                        aria-hidden="true">&times;</span>
                </button>
            </td>
            <td>
                <button data-id="${cell.id}" id="${cell.id}" type="button" class="destroy close" aria-label="Close"
                        style="float: none"><span
                        aria-hidden="true">&times;</span>
                </button>
            </td>


        </tr>
    </c:forEach>
</table>
<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-2.1.4.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/tableEditor.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/studyWebService.js" />"></script>
</body>

</html>