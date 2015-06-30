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
						<input class="w-checkbox-input" id="ITEM_<%=itemList.get(i).getItemId()%>" type="checkbox"
							name="COMPLETE_FLAG" data-name="Checkbox" value=""> <label
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
	<script>
		$(document).ready(function() {
			$('input').change(function() {
				var itemId = $(this).attr("id").split("_")[1];
				console.log(itemId);
				if ($(this).is(':checked')) {
					$.ajax({
						   type: "GET",
						   url: "http://localhost:8080/dokopro/front/course/item/" + itemId,
						   success: function(msg){
							  if(msq === "OK"){
								  $('')
							  }
						     alert( "Data Saved: " + msg );
						   }
						 });
				} else {
					
				}
			});
		});
	</script>
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->

</body>
</html>