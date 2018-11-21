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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="<%=path%>/js/jquery.js"></script>
<link href="https://cdn.bootcss.com/semantic-ui/2.2.13/semantic.css" rel="stylesheet" />
<script src="https://cdn.bootcss.com/semantic-ui/2.2.13/semantic.js"></script>
<link href="<%=path%>/css/button.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/css/loding.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/layui/css/layui.css" rel="stylesheet" type="text/css" />
<title>增加菜品</title>
</head>

<body>
<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<b>${user.name}，</b>欢迎您来到菜品管理</legend>
</fieldset>
	<div id="loding" style="height:50%;width:50%; margin:20% 20%; display:none;">
	  <div class="loader">
		                        <div class="loader-inner"><hr><hr><hr><hr><hr></div>
		                        <div class="loader-inner box box-1"><hr><hr><hr><hr><hr></div>
		                        <div class="loader-inner box box-2"><hr><hr><hr><hr><hr></div>
		                        <div class="loader-inner box box-3"><hr><hr><hr><hr><hr></div>
		                        <div class="loader-inner box box-4"><hr><hr><hr><hr><hr></div>
		                        <div class="loader-inner box box-5"><hr><hr><hr><hr><hr></div>
		                        <div class="loader-inner box box-6"><hr><hr><hr><hr><hr></div>
		                        <div class="loader-inner"><hr><hr><hr><hr><hr></div>
		                        
	</div>
	<div style="position :absolute; left:43.5%; top:59%;">Loding...</div>
	
	</div>
	
	
	<div class="ui modal" id="addModal">
		<div class="header">添加菜品信息</div>
		<div class="content">
			<form class="ui form" action="questionAddServlet" method="post"
				id="addForm" onsubmit="return formVer('addModal');">
				<div class="field">
					<div class="two fields">
						<div class="field">
							<select class="ui select dropdown" name="courseId" id="courseId">
								<c:forEach var="c" items="${courseList}">
									<option value="${c.id}">${c.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="field">
							<label>提交方式:</label>
							 <label>单选</label> <input type="radio" name="questionType" value="1" checked />
						</div>

					</div>
					<div class="field">
						<label>菜品名称：</label> <input name="questionName" type="text" onfocus="clearError('timu');" onblur="nullCheck('timu');"
							id="timu" />
					</div>
					<div class="field">
						<label>口味及配料：</label>
						<div class="four fields">
							<div class="field">
								<label>附加选项A</label> <input type="text" value="无" name="choiceA" id="ca" onfocus="clearError('ca');" onblur="nullCheck('ca');"  />
							</div>
							<div class="field">
								<label>附加选项B</label> <input type="text"  value="无" name="choiceB" id="cb" onfocus="clearError('cb');" onblur="nullCheck('cb');" />
							</div>
							<div class="field">
								<label>附加选项C</label> <input type="text"  value="无" name="choiceC" id="cc" onfocus="clearError('cc');" onblur="nullCheck('cc');"/>
							</div>
							<div class="field">
								<label>附加选项D</label> <input type="text"  value="无" name="choiceD" id="cd" onfocus="clearError('cd');" onblur="nullCheck('cd');" />
							</div>
						</div>
						<div class="inline fields">
							<label>价格：</label> 
							<div class="ui input">
									<input type="text" name="ans" value="50" class="" onfocus="clearError(this);"
										 onblur="nullCheck('testname');" />
								</div>
						</div>

					</div>

					
			</form>

		</div></div>
		<div class="actions">
			<div class="ui black deny button">取消</div>
			<div class="ui positive right labeled icon button" id="addOK"
				onclick="$('#addForm').submit();">
				确认提交<i class="checkmark icon"></i>
			</div>
		</div>
	</div>

	<div class="ui modal" id="modifyModal">
		<div class="header">修改菜品信息</div>
		<div class="content">
			<form class="ui form" action="questionModifyServlet" method="post"
				id="modifyForm" onsubmit="return mformVer();">
				<div class="field">
					<div class="two fields">
						<div class="field">
							<select class="ui select dropdown" name="courseId" id="McourseId">
								<c:forEach var="c" items="${courseList}">
									<option value="${c.id}" id="${c.id}">${c.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="field">
							<label>题目类型:</label> <label>单选</label>
							 <input type="radio" name="questionType" value="1" checked />
							 <input type="hidden" name="id" id="hiddenId" value="1" />
						</div>

					</div>
				</div>
				<div class="field">
					<label>菜品名称：</label> <input name="questionName" type="text"
						id="Mtimu"  onfocus="clearError('Mtimu');" onblur="nullCheck('Mtimu');"/>
				</div>
				<div class="field">
					<label>口味以及配料：</label>
					<div class="four fields">
						<div class="field">
							<label>附加选项A</label> <input type="text"  value="无" name="choiceA" id="Mca" onfocus="clearError('Mca');" onblur="nullCheck('Mca');" />
						</div>
						<div class="field">
							<label>附加选项B</label> <input type="text"  value="无" name="choiceB" id="Mcb" onfocus="clearError('Mcb');"  onblur="nullCheck('Mcb');" />
						</div>
						<div class="field">
							<label>附加选项C</label> <input type="text"  value="无" name="choiceC" id="Mcc"  onfocus="clearError('Mcc');"  onblur="nullCheck('Mcc');"/>
						</div>
						<div class="field">
							<label>附加选项D</label> <input type="text"  value="无" name="choiceD" id="Mcd" onfocus="clearError('Mcd');"  onblur="nullCheck('Mcd');" />
						</div>
					</div>
					<div class="field">
						<div class="inline fields">
							<label>价格：</label> 

							<div class="ui input">
									<input type="text" name="ans" value="50" class="" onfocus="clearError(this);"
										id="maA" onblur="nullCheck('testname');" />
								</div>
							
						</div>
					</div>

				</div>


			</form>

		</div>
		<div class="actions">
			<div class="ui black deny button">取消</div>
			<div class="ui positive right labeled icon button" id="addOK" onclick="$('#modifyForm').submit();">
				确认提交<i class="checkmark icon"></i>
			</div>
		</div>
	</div>
	</div></div>

	<div id="pages"  style="display: none !important;">
		<div style="position: absolute; top: 2.6em; right: 12em;">
	
	
			<form method="get" action="<%=path%>/questionQueryServlet"
				id="thisForm">
				
				<select name="selectk" id="selectk"
							class="ui compact selection dropdown">
							<option selected="selected" value="name">菜品分类</option>
							<option value="queTitle">菜品名称</option>
				</select>
				<div class="ui icon  input">
					<input placeholder="Search..." type="text" name="searchName"
						id="searchName" />
					<i class="circular search link icon" onclick="$('#thisForm').submit();"></i>
				</div>
					
						
				


				</h3>
				<br />
			</form>
		</div>

		<a href='#' style="position: absolute; right: 2em; top: 2.4em;"
			class="rkmd-btn btn-white ripple-effect ripple-dark"
			onclick="$('#addModal').modal('show');">增加菜品</a>
		<div
			style="margin: 35px !important; position: absolute; top: 3.9em; right: 0.1em; left: 0.1em;">
			<table class="ui celled very compact  structured table">
				<thead>
					<tr align="center">
						<th rowspan="2" class="sorted ascending"><b>菜品号</b></th>
						<th rowspan="2"><b>菜单分类</b></th>
						<th rowspan="2"><b>提交方式</b></th>
						<th rowspan="2"><b>菜品名称</b></th>
						<th colspan="4"><b>口味及配料</b></th>
						<th rowspan="2"><b>价格</b></th>
						<th rowspan="2" width="15%"><b>操作</b></th>
					</tr>
					<tr>
						<th>A</th>
						<th>B</th>
						<th>C</th>
						<th>D</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="que" items="${queList}">
						<tr align="center">
							<td>${que.id}</td>
							<td>${que.name}</td>
							<td>单选</td>
							<td style="align:left !important;">${que.que_title}</td>
							<td>${que.choice_A}</td>
							<td>${que.choice_B}</td>
							<td>${que.choice_C}</td>
							<td>${que.choice_D}</td>
							<td><span style="color: #ff0000">${que.ans}</span></td>
							<td>
								<div class="ui buttons">
									<button class="ui positive button active"
										onclick="modifyButton(${que.id},${que.course_id},'${que.que_title}','${que.choice_A}','${que.choice_B}','${que.choice_C}','${que.choice_D}','${que.ans}');">修改</button>
									<div class="or"></div>
									<a class="negative ui button"
										href="<%=path%>/questionModifyServlet?id=${que.id}"
										onclick="javascript: return confirm('确认删除此菜品吗？');">删除</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>



<script>

				$("#loding").show();
				$("#pages").hide();
				var n = 0, timer = setInterval(function(){
					console.log(n);
					n = n + Math.random()*10|0;  
					if(n>100){
					  n = 100;
					  clearInterval(timer);
					  $("#loding").hide();
					$("#pages").show();
					}
				  }, 120);
</script>
	<script>
			function nullCheck(id){
				
				if($('#' + id).val()== ""){
					$('#' + id).closest('.field').addClass("error");
					$('#' + id).attr('placeholder',"该字段不能为空，请重新输入");
				}
					
			}
			function clearError(id){
				console.log($('#' + id).closest(' .error'));
				$('#' + id).closest('.error').removeClass("error");
				$('#' + id).attr('placeholder',"");
			}
	</script>




	<script>
	
	function modifyButton(queId,courseId,queTitle,queChA,queChB,queChC,queChD,queAns) {
		$('#modifyModal').modal('show');
		$("#" + courseId).attr("selected","selected");
		$("#Mtimu").attr("value", queTitle);
		$("#Mca").attr("value",queChA);
		$("#Mcb").attr("value",queChB);
		$("#Mcc").attr("value",queChC);
		$("#Mcd").attr("value",queChD);
		$("#Mans").attr("value",queChA);
		$("#hiddenId").attr("value",queId);
		$("#ma" + queAns).attr("checked","checked");

	}
</script>
	<script src="<%=path%>/layui/layui.all.js"></script>
	<script>
		$( '.dropdown').dropdown();
		function mformVer(){
		
			if($("#Mca").val() && $("#Mcb").val() && $("#Mcc").val() && $("#Mcd").val() && $("#Mtimu").val()){
				return true;
			}
			else {
				layer.msg('请完善表单信息', function(){
					console.log("close");
					$('#modifyModal').modal('show');
				});
				
				
				return false;
			}
	}
</script>
<script>
		function formVer(){
			
			if($("#ca").val() && $("#cb").val() && $("#cc").val() && $("#cd").val() && $("#timu").val()){
				return true;
			}
			else {alert("请完善增加信息！");return false;}
		}
		
</script>

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