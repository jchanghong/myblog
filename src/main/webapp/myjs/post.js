$(document).ready(function () {
  alert("begen to get");
    var id=sessionStorage.getItem("id");
      $.get("http://localhost:8080/myblog/blog/"+id,
        function (data, status) {

            alert("Data: " + data + "\nStatus: " + status);
          $("h1#title").append(data["title"]);
          $("h1#subtitle").append(data["updatetime"]);
          $("div#data").append(data["data"]);
        }
    );
});