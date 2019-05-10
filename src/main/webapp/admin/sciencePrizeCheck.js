/**
 * Created by Administrator on 2017/11/19 0019.
 */


var loadDataUrl =  "/teachers/admin/sciencePrize/listPrizeRecord.do";
var updateUrl ="/teachers/admin/sciencePrize/updatePrizeRecord.do";

function passArticle(id) {
    // alert(id);
    //var rowData=$("#tProjectCheck").jqGrid("getRowData");

    var sta="通过"

    //alert(row.id+sta);
    $.ajax({
        type:'post',
        url:updateUrl,
        data: {id:id,status:sta},
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
            }else{
                //alert("服务器出错")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            //alert("服务器出错");
        }
    });

}

function uploadActivity() {
    $.ajax({
        type:'post',
        url:'/teachers/admin/sciencePrize/requestUpload.do',
        data: "",
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
                window.location.href = "/teachers/admin/sciencePrize/downloadExcel.do";
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
    var saveUrl =   "/teachers/teacher/sciencePrize/savePrizeRecord.do";
    var deleteUrl ="/teachers/teacher/sciencePrize/deletePrizeRecord.do";

    $.jgrid.defaults.styleUI="Bootstrap";

    $("#tPrizeCheck").jqGrid({
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
            '获奖名称',
            '成果名称',
            '证书编号',
            '获奖类别',
            '获奖日期',
            '授奖单位',
            '学校署名',
            '作者署名',
            '成员名单',
            '证明',
            '备注'],
            // '状态',
            // '审核',
            // '操作'

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
                name:'name',
                index:'name',
                witdth:150,
                editable:true,
                sortable:true,
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
                width: 150,
                sortable: true,
                editable: true,
                hidden: false,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {

                name:'educateScientificName',
                index:'educateScientificName',
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

                name:'certifyNumber',
                index:'certifyNumber',
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
                name: 'type',
                index: 'type',
                width: 150,
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
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'prizeTime',
                index:'prizeTime',
                width:150,
                formatter: 'date',
                formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d'},
                editable: true,
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
                            laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss', choose: function(dates){ //选择好日期的回调
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
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'schoolName',
                index:'schoolName',
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
                name:'author',
                index:'author',
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
                name:'membersList',
                index:'membersList',
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
                name:'evidencePath',
                index:'evidencePath',
                width: 120,
                align: "left",
                editable: false,
                editrules: {
                    required: false ,
                },
                formatter:function (cellvalue, options, row) {

                    return '<a href="#" onclick="downloadFile('+row.id+')">'+row.fileName+'</a>&nbsp;&nbsp;';

                },
                search: false,

            },
            {
                name:'others',
                index:'others',
                width:150,
                editable: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
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
        pager:'#pagerTPrizeCheck',
        add: false,
        edit: false,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tPrizeCheck").setSelection(4, true);
    // Setup buttons
    $("#tPrizeCheck").jqGrid('navGrid', '#pagerTPrizeCheck', {
            edit: true,
            add: true,
            del: true,
            search: true,
            view: true  //是否可以以模态框显示记录
        },
        {
        //edit按钮选项
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
                return [result,response.responseJSON.data,postdata.id];
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
        var width = $('.tPrizeCheck_wrapper').width();
        $('#tPrizeCheck').setGridWidth(width);
    });

}


function downloadFile(rowid){
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
            window.location.href = data;
        },
        error:function(e){
            console.log(e)
        }
    })
    return false;
}

function check(rowid) {
    $.ajax({
        type:'post',
        url:'/teachers/admin/sciencePrize/check.do',
        data: {"id":rowid},
        dataType : 'text',
        success:function(data){
            window.location.href='sciencePrizeCheck.html';
        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            //alert("服务器出错，无法下载");
        }
    });

}

function inSciencePrize() {
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
        url: '/teachers/admin/sciencePrize/inSciencePrize.do',
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

function downloadSciencePrize() {
    window.location.href = "/teachers/fileTemplates/prize_admin.xlsx";
}

$(function(){
    if(!checkLogin("教学科研奖项审核")){ return;}
    loadActivity();
})