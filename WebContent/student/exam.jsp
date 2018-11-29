<%@page import="com.onlinexam.po.Question"%>
	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

			<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>
	<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
	<script src="<%=path%>/js/jquery.js"></script>
	<title></title>
	<link href="<%=path%>/css/semantic.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/layui/css/layui.css" rel="stylesheet" />
	<script src="<%=path %>/layui/layui.all.js"></script>
	<script src="<%=path %>/layui/lay/modules/laydate.js"></script>
	<script src="<%=path%>/js/semantic.js"></script>
	<script language="javascript" type="text/javascript">
		document.onkeydown = function () {
			if (event.keyCode == 116) {
				event.keyCode = 0;
				event.returnValue = false;
			}
		};
		document.oncontextmenu = function () {
			event.returnValue = false;
		};

	</script>
	<style>
		#fd {
			position: fixed;
			*position: absolute;
			top: 10px;
			margin-top: 10px;
		}

		p {
			text-indent: 5em;
		}
		#submitButton {
			position: fixed;
			*position: absolute;
			top: 50px;
			left: 30px;
			margin-top: 50px;
		}

	</style>
</head>

<body onselectstart="return false">

	<h1>
		<center>${test.name}</center>
	</h1>
	<center>
		<p>${test.courseName} &emsp;&emsp;&emsp; ${test.classNames} &emsp;&emsp;&emsp;
		</p>
	</center>
	<blockquote class="layui-elem-quote" style="" id="fd">
		<span style="color: #ff0000">
			<b>离选择结束还有:&emsp;&emsp;&emsp;</b>
		</span>
		<span id="timezz"></span>
	</blockquote>


	<fieldset class="layui-elem-field layui-field-title" style="margin: 20px 10%;">
		<legend>
			<b>姓名：</b>${user.name} &emsp;&emsp;
			<b>会员编号：</b>${user.id}</legend>
	</fieldset>
	<div style="margin-left: 30%;">
		<form id="form1" name="form1" method="post" action="<%=path %>/studentTest?&testId=${test.id}">
			<p>
				<b>请选择菜品，不选口味默认不选择此菜品
				</b>
			</p>
			<ul class="layui-timeline">
				<input type="hidden" id="test1" />
				<input type="hidden" value="${scoreperques}" name="scoreperques" />
				<input type="hidden" value="${test.course_id}" name="courseId" />
				
				<c:forEach var="que" items="${quesList}" varStatus="status">
					<li class="layui-timeline-item">
						<i class="layui-icon layui-timeline-axis"></i>
						<div class="layui-timeline-content layui-text">
							<h3 class="layui-timeline-title">${status.index + 1}.&nbsp;&nbsp;${que.que_title}</h3>
							<p>
								<span>A.&nbsp;&nbsp;${que.choice_A } </span>&emsp;&emsp;
								<span>B.&nbsp;&nbsp;${que.choice_B }</span>
							</p>
							<p>
								<span> C.&nbsp;&nbsp;${que.choice_C }</span>&emsp;&emsp;
								<span>D.&nbsp;&nbsp;${que.choice_D }</span>
							</p>
							<p>
								A.
								<input type="radio" name="ques_${que.id}" value="A" />&emsp;&emsp; B.
								<input type="radio" name="ques_${que.id}" value="B" />&emsp;&emsp; C.
								<input type="radio" name="ques_${que.id}" value="C" />&emsp;&emsp; D.
								<input type="radio" name="ques_${que.id}" value="D" />&emsp;&emsp;
							</p>
						</div>
					</li>
				</c:forEach>
			</ul>
			<div>
				<div>

					<div id="fd" style="display:none;">
						<span style="color: #ff0000">菜品选择剩余时间</span>
						<br />
						<input size="12" type="hidden" value="45分00秒" name="input1" id="input1" readonly="readonly" />
						<br />
						<script language="javascript">
							var sec = 00;
							var min = ${ current };
							var hou = 0;
							flag = 0;
							idt = window.setTimeout("update();", 1000);
							function update() {
								//以下是倒计时实现方式
								if (min == 9 && sec == 59) {
									alert("还剩10分钟，请抓紧时间选择！");
								} //当时间到35的时候就提示还有十分钟
								if (min == 0 && sec == 0) {
									window.tijiao=true;
									form1.submit();
								} //当到45分的时候就自动提交
								sec--;
								if (sec == 0 && min > 0) {
									sec = 60;
									min -= 1;
								}
								//if((min>0)&&(flag==0)){flag=1;}
								document.form1.input1.value = min + "," + sec;
								idt = window.setTimeout("update();", 1000);
							}
						</script>
					</div>

					<div id="time"></div>


					<p class="text"></p>
						<div id="submitButton" >
							<button name="button2" id="button2" value="" class="layui-btn layui-btn-normal">确认</button>
						</div>
		</form>
		<label>
			
		</label>
		<input type="hidden" size="8" value="0时0分0秒" name="hidden1" />
		<script>
			window.tijiao = false;
			$("#button2").click(function(){
				layer.confirm('确定要提交吗?', {
					btn: ['提交', '取消'] //按钮
				}, function () {
					layer.msg('正在提交中', { icon: 1 });

					setTimeout("$('#form1').submit();",1000);
				}, function () {

				});
				console.log(form1);
				return false;

			});

		</script>

		<script>
			var util = layui.util
				, laydate = layui.laydate
				, layer = layui.layer;
			var thisTimer, setCountdown = function (y, M, d, H, m, s) {
				var date1 = new Date().setMinutes(new Date().getMinutes() + ${ current });
				var endTime = date1; //结束日期
				console.log(date1);
				var serverTime = new Date(); //假设为当前服务器时间，这里采用的是本地时间，实际使用一般是取服务端的

				clearTimeout(thisTimer);
				util.countdown(endTime, serverTime, function (date, serverTime, timer) {
					var str = date[2] + '分' + date[3] + '秒';
					lay('#timezz').html(str);
					thisTimer = timer;
				});
			};
			setCountdown(2099, 1, 1);

			laydate.render({
				elem: '#test1'
				, type: 'datetime'
				, value: new Date()
				, done: function (value, date) {
					setCountdown(date.year, date.month - 1, date.date, date.hours, date.minutes, date.seconds);
				}
			});
		</script>

		<script>
			var sec1 = 0;
			var min1 = 0;
			var hou1 = 0;
			flag1 = 0;
			idt1 = window.setTimeout("update22();", 1000);
			function update22() {
				sec1++;
				if (sec1 == 60) {
					sec1 = 0;
					min1 += 1;
				}
				if (min1 == 60) {
					min1 = 0;
					hou1 += 1;
				}
				if ((min1 > 0) && (flag1 == 0)) {
					flag1 = 1;
				}
				document.form1.hidden1.value = min1 + "分" + sec1 + "秒";
				idt1 = window.setTimeout("update22();", 1000);
			};
		</script>

		</div>
		</div>
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