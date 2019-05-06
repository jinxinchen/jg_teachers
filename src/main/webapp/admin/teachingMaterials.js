/**
 * Created by 陈 on 2017/12/10.
 */
function loadTeachingMaterials(){
    var saveUrl = "/teachers/admin/teachingMaterials/addMaterial.do";
    var deleteUrl = "/teachers/admin/teachingMaterials/deleteMaterial.do";
    var updateUrl = "/teachers/admin/teachingMaterials/editMaterial.do";
    var loadDataUrl = "/teachers/admin/teachingMaterials/loadMaterial.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    var lastFlag;
    $("#tTechingMaterialsList").jqGrid({
        url: loadDataUrl,
        datatype: "json",
        height: 170,
        editable: true,
        autowidth: true,
        shrinkToFit: true,
        multiSort:true,
        rowNum: 4,
        rowList: [5, 10, 15],
        colNames: [
            '记录id',
            'userId',
            '姓名',
            '课程名称',
            '上课学期',
            '类型',
            '查看文件',
            '上传时间',
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
            }, {
                name: 'name',
                index: 'name',
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
                name:'courseName',
                index:'courseName',
                width:150,
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
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
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
                width: 120,
                align: "left",
                editable: false,
                editrules: {
                    required: false ,
                },
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="downLoadFile(' + row.id + ','+1+')">下载</a>&nbsp;&nbsp;';
                },
            },


            {
                name:'fileTime',
                index:'fileTime',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                hidden: false,
                searchoptions: {
                    sopt: ['eq', 'ne', 'lt', 'le', 'gt']
                }
            },
        ],
        sortname: 'fileTime',
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
        pager: "#pagerTTeachingMaterialsList",
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tTechingMaterialsList").setSelection(4, true);
    // Setup buttons
    $("#tTechingMaterialsList").jqGrid('navGrid', '#pagerTTeachingMaterialsList',{
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
        var width = $('.tTeachingMaterials_wrapper').width();
        $('#tTechingMaterialsList').setGridWidth(width);
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
}

// 设置点击保存按钮后触发的事件,此处可以写成路径地址
$("#addForm").attr("onsubmit", 'saveFile()');

function saveFile() {
    var fd = new FormData();
    var rowid = $("#fileSrc").attr("data-rowid");
    fd.append("file", $("#fileSrc").get(0).files[0]);
    fd.append("id",rowid);

    $.ajax({
        type: 'post',
        url: '/teachers/admin/teachingMaterials/uploadMaterial.do',
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
function downLoadtExcel() {
    $.ajax({
        type:'post',
        url:'/teachers/admin/teachingMaterials/requestUpload.do',
        data: "",
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
                window.location.href = "/teachers/admin/teachingMaterials/downloadExcel.do";
            }else{
                alert("服务器出错，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错，无法下载");
        }
    });

}


function downLoadFile(id){
    $.ajax({
        type: 'post',
        url: '/teachers/admin/teachingMaterials/getMaterialSrcById.do',
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
    loadTeachingMaterials();
})