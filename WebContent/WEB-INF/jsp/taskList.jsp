<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/reset.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/task.css">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<!--[if (gte IE 6)&(lte IE 8)]>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/selectivizr/1.0.2/selectivizr-min.js"></script>
		<![endif]-->
		<script src="<%=request.getContextPath()%>/res/js/imagesloaded.pkgd.min.js"></script>
		<script src="<%=request.getContextPath()%>/res/js/masonry.pkgd.min.js"></script>
		<script src="<%=request.getContextPath()%>/res/js/task.js"></script>
	</head>
	<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/reset.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/task.css">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<!--[if (gte IE 6)&(lte IE 8)]>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/selectivizr/1.0.2/selectivizr-min.js"></script>
		<![endif]-->
		<script src="<%=request.getContextPath()%>/res/js/imagesloaded.pkgd.min.js"></script>
		<script src="<%=request.getContextPath()%>/res/js/masonry.pkgd.min.js"></script>
		<script src="<%=request.getContextPath()%>/res/js/task.js"></script>
		<div class="container">
			<!-- <header>
				<h1 class="site-id"></h1>
				<nav class="global-nav">
					<ul>
						<li><a href="javascript:void(0)">All</a></li>
						<li><a href="javascript:void(0)">Animal</a></li>
						<li><a href="javascript:void(0)">Landscape</a></li>
						<li><a href="javascript:void(0)">Flower</a></li>
						<li><a href="javascript:void(0)">People</a></li>
					</ul>
				</nav>
			</header> -->
			<ul class="photo-tile">
				<li>
					<a href="#">
						<div class="item-photo">
							<h2>dummy data dummy data dummy datadummy datadummy datadummy datadummy datadummy data</h2>
							<p>
							</div>
						<div class="item-info c2">
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c1">
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c5">
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c4">
							<h1>Sakura</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c1">
							<h1>Antique interior light</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c5">
							<h1>Clock tower</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info">
							<h1>No image</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c2">
							<h1>Matsuyama Catsle</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c3">
							<h1>Rainbow</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c1">
							<h1>Tiger</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c5">
							<h1>Classic car</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c3">
							<h1>Cat chocolates</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c2">
							<h1>View</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c4">
							<h1>Sakura</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c1">
							<h1>Interior light</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info">
							<h1>No image</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c5">
							<h1>Classic car</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c2">
							<h1>Sakura</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c2">
							<h1>Matsuyama Catsle</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c5">
							<h1>Rainbow</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c3">
							<h1>Tiger</h1>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<div class="item-photo"></div>
						<div class="item-info c4">
							<h1>Sakura</h1>
						</div>
					</a>
				</li>
			</ul>
		</div>
	</body>
	</html>
