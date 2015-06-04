<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Mon Apr 20 2015 01:31:28 GMT+0000 (UTC) -->
<html data-wf-site="5529405753ab13dd4efff00c"
	data-wf-page="5530dadb38615e9e376d3839">
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="w-section wraplogin">
		<div class="w-container wraplogindisp">
			<div class="loginwraper">
				<div class="logintext">ログイン</div>
				<div class="logindisp">
					<div class="w-row logincolumns">
						<div class="w-col w-col-6 loginwithown" id="separation">
							<div class="loginspace">
								<div class="w-form formwraper">
									<form class="loginform" id="email-form" name="email-form"
										data-name="Email Form"
										action="<%=request.getContextPath()%>/front/login/main"
										method="post">
										<label for="name-2">ユーザー名:</label> <input class="w-input"
											id="USER_NAME" type="text" placeholder="ユーザー名を入力してください"
											name="USER_NAME" data-name="Name 2"> <label
											for="email-2">パスワード:</label> <input class="w-input"
											id="PASSWORD" type="password" placeholder="パスワードを入力してください"
											name="PASSWORD" data-name="Email 2" required="required">
										<input class="w-button loginbutton" type="submit"
											value="Submit" data-wait="Please wait...">
									</form>
									<div class="w-form-done">
										<p>Thank you! Your submission has been received!</p>
									</div>
									<div class="w-form-fail">
										<p>Oops! Something went wrong while submitting the form :(</p>
									</div>
								</div>
							</div>
						</div>
						<div class="w-col w-col-6 w-clearfix loginwithsocialaccount">
							<div class="separationlinediv"></div>
							<div class="socialsigninwraper">
								<div class="facebookloginwrap">
									<a class="button socialsiginin" href="#">facebookでログイン</a>
								</div>
								<div class="googleloginwrap">
									<a class="button socialsiginin" href="#">googleでログイン</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div>
				<div class="navtoregister">
					まだ<a href="#">Dokopro</a>に登録していませんか ?
				</div>
			</div>
		</div>
	</div>
</body>
</html>