/**
 * Created by 陈 on 2017/7/11.
 */
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
            url:"system/user/login.do",
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
                    }else if(data == "isxuegong"){
                        alert("学工账号请在学工页面登陆")
                    }
                    location.href="login.html";
                }

            },
            error:function(response){
                console.log("this is a error!");
                console.log(response);
            }
        })
    }
}

function checkUrl() {
    //解析url的参数给出对应的提示
    //message登陆状态解析
    message = getUrlParam("message");
    if(message == "noLogin"){
        alert("用户未登陆，或者登陆已经过期,不能访问当前页面,请登陆后再试")
    }else if(message == "reject") {
        alert("当前登陆用户没有权限访问当前页面,请切换账号访问")
    }
}

function changeImage(){
    $("#verifyCodeImage").attr("src","verifyCode/getCode.do");
}

$(function () {
    checkUrl();
});