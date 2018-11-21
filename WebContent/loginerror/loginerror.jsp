<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<!--[if IE 8 ]><html class="no-js oldie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="no-js oldie ie9" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>

   <!--- basic page needs
   ================================================== -->
   <meta charset="utf-8">
	<title>Quatro - Slideshow</title>
	<meta name="description" content="">  
	<meta name="author" content="">

   <!-- mobile specific metas
   ================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

 	<!-- CSS
   ================================================== -->
   <link rel="stylesheet" href="<%=path %>/loginerror/css/base.css">  
   <link rel="stylesheet" href="<%=path %>/loginerror/css/main.css">
   <link rel="stylesheet" href="<%=path %>/loginerror/css/vendor.css">     

   <!-- script
   ================================================== -->
	<script src="<%=path %>/loginerror/js/modernizr.js"></script>

   <!-- favicons
	================================================== -->
	<link rel="icon" type="image/png" href="favicon.png">

</head>

<body>

	<!-- header 
   ================================================== -->
   <header class="main-header">
   	<div class="row">
   		<div class="logo">
	         <a href="../login.jsp">Onlinexam</a>
	      </div>   		
   	</div>   
   </header> <!-- /header -->

   <!-- navigation 
   ================================================== -->
	<!-- main content
   ================================================== -->
   <main id="main-404-content" class="main-content-slides">

   	<div class="content-wrap">

		   <div class="shadow-overlay"></div>

		   <div class="main-content">
		   	<div class="row">
		   		<div class="col-twelve">
			  		
			  			<h2 class="kern-this">无法找到登录用户，请重新登录</h2>
			  			<p>
							可能出现cookie过期，或者浏览器sessionID异常等错误。3秒后自动跳转至登录页面
			  			</p>	   			
			  			<p>点击返回<a href="../login.jsp">登录页面</a></p>

			   	</div> <!-- /twelve --> 		   			
		   	</div> <!-- /row -->    		 		
		   </div> <!-- /main-content --> 



		</div> <!-- /content-wrap -->
   
   </main> <!-- /main-404-content -->

   <div id="preloader"> 
    	<div id="loader"></div>
   </div> 

   <!-- Java Script
   ================================================== --> 
   <script src="<%=path %>/js/jquery.js"></script>
   <script src="<%=path %>/loginerror/js/plugins.js"></script>
   <script src="<%=path %>/loginerror/js/main.js"></script>
<script>
	setTimeout("window.open('<%=path%>/login.jsp','_parent')",3000);
	</script>
</body>

</html>