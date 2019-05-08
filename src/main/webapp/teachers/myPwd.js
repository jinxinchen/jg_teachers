
function updatePwd() {
    var updatePwdUrl = "/teachers/changePwd/updatePwd.do";

    if($("#newPassword").val().length<6){
        $("#modalContent").html("密码长度最少6位"); $('#noticeModal').modal('toggle');
        return false;
    }
    if($("#newPassword").val() != $("#newPassword1").val()){
        $("#modalContent").html("两次密码不一致");
        $('#noticeModal').modal('toggle');
    }else{
        $.post(updatePwdUrl, $("#pwdForm").serialize(), function (response) {
            console.log(response)
            if(response == 200) {
                $("#modalContent").html("修改成功");
                $('#noticeModal').modal('toggle');
            } else if(response == 0){
                $("#modalContent").html("旧密码错误");
                $('#noticeModal').modal('toggle');
            }else{
                $("#modalContent").html("修改密码失败");
                $('#noticeModal').modal('toggle');
            }
        }, "json");
    }
    return false;
}