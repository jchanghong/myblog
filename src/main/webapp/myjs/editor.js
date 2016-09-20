$(document).ready(function () {

    $("button#submit1").click(function (e) {

// iii2();
        // var title = $("input#title").val();
        // var data = UE.getEditor('editor').getContent();
        // $.ajax({
        //     url: "http://localhost:8080/myblog/blog/new",
        //     type: "POST",
        //     success: function (data) {
        //         // Success message
        //         alert("我会尽快联系22222你！！！");
        //     },
        //     error: function (data, status) {


        //         alert("我会尽快联系你！！！" + data["title"] + status["code"]);
        //     },
        // });
    });
});
function initblog() {

    var title = $("input#title").val();
    var data = UE.getEditor('editor').getContent();
    var blog= {
            id: 0,
            complete: 1,
            createtime: 1111111,
            data: data,
            image: "1",
            title: title,
            updatetime: 44444444
        };
    $.post("http://localhost:8080/myblog/blog/new",
    JSON.stringify(blog)
       ,
        function (data, status) {
            alert("Data: " + data + "\nStatus: " + status);
        });
}

function iii2()
{
     var title = $("input#title").val();
    var data = UE.getEditor('editor').getContent();
    var blog= {
            id: 0,
            complete: 1,
            createtime: 1111111,
            data: data,
            image: "1",
            title: title,
            updatetime: 44444444
        };
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/myblog/blog/new",
        data: JSON.stringify(blog),
        Content-Type :"application/json; charset=utf-8",
        success: function (response) {
            
        }
    });
}
function on11111()
{
     var title = $("input#title").val();
    var data = UE.getEditor('editor').getContent();
    var blog= {
            id: 0,
            complete: 1,
            createtime: 1111111,
            data: data,
            image: "1",
            title: title,
            updatetime: 44444444
        };
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/myblog/blog/new",
            data: blog,
            Accept:"application/json",
            contentType:"application/json; charset=utf-8",
            dataType: "dataType",
            success: function (response) {
                alert("!!!!");
            }
        });

}