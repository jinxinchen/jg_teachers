/**
 * Created by 陈 on 2017/7/11.
 */
var userName;
function loadAccount() {
    $.ajax({
        type:"POST",
        url:"system/user/account.do",
        async:"false",
        // dataType:"json",
        success:function(data){
            userName = data;
        },
        error:function (err) {
            console.log(1);
            console.log(err);
        }
    })
}



function loginOut() {
    $.ajax({
        type:"POST",
        url:"system/user/loginOut.do",
    });
    window.location.href="/teachers/login.html";
}


//加载用户模块
function loadModule() {
    $.ajax({
        type: 'get',
        url: 'module/listByUserAccount.do',
        async: false,
        dataType: 'json',
        success: function (data, text, xhr) {
            console.log(data);
            //默认显示模块
            var defaultModuleName = "";
            var defaultModuleUrl = "";

            //找出所有根菜单
            var rootModules = [];
            for(var i = 0; i < data.length; i++) {
                var item = data[i];
                if (item.moduleFatherId == null && item.moduleIsDefault != 1) {
                    rootModules.push(item);
                }
                //找到默认显示模块
                if (item.moduleIsDefault == 1) {
                    defaultModuleName = item.moduleName;
                    defaultModuleUrl = item.moduleUrl;
                    $("#navPage").html(defaultModuleName);
                    // $("#navPage").attr("data-id", defaultModuleUrl);
                    $(".J_iframe").attr("src", defaultModuleUrl);
                }
            }
            //根据sequence排序根菜单
            var rootSize = rootModules.length;
            rootModules = sortModuleBySequence(rootModules);

            var moduleCotent = "";
            //遍历根菜单找出其所哟子菜单
            for (var i = 0; i < rootSize; i++) {
                var parentItem = rootModules[i];
                var childModules = [];
                for (var c = 0; c < data.length; c++) {
                    var childItem = data[c];
                    if (parentItem.moduleId == childItem.moduleFatherId) {
                        childModules.push(childItem);
                    }
                }
                //根据sequence排序子菜单
                childModules = sortModuleBySequence(childModules);
                //拼接菜单html

                var parentIcon = "";
                var parentName = parentItem.moduleName;
                var parentUrl = parentItem.moduleUrl;
                moduleCotent += ("<li>");
                parentUrl = (parentUrl == null || parentUrl == "" ? "#" : parentUrl);
                if (childModules.length > 0) {
                    //父模块
                    moduleCotent += ("<a href=\"" + parentUrl + "\">\n"+
                    "                            <i class=\"" + parentIcon + "\"></i>\n"+
                    "                            <span class=\"nav-label\">" + parentName + "</span>\n"+
                    "                            <span class=\"fa arrow\"></span>\n"+
                    "                        </a>");
                    //子模块
                    moduleCotent += ("<ul class=\"nav nav-second-level\">");
                    for (var c = 0; c < childModules.length; c++) {
                        var childUrl = childModules[c].moduleUrl;
                        var childName = childModules[c].moduleName;
                        moduleCotent += ("<li>\n"+
                        "                                <a class=\"J_menuItem\" href=\"" + childUrl + "\">" + childName +"</a>\n"+
                        "                            </li>");
                    }
                    moduleCotent += ("</ul>");
                }
                if (childModules.length == 0) {
                    moduleCotent += ("<a class=\"J_menuItem\" href=\"" + parentUrl + "\"><i class=\"" + parentIcon + "\"></i> <span class=\"nav-label\">" + parentName + "</span></a>");
                }
                moduleCotent += ("<li/>");
            }

            $("#rt_header").after(moduleCotent);
        }
    });
}

// 根据sequence对模块进行排序
function sortModuleBySequence(modules) {
    var size = modules.length;
    for (var i = 0; i < size; i++) {
        for(var c = i; c < size; c++) {
            if (modules[c] < modules[i]) {
                var tempModule = modules[i];
                modules[i] = modules[c];
                modules[c] = tempModule;
            }
        }
    }
    return modules;
}


//为页面初始化提示模态框
$(function () {
    if(checkLogin()){
        loadAccount();
        loadModule();
    }
});
