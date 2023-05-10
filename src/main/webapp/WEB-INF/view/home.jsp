<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
    <style>
        body {
            font-size: 0px;
            background-color: #1c1c1c;
            color: #fff;
        }
        td {
            background-color: #fff;
            border-left: none;
            border-right: none;
            border-top: none;
            border-bottom:none;
        }
        table {
            margin-top: 50px;
            border-spacing: 0px;
            border-radius: 10px;
            box-shadow: 5px 5px 5px 5px black;
            width: 570px;
            table-layout: fixed;
        }
        input[type="text"] {
            background-color: #000;
            color: #fff;
            border: none;
            padding: 10px;
            font-size: 16px;
            font-family: sans-serif;
            border-radius: 20px;
            width: 20%;
            height: 30px;
        }
        input[type="submit"] {
            font-family: sans-serif;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 20px;
            height: 50px;
            width:100px;
            margin-left:20px;
            margin-top: 50px;
            cursor:pointer;
        }
        h3{
            text-align: right;
            margin-top: 1%;
            margin-right: 0.5%;
            font-family: sans-serif;
            color: white;
            font-size: 20px;
        }
        .img_td {
            border-bottom-left-radius: 10px;
            border-top-left-radius:10px
        }
        .img_list {
            border-top-left-radius:10px;
            border-bottom-left-radius:10px;
            width:100px;
            height:100px;
        }
        .title_td{
            text-overflow: ellipsis;
            overflow:hidden;
            white-space: nowrap;
            width: 350px;
            color: black;
            font-size: 15px;
            font-weight: bold;
            text-align: center;
            padding: 10px
        }
        .del_td{
            border-bottom-right-radius: 10px;
            border-top-right-radius:10px;
            padding: 10px;
            width: 50px;
        }
        .del_button {
            cursor: pointer;
            border: none;
            color: #fff;
            background-color:#1c1c1c ;
            border-radius: 10px;
            font-size: 16px;
            font-family: sans-serif;
            padding: 10px;
            box-shadow: 2px 2px gray;
        }
        .contents_td {
            color: black;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            width: 350px;
            font-size: 5px;
            vertical-align: top;
            padding: 10px
        }
        .user_btn{
            cursor: pointer;
            border: none;
            color: #fff;
            font-weight: bold;
            background-color:black;
            border-radius: 10px;
            font-size: 16px;
            font-family: sans-serif;
            padding: 10px;
            float: right;
            margin-right: 1%;
        }
    </style>
</head>
<body>
    <h3>${user.username}님 환영합니다</h3>

    <button type="button" onclick="location.href='update'" class="user_btn">수정하기</button>

    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button type="submit" class="user_btn">로그아웃</button>
    </form>

    <form action="/delete" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button type="submit" class="user_btn">탈퇴하기</button>
    </form>
    <h3>&nbsp;</h3>
    <div align="center">
        <form action="/add" method="post">
            <input type="text" name="LINK" placeholder="link">
            <input type="hidden" name="EMAIL" value="${user.email}" >
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" value="ADD">
        </form>
    </div>

    <c:forEach var="item" items="${linkList}">
        <table align="center" border="1" onClick="window.open('${item.LINK}')" style="cursor:pointer;">
            <tr>
                <td rowspan="2" class="img_td"><img src="${item.IMAGE}" class="img_list"/></td>
                <td class="title_td">${item.TITLE}</td>
                <td rowspan="2" class="del_td"><button onclick="deleteID('${item.LID}')" class="del_button">DEL</button></td>
            </tr>
            <tr>
                <td class="contents_td">${item.CONTENTS}</td>
            </tr>
        </table>
    </c:forEach>

</body>
<script>
    const deleteID = (LID) => {
        console.log(LID)
        location.href = "/delete_link?LID="+LID;
    }
</script>
</html>