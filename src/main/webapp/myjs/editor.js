$(document).ready(function () {
    initblog();
    $("button#submit").click(function (e) { 
          //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    // var ue = UE.getEditor('editor');
    var data=    UE.getEditor('editor').getContent();
     var title=   $("input#title").html();
     var id=sessionStorage.getItem("editid");
     var blog={"data":data,"complete":"0","createtime":0,"id":id,"title":title,"updatetime":"0"};
     $.post("http://localhost:8080/myblog/blog/"+id, blog,
         function (data, textStatus, jqXHR) {
             alert(""+data+textStatus);
         },
         "appliction/json"
     );
     
    });
});

function initblog()
{
    $.get("http://localhost:8080/myblog/blog/new", data,
        function (data, textStatus, jqXHR) {
           var id=data["id"];
           sessionStorage.setItem("editid",id);
        },
        "dataType"
    );

}