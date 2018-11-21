<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> 已提交的订单</title>
	<script src="<%=path%>/js/jquery.js"> </script>
	<script src="<%=path%>/layui/layui.js"></script>
	<script src="<%=path %>/layer/layer.js"></script>
	<script src="<%=path%>/js/semantic.js"></script>
	<link href="<%=path%>/layui/css/layui.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>/css/semantic.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<b>${user.name}</b>，已提交订单</legend>
	</fieldset>

	<div class="search" style="position:absolute; right:30px;">
		<form action="<%=path%>/pastTestServlet" method="post" id="searchForm" >
			
			<div class="ui icon input">
					<input type="text" placeholder="订单名称..." name="courseName">
					<i class="inverted circular search link icon" onclick="$('#searchForm').submit();"></i>
			</div>
		</form>
	</div>

	<div style="position:absolute; left:30px;right:30px;top:100px;">
		<table class="ui very compact selectable table">
			


			<tr align="center">
				<td>订单编号</td>
				<td>
					<b>菜系</b>
				</td>
				<td>
					<b>菜单名称</b>
				</td>
				<td>
					<b>选择时长</b>
				</td>
				<td>
					<b>订单提交时间</b>
				</td>
				<td>
					<b>总价格</b>
				</td>
				<td>订单状态</td>
			</tr>
			<c:forEach var="paper" items="${paperList}">
			
				<tr align="center">
				<td id = "paper_${paper.id} ">${paper.id}</td>
					<td>${paper.courseName}</td>
					<td><a href="<%=path%>/testInfoServlet?testId=${paper.test_id}&paperId=${paper.id}"> ${paper.testName}</a></td>
					<td>${paper.test_time}</td>
					<td>${paper.sub_time}</td>
					<td>${paper.score}</td>
					<c:if test="${paper.visited == true}"> <td>已接单</td></c:if>
					<c:if test="${paper.visited == false}"> 
						
						 
	
						 <td><a class="ui positive right labeled icon button"  href="<%=path%>/acceptServlet?testId=${paper.test_id}&paperId=${paper.id}"> 接单</a>
						 </td>
					 </c:if>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
<script>
function accpect(id){
	
}



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