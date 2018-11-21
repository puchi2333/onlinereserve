<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.onlinexam.po.Question"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 查看试卷时候使用 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/css/semantic.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/layui/css/layui.css" rel="stylesheet" type="text/css" />
<script src="<%=path%>/js/jquery.js"></script>
<script src="<%=path%>/js/semantic.js"></script>

<style>
p {
	text-indent: 2em;
}
</style>
</head>

<body>
	<div id="main_content">
		<form id="form1" name="form1" method="post"
			action="#">
			
			
			<h2 class="ui dividing header">
  				<img class="ui image" src="<%=path %>/img/school.png">
 			 	<div class="content">
   					菜单名称：${test.tName}
  				</div>
			</h2>
			
			<blockquote class="layui-elem-quote layui-quote-nm">
			
				菜单科目：${test.cName}<br />
					面向群体：${test.classNames}<br /> 菜单截止时间：${test.end_time}<br />
					菜单选择时长：${test.test_time}分<br />
			
			</blockquote>

			<p>
				<b></b>
			</p>
			<fieldset class="layui-elem-field">
  <legend>菜品：</legend>
			<table class="ui  sortable celled table">
				<thead class="full-width">
					<tr>
						
						<th>菜号</th>
						<th>菜品名称</th>
						<th>口味以及调料</th>
						<th>价钱</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="que" items="${quesList}" varStatus="status">
						<tr>
							
							<td>${que.id}</td>
							<td>${que.que_title}</td>
							<td>
								<span>A.${que.choice_A }</span><span>&nbsp;&nbsp;&nbsp;&nbsp; B.${que.choice_B }</span>&nbsp;&nbsp; &nbsp;&nbsp;
								<span>C.${que.choice_C }</span>&nbsp;&nbsp; &nbsp;&nbsp;<span>D.${que.choice_D }</span>
							</td>
							<td><font color="blue"> ${que.ans}</font></td>
						</tr>
		
					</c:forEach>
				</tbody>
			</table>
			<center>
				<input type="" name="button" id="button" class="ui blue button"
					value="返回" onclick="window.history.back(-1);" />
			</center>
			<p class="text"></p>
			<p>&nbsp;</p>
			<label>
				
			</label>
		</form>
		</fieldset>
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