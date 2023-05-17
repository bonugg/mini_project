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