$("#upload").submit(function (e) {
    e.preventDefault();
    var formdata = new FormData($('#upload')[0]);
    $.ajax({
        type: 'post',
        url: "/upload",
        data: formdata,
        cache: false,
        processData: false,
        contentType: false
    }).success(function (data) {
        setTimeout(function () {
            alert("成功");
        }, 500);
    })
});


$("#download").click(function () {
    // ajax返回二进制内容 未生成文件
    // $.ajax({
    //     type: 'post',
    //     url: "/download",
    //     data: "",
    //     cache: false,
    //     processData: false,
    //     contentType: false
    // }).success(function () {
    //     setTimeout(function() {
    //         alert("成功");
    //     }, 500);
    // })
    var form = $("<form>");
    form.attr("style", "display:none");
    form.attr("target", "");
    form.attr("method", "post");
    form.attr("action", "/download");
    var input1 = $("<input>");
    input1.attr("type", "hidden");
    input1.attr("name", "custdownload");
    input1.attr("value", (new Date()).getMilliseconds());
    $("body").append(form);//将表单放置在web中
    form.append(input1);
    form.submit();//表单提交form.remove();

});