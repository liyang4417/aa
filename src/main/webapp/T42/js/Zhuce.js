$(function () {
    $(".zhuce").click(function () {
        $.ajax({
            "url":"../zc",
            "type":"Post",
            "data":{
                username:$("#name").val(),
                password:$("#pass").val()
            },
            "dataType":"text",
            "success":Zhuce
        })
        function Zhuce(msg) {
            alert("true")
            if (msg=="true"){
                setTimeout(function () {
                    $('.modal' ).addClass('hidden');
                    $('.open').addClass('active');
                }, 800);
                setTimeout(function () {
                    window.location.href = "../T3/index.html";
                }, 1400);
            }
        }
    })

})