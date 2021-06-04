<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="./include/js/jquery-1.12.0.js"></script>
<title>Insert title here</title>
<style>
	/* 메인 슬라이드 Slideshow container */
	/* Slideshow container */
	* {box-sizing:border-box}
	/* body {font-family: Verdana,sans-serif;margin:0} */
	/* 슬라이드 컨테이너 */
	.slideshow-container {
	width: 100%;
	height: 300px;
	position: static;
	margin: auto;
	margin-top: 50px;
	}
	/* 들어가는 슬라이드 이미지 */
	.main_slideImg{
	width: 100%; 
	height: 300px;
	top : 100px;
	}
	
	/* 이전 다음 버튼. */
	.prev, .next {
	  cursor: pointer;
	  position: absolute;
	  text-align : center;
	  top: 0;
	  top: 20%;
	  width: 3%;
	  padding: 16px;
	  margin-top: -22px;
	  color: white;
	  font-weight: bold;
	  font-size: 18px;
	  transition: 0.6s ease;
	  border-radius: 0 3px 3px 0;
	  z-index: 100;
	}

	/* 다음버튼 위치. */
	.next {
	  right: 0;
	  border-radius: 3px 0 0 3px;
	}

	/* 이전 다음버튼 hover. */
	.prev:hover, .next:hover {
	  background-color: rgba(0,0,0,0.8);
	}
	
	/* 캡션 텍스트 */
	/* .text {
	  color: #f2f2f2; 
	  font-size: 15px;
	  padding: 8px 12px;
	  position: absolute;
	  bottom: 8px;
	  width: 100%;
	  text-align: center;
	} */
	
	/* 페이징 텍스트 (1/3 etc) */
/* 	.numbertext {
	  color: #f2f2f2;
	  font-size: 12px;
	  padding: 8px 12px;
	  position: absolute;
	  top: 0;
	} */
	
	/* 닷버튼. */
	.dot {
	  cursor:pointer;
	  height: 13px;
	  width: 13px;
	  margin: 0 2px;
	  background-color: #bbb;
	  border-radius: 50%;
	  display: inline-block;
	  transition: background-color 0.6s ease;
	}
	
	.active, .dot:hover {
	  background-color: #717171;
	}
	
	/* 페이드 애니메이션. */
	.fade2 {
	  -webkit-animation-name: fade;
	  -webkit-animation-duration: 0.5s;
	  animation-name: fade;
	  animation-duration: 5s;
	}
	
	@-webkit-keyframes fade2 {
	  from {opacity: .4}
	  to {opacity: 1}
	}
	
	@keyframes fade2 {
	  from {opacity: .4}
	  to {opacity: 1}
	}


</style>
<script type="text/javascript">
	//슬라이드 스크립
	var slideIndex = 1;
	$(document).ready(function(){
		showSlides(slideIndex);	
		
		var timer = setInterval(function(){
			plusSlides(1); //자동 슬라이드 설정
		}, 2000);
	});
	function currentSlide(n) {
		  showSlides(slideIndex=n);
		}
	function plusSlides(n) {
		  console.log("plus");
		  showSlides(slideIndex += n);
	}
	function showSlides(n) {
		  console.log(n);
		  var i;
		  var slides = document.getElementsByClassName("mySlides");
		  console.log(slides);
		  var dots = document.getElementsByClassName("dot");
		  console.log(dots);
		  // 슬라이드가 0개일경우 . 슬라이드 인덱스 1개.
		  if (n > slides.length) {
			  console.log("n > slides.length");
			  slideIndex = 1
		  }
		  // 모든 슬라이드 디스플레이 none.
		  for (i = 0; i < slides.length; i++) {
		      slides[i].style.display = "none";
		  }
		  // 모든 닷 버튼 클래스 이름 추가.
		  for (i = 0; i < dots.length; i++) {
		      dots[i].className = dots[i].className.replace(" active", "");
		  }
		  //alert(slideIndex);
		  //
		  slides[slideIndex-1].style.display = "block";
		  // 클래스 이름 표시.
		  dots[slideIndex-1].className += " active";
		  
		  
	}
</script>
</head>
<body>
<!-- 밀어내기  -->
<div class="slideshow-container">
	<!-- 슬라이드 이미지. -->
	<div class="mySlides fade2">
		<img class="main_slideImg" src="/spw/include/img/baner1.jpg">
		
	</div>
	<div class="mySlides fade2">
		<img class="main_slideImg" src="/spw/include/img/baner2.jpg">
		
	</div>
	<div class="mySlides fade2">
		<img class="main_slideImg" src="/spw/include/img/baner3.jpg">
		
	</div>
	<div class="mySlides fade2">
		<img class="main_slideImg" src="/spw/include/img/baner4.jpg">
		
	</div>
	<!-- 좌우 버튼. -->
	<a class="prev" onclick="plusSlides(-1)">❮</a>
	<a class="next"onclick="plusSlides(1)">❯</a>
</div>
	<br>
<!-- 하단 버튼.  -->
<div style="text-align: center">
	<span class="dot" onclick="currentSlide(1)"></span> 
	<span class="dot" onclick="currentSlide(2)"></span>
	<span class="dot" onclick="currentSlide(3)"></span>
	<span class="dot" onclick="currentSlide(4)"></span>
</div>
</body>
</html>