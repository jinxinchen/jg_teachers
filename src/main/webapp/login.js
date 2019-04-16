/**
 * Created by 陈 on 2017/7/11.
 */
function login(){
    var account = $("#account").val();
    var password = $("#password").val();
    // if(account.trim() == "" || password.trim() == ""){
    if(account == "" || password == ""){
        //输入不完全
        // $("#modalContent").html("用户名和密码输入不完整!");
        alert("wrong")
        // $('#noticeModal').modal('toggle');
    }else{
        $.ajax({
            type:"POST",
            url:"system/user/login.do",
            data:'account='+account+'&password='+password,
            // dataType:"json",
            async:true,
            success:function(data){
                if(data=="success"){
                    location.href="index.html";
                    // alert("success");
                }
                if(data=="wrong"){
                    alert("输入信息有误!!!");
                }

            },
            error:function(response){
                console.log("this is a error!");
                console.log(response);
            }
        })
    }
}