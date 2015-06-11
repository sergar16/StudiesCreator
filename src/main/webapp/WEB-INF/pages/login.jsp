<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
</head>
<body onload='document.loginForm.username.focus();'>


<div id="login-box">



    <form class="form-signin" name="loginform" action="<c:url value='j_spring_security_check' />" method="POST" autocomplete="off"
          onsubmit="return Login(0)">
        <input type="hidden" name="tz_offset">

        <p align="center"><img class="img-responsive" src="<c:url value="/resources/img/logo-logitech.png" />" alt="Logitech Logo"></p><br>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
        <p align="left"><label class="control-label" id="username" style="display:none;">&nbsp;
            username</label></p>

        <p align="center"><input type="text" class="form-control" placeholder="Windows username" name="username"
                                 size="25" maxlength="30"></p>


        <p align="left"><label class="control-label" id="password"  style="display:none;">&nbsp;
            password</label></p>

        <p align="center"><input type="password"  class="form-control" placeholder="Windows password" name="password"
                                 size="25" maxlength="30"></p>


        <input type="hidden" name="realm" value="Logitech">


        <p align="center"><input class="btn btn-custom" type="submit" value="Sign In" name="btnSubmit"></p>

        <p style="text-align:justify; margin-top: 18px;" align="center" class="list-group-item"><font size="2"
                                                                                                      face="sans-serif">To
            protect your account from unauthorized access, your session will end after a period of inactivity. If your
            session ends, please close your browser and open a new session.</font></p>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

    </form>
</div>

</body>
</html>