const deleteID = (LID) => {
    location.href = "/delete_link?LID=" + LID;
}
const myLinkAdd = (LINK, NO) => {
    location.href = "/myLinkAdd?LINK=" + LINK + "&no=" + NO;
}

const showUserList = (no) => {
    location.href = "/user_link?no=" + no;
}

const $autoComplete = document.querySelector(".autocomplete");

// 현재 가르키고 있는 검색어 순번
let nowIndex = 0;
$('#search').autocomplete({
    source: function (request, response) { //source: 입력시 보일 목록
        $.ajax({
            url: "/get/test"
            , type: "POST"
            , dataType: "JSON"
            , data: {value: request.term}	// 검색 키워드
            , success: function (data) { 	// 성공
                response(
                    $.map(data.resultList, function (item) {
                        return {
                            label: item.USERNAME //목록에 표시되는 값
                            , value: item.USERNAME //선택 시 input창에 표시되는 값
                            , idx: item.NO //index
                        };
                    })
                ); //response
            }
            , error: function () { //실패
                console.log("1")
                alert("오류가 발생했습니다.");
            }
        });
    }
    , focus: function (event, ui) { // 방향키로 자동완성단어 선택 가능하게 만들어줌
        return false;
    }
    , minLength: 1// 최소 글자수
    , autoFocus: true // true == 첫 번째 항목에 자동으로 초점이 맞춰짐
    , delay: 100	//autocomplete 딜레이 시간(ms)
    , select: function (evt, ui) {
        // 아이템 선택시 실행 ui.item 이 선택된 항목을 나타내는 객체, lavel/value/idx를 가짐
        console.log(ui.item.label);
        console.log(ui.item.idx);
    }
});