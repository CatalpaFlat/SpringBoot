$(function(){
    /**
     * 测试
     */
    $("#login").click(function(){
        $.ajax({
            url: 'ajaxLogin',
            type: 'POST',
            dataType: 'json',
            data:{username:"admin",password:"123456"},
            success: function(data) {
                var json = JSON.stringify(data);
                alert("success..."+json);
            },
            error: function(data) {
                var json = JSON.stringify(data);
                alert("error..."+json);
            }
        });
    });
});