<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign Up</title>
    <style>
        .div_inner {
            width : 330px;
            height : 515px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
        }
        .div_outter {
            width :400px;
            height : 600px;
            background-color: #1c1c1c;
            box-shadow: 1px 1px 5px 2px black;
            border-radius: 15px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        h6{
            font-size: 1px;
            text-align: left;
            margin-left: 20px;
        }
        body {
            background-color: #1c1c1c;
            color: #fff;
            font-size: 0px;
        }
        input[type="text"], input[type="password"] {
            background-color: #000;
            color: #fff;
            border: none;
            padding: 10px;
            font-family: sans-serif;
            border-radius: 10px;
            width: 280px;
            height: 25px;
            margin-bottom: 20px;
        }
        button[type="button"] ,button[type="submit"]{
            font-family: sans-serif;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 10px;
            height: 45px;
            width: 145px;
            cursor:pointer;
            margin-left: 10px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="div_outter">
    <form action="/update" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="div_inner">
            <h6>이름</h6>
            <input type="text" name="name" value="${user.name}"/>

            <h6>닉네임</h6>
            <input type="text" name="username" value="${user.username}" style="margin-bottom: 0px"/>
            <h6 style="margin-bottom: 20px">2~6글자 사이 특수문자 불가능</h6>

            <h6>비밀번호</h6>
            <input type="password" name="password" placeholder="비밀번호" style="margin-bottom: 0px"/>
            <h6 style="margin-bottom: 20px">8~13글자 사이 특수문자 포함</h6>

            <h6>주소</h6>
            <input type="text" name="address" value="${user.address}"/>

            <h6>번호</h6>
            <input type="text" name="phone" value="${user.phone}"/>

            <button type="submit">저장하기</button>
            <button type="button" onclick="location.href='../..'">취소</button>
        </div>
    </form>
</div>
</body>
<script>
    function buttonable()  {
        const button = document.getElementById('signin');
        button.disabled = false;
    }
</script>
</html>