<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=path%>/js/echart.js"></script>
<link href="<%=path %>/layui/css/layui.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
<fieldset class="layui-elem-field">
  <legend>销量分布散点图</legend>
  <div class="layui-field-box">
    <div id="main" style="width: 85%;height:400px;float:none;"></div>
  </div>
</fieldset>
<fieldset class="layui-elem-field">
  <legend>销量统计折线图与直方图</legend>
  <div class="layui-field-box">
    <div id="main2" style="width: 600px;height:400px; float:left;"></div>
<div id="main3" style="width: 600px;height:400px; float:left;"></div>
  </div>
</fieldset>

<script>
var myChart = echarts.init(document.getElementById('main'));

option = {
		tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'line',
	            label: {
	                backgroundColor: '#283b56',
	                formatter:'用户ID:{value}'
	            }
	        }
	    },
	    toolbox: {
	        show: true,
	        feature: {
	            dataView: {readOnly: false},
	            restore: {},
	            saveAsImage: {}
	        }
	    },
	  
	    xAxis: {type: 'category',name:"用户ID"},
	    yAxis: {'max':100,name:'成交价'},
	    series: [{
	    		name:"成交价",
	        symbolSize: 25,
	        data: ${data},
	        type: 'scatter'
	    }]
	};
myChart.setOption(option);
</script>

<script>
var myChart = echarts.init(document.getElementById('mai1'));
option = {
		tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'line',
	            label: {
	                backgroundColor: '#283b56',
	                formatter:"用户ID：{a}<br/> 成交价:{b}"
	            }
	    
	        }
	    },
	    toolbox: {
	        show: true,
	        feature: {
	            dataView: {readOnly: false},
	            restore: {},
	            saveAsImage: {}
	        }
	    },
	    dataZoom: {
	        show: false,
	        start: 0,
	        end: 100
	    },
	    xAxis: {type: 'category',name:"用户ID"},
	    yAxis: {'max':100,name:'成交价'},
	    series: [{
	        symbolSize: 20,
	        data: ${data},
	        type: 'pie'
	    }]
	};
myChart.setOption(option);
</script>
<script>
var myChart = echarts.init(document.getElementById('main2'));
option = {
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross',
	            label: {
	                backgroundColor: '#283b56',
	                formatter:'菜品号：{value}'
	            }
	        }
	    },

	    toolbox: {
	        show: true,
	        feature: {
	            dataView: {readOnly: false},
	            restore: {},
	            saveAsImage: {}
	        }
	    },
	    dataZoom: {
	        show: false,
	        start: 0,
	        end: 100
	    },
	    xAxis: {
	    		name:'销售次数',
	        type: 'category'
	    },
	    yAxis: {
	    	name:'菜品号',
	        type: 'value'
	    },
	    series: [{
	    		name:'销售次数',
	        data: ${data1},
	        type: 'bar'
	    }]
	};
myChart.setOption(option);
</script>

<script>
var myChart = echarts.init(document.getElementById('main3'));
option = {
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {
	            type: 'cross',
	            label: {
	                backgroundColor: '#283b56',
	                formatter:'菜品号：{value}'
	            }
	        }
	    },

	    toolbox: {
	        show: true,
	        feature: {
	            dataView: {readOnly: false},
	            restore: {},
	            saveAsImage: {}
	        }
	    },
	    dataZoom: {
	        show: false,
	        start: 0,
	        end: 100
	    },
	    xAxis: {
	    		name:'销售次数',
	        type: 'category'
	    },
	    yAxis: {
	    	name:'菜品号',
	        type: 'value'
	    },
	    series: [{
	    		name:'销售次数',
	        data: ${data1},
	        type: 'line'
	    }]
	};
myChart.setOption(option);
</script>
<script>

</script>

</body>
</html>