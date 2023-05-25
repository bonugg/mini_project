let subToggle2 = false;
$(".menu").click((event) => {
    event.stopPropagation(); // 이벤트 전파 중지
    if (subToggle2) {
        $(".sub").slideUp(300);
    } else {
        $(".sub").slideDown(300);
    }
    subToggle2 = !subToggle2;
});

$(document).click(() => {
    $(".sub").slideUp(300);
    subToggle2 = false;
});