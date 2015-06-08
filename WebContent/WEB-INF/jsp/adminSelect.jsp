<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="w-container adminselect">
		<div>
			<div class="w-row">
				<div class="w-col w-col-6">
					<a class="button" href="#">チーム削除</a>
				</div>
				<div class="w-col w-col-6">
					<a class="button" href="#">ユーザ削除</a>
				</div>
			</div>
			<div class="w-row">
				<div class="w-col w-col-6">
					<a class="button" href="#">コンテンツ追加</a>
				</div>
				<div class="w-col w-col-6">
					<a class="button" href="#">コンテンツ編集</a>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/webflow.js"></script>
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>