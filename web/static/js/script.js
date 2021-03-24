
$(function () {
    var username;
    var password;
    var password2;
    //绑定注册按钮事件
   $("#signup").click(function () {
       username = $("#username").val();
       password = $("#password").val();
       password2 = $("#password2").val();

   });

    //绑定登录按钮事件
    $("#signin").click(function () {

    });

    //用戶名称失去焦点
    $("#username").blur(function () {
        username = $("#username").val();
        password = $("#password").val();
        password2 = $("#password2").val();
        console.log(username);
    })
    //登录密码框失去焦点
    $("#password").blur(function () {
        password = $("#password").val();
        password2 = $("#password2").val();
    })
    //确认密码框失去焦点
    $("#password2").blur(function () {
        password2 = $("#password2").val();

    })
});