	//슬라이드 스크립
	var slideIndex = 1;
	$(document).ready(function(){
		showSlides(slideIndex);	
		
		var timer = setInterval(function(){
			plusSlides(1); //자동 슬라이드 설정
		}, 3000);
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