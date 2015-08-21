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
			<h1 class="contentsadd">プロジェクト作成</h1>
		</div>
	</div>
		<div class="w-form">
			<form id="email-form" name="email-form" action="<%=request.getContextPath()%>/front/project/add" method="post">
				<label for="CATEGORY_ID-2">チーム名</label> <select class="w-select"
					id="CATEGORY_ID-2" name="CATEGORY_ID-2" data-name="Category Id 2">
					<option value="">チーム名を選んでください</option>
					<option value="1">Androider</option>
					<option value="2">Javascripter</option>
					<option value="Third">TypeScripter</option>
				</select> <label for="ITEM_TITLE-3">プロジェクト名</label> <input class="w-input"
					id="" type="text" placeholder="アイテムのタイトル"
					name="ITEM_TITLE-3" data-name="Item Title 3" required="required">
				<label for="ITEM_TEXT-2">プロジェクト概要</label>
				<textarea class="w-input" id="ITEM_TEXT-2" placeholder="アイテムの内容を追加"
					name="ITEM_TEXT-2" data-name="Item Text 2"></textarea>
				<label for="field">コミットレベル</label> <select class="w-select"
					id="field" name="field">
					<option value="1">ゆるめ</option>
					<option value="2">ふつう</option>
					<option value="3">それなり</option>
					<option value="4">きつい</option>
				<!-- </select> <label for="field-2">開始日時</label> <input class="w-input"
					id="field-2" type="text" placeholder="Example Text" name="field-2"
					required="required"> <label for="field-3">終了日時</label> <input
					class="w-input" id="field-3" type="text" placeholder="Example Text"
					name="field-3" required="required" data-name="Field 3">  --><input
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
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>