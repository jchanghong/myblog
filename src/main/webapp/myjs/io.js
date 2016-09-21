
function postblog(title, data) {
    var blog = {
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
        cache: false,
        url: "http://localhost:8080/myblog/blog/new",
        data: JSON.stringify(blog),
        Accept: "application/json",
        contentType: "application/json; charset=utf-8",
        // dataType: "application/json; charset=utf-8",
        success: function (result,status,xhr) {
            // alert("成功！！！"+result["id"]+status);
            sessionStorage.setItem("id",result["id"]);
              location.assign("http://localhost:8080/myblog/post.html");
        },
        error: function (xhr, status, error) {
            alert("失败！！！"+status+error);
        }
    });

}
function postuser(name, password, email, tel) {
    var blog = {
        id: 0,
        email: email,
        imageurl: "0",
        logintime: 1111,
        name: name,
        password: password,
        tel: tel
    };
    $.ajax({
        type: "POST",
        cache: false,
        url: "http://localhost:8080/myblog/user/new",
        data: JSON.stringify(blog),
        Accept: "application/json",
        contentType: "application/json; charset=utf-8",
        dataType: "application/json; charset=utf-8",
        success: function (response) {
            alert("成功！！！");
        }
    });

}


