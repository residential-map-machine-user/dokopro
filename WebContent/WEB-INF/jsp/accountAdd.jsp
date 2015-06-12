<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Mon Apr 20 2015 01:31:28 GMT+0000 (UTC) -->
<html data-wf-site="5529405753ab13dd4efff00c" data-wf-page="5533380986ac3db85c98f433">
<body>
  <header class="w-section navbar">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
  <div class="w-section wraplogin">
    <div class="w-container wraplogindisp">
      <div class="dispinformation">
        <div class="logintext s">アカウント登録</div>
      </div>
      <div class="logindisp">
        <div class="w-row logincolumns">
          <div class="w-col w-col-6 login" id="separation">
            <div class="w-form">
              <form id="email-form" name="email-form" data-name="Email Form" action="<%=request.getContextPath() %>/front/account" method="post">
                <label for="name-2">アカウント名</label>
                <input class="w-input" id="name-2" type="text" placeholder="アカウント名を入力してください" name="ACCOUNT_NAME" data-name="Name 2">
                <label for="email-4">メールアドレス</label>
                <input class="w-input" id="email-4" type="email" placeholder="メールアドレスを入力してください" name="MAIL" data-name="Email 4" required="required">
                <label for="email-5">パスワード</label>
                <input class="w-input" id="email-5" type="password" placeholder="パスワードを入力してください" name="PASSWORD" data-name="Email 5" required="required">
                <label for="email-6">パスワード（確認)</label>
                <input class="w-input" id="email-6" type="password" placeholder="パスワード（確認）を入力してください" name="CHECK_PASSWORD" data-name="Email 6" required="required">
                <input class="w-button registerbutton" type="submit" value="登録" data-wait="Please wait...">
              </form>
              <div class="w-form-done">
                <p>Thank you! Your submission has been received!</p>
              </div>
              <div class="w-form-fail">
                <p>Oops! Something went wrong while submitting the form :(</p>
              </div>
            </div>
          </div>
          <div class="w-col w-col-6 w-clearfix column3">
            <div class="separationlinediv"></div>
            <div class="movetologin">すでに<a href="#">Dokopro</a>のアカウントをお持ちですか？</div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>