<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign Up</title>
    <style>
        .div_inner {
            width: 280px;
            height: 85px;
            margin: auto;
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
            border-radius: 20px;
            width: 280px;
            height: 27px;
        }
        button[type="button"] {
            font-family: sans-serif;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 20px;
            height: 45px;
            width: 145px;
            cursor:pointer;
        }
        button[disabled='disabled']{
            font-family: sans-serif;
            background-color: #000;
            color: #1c1c1c;
            border: none;
            border-radius: 20px;
            height: 45px;
            width: 145px;
            cursor:default;
        }
    </style>
</head>
<body>
<div style="text-align: center; margin-top: 8%">
    <form action="/signup" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="div_inner">
            <input type="text" name="id" placeholder="아이디" style="width: 195px">
            <button type="button" onclick= "buttonable()" style="width: 60px; margin-left: 5px;">체크</button>
            <h6>5~10글자 사이 특수문자 불가능</h6>
        </div>
        <div class="div_inner">
            <input type="text" name="name" placeholder="이름"/>
        </div>
        <div class="div_inner">
            <input type="text" name="username" placeholder="닉네임"/>
            <h6>2~6글자 사이 특수문자 불가능</h6>
        </div>
        <div class="div_inner">
            <input type="text" name="email" placeholder="이메일"/>
        </div>
        <div class="div_inner">
            <input type="password" name="password" placeholder="비밀번호"/>
            <h6>8~13글자 사이 특수문자 포함</h6>
        </div>
        <div class="div_inner">
            <input type="text" name="address" placeholder="주소"/>
        </div>
        <div class="div_inner">
            <input type="text" name="phone" placeholder="번호"/>
        </div>

        <div class="div_inner" style="text-align: center; width: 313px">
        <button disabled="disabled" type="submit" id="signin" style="margin-left: 18px; border: none;border-radius: 20px;height: 45px;width: 145px;">회원가입</button>
        <button type="button" onclick="location.href='../..'" style="margin-left: 5px">취소</button>
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