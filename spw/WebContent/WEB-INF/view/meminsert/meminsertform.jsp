<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<link rel="stylesheet" href="/spw/include/css/login.css">
<link rel="stylesheet" href="/spw/include/css/memberinsert.css">


<script type="text/javascript" src="/spw/include/js/jquery-1.12.0.js"></script>
<script type="text/javascript"
	src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	//ajax로  DB의 id 중복 체크
	function fn_idchk() {
	 $.ajax({
		 url : "/spw/idchk.spw", //실행할 컨트롤러
		 type : "post", // 전송방식
		 dataType : "json", // 서버측에서 전송받은 데이터 형식
		 data : {"mid":$("#mid").val()}, //서버로 전송할 데이터
		 success : function(data){
			 if(data==1){
				 alert("중복된 아이디입니다.");
			 }else if(data==0){
				 $("#idchk").attr("value","Y");
				 alert("사용가능한 아이디입니다.");
			 }
		 }
	 })//end of $.ajax({
	}; //end of function fn_idchk() 
</script>

<script type="text/javascript">
//유효성 검사
 function vali(){
	 //아이디
	 if(document.joinform.mid.value==""){
		 alert("아이디를 입력하세요");
		 document.getElementById("mid").focus();
		 return false;
	 }else{
	//	 var exp = /^[a-zA-Z0-9]+$/; 
	/*	 if(!exp.test(document.joinform.mid.value)){
			 document.getElementById("mid").focus();
			 return false;
		 }*/
		 document.getElementById("mpw").focus();
	 }
	 //비밀번호 
	 if(document.joinform.mpw.value ==""){
		 alert("비밀번호를 입력하세요");
		 document.getElementById("mpw").focus();
		 return false;
	 }else{
	//	 var exp = 정규식;
/*		 if(!exp.test(document.joinform.mpw.value)){
			 alert("비밀번호를 확인하세요");
			 document.getElementById("mpw").focus();
			 
			 return false;
		 }*/
		 document.getElementById("mname").focus();
	 }
	 //이름
	 if(document.joinform.mname.value==""){
		 alert("이름을 입력하세요");
		 document.getElementById("mname").focus();
		 return false;
	 }else{
	//	 var exp = 정규식;
/*		 if(!exp.test(document.joinform.mname.value)){
			 alert("이름을 확인하세요");
			 document.getElementById("mname").focus();
			 return false;
		 } */
		 document.getElementById("mphone0").focus();
	 }
	 //휴대폰 mphone0
	 if(document.joinform.mphone0.value==""){
		 alert("핸드폰 입력하세요");
		 document.getElementById("mphone0").focus();
		 return false;
	 }else{
	//	 var exp = 정규식;
/*		 if(!exp.test(document.joinform.mphone0.value)){
			 alert("핸드폰을 확인하세요");
			 document.getElementById("mphone0").focus();
			 return false;
		 } */
		 document.getElementById("mphone1").focus();
	 } 
	 //핸드폰 mphone1
	 if(document.joinform.mphone1.value==""){
		 alert("핸드폰 입력하세요");
		 document.getElementById("mphone1").focus();
		 return false;
	 }else{
	//	 var exp = 정규식;
/*		 if(!exp.test(document.joinform.mphone1.value)){
			 alert("핸드폰을 확인하세요");
			 document.getElementById("mphone1").focus();
			 return false;
		 }*/
		 document.getElementById("mphone2").focus();
	 } 
	 //핸드폰 mphone2
	 if(document.joinform.mphone2.value==""){
		 alert("핸드폰 입력하세요");
		 document.getElementById("mphone2").focus();
		 return false;
	 }else{
	//	 var exp = 정규식;
	/*	 if(!exp.test(document.joinform.mphone2.value)){
			 alert("핸드폰을 확인하세요");
			 document.getElementById("mphone2").focus();
			 return false;
		 }*/
		 document.getElementById("memail0").focus();
	 }
	 //이메일 memail0
	 if(document.joinform.memail0.value==""){
		 alert("이메일 입력하세요");
		 document.getElementById("memail0").focus();
		 return false;
	 }else{
	//	 var exp = 정규식;
	/* if(!exp.test(document.joinform.memail0.value)){
			 alert("이메일을 확인하세요");
			 document.getElementById("memail0").focus();
			 return false;
		 }*/
		 document.getElementById("maddr2").focus();
	 }
	 //약관동의 chk
	 if(document.joinform.chk.checked == false){
		 alert("약관동의를 체크하세요");
		
		 return false;
	 }else{
		 console.log(document.joinform.chk.value);
	 }
	 
	 
	 
	 window.document.joinform.action ="/spw/meminsert.spw";
	 window.document.joinform.method = "post";
	 window.document.joinform.submit();
 }

//입력시 email 체크 기능
function emailCheck(){
	var emailval = document.joinform.memail.options[document.joinform.memail.selectedIndex].value;
	if(emailval=='0'){
		document.joinform.memail1.readOnly=true;
		document.joinform.memail1.value="";
	}
	if(emailval=='9'){
		document.joinform.memail1.readOnly=false;
		document.joinform.memail1.value="";
		document.joinform.memail1.focus();
	}else{
		document.joinform.memail1.readOnly=true;
		document.joinform.memail1.value = emailval;
		
	}
	
}
//입력시 주소 api 사용 메서드
function addrCheck(){
				var width = 500;
				var height = 600;
				daum.postcode.load(function(){
					new daum.Postcode({
						oncomplete: function(data){							
							console.log(data);
							console.log("새주소값 >>> : " + data.address);
							console.log("옛주소값 >>> : "+data.jibunAddress);
							console.log("빌딩값 >>> : " + data.buildingName);	
							document.joinform.maddr0.value = data.zonecode;							
							document.joinform.maddr1.value = data.address;
							document.joinform.maddr2.value = data.buildingName;
						}	
					}).open({
						left: (window.screen.width / 2) - (width / 2),
						top: (window.screen.height / 2) - (height / 2),
					});						
				});				
			}
//입력시 비밀번호 체크 메서드
function pwCheck(){
	var pw = document.getElementById("mpw");
	var pwr = document.getElementById("mpwr");
	
	if(pw.value== pwr.value){
		alert("비밀번호가 같습니다");
		document.getElementById("mname").focus();
		return true;
	}else{
		alert("비밀번호가 다릅니다.");
		 pw.value="";
		 pwr.value="";
		 pw.focus();
		 return false;
	}
	
}

</script>
</head>
<body>

	<div class="background_img"></div>
	<!-- 인라인 자바스크립트 -->
	<input type="hidden" id="insertfail" name="insertfail"
		value="<%=request.getAttribute("result")%>">
	<script type="text/javascript">
	//아이디가 중복되어 DB에 입력을 시도 했을 때
	$(document).ready(function(){
		var s = $("#insertfail").val();
		console.log(s);
		//처음에 문자열 null이 들어가 있다.
		if(s!="null"&&s!="NULL"&&s!=null){
			 alert(s);
		 }else{
			 
		 }
		
		$("#joinform").submit(vali);
	});
	
	
	</script>
	<div class="login_wrapper">
		<div class="login_box1">
			<div class="dd" style="padding-top: 10px">
				<h1 align="center">회원가입</h1>
				<!--  action="/spw/meminsert.spw"-->
				<div class="login_contents">
					<div class="login_form" >
						<form name="joinform" id="joinform" class="joinform" method="post">
							<table>

								<tr>
									<td class="sub_subject" align="left"><span style="color: red;"> * </span>아이디<td>
									</tr>
									<tr>
									<td align="left">
									<input type="text" name="mid" id="mid"class="loginfo"/>
										<button class="btn" type="button" id="idchk"
											onclick="fn_idchk();" value="N">중복확인</button> <br /></td>
								</tr>
								<tr>
									<td class="sub_subject" align="left"><span style="color: red;"> * </span>비밀번호</td>
									</tr>
									<tr>
									<td align="left"><input type="password" name="mpw"
										id="mpw"class="loginfo" /><br> <input type="password" name="mpwr"
										id="mpwr"class="loginfo" /> <input type="button" value="비밀번호확인"
										onclick="pwCheck()"class="btn"/></td>
								</tr>
								<tr>
									<td class="sub_subject" align="left"><span style="color: red;"> * </span>이   름</td>
									</tr>
									<tr>
									<td align="left"><input type="text" name="mname"
										id="mname" class="loginfo"/><br></td>
								</tr>
								<tr>
									<td class="sub_subject" align="left"><span style="color: red;"> * </span>휴대전화</td>
									</tr>
									<tr>
									<td align="left" ><input type="text" name="mphone0"
										id="mphone0" size=5 class="loginfo" style="width: 90px"/> - <input type="text" name="mphone1"
										id="mphone1" size=5 class="loginfo"style="width: 90px"/> - <input type="text" name="mphone2"
										id="mphone2" size=5 class="loginfo"style="width: 90px"/><br></td>
								</tr>
								<tr>
									<td class="sub_subject" align="left"><span style="color: red;"> * </span> 이메일</td>
									</tr>
									<tr>
									<td align="left"><input type="text" name="memail0" id="memail0" size=10
										onfocus="this.values=';'" class="loginfo" style="width: 130px;"/><span style="font-size: 21px"> @ </span><input type="text"
										name="memail1" id="memail1" value="" size="10" readonly class="loginfo" style="width: 130px;"/> <select
										name="memail" id="memail" onchange="emailCheck()" class="btn">
											<option value="0">선택하세요</option>
											<option value="9">직접입력</option>
											<option>naver.com</option>
											<option>gmail.com</option>
									</select></td>
								</tr>
								<tr>
									<td class="sub_subject" align="left">주 소(도로명주소)</td>
									</tr>
									<tr>
									<td align="left"><input type="text" name="maddr0"
										id="maddr0"class="loginfo" /> <input type="button" value="주소검색"
										onclick="addrCheck()" class="btn"/><br> <input type="text"
										name="maddr1" id="maddr1" readonly="readonly" class="loginfo"/><br>
										상세주소<br> <input type="text" name="maddr2" id="maddr2" class="loginfo"/>
								</tr>
							
								<tr>
									<td colspan="2" align="left" class="sub_subject"><input type="checkbox"
										name="chk" id="chk" class="chk" /> 약관동의</td>
								</tr>
								<tr>
									<td align="center"> 
									<input type="submit" value="[ 등 록 ]" onclick="vali()" class="loginbtn" /></td>
									</tr>
									<tr>
									<td align="center">
									<input type="reset"  value="[ 다시입력 ]" class="loginbtn" /> </td>
								</tr>

							</table>
							
						</form>
						<div class="main_go">
					<a href="/spw/index.spw">메인화면으로</a>
					</div>
					</div> <!-- end of login_form-->
				</div>
				<!-- end of login_contents  -->
			</div>
			<!-- end of dd -->
		</div>
		<!-- end of login_box -->
	</div>
	<!-- end of login wrapper -->
</body>
</html>
