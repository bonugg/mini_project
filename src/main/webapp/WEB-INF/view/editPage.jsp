<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modify Information</title>
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
<div style="text-align: center; margin-top: 3%">
    <form action="/update" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <p>
            Name<br><br>
            <input type="text" name="name" value="${user.name}"/>
        </p>
        <p>
            Username<br><br>
            <input type="text" name="username" value="${user.username}"/>
        </p>
        <p>
            Email<br><br>
            <input type="text" name="email" value="${user.email}"/>
        </p>
        <p>
            Password<br><br>
            <input type="password" name="password" placeholder="Password를 입력해주세요"/>
        </p>
        <p>
            Address<br><br>
            <input type="text" name="address" value="${user.address}"/>
        </p>
        <p>
            Phone<br><br>
            <input type="text" name="phone" value="${user.phone}"/>
        </p>

        <button type="submit">저장하기</button>
    </form>
</div>
</body>
</html>