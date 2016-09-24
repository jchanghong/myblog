$(document).ready(function () {
    // alert("red");
    $.get("http://localhost:8080/myblog/geterrormap",
        function (data, status) {
            var htmps="<p>"+data["exception"]+"<br>"+data["message"]+"<br>"+data["trace"]+"</p>";
            // alert(htmps);
            $("div#myerror").append(htmps);
            // $("p3#myerror").val(data);
            // $("p3.myerror").append(' <p id="title">' + data + '</p>');
        }
    );
});