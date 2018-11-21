<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path%>/css/semantic.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/layui/css/layui.css" rel="stylesheet" type="text/css" />
<script src="<%=path%>/js/jquery.js"></script>
<script src="<%=path%>/js/semantic.js"></script>
<title>无标题文档</title>
<style>
</style>
<script>
	/* history.go(1);//屏蔽回退
	document.oncontextmenu = function(e) {
		if (e == null)
			e = window.event;
		e.cancelBubble = true;
		e.returnValue = false;
		return true;//右键屏蔽
	}; */
</script>
</head>

<body>
<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<b>${user.name}，</b>欢迎来到近期菜单页面</legend>
</fieldset>
	<div style="margin:20px;">
	<table class="ui very compact selectable table">
		<tr align="center">
			<td><b>菜单分类</b></td>
			<td><b>菜单名称</b></td>
			<td><b>菜单截止时间</b></td>
			<td><b>选择时长</b></td>
			<td><b>面向群体</b></td>
			<td><b>菜单总价格</b></td>
			<td width="81"><b>菜单状态</b></td>
		</tr>
		<c:forEach var="test" items="${testsList}">
			<tr align="center">
				<td>${test.courseName }</td>
				<td class="selectable"><a href = '<%=path%>/testDetailInfoServlet?id=${test.id}'>${test.name }</a></td>
				<td>${test.end_time }</td>
				<td>${test.test_time }</td>
				<td>${test.classNames }</td>
				<td>${test.score }</td>
				<td width="81" id="status">${test.status}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
<script>
$('[id=status]').each(function(i){
	if($(this).text() == "已结束"){
		$(this).attr("class","negative disable");
	}
	else{
		$(this).attr("class","positive");
	}
}); 
</script>
	<script src="<%=path%>/layer/layer.js"> </script>
<script>
function showMsg(){
	console.log("shw");
	layer.confirm('确定要退出用户吗？', {
		  btn: ['确定','取消'] //按钮
		}, function(){			
		window.open('<%=path%>/logoutServlet','_parent');
		}, function(){
		});
	
}
</script>
</html>