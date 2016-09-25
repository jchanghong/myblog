function myinit() {
    $.get("http://60.205.188.25/messages",
        function (data, status) {
            var bloss = "";
            for (var index = 0; index < data.length; index++) {
                var element = data[index];
                bloss += getitemhtml22(element);
            }
            // $("#mylist").append(bloss);
            $("ul#mylist").before(bloss);
        }
    );

}
function getitemhtml22(element) {
    var htmli = "";
    var date2=new Date(element["time"]);
    htmli += '  <li class="list-group-item">';
    htmli += element["name"] + '  留言于 ' + date2.toLocaleString();
    htmli += '    <p>' + element["message"] + '</p>';
    htmli += '  </li>';
    return htmli;

}
function mysend() {
var car = {id:"0", name:"500", time:1111,message:"hh"};
//  postmessage(JSON.stringify(car));
    var u22 = $("input#myname").val();
    var m22 = $("textarea#mymessage").val();
    car.name=u22;
    car.message=u22;
    // alert(JSON.stringify(car));
    postmessage(JSON.stringify(car));

}
function clenasss() {
    $("input#myname").val("");
    $("textarea#mymessage").val("");
 


}
$(document).ready(function () {
    myinit();
    $("button#mysend").click(function (e) {
        mysend();
    });
    $("button#myreset").click(function (e) {
        clenasss();
    });
});
function postmessage(u) {
    // var m = {
    //     id: 0,
    //     time: 1111111,
    //     message: m22,
    //     user: u22
    // };
    // alert(u);
    // alert(m["time"]+m["user"]);
    $.ajax({
        type: "POST",
        cache: false,
        url: "http://60.205.188.25/message/new",
        data: u,
        Accept: "application/json",
        contentType: "application/json; charset=utf-8",
        // dataType: "application/json; charset=utf-8",
        success: function (result, status, xhr) {
            $("p#myresult").html("发送成功！！！");
            $("ul#mylist").before(getitemhtml22(m));
        },
        error: function (xhr, status, error) {
            $("p#myresult").html("发送失败！！！" + status);
        }
    });

}