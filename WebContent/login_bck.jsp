<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<title>login.jsp</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="<%=path%>/css/style_login.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="<%=path%>/css/normalize.min.css">
<link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/verify.css">
<link href="<%=path %>/css/semantic.css" rel="stylesheet">
<script src="<%=path%>/js/jquery.min.js"></script>
<script src="<%=path%>/js/semantic.js"></script>
<script src="<%=path%>/layer/layer.js"></script>

</head>

<body style="background:url('<%=path %>/img/bg1.jpg');background-position:center;">
	<div class="form">

		<ul class="tab-group">
			<li class="tab  active"><a href="#login">Log In</a></li>
			<li class="tab "><a href="#signup">Sign Up</a></li>

		</ul>

		<div class="tab-content">
			
			<div id="login">
				<h1>登录</h1>

				<form action="loginServlet" method="post" class="login_form" id="form1" onsubmit="return check();">

					<div class="field-wrap">
						<label> 工号<span class="req">*</span>
						</label> <input id="username" name="username" type="text" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> 请输入密码<span class="req">*</span>
						</label> <input  id="password"  name="password" type="password" required autocomplete="off" />
					</div>
					

					<div class="field-wrap">
						<div id="mpanel1" >
						</div>			
					</div>
					<div class="top-row">
					<div	 class="field-wrap">
						<div class="filter-box" >

							<select name="role" class="ui dropdown" id="dropdown" style="background: rgba(19, 35, 47, 0.9);">
								<option value="admin" >管理员</option>
								<option value="student">学生</option>
								<option value="teacher" selected>教师</option>

							</select>
						</div>
						</div>
					</div>

					<p class="forgot">
						<a href="#">忘记密码?</a>
					</p>

					<button class="button login_button button-block" onclick="ajaxFunc();">
					登录
					</button>

				</form>

			</div>
			
			<div id="signup">
				<h1>注册</h1>

				<form action="loginServlet" method="post">

					<div>
						<div class="field-wrap">
							<label> 工号<span class="req">*</span>
							</label> <input type="text" required autocomplete="off" />
						</div>

					</div>


					<div class="field-wrap">
						<label> 请输入密码<span class="req">*</span>
						</label> <input type="password" required autocomplete="off" />
					</div>

					<button class="button button-block" " />
					注册
					</button>

				</form>

			</div>
			
		</div>
		<!-- tab-content -->

	</div>
	<!-- /form -->


	
	<script>
	window.verCode = 0;
	window.success = 0;
	</script>
	<script type="text/javascript">
	//本小插件支持移动端哦
	
	function fieldCheck(){
		return ( $('#username').val() == "" || $('#username').val() == null || $('#password').val() == "" || $('#password').val() == null);
	}
	
	function ajaxFunc(){
		//alert("ajax called");
		//alert(success);
		if(verCode == 0 || fieldCheck())
			return;
		window.success = 0;
		
		$.ajax({
            url:"loginServlet",
            type:"post",
            dataType:"text",
            data:$('#form1').serialize(),//数据为登录名和登录密码
            
            beforeSend:function(){
           // 	$('#username').val("");
                
            },
            success:function(data){//处理返回的信息，true则跳转，false则提示密码错误
          //	alert("success ajax return");
                if(data=="-1"){
                	//alert(data + "  data=-1");
                	layer.open({
          			  title: '',
          			anim: 6,
          			  content: '用户名或密码输入错误 请重新输入',
          			  yes: function(i,d){$('#username').val("");$('#password').val("");layer.close(i);}
          			});  
                	
                	window.success = 0;
                }else{
                //	alert(data + "  going to submit");
                	window.success = 1;
                      $("#form1").submit();
                }
            },
        });
	}
	 
	//这里是初始化
	$('.dropdown').dropdown();
</script>
<script type="text/javascript" src="js/verify.js" ></script>
<script type="text/javascript">
function check() {
	//alert("check" + success);
	if (window.verCode === 1 && success == 1) {
		console.log("YES");
		return true;
	} else if(verCode == 0) {
    	layer.open({
			  title: ''
			  ,content: '请先进行验证码认证'
			});
		return false;
	} else {return false;}
}
	
	
	$('#mpanel1').slideVerify({
		type : 1,		//类型
		vOffset : 5,	//误差量，根据需求自行调整
		barSize : {
			width : '100%',
			height : '40px',
		},
		ready : function() {
		},
		success : function() {
			window.verCode = 1;
			// alert(verCode)
			// alert('验证成功，添加你自己的代码！');
			//......后续操作
		},
		error : function() {
			window.verCode = 0;
			
		}
		
	});
		
	
</script>

</body>
</html>
