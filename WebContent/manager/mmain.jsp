
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script src="../js/jquery.js"></script>

<style>
@import url("https://fonts.googleapis.com/css?family=Montserrat:200,300,400,600");
.more-pens {
  position: fixed;
  left: 20px;
  bottom: 20px;
  z-index: 10;
  font-family: "Montserrat";
  font-size: 12px;
}

a.white-mode, a.white-mode:link, a.white-mode:visited, a.white-mode:active {
  font-family: "Montserrat";
  font-size: 12px;
  text-decoration: none;
  background: #212121;
  padding: 4px 8px;
  color: #f7f7f7;
}
a.white-mode:hover, a.white-mode:link:hover, a.white-mode:visited:hover, a.white-mode:active:hover {
  background: #edf3f8;
  color: #212121;
}

body {
  margin: 0;
  padding: 0;
  overflow: hidden;
  width: 100%;
  height: 100%;
  background: #000000;
}

.title {
  z-index: 10;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translateX(-50%) translateY(-50%);
  font-family: "Montserrat";
  text-align: center;
  width: 100%;
}
.title h1 {
  position: relative;
  color: #fff;
  font-weight: 600;
  font-size: 60px;
  padding: 0;
  margin: 0;
  line-height: 1;
  text-shadow: 0 0 30px #000155;
}
.title h1 span {
  font-weight: 600;
  padding: 0;
  margin: 0;
  color: #BBB;
}
.title h3 {
  font-weight: 200;
  font-size: 20px;
  padding: 0;
  margin: 0;
  line-height: 1;
  color: #FFF;
  letter-spacing: 2px;
  text-shadow: 0 0 30px #000155;
}
</style>
</head>
<body>

<div class="title">
    <h3>OnlineExam - 2018</h3>
    <h1>学生在线考试系统</h1>
    <h3>高校大规模考试解决方案</h3>
	<h5 style="color:#fff">Copyright © 2018 King's Landing. All rights reserved.</h5>
</div>

<script>
'use strict';

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var max_particles = 1000;

var tela = document.createElement('canvas');
tela.width = $(window).width();
tela.height = $(window).height();
$("body").append(tela);

var canvas = tela.getContext('2d');

var Particle = function () {
  function Particle(canvas, progress) {
    _classCallCheck(this, Particle);

    var random = Math.random();
    this.progress = 0;
    this.canvas = canvas;

    this.x = $(window).width() / 2 + (Math.random() * 200 - Math.random() * 200);
    this.y = $(window).height() / 2 + (Math.random() * 200 - Math.random() * 200);

    this.w = $(window).width();
    this.h = $(window).height();
    this.radius = random > .2 ? Math.random() * 1 : Math.random() * 3;
    this.color = random > .2 ? "#d8002c" : "#F9314C";
    this.radius = random > .8 ? Math.random() * 2 : this.radius;
    this.color = random > .8 ? "#7DFFF2" : this.color;

    // this.color  = random > .1 ? "#ffae00" : "#f0ff00" // Alien
    this.variantx1 = Math.random() * 300;
    this.variantx2 = Math.random() * 400;
    this.varianty1 = Math.random() * 100;
    this.varianty2 = Math.random() * 120;
  }

  Particle.prototype.render = function render() {
    this.canvas.beginPath();
    this.canvas.arc(this.x, this.y, this.radius, 0, 2 * Math.PI);
    this.canvas.lineWidth = 2;
    this.canvas.fillStyle = this.color;
    this.canvas.fill();
    this.canvas.closePath();
  };

  Particle.prototype.move = function move() {
    // this.x += (Math.sin(this.progress/this.variantx1)*Math.cos(this.progress/this.variantx2));
    // this.y += (Math.sin(this.progress/this.varianty1)*Math.cos(this.progress/this.varianty2));
    this.x += Math.sin(this.progress / this.variantx1) * Math.cos(this.progress / this.variantx2);
    this.y += Math.cos(this.progress / this.varianty2);

    if (this.x < 0 || this.x > this.w - this.radius) {
      return false;
    }

    if (this.y < 0 || this.y > this.h - this.radius) {
      return false;
    }
    this.render();
    this.progress++;
    return true;
  };

  return Particle;
}();

var particles = [];
var init_num = popolate(max_particles);

function popolate(num) {
  for (var i = 0; i < num; i++) {
    setTimeout(function () {
      particles.push(new Particle(canvas, i));
    }.bind(this), i * 20);
  }
  return particles.length;
}

function clear() {
  canvas.globalAlpha = 0.05;
  canvas.fillStyle = '#000';
  canvas.fillRect(0, 0, tela.width, tela.height);
  canvas.globalAlpha = 1;
}

function update() {
  particles = particles.filter(function (p) {
    return p.move();
  });
  if (particles.length < init_num) {
    popolate(1);
  }
  clear();
  requestAnimationFrame(update.bind(this));
}
update();
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
</body>
</html>

