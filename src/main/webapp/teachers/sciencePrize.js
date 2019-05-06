/**
 * Created by Administrator on 2017/11/18 0018.
 */










var uploadSever='http://192.168.213.253:8099/teachers_files/'
function loadReward() {
    var saveUrl = "/teachers/teacher/sciencePrize/savePrizeRecord.do";
    var deleteUrl ="/teachers/teacher/sciencePrize/deletePrizeRecord.do";
    var updateUrl ="/teachers/teacher/sciencePrize/updatePrizeRecord.do";
    var loadDataUrl ="/teachers/teacher/sciencePrize/listPrizeRecord.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';


    $("#tRewardList").jqGrid({
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
            '获奖名称',
            '成果名称',
            '证书编号',
            '获奖类别',
            '获奖日期',
            '授予单位',
            '学校署名排序',
            '作者署名排序',
            '成员名单',
            '证明上传',
            '证明查看',
            '上传日期',
            '备注',
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
                name: 'prizeName',
                index: 'prizeName',
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

                name:'educateScientificName',
                index:'educateScientificName',
                width:150,
                editable: true,
                sortable: false,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {

                name:'certifyNumber',
                index:'certifyNumber',
                width:150,
                editable: true,
                sortable: false,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                name:'type',
                index:'type',
                width:150,
                editable: true,
                edittype: 'select',
                editoptions: {
                    dataUrl: '',
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="科研">' + "科研" + '</option>';
                        selectHtml += '<option value="教学">' + "教学" + '</option>';
                        selectHtml += '</select>';
                        return selectHtml;
                    }
                },
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                name:'prizeTime',
                index:'prizeTime',
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
                name:'theUnit',
                index:'theUnit',
                width:150,
                editable: true,
                sortable: false,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                name:'schoolName',
                index:'schoolName',
                width:150,
                editable: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                name:'author',
                index:'author',
                width:150,
                editable: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },

            {
                name:'membersList',
                index:'membersList',
                width:150,
                editable: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                width: 120,
                align: "left",
                editable: false,
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="uploadFile(' + row.id + ')">上传文件</a>&nbsp;&nbsp;';
                },

            },
            {
                name:'evidencePath',
                index:'evidencePath',
                width: 120,
                align: "left",
                editable: false,
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="downLoadFile(' + row.id + ')">'+row.fileName+'</a>&nbsp;&nbsp;';
                },

            },
            {
                name:'uploadTime',
                index:'uploadTime',
                width: 120,
                align: "left",
                editable: false,

            },
            {
                name:'others',
                index:'others',
                width:150,
                editable: true,
                sortable: true,
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

        sortname: 'prizeTime',
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
        pager:'#pagerTRewardList',
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tRewardList").setSelection(4, true);
    // Setup buttons
    $("#tRewardList").jqGrid('navGrid', '#pagerTRewardList', {
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
        var width = $('.tReward_wrapper').width();
        $('#tRewardList').setGridWidth(width);
    });

}
function downLoadtExcel() {
    $.ajax({
        type:'post',
        url:'/teachers/teacher/sciencePrize/requestUpload.do',
        data: "",
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
                window.location.href = "/teachers/teacher/sciencePrize/downloadExcel.do";
            }else{
                alert("服务器出错，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错，无法下载");
        }
    });

}
var recordid;
function uploadFile(rowid){
    console.log(rowid)
    var rowData=$("#tRewardList").jqGrid("getRowData");
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
}

// 设置点击保存按钮后触发的事件,此处可以写成路径地址
$("#addForm").attr("onsubmit", 'saveFile()');

function saveFile() {
    //console.log("save");
    var fd = new FormData();
    fd.append("file", $("#fileSrc").get(0).files[0]);
    fd.append("id",recordid);

    $.ajax({
        type: 'post',
       // '/teachers/teacher/sciencePrize/uploadEvidence.do'
        url:uploadSever+ 'uploadSincePrize/uploadFile.do',
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
function downLoadFile(rowid){
    $.ajax({
        type: 'post',
        url: '/teachers/teacher/sciencePrize/downloadEvidence.do',
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


function downLoadSciencePrizeTemp() {
    window.location.href = "/teachers/fileTemplates/sciencePrize.xlsx";
}

function inSciencePrizeTemp() {
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
    $("#addForm").attr("onsubmit", 'inSciencePrizeTemp1()');
}

function inSciencePrizeTemp1() {
    var fd = new FormData();
    var rowid = $("#fileSrc").attr("data-rowid");
    fd.append("file", $("#fileSrc").get(0).files[0]);

    $.ajax({
        type: 'post',
        url: '/teachers/teacher/sciencePrize/inSciencePrizeTemp.do',
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

$(function(){
    if(!checkLogin()){ return;}
    loadReward();
})

