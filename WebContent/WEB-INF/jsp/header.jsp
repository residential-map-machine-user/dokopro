<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Beans.UserBean"%>
<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Sun May 10 2015 01:43:47 GMT+0000 (UTC) -->
<html data-wf-site="5529405753ab13dd4efff00c"
	data-wf-page="554eb623e47085a40aa28f05">
<head>
<meta charset="utf-8">
<title>header</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="generator" content="Webflow">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/res/css/normalize.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/res/css/webflow.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/res/css/pg-int.webflow.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.7/webfont.js"></script>
<script>
	WebFont
			.load({
				google : {
					families : [ "Montserrat:400,700",
							"Bitter:400,700,400italic",
							"Ubuntu:300,300italic,400,400italic,500,500italic,700,700italic" ]
				}
			});
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/res/js/modernizr.js"></script>
<link rel="shortcut icon" type="image/x-icon"
	href="/<%=request.getContextPath()%>/res/images/webclip-slate.png">
<link rel="apple-touch-icon"
	href="/<%=request.getContextPath()%>/res/images/webclip-slate.png">
</head>
<div class="headercontainer">
	<div class="w-nav navbarhome" data-collapse="all"
		data-animation="over-right" data-duration="400" data-easing="ease-in"
		data-doc-height="1">
		<div class="w-clearfix">
			<a class="w-nav-brand" href="#"> <img
				src="https://d3e54v103j8qbb.cloudfront.net/img/image-placeholder.svg"
				width="38">
			</a> <a class="courselistnavitem"
				href="<%=request.getContextPath()%>/front/course">コース一覧</a> <a
				class="courselistnavitem"
				href="<%=request.getContextPath()%>/front/group">チーム一覧</a>
			<div class="w-clearfix entrybuttonwrapper">

				<%
					if (request.getSession().getAttribute("USER_INF") == null) {
				%>
				<div class="w-clearfix headerbuttonwrapper">
					<a class="button" href="<%=request.getContextPath()%>/front/login">&nbsp;ログイン</a>
				</div>
				<div class="w-clearfix headerbuttonwrapper">
					<a class="button"
						href="<%=request.getContextPath()%>/front/account">新規登録</a>
				</div>
				<%
					} else {
				%>
				<div class="dropdown">

					<!-- ここが表示されるボタン <a>タグでもOK -->
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown">
						<%
							String account = ((UserBean) request.getSession().getAttribute(
										"USER_INF")).getAccountName();
						%>
						<%=account%>
						<span class="caret"></span>
					</button>
					<!-- ボタンここまで -->

					<!-- ここはボタンを押すと表示されるリスト -->
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="<%=request.getContextPath()%>/front/mypage">マイページ</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="<%=request.getContextPath()%>/front/account/edit">アカウント設定</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="<%=request.getContextPath()%>/front/admin">管理者メニュー</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="<%=request.getContextPath()%>/front/logout">サインアウト</a></li>
						<li role="presentation" class="divider"></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">Separated link</a></li>
					</ul>
					<!-- リストここまで -->
					<%
						}
					%>
				</div>
				<nav class="w-nav-menu" role="navigation"></nav>
			</div>
		</div>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/res/js/webflow.js"></script>
		<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
	</div>
</html>