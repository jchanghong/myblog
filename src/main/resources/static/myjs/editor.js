$(document).ready(function () {
    // alert("ready");
  $.get("http://localhost/types",
        function (data, status) {
            //   alert(typeof UE.getEditor('editor');
           data.forEach(function(element) {
             $("select#mytypes").append("<option>"+element["name"]+"</option>");
           }, this);
        }
    );

    $("input#butsubmit").click(function (e) { 
      var title = $("input#title").val();
      var types = $("select#mytypes").val();
    var data = UE.getEditor('editor').getContent();
    var nohtml=UE.getEditor('editor').getContentTxt();
    postblog(title,data,nohtml,types);
      // location.assign("http://localhost/post.html");
    });


    $("button#myaddtypes").click(function (e) { 
     
     var types=$("input#mytypesname").val();
   var  data={id:0,name:types};
       $.ajax({
        type: "POST",
        cache: false,
        url: "http://localhost/type/new",
        data: JSON.stringify(data),
        Accept: "application/json",
        contentType: "application/json; charset=utf-8",
        // dataType: "application/json; charset=utf-8",
        success: function (result,status,xhr) {
             $("select#mytypes").append("<option>"+data["name"]+"</option>");
            // alert("成功！！！"+result["id"]+status);
            // sessionStorage.setItem("id",result["id"]);
              // location.assign("http://localhost/post.html");
        },
        error: function (xhr, status, error) {
            alert("失败！！！"+status+error);
        }
    });
      
    });



});