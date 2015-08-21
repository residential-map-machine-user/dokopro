<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" import="java.util.List"
	import="Beans.SubCategoryBean" import="Beans.ContentsBean"%>
<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Mon Apr 20 2015 01:31:28 GMT+0000 (UTC) -->
<html data-wf-site="5529405753ab13dd4efff00c"
	data-wf-page="5533e4c386ac3db85c990614">
<body>

	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<script>
		$(document)
				.ready(
						function() {
							$
									.ajax({
										type : "POST",
										url : "/dokopro/front/progress/getsubcategoryprogress",
										data : {
											categoryId :
	<%=request.getAttribute("CLICKED_CATEGORY_ID")%>
		},
										success : function(data) {
											for (var i = 0; i < data.length; i++) {
												console
														.log(data[i].contentsTitle);
												console.log(data[i].contentsId);
												console.log(data[i].progress);
												var dataArea = $("#"
														+ data[i].contentsId);
												dataArea.html(data[i].progress
														+ "%");
												dataArea.css({
													'width' : data[i].progress
															+ '%'
												});
											}
										},
										error : function(data) {
											console.log("読み込み失敗");
										}
									});
							console.log("ok1");
							$(".list-group-item").click(
								/* 	function() {
										var item_list = $(".list-group-item")
												.find("a").attr("href");
										console.log(item_list.toString());
										window.location = $(".list-group-item")
												.find("a").attr("href");
									} */
									);
						});
	</script>
	<script>
		
	</script>
	<%
		List<SubCategoryBean> subcategoryList = new ArrayList<SubCategoryBean>();
		if (request.getAttribute("SUB_CATEGORY") instanceof List<?>) {
			subcategoryList = (List<SubCategoryBean>) request.getAttribute("SUB_CATEGORY");
		}
	%>
	<div id="jugyoinList">
		<div id="ajax-sample-ajax"></div>
		<div class="w-section section">
			<div class="row">
				<%
					for (int i = 0; i < subcategoryList.size(); i++) {
				%>
				<div class="col-md-3">
					<h1 class="coursedetailtitle"><%=subcategoryList.get(i).getTitle()%></h1>
					<ul class="list-group">
						<%
							for (int j = 0; j < subcategoryList.get(i).getContentsList().size(); j++) {
						%>
						<li class="list-group-item"><a
							href="<%=request.getContextPath()%>/front/course/content/<%=subcategoryList.get(i).getContentsList().get(j).getContentsId()%>"><%=subcategoryList.get(i).getContentsList().get(j).getContentsTitle()%></a></li>
						<div class="progress">
							<div
								id="<%=subcategoryList.get(i).getContentsList().get(j).getContentsId()%>"
								class="progress-bar" role="progressbar" aria-valuenow="60"
								aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
								0%</div>
						</div>

						<%
							}
						%>

					</ul>
				</div>
				<%
					}
				%>
			</div>
		</div>
		
		<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>
