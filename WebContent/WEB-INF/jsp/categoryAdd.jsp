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
   <div class="w-section">
    <div>
      <h1 class="contentsadd">カテゴリー追加</h1>
    </div>
  </div>
  <div class="w-container">
    <ul class="w-list-unstyled">
      <li>
        <div class="w-form">
          <form id="email-form" name="email-form" action="<%=request.getContextPath()%>/front/admin/addcategory" method="post" >
            <label for="CATEGORY_NAME">Category名</label>
            <input class="w-input" id="CATEGORY_NAME" type="text" placeholder="Example Text" name="CATEGORY_NAME" required="required" data-name="CATEGORY_NAME">
            <input class="w-button" type="submit" value="送信" data-wait="Please wait...">
          </form>
          <div class="w-form-done">
            <p>Thank you! Your submission has been received!</p>
          </div>
          <div class="w-form-fail">
            <p>Oops! Something went wrong while submitting the form</p>
          </div>
        </div>
      </li>
    </ul>
  </div>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>