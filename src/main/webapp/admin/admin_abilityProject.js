    /**
 * Created by 陈 on 2017/11/20.
 */
function loadAbilityProject(){
    var loadDataUrl = "/teachers/adminAbilityProject/loadAbilityProject.do";
        var deleteUrl = "/teachers/abilityProject/deleteAbilityProject.do";
        var saveUrl = "/teachers/adminAbilityProject/addAbilityProject.do";
        var updateUrl = "/teachers/adminAbilityProject/editAbilityProject.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    var lastFlag;

    $("#tAbilityProjectList").jqGrid({
        url: loadDataUrl,
        datatype: "json",
        height: 370,
        editable: true,
        autowidth: true,
        shrinkToFit: true,
        multiSort:true,
        rowNum: 5,
        rowList: [5, 10, 15],
        colNames: ['教师','编号','称号','获奖级别', '授奖单位','获奖者','获奖时间','资助或奖励金额','佐证下载','备注'],//,'状态','操作'
        colModel: [
            {
                name: 'name',
                index: 'name',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
                width: 90,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'prizeId',
                index: 'prizeId',
                search: true,
                editable: true,
                width: 150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'prizeName',
                index: 'prizeName',
                search: true,
                editable: true,
                width: 150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'prizeLevel',
                index: 'prizeLevel',
                search: true,
                editable: true,
                width: 150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'unitOfPrizes',
                index: 'unitOfPrizes',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
            },
            {
                name: 'winner',
                index: 'winner',
                width: 90,
                editable: true,
                search: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'winTime',
                index: 'winTime',
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
                name: 'funds',
                index: 'funds',
                width: 90,
                editable: true,
                search: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne', 'lt', 'le', 'gt']
                },
                searchrules: {
                    required: true
                }
            },
            {
                name: 'prizeEvidenceSrc',
                index: 'prizeEvidenceSrc',
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="downLoadFile(' + row.id + ')">' + row.fileName + '</a>&nbsp;&nbsp;';
                },
                width: 120,
                align: "left",
                editable: false,
                editrules: {
                    required: false ,
                },
            },
            {
                name: 'notice',
                index: 'notice',
                width: 90,
                editable: true,
                search: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            }
        ],
        sortname: 'winTime',
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
        pager: "#pagerTAbilityProjectList",
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tAbilityProjectList").setSelection(4, true);
    // Setup buttons
    $("#tAbilityProjectList").jqGrid('navGrid', '#pagerTAbilityProjectList', {
        edit: true,
        add: true,
        del: true,
        search: true,
        view: true  //是否可以以模态框显示记录
    },{//edit按钮选项
        key: true,
        url: updateUrl,
        mtype: 'POST',
        editCaption: "edit",
        restoreAfterError: true,
        afterSubmit : function(response, postdata) {
            console.log(response)
            var result = response.responseJSON.success;
            return [result,'fail to update！',postdata.id];
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
    }, {
        //delete按钮选项
        url: deleteUrl,  //delete对应接口
        afterSubmit : function(response, postdata) {
            var result = response.responseJSON.success;
            return [result,'fail to delete！',postdata.id];
        }
    }, {
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
        var width = $('.tAbilityProject_wrapper').width();
        $('#tAbilityProjectList').setGridWidth(width);
    });
}

function passAbilityProject(id) {
    $.ajax({
        type:'post',
        url:'/teachers/adminAbilityProject/passAbilityProject.do',
        async: false,e: false,
        data:{
            id:id
        },
        success:function(res){
            window.location.href='admin_abilityProject.html';
        },
    })
}

function downLoadFile(id){
    $.ajax({
        type: 'post',
        url: '/teachers/abilityProject/getAbilityProjectSrcById.do',
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

//导入
function inAbilityProject() {
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
    var rowid = $("#fileSrc").attr("data-rowid");
    fd.append("file", $("#fileSrc").get(0).files[0]);
    fd.append("id",rowid);

    $.ajax({
        type: 'post',
        url: '/teachers/adminAbilityProject/inAbilityProject.do',
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

function uploadAbilityProject(){
    $.ajax({
        type:'post',
        url:'/teachers/adminAbilityProject/requestAbilityprojectUpload.do',
        data: "",
        dataType : 'text',
        success:function(data){
            console.log(data)
            if(data.toString()=="success"){
                window.location.href = "/teachers/adminAbilityProject/downloadAbilityprojectExcel.do";
            }else{
                alert("服务器出错2，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错1，无法下载");
        }
    });
}

function downloadAbilityProject() {
    window.location.href = "/teachers/fileTemplates/abilityProject_admin.xlsx";
}

$(function () {
    if(checkLogin("人才项目审核")){
        loadAbilityProject()
    }
});
