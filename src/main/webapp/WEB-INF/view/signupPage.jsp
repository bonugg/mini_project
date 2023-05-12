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
            height : 575px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
        }
        .div_outter {
            width :400px;
            height : 650px;
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
        button[type="button"] {
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
        button[type="button"]:hover{
            background-color: white;
            color: black;
        }
        button[disabled='disabled']{
            font-family: sans-serif;
            background-color: #000;
            color: #1c1c1c;
            border: none;
            border-radius: 10px;
            height: 45px;
            width: 135px;
            cursor:default;
            margin-top: 10px;
            pointer-events: none;
        }
    </style>
</head>
<body>
<div class="div_outter">


        <div class="div_inner">
            <form action="/signup" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="text" name="id" id="id" placeholder="아이디" style="width: 195px; margin-bottom: 0px">
            <button type="button" onclick="idCheck()" style="width: 80px; margin-left: 5px;">체크</button>
            <h6 style="margin-bottom: 20px">하나 이상의 영문, 숫자를 포함하는 6~12글자</h6>

            <input type="text" name="email" id="email" placeholder="이메일">

            <input type="password" name="password" id="password" placeholder="비밀번호" style="margin-bottom: 0px"/>
            <h6 style="margin-bottom: 20px">하나 이상의 영문, 숫자, 특수문자를 포함하는 8~20글자</h6>

            <input type="text" name="name" id="name" placeholder="이름"/>

            <input type="text" name="username" id="username" placeholder="닉네임" style="margin-bottom: 0px"/>
            <h6 style="margin-bottom: 20px">2~6글자 사이 특수문자 불가능</h6>

            <input type="text" name="address" placeholder="주소"/>

            <input type="text" name="phone" id="phone" placeholder="번호"/>

            <input type="hidden" name="provider" value="linktree"/>

            </form>
            <button type="button" id="submit" disabled="disabled" onclick="registerCheck()" style="margin-right: 10px">회원가입</button>
            <button type="button" onclick="location.href='../..'">취소</button>
    </div>
</div>
</body>
<script type="text/javascript">
    /* 회원가입 유효성 체크 */
    function registerCheck() {
        var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        var regPassword = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;
        var regName = /^[가-힣a-zA-Z]{2,15}$/;
        var regUserName = /^[가-힣a-zA-Z0-9]{2,6}$/;
        var regPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;

        if($.trim($('#email').val()) == '') {
            alert("이메일을 입력해주세요.");
        }else if(!(regEmail.test($.trim($('#email').val())))){
            alert("올바른 이메일을 입력하세요.");
            $.trim($('#email').val()).focus();
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

        if($.trim($('#name').val()) == '') {
            alert("이름을 입력해주세요.");
        }else if(!(regName.test($.trim($('#name').val())))){
            alert("올바른 이름을 입력하세요.");
            $.trim($('#name').val()).focus();
            return false;
        }

        if($.trim($('#username').val()) == '') {
            alert("닉네임을 입력해주세요.");
            return false;
        }else if(!(regUserName.test($.trim($('#username').val())))){
            alert("닉네임 양식을 확인해주세요.");
            $.trim($('#name').username()).focus();
            return false;
        }

        if(!(regPhone.test($.trim($('#phone').val())))){
            alert("올바른 번호를 입력하세요.");
            $.trim($('#phone').username()).focus();
            return false;
        }

        if(confirm("회원가입을 하시겠습니까?")){
            alert("회원가입이 완료되었습니다.");
            $("form").submit();
        }
    }

    /* 아이디 중복 체크 : ajax 비동기처리 */
    function idCheck() {
        var id = $('#id').val();
        var regId = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{6,12}$/;
        if(id == "") {
            alert("아이디에는 공백이 들어갈 수 없습니다.");
        }else if (!(regId.test(id))) {
            alert("아이디 양식을 확인해주세요.");
            $.trim($('#id').val()).focus();
            return false;
        }
        else {
            if(id.trim().length != 0) {
                $.ajax({
                    async : true,
                    type : 'POST',
                    data: id,
                    url: "/idCheck",
                    dataType: "json",
                    contentType: "application/json; charset=UTF-8",
                    success: function(count) {
                        if(count > 0) {
                            alert("해당 아이디 존재");
                            $("#submit").attr("disabled", "disabled");
                            window.location.reload();
                        } else {
                            alert("사용가능 아이디");
                            $("#submit").removeAttr("disabled");
                        }
                    },
                    error: function(error) {
                        alert("아이디를 입력해주세요.");
                    }
                });
            } else {
                alert("아이디를 입력해주세요.");
            }
        }
    }
</script>
</html>