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
	<div class="row">
		<div class="w-section section">
			<div class="w-container teaminfo">
				<div class="row">
					<div>
						<div>
							<div>
								<h1 class="teamtitle"><%=group.getGroupName()%></h1>
							</div>
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
				<div class="col-md-4">
					<div class="panel panel-info">
						<div class="panel-heading">ViewPagerの実装</div>
						<div class="panel-body">
							<p>３時間でViewPagerの実装までこぎつけるプロジェクトです</p>
						</div>

						<!-- List group -->
						<ul class="list-group">
							<li class="list-group-item">メンバー</li>
							<li class="list-group-item">開始時期</li>
							<li class="list-group-item">終了時期</li>
							<li class="list-group-item">コミットレベル</li>
							<li class="list-group-item">その他</li>
						</ul>
					</div>
				</div>
				<div class="col-md-4">
					<div class="panel panel-info">
						<div class="panel-heading">ViewPagerの実装</div>
						<div class="panel-body">
							<p>３時間でViewPagerの実装までこぎつけるプロジェクトです</p>
						</div>

						<!-- List group -->
						<ul class="list-group">
							<li class="list-group-item">メンバー</li>
							<li class="list-group-item">開始時期</li>
							<li class="list-group-item">終了時期</li>
							<li class="list-group-item">コミットレベル</li>
							<li class="list-group-item">その他</li>
						</ul>
					</div>
				</div>
				<div class="col-md-4">
					<div class="panel panel-info">
						<div class="panel-heading">ViewPagerの実装</div>
						<div class="panel-body">
							<p>３時間でViewPagerの実装までこぎつけるプロジェクトです</p>
						</div>

						<!-- List group -->
						<ul class="list-group">
							<li class="list-group-item">メンバー</li>
							<li class="list-group-item">開始時期</li>
							<li class="list-group-item">終了時期</li>
							<li class="list-group-item">コミットレベル</li>
							<li class="list-group-item">その他</li>
						</ul>
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