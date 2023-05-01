<%@ page import="com.mini_project.dto.LinkTable" %>
<%@ page import="com.mini_project.DownloadImageFromUrlTest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
    <style>
        body {
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
            height: 5%;
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
            max-width: 350px;
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
            max-width: 350px;
            font-size: 5px;
            vertical-align: top;
            padding: 10px
        }
    </style>
</head>
<body>
<div style="text-align: center">
    <form action="/member/add" method="post">
        <input type="text" name="LINK" placeholder="link">
        <input type="submit" value="ADD">
    </form>
</div>

<c:forEach var="item" items="${linkList}">
<table align="center" border="1" onClick="window.open('${item.LINK}')" style="cursor:pointer;">
    <tr>
        <td rowspan="2" class="img_td"><img src="${item.IMAGE}" class="img_list"/></td>
        <td class="title_td">${item.TITLE}</td>
        <td rowspan="2" class="del_td"><button onclick="deleteID('${item.ID}')" class="del_button">DEL</button></td>
    </tr>
    <tr>
        <td class="contents_td">${item.CONTENTS}</td>
    </tr>
</table>
</c:forEach>
</body>
<script>
    const deleteID = (ID) => {
        console.log(ID)
        location.href = "/member/delete?ID="+ID;
    }
</script>
</html>
