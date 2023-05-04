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
    <form action="/loginProcess" method="post">
        <input type="text" name="M_ID" placeholder="ID"><br>
        <input type="password" name="M_PWD" placeholder="PASSWD"><br>
        <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
            <font color="red">
                <p>Your login attempt was not successful due to <br/>
                        ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
                <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
            </font>
        </c:if>
        <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
        <input type="submit" value="로그인">
        <input type="button" onclick="location.href='/member/signin'" value="회원가입" style="margin-left: 15px">
    </form>
</div>
<%--<div class="col-lg-12 text-center mt-3">--%>
<%--    <img alt="카카오로그인" src="${pageContext.request.contextPath}/resources/assets/img/kakao_login_medium_wide.png" onclick="loginWithKakao()">--%>
<%--</div>--%>
</body>
<%--<!-- 카카오 로그인 -->--%>
<%--<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>--%>
<%--<script type="text/javascript">--%>
<%--    $(document).ready(function(){--%>
<%--        Kakao.init('script앱키 입력');--%>
<%--        Kakao.isInitialized();--%>
<%--    });--%>

<%--    function loginWithKakao() {--%>
<%--        Kakao.Auth.authorize({--%>
<%--            redirectUri: 'http://localhost:8080/kakao_callback'--%>
<%--        }); // 등록한 리다이렉트uri 입력--%>
<%--    }--%>
<%--</script>--%>
</html>