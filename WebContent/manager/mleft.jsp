<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<link href="../css/style_left.css" rel="stylesheet" type="text/css" />
<link href="../css/jquery-ui.css" rel="stylesheet" type="text/css" />
<style>
body{
	background-image:url(../img/bian.png);
	background-repeat:repeat-y;
	background-position:right;
}
</style>
</head>

<body>

<aside class="sidebar">
    <div id="leftside-navigation" class="nano">
        <ul class="nano-content">
            <li>
                <a href="mmain.jsp" target="mainFrame"><i class="fa fa-dashboard"></i><span>主页</span></a>
            </li>
            <li class="sub-menu">
                    <a href="<%=path%>/stuClassQueryServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>班级管理</span> <i class="arrow fa fa-angle-right pull-right"></i></a>
            </li>
            <li class="sub-menu">
                    <a href="<%=path%>/teacherQueryServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>教师管理</span><i class="arrow fa fa-angle-right pull-right"></i></a>
            </li>
            <li class="sub-menu">
                    <a href="<%=path%>/courseQueryServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>课程管理</span><i class="arrow fa fa-angle-right pull-right"></i></a>
            </li>
            <li class="sub-menu">
                    <a href="<%=path%>/scheduleQueryServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>班级排课管理</span><i class="arrow fa fa-angle-right pull-right"></i></a>
            </li>
            <li class="sub-menu">
                    <a href="<%=path%>/studentQueryServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>学生管理</span><i class="arrow fa fa-angle-right pull-right"></i></a>
            </li>
            <li class="sub-menu">
                    <a href="<%=path%>/logoutServlet" target="_parent" onclick="javascript: return confirm('确认退出用户吗？');" ><i class="fa fa-cogs"></i><span>退出用户</span></a>
            </li>
            
                    
            

        </ul>
    </div>
</aside>

<script src='../js/jquery.js'></script>
<script src='../js/jquery-ui.min.js'></script>

    <script  src="../js/index.js"></script>
 
</div>
</body>
</html>
