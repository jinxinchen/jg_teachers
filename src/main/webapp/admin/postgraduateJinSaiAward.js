/**
 * Created by 陈 on 2018/11/26.
 */
function loadPostGraduteJingsai(){
    var saveUrl = "/teachers/student/addPostGraduateJingsai.do";
    var deleteUrl = "/teachers/student/deletePostGraduateJingsai.do";
    var updateUrl = "/teachers/student/editPostGraduateJingsai.do";
    var loadDataUrl = "/teachers/student/loadPostGraduateJingsai.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    var lastFlag;
    $("#tPostGraduateJingsaiList").jqGrid({
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
            '姓名',
            '年级',
            '指导教师',
            '竞赛名称',
            '参赛作品名称',
            '主办单位',
            '获奖等级',
            '获奖时间',
            '学生类别',
            '证书扫描件上传',
            '证书扫描件下载',
            '备注'
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
                name: 'name',
                index: 'name',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                }
            }, {
                name: 'grade',
                index: 'grade',
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
                name:'competitionName',
                index:'competitionName',
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
                name:'worksName',
                index:'worksName',
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
                name:'unit',
                index:'unit',
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
                name:'awardLevel',
                index:'awardLevel',
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
                name:'getTime',
                index:'getTime',
                editable:true,width:200,sorttype:"date",formatter:"date",
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
                name:'stuType',
                index:'stuType',
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
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="uploadFile(' + row.id + ')">上传文件</a>&nbsp;&nbsp;';
                },
                width: 120,
                align: "left",
                editable: false,
            },
            {
                name: 'fileSrc',
                index: 'fileSrc',
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="downLoadFile(' + row.id + ')">' + row.fileName + '</a>&nbsp;&nbsp;';
                },
                width: 120,
                align: "left",
                editable: false,
            },
            {
                name:'notice',
                index:'notice',
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
        sortname: 'getTime',
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
        pager: "#pagerTPostGraduateJingsaiList",
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tPostGraduateJingsaiList").setSelection(4, true);
    // Setup buttons
    $("#tPostGraduateJingsaiList").jqGrid('navGrid', '#pagerTPostGraduateJingsaiList',{
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
        var width = $('.tPostGraduteJingsai_wrapper').width();
        $('#tPostGraduateJingsaiList').setGridWidth(width);
    });
}


function uploadFile(rowid){
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
    $("#addForm").attr("onsubmit", 'saveFile()');
}

function saveFile() {
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
        url: 'http://192.168.213.253:8099/teachers_files/student/uploadJingsai.do',
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
function uploadPostGraduateJingsai() {
    $.ajax({
        type:'post',
        url:'/teachers/student/requestUploadPostGraduateJingsai.do',
        data: "",
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
                window.location.href = "/teachers/student/downloadExcelPostGraduateJingsai.do";
            }else{
                alert("服务器出错，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错，无法下载");
        }
    });

}
function downPostGraduateJingsai(){
    window.location.href = "/teachers/fileTemplates/postGraduateJingsai.xlsx";
}


function inPostGraduateJingsai() {
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
    $("#addForm").attr("onsubmit", 'savePostGraduateJingsai()');
}


function savePostGraduateJingsai() {

    var fd = new FormData();
    fd.append("file", $("#fileSrc").get(0).files[0]);

    $.ajax({
        type: 'post',
        url: '/teachers/student/inPostGraduateJingsai.do',
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
function downLoadFile(id){
    $.ajax({
        type: 'post',
        url: '/teachers/student/getJingsaiSrcById.do',
        // async: false,
        xhrFields: {
            withCredentials: true
        },
        // processData: false,
        // contentType: false,
        data: {
            'id':id
        },
        // dataType: 'json',
        success:function(data){
            console.log(data)
            window.location.href = data;
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
    loadPostGraduteJingsai();
})