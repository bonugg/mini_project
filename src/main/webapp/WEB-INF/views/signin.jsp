<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
    <style>
        body {
            background-color: #1c1c1c;
            color: #fff;
        }
        input[type="text"] {
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
    <form action="/member/signin" method="post">
        <input type="text" name="M_ID" placeholder="ID"><br>
        <input type="text" name="M_PWD" placeholder="PASSWD"><br>
        <input type="submit" value="회원가입">
        <input type="button" onclick="location.href='../..'" value="취소" style="margin-left: 15px">
    </form>
</div>
<table align="center" style="margin-top: 10%">
    <tr>
        <td>
            <a href="/member/list" style="text-align:center">링크추가</a>
        </td>
    </tr>
</table>

</body>
</html>