<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link href="<%=path %>/layui/css/layui.css" rel="stylesheet" />
<link href="<%=path%>/layer/theme/default/layer.css" rel="stylesheet" />
<script src="<%=path %>/layui/layui.js" ></script>
<script src="<%=path%>/js/semantic.js"></script>
<title>无标题文档</title>
<style>
</style>
 
</head>

<body>
<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<b>${user.name}管理员，</b>欢迎来到订单分析汇总页面</legend>
</fieldset>
	<h3 class="subTitle"></h3>
	<div style="margin:40px">
	<table width="90%" border="0" align="center" cellpadding="0"
		cellspacing="0" class="ui very  compact selectable table">
		<tr align="center">
			<td><b>面向群体</b></td>
			<td><b>菜系</b></td>
			<td><b>菜单名称</b></td>
			<td><b>菜单有效期</b></td>
			<td><b>菜单分类</b></td> 
			<td><b>平均销量</b></td>
		</tr>
		<c:forEach var="paper" items="${paperList}">
			<tr align="center">
				<td>${paper.className }</td>
				<td>${paper.courseName }</td>
				<td> <a href="<%=path%>/dataChartServlet?id=${paper.testId}"> ${paper.testName }</a> </td>
				<td>${paper.endDate }</td>
				<td>${paper.deptName }</td>
				
				<td><fmt:formatNumber type="number" value="${paper.avgScore}" pattern="0.00" maxFractionDigits="2"/> </td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
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