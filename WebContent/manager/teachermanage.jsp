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
<link href="https://cdn.bootcss.com/semantic-ui/2.2.13/semantic.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/semantic-ui/2.2.13/semantic.js"></script>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="<%=path%>/css/button.css" rel="stylesheet" type="text/css" /> 



</head>


<body>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改教师信息</h4>
				</div>
				<div class="modal-body">
					<form action="teacherModifyServlet" method="post"
						id="form_modify_class">
						<input type="hidden" name="teaid" id="classId" value= /> 教师姓名 <input
							type="text" name="stuname" id="stuname" />

						<td>所属方向</td>
						<td><select name="classify" id="classify">
								<c:forEach var="dept" items="${deptList}">

									<option id="${dept}" value="${dept}">${dept}</option>

								</c:forEach>

						</select></td>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" id="modify_class">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel2" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel2">添加教师信息</h4>
				</div>
				<div class="modal-body">
					<form action="teacherAddServlet" method="post" id="add_class_form">
						教师姓名 <input type="text" name="tname" id="stuname"
							value="${stuClass.name}" />



						<td>所属方向</td>
						<td><select name="classify" id="classify">
								<c:forEach var="dept" items="${deptList}">
									<option id="${dept}" value="${dept}">${dept}</option>
								</c:forEach>

						</select></td>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" id="add_class">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

	<div style="position: absolute; right: 2em; top: 2.4em;">
		<a class="rkmd-btn btn-white ripple-effect ripple-dark" href="#"
			data-toggle="modal" data-target="#myModal2" id="">增加教师</a>
		&nbsp;&nbsp;&nbsp;
	</div>
	<br />
	<div>
		
			<form action="teacherQueryServlet" method="get" id="addForm">
			<div class="ui action input" style="position: absolute; right: 12em; top: 2.4em;">
				<input name="name" type="text" placeholder="搜索教师..." />
				<button class="ui  button" onclick="$('#addForm').submit();">
					搜索
				</button>
				</div>
			</form>

		

	</div>
	<div  style="position: absolute; left:1.8em;right: 1.8em; top: 5.8em;">

		<div >
			<table class="ui striped celled yellow table" id="classes">
				<thead>
					<tr>
						<th width="200px">教师名称</th>
						<th width="200px">所属方向</th>
						<th width="200px">性别</th>
						<th width="200">出生日期</th>
						<th>修改操作</th>
						<th>删除操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="sc" items="${teaList}">
						<tr id="">
							<td width="200px" id="sourceName">${sc.name}</td>

							<td width="200px" id="classify_name">${sc.classify}</td>
							<c:choose>
								<c:when test="${sc.sex == 1}">
									<td width="200px">男</td>
								</c:when>
								<c:otherwise>
									<td width="200px">女</td>
								</c:otherwise>
							</c:choose>


							<td width="200px">${sc.birthday}</td>
							<td>
								<%-- "<%=path%>/stuClassModifyServlet?id=${sc.id}" --%> <a
								class="rkmd-btn btn-lightBlue ripple-effect" href="#"
								data-toggle="modal" fhref="${sc.id}" id="modify_button"
								sname="${sc.name}" sclassify="${sc.classify}"
								data-target="#myModal" onclick="modify_button();">修改</a>
							</td>
							<td>
								<div>
									<a class="rkmd-btn btn-red ripple-effect"
										href="<%=path%>/teacherDelServlet?id=${sc.id}">删除 </a>

								</div>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

	<script src="<%=path%>/js/jquery.min.js"></script>

	<script src="<%=path%>/js/index.js"></script>
	<script>
		$("#modify_class").click(function() {

			$("#form_modify_class").submit();

		});

		function processInnderDiv(domDiv) {
			$("#classId").attr("value", domDiv.getAttribute("fhref"));
			$("#stuname").attr("value", domDiv.getAttribute("sname"));
			var classify = domDiv.getAttribute("sclassify");
			$("#" + classify).attr("selected", "selected");

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
	<script type="text/javascript" color="0,0,0" opacity='1' zIndex="-88"
		count="200" src="<%=path%>/js/nest.js"></script>
</body>
</html>