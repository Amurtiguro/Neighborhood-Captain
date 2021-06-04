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
<link rel="stylesheet" href="/spw/include/css/mainstyle.css">
<link rel="stylesheet" href="/spw/include/css/login.css">
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
				<a href="/spw/index.spw"><img src="/spw/include/img/logo.png"></a>
			</div>
			
		 -->
		 <div>
		 </div>
			
			
			<div class="login_contents">
			
				<div class="login_form">
					
					<form action="loginOK.spw" id="loginform" name="loginform"
						method="post">
						<input type="text" id="mid" name="mid" class="loginfo"
							placeholder="아이디"><br> <input type="password" id="mpw"
							name="mpw" class="loginfo" placeholder="패스워드"><br> <input
							type="submit" value="로그인" class="loginbtn"><br> 
							
							<div class="link_a">
							<a
							href="/spw/idfind.spw" class="findinfo">아이디 찾기 </a> | <a
							href="/spw/pwfind.spw" class="findinfo">비밀번호 찾기</a> | <a
							href="/spw/meminsertform.spw" class="findinfo"> 회원가입</a>
							</div>
							
							<br>
					</form>
					</div>
				</div>
				<%
					String clientId = "_uTefj1dSwrQ5W6tjNPN";//애플리케이션 클라이언트 아이디값";
				String redirectURI = URLEncoder.encode("http://www.sajapanda.com/spw/callback.spw", "UTF-8");// 네이버에 등록한 값 콜백화면으로 가야된다.
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
						src="/spw/include/img/naver.PNG"/></a>
				</div>
				<br>
					<div class="main_go">
					<a href="/spw/index.spw">메인화면으로</a>
					</div>
			</div>
		</div>
	</div>
</body>
</html>