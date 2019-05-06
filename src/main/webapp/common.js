//这个导入公共js的所有的js公用的一些函数
/**
 * 主要是用来判断用户是不是登陆了
 */
function checkLogin() {
    result = true;
    $.ajax({
        type:"POST",
        url:"/teachers/system/user/checkLogin.do",
        async:false,
        success:function (data) {
            console.log(data);
            if(data == "reject"){
                result = false;
                //如果要重定向就添加teachers ?gourl="+window.location.href,那边现在没这个需求，先不搞
                window.location.href = "/teachers/login.html";
            }
        },
        error:function (err) {
            console.log(1);
            console.log(err);
        }

    });
    return result;
}