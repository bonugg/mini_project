<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
    <h2>${user.username}님의 회원 정보</h2>

    <p>name: ${user.id}</p>
    <p>name: ${user.name}</p>
    <p>username: ${user.username}</p>
    <p>email: ${user.email}</p>
    <p>password: ${user.password}</p>
    <p>address: ${user.address}</p>
    <p>phone: ${user.phone}</p>
    <p>website: ${user.website}</p>
    <p>company: ${user.company}</p>

    <div align="center" style="margin-left: 5%">
        <form action="/add" method="post">
            <input type="text" name="LINK" placeholder="link">
            <input type="hidden" name="ID" value="${user.id}" >
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



    <button type="button" onclick="location.href='update'">수정하기</button>

    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button type="submit">로그아웃</button>
    </form>

    <form action="/delete" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button type="submit">탈퇴하기</button>
    </form>
</body>
<script>
    const deleteID = (LID) => {
        console.log(LID)
        location.href = "/delete_link?LID="+LID;
    }
</script>
</html>