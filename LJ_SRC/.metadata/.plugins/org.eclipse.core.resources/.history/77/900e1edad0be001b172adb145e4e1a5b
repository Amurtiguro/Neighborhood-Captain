<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("siteTitle", "사자판다 상품등록");
%>
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<style>
.img_container{
	 height: auto; 
	 border:1px solid #eaeaea; 
	 padding: 0px;
	 position:static;
}
</style>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9b4172322671d1cc9e49a261f3c75475&libraries=services"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	var sel_file=null;
	var geocoder = new kakao.maps.services.Geocoder();
	$(document).ready(function(){
		
		$("#gphoto").on("change", handleImgFileSelect);
		// 탭 선택
		function selectTab(){
			// 기존 선택 제거
			$("#btnSaja, #btnPanda").removeClass("tabbtn_sel");
	
			// 탭 선택
			$(this).parent().addClass("tabbtn_sel");
	
			// 값 설정
			var tabSort = $(this).attr("data-tab-sort");
			$("#gsort").val(tabSort);
	
			return false;
		}
	
		$("#btnSaja > a").click(selectTab);
		$("#btnPanda > a").click(selectTab);
		$("#btnAuction > a").click(function(){
			if(confirm("작성중이던 내용을 버리고 경매글을 작성하시겠습니까?") == false){
				return false;
			}
		});
	
	});
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
	//현위치 주소 찾기 
	function getLocation(){
		console.log("---------- 현위치로 동 찾기 버튼 클릭 ----------");	
		var va1=null;
		var va2=null;
		
		if (navigator.geolocation) {
			console.log("navigator.geoloaction :: "+navigator.geolocation);
			
			//watchposition :: 장치의 위치가 바뀔 때마다, 자동으로 새로운 위치를 사용해 호출할 처리기 함수를 등록
			navigator.geolocation.watchPosition(showPosition);
			console.log("check >>>> ");
		} else {
			console.log("Geolocation is not supported by this browser.");
		}
		
		function showPosition(position) {
			console.log(" 좌표 위도 변환 함수 start !! ");
			//좌표 경도 
			val1 = position.coords.longitude;
			//좌표 위도
			val2 = position.coords.latitude;
			console.log("val1 >>> " + val1); 
			console.log("val2 >>> " + val2);
	
			var callback = function(result, status) {
				console.log("status >>> " + status);
				if (status === kakao.maps.services.Status.OK) {
					//법정동명
					console.log("지역 명칭 : " + result[0].address_name);
					//법정동명 코드 (10자리 숫자 코드 2/3/3/2) 
					console.log("행정구역 코드 : " + result[0].code);
					document.insertForm.gloc.value = result[0].address_name;
					document.insertForm.gregcode.value = result[0].code;
				}
			};
			
			geocoder.coord2RegionCode(val1, val2, callback);
		}
	}
	//첨부파일 validation 
	function handleImgFileSelect(e){
		
		var files=e.target.files;
		var filesArr=Array.prototype.slice.call(files);
		var flag=true;
		filesArr.forEach(function(f){
			if(!f.type.match("image.*")){
				console.log("f >>>> "+f);
				console.log("확장자는 이미지 확장자만 가능");
				return false;
			}
			//이미지 확장자인 경우에만 미리보기 보여주기 
			if(flag){
				console.log("이미지 확장자임 !! ");
				sel_file=f;
				var reader=new FileReader();
				reader.onload=function(e){
					$("#image_container").attr("src",e.target.result);
				}
				reader.readAsDataURL(f);
			}else{
				console.log("이미지 확장자 입력하세요 !!");
			}
		});
	}
	/* 게시글 등록 : generalInsert */
	function generalInsert(){
		console.log("generalInsert 클릭");
		insertForm.method="POST";
		insertForm.enctype = "multipart/form-data";
		insertForm.action="generalInsert.spw";
		insertForm.submit();
	}
	
	/* 전체 목록으로 : generalAllList */
	function generalAllList(){
		//console.log("generalAllList 클릭");
		var sort = $('#gsort').val();
		if(sort=="1"){
			location.href="/spw/generalSList.spw";
		}else{
			location.href="/spw/generalPList.spw";
		}
	}
	
	/* 주소 찾기 : glocFunc */
	function glocFunc() {
       new daum.Postcode({
           oncomplete: function(data) {
               // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

               // 각 주소의 노출 규칙에 따라 주소를 조합한다.
               // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
               var addr = ''; // 주소 변수
               var extraAddr = ''; // 참고항목 변수

               //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
               if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                   addr = data.roadAddress;
               } else { // 사용자가 지번 주소를 선택했을 경우(J)
                   addr = data.jibunAddress;
               }

               // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
               if(data.userSelectedType === 'R'){
                   // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                   // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                   if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                       extraAddr += data.bname;
                   }
                   // 건물명이 있고, 공동주택일 경우 추가한다.
                   if(data.buildingName !== '' && data.apartment === 'Y'){
                       extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                   }
                   // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                   if(extraAddr !== ''){
                       extraAddr = ' (' + extraAddr + ')';
                   }
                   // 조합된 참고항목을 해당 필드에 넣는다.
                   /* document.getElementById("sample6_extraAddress").value = extraAddr; */
               
               } else {
                   /* document.getElementById("sample6_extraAddress").value = ''; */
               }

               // 우편번호와 주소 정보를 해당 필드에 넣는다.
              /*  document.getElementById('sample6_postcode').value = data.zonecode; */
               
               var sido = data.sido; // 
               var sigungu = data.sigungu; // 
               var bname = data.bname; //
               var fullloc = sido +" "+ sigungu +" "+ bname
               
               document.getElementById("gloc").value = fullloc;
               document.getElementById("gregcode").value = data.bcode;
               
               // 커서를 상세주소 필드로 이동한다.
               /* document.getElementById("sample6_detailAddress").focus(); */
           }
       }).open();
   }
	/* 숫자 천단위 입력 */
	function numberWithCommas(x) {
	    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}

		
</script>
<%@include file="/WEB-INF/view/main/top2.jsp" %>
<div class="formbox formbox_75">
	<h3>상품 등록</h3>
	<!-- 탭 -->
	<div class="formtab">
		<%
			// 종류(사자/판다)
			String gsort = "1";
			String genSort= request.getParameter("gsort");

			// 선택 클래스
			String tabselCls = "tabbtn_sel";

			if(genSort != null){
				gsort = genSort;
			}

			// 선택 클래스 설정
			String tab_saja = "";
			String tab_panda = "";
			if("1".equals(gsort)){
				tab_saja = " " + tabselCls;
			}else if("2".equals(gsort)){
				tab_panda = " " + tabselCls;
				
			}
		%>
		<div class="tabbtn tabbtn_3 tabsaja<%=tab_saja%>" id="btnSaja">
			<a data-tab-sort="1">사자</a>
		</div>
		<div class="tabbtn tabbtn_3 tabpanda<%=tab_panda%>" id="btnPanda">
			<a data-tab-sort="2">판다</a>
		</div>
		<div class="tabbtn tabbtn_3 tabauction" id="btnAuction">
			<a href="/spw/auctionWrite.spw">경매</a>
		</div>
	</div>
	<!-- 폼 -->
	<div class="formcontent">
		<form id="insertForm" name="insertForm">
			<div class="formrow">
				<label for="gtitle" class="rowlabel">제목</label>
				<input type="text" id="gtitle" name="gtitle" class="sitetxt form_ele_100" placeholder="최대 40자">
			</div>
			<div class="formrow">
				<label for="cgnum" class="rowlabel">카테고리</label>
				<select id="cgnum" name="cgnum" class="sitetxt form_ele_50">
					<option>대분류</option>
					<option value="CG01">패션잡화</option>                                    
				    <option value="CG02">여성의류</option>
				    <option value="CG03">남성의류</option>
				    <option value="CG04">디지털/가전</option>
				    <option value="CG05">도서/티켓/취미/애완</option>
				    <option value="CG06">생활/문구/가전/식품</option>
				    <option value="CG07">유아동/출산</option>
				    <option value="CG08">스포츠/레저</option>
				    <option value="CG09">뷰티/미용</option>
				    <option value="CG10">기타</option>
				</select>
			</div>
			<div class="formrow">
				<label for="gloc" class="rowlabel">거래지역</label>
				<div class="form_ele_100">
					<div class="form_ele_100">
						<input type="button" id="whereInow" onclick="getLocation()" value="현위치" class="sitebtn"/> 
						<input type="button" onclick="glocFunc()" value="주소검색" class="sitebtn"/>
					</div>
					<input type="text" id="gloc" name="gloc" placeholder="주소" class="sitetxt form_ele_75"/>
				</div>
			</div>
			<div class="formrow">
				<label for="gphoto" class="rowlabel">사진</label>
				<div class="form_ele_100">
					<img id="image_container" width="150" height="150" class="img_container"></img>
					<input type="file" name="gphoto" id="gphoto">
				</div>
			</div>
			<div class="formrow">
				<label for="gprice" class="rowlabel">가격</label>
				<input type="text" id="gprice" name="gprice" class="sitetxt form_ele_50" onkeyup="inputNumberFormat(this)">
				<span class="form_ele_onechar">원</span>
			</div>
			<div class="formrow">
				<label for="gcontents" class="rowlabel">설명</label>
				<textarea name="gcontents" id="gcontents" class="sitetxt form_ele_100" placeholder="2,000자 제한"></textarea>
			</div>
			<!-- <div class="formrow">
				<label for="gstatus" class="rowlabel">판매 상태</label>
				<select name="gstatus" id="gstatus" class="siteselect form_ele_100">
				    <option value="1">거래중</option>                                    
				    <option value="2">거래완료</option>
				    <option value="3">거래취소</option>
				</select>
			</div> -->
			<div class="formrow formrow_center">
				<!-- 사자/판다 -->
				<input type="hidden" name="gstatus" id="gstatus" value="1">
				<input type="hidden" name="gsort" id="gsort" value="<%=gsort%>">
				<input type="hidden" name="gregcode" id="gregcode">
				<input type="button" value="게시글 등록" class="sitebtn" onclick="generalInsert()">
				<input type="button" value="목록으로" class="sitebtn" onclick="generalAllList()">
			</div>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/view/main/bottom.jsp" %>