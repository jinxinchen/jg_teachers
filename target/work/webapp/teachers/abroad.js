function loadInfo(){
	
}

function loadAbroadExp(){
	var saveUrl = "#";
    var deleteUrl = "#";
    var updateUrl = "#";
    var loadDataUrl = "#";
	$.jgrid.defaults.styleUI = 'Bootstrap';
    var lastFlag;
    var testData = [{
            country: "美国",
            school: "哈佛大学",
            time: "2017.01.01-2017.06.30",
            content: "进修",
            addTime:"2017.06.30"
        }, {
        	country: "美国",
            school: "哈佛大学",
            time: "2017.01.01-2017.06.30",
            content: "进修",
            addTime:"2017.06.30"
        }];
    $("#tAbroadExList").jqGrid({
//      url: loadDataUrl,
//		datatype: "json",
		data:testData,
        datatype: "local",
        height: 170,
        editable: true,
        autowidth: true,
        shrinkToFit: true,
        multiSort:true,
        rowNum: 5,
        rowList: [5, 10, 15],
        colNames: ['交流国家', '学校', '时间段', '详情', '添加时间','操作'],
        colModel: [
            {
                name: 'country',
                index: 'country',
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
                name: 'school',
                index: 'school',
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
                name: 'time',
                index: 'time',
                search: true,
                width: 150,
                sortable: true,
                editable: true,
                edittype: 'select',
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
                stype: 'select',
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
                name: 'content',
                index: 'content',
                width: 90,
                stype: 'integer',
                editable: true,
                editrules: {
                    required: true,
                    integer: true
                },
                search: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne', 'lt', 'le', 'gt']
                },
                searchrules: {
                    required: true,
                    integer: true
                }
            },
            {
                name: 'addTime',
                index: 'addTime',
                width: 90,
                stype: 'integer',
                editable: true,
                editrules: {
                    required: true,
                    integer: true
                },
                search: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne', 'lt', 'le', 'gt']
                },
                searchrules: {
                    required: true,
                    integer: true
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
        sortname: 'addTime',
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
        pager: "#pagerTAbroadExList",
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });
    
    // Add selection
    $("#tAbroadExList").setSelection(4, true);
    // Setup buttons
    $("#tAbroadExList").jqGrid('navGrid', '#pagerTAbroadExList', {
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
        var width = $('.tAbroadEx_wrapper').width();
        $('#tAbroadExList').setGridWidth(width);
    });
}

$(function(){
	loadAbroadExp();
})
