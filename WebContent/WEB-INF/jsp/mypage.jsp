<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Beans.UserBean" %>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<body>
	<header class="w-section navbar">
		
		<%
		UserBean user = new UserBean();
		if(request.getSession().getAttribute("USER_INF") instanceof UserBean){
			user =((UserBean)request.getSession().getAttribute("USER_INF"));
		}
		%>
	</header>
	<div class="w-section">
		<div class="w-container tab">
			<div class="pic">
				<img class="slefpic" src="<%=request.getContextPath()%>/res/images/IMG_0181.JPG" alt="5534004c86ac3db85c9909a5_IMG_0181.JPG">
				<div class="username"><%=user.getAccountName() %></div>
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
									<div class="w-col w-col-3">
										<img src="<%=request.getContextPath() %>/res/images/HTML5_logo_and_wordmark.svg.png" width="175"
											alt="5533fe98fd7ee5b552c33fce_HTML5_logo_and_wordmark.svg.png">
									</div>
									<div class="w-col w-col-3">
										<img class="php" src="<%=request.getContextPath() %>/res/images/phplogo-highres.png" width="188"
											alt="5533fee6fd7ee5b552c33fd3_phplogo-highres.png">
									</div>
									<div class="w-col w-col-3">
										<img class="csss" src="<%=request.getContextPath() %>/res/images/css3.jpg" width="188"
											alt="5533ff05fd7ee5b552c33fd5_css3.jpg">
									</div>
									<div class="w-col w-col-3">
										<img src="<%=request.getContextPath() %>/res/images/java_logo.png" width="188"
											alt="5533ff1086ac3db85c990951_java_logo.png">
									</div>
								</div>
								<div>
									<div class="w-row">
										<div class="w-col w-col-3">
											<ul class="w-list-unstyled">
												<li>
													<div>HTML基礎 進捗率30%</div>
												</li>
												<li>HTMLを理解しよう&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;進捗率20%</li>
												<li>HTML応用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
											</ul>
										</div>
										<div class="w-col w-col-3"></div>
										<div class="w-col w-col-3"></div>
										<div class="w-col w-col-3"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="w-tab-pane w--tab-active" data-w-tab="Tab 2">
							<div>
								<div class="w-row">
									<div class="w-col w-col-3">
										<ul class="w-list-unstyled">
											<li>デザイナー思考チーム</li>
											<li>デザイン王子</li>
											<li>erdesin</li>
										</ul>
									</div>
									<div class="w-col w-col-3">
										<ul class="w-list-unstyled">
											<li>HTML好きチーム</li>
											<li>HTMl王子</li>
											<li>erdesin</li>
										</ul>
									</div>
									<div class="w-col w-col-3">
										<ul class="w-list-unstyled">
											<li>Javaでいくチーム</li>
											<li>java王子</li>
											<li>erdesin</li>
										</ul>
									</div>
									<div class="w-col w-col-3">
										<ul class="w-list-unstyled">
											<li>phpでばりばりチーム</li>
											<li>デザイン王子</li>
											<li>erdesin</li>
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