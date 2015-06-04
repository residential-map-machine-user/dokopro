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
          <h1>Programming</h1>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse varius enim in eros elementum tristique. Duis cursus, mi quis viverra ornare, eros dolor interdum nulla, ut commodo diam libero vitae erat. Aenean faucibus nibh et justo cursus id rutrum lorem imperdiet. Nunc ut sem vitae risus tristique posuere.</p>
        </div>
        <div class="w-col w-col-6 column1">
          <h1>Design</h1>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse varius enim in eros elementum tristique. Duis cursus, mi quis viverra ornare, eros dolor interdum nulla, ut commodo diam libero vitae erat. Aenean faucibus nibh et justo cursus id rutrum lorem imperdiet. Nunc ut sem vitae risus tristique posuere.</p>
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
                <a class="w-inline-block" href="#"><img src="https://d3e54v103j8qbb.cloudfront.net/img/image-placeholder.svg" alt="image-placeholder.svg">
                </a>
                <div>HTML</div><a class="button choosecoursebtton" href="<%=request.getContextPath()%>/front/course/detail">HTMLを受講する</a>
              </div>
              <div class="w-col w-col-6"><img class="css" src="https://d3e54v103j8qbb.cloudfront.net/img/image-placeholder.svg" alt="image-placeholder.svg">
                <div>CSS</div><a class="button choosecoursebtton" href="<%=request.getContextPath()%>/front/course/content">CSSを受講する</a>
              </div>
            </div>
          </li>
          <li>
            <div class="w-row">
              <div class="w-col w-col-6"><img src="https://d3e54v103j8qbb.cloudfront.net/img/image-placeholder.svg" alt="image-placeholder.svg">
                <div class="java">JAVA</div><a class="button choosecoursebtton" href="#">Java<br>を受講する</a>
              </div>
              <div class="w-col w-col-6"><img src="https://d3e54v103j8qbb.cloudfront.net/img/image-placeholder.svg" alt="image-placeholder.svg">
                <div class="ruby">Ruby</div><a class="button choosecoursebtton" href="#">HTMLを受講する</a>
              </div>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>