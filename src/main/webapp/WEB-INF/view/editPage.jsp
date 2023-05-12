<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign Up</title>
    <style>
        .div_inner {
            width : 330px;
            height : 670px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
        }
        .div_outter {
            width :400px;
            height : 720px;
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
            margin-left: 35px;
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
            height: 45px;
            margin-bottom: 20px;
        }
        button[type="button"] ,button[type="submit"]{
            font-family: sans-serif;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 10px;
            height: 45px;
            width: 135px;
            cursor:pointer;
            margin-top: 10px;
        }
        button[type="submit"]:hover, button[type="button"]:hover{
            background-color: white;
            color: black;
        }
    </style>
</head>
<body>
<div class="div_outter">
    <div class="div_inner">
         <form action="/update" method="post">
             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
             <input type="hidden" name="no" value="${user.no}"/>
             <input type="hidden" name="provider" value="${user.provider}"/>
             <input type="hidden" name="role" value="${user.role}"/>

             <h6>아이디</h6>
             <input style="color:gray;" type="text" readonly name="id" value="${user.id}"/>

             <h6>이메일</h6>
             <input style="color:gray;" type="text" readonly name="email" value="${user.email}"/>

             <h6>이름</h6>
             <input style="color:gray;" type="text" readonly name="name" value="${user.name}"/>

             <h6>닉네임</h6>
             <input type="text" name="username" id="username" value="${user.username}" style="margin-bottom: 0px"/>
             <h6 style="margin-bottom: 20px">2~6글자 사이 특수문자 불가능</h6>

             <h6>비밀번호</h6>
             <input type="password" name="password" id="password" placeholder="비밀번호" style="margin-bottom: 0px"/>
             <h6 style="margin-bottom: 20px">하나 이상의 영문, 숫자, 특수문자를 포함하는 8~20글자</h6>

             <h6>주소</h6>
             <input type="text" name="address" value="${user.address}"/>

             <h6>번호</h6>
             <input type="text" name="phone" id="phone"value="${user.phone}"/>
         </form>
        <button type="button" id="submit" onclick="userModify()" style="margin-right: 10px">수정완료</button>
        <button type="button" onclick="location.href='../..'">취소</button>
    </div>

</div>
</body>
<script type="text/javascript">
    /* 회원가입 유효성 체크 */
    function userModify() {
        var regPassword = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;
        var regUserName = /^[가-힣a-zA-Z0-9]{2,6}$/;
        var regPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;

        if($.trim($('#username').val()) == '') {
            alert("닉네임을 입력해주세요.");
            return false;
        }else if(!(regUserName.test($.trim($('#username').val())))){
            alert("닉네임 양식을 확인해주세요.");
            $.trim($('#name').username()).focus();
            return false;
        }

        if($.trim($('#password').val()) == '') {
            alert("비밀번호를 입력해주세요.");
            return false;
        }else if(!(regPassword.test($.trim($('#password').val())))){
            alert("비밀번호 양식을 확인해주세요.");
            $.trim($('#password').val()).focus();
            return false;
        }

        if(!(regPhone.test($.trim($('#phone').val())))){
            alert("올바른 번호를 입력하세요.");
            $.trim($('#phone').username()).focus();
            return false;
        }

        if(confirm("회원정보를 수정하시겠습니까?")){
            alert("수정이 완료되었습니다.");
            $("form").submit();
        }
    }
</script>
</html>