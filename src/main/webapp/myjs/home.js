
$(document).ready(function () {
    aa();
});

function aa() {
    $.get("http://localhost:8080/myblog/blogs",
        function (data, status) {

            // alert("Data: " + data + "\nStatus: " + status);
            var bloss="";
            for (var index = 0; index < data.length; index++) {
                var element = data[index];
               bloss+=getbloghtml(element);
            }
            $("#mylist").append(bloss);
        }
    );

}

function getbloghtml(blog) {
    var html = "";
    html += '<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 "  >';
    html += geturlfor_blog(blog["id"]);
    html += ' <img src="img/portfolio/thumbnails/1.jpg" class="img-responsive" alt="" >';
    html += ' <h2 class="post-title itemtext" >';
    html += ' fffffff';
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

function geturlfor_blog(blogid)
{

return  '<a href="'+
"http://localhost:8080/myblog/blog/show/"+blogid+'" class="portfolio-box" >';
}