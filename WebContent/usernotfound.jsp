<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>User Not Found</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/htmleaf-demo.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/demo.css">
    <link rel="stylesheet" type="text/css" href="<%=path %>/css/mimic.css">
      <script src="<%=path %>/js/jquery.js"></script>
</head>
<body>
	<!-- <div class="htmleaf-container">

		<div class="center">
			<h1 class="mimic nope"> 用户没有找到，您可能忘记登录了？ </h1>
		        <div class="description">
		            您确实忘了登录,正在帮您跳转登录页面...
		        </div>
		         <div class="controls" >
		            <form>		            
		                <div class="select">
		                    <select>
		                        <option value="boomerang">boomerang</option>
		                        <option value="swivelChair">swivel chair</option>
		                        <option value="gettinInYoFace">gettin' in yo face</option>
		                        <option value="airplanePropeller">airplane propeller</option>
		                        <option value="pulsate">pulsate</option>
		                        <option value="candleInTheWind">candle in the wind</option>
		                        <option value="highlighter">highlighter</option>
		                        <option value="lawnMower">lawn mower</option>
		                        <option value="bungee">bungee</option>               
		                        <option value="nope">nope</option>
		                        <option value="heartBeat">heartbeat</option>
		                        <option value="sleepyEyes">sleepy eyes</option>
		                        <option value="plummit">plummit</option>
		                        <option value="dropItLikeItsHot">drop it like it's hot</option>
		                        <option value="gettinLifted">lifted</option>
		                        <option value="glaucoma">glaucoma</option>
		                        <option value="chameleon">chameleon</option>
		                        <option value="backdrop">backdrop</option>
		                    </select>
		                </div>

		                <button>mimic</button>
		            </form>

		        </div>
		</div>
	</div>
	 -->
	<script>
	setTimeout("window.open('<%=path%>/loginerror/loginerror.jsp','_parent')",1);
	</script>
</body>
</html>