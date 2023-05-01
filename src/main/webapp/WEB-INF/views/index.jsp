<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>링크트리</title>
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
        input[type="submit"], input[type="button"] {
            font-family: sans-serif;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 20px;
            height: 5%;
            width: 7%;
            cursor:pointer;
        }
    </style>
</head>
<body>
<div style="text-align: center; margin-top: 15%">
    <form action="/member/login" method="post">
        <input type="text" name="M_ID" placeholder="ID"><br>
        <input type="password" name="M_PWD" placeholder="PASSWD"><br>
        <input type="submit" value="로그인">
        <input type="button" onclick="location.href='/member/signin'" value="회원가입" style="margin-left: 15px">
    </form>
</div>
</body>
</html>