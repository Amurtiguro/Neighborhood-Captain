<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<link rel="stylesheet" href="/ijw/include/css/mainstyle.css">
<link rel="stylesheet" href="/ijw/include/css/login.css">
<script type="text/javascript">
	
</script>

</head>
<body>
 
     <div class="background_img">
     
     </div>
	<div class="login_wrapper">
		<div class="login_box">
			<div class="dd">
			<!-- 
			<div class="login_logo">
				<a href="/ijw/index.ijw"><img src="/ijw/include/img/logo.png"></a>
			</div>
			
		 -->
		 <div>
		 </div>
			
			
			<div class="login_contents">
			
				<div class="login_form">
					
					<form action="loginOK.ijw" id="loginform" name="loginform"
						method="post">
						<input type="text" id="mid" name="mid" class="loginfo"
							placeholder="아이디"><br> <input type="password" id="mpw"
							name="mpw" class="loginfo" placeholder="패스워드"><br> <input
							type="submit" value="로그인" class="loginbtn"><br> 
							
							<div class="link_a">
							<a
							href="/ijw/idfind.ijw" class="findinfo">아이디 찾기 </a> | <a
							href="/ijw/pwfind.ijw" class="findinfo">비밀번호 찾기</a> | <a
							href="/ijw/meminsertform.ijw" class="findinfo"> 회원가입</a>
							</div>
							
							<br>
					</form>
					</div>
				</div>
				<%
					String clientId = "mwmVcx684HiSH3eR8sUY";//애플리케이션 클라이언트 아이디값";
				String redirectURI = URLEncoder.encode("http://localhost:8088/ijw/callback.ijw", "UTF-8");// 네이버에 등록한 값 콜백화면으로 가야된다.
				SecureRandom random = new SecureRandom();
				String state = new BigInteger(130, random).toString();
				String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
				apiURL += "&client_id=" + clientId;
				apiURL += "&redirect_uri=" + redirectURI;
				apiURL += "&state=" + state;
				session.setAttribute("state", state);
				%>
				<div class="naver_btn">
					<a href="<%=apiURL%>">
				<!-- <img height="50"
						src="http://static.nid.naver.com/oauth/small_g_in.PNG" /></a> -->	
					<img height="60" width="300"
						src="/ijw/include/img/naver.PNG"/></a>
				</div>
				<br>
					<div class="main_go">
					<a href="/ijw/index.ijw">메인화면으로</a>
					</div>
			</div>
		</div>
	</div>
</body>
</html>