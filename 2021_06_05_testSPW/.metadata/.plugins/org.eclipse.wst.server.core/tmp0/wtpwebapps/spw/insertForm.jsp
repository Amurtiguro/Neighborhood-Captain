<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("siteTitle", "입력폼");
%>
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){

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


	/* 게시글 등록 : generalInsert */
	function generalInsert(){
		alert("generalInsert 클릭");
		insertForm.method="POST";
		insertForm.enctype = "multipart/form-data";
		insertForm.action="generalInsert.spw";
		insertForm.submit();
	}
	
	/* 전체 목록으로 : generalAllList */
	function generalAllList(){
		alert("generalAllList 클릭");
		location.href="generalAllList.spw";
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
<!-- 사용예(탭 + 폼) -->
<div class="formbox formbox_50">
	<h3>글쓰기</h3>
	<!-- 탭 -->
	<div class="formtab">
		<div class="tabbtn tabbtn_3 tabsaja tabbtn_sel" id="btnSaja">
			<a data-tab-sort="1">사자</a>
		</div>
		<div class="tabbtn tabbtn_3 tabpanda" id="btnPanda">
			<a data-tab-sort="2">판다</a>
		</div>
		<div class="tabbtn tabbtn_3 tabauction" id="btnAuction">
			<a href="#링크">경매</a>
		</div>
	</div>
	<!-- 폼 -->
	<div class="formcontent">
		<form id="insertForm" name="insertForm">
			<div class="formrow">
				<label for="gtitle" class="rowlabel">제목</label>
				<input type="text" id="gtitle" name="gtitle" class="sitetxt form_ele_100" placeholder="40자 제한">
			</div>
			<div class="formrow">
				<label for="cgnum" class="rowlabel">카테고리</label>
				<select id="cgnum" name="cgnum" class="sitetxt form_ele_100">
					<option name= "패션잡화" value="CG01">패션잡화</option>                                    
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
				<input type="text" id="gloc" name="gloc" class="sitetxt form_ele_50" placeholder="주소">
				<span class="form_ele_onechar"></span>
				<div class="form_ele_30">
					<input type="button" onclick="glocFunc()" class="sitebtn" value="주소 찾기">
				</div>
			</div>
			<div class="formrow">
				<label for="gphoto" class="rowlabel">사진</label>
				<input type="file" name="gphoto" id="gphoto" class="form_ele_100">
			</div>
			<div class="formrow">
				<label for="gprice" class="rowlabel">전화</label>
				<input type="text" id="gprice" name="gprice" class="sitetxt form_ele_50">
				<span class="form_ele_onechar">원</span>
			</div>
			<div class="formrow">
				<label for="gcontents" class="rowlabel">설명</label>
				<textarea name="gcontents" id="gcontents" class="sitetxt form_ele_100" placeholder="2,000자 제한"></textarea>
			</div>
			<div class="formrow">
				<label for="gstatus" class="rowlabel">판매 상태</label>
				<select name="gstatus" id="gstatus" class="siteselect form_ele_100">
				    <option value="1">거래중</option>                                    
				    <option value="2">거래완료</option>
				    <option value="3">거래취소</option>
				</select>
			</div>
			<div class="formrow formrow_center">
				<!-- 사자/판다 -->
				<input type="hidden" name="gsort" id="gsort" value="1">
				<input type="button" value="게시글 등록" class="sitebtn" onclick="generalInsert()">
				<input type="button" value="목록으로" class="sitebtn" onclick="generalAllList()">
			</div>
		</form>
	</div>
</div>
<%@ include file="/WEB-INF/view/main/bottom.jsp" %>