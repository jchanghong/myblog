$(document).ready(function () {
    // alert("red");
    $.get("http://60.205.188.25/geterrormap",
        function (data, status) {
            var htmps="<p>"+data["exception"]+"<br>"+data["message"]+"<br>"+data["trace"]+"</p>";
            // alert(htmps);
            $("div#myerror").append(htmps);
            // $("p3#myerror").val(data);
            // $("p3.myerror").append(' <p id="title">' + data + '</p>');
        }
    );
});