/**
 * Created by 陈 on 2017/10/13.
 */

var projectName = "teachers";
//将js对象填充入form表单
function loadData(form,obj) {
    console.log(obj);
    for(var attr in obj ){
        // if(typeof(obj[attr] == 'function')){
        //     continue;
        // }
        console.log(attr);
        //inpupt输入框
        var $input = $("#" + form + " input[name='"+attr+"']");
        var type = $input.attr("type");
        if(type=="checkbox" ||type=="radio"){
            if (obj[attr] != null && obj[attr] != "") {
                var avalues = obj[attr].split(",");
                for(var v=0; v<avalues.length;v++){
                    $input.each(function(i,n){
                        var value = $(n).val();
                        if(value == avalues[v]){
                            $(n).attr("checked","checked");
                        }
                    });
                }
            }

        }else{
            $input.val(obj[attr]);
        }

        //textArea输入框
        var $textArea = $("#" + form + " textarea[name='"+attr+"']");
        $textArea.html(obj[attr]);
        //select
        var $select = $("#" + form + " select[name='"+attr+"'] " + " option[value='" + obj[attr] + "']");
        $select.attr("selected","selected");
    }
}
function loadNoticeModal() {
    var noticeModal = "<div class=\"modal fade\" id=\"noticeModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n"+
        "        <div class=\"modal-dialog\">\n"+
        "            <div class=\"modal-content\">\n"+
        "                <div class=\"modal-header\">\n"+
        "                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">\n"+
        "                        &times;\n"+
        "                    </button>\n"+
        "                    <h4 class=\"modal-title\" id=\"myModalLabel\">\n"+
        "                        Tips\n"+
        "                    </h4>\n"+
        "                </div>\n"+
        "                <div id=\"modalContent\" class=\"modal-body\" style='color: #000000'>\n"+
        "                    \n"+
        "                </div>\n"+
        "                <div class=\"modal-footer\">\n"+
        "                    <button type=\"button\" class=\"btn btn-primary\" data-dismiss=\"modal\">confirm\n"+
        "                    </button>\n"+
        "                </div>\n"+
        "            </div>\n"+
        "        </div>\n"+
        "    </div>";
    $("body").append(noticeModal);
}

function showNotice(notice) {
    $("#modalContent").html(notice);
    $('#noticeModal').modal('toggle');
}



//获取url中参数值
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}


//为页面初始化提示模态框
$(function () {
    loadNoticeModal();
});