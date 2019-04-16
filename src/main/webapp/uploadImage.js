/**
 * Created by 陈 on 2017/10/28.
 */
//解析URL中的参数
// function GetQueryString(name)
// {
//     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
//     var r = window.location.search.substr(1).match(reg);
//     if(r!=null)return  unescape(r[2]); return null;
// }
function setImageSrc() {
    $("#imageform").attr("onsubmit", "saveInfo()")

}
function saveInfo() {
    var picfile = document.getElementById("file");
    var file = picfile.files;
    var formdata = new FormData();
    formdata.append("file",file[0])
    $.ajax({
        type:"get",
        url:"http;//127.0.0.1:8080/teachers/imageUpload/Upload.do",
        data: formdata,
        async:true,
        xhrFields: {
            withCredentials: true
        },
        success:function (e) {
            alert("ss")
            console.log(e)
        }
    })

}
setImageSrc();