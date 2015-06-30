<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Beans.GroupBean" import="Beans.ProjectBean"
	import="java.util.ArrayList" import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<%
		GroupBean group = new GroupBean();
		if (request.getAttribute("GROUP") instanceof GroupBean) {
			group = (GroupBean) request.getAttribute("GROUP");
		}
		List<ProjectBean> projectList = new ArrayList<ProjectBean>();
		if (request.getAttribute("PROJECT_LIST") instanceof List<?>) {
			projectList = (List<ProjectBean>) request
					.getAttribute("PROJECT_LIST");
		}
	%>
	<div class="row">
		<div class="w-section section">
			<div class="w-container teaminfo">
				<div class="row">
					<div>
						<div>
							<div>
								<h1 class="teamtitle"><%=group.getGroupName()%></h1>
							</div>
							<script>
							$(document).ready(function(){
								var button = $('#joinButton')
								button.click(function(){
									var groupId = "<%=group.getGroupId()%>";
									$.ajax({
										   type: "GET",
										   url: "http://localhost:8080/dokopro/front/group/join/" + groupId,
										   success: function(msg){
												  button.text("参加中");
												  console.log("登録を完了しました");
											  }
										   })
									});
								});
							</script>
							<div style="float:right;font-famly:メイリオ;"><button type="button" id="joinButton">参加する</button></div>
							<div class="teamex">
								<p>チーム概要</p>
								<p><%=group.getDescription()%></p>
							</div>
						</div>
						<div>
							<div></div>
							<div></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="w-section">
		<div class="w-container">
			<div class="row">
				<%
					for (int i = 0; i < projectList.size(); i++) {
				%>
				<div class="col-md-4">
					<div class="panel panel-info">
						<div class="panel-heading"><%=projectList.get(i).getProjectName()%></div>
						<div class="panel-body">
							<p><%=projectList.get(i).getProjectSummery()%></p>
						</div>

						<!-- List group -->
						<ul class="list-group">
							<li class="list-group-item">メンバー</li>
							<li class="list-group-item">開始時期<%=projectList.get(i).getDayStart()%></li>
							<li class="list-group-item">終了時期<%=projectList.get(i).getDayStart()%></li>
							<li class="list-group-item">コミットレベル<%=projectList.get(i).getCommitLevel()%></li>
							<li class="list-group-item">その他</li>
						</ul>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>