<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <%--    静态包含style.css, jQuery, base, script--%>
    <%@include file="../common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("#codeImg").click(function () {
                //src描述图片路径, 可读可写, 加个时间参数避免浏览器缓冲问题
                this.src = "${basePath}/kaptcha.jpg?d="+new Date();
            })
        })
    </script>
</head>
<body>
    <div id="div1">
        <div class="welcom">注册书城会员</div>
        <div class="reglog">
            <a href="pages/user/login.jsp">立即登录</a>
        </div>
        <%--用户名已存在--%>
        <div class="msg01">
<%--            <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
            ${requestScope.msg}  <%---EL表达式, 为null时默认空串(不显示东西)--%>
        </div>
        <form action="userServlet", method="post">
            <input type="hidden" name="action" value="regist"/>
            <table>
                <tr>
                    <td>用户名称 : </td>
                    <td><input id="username" name="username" class="item" type="text"
                               placeholder="请输入用户名" value="${requestScope.username}"
                               autocomplete="off" tabindex="1"/></td>
                </tr>
                <tr>
                    <td>登录密码 : </td>
                    <td><input id="password"  name="password" class="item" type="password" placeholder="请输入密码"/></td>
                </tr>
                <tr>
                    <td>重复密码 : </td>
                    <td><input id="password2" class="item" type="password" placeholder="确认密码"/></td>
                </tr>
                <tr>
                    <td>电子邮箱 : </td>
                    <td><input id="email" name="email" class="item" type="text" placeholder="请输入邮箱地址" value="${requestScope.email}"
                               autocomplete="off" tabindex="1"/></td>
                </tr>
                <tr>
                    <td>验证码 : </td>
                    <td>
                        <input id="code" name="code" type="text" size="5" autocomplete="off" tabindex="1" placeholder="验证码"/>
                        <img id="codeImg" alt="加载失败" src="kaptcha.jpg" width="90px" height="25px"/>
                    </td>
                </tr>
            </table>
            <div class="siglog">
                <input  id="signup" type="submit" value="注册"/>
            </div>
        </form>

    </div>
<%--    页脚--%>
    <%@include file="../common/footer.jsp"%>
</body>
</html>