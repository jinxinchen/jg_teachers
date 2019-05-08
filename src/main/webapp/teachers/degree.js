/**
 * Created by 陈 on 2017/11/5.
 */
function load() {
    $.ajax({
        type:"GET",
        url:"/teachers/degree/loadDegreeInfo.do",
        async:true,
        success:function (e) {
            console.log(e)
            if(e[0] == null){
                var html = '<span>无文件</span>&nbsp;&nbsp;';
                $("#educateDegreeSrc").append(html)

                $("#degreeInfoForm").attr("onsubmit", "savedegreeInfo()");
                $("#degreeInfoBt").html("保存");
            }else{
                $("#degreeInfoForm input[name='educateTime']").val(e[0].educateTime);
                $("#degreeInfoForm input[name='reportTime']").val(e[0].reportTime);
                $("#degreeInfoForm input[name='educateDegreeName']").val(e[0].educateDegreeName);
                $("#degreeInfoForm input[name='major']").val(e[0].major);
                $("#degreeInfoForm input[name='forClass']").val(e[0].forClass);
                $("#degreeInfoForm input[name='adminFunction']").val(e[0].adminFunction);
                $("#degreeInfoForm input[name='research']").val(e[0].research);
                $("#degreeInfoForm input[name='socialFunction']").val(e[0].socialFunction);

                //导师情况
                if(e[0].isMentor == "是"){
                    $("#is_mentor").attr("checked","checked");
                }else if(e[0].isMentor == "否"){
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
                $("#educate_degree_name").val(e[0].educateDegreeName);
                $("#educate_degree_level").val(e[0].educateDegreeLevel);
                $("#position_type").val(e[0].positionType);
                $("#forClass").val(e[0].forClass);

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

            console.log(e)
        }
    })
}

function updatedegreeInfo(){
    var formdata = new FormData(document.getElementById("degreeInfoForm"));
    console.log(formdata);
    $.ajax({
        type:"post",
        url:"/teachers/degree/updateDegreeInfo.do",
        processData: false,
        contentType: false,
        data: formdata,
        async:false,
        dataType: 'json',
        success:function (e) {
            console.log(e)
        },
        error:function(e){
            console.log(e)
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
    var user_id;
    var id;
    //获取user_id和degree_id
    $.ajax({
        type: 'post',
        url: '/teachers/degree/getUserIdAndDegreeId.do',
        async: false,

        xhrFields: {
            withCredentials: true
        },
        processData: false,
        contentType: false,
        // dataType: 'json',
        success:function(data){
            id = data.id;
            user_id = data.user_id
        },
        error:function(e){
            console.log(e)
        }
    })
    fd.append("user_id",user_id);
    fd.append("id",id);
    $.ajax({
        type: 'post',
        //url: 'http://127.0.0.1:8099/teachersFile/degree/uploadDegree.do',
        url: 'http://192.168.213.253:8099/teachers_files/degree/uploadDegree.do',
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
    var user_id;
    var id;
    //获取user_id和degree_id
    $.ajax({
        type: 'post',
        url: '/teachers/degree/getUserIdAndDegreeId.do',
        async: false,

        xhrFields: {
            withCredentials: true
        },
        processData: false,
        contentType: false,
        // dataType: 'json',
        success:function(data){
            id = data.id;
            user_id = data.user_id
        },
        error:function(e){
            console.log(e)
        }
    })
    fd.append("user_id",user_id);
    fd.append("id",id);
    $.ajax({
        type: 'post',
        url: 'http://192.168.213.253:8099/teachers_files/degree/uploadDegreeMentor.do',
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

$(function () {
    if(!checkLogin("职位信息")){ return;}
    load();
})
