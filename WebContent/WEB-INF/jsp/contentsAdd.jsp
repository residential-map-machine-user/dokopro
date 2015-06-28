<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="java.util.ArrayList"
	import="Beans.SubCategoryBean"%>
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
			<h1 class="contentsadd">コンテンツ追加</h1>
		</div>
	</div>
	<div class="w-container">
		<%
			List<SubCategoryBean> subCategoryList = new ArrayList<SubCategoryBean>();
			if (request.getAttribute("SUB_CATEGORY_LIST") instanceof List<?>) {
				subCategoryList = (List<SubCategoryBean>) request
						.getAttribute("SUB_CATEGORY_LIST");
			}
		%>
		<div class="w-form">
			<form id="email-form" name="email-form" data-name="Email Form" action="<%=request.getContextPath() %>/front/admin/addcontents" method="post">
				<label for="CATEGORY_ID-2">Category名</label> <select
					class="w-select" id="CATEGORY_ID-2" name="CATEGORY_ID-2"
					data-name="Category Id 2">
					<option value="">Select one...</option>

					<option value="Second">Second Choice</option>
				</select> <label for="SUB_CATEGORY_ID">SubCategory名</label> <select
					class="w-select" id="SUB_CATEGORY_ID" name="SUB_CATEGORY_ID"
					data-name="Sub Categoyr Id 2">
					<option value="">Select one...</option>
					<%
						for (int i = 0; i < subCategoryList.size(); i++) {
					%>
					<option value="<%=subCategoryList.get(i).getSubCategoryId()%>"><%=subCategoryList.get(i).getTitle()%></option>
					<%
						}
					%>
					<option value="Second">Second Choice</option>
					<option value="Third">Third Choice</option>
				</select> <label for="CONTENTS_TITLE">Contents名</label> <input
					class="w-input" id="CONTENTS_TITLE" type="text"
					placeholder="コンテンツのタイトル" required="required" name="TITLE"
					data-name="CONTENTS_TITLE"> <input class="w-button"
					type="submit" value="送信" data-wait="Please wait...">
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