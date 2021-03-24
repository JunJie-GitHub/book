<%--
  Created by IntelliJ IDEA.
  User: jerry
  Date: 2020/11/13
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
<%--    静态包含style.css, jQuery, base, script--%>
    <%@include file="../common/head.jsp"%>
</head>
<body>
<div id="div1">
    <div class="welcom">登录书城</div>
    <div class="reglog">
        <a href="pages/user/register.jsp">立即注册</a>
    </div>
    <%--用户名密码输入错误提示--%>
    <div class="msg01">
<%--        <%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
<%--        ${empty requestScope.msg ? "请输入用户名密码":requestScope.msg}--%>
        ${requestScope.msg}
    </div>

    <form action="userServlet", method="post">
<%--        隐藏域, 用于区分表单提交, 以合并Servlet--%>
        <input type="hidden" name="action" value="login"/>
        <table>
            <tr>
                <td>用户名称 : </td>
                <td><input id="username" name="username" class="item" type="text"
                           value="${requestScope.username}" placeholder="请输入用户名"
                           autocomplete="off" tabindex="1"/></td>
            </tr>
            <tr>
                <td>登录密码 : </td>
                <td><input id="password"  name="password" class="item" type="password" placeholder="请输入密码"/></td>
            </tr>
        </table>
        <div class="siglog">
            <input  id="signin" type="submit" value="登录"/>
        </div>
    </form>

</div>

<%@include file="../common/footer.jsp"%>
</body>
</html>
