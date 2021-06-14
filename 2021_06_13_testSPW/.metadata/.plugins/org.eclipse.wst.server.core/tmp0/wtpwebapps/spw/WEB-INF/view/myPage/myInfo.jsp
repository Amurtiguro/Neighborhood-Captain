<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spw.member.vo.MemberVO" %>
<%
	System.out.println("<myInfo>");
	Object obj = request.getAttribute("mvo");
	System.out.println("obj null확인 : "+obj);
	MemberVO mvo = (MemberVO)obj;
	System.out.println("mvo null확인 : "+mvo);
	
 %>
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<link rel="stylesheet" href="./include/css/myinfo.css">
<script type="text/javascript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="./include/js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		console.log("jQuery 실행 : ");
		// POST 방식.
		$('#myInfoForm').attr('method','POST');
		
		// 전 페이지인 마이페이지로 이동 버튼.
		$('#myPage').click(function(){
			console.log("마이페이지 실행 : ");
			$('#myInfoForm').attr('action','/spw/myPage.spw');
			$('#myInfoForm').submit();
		});
		// 수정 버튼.
		$('#myUpdateOK').click(function(){
			console.log("수정 실행 : ");
			$('#myInfoForm').attr('action','/spw/memberUpdate.spw');
			$('#myInfoForm').submit();
		});
		// 탈퇴 버튼.
		$('#myDeleteOK').click(function(){
			console.log("탈퇴 실행 : ");
			$('#myInfoForm').attr('action','/spw/memberDelete.spw');
			$('#myInfoForm').submit();
		});
	});
	//주소검색
	function addrCheck(){
		console.log("---------- 다음 주소 검색 api ----------");
		var width = 500;
		var height = 600;
		
		daum.postcode.load(function(){
			new daum.Postcode({
				oncomplete: function(data){							
					console.log("새우편번호 >>> : " + data.zonecode);
					console.log("주소값 >>> : " + data.address);
					console.log("빌딩값 >>> : " + data.buildingName);	
					console.log("시/도이름 >>> : " + data.sido);
					console.log("시/군/구이름 >>> : " + data.sigungu);
					console.log("법정동/법정리 이름 >>> : " + data.bname);
					console.log("법정리의 읍/면 이름 >>> : " + data.bname1);
					console.log("법정동/법정리 이름 >>> : " + data.bname2);
					console.log("법정동 코드 >>> : " + data.bcode);
					// 시군구 동.
					var address=data.sido+" "+data.sigungu+" "+data.bname+" "+data.bname1;
					
					// 우편번호.
					document.myInfoForm.maddr0.value = data.zonecode;
					// 주소.
					document.myInfoForm.maddr1.value = data.address;
					// 상세주소.
					document.myInfoForm.maddr2.value = data.buildingName;
					console.log(">>> "+address);
				}	
			}).open({
				left: (window.screen.width / 2) - (width / 2),
				top: (window.screen.height / 2) - (height / 2),
			});						
		});				
	}
	
</script>
<!-- 상단 바. -->
<%@include file="/WEB-INF/view/main/top2.jsp" %>
<div class="myinfo_contents">
<form id="myInfoForm" name="myInfoForm">
<input type="hidden" name="mnum" id="mnum" value="<%=mvo.getMnum() %>"/>
<h2>회원정보 수정</h2>
<div class="myinfo_func">
	<span>
		<input type="button" value="뒤로" name="myPage" id="myPage" class="sitebtn"/>
		<input type="submit" value="수정" name="myUpdateOK" id="myUpdateOK" class="sitebtn"/>
		<input type="button" value="탈퇴" name="myDeleteOK" id="myDeleteOK" class="sitebtn"/>		
	</span>
</div>
<div class="myinfo_form">
	<div class="myinfo_center">
		<div class="myinfo_left">
			<!-- <a>번호</a><br> -->
			<a>아이디</a><br>
			<a><font>*</font>비밀번호</a><br>
			<a><font>*</font>이름</a><br>
			<a><font>*</font>휴대폰 번호</a><br>
			<a><font>*</font>이메일</a><br>
			<a><font>*</font>우편번호</a><br>
			<a><font>*</font>주소</a><br>	
			<a><font>*</font>상세주소</a><br>		
			<a>회원등록일</a>
<!-- 			<a>등록일</a><br>
			<a>수정일</a> -->
		</div>
		<div class="myinfo_middle">
			<span><input type="text" name="mid" id="mid" value="<%=mvo.getMid() %>" disabled/></span><br>
			<span><input type="text" name="mpw" id="mpw" value="<%=mvo.getMpw() %>"/></span><br>
			<span><input type="text" name="mname" id="mname" value="<%=mvo.getMname() %>"/></span><br>
<%
	// 전화번호.
	String phone = mvo.getMphone();
	// - 로 나눈 전화번호.
	String phone0="";
	String phone1="";
	String phone2="";
	String rePhone="";
	// 있을 경우 그냥하고 없을경우 삽입.
	int ynBar = phone.indexOf("-");
	if(ynBar>0){
%>
			<span><input type="text" name="mphone" id="mphone" value="<%=mvo.getMphone() %>"></span><br>
<%	
	}else{
		phone0 = phone.substring(0, 3);
		System.out.println("010 : "+phone0);
		phone1 = phone.substring(3, 7);
		System.out.println("XXXX : "+phone1);
		phone2 = phone.substring(7,11);
		System.out.println("XXXX : "+phone2);
		rePhone=phone0+"-"+phone1+"-"+phone2;
%>
			<span><input type="text" name="mphone" id="mphone" value="<%=rePhone %>"></span><br>
<%
	}
%>				
			<span><input type="text" name="memail" id="memail" value="<%=mvo.getMemail() %>"/></span><br>
			<span><input type="text" name="maddr0" id="maddr0" value="<%=mvo.getMaddr0() %>"/></span><br>
			<span><input type="text" name="maddr1" id="maddr1" value="<%=mvo.getMaddr1() %>"/></span><br>
			<span><input type="text" name="maddr2" id="maddr2" value="<%=mvo.getMaddr2() %>"/></span><br>
			<span><input type="text" name="mregdate" id="mregdate" value="<%=mvo.getMregdate() %>" readOnly/></span>
<%-- 			<span><input type="text" name="mindate" id="mindate" value="<%=mvo.getMindate() %>"/></span><br>
			<span><input type="text" name="mupdate" id="mupdate" value="<%=mvo.getMupdate() %>"/></span><br> --%>
		</div>
		<div class="myinfo_right">
			<input type="button" onclick="addrCheck()" value="주소" class="sitebtn">
			
		</div>
	</div>
</div>
</form>
</div>
<!-- 하단 바. -->
<%@ include file="/WEB-INF/view/main/bottom.jsp" %>
</body>
</html>