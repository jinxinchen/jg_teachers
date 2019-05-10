/**
 * Created by 陈 on 2017/11/16.
 */


function downLoadtExcel() {
    $.ajax({
        type:'post',
        url:'/teachers/manageTeachers/requestUpload.do',
        data: "",
        dataType : 'text',
        success:function(data){
            if(data.toString()=="success"){
                window.location.href = "/teachers/manageTeachers/downloadExcel.do";
            }else{
                alert("服务器出错，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错，无法下载");
        }
    });

}

//加载教师
function  loadTeachers() {
    var loadDataUrl = "/teachers/manageTeachers/loadTeachers.do";
    var updateUrl="/teachers/manageTeachers/updateTeachers.do";
    var deleteUrl="/teachers/manageTeachers/deleteTeachers.do";
    var saveUrl="";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $("#tBaseInfoList").jqGrid({
        url: loadDataUrl,
        datatype: "json",
        editurl: 'remote',
        height: 500,
        autowidth: true,
        shrinkToFit: true,
        rowNum: 10,
        // editurl: 'clientArray',
        emptyrecords : "no record",
        viewrecords: true,
        rownumbers: true,  //是否显示行号
        multiselect: true,  //是否有多选功能
        multiSort: true,
        rowList: [10, 20, 30],
        colNames: ['id','userId','身份证号','姓名', '性别','来校报道时间','岗位类别', '联系电话','出生年月', '学位','学位类型','职称','职称等级','是否为导师','导师类型','所属系','任教专业','任职状态','详情'],
        colModel: [
            {
                name: 'id',
                index: 'id',
                search: true,
                width: 150,
                editable: true,
                hidden:true
            },
            {
                name: 'userId',
                index: 'userId',
                search: true,
                width: 150,
                editable: true,
                hidden:true
            },
            {
                name:'identityNum',
                index:'identityNum',
                search:true,
                width:150,
                editable:false
            },
            {
                name: 'name',
                index: 'name',
                search: true,
                width: 150,
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
                name: 'gender',
                index: 'gender',
                search: true,
                width: 150,
                editable: true,
                sortable: true,
                edittype: 'select',
                searchoptions: {
                    sopt: ['eq'],
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="男">' + "男" + '</option>';
                        selectHtml += '<option value="女">' + "女" + '</option>';
                        selectHtml += '</select>';
                        return selectHtml;
                    }
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'reportTime',
                index: 'reportTime',
                search: true,
                width: 150,
                editable: true,
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
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
                },
            {    name: 'positionType',
                index: 'positionType',
                search: true,
                width: 150,
                editable: true,
                sortable: true,
                edittype: 'select',
                searchoptions: {
                    sopt: ['eq'],
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="教学科研">' + "教学科研" + '</option>';
                        selectHtml += '<option value="辅导员">' + "辅导员" + '</option>';
                        selectHtml += '<option value="行政人员">' + "行政人员" + '</option>';
                        selectHtml += '<option value="实验员">' + "实验员" + '</option>';
                        selectHtml += '</select>';
                        return selectHtml;
                    }
                },
                searchrules: {
                    // required: true
                }
                },
            {
                name: 'phoneNum',
                index: 'phoneNum',
                search: true,
                width: 150,
                editable: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc'],
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'birthday',
                index: 'birthday',
                editable:true,width:180,sorttype:"date",formatter:"date",
                editrules: {
                    required: true
                },
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
                name: 'degree',
                index: 'degree',
                search: true,
                width: 150,
                editable: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc'],
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'degreeType',
                index: 'degreeType',
                search: true,
                width: 150,
                editable: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc'],
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'educateDegreeName',
                index: 'educateDegreeName',
                search: true,
                width: 150,
                editable: true,
                sortable: true,
                edittype: 'select',
                searchoptions: {
                    sopt: ['eq'],
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="教授">' + "教授" + '</option>';
                        selectHtml += '<option value="副教授">' + "副教授" + '</option>';
                        selectHtml += '<option value="讲师">' + "讲师" + '</option>';
                        selectHtml += '<option value="研究员">' + "研究员" + '</option>';
                        selectHtml += '<option value="副研究员">' + "副研究员" + '</option>';
                        selectHtml += '<option value="助理研究员">' + "助理研究员" + '</option>';
                        selectHtml += '<option value="实习研究员">' + "实习研究员" + '</option>';
                        selectHtml += '<option value="无">' + "无" + '</option>';
                        selectHtml += '</select>';
                        return selectHtml;
                    }
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'educateDegreeLevel',
                index: 'educateDegreeLevel',
                search: true,
                width: 150,
                editable: true,
                sortable: true,
                edittype: 'select',
                searchoptions: {
                    sopt: ['eq'],
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="一级">' + "一级" + '</option>';
                        selectHtml += '<option value="二级">' + "二级" + '</option>';
                        selectHtml += '<option value="三级">' + "三级" + '</option>';
                        selectHtml += '<option value="四级">' + "四级" + '</option>';
                        selectHtml += '<option value="五级">' + "五级" + '</option>';
                        selectHtml += '<option value="六级">' + "六级" + '</option>';
                        selectHtml += '<option value="七级">' + "七级" + '</option>';
                        selectHtml += '<option value="八级">' + "八级" + '</option>';
                        selectHtml += '<option value="九级">' + "九级" + '</option>';
                        selectHtml += '<option value="十级">' + "十级" + '</option>';
                        selectHtml += '<option value="十一级">' + "十一级" + '</option>';
                        selectHtml += '<option value="十二级">' + "十二级" + '</option>';
                        selectHtml += '<option value="无">' + "无" + '</option>';
                        selectHtml += '</select>';
                        return selectHtml;
                    }
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'isMentor',
                index: 'isMentor',
                search: true,
                width: 150,
                editable: true,
                sortable: true,
                edittype: 'select',
                searchoptions: {
                    sopt: ['eq'],
                    buildSelect: function (responseData) {
                        var selectHtml = '<select><option></option>';
                        selectHtml += '<option value="是">' + "是" + '</option>';
                        selectHtml += '<option value="否">' + "否" + '</option>';
                        selectHtml += '</select>';
                        return selectHtml;
                    }
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'mentorType',
                index: 'mentorType',
                search: true,
                width: 180,
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
                name: 'major',
                index: 'major',
                search: true,
                width: 150,
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
                name: 'forClass',
                index: 'forClass',
                search: true,
                width: 180,
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
                name: 'officeStatus',
                index: 'officeStatus',
                search: true,
                width: 180,
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
                width: 150,
                align: "center",
                search:false,
                sortable: false,
                formatter: function (cellvalue, options, row) {
                    return '<a href="#" onclick="showDetail(\'' + row.userId + '\')">查看详情</a>&nbsp;&nbsp;';
                }
            }
        ],
        pager: "#pagerTBaseInfoList",
        sortname: 'name',
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

        pager: "#pagerTBaseInfoList",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false

    });


    // Add selection
    $("#tBaseInfoList").setSelection(4, true);

    $("#tBaseInfoList").jqGrid('navGrid', '#pagerTBaseInfoList', {
        edit: true,
        add: false,
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
    },{
        //delete按钮选项
        url: deleteUrl,  //delete对应接口
        serializeEditData: function(postData) {
            postData.id = postData.userId;
            return postData;
        },
        afterSubmit : function(response, postdata) {
            console.log(response)
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
        var width = $('.tBaseInfo_wrapper').width();
        $('#tBaseInfoList').setGridWidth(width);
    });

}

function tableToExcel(){
    //要导出的json数据
    jsonData = [];
    var ids=$('#tBaseInfoList').jqGrid('getGridParam','selarrrow');
    for(i=0;i<ids.length;i++){
        jsonData.push($("#tBaseInfoList").jqGrid('getRowData',ids[i]))
    }

    //列标题，逗号隔开，每一个逗号就是隔开一个单元格
    str = '身份证号,姓名,性别,来校报道时间,岗位类别,联系电话,出生年月,学位,学位类型,职称,职称等级,是否为导师,导师类型,所属系,任教专业,任职状态\n';
    ExportItem = ['identityNum','name','gender','reportTime', 'positionType','phoneNum','birthday','degree','degreeType','educateDegreeName', 'educateDegreeLevel','isMentor','mentorType','major','forClass','officeStatus']

    //增加\t为了不让表格显示科学计数法或者其他格式
    for(i = 0 ; i < jsonData.length ; i++ ){
        for( item in ExportItem){
            str+=jsonData[i][ExportItem[item]]+ '\t'+",";
        }
        str+='\n';
    }
    //encodeURIComponent解决中文乱码
    uri = 'data:text/csv;charset=utf-8,\ufeff' + encodeURIComponent(str);
    //通过创建a标签实现
    link = document.createElement("a");
    link.href = uri;
    //对下载的文件命名
    link.download =  "教师信息.csv";
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}
function showDetail(id) {
    // alert(id)
    window.location.href = 'baseInfo.html?id=' + id;
}

//初始化页面
$(function () {
    if(!checkLogin("教师管理")){ return;}
    loadTeachers();
})
