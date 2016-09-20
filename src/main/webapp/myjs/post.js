$(document).ready(function () {
    var id = sessionStorage.getItem("id");
    $.get("http://localhost:8080/myblog/blog/show/" + id,
        function (data, status) {
            $("header.intro-header").css("background-image", data["image"]);
            $("div.post-heading").append(' <h1 id="title">' + data["title"] + '</h1>');
            $("div.post-heading").append(' <h2 id="subtitle">' + data["title"] + '</h2>');
            $("div#data").append(data["data"]);
        }
    );
});

