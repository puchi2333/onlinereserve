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
<script src="<%=path%>/js/jquery.js"> </script>
	<script src="<%=path%>/layui/layui.js"></script>
	<script src="<%=path%>/js/semantic.js"></script>
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
<script>
history.go(1);//屏蔽回退
	document.oncontextmenu = function(e){
		if(e==null)e = window.event;
		e.cancelBubble = true;
		e.returnValue=false;
		return true;//右键屏蔽
	};
</script>
</head>

<style>
body {
height:100%;
}
</style>

<aside class="sidebar">
    <div id="leftside-navigation" class="nano">
        <ul class="nano-content">
            <li class="sub-menu">
                    <a href="<%=path%>/testQueryServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>近期菜单</span> <i class="arrow fa fa-angle-right pull-right"></i></a>
            </li>
            <li class="sub-menu">
                    <a href="<%=path%>/papersCompareServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>订单分析</span><i class="arrow fa fa-angle-right pull-right"></i></a>
            </li>
            <li class="sub-menu">
                    <a href="<%=path%>/testAddServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>发布订单</span><i class="arrow fa fa-angle-right pull-right"></i></a>
            </li>
            <li class="sub-menu">
                    <a href="<%=path%>/questionQueryServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>菜品管理</span><i class="arrow fa fa-angle-right pull-right"></i></a>
            </li>
            
            <li class="sub-menu">
                    <a href="<%=path%>/logoutServlet" target="_parent" onclick="javascript: return confirm('确认退出用户吗？');" ><i class="fa fa-cogs"></i><span>退出用户</span></a>
            </li>
            
                    
            

        </ul>
    </div>
</aside>
</html>