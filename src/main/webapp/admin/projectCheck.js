/**
 * Created by Administrator on 2017/11/21 0021.
 */







// 设置点击保存按钮后触发的事件,此处可以写成路径地址
$("#addForm").attr("onsubmit", 'saveFile()');


function loadReward() {
    var saveUrl = "/teachers/teacher/project/saveProjectRecord.do";
    var deleteUrl ="/teachers/teacher/project/deleteProjectRecord.do";
    var updateUrl ="/teachers/teacher/project/updateProjectRecord.do";
    var loadDataUrl ="/teachers/admin/project/listProjectRecord.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';


    $("#tProjectCheck").jqGrid({
        url: loadDataUrl,
        datatype: "json",
        height: 250,
        editable: true,
        autowidth: true,
        shrinkToFit: true,

        rowNum: 5,
        rowList: [5, 10, 15],
        colNames: [
            'userId',
            '项目id',
            '项目编号',
            '负责人',
            '项目名称',
            '项目来源',
            '项目级别',//等级
            '立项时间',
            '结束时间',

            '是否在研',
            '项目类型',
            '成员名单',

            '资助经费',
            '立项书查看',
            '立项书上传时间',
            '结项书查看',
            '结项书上传时间',
            '备注'],
            // '状态',










        //具体的每列的设计
        colModel: [
            {
                name: 'userId',
                index: 'userId',
                search: true,
                hidden:true,
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
                name: 'id',
                index: 'id',
                search: true,
                hidden:true,
                width: 150,
                sortable: true,
                editable: false,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'projectId',
                index: 'projectId',
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
                name: 'headName',
                index: 'headName',
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

                name:'scientificName',
                index:'scientificName',
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

                name:'scientificSource',
                index:'scientificSource',//po层class是关键字没办法用class故变成clazz了
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
                name:'level',
                index:'level',
                width:150,
                editable: true,
                sortable: false,
                edittype: 'select',
                editoptions: {
                    dataUrl: '',
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="国家级">' + "国家级" + '</option>';
                        selectHtml += '<option value="省部级">' + "省部级" + '</option>';
                        selectHtml += '<option value="地厅级">' + "地厅级" + '</option>';
                        selectHtml += '<option value="校级">' + "校级" + '</option>';
                        selectHtml += '<option value="横向">' + "横向" + '</option>';
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
                name:'createTime',
                index:'createTime',
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
                name:'endTime',
                index:'endTime',
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
                name:'isMarch',
                index:'isMarch',
                width:150,
                editable: true,
                sortable: false,
                edittype: 'select',
                editoptions: {
                    dataUrl: '',
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="是">' + "是" + '</option>';
                        selectHtml += '<option value="否">' + "否" + '</option>';
                        selectHtml += '</select>';
                        return selectHtml;
                    }
                },
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },

            {
                name:'type',
                index:'type',
                width:150,
                editable: true,
                sortable: false,
                edittype: 'select',
                editoptions: {
                    dataUrl: '',
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="科研项目">' + "科研项目" + '</option>';
                        selectHtml += '<option value="教学项目">' + "教学项目" + '</option>';
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
                name:'memberList',
                index:'memberList',
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
                name:'grants',
                index:'grants',
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
                name:'createScientificEvidenceSrc',
                index:'createScientificEvidenceSrc',
                width:150,
                editable: false,
                formatter:function (cellvalue, options, row) {
                    var s=row.createScientificEvidenceSrc;
                    if(s!=null) {
                        var index = s.lastIndexOf("\/");
                        s = s.substring(index + 1, s.length);
                    }
                    return '<a href="#" onclick="downLoadCreateFile(' + row.id + ')"> '+s+'  </a>&nbsp;&nbsp;';
                },
            },
            {
                name:'createUpdateTime',
                index:'createUpdateTime',
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
                name:'endScientificEvidenceSrc',
                index:'endScientificEvidenceSrc',
                width:150,
                editable: false,
                formatter:function (cellvalue, options, row) {
                    var s=row.endScientificEvidenceSrc;
                    if(s!=null) {
                        var index = s.lastIndexOf("\/");
                        s = s.substring(index + 1, s.length);
                    }
                    return '<a href="#" onclick="downLoadEndFile(' + row.id + ')"> '+s+'</a>&nbsp;&nbsp;';
                },
            },
            {
                name:'endUpdateTime',
                index:'endUpdateTime',
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

        sortname: 'createTime',
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
        pager:'#pagerTProjectCheck',
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tProjectCheck").setSelection(4, true);
    // Setup buttons
    $("#tProjectCheck").jqGrid('navGrid', '#pagerTProjectCheck', {
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
                return [result,'立项时间要比结束时间早',postdata.id];
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
        var width = $('.tProjectCheck_wrapper').width();
        $('#tProjectCheck').setGridWidth(width);
    });

}


function loadMembers(rowid) {
    jQuery("#tProjectUser").trigger("reloadGrid");
    var saveUrl = "/teachers/teacher/project/saveProjectUser.do";
    var deleteUrl ="/teachers/teacher/project/deleteProjectUser.do";
    var updateUrl ="/teachers/teacher/project/updateProjectUser.do";
    var loadDataUrl ="/teachers/teacher/project/listProjectUser.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    var PostData={projectid:rowid};

    $("#tProjectUser").jqGrid({
        url: loadDataUrl,
        postData:PostData,
        datatype: "json",
        height: 170,
        editable: true,
        autowidth: true,
        shrinkToFit: true,

        rowNum: 5,
        rowList: [5, 10, 15],
        colNames: [
            'id',
            'userId',
            'projectId',
            '姓名',
            '项目名',
            '序号',
            '是否为负责人'],
            // '操作'

        //具体的每列的设计
        colModel: [
            {
                name: 'id',
                index: 'id',
                search: true,
                width: 100,
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
                search: true,
                hidden: true,
                width: 100,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                name: 'projectId',
                index: 'projectId',
                search: true,
                width: 100,
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

                name:'name',
                index:'name',
                width:100,
                editable: true,
                sortable: false,
                editrules: {
                    required: true
                },
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {

                name:'scientificName',
                index:'scientificName',
                width:100,
                editable: false,
                sortable: false,
                editrules: {
                    required: true
                },
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {

                name:'level',
                index:'level',
                width:100,
                editable: true,
                sortable: false,
                editrules: {
                    required: true
                },
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {

                name:'isPrincipal',
                index:'isPrincipal',
                width:100,
                editable: true,
                sortable: false,
                edittype: 'select',
                editoptions: {
                    dataUrl: '',
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="是">' + "是" + '</option>';
                        selectHtml += '<option value="否">' + "否" + '</option>';
                        selectHtml += '</select>';
                        return selectHtml;
                    }
                },
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            }
        ],

        sortname: 'projectId',
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
        pager:'#pagerTProjectUser',
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tProjectUser").setSelection(4, true);
    // Setup buttons
    $("#tProjectUser").jqGrid('navGrid', '#pagerTProjectUser', {
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
                return [result,response.responseJSON.data,postdata.id];
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

        },{
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
        var width = $('.addMemberContent').width();
        $('#tProjectUser').setGridWidth(width);
    });

}

urlValue="#";
function uploadEndFile(rowid){
    urlValue='/teachers/teacher/project/uploadEnd.do';
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
function uploadCreateFile(rowid){
    urlValue='/teachers/teacher/project/uploadCreate.do';
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

function saveFile() {
    //console.log("save");
    var fd = new FormData();
    fd.append("file", $("#fileSrc").get(0).files[0]);
    fd.append("id",recordid);

    $.ajax({
        type: 'post',
        url:urlValue ,
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

function downLoadCreateFile(rowid){
    $.ajax({
        type: 'post',
        url: '/teachers/teacher/project/downloadCreate.do',
        // async: false,
        xhrFields: {
            withCredentials: true
        },
        // processData: false,
        // contentType: false,
        data: {
            'id':rowid
        },
        // dataType: 'json',
        success:function(data){
            window.location.href = data;
        },
        error:function(e){
            console.log(e)
        }
    })
    return false;
}

function downLoadEndFile(rowid) {
    $.ajax({
        type: 'post',
        url: '/teachers/teacher/project/downloadEnd.do',
        // async: false,
        xhrFields: {
            withCredentials: true
        },
        // processData: false,
        // contentType: false,
        data: {'id':rowid},
        // dataType: 'json',
        success:function(data){
            console.log(12212121212)
            console.log(data)
            window.location.href = data;
        },
        error:function(e){
            console.log(e)
        }
    })
    return false;
}


function findMembers(rowid) {
    //$("#addFormContent").html("");
    //$("#memberList").cleardraw();
    $("#addMemberContent").html("")
    var cont="<div class=\"tProjectUser_wrapper\">\n"+
        "        <table id=\"tProjectUser\"></table>\n"+
        "        <div id=\"pagerTProjectUser\"></div>\n"+
        "        </div>"
    $("#addMemberContent").html(cont);
    $("#memberList").modal();
    loadMembers(rowid);
}

function check(rowid) {
    $.ajax({
        type:'post',
        url:'/teachers/admin/project/check.do',
        data: {"id":rowid},
        dataType : 'text',
        success:function(data){
        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            //alert("服务器出错，无法下载");
        }
    });

}

function uploadScienceProject() {
    $.ajax({
        type:'post',
        url:'/teachers/admin/project/requestUpload.do',
        data: "",
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
                window.location.href = "/teachers/admin/project/downloadExcel.do";
            }else{
                alert("服务器出错，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错，无法下载");
        }
    });
}

//教学科研项目导入
function inProject() {
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
    $("#addForm").attr("onsubmit", 'saveScienceProjectFile()');
}


function saveScienceProjectFile() {

    var fd = new FormData();
    var rowid = $("#fileSrc").attr("data-rowid");
    fd.append("file", $("#fileSrc").get(0).files[0]);
    fd.append("id",rowid);

    $.ajax({
        type: 'post',
        url: '/teachers/admin/project/inScienceProject.do',
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

function downlScienceProject(){
    window.location.href = "/teachers/fileTemplates/project_admin.xlsx";
}


$(function(){
    if(!checkLogin("教学科研项目审核")){ return;}
    loadReward();
})

