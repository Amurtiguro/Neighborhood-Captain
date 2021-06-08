<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=ege"/>
<meta name="viewport" content="user-scalable=no,inital-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,width=device-width">
<title>:: Custom Login Demo - Kakao JavaScript SDK ::</title>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function() {
        // @details 카카오톡 Developer API 사이트에서 발급받은 JavaScript Key
        Kakao.init( "8f4a74f4ffe2c74546040096c342e074" );
        // @breif 카카오 로그인 버튼을 생성합니다.
        Kakao.Auth.createLoginButton({
              container : "#kakao-login-btn",
              success : function( authObj ) {
              // console.log( authObj );
              Kakao.API.request({
                      url : "/v2/user/me",
                      success : function( res ) {
                        // console.log( res );
                        // @breif 아이디
                        document.getElementById( "kakaoIdentity" ).innerHTML = res.id;
                        // @breif 닉네임
                        document.getElementById( "kakaoNickName" ).innerHTML = res.properties.nickname;
                        // @breif 프로필 이미지
                        document.getElementById( "kakaoProfileImg" ).src = res.properties.profile_image;
                        // @breif 썸네일 이미지
                        document.getElementById( "kakaoThumbnailImg" ).src = res.properties.thumbnail_image;
                    }, 
                    fail : function( error ) {
                        alert( JSON.stringify( error ) );
                    }
                });
            }
            , fail : function( error ) {
                alert( JSON.stringify( error ));
            }
        });
    });
</script>
</head>
<body>
    <div>카카오 아이디 : <span id="kakaoIdentity"></span></div>
    <div>닉네임 : <span id="kakaoNickName"></span></div>
    <div>프로필 이미지 : <img id="kakaoProfileImg" src=""/></div>
    <div>썸네일 이미지 : <img id="kakaoThumbnailImg" src=""/></div>
    <br/>
    <a id="kakao-login-btn"></a>
</body>
</html> 