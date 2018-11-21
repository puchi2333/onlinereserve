<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/layui/css/layui.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/layui/css/global.css" rel="stylesheet" type="text/css" />

<script src="<%=path %>/layui/layui.js" charset="utf-8"></script>
<script>
history.go(1);//屏蔽回退
	document.oncontextmenu = function(e){
		if(e==null)e = window.event;
		e.cancelBubble = true;
		e.returnValue=false;
		return true;//右键屏蔽
	};
</script>
</head>

<body>
<div class="layui-header header header-demo">
<div class="layui-main">
	<a class="" style="position :absolute; left:00%; top:10px;"><img src="<%=path%>/img/logo.png" style="width:250px;height:40px"></img></a>
	<ul class="layui-nav">
	  <li class="layui-nav-item"><a href="<%=path%>/acceptedOrderServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>已接收的菜单</span> </a></li>
  <li class="layui-nav-item layui-this"><a href="<%=path%>/testQueryServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>已发布的菜单</span></a></li>
  <li class="layui-nav-item "> <a href="<%=path%>/papersCompareServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>订单分析</span></a></li>
  <li class="layui-nav-item "><a href="<%=path%>/testAddServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>发布菜单</span></a></li>
  <li class="layui-nav-item"><a href="<%=path%>/questionQueryServlet" target="mainFrame"><i class="fa fa-cogs"></i><span>菜品管理</span> </a></li>
  <li class="layui-nav-item" lay-unselect="">
    <a href="javascript:;"><img src="http://t.cn/RCzsdCq" class="layui-nav-img">${ sessionScope.user.name} </a>
    <dl class="layui-nav-child">
      <dd><a href="#" onclick="logout();" ><i class="fa fa-cogs"></i><span>退出用户</span></a></dd>
    </dl>
  </li>
  </ul>
</div>
</div>
	
</body>

<script>
function logout(){
	console.log("called");
	window.parent.frames['mainFrame'].showMsg();
	
}
</script>

<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use('element', function(){
  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
  
  //监听导航点击
  element.on('nav(demo)', function(elem){
    //console.log(elem)
    layer.msg(elem.text());
  });
});
</script>
</html>