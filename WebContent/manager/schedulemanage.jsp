
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
<script src="<%=path %>/js/jquery.js"></script>
<link href="<%=path %>/css/semantic.css" rel="stylesheet">
<script src="<%=path %>/js/semantic.js"></script>
<link href="<%=path%>/css/button.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- 弹出层 -->
	<div class="ui modal" id="modifyPop">
		<div class="header">修改排课信息</div>
		<div class="content">
			<form class="ui form" action="scheduleModifyServlet" method="post"
				id="modifyFrom">
				
					<span><h3 ">教师姓名:</h3></span> <span
						id="teacherName">11</span>
			
				<input type="hidden" id="hiddenId" name="hid1denId" value="1" />

				<div class="ui horizontal divider">我是一条分割线</div>
				<br />
				<div class="two fields">
					<div class="field">
						<label>课程信息</label> <select class="ui fluid dropdown"
							name="courseId">
							<c:forEach var="cs" items="${courseList}">
								<option value="${cs.id}" id="${cs.name}">${cs.name}</option>
							</c:forEach>
							
						</select>
					</div>
					<div class="field">
						<label>班级信息</label> <select class="ui fluid dropdown"
							name="classId">
							<c:forEach var="ci" items="${classList}">
								<option value="${ci.id}" id="${ci.name}">${ci.name}</option>
							</c:forEach>
							
						</select>
					</div>
					<div class="field">
						<label></label>
					</div>
				</div>
			</form>
		</div>
		<div class="actions">
			<div class="ui black deny button">取消</div>
			<div class="ui positive right labeled icon button" id="modifyOK">
				确认提交<i class="checkmark icon"></i>
			</div>
		</div>

	</div>
	<div class="ui modal" id="addPop">
		<div class="header">增加排课信息</div>
		<div class="content">
			<form class="ui form" action="scheduleAddServlet" method="post"
				id="addForm">
				<input type="hidden" id="hiddenId" name="hiddenId" /> <br />
				<div class="three fields">
					
					<div class="field">
						<label>教师姓名</label> <select class="ui fluid dropdown"
							name="teacherId">
							<c:forEach var="teacher" items="${teacherList}">
								<option value="${teacher.id}" selected>${teacher.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="field">
						<label>课程信息</label> <select class="ui fluid dropdown"
							name="courseId">
							<c:forEach var="cs" items="${courseList}">
								<option value="${cs.id}" id="${cs.name}">${cs.name}</option>
							</c:forEach>
							
						</select>
					</div>
					<div class="field">
						<label>班级信息</label> <select class="ui fluid dropdown"
							name="classId">
							<c:forEach var="ci" items="${classList}">
								<option value="${ci.id}" id="${ci.name}">${ci.name}</option>
							</c:forEach>
							
						</select>
					</div>

				</div>
			</form>
		</div>
		<div class="actions">
			<div class="ui black deny button">取消</div>
			<div class="ui positive right labeled icon button" id="addOK" onclick="$('#addForm').submit();">
				确认提交 <i class="checkmark icon"></i>
			</div>
		</div>
	</div>

	<div style="position: absolute; right: 2em; top: 2.5em;">
		<a class="rkmd-btn btn-white ripple-effect ripple-dark" href="#"
			id="scheAddButton" onclick="$('#addPop').modal('show');">增加排课</a>
		&nbsp;&nbsp;&nbsp;
	</div>
	<div
		style="margin: 35px !important; position: absolute; top: 2.9em; right: 0.1em; left: 0.1em;">
		<table class="ui selectable striped grey table" id="showTables">
			<thead>
				<tr>
					<th>教师姓名</th>
					<th>课程名称</th>
					<th>班级名称</th>
					<th>修改操作</th>
					<th>删除操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sc" items="${scheduleList}">
					<tr id="">
						<td id="">${sc.teaName}</td>
						<td id="">${sc.cName}</td>
						<td>${sc.scName}</td>
						<td><a class="ui blue button" href="#"
							teacherName="${sc.teaName}" tcId="${sc.tcId}"
							courseId="${sc.cName}" classId="${sc.scName}"
							onclick="showTable();">修改</a></td>
						<td>
							<div>
								<a class="ui red button"
									href="<%=path %>/scheduleModifyServlet?id=${sc.tcId}">删除</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script>
		$('.ui .dropdown').dropdown();
		$("#modifyOK").click(function() {
			var tmpInput=$("<input type='text' name='hiddenId'/>");
	        tmpInput.attr("value",window.tcId);
	        console.log(window.tcId);
			var form = $("#modifyFrom");
			form.append(tmpInput);
			form.submit();
		});

		function showTable() {
			$('#modifyPop').modal('show');
		}

		function processInnderDiv(domDiv) {

			var classId = domDiv.getAttribute("classid");
			var courseId = domDiv.getAttribute("courseid");
			var teacherName = domDiv.getAttribute("teachername");
			 window.tcId = domDiv.getAttribute("tcId");
			console.log($("#hiddenId"));
			$("#" + classId).attr("selected", "selected");
			document.getElementById("teacherName").innerHTML = teacherName;
			$("#" + courseId).attr("selected", "selected");
			$("#hiddenId").attr("value", window.tcId);
			document.getElementById("hiddenId").innerHTML = tcId;

		}
		document.getElementById("showTables").addEventListener("click",
				function(event) {
					processInnderDiv(event.target);
				}, false);
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
	<script type="text/javascript" color="0,0,255" opacity='0.6' zIndex="-88" count="150"  src="<%=path%>/js/nest.js"></script>
</body>

</html>

