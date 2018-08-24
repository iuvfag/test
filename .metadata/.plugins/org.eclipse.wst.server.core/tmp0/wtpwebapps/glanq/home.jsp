<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム画面</title>

<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<link rel="stylesheet" href="./css/home.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-2.2.3.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<!--    スライドの設定 -->
<script>
$(document).ready(function(){
    $('.slider').bxSlider({
  	  auto:true,
  	  mode:'fade',
  	  speed:1000,
  	  infinite:true,
 	  pager:false,
  	  controls:false,

    });
  });




$(function(){
    $(window).scroll(function (){
        $('.concept').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
//          300pxスクロールでscrollinが始動
            if (scroll > elemPos - windowHeight + 200){
                $(this).addClass('scrollin');
            }
        });
    });
});


$(function(){
    $(window).scroll(function (){
        $('.intro_title').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 200){
                $(this).addClass('scrollin2');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.BBQ1').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 200){
                $(this).addClass('scrollin3');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.BBQ2').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 200){
                $(this).addClass('scrollin4');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.BBQ3').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 200){
                $(this).addClass('scrollin5');
            }
        });
    });
});

//左サイド
$(function(){
    $(window).scroll(function (){
        $('.left1').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 250){
                $(this).addClass('scrollanime1');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.left2').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 300){
                $(this).addClass('scrollanime2');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.left3').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 300){
                $(this).addClass('scrollanime3');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.left4').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 300){
                $(this).addClass('scrollanime4');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.left5').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 300){
                $(this).addClass('scrollanime5');
            }
        });
    });
});
$(function(){
    $(window).scroll(function (){
        $('.left6').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 300){
                $(this).addClass('scrollanime6');
            }
        });
    });
});


// 右サイド
$(function(){
    $(window).scroll(function (){
        $('.right1').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 250){
                $(this).addClass('scrollanime1');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.right2').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 300){
                $(this).addClass('scrollanime2');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.right3').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 300){
                $(this).addClass('scrollanime3');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.right4').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 300){
                $(this).addClass('scrollanime4');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.right5').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 300){
                $(this).addClass('scrollanime5');
            }
        });
    });
});

$(function(){
    $(window).scroll(function (){
        $('.right6').each(function(){
            var elemPos = $(this).offset().top;
            var scroll = $(window).scrollTop();
            var windowHeight = $(window).height();
            if (scroll > elemPos - windowHeight + 300){
                $(this).addClass('scrollanime6');
            }
        });
    });
});



</script>
</head>

<body>

<s:include value="header.jsp" />

<div id="wrapper">

<!-- 	gifファイルの埋め込み -->
<div id="gif">
<iframe src="https://publish.animatron.io/4ab47b5b5272616eb6ab368f?w=1066&h=600&a=1&r=1&c=0" width="1066" height="600" frameborder="0"></iframe>
</div>

<div class="main">

<div class="space1"></div>

<div class="left">
<div class="left1"></div><div class="space2"></div>
<div class="left2"></div><div class="space2"></div>
<div class="left3"></div><div class="space3"></div>
<div class="left4"></div><div class="space3"></div>
<div class="left5"></div><div class="space3"></div>
<div class="left6"></div><div class="space4"></div>
<div class="left1"></div><div class="space2"></div>
<div class="left2"></div><div class="space2"></div>
<div class="left3"></div><div class="space3"></div>
<div class="left4"></div><div class="space3"></div>
<div class="left5"></div><div class="space3"></div>
<div class="left6"></div><div class="space1"></div>
</div>

<div class="center">
<!-- サイトコンセプト -->
<div class="concept">
<h2>GLANQとは？</h2>
<br>
GLANQとはGlamorousとBBQを併せた造語であり、<br>
それらの意味通り普段とは一風変わった<br>
「華やかで魅惑的なBBQ体験を提供したい」<br>という思いが込められています。<br>
お好きなものをお好きな分だけお届けします。
<br>
</div>

<div class="space1"></div>

<!-- 提携BBQ場の紹介 -->
<div class="BBQ_spot_introduction">

<div class="intro_title">
<h2>提携BBQ場の紹介</h2>
<br>
GlanQでは3つのBBQ場と提携しており、<br>食材を各BBQ場に送り完全手ぶらでBBQが楽しめます。<br>
タイプの異なる3つの中から場所をお選びいただけます。<br>

</div>

<div class="space1"></div>

<div class="BBQ1">
<h3>BBQ場1</h3>

<img src="./images/basyo1.jpg" width="100%" height="100%" alt="" class="BBQ1_img" >

<div class="BBQ1_text">
<p>お子様連れの方にオススメ♪</p>
<p>BBQ施設の隣には大きな公園が</p>
<p>隣接しているので</p>
<p>緑に囲まれた場所で楽しいBBQの時間を</p>
<p>過ごすことができます。
</div>
</div>

<div class="space2"></div>

<div class="BBQ2">
<h3>BBQ場2</h3>
<div class="BBQ2_text">
<p>隣に川が流れているのが</p>
<p>このBBQ場の最大のポイント！</p>
<p>太陽に照らされる眩しい川を</p>
<p>眺めながら食べるお肉は絶品でしょう♪</p></div>
<img src="./images/basyo2.jpg" width="100%" height="100%" alt="" class="BBQ2_img" >
</div>

<div class="space2"></div>


<div class="BBQ3">
<h3>BBQ場3</h3>
<img src="./images/basyo3.jpg" width="100%" height="100%" alt="" class="BBQ3_img">
<div class="BBQ3_text">
<p>駅からたったの徒歩5分！</p>
<p>アクセスの良さが一番のBBQ場です。</p>
<p>手ぶらで気軽に楽しむことができるので</p>
<p>デートのプランにオススメです♪</p></div>
</div>

</div>

</div>



<div class="right">

<div class="right1"></div><div class="space2"></div>
<div class="right2"></div><div class="space2"></div>
<div class="right3"></div><div class="space3"></div>
<div class="right4"></div><div class="space3"></div>
<div class="right5"></div><div class="space3"></div>
<div class="right6"></div><div class="space4"></div>
<div class="right1"></div><div class="space2"></div>
<div class="right2"></div><div class="space2"></div>
<div class="right3"></div><div class="space3"></div>
<div class="right4"></div><div class="space3"></div>
<div class="right5"></div><div class="space3"></div>
<div class="right6"></div><div class="space1"></div>

</div>


</div>
</div>

	<s:include value="footer.jsp" />

</body>
</html>