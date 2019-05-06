/**
 * Created by 陈 on 2018/11/26.
 */
function loadStudentInfo(){
    var saveUrl = "/teachers/student/addInfo.do";
    var deleteUrl = "/teachers/student/deleteInfo.do";
    var updateUrl = "/teachers/student/editInfo.do";
    var loadDataUrl = "/teachers/student/loadInfo.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    var lastFlag;
    $("#tStudentInfoList").jqGrid({
        url: loadDataUrl,
        datatype: "json",
        height: 170,
        editable: true,
        autowidth: true,
        shrinkToFit: true,
        multiSort:true,
        rowNum: 5,
        rowList: [5, 10, 15],
        colNames: [
            '学号',
            '年级',
            '姓名',
            '性别',
            '学生类别',
            '出生日期',
            '专业',
            '研究方向',
            '导师姓名',
            '身份证号',
            '联系电话'
        ],

        //具体的每列的设计
        colModel: [
            {
                name: 'sno',
                index: 'sno',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                }
            },

            {
                name: 'grade',
                index: 'grade',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                }
            }, {
                name: 'name',
                index: 'name',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'gender',
                index:'gender',
                width:150,
                editable: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'stuType',
                index:'stuType',
                width:150,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },{
                name:'birthday',
                index:'birthday',
                width:150,
                formatter: 'date',
                formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'},
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
                name:'courseName',
                index:'courseName',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'research',
                index:'research',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'mentor',
                index:'mentor',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'identity',
                index:'identity',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'phoneNum',
                index:'phoneNum',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            }
        ],
        sortname: 'sno',
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
        viewrecords: true,  //是否显示总记录数
        rownumbers: true,  //是否显示行号
        multiselect: true,  //是否有多选功能

        // caption: "学生记录",
        pager: "#pagerTStudentInfoList",
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tStudentInfoList").setSelection(4, true);
    // Setup buttons
    $("#tStudentInfoList").jqGrid('navGrid', '#pagerTStudentInfoList',{
            edit: true,
            add: true,
            del: true,
            search: true,
            view: true  //是否可以以模态框显示记录
        }, {//edit按钮选项
            key: true,
            url: updateUrl,
            mtype: 'POST',
            editCaption: "edit",
            restoreAfterError: true,
            afterSubmit : function(response, postdata) {
                var result = response.responseJSON.success;
                return [result,'fail to update！',postdata.id];
            },
            closeAfterEdit: true,
            extraparam: {
            }
        } ,
        {
            //添加按钮选项
            url: saveUrl,
            // datatype: 'json',
            serializeEditData: function(postData) {
                postData.id = "";
                return postData;
            },
            closeAfterAdd: true,
            afterSubmit : function(response, postdata) {
                var result = response.responseJSON.success;
                return [result,'save failed！',postdata.id];
            }
        },
        {
            //delete按钮选项
            url: deleteUrl,  //delete对应接口
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
            drag: false, //search模态框是否能够被拖拽动
            reloadAfterSubmit: true,
            closeOnEscape:true  //按钮ESC键，弹窗消失
        });
    // Add responsive to jqGrid
    $(window).bind('resize', function () {
        var width = $('.tStudentInfo_wrapper').width();
        $('#tStudentInfoList').setGridWidth(width);
    });
}


function uploadAwardFile(rowid){
    console.log(rowid)
    //清空form弹窗内内容
    $("#addFormContent").html("");


    // 往form中塞入输入域
    var content = "<div class='form-group' id='enterCourse'></div>\n"+
        "                            <div class=\"form-group\">\n" +
        "                                <label class=\"col-sm-3 control-label\">选择文件：</label>\n" +
        "                                <div class=\"col-sm-8\" style=\"display:inline-flex\">\n" +
        "                                    <input id=\"fileSrc\" type=\"file\" name=\"fileSrc\" required=\"\" style=\"display: none\" onchange='tran_value()' data-rowid = '"+ rowid+"'>\n" +
        "                                    <input style=\"width: 180px;margin-right: 20px;\" id=\"fileName\" name=\"fileName\" readonly=\"true\"  aria-required=\"true\"  class=\"form-control\" required=\"\">\n" +
        "                                    <button type=\"button\" class=\"btn btn-w-m btn-default\" onclick=\"fileSrc.click()\" style=\"height: 30px;text-align: center\">上传</button>\n" +
        "                                </div>\n" +
        "                            </div>";
    $("#addFormContent").html(content);
    $("#addFormModel").modal();

// 设置点击保存按钮后触发的事件,此处可以写成路径地址
    $("#addForm").attr("onsubmit", 'saveAwardFile()');
}

function saveAwardFile() {
    var fd = new FormData();
    var rowid = $("#fileSrc").attr("data-rowid");
    fd.append("file", $("#fileSrc").get(0).files[0]);
    fd.append("id",rowid);
    var user_id;
    //获取user_id和id
    $.ajax({
        type: 'post',
        url: '/teachers/student/getUserId.do',
        async: false,

        xhrFields: {
            withCredentials: true
        },
        processData: false,
        contentType: false,
        // dataType: 'json',
        success:function(data){
            user_id = data.user_id
            console.log(data)
        },
        error:function(e){
            console.log(e)
        }
    })
    fd.append("user_id",user_id);
    $.ajax({
        type: 'post',
        url: 'http://192.168.213.253:8099/teachers_files/student/uploadStudentInfo.do',
        async: false,
        xhrFields: {
            withCredentials: true
        },
        processData: false,
        contentType: false,
        data: fd,
        // dataType: 'json',
        success:function(data){
            console.log(data)
        },
        error:function(e){
            console.log(e)
        }
    })
}
function uploadStudentInfo() {
    $.ajax({
        type:'post',
        url:'/teachers/student/requestUploadInfo.do',
        data: "",
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
                window.location.href = "/teachers/student/downloadExcelInfo.do";
            }else{
                alert("服务器出错，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错，无法下载");
        }
    });

}
function downStudentInfo(){
    window.location.href = "/teachers/fileTemplates/studentInfo.xlsx";
}


function inStudentInfo() {
    //清空form弹窗内内容
    $("#addFormContent").html("");


    // 往form中塞入输入域
    var content = "<div class='form-group' id='enterCourse'></div>\n"+
        "                            <div class=\"form-group\">\n" +
        "                                <label class=\"col-sm-3 control-label\">选择文件：</label>\n" +
        "                                <div class=\"col-sm-8\" style=\"display:inline-flex\">\n" +
        "                                    <input id=\"fileSrc\" type=\"file\" name=\"fileSrc\" required=\"\" style=\"display: none\" onchange='tran_value()'>\n" +
        "                                    <input style=\"width: 180px;margin-right: 20px;\" id=\"fileName\" name=\"fileName\" readonly=\"true\"  aria-required=\"true\"  class=\"form-control\" required=\"\">\n" +
        "                                    <button type=\"button\" class=\"btn btn-w-m btn-default\" onclick=\"fileSrc.click()\" style=\"height: 30px;text-align: center\">上传</button>\n" +
        "                                </div>\n" +
        "                            </div>";
    $("#addFormContent").html(content);
    $("#addFormModel").modal();
    // 设置点击保存按钮后触发的事件,此处可以写成路径地址
    // 设置点击保存按钮后触发的事件,此处可以写成路径地址
    $("#addForm").attr("onsubmit", 'saveStudentInfo()');
}


function saveStudentInfo() {

    var fd = new FormData();
    fd.append("file", $("#fileSrc").get(0).files[0]);

    $.ajax({
        type: 'post',
        url: '/teachers/student/inStudentInfo.do',
        async: false,
        xhrFields: {
            withCredentials: true
        },
        processData: false,
        contentType: false,
        data: fd,
        success:function(data){
            console.log(data)
        },
        error:function(e){
            console.log(e)
        }
    })
}
function tran_value() {

    $("#fileName").val($("#fileSrc").val());
}
$(function () {
    if(!checkLogin()){ return;}
    loadStudentInfo();
})