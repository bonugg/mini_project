let test = document.querySelector(".test");

let isOn = false;
const uno = $('#uno').val();
const no = $('#no').val();

$.ajax({
    type : 'POST',
    async: false,
    data: {
        no: no,
        uno: uno
    },
    url: '/likeshow',
    success: function(count) {
        if(count > 0) {
            console.log("on");
            isOn=true;
            test.classList.remove("likeoff_img");
            test.classList.add("likeon_img");

        } else {
            console.log("off");
            isOn=false;
            test.classList.remove("likeon_img");
            test.classList.add("likeoff_img");
        }
    }
});

test.onclick = function (){
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
                test.classList.remove("likeoff_img");
                test.classList.add("likeon_img");
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
                test.classList.remove("likeon_img");
                test.classList.add("likeoff_img");
            }
        });
    }

}

