<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生在线考试系统</title>
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




  <frameset rows="110,*" cols="*" frameborder="no" border="0" framespacing="0">
     <frame src="<%=path %>/teacher/ttop.jsp" name="topFrame" frameborder="0" scrolling="no" width="500" height="50" allowTransparency="true"></frame>
     
    <frame src="<%=path %>/testQueryServlet" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
  <body>
</body>
</html>

