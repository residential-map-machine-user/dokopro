<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Beans.GroupBean"%>
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
	%>
	<div class="w-section wrapperteaminfo">
		<div class="w-container teaminfo">
			<div>
				<div>
					<div>
						<h1 class="teamtitle">
							TEAM:<%=group.getGroupName()%></h1>
					</div>
					<p><%=group.getDescription()%></p>
				</div>
				<div>
					<div class="w-row">
						<div class="w-col w-col-6">
							<div>人数:5人</div>
						</div>
						<div class="w-col w-col-6">
							<div>
								チームタイプ:<%
								
							%>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div>
				<div class="w-form">
					<form class="submitteamjoin" id="email-form" name="email-form"
						data-name="Email Form">
						<input class="w-button" type="submit" value="参加する"
							data-wait="登録処理中...">
					</form>
					<div class="w-form-done">
						<p>登録完了しました</p>
					</div>
					<div class="w-form-fail">
						<p>登録に失敗しました。</p>
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