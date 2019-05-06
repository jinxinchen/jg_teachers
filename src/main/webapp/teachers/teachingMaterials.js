/**
 * Created by Administrator on 2017/12/17 0017.
 */


var uploadSever='http://192.168.213.253:8099/teachers_files/'
//var uploadSever='http://127.0.0.1:8099/teachersFile/'

function downLoadtExcel() {
    $.ajax({
        type:'post',
        url:'/teachers/teacher/teacherMaterials/requestUpload.do',
        data: "",
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
                window.location.href = "/teachers/teacher/teacherMaterials/downloadExcel.do";
            }else{
                alert("服务器出错，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错，无法下载");
        }
    });

}


function loadMaterials(){
    var saveUrl = "/teachers/teacher/teacherMaterials/saveMaterials.do";
    var deleteUrl = "/teachers/teacher/teacherMaterials/deleteMaterials.do";
    var updateUrl = "/teachers/teacher/teacherMaterials/updateMaterials.do";
    var loadDataUrl =  "/teachers/teacher/teacherMaterials/listMaterials.do";

    $.jgrid.defaults.styleUI = 'Bootstrap';


    $("#tMaterials").jqGrid({
        url: loadDataUrl,
        datatype: "json",
        //  data:testData,
        //  datatype: "local",
        height: 170,
        editable: true,
        autowidth: true,
        shrinkToFit: true,

        rowNum: 4,
        rowList: [5, 10, 15],
        colNames: [
            '记录id',
            'userId',
            '课程名称',
            '上课学期',
            '类型',
            '查看文件',
            '上传文件',
            '上传时间',
            '操作'],

        //具体的每列的设计
        colModel: [
            {
                name: 'id',
                index: 'id',
                search: true,
                width: 150,
                sortable: true,
                editable: false,
                hidden: true,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },

            {
                name: 'userId',
                index: 'userId',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                hidden: true,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                name:'courseName',
                index:'courseName',
                width:150,
                editable: true,
                sortable: false,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },


            {
                name:'semester',
                index:'semester',
                width:150,
                sortable: true,
                editable: true,
                edittype: 'select',
                editoptions: {
                    dataUrl: '',
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        var val="";
                        for( i=2018;i<2050;i++){
                            val=i+"年上学期";
                            selectHtml += '<option value='+val+'>' + val + '</option>';
                            val=i+"年下学期";
                            selectHtml += '<option value='+val+'>' + val + '</option>';
                        }
                        return selectHtml;
                    }
                },
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },{
                name:'type',
                index:'type',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                hidden: false,
                edittype: 'select',
                editoptions: {
                    dataUrl: '',
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="大纲">' + "大纲" + '</option>';
                        selectHtml += '<option value="进度表">' + "进度表" + '</option>';
                        selectHtml += '<option value="幻灯片">' + "幻灯片" + '</option>';
                        selectHtml += '<option value="点名单">' + "点名单" + '</option>';
                        selectHtml += '<option value="教案">' + "教案" + '</option>';
                        selectHtml += '<option value="其他">' + "其他" + '</option>';

                        return selectHtml;
                    }
                },
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                width: 120,
                align: "left",
                editable: false,
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="downLoadFile(' + row.id + ','+1+')">下载</a>&nbsp;&nbsp;';
                },
            },
            {
                width: 120,
                align: "left",
                editable: false,
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="uploadFile(' + row.id + ','+1+')">上传</a>&nbsp;&nbsp;';
                },
            },

            {
                name:'fileTime',
                index:'fileTime',
                search: true,
                width: 150,
                sortable: true,
                editable: false,
                hidden: false,
                searchoptions: {
                    sopt: ['eq', 'ne']
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
                            var result = response.responseJSON.success;
                            return [result, 'fail to delete！', postdata.id];
                        }
                    }
                }
            }
        ],

        sortname: 'id',
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
        pager:'#pagerTMaterials',
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tMaterials").setSelection(4, true);
    // Setup buttons
    $("#tMaterials").jqGrid('navGrid', '#pagerTMaterials', {
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
        var width = $('.tMaterials_wrapper').width();
        $('#tMaterials').setGridWidth(width);
    });

}

/*
function loadDate(){
    var saveUrl = "#";
    var deleteUrl = "#";
    var updateUrl = "#";
    var loadDataUrl =  "/teachers/teacher/teacherMaterials/listMaterialsDate.do";

    $.jgrid.defaults.styleUI = 'Bootstrap';


    $("#tDate").jqGrid({
        url: loadDataUrl,
        datatype: "json",
        //  data:testData,
        //  datatype: "local",
        height: 170,
        editable: true,
        autowidth: true,
        shrinkToFit: true,

        rowNum: 4,
        rowList: [5, 10, 15],
        colNames: [
            '记录id',
            'userId',
            '课程名称',
            '上课学期',
            '大纲附件上传时间',
            '进度表附件上传时间',
            'ppt附件上传时间',
            '点名单附件上传时间',
            '教案附件上传时间',
        ],

        //具体的每列的设计
        colModel: [
            {
                name: 'id',
                index: 'id',
                search: true,
                width: 150,
                sortable: true,
                editable: false,
                hidden: true,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },

            {
                name: 'userId',
                index: 'userId',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                hidden: true,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                name:'courseName',
                index:'courseName',
                width:150,
                editable: true,
                sortable: false,
                editrules: {
                    required: true
                },
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },


            {
                name:'semester',
                index:'semester',
                width:150,
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
                name:'synopsisTime',
                index:'synopsisTime',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                hidden: false,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                name:'scheduleTime',
                index:'scheduleTime',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                hidden: false,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },

            {
                name:'pptTime',
                index:'pptTime',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                hidden: false,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },


            {
                name:'attendanceSheetTime',
                index:'attendanceSheetTime',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                hidden: false,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },

            {
                name:'lessonPlanTime',
                index:'lessonPlanTime',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                hidden: false,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },



        ],

        sortname: 'id',
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
        pager:'#pagerTDate',
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tDate").setSelection(4, true);
    // Setup buttons
    $("#tDate").jqGrid('navGrid', '#pagerTDate', {
            edit: false,
            add: false,
            del: false,
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
        },
        {
            //delete按钮选项
        },
        {
            //搜素按钮对应search框设置
            multipleSearch:true,   //是否开启多条件search功能
            caption: "search...",  //search模态框标头
            multipleGroup: true, //复杂条件与或search
            Find: "search",  //search按钮显示名称
            Reset: "reset", //reset按钮名称
            // top: 100,
            showQuery: false,  //是否在search模态框中显示生成的search条件语句
            searchOnEnter: true,  //按下回车建是否开始search
            groupOps: [ { op: "AND", text: "Satisfy all the conditions" }, { op: "OR", text: "Satisfy any conditions" } ],  //逻辑条件名称设置
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
        var width = $('.tDate_wrapper').width();
        $('#tDate').setGridWidth(width);
    });

}
*/
var recordid;
var selectop;
function uploadFile(rowid,select){
    selectop=select;//选择
    recordid=rowid;
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
    console.log(rowid);
    console.log(selectop);
}

// 设置点击保存按钮后触发的事件,此处可以写成路径地址
$("#addForm").attr("onsubmit", 'saveFile()');

function saveFile() {
    //console.log("save");
    var fd = new FormData();
    fd.append("file", $("#fileSrc").get(0).files[0]);
    fd.append("id",recordid);
    fd.append("select",selectop);
    $.ajax({
        type: 'post',
        //'/teachers/teacher/teacherMaterials/uploadMaterials.do'
        //'/teachers/uploadMaterials/uploadMa.do'

        url:uploadSever+'uploadMaterials/uploadMa.do',
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

function downLoadFile(rowid,select){
    $.ajax({
        type: 'post',
        url: '/teachers/teacher/teacherMaterials/downloadMaterials.do',
        // async: false,
        xhrFields: {
            withCredentials: true
        },
        // processData: false,
        // contentType: false,
        data: {
            'id':rowid,
            'select':select
        },
        //dataType: 'json',
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

$(function(){
    if(!checkLogin()){ return;}
    loadMaterials();
    //loadDate()
})