$(function(){
	$('a[href = "#"]').click(function(){
		var speed = 500;
		var href = $(this).attr("href");
		/* 上記の文で「hrefタグのhref属性の値」
		 * を入手することが出来る */

		var target = $(href == "#" || href == "" ? 'html' : href);
		/* 入手した値が＃か空欄の場合はhtmlを
		 * そうでない場合はhref(href属性の値を再度とってくる)を
		 * targetに代入 */

		var position = target.offset().top;
		/* 上で入手した値の座標{"top":(y座標), "left":(x座標)}を入手
		 * topを利用することでtopのみの値を入手し、positionに代入 */

		$("html, body").animate({
			scrollTop : position
		}, speed, "swing");
		/* animateで要素を動かすことが出来る
		 * 今回はhtmlとbodyを
		 * scroll-top(jQueryでは小文字大文字のキャメルケースで記述)方向(ページトップ)に
		 * position分動かす
		 *
		 * 後の引数に数字を指定することでオプションの設定をすることが出来る
		 * 今回はspeed(500)、swingで動く
		 *
		 */
		return false;
	});
});