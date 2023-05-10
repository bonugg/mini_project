<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modify Information</title>
    <style>
        .div_inner {
            width: 320px;
            height: 85px;
            margin: auto;
        }
        h6{
            font-size: 1px;
            text-align: left;
            margin-left: 20px;
        }
        body {
            font-size: 0px;
            background-color: #1c1c1c;
            color: #fff;
        }
        input[type="text"], input[type="password"] {
            background-color: #000;
            color: #fff;
            border: none;
            padding: 10px;
            font-family: sans-serif;
            border-radius: 20px;
            width: 280px;
            height: 27px;
        }
        button[type="submit"] {
            font-family: sans-serif;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 20px;
            height: 45px;
            width: 145px;
            cursor:pointer;
        }
    </style>
</head>
<body>
<div style="text-align: center; margin-top: 8%">
    <form action="/update" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <div class="div_inner">
            <h6>이름</h6>
            <input type="text" name="name" value="${user.name}"/>
        </div>
        <div class="div_inner" style="margin-bottom: 15px">
            <h6>닉네임</h6>
            <input type="text" name="username" value="${user.username}"/>
            <h6>2~6글자 사이 특수문자 불가능</h6>
        </div>
        <div class="div_inner" style="margin-bottom: 15px">
            <h6>비밀번호</h6>
            <input type="password" name="password" placeholder="비밀번호"/>
            <h6>8~13글자 사이 특수문자 포함</h6>
        </div>
        <div class="div_inner">
            <h6>주소</h6>
            <input type="text" name="address" value="${user.address}"/>
        </div>
        <div class="div_inner">
            <h6>번호</h6>
            <input type="text" name="phone" value="${user.phone}"/>
        </div>
        <div class="div_inner" style="margin-top: 15px">
        <button type="submit">저장하기</button>
        </div>
    </form>
</div>
</body>
</html>