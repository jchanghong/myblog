$(document).ready(function () {
    alert("red");
      $.get("http://localhost:8080/myblog/geterror",
        function (data, status) {
alert("red");
$("p3#myerror").val(data);
            // $("p3.myerror").append(' <p id="title">' + data + '</p>');
        }
    );
});