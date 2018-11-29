<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.onlinexam.po.Question"%>
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
<script src="<%=path%>/js/tablesort.js"></script>
<script src="<%=path%>/layui/layui.js"></script>
<title>无标题文档</title>


</head>

<body>
<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<b>${user.name}，</b>菜单即将发布，请选择修改确认</legend>
</fieldset>
	<div id="loding" style="display:none; width:70%; margin:20% 10%;">
	<div   class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="demo">
				<div class="layui-progress-bar layui-bg-red" lay-percent="0%" style=""></div>
		</div>
	</div>
		

		<script>
		layui.use('element', function(){
			  var $ = layui.jquery,
			  element = layui.element;
				$("#loding").show();
				$("#main_content").hide();
				var n = 0, timer = setInterval(function(){
					n = n + Math.random()*10|0;  
					if(n>100){
					  n = 100;
					  clearInterval(timer);
					  $("#loding").hide();
					$("#main_content").show();
					}
					element.progress('demo', n+'%');
				  }, 100);
				});
		</script>

	<div id="main_content" style="margin:20px 20px 30px 20px">
		<form id="form1" name="form1" method="post" name="subForm" onsubmit="return hideCheck();"
			action="<%=path%>/testCreateServlet">
			
			<h2 class="ui dividing header">
  				<img class="ui image" src="<%=path %>/img/school.png">
 			 	<div class="content">
   					菜单名称：${test.name}
  				</div>
			</h2>
			
			<blockquote class="layui-elem-quote layui-quote-nm">
			
				菜品分类：${c.name}
					面向对象：${classNames}<br /> 
					菜单截止时间：${test.end_time}<br />
					选择时长：${test.test_time}分钟<br />
					菜单总价格：${test.score}分
			
			</blockquote>

			<p>
				<b></b>
			</p>
			<fieldset class="layui-elem-field">
  <legend>菜单</legend>

			<table class="ui compact sortable celled definition table"  >
				<thead class="full-width">
					<tr>
						<th></th>
						<th>菜品号</th>
						<th>口味及配料</th>
						<th>附加选项</th>
						<th>价格</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="que" items="${quesList}" varStatus="status">
						<tr>
							<td class="collapsing">
								<div class="ui fitted slider checkbox">
									<input name="changeIds" type="checkbox" value="${que.id}" type="checkbox" /><label for=""></label>
								</div>
							</td>
							<td id="tihao">${que.id}</td>
							<td>${que.que_title}</td>
							<td>
								<span>A.${que.choice_A }</span><span>&nbsp;&nbsp;&nbsp;&nbsp; B.${que.choice_B }</span>&nbsp;&nbsp; &nbsp;&nbsp;
								<span>C.${que.choice_C }</span>&nbsp;&nbsp; &nbsp;&nbsp;<span>D.${que.choice_D }</span>
							</td>
							<td><font color="red"> ${que.ans}</font></td>
						</tr>
		
					</c:forEach>
				</tbody>
			</table>
			
				<center>
					<div id="button">
						
							<button class="ui positive button" type="submit" name="button" id="publishButton"> <i class="icon send"></i>发布菜单</button>
		
							<button  style="display:none;"  id="changeButton" name="changeButton" class="ui red button" onclick="changeFunc();">删除选中菜品</button>
					</div>
					
				</center>
				</fieldset>
		</form>
		<form style="display:none;" action='<%=path%>/testAddServlet' method='post' id="changeForm">
				<c:forEach var="stuclass" items="${classch}">
						<input type="checkbox" name="classCheck" value="${stuclass}" checked="checked"/>
				</c:forEach>
		</form>
		
	</div>
	<script>
	$('table').tablesort();
	
	function hideCheck(){
		var display = $("#publishButton").css("display");
		if(display == "none"){
			return false;
		}
		return true;
	}
	
	
	</script>
	<script>
	// 修改题号
	window.s = "";
	
	$("input[name='changeIds']").click(function(){
		 window.flag = false;
		$('input[name="changeIds"]:checked').each(function(){
			window.flag = true;
		});
		if (!window.flag) {
			$("#changeButton").hide();
			$("#publishButton").show();
		} else {
			$("#changeButton").show();
			$("#publishButton").hide();
		}
		
	});

	function fillStr(t){
		$(t).text('0' + $(t).text());
		if($(t).text().length < 6 ){
			fillStr(t);
		}
	}

	$("td[id='tihao']").each(function(){
		if($(this).text().length < 6){
			fillStr(this);
		}
		console.log("called");
	});

	function changeFunc() {
		$('input[name="changeIds"]:checked').each(function(){  
    		s += $(this).val() + ',';//向数组中添加元素  
		});  
		var form = $("#changeForm");
		var tmp1 = $("<input type='text' name='changeIds' />");
		tmp1.attr("value", s);
		var tmp6 = $("<input type='text' name='courseid' value='${c.id}'>");
		var tmp2 = $("<input type='text' name='testname' value='${test.name}'>");
		var tmp3 = $("<input type='text' name = 'enddate' value = '${test.end_time}'>");
		var tmp4 = $("<input type='text' name= 'sinscores' value = '${test.score}'>");
		var tmp7 = $("<input type='text' name='sinnum' value = '${num}'> ");
		var tmp5 = $("<input type='text' name='testtime'value='${test.test_time}' >");
		form.append(tmp1);
		form.append(tmp2);
		form.append(tmp3);
		form.append(tmp4);
		form.append(tmp5);
		form.append(tmp6);
		form.append(tmp7);
		form.submit();
	}
	

	
	
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
</body>
</html>