$(function(){
	// Masonryの対象となる親要素
	var $container = $('.photo-tile');

	// 読み込み中のスタイルにする
	$container.addClass("loading");

	// Masonryの初期設定
	var msnry = new Masonry($container[0], {
		itemSelector: '.photo-tile li',
		transitionDuration: "0.2s",
		gutter: 15,
		isFitWidth: true
	});

	// 画像読み込み後レイアウトを構築
	$container.imagesLoaded(function() {
		msnry.layout();
	}).progress(function(instance, image){
		var result = image.isLoaded ? 'loaded' : 'broken';
		if(result == "broken"){
			image.img.src = "images/no-image.jpg";
		}
	});

	// レイアウト構築後に実行
	msnry.on('layoutComplete', function(){
		if($container.hasClass("loading")){
			$container.removeClass("loading");
		}
	});

	// 画像読み込み後レイアウトを構築（リサイズ時の動きを隠す）
	// $(window).bind('resize', function(){
	// 	$('.photo-tile').addClass("loading");
	// });
});