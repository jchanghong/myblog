$(document).ready(function () {
    var id = sessionStorage.getItem("id");
    if(typeof(id)==undefined)
    {
        id=0;
        sessionStorage.setItem("id",id);
    }
    $.get("http://60.205.188.25/blog/show/ordown/" + id,
        function (data, status) {
            $("header.intro-header").css("background-image", data["image"]);
            $("div.post-heading").append(' <h1 id="title">' + data["title"] + '</h1>');
            $("div.post-heading").append(' <h2 id="subtitle">' + data["title"] + '</h2>');
            $("div#data").append(data["data"]);
        }
    );
    $("a#myup").click(function (e) { 
        //  alert("up");
        upmy();
    });
    $("a#mydown").click(function (e) { 
        // alert("down");
        mydown();
    });
});

function upmy()
{
    var sum=sessionStorage.getItem("sum");
    var isss=sessionStorage.getItem("id");
    if(isss-1>-1)
    {

  
      sessionStorage.setItem("id",--isss);
    $.get("http://60.205.188.25/blog/show/orup/" + isss,
        function (data, status) {
            $("header.intro-header").css("background-image", data["image"]);
            $("div.post-heading").append(' <h1 id="title">' + data["title"] + '</h1>');
            $("div.post-heading").append(' <h2 id="subtitle">' + data["title"] + '</h2>');
            $("div#data").append(data["data"]);
        }
    );
    }
    

}
function mydown()
{
    // alert("sum"+sum+"id"+isss);
     var sum=sessionStorage.getItem("sum");
    var isss=sessionStorage.getItem("id");
    if(isss+1<sum)
    {

  
      sessionStorage.setItem("id",++isss);
    $.get("http://60.205.188.25/blog/show/ordown/" + isss,
        function (data, status) {
            $("header.intro-header").css("background-image", data["image"]);
            $("div.post-heading").append(' <h1 id="title">' + data["title"] + '</h1>');
            $("div.post-heading").append(' <h2 id="subtitle">' + data["title"] + '</h2>');
            $("div#data").append(data["data"]);
        }
    );
    }
    

}

