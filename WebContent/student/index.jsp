<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生在线考试系统</title>
</head>
<frameset rows="110,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="<%=path %>/student/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
    <frame src="<%=path %>/recentTestServlet" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</html>

<script>
function showMsg(){
	alert("22");
	layer.confirm('确定要退出用户吗？', {
		  btn: ['确定','取消'] //按钮
		}, function(){
			
		window.open('<%=path%>/logoutServlet','_parent');
		}, function(){
		});
	
}

</script>
