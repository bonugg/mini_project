<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <style>
        .div_inner {
            width : 320px;
            height : 580px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
        }
        .div_outter {
            width :400px;
            height : 630px;
            background-color: #1c1c1c;
            box-shadow: 1px 1px 5px 2px black;
            border-radius: 15px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        body {
            font-size:0;
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
            border-radius: 10px;
            width: 237px;
            height: 40px;
            margin-top: 3.7%;
        }
        button[type="submit"], button[type="button"] {
            font-family: sans-serif;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 10px;
            height: 40px;
            width: 115px;
            cursor:pointer;
            margin-top: 1.5%;
        }
        button[type="submit"]:hover, button[type="button"]:hover{
            background-color: white;
            color: black;
        }
    </style>
</head>
<body>
<div class="div_outter">
    <form action="/auth" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div class="div_inner">
            <img src="https://i.ibb.co/QKJH7jN/Link-Tree.png
            " style="width: 150px; height: 150px; border-radius: 100px; margin-bottom: 30px;">
            <input type="text" name="id" placeholder="아이디"/>

            <input type="password" name="password" placeholder="비밀번호" style="margin-bottom: 9px"/>

            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                <font color="red" style="font-size: 2px">
                    <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
                    <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
                </font>
            </c:if>

            <button type="submit" style="margin-top: 9px">로그인</button>
            <button type="button" onclick="location.href='signup'" style="margin-left: 10px">회원가입</button>

            <h3 style="font-size: 15px; margin-top: 20px;">OR</h3>

            <a style="font-size: 15px" href="/oauth2/authorization/google" class="btn btn-success active" role="button">
                <img src="https://ifh.cc/g/R1T8tk.png" alt="구글 로그인 이미지" width="245" height="55px" style="border-radius: 20px;"></a>
            <a style="font-size: 15px" href="/oauth2/authorization/kakao" class="btn btn-success active" role="button">
                <img src="https://i.ibb.co/gj6bLHT/kakao-login-medium-narrow-1.png" alt="kakao-login-medium-narrow-1" alt="카카오 로그인 이미지" width="238" height="48px"
                     style="border-radius: 5px; margin-bottom: 3px"></a>
            <a style="font-size: 15px" href="/oauth2/authorization/naver" class="btn btn-success active" role="button">
                <img src="https://i.ibb.co/PYLVg85/btn-G-official.png" alt="kakao-login-medium-narrow-1" alt="네이버 로그인 이미지" width="238" height="48" style="border-radius: 5px;"></a>
        </div>
    </form>

</div>
</body>
</html>