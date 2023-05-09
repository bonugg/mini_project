<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <style>
        body {
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
            width: 15%;
            height: 5%;
            margin-bottom: 30px;
        }
        button[type="submit"], button[type="button"] {
            font-family: sans-serif;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 20px;
            height: 40px;
            width: 7.7%;
            cursor:pointer;
        }
    </style>
</head>
<body>
<div style="text-align: center; margin-top: 15%">
    <form action="/auth" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            <div>
                <input type="text" name="id" placeholder="아이디"/>
            </div>
            <div>
                <input type="password" name="password" placeholder="비밀번호"/>
            </div>

        <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
            <font color="red">
                <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
                <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
            </font>
        </c:if>

            <button type="submit">로그인</button>
            <button type="button" onclick="location.href='signup'" style="margin-left: 10px">회원가입</button>
    </form>
</div>
</body>
</html>