<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<script src="<%=path%>/js/jquery.js"></script>

<link href="<%=path %>/css/semantic.css" rel="stylesheet">
<script src="<%=path %>/semantic/semantic.js"></script>

<link  href="<%=path %>/layui/css/layui.css" rel="stylesheet" />
<link  href="<%=path %>/layer/theme/default/layer.css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="<%=path%>/css/button.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="ui modal" id="modifyModal">
		<div class="header">修改学生信息</div>
		<div class="content">
			<form class="ui form" action="studentModifyServlet" id="form_modify_class" method="post" onsubmit="return mformCheck();">
				
				<div class="field">
					<div class="two fields">
						<div class="field">
								<label>姓名</label>
								<input onblur="nullCheck(this);" onfocus="clearError(this);" type="text" id="stuName" name="stuName" class="ui input" placeholder="姓名" />		
						</div>
						<div class="field">
							<label for="">性别</label>
							<div class="inline fields">
									<div class="field">
										<div class="ui radio checkbox">
												
												 <input onblur="nullCheck(this);" onfocus="clearError(this);"  onblur name="sex" type="radio" value="1" id="radio1"/>
												<label for="">男</label>
										</div>
									</div>
									<div class="field">
											<div class="ui radio checkbox">
													
													<input onblur="nullCheck(this);" onfocus="clearError(this);" name="sex" type="radio" value="0" id="radio0"/>
													<label for="">女</label>
											</div>
									</div>
			
								</div>
							</div>
							</div>
							<div class="two fields">
								<div class="field">
									<label for="">学校姓名</label>
									<input onblur="nullCheck(this);" onfocus="clearError(this);" type="text" name="schoolName" id="schoolName" />
								</div>
								<div class="field">
									<label for="">班级</label>
									<select class="ui dropdown" name="classId">
										<c:forEach var="cl" items="${classList}">
											<option id="${cl.id}" value="${cl.id}">${cl.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="field">
								<label for="">出生日期</label>
								<input onblur="nullCheck(this);" onfocus="clearError(this);" type="text" name="born" id="born" class="layui-input"  placeholder="yyyy-MM-dd">
							</div>

						</div>
						<input onblur="nullCheck(this);" onfocus="clearError(this);" type="hidden" name="id" id="id" value= /> 
					</form>
					</div>
					
			
			
			<div class="actions">
					<div class="ui black deny button">取消</div>
					<div class="ui positive right labeled icon button" onclick="$('#form_modify_class').submit();">
						提交 <i class="checkmark icon"></i>
					</div>
			</div>
		</div>
	



	<div class="ui modal" id="addModal">
			<div class="header">增加学生信息</div>
			<div class="content">
				<form class="ui form" action="studentAddServlet" id="formAdd" method="post" onsubmit="return formCheck();">
					
					<div class="field">
						<div class="two fields">
							<div class="field">
									<label>姓名</label>
									<input onblur="nullCheck(this);" onfocus="clearError(this);" type="text" id="addStuName" name="stuName" class="ui input" placeholder="姓名" />		
							</div>
							<div class="field">
								<label for="">性别</label>
								<div class="inline fields">
										<div class="field">
											<div class="ui radio checkbox">
													
													<input onblur="nullCheck(this);" onfocus="clearError(this);" name="sex" type="radio" value="1" id="" checked/>
													<label for="">男</label>
											</div>
										</div>
										<div class="field">
												<div class="ui radio checkbox">
														
														<input onblur="nullCheck(this);" onfocus="clearError(this);" name="sex" type="radio" value="0" id=""/>
														<label for="">女</label>
												</div>
										</div>
				
									</div>
								</div>
								</div>
								<div class="two fields">
									<div class="field">
										<label for="">学校姓名</label>
										<input onblur="nullCheck(this);" onfocus="clearError(this);" type="text" name="schoolName" id="addStuSchool" />
									</div>
									<div class="field">
										<label for="">班级</label>
										<select class="ui dropdown" name="classId">
											<c:forEach var="cl" items="${classList}">
												<option selected value="${cl.id}">${cl.name}</option>
											</c:forEach>
										</select>
									</div>
								</div>
	
								<div class="field">
									<label for="">出生日期</label>
									<input onblur="nullCheck(this);" onfocus="clearError(this);" type="text" name="born" id="addBorn" class="layui-input"  placeholder="yyyy-MM-dd" >
								</div>
	
							</div>
						 
						</form>
						</div>
						
				
				
				<div class="actions">
						<div class="ui black deny button">取消</div>
						<div class="ui positive right labeled icon button" onclick="$('#formAdd').submit();">
							提交 <i class="checkmark icon"></i>
						</div>
				</div>


	</div>




	<br />
	<div>
		<form action="studentQueryServlet" method="get" id="addForm">
			<div class="ui action input" style="position: absolute; right: 12em; top: 2.4em;">
				<input name="name" type="text" placeholder="搜索学生..." />
				<button type="submit" class="ui  button" >
					搜索
				</button>
				</div>
		</form>
	</div>
	
		<div style="position: absolute; right: 2em; top: 2.4em;">
		<a class="rkmd-btn btn-white ripple-effect ripple-dark" href="#"
			id="stuAddButton">增加学生</a> &nbsp;&nbsp;&nbsp;
	</div>
	<div style="position: absolute; left:1.8em;right: 1.8em; top: 5.8em;">

		<table class="ui striped selectable sortable celled red center table"
			id="classes">
			<thead>
				<tr align="center">
					<th>学生姓名</th>
					<th class="">性别</th>
					<th class="">出生日期</th>
					<th>所属方向</th>
					<th class="">班级名称</th>
					<th class="">学校名称</th>
					<th>修改操作</th>
					<th>删除操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sc" items="${stuList}">
					<tr align="center" id="">
						<td id="sourceName">${sc.name}</td>


						<c:choose>
							<c:when test="${sc.sex == 1}">
								<td>男</td>
							</c:when>
							<c:otherwise>
								<td>女</td>
							</c:otherwise>
						</c:choose>
						<td>${sc.birthday}</td>
						<td id="classify_name">${sc.classify}</td>



						<td>${sc.class_name}</td>
						<td>${sc.school }</td>
						<td>
						<a	onclick="$('#modifyModal').modal('show');"
							class="rkmd-btn btn-lightBlue ripple-effect" href="#"
							data-toggle="modal" fhref="${sc.id}" id="modify_button"
							sname="${sc.name}" schoolName="${sc.school}"
							classId="${sc.class_id}" born="${sc.birthday }" sex="${sc.sex}"
							data-target="#myModal">修改</a>
						</td>
						<td>
							<div>
								<a class="rkmd-btn btn-red ripple-effect"
									href="<%=path%>/studentDelServlet?id=${sc.id}">删除 </a>

							</div>

						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>




	</div>
	<script src="<%=path%>/js/index.js"></script>
	<script src="<%=path%>/layui/layui.js" ></script>
	<script src="<%=path%>/layer/layer.js" ></script>
		<script>
			layui.use('laydate', function(){
				  var laydate = layui.laydate;
				console.log(laydate);
				  //常规用法
				  laydate.render({
						elem: '#addBorn'
						,type: 'date',
						trigger: 'click',
						theme: '#393D49',
						value: new Date()
					  });
				  laydate.render({
						elem: '#born'
						,type: 'date',
						trigger: 'click',
						theme: '#393D49',
						value: new Date()
					  });
			});
				
				
			</script>
	
	<script>
	function formCheck(){
			
			if($("#addStuName").val() && $("#addStuSchool").val() && $("#addBorn").val()){
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
	
	function mformCheck(){
		
		if($("#stuName").val() && $("#schoolName").val() && $("#born").val()){
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
		$('.ui .dropdown').dropdown();
		
		$("#stuAddButton").click(function() {
			$('#addModal').modal('show');
		});
	</script>
	<script>
			function clearError(t){
				console.log(t);
				$(t).closest(".error").removeClass("error");
				$(t).attr("placeholder","");
			}
			function nullCheck(t){
				if($(t).val()== ""){
					$(t).closest('.field').addClass("error");
					$(t).attr('placeholder',"该字段不能为空，请重新输入");
				}
			}
	</script>
	<script>
		$("#modify_class").click(function() {

			$("#form_modify_class").submit();

		});

		function processInnderDiv(domDiv) {

			$("#id").attr("value", domDiv.getAttribute("fhref"));
			$("#stuName").attr("value", domDiv.getAttribute("sname"));
			$("#schoolName").attr("value", domDiv.getAttribute("schoolName"));
			$('#born').attr("value", domDiv.getAttribute("born"));
			var classId = domDiv.getAttribute("classId");
			var sex = domDiv.getAttribute("sex");
			$("#" + classId).attr("selected", "selected");

			$("#radio" + sex).attr("checked", "checked");
		}
		document.getElementById("classes").addEventListener("click",
				function(event) {
					processInnderDiv(event.target);
				}, false);

		$("#add_class").click(function() {

			$("#add_class_form").submit();
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
	<script type="text/javascript" color="0,0,255" opacity='1' zIndex="-88"
		count="200" src="<%=path%>/js/nest.js"></script>
</body>
</html>