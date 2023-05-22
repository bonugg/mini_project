let like = document.querySelector(".like");
const uno = $('#uno').val();
const no = $('#no').val();
let isOn = false;

updateLikeCount();

function updateLikeCount() {
    $.ajax({
        type: 'POST',
        async: false,
        data: {
            no: no,
            uno: uno
        },
        url: '/likeshow',
        success: function (likecc) {
            $('#likeCount').text(likecc.likeCount);
            if (likecc.count > 0) {
                isOn = true;
                like.classList.remove("likeoff_img");
                like.classList.add("likeon_img");

            } else {
                isOn = false;
                like.classList.remove("likeon_img");
                like.classList.add("likeoff_img");
            }
        }
    });
}

like.onclick = function (){
    isOn = !isOn;
    if (isOn) {
        $.ajax({
            type: 'POST',
            url: '/userlike',
            data: {
                no: no,
                uno: uno
            },
            success: function() {
                updateLikeCount();
            }
        });
    } else {
        $.ajax({
            type: 'POST',
            url: '/userdislike',
            data: {
                no: no,
                uno: uno
            },
            success: function() {
                updateLikeCount();
            }
        });
    }

}

