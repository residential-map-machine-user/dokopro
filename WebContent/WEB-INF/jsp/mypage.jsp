<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Mon Apr 20 2015 01:31:28 GMT+0000 (UTC) -->
<html data-wf-site="5529405753ab13dd4efff00c"
	data-wf-page="5533fc6dfd7ee5b552c33f8a">
<head>
<meta charset="utf-8">
<title>MyPage</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="generator" content="Webflow">
<link rel="stylesheet" type="text/css" href="css/normalize.css">
<link rel="stylesheet" type="text/css" href="css/webflow.css">
<link rel="stylesheet" type="text/css" href="css/pg-int.webflow.css">
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
<script type="text/javascript" src="js/modernizr.js"></script>
<link rel="shortcut icon" type="image/x-icon"
	href="images/webclip-slate.png">
<link rel="apple-touch-icon" href="images/webclip-slate.png">
</head>
<body>
	<header class="w-section navbar">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	<div class="w-section">
		<div class="w-container tab">
			<div class="pic">
				<img class="slefpic" src="<%=request.getContextPath()%>/res/images/IMG_0181.JPG" alt="5534004c86ac3db85c9909a5_IMG_0181.JPG">
				<div class="username">Yuki&nbsp;Matsuyama</div>
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