<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" import="java.util.List"
	import="Beans.ItemBean"%>
<!DOCTYPE html>
<html>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="w-section">
		<%
			List<ItemBean> itemList = new ArrayList<ItemBean>();
			if (request.getAttribute("ITEM") instanceof List<?>) {
				itemList = (List<ItemBean>) request.getAttribute("ITEM");
			}
		%>
		<div class="w-container detailquestionbody">
			<%
				for (int i = 0; i < itemList.size(); i++) {
			%>
			<h1 class="heading"><%=itemList.get(i).getItemTitle()%></h1>
			<p class="personalizedcontents">
				<%=itemList.get(i).getItemText()%>
			<div class="w-form w-clearfix">
				<form class="w-clearfix formposition" id="email-form"
					name="email-form" data-name="Email Form">
					<div class="w-checkbox check">
						<input class="w-checkbox-input" id="checkbox" type="checkbox"
							name="checkbox" data-name="Checkbox"> <label
							class="w-form-label" for="checkbox">チェックポイント</label>
					</div>
					<label for="name"></label>
				</form>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>