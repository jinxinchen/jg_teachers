/**
 * Created by 陈 on 2017/11/16.
 */
function loadTech(){
    var loadDataUrl = "/teachers/tech/loadTech.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    var lastFlag;

    $("#tTechList").jqGrid({
        url: loadDataUrl,
        datatype: "json",
        height: 370,
        editable: true,
        autowidth: true,
        shrinkToFit: true,
        multiSort:true,
        rowNum: 4,
        rowList: [5, 10, 15],
        colNames: ['项目编号','年度', '项目级别', '项目类别','项目名称','经费','负责人','单位','状态','操作'],
        colModel: [
            {
                name: 'techId',
                index: 'techId',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
                width: 90,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'time',
                index: 'time',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
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
                name: 'level',
                index: 'level',
                editable: true,
                editrules: {
                    required: true
                },
                search: true,
                width: 150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne']
                }
            },
            {
                name: 'type',
                index: 'type',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                // edittype: 'select',
//              editoptions: {
////                  dataUrl: '/' + project_name + '/teacher/education/listNames.do',
//                  buildSelect: function (responseData) {
////                      var response = $.parseJSON(responseData);
////                      var data = response.data;
//						var data =['本科','硕士','博士','博士后'];
//                      var selectHtml = '<select><option></option>';
//                      for (var i = 0; i < data.length; i++) {
//                          var dataValue = data[i];
//                          selectHtml += ('<option value="' + dataValue + '">' + dataValue + '</option>');
//                      }
//                      selectHtml += '</select>';
//                      return selectHtml
//                  }
//              },
                editrules: {
                    required: true
                },
                // stype: 'select',
//              searchoptions: {
//                  sopt: ['eq', 'ne'],
////                  dataUrl: '/' + project_name + '/teacher/education/listNames.do',
////                  buildSelect: function (responseData) {
////                      var response = $.parseJSON(responseData);
////                      var data = response.data;
//						var data =['本科','硕士','博士','博士后'];
//                      var selectHtml = '<select><option></option>';
//                      for (var i = 0; i < data.length; i++) {
//                          var dataValue = data[i];
//                          selectHtml += ('<option value="' + dataValue + '">' + dataValue + '</option>');
//                      }
//                      selectHtml += '</select>';
//                      return selectHtml
////                  }
//              }
            },
            {
                name: 'name',
                index: 'name',
                width: 90,
                editable: true,
                editrules: {
                    required: true
                },
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
                name: 'funds',
                index: 'funds',
                width: 90,
                editable: true,
                editrules: {
                    required: true
                },
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
                name: 'leadPeople',
                index: 'leadPeople',
                width: 90,
                editable: true,
                editrules: {
                    required: true
                },
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
                name: 'office',
                index: 'office',
                width: 90,
                editable: true,
                editrules: {
                    required: true
                },
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
                name: 'status',
                index: 'status',
                width: 120,
                // stype: 'integer',
                editable: true,
                editrules: {
                    required: true,
                    // integer: true
                },
                search: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne', 'lt', 'le', 'gt']
                },
                searchrules: {
                    required: true,
                    // integer: true
                }
            },
            {
                viewable: false,
                sortable: false,
                align:"center",
                formatter:function (cellvalue, options, row) {
                    return '<a href="#" onclick="passTech(' + row.id + ')">通过</a>&nbsp;&nbsp;';
                }
            }
        ],
        sortname: 'time',
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
        pager: "#pagerTTechList",
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tTechList").setSelection(4, true);
    // Setup buttons
    $("#tTechList").jqGrid('navGrid', '#pagerTTechList', {
        edit: false,
        add: false,
        del: false,
        search: true,
        view: true  //是否可以以模态框显示记录
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
        var width = $('.tTech_wrapper').width();
        $('#tTechList').setGridWidth(width);
    });
}

function passTech(id) {

}

function uploadTech() {
    $.ajax({
        type:'post',
        url:'/teachers/adminArticle/requestTechUpload.do',
        data: "",
        dataType : 'text',
        success:function(data){
            console.log(data)
            if(data.toString()=="success"){
                window.location.href = "/teachers/adminArticle/downloadCopyRightExcel.do";
            }else{
                alert("服务器出错2，无法下载")
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown){
            alert("服务器出错1，无法下载");
        }
    });
}
loadTech()
