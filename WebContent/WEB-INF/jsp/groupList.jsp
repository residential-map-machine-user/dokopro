<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="java.util.ArrayList"
	import="Beans.GroupBean" import="Beans.ProjectBean"%>
<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Mon Apr 20 2015 01:31:28 GMT+0000 (UTC) -->
<html data-wf-site="5529405753ab13dd4efff00c"
	data-wf-page="553402e0fd7ee5b552c34048">
<head>
<meta charset="utf-8">
<title>teamList</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="generator" content="Webflow">
</head>
<body>
	<header class="w-section navbar">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
		<%
			List<GroupBean> groupList = new ArrayList<GroupBean>();
			if (request.getAttribute("GROUP_LIST") instanceof List<?>) {
				groupList = (List<GroupBean>) request
						.getAttribute("GROUP_LIST");
			}
			List<List<ProjectBean>> nestedProjectList = new ArrayList<List<ProjectBean>>();
			if (request.getAttribute("NESTED_PROJECT_LIST") instanceof List<?>) {
				nestedProjectList = (List<List<ProjectBean>>) request
						.getAttribute("NESTED_PROJECT_LIST");
			}
		%>
	</header>
	<div class="w-section">
		<div class="w-container">
			<h1 class="teamlisthead">チーム一覧</h1>
			<a class="button teamaddbutton"
				href="<%=request.getContextPath()%>/front/group/add">新規チーム作成</a>
			<div></div>
		</div>
	</div>
	<div class="w-section">
		<div class="w-container"></div>
	</div>
	<%
		for (int i = 0; i < groupList.size(); i++) {
	%>
	<div class="w-section wrapperteaminfo">
		<div class="w-container teaminfo">
			<div>
				<div>
					<div>
						<h1 class="teamtitle">
							<a
								href="<%=request.getContextPath()%>/front/group/detail/<%=groupList.get(i).getGroupId()%>"><%=groupList.get(i).getGroupName()%></a>
						</h1>
					</div>
					<div class="teamex">
						<p>チーム概要</p>
						<p><%=groupList.get(i).getDescription()%></p>
					</div>
				</div>
				<div>
					<div>
						<div class="row">
							<%for(int j=0;j < nestedProjectList.get(i).size();j++){ %>
							<div class="col-md-4">
								<div class="panel panel-info">
									<div class="panel-heading">
										<h3 class="panel-title"><%=nestedProjectList.get(i).get(j).getProjectName() %></h3>
									</div>
									<div class="panel-body"><%=nestedProjectList.get(i).get(j).getProjectSummery() %></div>
								</div>
							</div>
							<%} %>
						</div>
						<div></div>
					</div>
					<div class="joinbuttonwrapper">
						<a class="button"
							href="<%=request.getContextPath()%>/front/group/detail/<%=groupList.get(i).getGroupId()%>">詳細</a>
					</div>
				</div>
			</div>
		</div>
		<%
			}
		%>
	</div>
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>