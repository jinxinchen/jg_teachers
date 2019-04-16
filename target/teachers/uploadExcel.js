/**
 * Created by 陈 on 2017/9/27.
 */
function upload() {
    console.log("start upload");
    var formData = new FormData;
    formData.append("file", $("#file").get(0).files[0]);

    $.ajax({
        type:"post",
        data:formData,
        url:'/teachers/technology/inTechnology.do',
        processData: false,
        async: true,
        contentType: false,
        success:function (res) {
            console.log("success")
        },
        error:function (err) {
            console.log(err)

        }
    })
}