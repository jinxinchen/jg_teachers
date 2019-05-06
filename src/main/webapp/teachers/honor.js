/**
 * Created by 陈 on 2017/10/22.
 */
function loadHonor(){
    var saveUrl = "#";
    var deleteUrl = "#";
    var updateUrl = "#";
    var loadDataUrl = "/"+projectName+"/honor/loadHonor.do";
    $.jgrid.defaults.styleUI = 'Bootstrap';
    var lastFlag;
    // var testData = [{
    //     award_method: "A",
    //     award_winner: "张三",
    //     class: "2014dsdsdsd级统计学1111",
    //     award_level: "A",
    //     award_type:"A",
    //     award_name:"奖学金",
    //     the_unit:"教育部",
    //     award_time:"2017-11-11",
    //     note:"sd"
    //
    //
    //
    // }, {
    //     award_method: "A",
    //     award_winner: "张三",
    //     class: "201dsdsdsd4级统计学",
    //     award_level: "A",
    //     award_type:"A",
    //     award_name:"奖学金",
    //     the_unit:"教育部",
    //     award_time:"2017-11-11",
    //     note:"sd"
    // }];
    $("#tHonorList").jqGrid({
        url:loadDataUrl,
        datatype:"json",
        // data:testData,
        // datatype: "local",
        height: 170,
        editable: true,
        autowidth: true,
        shrinkToFit: true,
        multiSort:true,
        rowNum: 5,
        rowList: [5, 10, 15],
        colNames:['获奖方式（A个人、B团队：团队其他成员请填写在备注栏内）团队请按负责人所在班级统一报送，如果负责人为其他学院，按第二负责人所在班级报送，以此类推',
                '获奖者','班级','获奖级别（A国家级、B省级、C市级、D校级）','获奖类型（A奖学金、B科创创新、C学科竞赛、D社会实践、E志愿服务、F学生工作、G体育比赛、H文艺比赛、I其他）',
                '荣誉全称（请根据证书上的内容写全称，部分荣誉需包括作品名称）','授奖单位','获奖时间','备注','操作'],
        colModel:[
            {
                name:'award_method',
                index:'award_method',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
                width:200,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name: 'award_winner',
                index: 'award_winner',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
                width: 150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne', 'cn', 'nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'clazz',
                index:'clazz',
                search: true,
                editable: true,
                edittype:'textarea',
                editrules: {
                    required: true
                },
                width:150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'award_level',
                index:'award_level',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
                width:150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'award_type',
                index:'award_type',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
                width:150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'award_name',
                index:'award_name',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
                width:150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'the_unit',
                index:'the_unit',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
                width:150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'awardTime',
                index:'awardTime',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
                width:150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                name:'note',
                index:'note',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
                width:150,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                searchrules: {
                    // required: true
                }
            },
            {
                viewable: false,
                sortable: false,
                formatter : 'actions', // 在每一行显示edit按钮与delete按钮
                formatoptions : {          // 按钮设定
                    url: updateUrl,  //in-line update对应的接口
                    delOptions: {
                        url: deleteUrl,  //delete对应接口
                        afterSubmit: function (response, postdata) {
                            var result = response.responseJSON.success;
                            return [result, 'fail to delete！', postdata.id];
                        }
                    }
                }
            }
        ],
        sortname: 'awardTime',
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
        pager: "#pagerTHonorList",
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#tHonorList").setSelection(4, true);
    // Setup buttons
    $("#tHonorList").jqGrid('navGrid', '#pagerTHonorList', {
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
        afterSubmit : function(response, postdata) {
            var result = response.responseJSON.success;
            return [result,'fail to delete！',postdata.id];
        }
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
        var width = $('.tHonor_wrapper').width();
        $('#tHonorList').setGridWidth(width);
    });
}

function outExcel() {
    tableExport('tHonorList', '荣誉统计表', 'xls');

}
$(function () {
    if(!checkLogin()){ return;}
    loadHonor();

})