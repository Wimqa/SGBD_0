<%--
  Created by IntelliJ IDEA.
  User: Code
  Date: 10-08-20
  Time: 06:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8" />
    <title>SignIn</title>
    <link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/assets/css/signIn.css' />
</head>

<body>

    <div class="maDiv">
            <span id="mainTitle"> School UX </span>
    </div>

    <div class="maDiv">
            <span class="ask">Veuillez vous authentifier : </span>

            <form method="post" action="${pageContext.request.contextPath}/signin">
                <label for='idUsernameForm'>Username :</label>
                <input id='idUsernameForm' name='usernameFromForm' type='text' value='${sessionScope.usernameSessionKey}' autofocus /> <br/>
                <label for='idPwdForm'>Password :</label>
                <input  id='idPwdForm' name='passwordFromForm' type='password' value='${sessionScope.passwordSessionKey}' /> <br/>
                <br/>
                <input name='btnSignIn' type='submit' value="Se connecter"/> <br/>
            </form>

    </div>



    <div class="maDiv">

            <span class="ask">Pas encore inscrit ? </span>

                <a id="monAncre" href="${pageContext.request.contextPath}/signup">
                    <button>S'inscrire</button>
                </a>

    </div>

</body>
</html>





<%--<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%> --%>