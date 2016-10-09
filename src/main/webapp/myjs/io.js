
function postblog(title, data,nohtml,types) {
    var blog = {
        id: 0,
        complete: 1,
        createtime: 1111111,
        data: data,
        datanohtml: nohtml,
        image: "1",
        title: title,
        types: types,
        updatetime: 44444444
    };
    $.ajax({
        type: "POST",
        cache: false,
        url: "http://ljx520.cn/blog/new",
        data: JSON.stringify(blog),
        Accept: "application/json",
        contentType: "application/json; charset=utf-8",
        // dataType: "application/json; charset=utf-8",
        success: function (result,status,xhr) {
            // alert("成功！！！"+result["id"]+status);
            sessionStorage.setItem("id",result["id"]);
              location.assign("http://ljx520.cn/post.html");
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
        url: "http://ljx520.cn/user/new",
        data: JSON.stringify(blog),
        Accept: "application/json",
        contentType: "application/json; charset=utf-8",
        dataType: "application/json; charset=utf-8",
        success: function (response) {
            alert("成功！！！");
        }
    });

}


