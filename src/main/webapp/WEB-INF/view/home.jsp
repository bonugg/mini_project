<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <style>
        body {
            margin: 0;
            font-size: 0px;
            background-color: #1c1c1c;
            color: #fff;
        }

        td {
            background-color: #fff;
            border-left: none;
            border-right: none;
            border-top: none;
            border-bottom: none;
        }

        table {
            margin-top: 50px;
            border-spacing: 0px;
            border-radius: 10px;
            box-shadow: 1px 1px 5px 2px black;
            width: 570px;
            table-layout: fixed;
        }

        .input_link {
            background-color: #000;
            color: #fff;
            border: none;
            padding: 10px;
            font-size: 16px;
            font-family: sans-serif;
            border-radius: 10px;
            width: 20%;
            height: 45px;
        }

        span {
            font-family: sans-serif;
            color: white;
            font-size: 15px;
            margin-top: 11.5px;
        }

        .span_user {
            font-family: sans-serif;
            color: white;
            font-size: 15px;
            margin-top: 15px;
            margin-right: 10px;
            margin-left: auto;
        }

        .span_search {
            font-family: sans-serif;
            color: white;
            margin-top: 11px;
            margin-left: 30px;
        }

        .img_list {
            border-top-left-radius: 10px;
            border-bottom-left-radius: 10px;
            width: 100px;
            height: 100px;
        }

        .img_td {
            border-bottom-left-radius: 10px;
            border-top-left-radius: 10px
        }

        .title_td {
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
            width: 350px;
            color: black;
            font-size: 15px;
            font-weight: bold;
            text-align: center;
            padding: 10px
        }

        .del_td {
            border-bottom-right-radius: 10px;
            border-top-right-radius: 10px;
            padding: 10px;
            width: 50px;
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

        input[type="submit"] {
            font-family: sans-serif;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 10px;
            height: 45px;
            width: 100px;
            margin-left: 20px;
            cursor: pointer;
        }

        .del_button {
            cursor: pointer;
            border: none;
            color: #fff;
            background-color: #1c1c1c;
            border-radius: 10px;
            font-size: 16px;
            font-family: sans-serif;
            padding: 10px;
            box-shadow: 2px 2px gray;
        }

        .user_btn {
            cursor: pointer;
            border: none;
            color: #fff;
            background-color: black;
            border-radius: 5px;
            font-size: 5px;
            font-family: sans-serif;
            padding: 7px;

            margin-left: 5px;
        }

        input[type="submit"]:hover {
            background-color: white;
            color: black;
        }

        .del_button:hover {
            background-color: #3c3c3c;
        }

        .user_btn:hover {
            background-color: white;
            color: black;
        }

        .menu-right {
            margin-left: auto;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 7px;
            height: 50px;
        }

        nav ul {
            margin: 0;
            padding: 0;
            list-style: none;
            display: flex;
        }

        nav li {
            margin-right: 10px;
            margin-top: 10px;
            margin-left: 20px;
        }

        nav a {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            font-size: 20px;
            text-transform: uppercase;
            padding-right: 10px;
            padding-left: 10px;
        }

        nav a:hover {
            color: #ccc;
        }

        /* 검색창 스타일링 */
        .search-form {
            margin-left: auto;
            display: flex;
            align-items: center;
        }

        .search-input {
            font-family: sans-serif;
            background-color: #000;
            color: #fff;
            border: none;
            padding: 10px;
            font-size: 12px;
            font-family: sans-serif;
            border-radius: 10px;
            height: 30px;
            width: 250px;
        }

        .search-btn {
            cursor: pointer;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 10px;
            height: 30px;
            width: 45px;
            font-size: 15px;
            margin-left: 5px;
        }

        .search-btn:hover {
            background-color: white;
            color: black;
        }
    </style>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="/">LINK TREE</a></li>
            <span class="span_search">
                    <form class="search-form" action="/search" method="get">
                        <input class="search-input" type="text" name="USERNAME" placeholder="유저를 검색하세요">
                        <button class="search-btn" type="submit">S</button>
                    </form>
                </span>
            <span class="span_user">${user.username}님 환영합니다</span>
            <span>
                <c:if test="${user.name != null}">
                    <button type="button" onclick="location.href='update'" class="user_btn">정보수정</button>
                </c:if></span>
            <span><c:if test="${user.name != null}">
            <form action="/delete" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="user_btn">탈퇴하기</button>
            </form>
            </c:if> </span>
            <span><form action="/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit" class="user_btn">로그아웃</button>
        </form>
            </span>

        </ul>

    </nav>

</header>
<h3>&nbsp;</h3>
<div style="margin-top: 100px; text-align: center;">
    <form action="/add" method="post">
        <input type="text" name="LINK" placeholder="link" class="input_link">
        <input type="hidden" name="NO" value="${user.no}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="ADD">
    </form>
</div>

<c:forEach var="item" items="${linkList}">
    <table align="center" border="1" onClick="window.open('${item.LINK}')" style="cursor:pointer;">
        <tr>
            <td rowspan="2" class="img_td"><img src="${item.IMAGE}" class="img_list"/></td>
            <td class="title_td">${item.TITLE}</td>
            <td rowspan="2" class="del_td">
                <button onclick="deleteID('${item.LID}')" class="del_button">DEL</button>
            </td>
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
        location.href = "/delete_link?LID=" + LID;
    }
</script>
</html>