<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign Up</title>
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
<div style="text-align: center; margin-top: 8%">
    <form action="/signup" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <div>
            <input type="text" name="name" placeholder="Name"/>
        </div>
        <div>
            <input type="text" name="username" placeholder="*Username"/>
        </div>
        <div>
            <input type="text" name="email" placeholder="*Email"/>
        </div>
        <div>
            <input type="password" name="password" placeholder="Password"/>
        </div>
        <div>
            <input type="text" name="address" placeholder="Address"/>
        </div>
        <div>
            <input type="text" name="phone" placeholder="Phone"/>
        </div>
        <div>
            <input type="text" name="website" placeholder="Website"/>
        </div>
        <div>
            <input type="text" name="company" placeholder="Company"/>
        </div>

        <button type="submit">회원가입</button>
        <button type="button" onclick="location.href='../..'" style="margin-left: 10px">취소</button>
    </form>
</div>
</body>
</html>