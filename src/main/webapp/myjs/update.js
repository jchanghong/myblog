function initupdate() {
    var id = sessionStorage.getItem("id");
    if (typeof (id) == undefined) {
        id = 0;
        sessionStorage.setItem("id", id);
    }

    $.get("http://localhost:8080/myblog/blog/show/ordown/" + id,
        function (data, status) {
            //   alert(typeof UE.getEditor('editor');

            UE.getEditor('editor').setContent(data["data"], false);
            $("input#title").val(data["title"]);
        }
    );
    $("input#butsubmit").click(function (e) {
        //   alert(typeof UE.getEditor('editor');
        var title = $("input#title").val();
        var data = UE.getEditor('editor').getContent();
        var nohtml = UE.getEditor('editor').getContentTxt();

        postblogupdate(id, title, data, nohtml);
        // location.assign("http://localhost:8080/myblog/post.html");
    });

}
function postblogupdate(id, title, data, nohtml) {
    var blog = {
        id: id,
        complete: 1,
        createtime: 1111111,
        data: data,
        datanohtml: nohtml,
        image: "666",
        title: title,
        updatetime: 44444444
    };
    $.ajax({
        type: "POST",
        cache: false,
        url: "http://localhost:8080/myblog/blog/update",
        data: JSON.stringify(blog),
        Accept: "application/json",
        contentType: "application/json; charset=utf-8",
        // dataType: "application/json; charset=utf-8",
        success: function (result, status, xhr) {
            // alert("成功！！！"+result["id"]+status);
            // sessionStorage.setItem("id",result["id"]);
            location.assign("http://localhost:8080/myblog/post.html");
        },
        error: function (xhr, status, error) {
            alert("失败！！！" + status + error);
        }
    });

}