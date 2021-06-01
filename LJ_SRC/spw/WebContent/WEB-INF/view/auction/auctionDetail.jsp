<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spw.auction.vo.AuctionVO" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!-- 상단 바. -->
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<%
	request.setAttribute("siteTtitle","상세보기");
	System.out.println("상세보기 페이지 세션 회원번호 : "+sessionNum);
%>
<%
	Object obj=request.getAttribute("deatilVO");
	if(obj!=null){
		AuctionVO auvo=(AuctionVO)obj;
		System.out.println("cgname >>>" +auvo.getCgname());
%>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"> </script>
<script type="text/javascript">
	
	//숫자 천단위 콤마 형식 생성
	function inputNumberFormat(obj) {
	    obj.value = comma(uncomma(obj.value));
	}
	
	//천단위 콤마 생성 
	function comma(str) {
	    var regexp = /\B(?=(\d{3})+(?!\d))/g;
	    return str.toString().replace(regexp, ',');
	}
	
	//천단위 콤마 제거
	function uncomma(str) {
	    str = String(str);
	    return str.replace(/[^\d]+/g, '');
	}
	
	// 매개변수 : fnUse(timeDifference)함수
	// timeDifference 서버와 클라이언트의 시간 차이(1000분의 1초)
	// (양수: 서버시간이 클라이언트보다 미래, 음수: 서버시간이 클라이언트보다 과거)
	// 데이터를 가져오는데 실패하면, 0으로 설정해서 클라이언트의 시간을 사용함
	function useServerTime(fnUse){
	
		// 서버시간을 가져올 URL
		var timeURL = "/spw/getServerTime.spw";
	
		// 데이터를 가져왔을때
		function whenSuccess(data, stat){
			console.log(stat);
			if(stat == "success"){
				// 서버시간
				var sTime = data;
	
				// 시간차이 (양수: 서버시간이 클라이언트보다 미래, 음수: 서버시간이 클라이언트보다 과거)
				var timeDifference = sTime - cTime;
				console.log("서버 시간 => " + sTime);
				console.log("클라이언트 시간 => " + cTime);
				console.log("차이 => " + timeDifference);
	
				fnUse(timeDifference);
			}else{
				whenError();
			}
		}
	
		//데이터를 못가져왔을 때
		function whenError(){
			alert("서버 시간을 불러오는데 실패했습니다. 클라이언트의 시간을 사용합니다.")
	
			// 클라이언트의 시간을 사용(시간차를 0으로)
			fnUse(0);
		}
	
		//클라이언트 시간
		var cTime = new Date().getTime();
	
		// ajax
		$.ajax({
			url: timeURL,
			success: whenSuccess,
			error: whenError
		});
	}
	
	$(document).ready(function() {
		//수정버튼 클릭 이벤트
		$("#update").click(function(){
			$("#detailForm").attr({
				"method":"POST",
				"enctype":"multipart/form-data",
				"action":"/spw/auctionUpdateView.spw"
			}).submit();
		});
		
		//삭제버튼 클릭 이벤트
		$("#delete").click(function(){
			$("#detailForm").attr({
				"method":"POST",
				"enctype":"multipart/form-data",
				"action":"/spw/auctionDelete.spw"
			}).submit();
		});
		
		var timer;
		//현재 로그인한 세션에 담긴 회원번호 
		var mnumber="<%=sessionNum%>";
		
		//글쓴이 본인이 아닐 경우 수정, 삭제 버튼 숨기기 
		if(mnumber!="<%=auvo.getMnum()%>"){
			console.log("작성자가 아닌 사람이 로그인함 ");
			$("#update").hide();
			$("#delete").hide();
		}
		
		//종료시간 
		var endTime=$("#closeTime").val();
		
		//var compareDate = new Date(endTime);
		var compareDate = new Date(Number.parseInt(endTime));
		console.log("compareDate >>>  " + compareDate);
		console.log("compareDate.getTime()>>> " + compareDate.getTime());
	
		function serverClock(timeDiff){
			timeBetweenDates(compareDate, timeDiff);
			
			//setInterval :: 일정한 간격으로 함수 실행, 1000ms(1초 )
			timer = setInterval(function() {
				timeBetweenDates(compareDate, timeDiff);
			}, 1000);
	
		}
		
		useServerTime(serverClock);
	
		function timeBetweenDates(toDate, timeDiff) {
			var dateEntered = toDate;
	
			// 클라이언트 시간
			var timeNow = new Date();
			
			// 서버시간
			var now = new Date(timeNow.getTime() + timeDiff);
			
			// 시간 차(milliseconds) 
			var difference = dateEntered.getTime() - now.getTime();
			
			//경매가 종료되면 페이지 상태 변경
			if (difference <= 0) {
				$("#bidSub").attr('disabled',true);
				$("#bidSub").attr('value','종료');
				$("#bprice").attr('disabled',true);
				
				//interval 함수 종료
				clearInterval(timer);
				
				$("#count").text("종료된 경매");
				$("#removeStr").text("");
				console.log("종료 >>> " );
			} else {
				//계산된 milliseconds을 일, 시간, 분, 초로 단위 변환
				var seconds = Math.floor(difference / 1000);
				var minutes = Math.floor(seconds / 60);
				var hours = Math.floor(minutes / 60);
				var days = Math.floor(hours / 24);
	
				hours %= 24;
				minutes %= 60;
				seconds %= 60;
				
				var countdown="";
				if(days==0||days==''){
					countdown=hours+":"+minutes+":"+seconds;
				}else{
					countdown=days+"일 "+hours+":"+minutes+":"+seconds;
				}
				$("#count").text(countdown);
			}
		} //end of function

		//입찰 버튼 클릭시, 입찰정보 등록
		var vm=new Vue({
			el : "#product_info",
			data : {
				maxprice:$("#startValue").val(),
				bprice:""
			},
			methods:{
				calculation:function(){
					if(confirm("입찰하시겠습니까? ")){
						if(mnumber.indexOf("M")!=0){
							alert("비회원은 입찰 불가능 ! 로그인 하세요 ");
						}else if(mnumber=="<%=auvo.getMnum()%>"){
							alert("본인 글은 입찰 불가능 ! ");
						} else {
							//text에 입력된 금액
							var userInputPrice=this.bprice;
							console.log("입력금액 >>> "+userInputPrice);
							console.log("현재 최고가 >>> "+this.maxprice);
							
							var maxP=String(this.maxprice);
							
							var nowMaxPrice=uncomma(maxP);
							console.log("raplace comma nowMaxPrice >>> "+nowMaxPrice);
							
							var inputprice=uncomma(userInputPrice);
							console.log("raplace comma inputprice >>> "+inputprice);
							
							//입찰 거래가 성공했을 때
							if(parseInt(nowMaxPrice)<parseInt(inputprice)){
								 
								//금액 천단위 콤마 설정
								var res=comma(uncomma(userInputPrice));
								console.log("res >>> "+res);
								
								this.maxprice=res;
								
								var anumber=$("#anum").val();
								
								var fdata = {mnum: mnumber
											,bprice: inputprice
											,anum : anumber};
								
								var urls="/spw/bidInsert.spw";
								
								$.ajax({
									type : "get",
									url:urls,
									data : fdata,
									success: whenSuccess,
									error: whenError,
								});
								
								function whenSuccess(res){
									console.log(" 입찰 insert 성공!");
									$("#bprice").val('');
								}
								
								function whenError(){
									console.log(" 입찰 insert 실패!")	;			
								}
							}else{
								alert("현재 최고가보다 높은 금액 입력하세요.");
							}
						}
					}
				}
			}
		});
	});
	
	
</script>
<%@include file="/WEB-INF/view/main/top2.jsp" %>
<form id="detailForm" name="detailForm">
	<input type="hidden" id="anum" name="anum" value="<%=auvo.getAnum() %>"/>
	<div id="sitecontent">
		<div class="wrapper">
			<div class="product_detail">
				<div class="product_top">
					<h2 class="product_title"> 
						<%=auvo.getAtitle() %>
					</h2>
					<div class="product_info_mini">
						<span class="product_writer">
							 아이디 : <%=auvo.getMid() %> 
						</span>
						<span class="product_date">
							(<%=auvo.getAregdate() %>)
						</span>
					</div>

					<!-- product_info_images의 style와 내부의 img태그의 src에 동일한 이미지 경로 입력 -->
					<div class="product_info_images" style="background-image: url('/spw/uploadImages/<%=auvo.getAphoto()%>');" alt="상품 이미지">
						<img src="/spw/uploadImages/<%=auvo.getAphoto() %>"/>
					</div>
					
					<div class="product_info_side" id="product_info">
						<div class="product_sort_label label_auction">경매</div>
						<div class="product_info_detail">
							<p>카테고리 : <span><%=auvo.getCgname() %></span></p>
							<p>거래지역 : <span><%=auvo.getAloc() %></span></p>
							<p>시작가격 : <span><%=auvo.getApricemin() %></span>원</p>
							<p>종료시간 : <span id=""><%=auvo.getAendtime() %></span></p>
						</div>
						<div class="product_info_bottom">
							<div class="product_info_auction">
								남은시간 : <span id="count"></span>
								<%
									Date endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(auvo.getAendtime());
								%>
								<input type="hidden" id="closeTime" value="<%=endTime.getTime()%>"/>
								<%-- <input type="hidden" id="closeTime" value="<%=auvo.getAendtime()%>"/> --%>
							</div>
							<div class="product_info_price">
								<span id="">{{maxprice}}</span>원
								<input type="hidden" id="startValue" value="<%=auvo.getBidhighprice()%>">
							</div>
							<div class="product_action">
								<input type="text" id="bprice" name="bprice" v-model="bprice"  class="sitetxt bidtxt"  onkeyup="inputNumberFormat(this)"/> 
								<input type="button" id="bidSub" @click="calculation" class="sitebtn label_default" value="입찰"/>
							</div>
						</div>
					</div>
				</div>
				<div class="product_content">
					<h4>상세 설명</h4>
					<div class="product_content_txt">
						<%=auvo.getAcontents()%>
					</div>
					<div class="product_content_btn">
						<a href="/spw/auctionUpdateView.spw?anum=<%=auvo.getAnum()%>" class="sitebtn" id="update">수정</a>
						<a href="/spw/auctionDelete.spw?anum=<%=auvo.getAnum()%>" class="sitebtn" id="delete">삭제</a>
						<a href="/spw/auctionList.spw" class="sitebtn">목록</a>
					</div>
				</div>
			</div>
		</div>
	</div> 

<%
		}else{
			System.out.println("obj is null ");
%>
		<script>
			console.log("데이터 없음! ");
			location.href="/index.jsp";
		</script>
<%
		}
%> 
	
</form>
<%-- 댓글 --%>
<jsp:include page="/comment/list.spw">
	<jsp:param value="${param.anum}" name="cpnum"/>
</jsp:include>
<!-- 하단 바. -->
<%@ include file="/WEB-INF/view/main/bottom.jsp" %>
</body>
</html>