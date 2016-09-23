$(document).ready(function () {
    // alert("ready");
    $("input#butsubmit").click(function (e) { 
      var title = $("input#title").val();
    var data = UE.getEditor('editor').getContent();
    var nohtml=UE.getEditor('editor').getContentTxt();
    postblog(title,data,nohtml);
      // location.assign("http://localhost:8080/myblog/post.html");
    });
});