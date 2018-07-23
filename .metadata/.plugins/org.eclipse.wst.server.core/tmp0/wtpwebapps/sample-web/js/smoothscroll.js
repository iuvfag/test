$(function() {
	$('a[href^="#"]').click(function() {
		var speed = 500;
		var href = $(this).attr("href");
		/* 上記の文で「hrefタグのhref属性の値」
		 * を入手することが出来る */
		var target = $(href == "#" || href == "" ? 'html' : href);
		var position = target.offset().top;
		$("html, body").animate({
			scrollTop : position
		}, speed, "swing");
		return false;
	});
});