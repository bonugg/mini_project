<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <style>
        .div_inner {
            width: 320px;
            height: 50px;
            margin: auto;
            margin-bottom: 30px;
        }
        .div_outter {
            text-align: center;
            margin-top: 15%;
        }
        body {
            font-size:0px;
            background-color: #1c1c1c;
            color: #fff;
        }
        input[type="text"], input[type="password"] {
            background-color: #000;
            color: #fff;
            border: none;
            padding: 10px;
            font-size: 16px;
            font-family: sans-serif;
            border-radius: 20px;
            width: 280px;
            height: 27px;
        }
        button[type="submit"], button[type="button"] {
            font-family: sans-serif;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 20px;
            height: 40px;
            width: 145px;
            cursor:pointer;
        }
    </style>
</head>
<body>
<div class="div_outter">
    <form action="/auth" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            <div class="div_inner">
                <input type="text" name="email" placeholder="아이디"/>
            </div>
            <div class="div_inner" style="margin-bottom: 15px">
                <input type="password" name="password" placeholder="비밀번호"/>
            </div>

        <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
            <font color="red" style="font-size: 2px">
                <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
                <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
            </font>
        </c:if>

            <button type="submit" style="margin-top: 15px">로그인</button>
            <button type="button" onclick="location.href='signup'" style="margin-left: 10px">회원가입</button>
        <br><br>
        <a style="font-size: 15px" href="/oauth2/authorization/google" class="btn btn-success active" role="button">Google Login</a>
    </form>
</div>
</body>
</html>