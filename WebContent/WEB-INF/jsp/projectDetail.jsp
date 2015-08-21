<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="java.util.ArrayList"
	import="Beans.CategoryBean" import="Beans.UserBean"%>
<% UserBean user = null;
if(request.getSession().getAttribute("USER_INF") instanceof UserBean){
	user = (UserBean)request.getSession().getAttribute("USER_INF");
} 
String projectId = "";
if(request.getAttribute("PROJECT_ID") instanceof String){
	projectId = (String)request.getAttribute("PROJECT_ID");
}
%>
<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Mon Apr 20 2015 01:31:28 GMT+0000 (UTC) -->
<html data-wf-site="5529405753ab13dd4efff00c"
	data-wf-page="5533380986ac3db85c98f433">
<body>
<div id="hidden_user_name" style="display:none"><%=user.getAccountName()%></div>
<div id="hidden_user_id" style="display:none"><%=user.getUserId()%></div>
<div id="hidden_project_id" style="display:none"><%=projectId %></div>
	<header class="w-section navbar">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	<div class="w-section">
		<div>
			<h1 class="contentsadd">プロジェクト詳細</h1>
		</div>
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

	<script src="<%=request.getContextPath()%>/res/js/socket.io.js"></script>
	<script src="<%=request.getContextPath()%>/res/js/main.js"></script>
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>