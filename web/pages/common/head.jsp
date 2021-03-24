<%--
  Created by IntelliJ IDEA.
  User: jerry
  Date: 2020/11/14
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    pageContext.setAttribute("basePath",basePath);
%>

<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">
<%--<base href="http://localhost:8080/bookstore/"/>--%>
<link rel="stylesheet" type="text/css" href="static/css/style.css"/>
<%--style02是视频资料的原css, style是自己写的登录注册页面css--%>
<link rel="stylesheet" type="text/css" href="static/css/style02.css"/>
<script type="text/javascript" src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="static/js/script.js"></script>
