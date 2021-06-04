

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

	<div class="background_img"></div>
	<div class="login_wrapper">
		<div class="login_box">
			<div class="dd">
				<!-- 
			<div class="login_logo">
				<a href="/spw/index.spw"><img src="/spw/include/img/logo.png"></a>
			</div>
			
		 -->
				<div></div>


				<div class="login_contents">

					<div class="login_form">

						<h2 class="subject">비밀번호찾기</h2>
						<form action="/spw/pwfindOK.spw" method="post">
							<input type="text" name="mid" id="mid" class="loginfo"
								placeholder="아이디"><br> <input type="text"
								name="memail" id="memail" class="loginfo" placeholder="email"><br>
							<input type="submit" value="찾기" class="loginbtn"> <input
								type="reset" value="다시입력" class="loginbtn">
						</form>
					</div> <!-- end of "login_form" -->
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