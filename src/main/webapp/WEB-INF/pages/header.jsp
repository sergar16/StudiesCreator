<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid">
    <nav class="navbar navbar-default"
         style="background-color: #ededed;border-radius: 10px;box-shadow: 0 0 5px rgba(0,0,0,.2);height: 60px;">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->


            <div class="navbar-header">

                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"> </span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <img style="position: relative; top: 9px" src='<c:url value="/resources/img/logo-logitech.png" />'/>
            </div>
            <div class="navbar-header">

                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <a class="navbar-brand" href="#">Studies Creator</a></button>
            </div>
            <div class="navbar-header">

                <a type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <a class="navbar-brand" href="<c:url value='/user/studies'/>" >Studies List</a></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">


                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false">Admin Operations<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">

                                <li><a href='<c:url value="/admin/edit/dcm" />'>Edit Available DCM Options</a></li>
                                <li class="divider"></li>
                                <li><a href='<c:url value="/admin/edit/conditions" />'>Edit Available Conditions
                                    Options</a></li>
                            </ul>
                        </li>
                    </ul>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-expanded="false"> ${pageContext.request.userPrincipal.name} <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li>
                                <c:url value="/j_spring_security_logout" var="logoutUrl"/>
                                <c:if test="${pageContext.request.userPrincipal.name != null}">

                                    <a href="javascript:formSubmit()"> Logout</a>

                                </c:if>
                                <form action="${logoutUrl}" method="post" id="logoutForm">
                                    <input type="hidden"
                                           name="${_csrf.parameterName}"
                                           value="${_csrf.token}"/>
                                </form>
                            </li>

                        </ul>
                    </li>

                </ul>

            </div>
            <!-- /.navbar-collapse -->

        </div>
        <!-- /.container-fluid -->
    </nav>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>
</div>



