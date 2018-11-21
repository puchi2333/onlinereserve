<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>

<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="<%=path%>/js/jquery.js"></script>

<link href="<%=path %>/css/semantic.css" rel="stylesheet">
<script src="<%=path %>/js/semantic.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link  href="<%=path %>/layui/css/layui.css" rel="stylesheet" />
<link  href="<%=path %>/layer/theme/default/layer.css" rel="stylesheet" />

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
					<h4 class="modal-title" id="myModalLabel">修改课程信息</h4>
				</div>
				<div class="modal-body">
					<form action="courseModifyServlet" method="post"
						id="form_modify_class">
						<input type="hidden" name="id" id="classId" value="${stuClass.id}" />
						课程名称 <input type="text" name="name" id="stuname"
							value="${stuClass.name}" />

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
					<h4 class="modal-title" id="myModalLabel2">添加课程信息</h4>
				</div>
				<div class="modal-body">
					<form action="courseAddServlet" method="post" id="add_class_form">
						课程名称 <input type="text" name="course_name" id="stuname" />

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



	<div style="position: absolute; right: 2em; top: 2em;">
		<a class="rkmd-btn btn-white ripple-effect ripple-dark" href="#"
			data-toggle="modal" data-target="#myModal2" id="">增加课程</a>
		&nbsp;&nbsp;&nbsp;
	</div>
	<div>
		<div style="float: none; margin: 20px;">
			
		</div>
	</div>
	<div style="margin: 35px !important;  position: absolute; top: 2.9em; right:0.1em; left:0.1em;">
		<table class="ui striped selectable grey table" id="classes">
			<thead>
				<tr>
					<th width="200px">课程ID</th>
					<th width="600px">课程名称</th>
					<th>修改操作</th>
					<th>删除操作</th>
				</tr>
			</thead>
			<tbody>
				</div>


				<c:forEach var="sc" items="${classlist}">
					<tr id="">
						<td width="200px" id="sourceName">${sc.id}</td>
						<td width="600px" id="classify_name">${sc.name}</td>
						<td><a class="rkmd-btn btn-lightBlue ripple-effect" href="#"
							data-toggle="modal" fhref="${sc.id}" id="modify_button"
							sname="${sc.id}" sclassify="${sc.name}" data-target="#myModal">修改</a>
						</td>
						<td>
							<div>
								<button class="rkmd-btn btn-lightBlue" disabled="">无权限</button>

							</div>

						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>


	</div>






	<script src="<%=path%>/js/index.js"></script>
	<script>
		$("#modify_class").click(function() {

			$("#form_modify_class").submit();

		});
		function processInnderDiv(domDiv) {
			$("#classId").attr("value", domDiv.getAttribute("fhref"));
			$("#stuname").attr("value", domDiv.getAttribute("sclassify"));

		}
		document.getElementById("classes").addEventListener("click",
				function(event) {
					processInnderDiv(event.target);
				}, false);

		$("#add_class").click(function() {

			$("#add_class_form").submit();
		});
	</script>
	<script type="text/javascript" color="0,0,0" opacity='1' zIndex="-7"
		count="200" src="<%=path%>/js/nest.js"></script>
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