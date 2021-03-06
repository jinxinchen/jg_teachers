/**
 * Created by 陈 on 2018/11/26.
 */
function loadStudent(){
    var saveUrl = "/teachers/student/add.do";
    var deleteUrl = "/teachers/student/delete.do";
    var updateUrl = "/teachers/student/edit.do";
    var loadDataUrl = "/teachers/student/load.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    var lastFlag;
    $("#tStudentList").jqGrid({
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
            '年级',
            '学历',
            '班级',
            '姓名',
            '学号',
            '性别',
            '家庭详细地址',
            '联系电话',
            '邮箱',
            '任职情况',
            '获奖级别',
            '获奖形式',
            '获奖类型',
            '荣誉全称（部分荣誉需包括作品名称）',
            '授奖单位',
            '获奖时间',
            '证书上传',
            '证书下载',
            '论文级别',
            '论文题目',
            '刊号',
            '刊物证明上传',
            '刊物证明下载',
            '公共活动认证',
            '备注'
        ],

        //具体的每列的设计
        colModel: [
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
            },

            {
                name: 'eduBack',
                index: 'eduBack',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                }
            }, {
                name: 'clazz',
                index: 'clazz',
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
                name:'name',
                index:'name',
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
                name:'sno',
                index:'sno',
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
                name:'sex',
                index:'sex',
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
                name:'address',
                index:'address',
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
                name:'tel',
                index:'tel',
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
                name:'mail',
                index:'mail',
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
                name:'position',
                index:'position',
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
                width:150,
                editable: true,
                sortable: false,
                edittype: 'select',
                editoptions: {
                    dataUrl: '',
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="国家级">' + "国家级" + '</option>';
                        selectHtml += '<option value="省级">' + "省级" + '</option>';
                        selectHtml += '<option value="市级">' + "市级" + '</option>';
                        selectHtml += '<option value="校级">' + "校级" + '</option>';
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
                name:'awardShape',
                index:'awardShape',
                width:150,
                editable: true,
                sortable: false,
                edittype: 'select',
                editoptions: {
                    dataUrl: '',
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="个人">' + "个人" + '</option>';
                        selectHtml += '<option value="团队">' + "团队" + '</option>';
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
                name:'awardType',
                index:'awardType',
                width:150,
                editable: true,
                sortable: false,
                edittype: 'select',
                editoptions: {
                    dataUrl: '',
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="奖学金">' + "奖学金" + '</option>';
                        selectHtml += '<option value="科技创新">' + "科技创新" + '</option>';
                        selectHtml += '<option value="学科竞赛">' + "学科竞赛" + '</option>';
                        selectHtml += '<option value="社会实践">' + "社会实践" + '</option>';
                        selectHtml += '<option value="志愿服务">' + "志愿服务" + '</option>';
                        selectHtml += '<option value="学生工作">' + "学生工作" + '</option>';
                        selectHtml += '<option value="体育比赛">' + "体育比赛" + '</option>';
                        selectHtml += '<option value="文艺比赛">' + "文艺比赛" + '</option>';
                        selectHtml += '<option value="其他">' + "其他" + '</option>';
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
                name:'awardName',
                index:'awardName',
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
                name:'awardingUnit',
                index:'awardingUnit',
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
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="uploadAwardFile(' + row.id + ')">上传文件</a>&nbsp;&nbsp;';
                },
                width: 120,
                align: "left",
                editable: false,
            },
            {
                name: 'awardFileSrc',
                index: 'awardFileSrc',
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="downLoadAwardFile(' + row.id + ')">' + row.awardFileName + '</a>&nbsp;&nbsp;';
                },
                width: 120,
                align: "left",
                editable: false,
            },
            {
                name:'articleLevel',
                index:'articleLevel',
                width:150,
                editable: true,
                sortable: false,
                edittype: 'select',
                editoptions: {
                    dataUrl: '',
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="A类">' + "A类" + '</option>';
                        selectHtml += '<option value="B类">' + "B类" + '</option>';
                        selectHtml += '<option value="C类">' + "C类" + '</option>';
                        selectHtml += '<option value="其他">' + "其他" + '</option>';
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
                name:'articleName',
                index:'articleName',
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
                name:'issn',
                index:'issn',
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
                    return '<a href="#" onclick="uploadIssbnFile(' + row.id + ')">上传文件</a>&nbsp;&nbsp;';
                },
                width: 120,
                align: "left",
                editable: false,
            },
            {
                name: 'issnFileSrc',
                index: 'issnFileSrc',
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="downLoadIssbnFile(' + row.id + ')">' + row.issnFileName + '</a>&nbsp;&nbsp;';
                },
                width: 120,
                align: "left",
                editable: false,
            },
            {
                name:'activity',
                index:'activity',
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
            },

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
        pager: "#pagerTStudentList",
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tStudentList").setSelection(4, true);
    // Setup buttons
    $("#tStudentList").jqGrid('navGrid', '#pagerTStudentList',{
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
        var width = $('.tStudent_wrapper').width();
        $('#tStudentList').setGridWidth(width);
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
        url: 'http://192.168.213.253:8099/teachers_files/student/uploadStudent.do',
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
function uploadStudent() {
    $.ajax({
        type:'post',
        url:'/teachers/student/requestUpload.do',
        data: "",
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
                window.location.href = "/teachers/student/downloadExcel.do";
            }else{
                alert("服务器出错，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错，无法下载");
        }
    });

}
function downStudent(){
    window.location.href = "/teachers/fileTemplates/student.xlsx";
}


function inStudent() {
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
    $("#addForm").attr("onsubmit", 'saveStudent()');
}


function saveStudent() {

    var fd = new FormData();
    fd.append("file", $("#fileSrc").get(0).files[0]);

    $.ajax({
        type: 'post',
        url: '/teachers/student/inStudent.do',
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
function downLoadAwardFile(id){
    $.ajax({
        type: 'post',
        url: '/teachers/student/getAwardSrcById.do',
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
function uploadIssbnFile(rowid){
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
    $("#addForm").attr("onsubmit", 'saveIssbnFile()');
}

function saveIssbnFile() {
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
        url: 'http://192.168.213.253:8099/teachers_files/student/uploadStudentIssbn.do',
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
function downLoadIssbnFile(id){
    $.ajax({
        type: 'post',
        url: '/teachers/student/getIssbnSrcById.do',
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
    loadStudent();
})