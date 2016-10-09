function initupdate() {
 $.get("http://ljx520.cn/types",
        function (data, status) {
            //   alert(typeof UE.getEditor('editor');
           data.forEach(function(element) {
             $("select#mytypes").append("<option>"+element["name"]+"</option>");
           }, this);
        }
    );


    var id = sessionStorage.getItem("id");
    if (typeof (id) == undefined) {
        id = 0;
        sessionStorage.setItem("id", id);
    }

    $.get("http://ljx520.cn/blog/show/ordown/" + id,
        function (data, status) {
            //   alert(typeof UE.getEditor('editor');
  $("select#mytypes").val(data["types"]);
   $("select#mytypes").val(data["types"]);
            UE.getEditor('editor').setContent(data["data"], false);
            $("input#title").val(data["title"]);
        }
    );
    $("input#butsubmit").click(function (e) {
        //   alert(typeof UE.getEditor('editor');
        var title = $("input#title").val();
          var types = $("select#mytypes").val();
        var data = UE.getEditor('editor').getContent();
        var nohtml = UE.getEditor('editor').getContentTxt();

        postblogupdate(id, title, data, nohtml,types);
        // location.assign("http://ljx520.cn/post.html");
    });




    $("button#myaddtypes").click(function (e) { 
     
     var types=$("input#mytypesname").val();
   var  data={id:0,name:types};
       $.ajax({
        type: "POST",
        cache: false,
        url: "http://ljx520.cn/type/new",
        data: JSON.stringify(data),
        Accept: "application/json",
        contentType: "application/json; charset=utf-8",
        // dataType: "application/json; charset=utf-8",
        success: function (result,status,xhr) {
             $("select#mytypes").append("<option>"+data["name"]+"</option>");
            // alert("成功！！！"+result["id"]+status);
            // sessionStorage.setItem("id",result["id"]);
              // location.assign("http://ljx520.cn/post.html");
        },
        error: function (xhr, status, error) {
            alert("失败！！！"+status+error);
        }
    });
      
    });


}
function postblogupdate(id, title, data, nohtml,types) {
    var blog = {
        id: id,
        complete: 1,
        createtime: 1111111,
        data: data,
        types:types,
        datanohtml: nohtml,
        image: "666",
        title: title,
        updatetime: 44444444
    };
    $.ajax({
        type: "POST",
        cache: false,
        url: "http://ljx520.cn/blog/update",
        data: JSON.stringify(blog),
        Accept: "application/json",
        contentType: "application/json; charset=utf-8",
        // dataType: "application/json; charset=utf-8",
        success: function (result, status, xhr) {
            // alert("成功！！！"+result["id"]+status);
            // sessionStorage.setItem("id",result["id"]);
            location.assign("http://ljx520.cn/post.html");
        },
        error: function (xhr, status, error) {
            alert("失败！！！" + status + error);
        }
    });

}