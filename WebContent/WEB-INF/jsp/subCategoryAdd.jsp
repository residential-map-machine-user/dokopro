<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="java.util.ArrayList"
	import="Beans.CategoryBean"%>
<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Mon Apr 20 2015 01:31:28 GMT+0000 (UTC) -->
<html data-wf-site="5529405753ab13dd4efff00c"
	data-wf-page="5533380986ac3db85c98f433">
<body>
	<header class="w-section navbar">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	<div class="w-section">
		<div>
			<h1 class="contentsadd">サブカテゴリー追加</h1>
		</div>
	</div>
	<div class="w-container">
		<div>
			<h3 class="contentstitle">内容</h3>
		</div>
		<%
			List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
			if (request.getAttribute("CATEGORY_LIST") instanceof List<?>) {
				categoryList = (List<CategoryBean>) request
						.getAttribute("CATEGORY_LIST");
			}
		%>
		<div class="w-form">
			<form id="email-form" name="email-form"
				action="<%=request.getContextPath()%>/front/admin/addsubcategory"
				method="post">
				<label for="CATEGORY_ID-2">Category名</label> <select
					class="w-select" id="CATEGORY_ID-2" name="CATEGORY_ID"
					data-name="Category Id">
					<option value="">Select one...</option>
					<%
						for (int i = 0; i < categoryList.size(); i++) {
					%>
					<option value="<%=categoryList.get(i).getCategoryId()%>"><%=categoryList.get(i).getCategoryName()%></option>
					<%
						}
					%>
				</select> <label for="SUB_CATEGORY_NAME">SubCategory名</label> <input
					class="w-input" id="SUB_CATEGORY_NAME" type="text"
					placeholder="サブカテゴリー名" name="TITLE"
					data-name="SUB_CATEGORY_NAME" required="required"> <input
					class="w-button" type="submit" value="送信"
					data-wait="Please wait...">
			</form>
			<div class="w-form-done">
				<p>Thank you! Your submission has been received!</p>
			</div>
			<div class="w-form-fail">
				<p>Oops! Something went wrong while submitting the form</p>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>