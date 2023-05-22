let subToggle = false;
$(".menu").click((event) => {
    event.stopPropagation(); // 이벤트 전파 중지
    if (subToggle) {
        $(".sub").slideUp(300);
    } else {
        $(".sub").slideDown(300);
    }
    subToggle = !subToggle;
});

$(document).click(() => {
    $(".sub").slideUp(300);
    subToggle = false;
});