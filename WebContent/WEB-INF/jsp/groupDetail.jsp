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
<div class="w-section wrapperteaminfo">
    <div class="w-container teaminfo">
      <div>
        <div>
          <div>
            <h1 class="teamtitle">Androider</h1>
          </div>
          <h1 class="teamtitle">紹介</h1>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse varius enim in eros elementum tristique. Duis cursus, mi quis viverra ornare, eros dolor interdum nulla, ut commodo diam libero vitae erat. Aenean faucibus nibh et justo cursus id rutrum lorem imperdiet. Nunc ut sem vitae risus tristique posuere.</p>
        </div>
        <div>
          <div class="w-row">
            <div class="w-col w-col-6">
              <div>人数:5人</div>
            </div>
            <div class="w-col w-col-6">
              <div>チームタイプ:デザイナー</div>
            </div>
          </div>
        </div>
      </div>
      <div>
        <div class="w-form">
          <form class="submitteamjoin" id="email-form" name="email-form" data-name="Email Form">
            <input class="w-button" type="submit" value="参加する" data-wait="Please wait...">
          </form>
          <div class="w-form-done">
            <p>Thank you! Your submission has been received!</p>
          </div>
          <div class="w-form-fail">
            <p>Oops! Something went wrong while submitting the form</p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>