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
    const id = $('#id').val();
    const regId = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{6,12}$/;
    if(id == "") {
        alert("아이디에는 공백이 들어갈 수 없습니다.");
    }else if (!(regId.test(id))) {
        alert("아이디 양식을 확인해주세요.");
        $('#id').val().focus();
        return false;
    }
    else {
        if(id.trim().length != 0) {
            $.ajax({
                    type : 'POST',
                data: id,
                url: '/idCheck',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                success: function(count) {
                    if(count > 0) {
                        console.log(count);
                        alert("해당 아이디 존재");
                        $("#submit").attr("disabled", "disabled");
                        window.location.reload();
                    } else {
                        console.log(count);
                        alert("사용가능 아이디");
                        $("#submit").removeAttr("disabled");
                    }
                },
                error: function(error) {
                    console.log("1")
                    alert("아이디를 입력해주세요.");
                }
            });
        } else {
            console.log("2")
            alert("아이디를 입력해주세요.");
        }
    }
}