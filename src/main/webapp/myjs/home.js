
$(document).ready(function () {
    $.get("http://localhost:8080/myblog/blogs/number/sum",
        function (data, status) {
            sessionStorage.setItem("sum", Number(data));
            sessionStorage.setItem("start", 0);
            setmorebutton();
        }
    );

    aa();
    $("button#mymoreup").click(function (e) {
        var sum = sessionStorage.getItem("sum");
        var start = sessionStorage.getItem("start");
        // alert(sum+start);
        if (Number(start) <= 0) {

            return;
        }


        moreup();

    });
    $("button#mymoredown").click(function (e) {
        var sum = sessionStorage.getItem("sum");
        var start = sessionStorage.getItem("start");

        if (Number(start) + 10 >= Number(sum)) {
            return;
        }


        moredown();


    });
    serch();

    // $("a#more").click(function (e) { 
    //     alert("more");
    //      location.assign("http://localhost:8080/myblog/post.html");
    // });

});
function setmorebutton() {
    var sum = sessionStorage.getItem("sum");
    var start = sessionStorage.getItem("start");
    // alert(sum + start);
    if (Number(start) <= 0) {

        $("button#mymoreup").hide();
        if (Number(start) + 10 < Number(sum)) {
            $("button#mymoredown").show();

        }
    }
    else {
        $("button#mymoreup").show();
    }
    if (Number(start) + 10 >= Number(sum)) {
        $("button#mymoredown").hide();
    }
    if (Number(start) > 0 && Number(start) + 10 < Number(sum)) {
        $("button#mymoredown").show();
        $("button#mymoreup").show();
    }

    // $("button#moreup").hide();
}
function serch() {

    $("input#myserch").bind("input propertychange", function (e) {
        // alert("The text has been changed." + document.getElementById("myserch").value);
        var text = document.getElementById("myserch").value;
        if (sessionStorage.getItem("serchtext") == text) return;
        sessionStorage.setItem("serchtext", text);
        var ourl = "http://localhost:8080/myblog/blogs/" + text;

        // var urls = encodeURI(ourl);
        // alert(encodeURI(ourl));


        $.get(encodeURI(ourl),
            function (data, status) {
                // alert(data);
                $(".aaaaaaaaaa").remove();
                var bloss = "";
                for (var index = 0; index < data.length; index++) {
                    var element = data[index];
                    bloss += getbloghtml(element);
                }
                // $("#mylist").append(bloss);
                $("#mylist").before(bloss);
                bb();





            }
        );


    });

}
function more() {
    $("button#mymoredown").show();

    //  var start = sessionStorage.getItem("start");
    //  var sum=sessionStorage.getItem("sum");
    // if (start== null) {
    //     // alert("nan");
    //     start = 0;
    //     sessionStorage.setItem("start", start);
    // }
    // else {
    //     // start+=10;

    //     if (start + 10 < sum {
    //         start += 10;
    //     sessionStorage.setItem("start", start);
    //      aa(start);
    //     }
    //     else{
    //         return;
    //     }
    // }

}
function bb() {
    $("a.portfolio-box").each(function (index, element) {
        $(element).click(function (e) {
            var id = $(element).attr("title");
            // alert(id);
            sessionStorage.setItem("id", id);
        });
    });
}
function aa(start) {

    $.get("http://localhost:8080/myblog/blogs/get10/0",
        function (data, status) {
            var bloss = "";
            for (var index = 0; index < data.length; index++) {
                var element = data[index];
                bloss += getbloghtml(element);
            }
            // $("#mylist").append(bloss);
            $("#mylist").before(bloss);
            bb();
        }
    );

}

function getbloghtml(blog) {
    var html = "";
    html += '<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 aaaaaaaaaa"  >';
    html += geturlfor_blog(blog["id"]);
    html += ' <img src="' + blog["image"] + '" class="img-responsive" alt="" >';
    html += ' <h2 class="post-title itemtext" >';
    html += blog["title"];
    html += '</h2>';
    html += ' <div class="portfolio-box-caption ">';
    html += '<div class="portfolio-box-caption-content ">';
    html += ' <div class="project-category text-faded ">';
    html += ' 作者：长宏';
    html += ' </div>';
    html += ' <div class="project-name ">';
    html += '  时间：2018年10月';
    html += '</div>';
    html += '  </div>';
    html += ' </div>';
    html += ' </a>';
    html += '</div>';
    return html;
}

function geturlfor_blog(blogid) {
    return '<a href="' +
        'http://localhost:8080/myblog/post.html"' + '  title="' + blogid + '"' + '" class="portfolio-box" >';
}

function moredown() {
    var start = sessionStorage.getItem("start");
    sessionStorage.setItem("start", Number(start) + 10);
    setmorebutton();



    var text = sessionStorage.getItem("start");

    var ourl = "http://localhost:8080/myblog/blogs/get10/" + text;

    // var urls = encodeURI(ourl);
    // alert(encodeURI(ourl));


    $.get(encodeURI(ourl),
        function (data, status) {
            // alert(data);
            $(".aaaaaaaaaa").remove();
            var bloss = "";
            for (var index = 0; index < data.length; index++) {
                var element = data[index];
                bloss += getbloghtml(element);
            }
            // $("#mylist").append(bloss);
            $("#mylist").before(bloss);
            bb();





        }
    );

}
function moreup() {
    var start = sessionStorage.getItem("start");

    sessionStorage.setItem("start", Number(start) - 10);

    setmorebutton();

    var text = sessionStorage.getItem("start");

    var ourl = "http://localhost:8080/myblog/blogs/get10/" + text;


    // var urls = encodeURI(ourl);
    // alert(encodeURI(ourl));


    $.get(encodeURI(ourl),
        function (data, status) {
            // alert(data);
            $(".aaaaaaaaaa").remove();
            var bloss = "";
            for (var index = 0; index < data.length; index++) {
                var element = data[index];
                bloss += getbloghtml(element);
            }
            // $("#mylist").append(bloss);
            $("#mylist").before(bloss);
            bb();





        }
    );

}