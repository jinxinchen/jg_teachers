/**
 * Created by Administrator on 2017/11/13 0013.
 */


var loadDataUrl =  "/teachers/admin/teacherActivity/listActivity.do";
var updateUrl = "/teachers/admin/teacherActivity/updateActivity.do";
var deleteUrl="/teachers/teacher/teacherActivity/deleteActivity.do";
var saveUrl="/teachers/teacher/teacherActivity/saveActivity.do";

function uploadActivity() {
    $.ajax({
        type:'post',
        url:'/teachers/admin/teacherActivity/requestUpload.do',
        data: "",
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
                window.location.href = "/teachers/admin/teacherActivity/downloadExcel.do";
            }else{
                alert("服务器出错，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错，无法下载");
        }
    });

}
function loadActivity(){

    $.jgrid.defaults.styleUI="Bootstrap";

    $("#tActivityCheck").jqGrid({
        url: loadDataUrl,
        datatype: "json",
        height: 170,
        editable: true,
        autowidth: true,
        shrinkToFit: true,

        rowNum: 5,
        rowList: [5, 10, 15],
        colNames: [
            '记录id',
            '用户id',
            '老师姓名',
            '活动名称',
            '活动地点',
            '活动时间',
            '举办单位',
            '相关证明',
            // '状态',
            '备注'],
            // '审核'],

        //具体的每列的设计
        colModel: [
            {
                name: 'id',
                index: 'id',
                search: false,
                width: 150,
                sortable: true,
                editable: false,
                hidden: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'userId',
                index: 'userId',
                search: false,
                width: 150,
                sortable: true,
                editable: false,
                hidden: true,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                name:'teacherName',
                index:'teacherName',
                witdth:150,
                editable:true,
                sotrable:false,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },

            {

                name:'activityName',
                index:'activityName',
                width:150,
                editable: true,
                sortable: false,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'activityLocation',
                index:'activityLocation',
                width:150,
                editable: true,
                sortable: false,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },

            {
                name:'activityTime',
                index:'activityTime',
                width:150,
                formatter: 'date',
                formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'},
                editable:true,
                width: 150,
                search: true,
                sortable: true,
                editoptions: {
                    dataInit: function (element) {
                        $(element).attr("readonly", "readonly");
                        $(element).on("click", function () {
                            laydate({istime: false, format: 'YYYY-MM-DD', choose: function(dates){ //选择好日期的回调
                                    $(element).trigger("change");
                                }})
                        })
                    }
                },
                searchoptions: {
                    sopt: ['eq', 'ne', 'lt', 'le', 'gt'],
                    dataInit: function (element) {
                        $(element).attr("readonly", "readonly");
                        $(element).on("click", function () {
                            laydate({istime: false, format: 'YYYY-MM-DD', choose: function(dates){ //选择好日期的回调
                                    $(element).trigger("change");
                                }})
                        })
                    }
                }
            },

            {
                name:'activityOrganizers',
                index:'activityOrganizers',
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
                width: 120,
                align: "left",
                editable: false,
                formatter:function (cellvalue, options, row) {
                    var s=row.certificate;
                    if(s!=null) {
                        var index = s.lastIndexOf("\/");
                        s = s.substring(index + 1, s.length);
                    }
                    return '<a href="#" onclick="downLoadFile(' + row.id + ')">'+s+'</a>&nbsp;&nbsp;';
                },
            },

            {
                name:'others',
                index:'others',
                width:150,
                editable: false,
                sortable: false,
            }
        ],

        sortname: 'activityTime',
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
        pager:'#pagerTActivityCheck',
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: true
    });

    // Add selection
    $("#tActivityCheck").setSelection(4, true);
    // Setup buttons
    $("#tActivityCheck").jqGrid('navGrid', '#pagerTActivityCheck', {
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
            return [result,response.responseJSON.data,postdata.id];
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
            return [result,response.responseJSON.data,postdata.id];
        }
    },{
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
            // top: 100,w
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
        var width = $('.tActivityCheck_wrapper').width();
        $('#tActivityCheck').setGridWidth(width);
    });

}

function check(rowid) {
    $.ajax({
        type:'post',
        url:'/teachers/admin/teacherActivity/check.do',
        data: {"id":rowid},
        dataType : 'text',
        success:function(data){
            window.location.href='teacherActivityCheck.html';
        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            //alert("服务器出错，无法下载");
        }
    });

}

function downLoadFile(rowid){
    $.ajax({
        type: 'post',
        url: '/teachers/teacher/teacherActivity/downloadEvidence.do',
        // async: false,
        xhrFields: {
            withCredentials: true
        },
        // processData: false,
        // contentType: false,
        data: {
            'id':rowid
        },
        success:function(data){
            console.log(data)
            window.location.href = data;
        },
        error:function(e){
            console.log(e)
        }
    })
    return false;
}

function inActivity() {
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
    $("#addForm").attr("onsubmit", 'saveFile()');
}
function saveFile() {
    var fd = new FormData();
    fd.append("file", $("#fileSrc").get(0).files[0]);

    $.ajax({
        type: 'post',
        url: '/teachers/admin/teacherActivity/inActivity.do',
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


function tran_value() {

    $("#fileName").val($("#fileSrc").val());
}

function downloadActivity() {
    window.location.href = "/teachers/fileTemplates/activity_admin.xlsx";
}


$(function(){
    if(!checkLogin("研修经历审核")){ return;}
    loadActivity();
})