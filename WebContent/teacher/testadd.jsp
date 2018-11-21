<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<title></title>
<link href="<%=path%>/css/semantic.css" rel="stylesheet" type="text/css" />


<link href="<%=path %>/layui/css/layui.css" rel="stylesheet" />
<script src="<%=path %>/layui/layui.js" ></script>
<script src="<%=path%>/js/semantic.js"></script>

</head>

<body>
<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<b>${user.name}，</b>欢迎来到发布菜单页面</legend>
</fieldset>
	<div style="width: 100%; height: 100%; display: none;" id="loding"></div>
	<div id="page" style="margin: 2cm 4cm 3cm 4cm;">

		<form id="form1" name="form1" method="post" class="ui form"
			onsubmit="return formCheck();" action='<%=path%>/testAddServlet'>
			<div class="field">
				<div class="field">
				<label>菜单分类为：</label> 
					<select name="courseid" id="courseid" class="ui dropdown">
						<c:forEach var="course" items="${courseList}">
							<option value="${course.id}">${course.name}</option>
						</c:forEach>
					</select>
					
				</div>

				<div class="field">
					<label>菜单名称为： </label>
					<div class="ui input">
						<input type="text" name="testname" value="" class="" onfocus="clearError(this);"
							id="testname" onblur="nullCheck('testname');" />
					</div>
				</div>
				<div class="field">
					<label>菜单截止时间为： </label>
					<div class="ui input">
						<input type="text" name="enddate"  onblur="nullCheck('control_date');" value='' onfocus="clearError(this);" class="layui-input" id="control_date" placeholder="yyyy-MM-dd hh:mm:ss" /> 
						<!-- <input name="enddate" type="text" id="control_date" size="20"
							maxlength="10" readonly="readonly" value=''  onblur="nullCheck('control_date');"onfocus="clearError(this);" />-->
					</div> 
				</div>

				<div class=" two fields">
					<div class="field">
						<label>总价格</label> 
						<input name="sinscores" id="sinscores"
							type="text" size="1" value="100" onblur="nullCheck('sinscores');"  onfocus="clearError(this);"  />
					</div>
					<div class="field">
						<label>菜品总数</label> <input value="10" name="sinnum" type="text"
							id="sinnum" size="5" onblur="nullCheck('sinnum');"  onfocus="clearError(this);"/>
					</div>

				</div>
				<div class="field">
					<label>选择时长</label>
					<div class="ui input">
						<input name="testtime" id="testtime" value="45" type="text"
							size="5" onblur="nullCheck('testtime')" onfocus="clearError(this);"/>
					</div>

				</div>

				<div class="field">
					<label>面向群体</label>
					 <select multiple="" id="cho" name="classCheck" onchange="nullCheck('cho');" class="ui dropdown" onfocus="clearError(this);">
						<c:forEach var="stuclass" items="${classesList}">
							<option value="${stuclass.id}">${stuclass.name}</option>
						</c:forEach>  
						<option id="errormsg" value='' disabled  style='display:none;'>请选择群体</option> 
					</select>

				</div>
				<div class="field"  style="text-align:center">
					<input class="ui primay blue button" type="submit" class="btn_grey"
						value="进入菜品选择" />&nbsp;&nbsp;&nbsp;&nbsp;<br />
				</div>
			</div>
		</form>
		<p>
			
			<script>
				$('.dropdown').dropdown();
				/* Calendar.setup({
					inputField : "control_date",
					ifFormat : "%Y-%m-%d %H:%M:%S",
					showsTime : true,
					timeFormat : "24"
				}); */
			</script>
		</p>
	</div>
	
	
	<script>
		function clearError(t){
			console.log(t);
			$(t).closest(".error").removeClass("error");
			$(t).attr("placeholder","");
		}
		function nullCheck(id){
			console.log("nullCheck called");
			if($('#' + id).val() == '' || $('#' + id).val() == null){
				if("cho" == id){
					$("#errormsg").attr("selected","selected");
				}
				$("#" + id).closest(".field").addClass("error");
				$("#" + id).attr("placeholder","该字段不能为空，请重新输入");
			} else{
				console.log(id);
				if("cho" == id){
					$("#" + id).closest(".error").removeClass("error");
				}
			}
		}
		/* 	function clearError(id){
				console.log($('#' + id).closest(' .error'));
				$('#' + id).closest('.error').removeClass("error");
				$('#' + id).attr('placeholder',"");
			} */
			function formCheck(){
				if($('#cho').val()!=null && $('#cho').val()!="" && $('#control_date').val()!="" && $('#testtime').val()!="" && $('#sinnum').val()!=""){
					console.log("true");
					$('#cho').val();
					return true;
				}
				layui.use('layer',function(){
					layer.alert('请检查表单信息是否完整');
				});
				return false;
				
				
				
			}
		
	</script>
	<script>
			layui.use('laydate', function(){
				  var laydate = layui.laydate;
				console.log(laydate);
				  //常规用法
				  laydate.render({
						elem: '#control_date'
						,type: 'datetime',
						trigger: 'click',
						theme: '#393D49',
						value: new Date()
					  });
			});
				
				
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