/**
 * Created by 陈 on 2018/5/17.
 */
function loadMessageAdmin(){
    var loadDataUrl = "/teachers/messageBoardAdmin/loadMessageBoard.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    var lastFlag;
    $("#tMessageAdminList").jqGrid({
        url: loadDataUrl,
        datatype: "json",
        height: 170,
        editable: true,
        autowidth: true,
        shrinkToFit: true,
        multiSort:true,
        rowNum: 5,
        rowList: [5, 10, 15],
        colNames: ['教师','留言内容','留言时间'],
        colModel: [
            {
                name: 'name',
                index: 'name',
                search: true,
                editable: false,
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
                name:'message',
                index:'message',
                search:true,
                editable:true,
                width:170,
                edittype:'textarea',
                editoptions:{
                    rows:"3"
                },
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'dateTime',
                index: 'dateTime',
                search: true,
                editable: false,
                width: 150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne', 'lt', 'le', 'gt']
                },
                searchrules: {
                    // required: true
                }
            }
        ],
        sortname: 'dateTime',
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
        pager: "#pagerTMessageAdminList",
        add: false,
        edit: false,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tMessageAdminList").setSelection(4, true);
    // Setup buttons
    $("#tMessageAdminList").jqGrid('navGrid', '#pagerTMessageAdminList', {
        edit: false,
        add: false,
        del: false,
        search: true,
        view: true  //是否可以以模态框显示记录
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
        var width = $('.tMessageAdmin_wrapper').width();
        $('#tMessageAdminList').setGridWidth(width);
    });
}


$(function(){
    if(!checkLogin("留言板")){ return;}
    loadMessageAdmin();
})
