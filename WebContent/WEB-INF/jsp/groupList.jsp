<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="java.util.ArrayList"
	import="Beans.GroupBean"%>
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
			if (groupList instanceof List<?>) {
				groupList = (List<GroupBean>) request.getAttribute("GROUPLIST");
			}
		%>
	</header>
	<div class="w-section">
		<div class="w-container">
			<h1 class="teamlisthead">チーム一覧</h1>
			<div>
				<a class="button"
					href="<%=request.getContextPath()%>/front/group/add">チーム作成</a>
			</div>
		</div>
	</div>
	<div class="w-section">
		<div class="w-container">
			<div class="w-row">
				<%
					for (int i = 0; i < groupList.size(); i++) {
				%>
				<div class="w-col w-col-3">
					<div>
						<h1 class="teamnameing">
							<a
								href="<%=request.getContextPath()%>/front/group/detail/<%=groupList.get(i).getGroupId()%>"><%=groupList.get(i).getGroupName()%>
							</a>
						</h1>
						<div>
							<p><%=groupList.get(i).getDescription() %></p>
							<div>
								<div class="w-row">
									<div class="w-col w-col-6">
										<div class="teamhowmuch">人数 ４人</div>
									</div>
									<div class="w-col w-col-6">
										<div class="statusoftem">募集中</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>