<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<title>Foot ball</title>
<meta charset='UTF-8'>

<style>
html, body {
	overflow: hidden;
	height: 100%;
	width: 100%;
	margin: 0px;
}

.container {
	overflow: hidden;
	width: 100%;
	height: 100%;
	border: 1px solid gray;
}

nav {
	float: left;
	max-width: 160px;
	margin: 0;
	height: 80%;
	padding: 10px;
}

aside {
	overflow: hidden;
	width: auto;
	height: 85%;
}

header {
	padding: 1em;
	color: white;
	background-color: black;
	clear: left;
	text-align: center;
	height: 3%;
}

footer {
	padding: 1em;
	color: white;
	background-color: #aaa;
	clear: left;
	text-align: center;
	height: 3%;
}

nav ul {
	list-style-type: none;
	padding: 0;
}

#aside-container, iframe {
	width: 100%;
	height: 100%;
}
</style>

<script type="text/javascript" src="/script/jquery-3.1.1.js"></script>

<script type="text/javascript">
	
	function onload(){
		$(".menu").on("click", function(e){
			console.log('clicked');
			
			if(this.id == "top3Point")
			{
				document.getElementById('aside-container').innerHTML  = "<iframe id='iframe' src='/view/cont/Top3Point.jsp' scrolling='no' framebodrder='1' height='1'> </iframe>";
			}
			else if(this.id == "liWinPoint")
			{
				document.getElementById('aside-container').innerHTML  = "<iframe id='iframe' src='/view/cont/WinPoint.jsp' scrolling='no' framebodrder='1' height='1'> </iframe>";
			}
			else if(this.id == "liScore")
			{
				document.getElementById('aside-container').innerHTML  = "<iframe id='iframe' src='/view/cont/Score.jsp' scrolling='no' framebodrder='1' height='1'> </iframe>";
			}
			else if(this.id == "liGameResult")
			{
				document.getElementById('aside-container').innerHTML  = "<iframe id='iframe' src='/view/cont/GameResult.jsp' scrolling='no' framebodrder='1' height='1'> </iframe>";	
			}
			
		});
	}
	
	
</script>




<body onload="onload();">
	<div class="container">
		<header></header>
		<nav>
			<div>
				<img src="\resources\fifa-img.png" width="100%"
					height="100%"></img>
			</div>
	
			<ul>
				<li class="menu" id="top3Point" style="CURSOR:pointer">Top3 승점</li>
				<li class="menu" id="liWinPoint" style="CURSOR:pointer">승률</li>
				<li class="menu" id="liScore" style="CURSOR:pointer" >전적</li>
				<li class="menu" id="liGameResult" style="CURSOR:pointer">결과</li>
			</ul>
		</nav>


		<aside>
		<!-- 컨텐츠 -->
		<div id="aside-container"></div>
		</aside>


		<footer> Copyright © org.football </footer>
	</div>
</body>

</html>
