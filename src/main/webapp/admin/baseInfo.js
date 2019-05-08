
var userId = getQueryString("id");
var userQs = "id=" + userId;
//前缀url, http://192.168.213.253:8099/teachers_files/
//        http://localhost:8099/teachers_files/
var preUrl = "http://localhost:8099/teachersFile/";
var userQs1 = "userId=" + userId;
//加载基本信息
function loadBaseInfo() {
    $.ajax({
        type:"GET",
        url:"/teachers/baseInfo/getBaseInfo.do"+ "?" + userQs,
        async:true,
        success:function (e) {

            if(e[0] != null){
               $("#baseInfoForm input[name='name']").val(e[0].name);
                $("#baseInfoForm input[name='birthday']").val(e[0].birthday );
                $("#baseInfoForm input[name='identityNum']").val(e[0].identityNum );
                $("#baseInfoForm input[name='email']").val(e[0].email );
                $("#baseInfoForm input[name='phoneNum']").val(e[0].phoneNum );
                $("#baseInfoForm input[name='address']").val(e[0].address );
                $("#degreeConfirm").attr('src',e[0].degreeConfirm);
                $("#office_status").val(e[0].officeStatus);
                $("#identityPic").attr('src',e[0].identityPic);
                if(e[0].gender == "男"){
                    $("#gender1").attr("checked","checked");
                }else if(e[0].gender == "女"){
                    $("#gender2").attr("checked","checked");
                }

                if(e[0].isMoreLangue == 1){
                    $("#yesmorelanguage").attr("checked","checked");
                }else if(e[0].isMoreLangue == 0){
                    $("#nomorelanguage").attr("checked","checked");
                }

                $("#degree").val(e[0].degree);
                $("#degreeType").val(e[0].degreeType);

                $("#baseInfoForm").attr("onsubmit","updateBaseInfo()");
                $("#baseInfoBt").html("更新");
            }else{
                $("#baseInfoForm").attr("onsubmit", "saveBaseInfo()");
                $("#baseInfoBt").html("保存");
            }



        }
    })
}



function updateBaseInfo(){
    var updateUrl = "/teachers/baseInfo/updateBaseInfo.do"
    var formData = new FormData(document.getElementById("baseInfoForm"));
    console.log(formData)
    if (!checkIdentity()) {
        return;
    }
    if (!checkMail()) {
        return;
    }
    if (!checkPhone()) {
        return;
    }
    $.ajax({
        type:'post',
        url: updateUrl,
        async: false,
        processData: false,
        contentType: false,
        data: formData,
        // datatype:json,
        success:function(res){
            alert("更新成功");
            console.log(res)
        },
        error:function(e){
            alert("更新失败");
            console.log(e)
        }
    })
}

function saveBaseInfo(){
    var saveUrl = "/teachers/baseInfo/saveBaseInfo.do";
    var formdata = new FormData(document.getElementById("baseInfoForm"));
    $.ajax({
        type:'post',
        url: saveUrl,
        async: false,
        xhrFields: {
            withCredentials: true
        },
        processData: false,
        contentType: false,
        data: formdata,
        success:function(res){
            alert("保存成功");
            console.log(res)
        },
        error:function(e){
            alert("保存失败");
            console.log(e)
        }
    })
}

function uploadIdentityFile(){
    //清空form弹窗内内容
    $("#addFormContent").html("");


    // 往form中塞入输入域
    var content = "<div class='form-group' id='enterCourse'></div>\n"+
        "                            <div class=\"form-group\">\n" +
        "                                <label class=\"col-sm-3 control-label\">上传照片：</label>\n" +
        "                                <div class=\"col-sm-8\" style=\"display:inline-flex\">\n" +
        "                                    <input id=\"fileSrc\" type=\"file\" name=\"fileSrc\" required=\"\" style=\"display: none\" onchange='tran_value()'>\n" +
        "                                    <input style=\"width: 180px;margin-right: 20px;\" id=\"fileName\" name=\"fileName\" readonly=\"true\"  aria-required=\"true\"  class=\"form-control\" required=\"\">\n" +
        "                                    <button type=\"button\" class=\"btn btn-w-m btn-default\" onclick=\"fileSrc.click()\" style=\"height: 30px;text-align: center\">上传</button>\n" +
        "                                </div>\n" +
        "                            </div>";
    $("#addFormContent").html(content);
    $("#addFormModel").modal();

    // 设置点击保存按钮后触发的事件,此处可以写成路径地址
    $("#addForm").attr("onsubmit", 'saveIdentityFile()');
}

function saveIdentityFile() {
    var fd = new FormData();
    fd.append("file", $("#fileSrc").get(0).files[0]);

    var formData = new FormData(document.getElementById("baseInfoForm"));
    var user_id;
    var id;
    //id
    $.ajax({
        type: 'post',
        url: '/teachers/baseInfo/getUserIdAndIdForAdmin.do'+ "?" + userQs,
        async: false,

        xhrFields: {
            withCredentials: true
        },
        processData: false,
        contentType: false,
        // dataType: 'json',
        success:function(data){
            id = data.id;
        },
        error:function(e){
            console.log(e)
        }
    })

}



function loadEduExp(){
	var saveUrl = "/"+projectName+"/education/addEduExp.do"+ "?" + userQs1;
    var deleteUrl = "/"+projectName+"/education/deleteEduExp.do"+ "?" + userQs1;
    var updateUrl = "/"+projectName+"/education/editEduExp.do"+ "?" + userQs1;
    var loadDataUrl = "/"+projectName+"/education/loadEduExp.do"+ "?" + userQs1;
	$.jgrid.defaults.styleUI = 'Bootstrap';
    var lastFlag;
    $("#tEduExList").jqGrid({
        url: loadDataUrl,
		datatype: "json",
        mtype: 'GET',
        height: 170,
        editable: true,
        autowidth: true,
        shrinkToFit: true,
        multiSort:true,
        rowNum: 5,
        rowList: [5, 10, 15],
        colNames: ['学校', '专业', '教育背景', '入学年份','毕业年份','学位证书', '海外留学经历'],
        colModel: [
            {
                name: 'school',
                index: 'school',
                search: true,
                editable: true,
                editrules: {
                    required: true
                },
                width: 150,
                sortable: false,
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
                editable: true,
                editrules: {
                    required: true
                },
                search: true,
                width: 150,
                sortable: false,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                }
            },
            {
                name: 'education',
                index: 'education',
                search: true,
                width: 150,
                sortable: false,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                },
                editrules: {
                    required: true
                },
            },
            {
                name: 'entrance',
                index: 'entrance',
                editable:true,width:200,sorttype:"date",formatter:"date",
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
                name: 'graduationYear',
                index: 'graduationYear',
                editable:true,width:200,sorttype:"date",formatter:"date",
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
                name: 'degreeCard',
                index: 'degreeCard',
                formatter:function (cellvalue, options, row) {
                    var s=row.degreeCard;
                    if(s!=null) {
                        var index = s.lastIndexOf("\/");
                        s = s.substring(index + 1, s.length);
                    }
                    if(s == undefined){
                        s=null;
                    }
                    return '<a href='+row.degreeCard+' >'+s+'</a>&nbsp;&nbsp;';;
                },
            },
            {
                name: 'abroad',
                index: 'abroad',
                search: true,
                width: 150,
                sortable: false,
                editable: true,
                searchoptions: {
                    sopt: ['eq', 'ne','cn','nc']
                }
            }
        ],
        sortname: 'graduationYear',
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
        pager: "#pagerTEduExList",
        add: false,
        edit: false,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });
    
    // Add selection
    $("#tEduExList").setSelection(4, true);
    // Setup buttons
    $("#tEduExList").jqGrid('navGrid', '#pagerTEduExList', {
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
            console.log(response)
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
        var width = $('.tEduEx_wrapper').width();
        $('#tEduExList').setGridWidth(width);
    });

}

function loadWorkExp() {
	var saveUrl = "/"+projectName+"/work/addWorkExp.do"+ "?" + userQs1;
    var deleteUrl = "/"+projectName+"/work/deleteWorkExp.do"+ "?" + userQs1;
    var updateUrl = "/"+projectName+"/work/editWorkExp.do"+ "?" + userQs1;
    var loadDataUrl = "/"+projectName+"/work/loadWorkExp.do"+ "?" + userQs1;
	$.jgrid.defaults.styleUI = 'Bootstrap';
    var lastFlag;
    $("#tWorkExList").jqGrid({
        url: loadDataUrl,
		datatype: "json",
        mtype: 'GET',
        height: 170,
        editable: true,
        autowidth: true,
        shrinkToFit: true,
        multiSort:true,
        rowNum: 4,
        rowList: [5, 10, 15],
        colNames: ['单位', '职称', '工作部门', '工作岗位', '工作内容', '开始时间','结束时间'],
        colModel: [
            {
                name: 'organization',
                index: 'organization',
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
                name:'professionalTitle',
                index:'professionalTitle',
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
                name: 'department',
                index: 'department',
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
                name: 'post',
                index: 'post',
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
                name: 'content',
                index: 'content',
                width: 90,
                // stype: 'integer',
                editable: true,
                editrules: {
                    required: true,
                },
                search: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne', 'lt', 'le', 'gt']
                },
                searchrules: {
                    required: true,
                }
            },
            {
                name: 'startTime',
                index: 'startTime',
                width: 90,
                stype: 'integer',
                editable: true,
                editrules: {
                    required: true,
                },
                search: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne', 'lt', 'le', 'gt']
                },
                searchrules: {
                    required: true,
                }
            },
            {
                name: 'endTime',
                index: 'endTime',
                width: 90,
                stype: 'integer',
                editable: true,
                editrules: {
                    required: true,
                },
                search: true,
                sortable: true,
                searchoptions: {
                    sopt: ['eq', 'ne', 'lt', 'le', 'gt']
                },
                searchrules: {
                    required: true,
                }
            }
        ],
        sortname: 'endTime',
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
        pager: "#pagerTWorkExList",
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });
    
    // Add selection
    $("#tWorkExList").setSelection(4, true);
    // Setup buttons
    $("#tWorkExList").jqGrid('navGrid', '#pagerTWorkExList', {
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
            var result = 'success';
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
        var width = $('.tWorkEx_wrapper').width();
        $('#tWorkExList').setGridWidth(width);
    });
}


function outExcel() {
    tableExport('tEduExList', '1', 'xls');

}

//degree
function loadDegree() {
    $.ajax({
        type:"GET",
        url:"/teachers/degree/loadDegreeInfo.do"+ "?" + userQs,
        async:true,
        success:function (e) {
            console.log(e[0].userId);
            if(e[0] == null){
                var html = '<span>无文件</span>&nbsp;&nbsp;';
                $("#educateDegreeSrc").append(html)

                $("#degreeInfoForm").attr("onsubmit", "savedegreeInfo()");
                $("#degreeInfoBt").html("保存");
            }else{
                $("#degreeInfoForm input[name='userId']").val(e[0].userId);

                $("#degreeInfoForm input[name='educateTime']").val(e[0].educateTime);
                $("#degreeInfoForm input[name='reportTime']").val(e[0].reportTime);

                $("#degreeInfoForm input[name='educateDegreeName']").val(e[0].educateDegreeName);
                $("#degreeInfoForm input[name='major']").val(e[0].major);
                $("#degreeInfoForm input[name='forClass']").val(e[0].forClass);
                $("#degreeInfoForm input[name='adminFunction']").val(e[0].adminFunction);
                $("#degreeInfoForm input[name='research']").val(e[0].research);
                $("#degreeInfoForm input[name='socialFunction']").val(e[0].socialFunction);

                //导师情况
                if(e[0].isMentor == 1){
                    $("#is_mentor").attr("checked","checked");
                }else if(e[0].isMentor == 0){
                    $("#not_mentor").attr("checked","checked");
                }



                if(e[0].educateDegreeSrc != null){
                    var html = '<a href="#" onclick="downLoadFile()">' + e[0].fileName + '</a>&nbsp;&nbsp;';
                    $("#educateDegreeSrc").append(html)
                }else{
                    var html = '<span>无文件</span>&nbsp;&nbsp;';
                    $("#educateDegreeSrc").append(html)
                }


                if(e[0].mentorFileName != null){
                    var html = '<a href="#" onclick="downLoadMentorFile()">' + e[0].mentorFileName + '</a>&nbsp;&nbsp;';
                    $("#mentorEvidenceSrc").append(html)
                }else{
                    var html = '<span>无文件</span>&nbsp;&nbsp;';
                    $("#mentorEvidenceSrc").append(html)
                }


                $("#mentorType").val(e[0].mentorType);
                $("#major").val(e[0].major);
                $("#position_type").val(e[0].positionType);
                $("#educate_degree_level").val(e[0].educateDegreeLevel);
                //上传佐证
                if(e[0].educateDegreeSrc != null){
                    $("#educate_degree_src_img").attr('src',e[0].educateDegreeSrc);

                }else{
                    $("#educate_degree_src").css('display','block');
                }

                $("#degreeInfoForm").attr("onsubmit", "updatedegreeInfo()");
                $("#degreeInfoBt").html("更新");
            }
        }
    })
}

function savedegreeInfo(){
    var formdata = new FormData(document.getElementById("degreeInfoForm"));

    $.ajax({
        type:"post",
        url:"/teachers/degree/saveDegreeInfo.do",
        processData: false,
        contentType: false,
        data: formdata,
        async:false,
        success:function (e) {
            fd.append("user_id",userId);
            fd.append("id",id);

            $.ajax({
                type: 'post',
                url: preUrl+'baseInfoFile/uploadIdentityPic.do',
                async: false,
                data: fd,
                xhrFields: {
                    withCredentials: true
                },
                processData: false,
                contentType: false,
                // dataType: 'json',
                success:function(data){
                    alert("保存成功");
                    console.log(data)
                },
                error:function(e){
                    alert("保存失败");
                    console.log(e)
                }
            })
            console.log(e)
        }
    })
}

function updatedegreeInfo(){
    var formdata = new FormData(document.getElementById("degreeInfoForm"));
    formdata.append("id",userId);
    console.log(formdata)
    $.ajax({
        type:"post",
        url:"/teachers/degree/updateDegreeInfo.do",
        processData: false,
        contentType: false,
        data: formdata,
        async:false,
        dataType: 'json',
        success:function (e) {
            alert("更新成功");
            //console.log(e)
            //console.log(123)
        },
        error:function(e){
            alert("更新失败");
            //console.log(e)

            //onsole.log(123+"wrong")
        }
    })
}

function uploadFile(){
    // console.log(rowid)
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
        url: '/teachers/degree/uploadDegree.do',
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

function downLoadFile(){
    $.ajax({
        type: 'post',
        url: '/teachers/degree/getDegreeSrcById.do',
        // async: false,
        xhrFields: {
            withCredentials: true
        },
        success:function(data){
            console.log(data)
            window.location.href = data;
        },
        error:function(e){
            console.log(e)
        }
    })

}

//导师文件
function uploadMentorFile(){
    // console.log(rowid)
    //清空form弹窗内内容
    $("#addFormContent").html("");


    // 往form中塞入输入域
    var content = "<div class='form-group' id='enterCourse'></div>\n"+
        "                            <div class=\"form-group\">\n" +
        "                                <label class=\"col-sm-3 control-label\">选择文件：</label>\n" +
        "                                <div class=\"col-sm-8\" style=\"display:inline-flex\">\n" +
        "                                    <input id=\"mentorFileSrc\" type=\"file\" name=\"mentorFileSrc\" required=\"\" style=\"display: none\" onchange='tran_value_mentor()'>\n" +
        "                                    <input style=\"width: 180px;margin-right: 20px;\" id=\"MentorFileName\" name=\"MentorFileName\" readonly=\"true\"  aria-required=\"true\"  class=\"form-control\" required=\"\">\n" +
        "                                    <button type=\"button\" class=\"btn btn-w-m btn-default\" onclick=\"mentorFileSrc.click()\" style=\"height: 30px;text-align: center\">上传</button>\n" +
        "                                </div>\n" +
        "                            </div>";
    $("#addFormContent").html(content);
    $("#addFormModel").modal();
    // 设置点击保存按钮后触发的事件,此处可以写成路径地址
    $("#addForm").attr("onsubmit", 'saveMentorFile()');
}



function saveMentorFile() {
    var fd = new FormData();
    fd.append("file", $("#mentorFileSrc").get(0).files[0]);

    $.ajax({
        type: 'post',
        url: '/teachers/degree/uploadDegreeMentor.do',
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

function tran_value_mentor() {

    $("#MentorFileName").val($("#mentorFileSrc").val());
}

function downLoadMentorFile(){
    $.ajax({
        type: 'post',
        url: '/teachers/degree/getDegreeMentorSrcById.do',
        // async: false,
        xhrFields: {
            withCredentials: true
        },
        success:function(data){
            console.log(data)
            window.location.href = data;
        },
        error:function(e){
            console.log(e)
        }
    })

}

function uploadFileDegree(degreeId){
    //清空form弹窗内内容
    $("#addFormContent").html("");


    // 往form中塞入输入域
    var content = "<div class='form-group' id='enterCourse'></div>\n"+
        "                            <div class=\"form-group\">\n" +
        "                                <label class=\"col-sm-3 control-label\">上传文件：</label>\n" +
        "                                <div class=\"col-sm-8\" style=\"display:inline-flex\">\n" +
        "                                    <input id=\"fileSrc\" type=\"file\" name=\"fileSrc\" required=\"\" style=\"display: none\" onchange='tran_value()'>\n" +
        "                                    <input style=\"width: 180px;margin-right: 20px;\" id=\"fileName\" name=\"fileName\" readonly=\"true\"  aria-required=\"true\"  class=\"form-control\" required=\"\">\n" +
        "                                    <button type=\"button\" class=\"btn btn-w-m btn-default\" onclick=\"fileSrc.click()\" style=\"height: 30px;text-align: center\">上传</button>\n" +
        "                                </div>\n" +
        "                            </div>";
    $("#addFormContent").html(content);
    $("#addFormModel").modal();
    $("#addForm").attr("onsubmit", 'saveDegreeFile('+degreeId.toString()+')');
}
function saveDegreeFile(degreeId) {
    var fd = new FormData();
    fd.append("file", $("#fileSrc").get(0).files[0]);
    fd.append("user_id",userId);
    fd.append("id",degreeId);
    $.ajax({
        type: 'post',
        //url: 'http://127.0.0.1:8099/teachersFile/baseInfoFile/uploadDegreeCard.do',
        url: preUrl+'baseInfoFile/uploadDegreeCard.do',
        async: false,
        data: fd,
        xhrFields: {
            withCredentials: true
        },
        processData: false,
        contentType: false,
        // dataType: 'json',
        success:function(data){
            console.log(data)
            console.log(data.id)
        },
        error:function(e){
            console.log(e)
        }
    })
}

//y验证邮箱
function checkMail() {
    var obj = document.getElementById("email").value;
    if (obj.length == 0){
        return true;
    }
    if(!obj.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
        alert("请输入有效合法的邮箱地址！");
        return false;
    }
    return true;
}

//验证身份证
function checkIdentity() {
    var obj = document.getElementById("identity").value;
    if(obj.length == 0){
        return true;
    }
    if(!obj.match(/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/)){
        alert("有效合法的身份证号码！");
        return false;
    }
    return true;
}

//验证手机号
function checkPhone(){
    var phone = document.getElementById('tel').value;
    if (phone.length == 0){
        return true;
    }
    if(!(/^1(3|4|5|7|8)\d{9}$/.test(phone))){
        alert("请输入有效合法的手机号码！");
        return false;
    }
    return true;
}
$(function(){
    if(!checkLogin()){ return;}
    loadBaseInfo();
	loadEduExp();
	loadWorkExp();
    loadDegree();
})
