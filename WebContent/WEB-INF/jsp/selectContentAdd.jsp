<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Mon Apr 20 2015 01:31:28 GMT+0000 (UTC) -->
<html data-wf-site="5529405753ab13dd4efff00c"
	data-wf-page="5533380986ac3db85c98f433">
<body>
	<header class="w-section navbar">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	<div class="w-container adminselect">
		<div>
			<div class="w-row">
				<div class="w-col w-col-6">
					<div class="selectaction4admin">
						<h3><a href="<%=request.getContextPath() %>/front/admin/addcategory">カテゴリー追加</a></h3>
					</div>
				</div>
				<div class="w-col w-col-6">
					<div class="selectaction4admin">
						<h3><a href="<%=request.getContextPath() %>/front/admin/addsubcategory">サブカテゴリー追加</a></h3>
					</div>
				</div>
			</div>
			<div class="w-row">
				<div class="w-col w-col-6">
					<div class="selectaction4admin">
						<h3><a href="<%=request.getContextPath() %>/front/admin/addcontents">コンテンツ追加</a></h3>
					</div>
				</div>
				<div class="w-col w-col-6">
					<div class="selectaction4admin">
						<h3><a href="<%=request.getContextPath() %>/front/admin/additem">アイテム追加</a></h3>
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