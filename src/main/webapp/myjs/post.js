$(document).ready(function () {
    // var id=sessionStorage.getItem("id");
  // alert("begen to get:"+id);
geall1t();
      $.get("http://localhost:8080/myblog/blog/2",
        function (data, status) {

            // alert("Data: " + data + "\nStatus: " + status);
          $("div.heading").append(' <h1 id="title">'+data["title"]+'</h1>');
          // $("h1#subtitle").append(data["updatetime"]);
          // $("div#data").append(data["data"]);
        }
    );
});

function geall1t()
{


    $.ajax({
                url: "http://localhost:8080/myblog/blog/2",
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