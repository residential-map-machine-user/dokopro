<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
  <div class="w-container accountsettingwrapper">
    <div>
      <h1 class="accountsetting">チーム作成</h1>
      <div class="separationyoko"></div>
      <div class="changaccountinfowrapper">
        <div class="w-form">
          <form id="email-form" name="email-form" data-name="Email Form">
            <label for="name-2">チーム名</label>
            <input class="w-input" id="name-2" type="text" placeholder="Androider" name="name-2" data-name="Name 2" required="required">
            <label for="email-5">チーム説明</label>
            <input class="w-input" id="email-5" type="email" placeholder="e.gこのチームは優れたUIを研究するチームです" name="email-5" data-name="Email 5" required="required">
            <label for="email-6">プロジェクト名</label>
            <input class="w-input" id="email-6" type="email" placeholder="e.gかっこいいUIを探して写経しよう" name="email-6" data-name="Email 6" required="required">
            <label for="email-7">プロジェクト開始時期</label>
            <input class="w-input" id="email-7" type="email" placeholder="2015/2/1" name="email-7" data-name="Email 7" required="required">
            <input class="w-button" type="submit" value="作成" data-wait="Please wait...">
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
  </div>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>