<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- This site was created in Webflow. http://www.webflow.com-->
<!-- Last Published: Mon Apr 20 2015 01:31:28 GMT+0000 (UTC) -->
<html data-wf-site="5529405753ab13dd4efff00c" data-wf-page="5533d299777d17b75ce87bf0">
<body>
  <header class="w-section navbar">
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
<div class="w-section explanationcourse">
    <div class="topimagecontainer">
      <h1 class="catchphrasemypage">コース選択</h1>
      <div class="w-row courseexplanationcontainer">
        <div class="w-col w-col-6 column1">
          <h2>プログラミング</h2>
          <p class="courseselectparagraph">Webアプリの作成などページを動的に変更することをメインに進めていきます。言語はJavaです。java以外は出来ないのでコース作成しません。</p>
        </div>
        <div class="w-col w-col-6 column1">
          <h2>デザイン</h2>
          <p class="courseselectparagraph">Html,Css,Javascriptをメインに勉強します。javascriptでページを動的に操作したりすることができます。最終的にはjQueryを勉強します。</p>
        </div>
      </div>
    </div>
  </div>
  <div class="w-section">
    <div class="w-container languagelist">
      <div class="languagesoutlinedecorate">
        <ul class="w-list-unstyled">
          <li>
            <div class="w-row">
              <div class="w-col w-col-6 html">
                <a class="w-inline-block" href="#"><img src="https://d3e54v103j8qbb.cloudfront.net/img/image-placeholder.svg">
                </a>
                <div>Html</div><a class="button choosecoursebtton" href="<%=request.getContextPath() %>/front/course/detail">Htmlを受講する</a>
              </div>
              <div class="w-col w-col-6"><img class="css" src="https://d3e54v103j8qbb.cloudfront.net/img/image-placeholder.svg">
                <div>CSS</div><a class="button choosecoursebtton" href="#">Cssを受講する</a>
              </div>
            </div>
          </li>
          <li>
            <div class="w-row">
              <div class="w-col w-col-6"><img src="https://d3e54v103j8qbb.cloudfront.net/img/image-placeholder.svg">
                <div class="java">Java</div><a class="button choosecoursebtton" href="#">Javaを受講する</a>
              </div>
              <div class="w-col w-col-6"><img src="https://d3e54v103j8qbb.cloudfront.net/img/image-placeholder.svg">
                <div class="ruby">Android</div><a class="button choosecoursebtton" href="#">Androidを受講する</a>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script type="text/javascript" src="js/webflow.js"></script>
  <!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>