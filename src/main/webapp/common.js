//这个导入公共js的所有的js公用的一些函数
/**
 * 主要是用来判断用户是不是登陆了
 * checkUser是用来判断user角色的
 * moduleName 是null的时候 即调用checkLogin的时候，只会判断是不是已经登陆就行
 * moduleName 对应访问模块,例如一个教师登陆  管理员的模块是addAccount这个时候，
 * 以教师的身份访问addAcounts的页面会失败, addAcount的js调用为checkLogin("添加账户")
 *
 * 返回的data有三种
 * sucess表示可以访问
 * reject表示没有权限
 * noLogin表示没有登陆或者登陆过期
 *
 * @return bool  符合规定的话将会返回true，否则的返回false，同时自动跳转到登陆页面
 */
function checkLogin(moduleName) {
    result = true;
    $.ajax({
        type:"POST",
        data:{moduleName:moduleName},
        url:"/teachers/system/user/checkLogin.do",
        async:false,
        success:function (data) {
            console.log(data);
            if(data !="success"){
                //直接跳转
                result = false;
                window.location.href = "/teachers/login.html?message="+data.toString();
            }

        },
        error:function (err) {
            console.log(1);
            console.log(err);
        }

    });
    return result;
}

/**
 *  解析url获得，获得paraName参数的值
 * @param paraName 参数名
 * @returns {string} 参数
 */
function getUrlParam(paraName) {
    var url = document.location.toString();
    var arrObj = url.split("?");

    if (arrObj.length > 1) {
        var arrPara = arrObj[1].split("&");
        var arr;

        for (var i = 0; i < arrPara.length; i++) {
            arr = arrPara[i].split("=");

            if (arr != null && arr[0] == paraName) {
                return arr[1];
            }
        }
        return "";
    }
    else {
        return "";
    }
}