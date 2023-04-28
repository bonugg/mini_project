<%@ page import="com.mini_project.dto.LinkDTO" %>
<%@ page import="com.mini_project.DownloadImageFromUrlTest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
    <style>
        /* 검은색 테마 스타일 */
        body {
            background-color: #1c1c1c;
            color: #fff;
        }
        th, td {
            padding: 10px;
            background-color: #fff;
            border-radius: 0px;
            border-left: none;
            border-right: none;
            border-top: none;
            border-bottom:none;

        }
        th {
            background-color: #1c1c1c;
            text-align: center;
            column-span: 2;
        }
        table {
            border-collapse: collapse;
            margin-top: 100px;
            border-collapse: separate;
            border-spacing: 0px;
            border-radius: 10px;
        }
        input[type="text"], input[type="submit"] {
            background-color: #000;
            color: #fff;
            border: none;
            padding: 10px;
            font-size: 16px;
            font-family: sans-serif;
            border-radius: 20px;
            width: 20%;
            height: 5%;
        }
        input[type="text"], input[type="submit"] {
            margin-top: 50px;
        }
        button {
            cursor: pointer;
            border: none;
            color: #fff;
            background-color:#1c1c1c ;
            border-radius: 10px;
            font-size: 16px;
            font-family: sans-serif;
            padding: 10px;
        }
        a {
            color: #fff;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div style="text-align: center">
    <form action="javascript:myFunction()" method="post">
        <input type="text" id="LINK" placeholder="link">
        <input type="submit" value="ADD" style="height: 50px;width:100px;margin-left:20px; margin-top: 50px">
    </form>
</div>

<c:forEach var="item" items="${linkList}">
<table align="center" border="1" onClick="window.open('${item.LINK}')" style="cursor:pointer">
    <tr>
        <td rowspan="2" style="border-bottom-left-radius: 10px; border-top-left-radius:10px"><img src="${item.IMAGE}" width="100" height="100"/></td>
        <td style="border-radius: 0px; color: black; text-overflow: ellipsis; overflow:hidden; white-space: nowrap;width: 350px; max-width: 350px; font-size: 15px; text-align: center; font-weight: bold">${item.TITLE}</td>
        <td rowspan="2" style="border-bottom-right-radius: 10px; border-top-right-radius:10px"><button onclick="deleteLink('${item.LINK}')">DEL</button></td>
    </tr>
    <tr>
        <td style="color: black; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; width: 350px ;max-width: 350px; font-size: 5px; vertical-align: top">${item.CONTENTS}</td>
    </tr>
</table>
</c:forEach>
</body>
<script>
    function myFunction(){
        var LINK = document.getElementById("LINK").value;
        window.location.href = "/member/add?link="+LINK;
    }
</script>
<script>
    const deleteLink = (LINK) => {
        location.href = "/member/delete?link="+LINK;
    }
</script>
</html>
