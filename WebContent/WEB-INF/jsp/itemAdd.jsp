<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" import="java.util.ArrayList"
	import="Beans.ContentsBean"%>
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
			<h1 class="contentsadd">アイテム追加</h1>
		</div>
	</div>
	<%
		List<ContentsBean> contentsList = new ArrayList<ContentsBean>();
		if (request.getAttribute("CONTENTS_LIST") instanceof List<?>) {
			contentsList = (List<ContentsBean>) request
					.getAttribute("CONTENTS_LIST");
		}
	%>
	<div class="w-container">
		<div class="w-form">
			<form id="email-form" name="email-form" data-name="Email Form" action="<%=request.getContextPath() %>/front/admin/additem" method="post">
				<label for="CATEGORY_ID">Category名</label> <select class="w-select"
					id="CATEGORY_ID" name="CATEGORY_ID" data-name="CATEGORY_ID">
					<option value="">Select one...</option>
					<option value="First">First Choice</option>
					<option value="Second">Second Choice</option>
					<option value="Third">Third Choice</option>
				</select> <label for="SUB_CATEGOYR_ID">SubCategory名</label> <select
					class="w-select" id="SUB_CATEGOYR_ID" name="SUB_CATEGOYR_ID"
					data-name="SUB_CATEGOYR_ID">
					<option value="">Select one...</option>
					<option value="First">First Choice</option>
					<option value="Second">Second Choice</option>
					<option value="Third">Third Choice</option>
				</select> <label for="CONTENTS_ID">Contents名</label> <select class="w-select"
					id="CONTENTS_ID" name="CONTENTS_ID" required="required"
					data-name="CONTENTS_ID">
					<option value="">Select one...</option>
					<%
						for (int i = 0; i < contentsList.size(); i++) {
					%>
					<option value="<%=contentsList.get(i).getContentsId()%>"><%=contentsList.get(i).getContentsTitle()%></option>
					<%
						}
					%>
				</select> <label for="ITEM_TITLE">Itemタイトル</label> <input class="w-input"
					id="ITEM_TITLE" type="text" placeholder="アイテムのタイトル"
					name="ITEM_TITLE" data-name="ITEM_TITLE" required="required">
				<label for="ITEM_TEXT">Itemテキスト</label>
				<textarea class="w-input" id="ITEM_TEXT" placeholder="アイテムの内容を追加"
					name="ITEM_TEXT" data-name="ITEM_TEXT"></textarea>
				<input class="w-button" type="submit" value="送信" data-wait="Please wait...">
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