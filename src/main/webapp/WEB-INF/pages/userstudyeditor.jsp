<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
    <script type="text/javascript" src="<c:url value="/resources/js/tableeditor.js" />"></script>
</head>
<body>
<h1>Study Editor</h1>
<table id="Conditions" align="left" border="1" style="margin-right: 30px">
    <caption><h1>Conditions</h1></caption>
    <th>name</th>
    <th> value</th>

    <c:forEach items="${study.conditions}" var="cell">
        <tr>
            <td align="left">
                <select name="name">
                    <c:forEach var="item" items="${names}">
                        <option value="${item.name}" ${item.name == cell.name ? 'selected="selected"' : ''}>${item.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td align="left"><select name="value">
                <c:forEach var="item" items="${values}">
                    <option value="${item.value}" ${item.value == cell.value ? 'selected="selected"' : ''}>${item.value}</option>
                </c:forEach>
            </select>
            </td>


        </tr>
    </c:forEach>
</table>

<input type="button" value="delete" onclick="deleteRow('Conditions')" style="width:100px;height:100px">


<input type="button" value="add" onclick="addRow('Conditions')" style="width:100px;height:100px">


<table id="DCM" border="1">
    <caption><h1>DCM</h1></caption>
    <th>key</th>
    <th>source</th>
    <th>sampling period</th>

    <c:forEach items="${study.dcm}" var="cell">

        <tr>
            <td align="left">
                <select name="keys">
                    <c:forEach var="item" items="${enabledKeys}">
                        <option value="${item.keyValue}" ${item.keyValue == cell.key ? 'selected="selected"' : ''}>${item.keyValue}</option>
                    </c:forEach>
                </select>
            </td>

            <td align="left"><select name="sources">
                <c:forEach var="item" items="${enabledSources}">
                    <option value="${item.source}" ${item.source == cell.source ? 'selected="selected"' : ''}>${item.source}</option>
                </c:forEach>
            </select>

            </td>
            <td align="left"><select name="sampling-periods">
                <c:forEach var="item" items="${enabledSamplingPeriods}">
                    <option value="${item.samplingPeriod}" ${item.samplingPeriod == cell.samplingPeriod ? 'selected="selected"' : ''}>${item.samplingPeriod}</option>
                </c:forEach>
            </select>
            </td>


        </tr>
    </c:forEach>
</table>

<input type="button" value="delete" onclick="deleteRow('DCM')" style="width:100px;height:100px">


<input type="button" value="add" onclick="addRow('DCM')" style="width:100px;height:100px">
</body>
</html>