<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/main/top1.jsp"%>
<link rel="stylesheet" href="/spw/include/css/adminform.css">
<script type="text/javascript">
//html을 동적으로 만들려면 제이쿼리 reay사용
	$(document).ready(function(){
		//(실시간)년도를 계산하기 위한 변수 선언
		var year = new Date().getFullYear();
		var previousYear = 	year-1;
		var twoYearsAgo = (year-2);
		var threeYearsAgo =( year-3);
		var FourYearsAgo = (year-4);
	
		//년도를 해당 html 태그(select태그 내부의 option태그)에 넣기
		document.getElementById('thisYear').value = year;
		document.getElementById('thisYear').innerText = year;
		
		document.getElementById('previousYear').value = previousYear;
		document.getElementById('previousYear').innerText = previousYear;
		
		document.getElementById('twoYearsAgo').value = twoYearsAgo;
		document.getElementById('twoYearsAgo').innerText = twoYearsAgo;
		
		document.getElementById('threeYearsAgo').value = threeYearsAgo;
		document.getElementById('threeYearsAgo').innerText = threeYearsAgo;
		
		document.getElementById('FourYearsAgo').value = FourYearsAgo;
		document.getElementById('FourYearsAgo').innerText = FourYearsAgo;
	});//end of $(document).ready
	
	function cnt() {
		//분기별 선택 값을 추출해서  분기해서 담기 
	    var years = document.getElementById('selectYear').value;
		var start1 = years+"0101";
		var end1 = years+"0331";
		var start2 = years+"0401";
		var end2 = years+"0630";
		var start3 = years+"0701";
		var end3 = years+"0930";
		var star4 = years+"1001";
		var end4 = years+"1231";
		}//end of cnt()
</script>
    <script type="text/javascript">
    $(document).ready(function(){
    	
    	//제이쿼리는 태그선택을 name으로 선택하는게 아니라 id로 선택한다.
 		$("#search").on("click",function(){
 			var cgNum = $("#cgNum").val();
 			if(cgNum == "모두 선택"){
 				cgNum=null;
 			}
 			
 			$.ajax({
 				url :"/spw/cntAllData.spw" ,
 				type : "post",
 				dataType : "json",
 				data : {"selectYear":$("#selectYear").val(),"cgNum":cgNum}, //보내는 데이터를 어떻게 보낼지 생각해봐야 한다.
 				success : function(list, status, xhr){
 					console.log("리스트 list :", list);
 					
 					google.charts.load('current', {'packages':['corechart']});
 					google.charts.setOnLoadCallback(drawChart);
 					
 					function drawChart(){
 						var data = google.visualization.arrayToDataTable(list);
 						var options = {
 						          title : '년도 별 상품등록 현황',
 						          vAxis: {title: '상품등록 수'},
 						          hAxis: {title: '분기별'},
 						          seriesType: 'bars',
 						          series: {5: {type: 'line'}}     
 						          };
 						var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
 				        chart.draw(data, options);

 					}//deawChart 종료
 					
 				},//success 종료
 				error: function(xhr,status,error){
 					console.log(error);
 				}
 			}) //ajax 종료
 			
 			return false;
 		});   
    });
    </script>
<%@ include file="/WEB-INF/view/main/top2.jsp"%>
	
	<br>
	<br>
	<div class="list_sort">
    	<div class="tab_sort tab_panda">
    		<a href="/spw/adminSelectAll.spw">회원 관리</a>
    	</div>
    	<div class="tab_sort tab_saja tab_sel">
    		상품등록 현황
    	</div>
    	<div class="tab_sort tab_comment">
    		<a href="/spw/comment/listall.spw">댓글 관리</a>
    	</div>
    </div>
	<div class="chart" align="center" style="background-color: #EAEAEA">
	<div id="chart_div" style="width: 900px; height: 500px;"></div><br> 
	<form id="chartinput" name="chartinput">
	카테고리 선택 <select id="cgNum">
		<option>모두 선택</option>
		<option value="CG01">패션잡화 </option>
		<option value="CG02">여성의류</option>
		<option value="CG03">남성의류</option>
		<option value="CG04">디지털/가전</option>
		<option value="CG05">도서/티켓/취미/애완</option>
		<option value="CG06">생활/문구/가구/식품</option>
		<option value="CG07">유아동/출산</option>
		<option value="CG08">스포츠/레저 </option>
		<option value="CG09">뷰티/미용</option>
		<option value="CG10">기타</option>
		</select>
	연도선택
		<select id="selectYear" name="selectYear">
			<option id="thisYear"></option>
			<option id="previousYear" ></option>
			<option id="twoYearsAgo"></option>
			<option id="threeYearsAgo"></option>
			<option id="FourYearsAgo"></option>
		</select>
		 <input type="button" id ="search" name="search" value="조회" onclick="cnt()"> 
		 <input type="hidden" id ="startDate" name="startDate" value="">
		 <input type="hidden" id="endDate"name="endDate" value="">
	</form>
	</div>
<%@ include file="/WEB-INF/view/main/bottom.jsp"%>