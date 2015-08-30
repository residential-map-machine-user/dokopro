<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="java.util.ArrayList"
	import="Beans.CategoryBean" import="Beans.UserBean"%>
<%
	UserBean user = null;
	if (request.getSession().getAttribute("USER_INF") instanceof UserBean) {
		user = (UserBean) request.getSession().getAttribute("USER_INF");
	}
	String projectId = "";
	if (request.getAttribute("PROJECT_ID") instanceof String) {
		projectId = (String) request.getAttribute("PROJECT_ID");
	}
%>
<html>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
</head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/res/css/reset.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/res/css/task.css">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/res/js/imagesloaded.pkgd.min.js"></script>
<script src="<%=request.getContextPath()%>/res/js/masonry.pkgd.min.js"></script>
<script src="<%=request.getContextPath()%>/res/js/task.js"></script>
<script src="<%=request.getContextPath()%>/res/js/socket.io.js"></script>
<script src="<%=request.getContextPath()%>/res/js/main.js"></script>
<div id="hidden_user_name" style="display: none"><%=user.getAccountName()%></div>
<div id="hidden_user_id" style="display: none"><%=user.getUserId()%></div>
<div id="hidden_project_id" style="display: none"><%=projectId%></div>
<div class="wrapper">
	<div class="container">
		<ul class="photo-tile">
			<li><a href="#">
					<div class="item-photo">
						<h2>dummy data dummy data dummy datadummy datadummy
							datadummy datadummy datadummy data</h2>
						<p>
					</div>
					<div class="item-info c2"></div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c1"></div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c5"></div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c4">
						<h1>Sakura</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c1">
						<h1>Antique interior light</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c5">
						<h1>Clock tower</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info">
						<h1>No image</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c2">
						<h1>Matsuyama Catsle</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c3">
						<h1>Rainbow</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c1">
						<h1>Tiger</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c5">
						<h1>Classic car</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c3">
						<h1>Cat chocolates</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c2">
						<h1>View</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c4">
						<h1>Sakura</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c1">
						<h1>Interior light</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info">
						<h1>No image</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c5">
						<h1>Classic car</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c2">
						<h1>Sakura</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c2">
						<h1>Matsuyama Catsle</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c5">
						<h1>Rainbow</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c3">
						<h1>Tiger</h1>
					</div>
			</a></li>
			<li><a href="#">
					<div class="item-photo"></div>
					<div class="item-info c4">
						<h1>Sakura</h1>
					</div>
			</a></li>
		</ul>
	</div>
	<section class="chat-wrapper">
		<ul class="pages">
			<li class="chat page">
				<div class="chatArea">
					<ul class="messages"></ul>
				</div> <input class="inputMessage" placeholder="Type here..." />
			</li>
			<link rel="stylesheet"
				href="<%=request.getContextPath()%>/res/css/style.css">
			<li class="login page">
				<div class="form">
					<h3 class="title">What's your nickname?</h3>
					<input class="usernameInput" type="text" maxlength="14" />
				</div>
			</li>
		</ul>
	</section>
</div>
</body>
</html>
