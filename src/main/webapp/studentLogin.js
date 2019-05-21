/**
 * Created by 陈 on 2017/7/11.
 */

function changeImage(){
    $("#verifyCodeImage").attr("src","verifyCode/getCode.do");
}

function login(){
    var account = $("#account").val();
    var password = $("#password").val();
    var code = $("#verifyCode").val();
    if(account == ""){
        alert("请输入账号");
    } else if(password == ""){
        alert("请输入密码")
    }else if(code == ""){
        alert("请输入验证码");
    }else{
        $.ajax({
            type:"POST",
            url:"system/user/studentLogin.do",
            data:'account='+account+'&password='+password+'&code='+code,
            async:true,
            success:function(data){
                if(data=="success"){
                    location.href="index.html";
                }else {
                    if(data == "noAccount"){
                        alert("账户不存在，请检查账户");
                    }else if(data == "codeErro"){
                        alert("验证码错误")
                    }else if(data == "passwordWorry"){
                        alert("账号密码错误");
                    }else if(data == "timesLimit"){
                        alert("密码错误次数太多，请等会再试")
                    }else if(data == "isnotxuegong"){
                        alert("此账号不是学工账号，无法登陆")
                    }
                    location.href="studentLogin.html";
                }

            },
            error:function(response){
                console.log("this is a error!");
                console.log(response);
            }
        })
    }

}