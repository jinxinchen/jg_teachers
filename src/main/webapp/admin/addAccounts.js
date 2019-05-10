/**
 * Created by yangbo on 2017/3/29.
 */

function downLoadtExcel() {
    $.ajax({
        type:'post',
        url:'/teachers/manageTeachers/requestUpload.do',
        data: "",
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
                window.location.href = "/teachers/manageTeachers/downloadAcountExcel.do";
            }else{
                alert("服务器出错，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错，无法下载");
        }
    });

}

//加载账号信息
function loadAccount() {
    var saveUrl = "/teachers/manageTeachers/addRecord.do";
    var deleteUrl = "/teachers/manageTeachers/deleteAccount.do";
    var updateUrl = "/teachers/manageTeachers/editAccount.do";
    var loadDataUrl = "/teachers/manageTeachers/loadRecord.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $("#tAccountList").jqGrid({
        url: loadDataUrl,
        mtype: 'GET',
        datatype: "json",
        height: 500,
        autowidth: true,
        shrinkToFit: true,
        rowNum: 10,
        // editurl: 'clientArray',
        emptyrecords : "no record",
        viewrecords: true,
        rownumbers: true,  //是否显示行号
        multiselect: true,  //是否有多选功能
        multiSort: true,
        rowList: [10, 20, 30],
        sortname: 'createTime',
        sortorder: "desc",
        colNames: [ 'userId','账号','账户密码', '教师姓名','创建时间', '操作 '],
        colModel: [
            {
                name :'userId',

                index: 'userId',
                sortable: true,
                editable: false,
                hidden: true,
            },
            {
                name: 'account',
                index: 'account',
                search: true,
                width: 150,
                editable: true,
                sortable: true,
                editrules: {
                    required: true
                },
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
              //账户密码
                name:'password',
                index:'password',
                editable: false,
            },{
              //教师姓名
                name:'name',
                index:'name',
                editable: false
            },
            {
                name: 'createTime',
                index: 'createTime',
                formatter: 'date',
                formatoptions: {srcformat: 'Y-m-d H:i:s.u', newformat: 'Y-m-d H:i:s'},
                editable: false,
                width: 150,
                search: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne', 'lt', 'le', 'gt'],
                    dataInit: function (element) {
                        $(element).attr("readonly", "readonly");
                        $(element).on("click", function () {
                            laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss', choose: function(dates){ //选择好日期的回调
                                $(element).trigger("change");
                            }})
                        })
                    }
                }
            },
            {
                viewable: false,
                sortable: false,
                formatter : 'actions', // 在每一行显示编辑按钮与删除按钮
                search: false,
                formatoptions : {          // 按钮设定
                    url: updateUrl,  //in-line 更新对应的接口
                    delOptions: {
                        url: deleteUrl,  //删除对应接口
                        afterSubmit: function (response, postdata) {
                            var result = "";
                            return [result, 'fail to delete！', postdata.id];
                        }
                    }
                }
            }
        ],
        pager: "#pagerTAccountList",
        sortorder: "desc",
        prmNames: {
            rows: 'limit',
            page: 'page'
        },
        jsonReader: {
            root: 'result',
            total: 'pages',
            page: 'page',
            records: 'recores',
            repeatitems: false
        },
        viewrecords: true,
        // caption: "学生记录",
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });
    // Add selection
    $("#tAccountList").setSelection(4, true);
    // Setup buttons
    $("#tAccountList").jqGrid('navGrid', '#pagerTAccountList', {
        edit: true,
        add: true,
        del: true,
        search: true,
        view: true  //是否可以以模态框显示记录
    }, {//编辑按钮选项
        key: true,
        url: updateUrl,
        mtype: 'POST',
        editCaption: "edit",
        restoreAfterError: true,
        afterSubmit : function(response, postdata) {
            console.log("*******")
            console.log(response)
            var result = response.responseJSON;
            if(result == 201){
                showNotice("该账户已存在！");
            }
            var errorText = response.responseJSON.data;
            return [result,errorText,postdata.id];
        },
        closeAfterEdit: true,
        extraparam: {
        }
    },{
        //添加按钮选项
        url: saveUrl,
        datatype: 'json',
        serializeEditData: function(postData) {
            postData.id = "";
            return postData;
        },
        closeAfterAdd: true,
        afterSubmit : function(response, postdata) {
            var result = response.responseJSON.success;
            return [result,'save failed！',postdata.id];
        }
    },{
        //删除按钮选项
        url: deleteUrl,  //删除对应接口
        afterSubmit : function(response, postdata) {
            var result = response.responseJSON.success;
            return [result,'fail to delete！',postdata.id];
        }
    },{
        //搜素按钮对应search框设置
        multipleSearch:true,   //是否开启多条件search功能
        caption: "搜索...",  //search模态框标头
        multipleGroup: true, //复杂条件与或search
        Find: "搜索",  //search按钮显示名称
        Reset: "重置", //reset按钮名称
        // top: 100,
        showQuery: false,  //是否在search模态框中显示生成的search条件语句
        searchOnEnter: true,  //按下回车建是否开始search
        groupOps: [ { op: "AND", text: "满足所有条件" }, { op: "OR", text: "满足任一条件" } ],  //逻辑条件名称设置
        // jqModal: true,
        // modal: true,
        drag: true, //search模态框是否能够被拖拽动
    },{
        //view按钮对应选项
        // height: 200,
        drag: false, //搜索模态框是否能够被拖拽动
        reloadAfterSubmit: true,
        closeOnEscape:true  //按钮ESC键，弹窗消失
    });


    //自定义按钮
    jQuery("#tAccountList")
    //给jqgrid按钮和自定义按钮添加分隔符
        .jqGrid('navSeparatorAdd','#pagerTAccountList', {
            sepclass : 'ui-separator',
            sepcontent: ''})
        .jqGrid('navButtonAdd','#pagerTAccountList',{
            caption:"下载模板文件",
            buttonicon:'none',
            onClickButton : function () {
                downloadExcel();
            }
        })
        .jqGrid('navButtonAdd','#pagerTAccountList',{
            caption:"导入",
            buttonicon:'none',
            onClickButton : function () {
                uploadExcel();
            }
        });
        // .jqGrid('navButtonAdd','#pagerTAccountList',{
        //     caption:"智能导入",
        //     buttonicon:'none',
        //     onClickButton : function () {
        //         IntelligenceImport();
        //     }
        // });

    //下载模板文件
    function downloadExcel() {
        window.location.href = '/teachers/fileTemplates/teacherAccounts.xls';
    }

    //显示上传模板文件模态框
    function uploadExcel(){
        $("#addFormModel").modal();
    }

    // Add responsive to jqGrid
    $(window).bind('resize', function () {
        var width = $('.tAccount_wrapper').width();
        $('#tAccountList').setGridWidth(width);
    });
}


//智能导入账号
// function IntelligenceImport() {
//     var url = "/" + project_name + "/user/account/intelligenceImportAccount.do";
//     $.get(url, {}, function (response) {
//         if (response != null) {
//             if (response.success == true) {
//                 showNotice("智能导入执行成功");
//                 jQuery("#tAccountList").trigger("reloadGrid");
//             } else {
//                 showNotice(response.data);
//             }
//         } else {
//             showNotice("智能导入失败")
//         }
//     }, 'json')
// }

//上传模板文件
function uploadRecordsByXls() {
    console.log("start upload");
    var formData = new FormData;
    formData.append("file", $("#file").get(0).files[0]);
    $.ajax({
        type: 'POST',
        url: '/teachers/manageTeachers/upload.do',
        data: formData,
        processData: false,
        async: true,
        contentType: false,
        success: function (response) {
            if (response = 0) {
                showNotice("导入失败！");
            } else {
                $("#tAccountList").trigger("reloadGrid");
                $("#addFormModel").modal("hide");
                showNotice("导入成功！")
            }
        },
        timeout: 10000,
        error: function (response) {
            showNotice("请等待     !");
        },
        dataType: "json"
    });
    return false;
}


$(function () {
    if(checkLogin("添加账户")){
        loadAccount();
    }
})