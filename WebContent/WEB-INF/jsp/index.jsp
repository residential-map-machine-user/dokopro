<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<style>
		.section{
			max-width:100%;
		}
	</style>
	<div class="w-section section hero">
		<div class="w-container">
			<div class="w-row">
				<div class="w-col w-col-9 catch_phrase_column">
					<h1 class="hero-header">Life With Programming</h1>
					<p class="hero-subtitle">Let’s start your creative life</p>
					<div class="registerbuttonwraper">
							<a class="button toplogin" href="<%=request.getContextPath() %>/front/account">新規登録</a>
					</div>
				</div>
				<div class="w-col w-col-3 catch_phrase_column"></div>
			</div>
		</div>
	</div>
	<div class="w-section w-hidden-small w-hidden-tiny section grey"></div>
	<div class="w-section w-clearfix section" id="features">
		<div class="w-container">
			<div class="w-row">
				<div class="w-col w-col-6">
					<h2>Android Application</h2>
					<p>AdnroidOSを使った開発はもはやスマートフォンだけに止まりません。Wearableといった時計から車やロボットにいたるところでの導入が開始されています。一緒にAndroidの開発を学びましょう.</p>
					<div class="w-row">
						<div class="w-col w-col-4 w-col-small-4 w-col-tiny-4">
							<div class="icon-title">Album</div>
							<img src="<%=request.getContextPath() %>/res/images/album.png" width="57"
								alt="52af8d1ca41389d367000039_album.png">
						</div>
						<div class="w-col w-col-4 w-col-small-4 w-col-tiny-4">
							<div class="icon-title">Funnel</div>
							<img src="<%=request.getContextPath() %>/res/images/filter.png" width="57px"
								alt="52af8d22a41389d36700003a_filter.png">
						</div>
						<div class="w-col w-col-4 w-col-small-4 w-col-tiny-4">
							<div class="icon-title">Folders</div>
							<img src="<%=request.getContextPath() %>/res/images/folder.png" width="57px"
								alt="52af8d28a41389d36700003b_folder.png">
						</div>
					</div>
				</div>
				<div class="w-col w-col-6 center">
					<img src="<%=request.getContextPath() %>/res/images/android_pic_top.png" width="510"
						alt="5529f77e416f90126f4e71f5_android_pic_top.png">
				</div>
			</div>
		</div>
	</div>
	<div class="w-section section grey">
		<div class="w-container">
			<div class="w-row">
				<div class="w-col w-col-6 center">
					<img src="<%=request.getContextPath() %>/res/images/web_programming.png" width="323"
						alt="5529f8aa3b36ca374dffdd8e_web_programming.png">
				</div>
				<div class="w-col w-col-6">
					<h2>Web Programming</h2>
					<p>最近は優れた見かけや機能を持ったWebサイトを見かけることも多くなってきました。canvasを使うことで、今までにないWebサイトを見かけるようになってきました。一緒にクリエイティブなWebサイトを作りましょう。</p>
					<div class="w-row">
						<div class="w-col w-col-4 w-col-small-4 w-col-tiny-4">
							<div class="icon-title">Standard</div>
							<img src="<%=request.getContextPath() %>/res/images/basic.png" width="57px"
								alt="52af8d56aae9d4d56700005b_basic.png">
						</div>
						<div class="w-col w-col-4 w-col-small-4 w-col-tiny-4">
							<div class="icon-title">Stacked</div>
							<img src="<%=request.getContextPath() %>/res/images/stacked.png" width="57px"
								alt="52af8d5da41389d36700003f_stacked.png">
						</div>
						<div class="w-col w-col-4 w-col-small-4 w-col-tiny-4">
							<div class="icon-title">Tetris</div>
							<img src="<%=request.getContextPath() %>/res/images/tetris.png" width="57px"
								alt="52af8d65aae9d4d56700005d_tetris.png">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="w-section section">
		<div class="w-container">
			<div class="w-row">
				<div class="w-col w-col-6 w-clearfix">
					<h2>Share Contents</h2>
					<p>プログラミングは孤独な作業になってしまうと長く続きません。特に独学で学んでいる人は”プログラミング=辛い"という結果になりかねません。ここで仲間を見つけて一緒に開発を楽しみましょう。</p>
					<div class="w-widget w-widget-twitter social-widget">
						<iframe
							src="https://platform.twitter.com/widgets/tweet_button.html#url=http%3A%2F%2Fwebflow.com&amp;counturl=webflow.com&amp;text=Check%20out%20this%20site&amp;count=vertical&amp;size=m&amp;dnt=true"
							scrolling="no" frameborder="0" allowtransparency="true"
							style="border: none; overflow: hidden; width: 55px; height: 62px;"></iframe>
					</div>
					<div class="w-widget w-widget-gplus social-widget">
						<div class="g-plusone" data-href="http://webflow.com"
							data-size="tall" data-annotation="bubble" data-width="120"
							data-recommendations="false" id="___plusone_0"
							style="width: 50px; height: 60px; text-indent: 0px; margin: 0px; padding: 0px; border-style: none; float: none; line-height: normal; font-size: 1px; vertical-align: baseline; display: inline-block; background: transparent;"></div>
					</div>
					<div class="w-widget w-widget-facebook social-widget">
						<iframe
							src="https://www.facebook.com/plugins/like.php?href=https%3A%2F%2Ffacebook.com%2Fwebflow&amp;layout=box_count&amp;locale=en_US&amp;action=like&amp;show_faces=false&amp;share=false"
							scrolling="no" frameborder="0" allowtransparency="true"
							style="border: none; overflow: hidden; width: 55px; height: 65px;"></iframe>
					</div>
				</div>
				<div class="w-col w-col-6 center">
					<img src="<%=request.getContextPath() %>/res/images/third-section.jpg" width="250"
						alt="52ddf261b6d2171f780000ad_third-section.jpg">
				</div>
			</div>
		</div>
	</div>
	<div class="w-section section purple">
		<div class="w-container">
			<div>
				<div>copyright 2015&nbsp;laklab.inc&nbsp;</div>
			</div>
		</div>
	</div>
	<div class="w-section section grey footer">
		<div class="w-container">
			<p class="footer-text">いつでもどこでもプログラミング ~programming anywhere~</p>
			<div class="button-block">
				<a class="w-inline-block social-button"
					href="mailto:support@webflow.com?subject=Hello!" target="_blank"><img
					src="<%=request.getContextPath() %>/res/images/email-icon.png" width="21px"
					alt="52af8da2aed63fb91400000f_email-icon.png"> </a> <a
					class="w-inline-block social-button"
					href="http://facebook.com/webflowapp" target="_blank"><img
					src="<%=request.getContextPath() %>/res/images/facebook-icon.png" width="21px"
					alt="52af8da8aed63fb914000010_facebook-icon.png"> </a> <a
					class="w-inline-block social-button"
					href="http://twitter.com/webflowapp" target="_blank"><img
					src="<%=request.getContextPath() %>/res/images/twitter-icon.png" width="21px"
					alt="52af8db1aed63fb914000011_twitter-icon.png"> </a>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/js/webflow.js"></script>
	<!--[if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>
</html>