<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ page import="java.text.SimpleDateFormat" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

        <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
        <html xmlns="http://www.w3.org/1999/xhtml">

        <head>
          <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
          <title></title>
          <script src="<%=path%>/js/jquery.js"></script>
          <link href="<%=path %>/css/semantic.css" rel="stylesheet" type="text/css" />
          <link href="<%=path %>/layui/css/layui.css" rel="stylesheet" type="text/css" />
          <script src="<%=path%>/js/semantic.js"></script>
          <script  src="<%=path%>/layer/layer.js"></script>
          <script src="<%=path %>/layui/layui.all.js"></script>
          
        </head>
	<fieldset class="layui-elem-field layui-field-title">
		<legend>
			<b>${user.name}</b>，菜单查询</legend>
	</fieldset>
        <body>
        
          <div style="margin:40px">
            <table class="ui very compact table">
              <tr align="center">
                <td>
                  <b>菜系</b>
                </td>
                <td>
                  <b>菜单名称</b>
                </td>
                <td>
                  <b>菜单截止时间</b>
                </td>
                <td width="81">
                  <b>选择项</b>
                </td>
              </tr>

              <c:forEach items="${testsList}" var="test">
                <tr align="center">
                  <td>${test.courseName }</td>
                  <td>${test.testName }</td>
                  <td>${test.endDate }</td>
                  <td class="selectable positive">
                    <a href='studentTest?testId=${test.id}&courseid=${test.course_id}' target="_parent">进入选择</a>
                  </td>
                </tr>
              </c:forEach>
            </table>
          </div>
             
        </body>
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