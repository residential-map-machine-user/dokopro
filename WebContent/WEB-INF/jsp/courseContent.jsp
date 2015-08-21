<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" import="java.util.List"
	import="Beans.ItemBean"%>
<!DOCTYPE html>
<html>
<body>

	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<script
		src="<%=request.getContextPath()%>/res/js/jquery.yycountdown.min.js">
		
	</script>
	<div class="w-section">
		<input id="contentsId" type="hidden"
			value="<%=(Integer)request.getAttribute("CONTENTS_ID")%>">
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
						<input class="w-checkbox-input"
							id="ITEM_<%=itemList.get(i).getItemId()%>" type="checkbox"
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
	<style>
body {
	position: relative;
}

.timer_message {
	display: inline-block;
	margin: 0;
}

.progress_keep {
	position: fixed;
	top: 580px;
	left: 83%;
	display: inline-block;
	text-align: center;
	padding: 10px;
	width: 145px;
	height: 140px;
	backgroud-size: cover;
	background-position: center center;
	background-size: contain;
	background-repeat: no-repeat;
	background-image: url(<%=request.getContextPath ()%>/res/images/tnm.png);
}

.yycountdown-box {
	text-align: center;
	margin: 10px 0;
	color: #000000;
}

#timer .yycountdown-box .yyc-day {
	font-size: 2.0em;
	color: #009F3D;
}

#timer .yycountdown-box .yyc-hou {
	font-size: 2.0em;
	color: #009F3D;
}

#timer .yycountdown-box .yyc-min {
	font-size: 2.0em;
	color: #009F3D;
}

#timer .yycountdown-box .yyc-sec {
	font-size: 2.0em;
	color: #009F3D;
}

#timer .yycountdown-box .yyc-day-text, #timer .yycountdown-box .yyc-hou-text,
	#timer .yycountdown-box .yyc-min-text, #timer .yycountdown-box .yyc-sec-text
	{
	font-size: 2.0em;
}
</style>
	<div class="progress_keep">
		<div class="timer_message">制限時間</div>
		<div id="timer" class="yycountdown-box"></div>
	</div>

	<script>
		$(document)
				.ready(
						function() {
							console.log("準備OK");
							var contentsId = $("#contentsId").val();
							console.log(contentsId);
							//ここで必要なのはjson形式でそのユーザが持つITEM_IDを取得してくること(complete_flagが立っているもののみ)
							$('input')
									.change(
											function() {
												var itemId = $(this).attr("id")
														.split("_")[1];
												console.log(itemId);
												if ($(this).is(':checked')) {
													$
															.ajax({
																type : "GET",
																url : "<%=request.getContextPath()%>/front/course/item/"
																		+ itemId,
																success : function(
																		msg) {
																	alert("Data Saved: "
																			+ msg);
																}
															});
												} else if(!$(this).is(':checked')){
													$.ajax({
																type : "POST",
																url : "<%=request.getContextPath()%>/front/course/item/"
																		+ itemId,
																success : function(
																		msg) {
																	if (msg === "OK") {
																		alert("Data Deleted: "
																				+ msg);
																	}
																	
																}
															});
												}
											});
							$
									.ajax({
										type : "GET",
										url : "<%=request.getContextPath()%>/front/progress/getcompleteitemidlist/"
												+ contentsId,
										data : {
											"CONTENTS_ID" : contentsId
										},
										success : function(data) {
											var str = data.toString();
											var splitstr = str.replace("[","").replace("]","").split(",");
											console.log(splitstr);
											for (var i = 0; i < splitstr.length; i++) {
												console.log(splitstr[i]);
												if (splitstr[i]) {
													console.log("itme_id" + splitstr[i]);
													var checkBox = $("#ITEM_"+ splitstr[i]);
													if (checkBox) {
														checkBox.attr({"checked":""});
													}
												}
											}
										}
									});
							$("#timer").yycountdown({
								startDateTime : '2020/07/23 23:45:00', //カウントダウン開始日時
								endDateTime : '2020/07/24 00:00:00',
								unit : {
									d : ':',
									h : ':',
									m : ':',
									s : ''
								}, //カウントダウン単位
								complete : function(_this) { //カウントダウン完了時のコールバック
									_this.find('.yycountdown-box').css({
										color : 'red'
									});
								}
							});
						});
	</script>
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->

</body>
</html>