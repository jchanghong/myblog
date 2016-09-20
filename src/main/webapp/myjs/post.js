$(document).ready(function () {
    // var id=sessionStorage.getItem("id");
  // alert("begen to get:"+id);
geall1t();
      $.get("http://localhost:8080/myblog/blog/23",
        function (data, status) {

            alert("Data: " + data["title"] + "\nStatus: " + status);

$("div#data").css("background-image",'http://localhost:8080/myblog/'+ data["image"]);
$("header.intro-header").css("background-image", data["image"]);

          $("div.post-heading").append(' <h1 id="title">'+data["title"]+'</h1>');
          $("div.post-heading").append(' <h2 id="subtitle">'+data["title"]+'</h1>');
          $("div#data").append(' <h1 >'+data["title"]+'</h1>');
          $("div#data").append(' <p >'+data["data"]+'</p>');
          $("div#data").append(data["data"]);
        
          // $("h1#subtitle").append(data["updatetime"]);
          // $("div#data").append(data["data"]);
        }
    );
});

function geall1t()
{


var ids=sessionStorage.getItem("id");
    $.ajax({
                url: "http://localhost:8080/myblog/blog/"+ids,
                type: "GET",
                success: function(data) {
                    // Success message
                    alert("我会尽快联系22222你！！！");
                },
                error: function(data,status) {
                  

                    alert("我会尽快联系你！！！"+data["title"]+status["code"]);
                },
            });

}