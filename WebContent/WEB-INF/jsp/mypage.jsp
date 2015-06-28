<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Beans.UserBean" import="Beans.CategoryBean"
	import="Beans.GroupBean" import="java.util.List"
	import="java.util.ArrayList"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<body>
	<header class="w-section navbar">
		<%
			UserBean user = new UserBean();
			if (request.getSession().getAttribute("USER_INF") instanceof UserBean) {
				user = ((UserBean) request.getSession()
						.getAttribute("USER_INF"));
			}
			List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
			List<GroupBean> groupList = new ArrayList<GroupBean>();
			if (request.getAttribute("GROUP_LIST") instanceof List<?>) {
				groupList = (List<GroupBean>) request
						.getAttribute("GROUP_LIST");
			}
			if (request.getAttribute("CATEGORY_LIST") instanceof List<?>) {
				categoryList = (List<CategoryBean>) request
						.getAttribute("CATEGORY_LIST");
			}
		%>
	</header>
	<div class="w-section">
		<div class="w-container tab">
			<div class="pic">
				<img class="slefpic"
					src="<%=request.getContextPath()%>/res/images/IMG_0181.JPG"
					alt="5534004c86ac3db85c9909a5_IMG_0181.JPG">
				<div class="username"><%=user.getAccountName()%></div>
			</div>
			<div class="sepself"></div>
			<div>
				<div class="w-tabs" data-duration-in="300" data-duration-out="100">
					<div class="w-tab-menu">
						<a class="w-tab-link w-inline-block" data-w-tab="Tab 1">
							<div>受講中コース</div>
						</a> <a class="w-tab-link w--current w-inline-block"
							data-w-tab="Tab 2">
							<div>参加チーム</div>
						</a>
					</div>
					<div class="w-tab-content">
						<div class="w-tab-pane" data-w-tab="Tab 1">
							<div>
								<div class="w-row">
									<div class="w-col w-col-3"></div>
								</div>
								<div>
									<div class="w-row">
										<div class="w-col w-col-3">
											<ul class="w-list-unstyled">
												<%
													for (int i = 0; i < categoryList.size(); i++) {
												%>
												<li><%=categoryList.get(i).getCategoryName()%></li>
												<%
													}
												%>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="w-tab-pane w--tab-active" data-w-tab="Tab 2">
							<div>
								<div class="w-row">
									<div class="w-col w-col-3">
										<ul class="w-list-unstyled">
											<%
												for (int i = 0; i < groupList.size(); i++) {
											%>
											<li><%=groupList.get(i).getGroupName()%></li>
											<%
												}
											%>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>