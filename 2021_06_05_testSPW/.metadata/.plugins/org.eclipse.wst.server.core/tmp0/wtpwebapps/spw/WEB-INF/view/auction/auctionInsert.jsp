<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상단 바. -->
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<%
   request.setAttribute("siteTtitle","경매 상품 등록 페이지 ");
   System.out.println("작성 페이지 세션 회원번호 : "+sessionNum);
%>
<style type="text/css">
#apricemin{
   text-align:right;
}
#aendtime{
   text-align:right;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://unpkg.com/vue/dist/vue.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9b4172322671d1cc9e49a261f3c75475&libraries=services"></script>
<script type="text/javascript">
   
   var sel_file=null;
   var geocoder = new kakao.maps.services.Geocoder();
   
   $(document).ready(function(){
      var mnumber = "<%=sessionNum%>";
      
      //사진 미리보기 
      $("#aphoto").on("change", handleImgFileSelect);
      
      //등록버튼 클릭
      $("#insert").click(function(){
         //유효성 검사 
         var flag=true;
         var arrVal=new Array(7);
         
         arrVal[0]=$("#atitle").val().length;
         arrVal[1]=$("#cgnum option").index( $("#cgnum option:selected") );
         arrVal[2]=$("#aloc").val().length;
         arrVal[3]=$("#aphoto").val().length;
         arrVal[4]=$("#apricemin").val().length;
         arrVal[5]=$("#aendtime").val().length;
         arrVal[6]=$("#acontents").val().length;
         
         //미입력한 항목이 있을 시 유효성 flag에 false 세팅
         for(var i=0;i<arrVal.length;i++){
            var a=arrVal[i];
            console.log(i+"번째 value :: "+a);
            if(a==0)
               flag=false;
         }
         
         if(flag){
            $("#insertAuction").attr({
               "method":"POST",
               "enctype":"multipart/form-data",
               "action":"/spw/auctionInsert.spw"
            }).submit();
         }else{
            alert("다시 작성하세요 !! ")
         }
      });
      
   }); //end of docuemnt 
   
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
   
   //첨부파일 유효성 검사
   function handleImgFileSelect(e){
      
      var files=e.target.files;
      var filesArr=Array.prototype.slice.call(files);
      var flag=true;
      filesArr.forEach(function(f){
         if(!f.type.match("image.*")){
            console.log("f >>>> "+f);
            alert("확장자는 이미지 확장자만 가능");
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
   
   //주소검색 다음 api
   function addrCheck(){
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
               
               var address=data.sido+" "+data.sigungu+" "+data.bname+" "+data.bname1;
               
               document.insertAuction.aloc.value = address;
               console.log(">>> "+address);
            }   
         }).open({
            left: (window.screen.width / 2) - (width / 2),
            top: (window.screen.height / 2) - (height / 2),
         });                  
      });            
   }
   
   
   //현위치 주소 찾기 geoloaction api 
   function getLocation(){
      var va1=null;
      var va2=null;
      
      if (navigator.geolocation) {
         console.log("navigator.geoloaction :: "+navigator.geolocation);
         //watchposition :: 장치의 위치가 바뀔 때마다, 자동으로 새로운 위치를 사용해 호출할 처리기 함수를 등록
         navigator.geolocation.watchPosition(showPosition);
         console.log("check >>>> ");
      } else {
         alert("geolocation이 지원되지 않는 브라우저 입니다.");
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
               document.insertAuction.aloc.value = result[0].address_name;
            }
         };
         
         geocoder.coord2RegionCode(val1, val2, callback);
      }
   }
   
</script>
<!-- 상단 바. -->
<%@include file="/WEB-INF/view/main/top2.jsp" %>
<div class="formbox formbox_75">
   <h3>상품 등록</h3>
   <!-- 탭 -->
   <div class="formtab">
      <div class="tabbtn tabbtn_3 tabsaja">
         <a href="/spw/generalInsertForm.spw">사자</a>
      </div>
      <div class="tabbtn tabbtn_3 tabpanda">
         <a href="/spw/generalInsertForm.spw?gsort=2">판다</a>
      </div>
      <div class="tabbtn tabbtn_3 tabauction tabbtn_sel">
         <a href="/spw/auctionWrite.spw">경매</a>
      </div>
      
   </div>
   
   <!-- 폼 -->
   <div class="formcontent">
      <form id="insertAuction" name="insertAuction" method="POST">
            <input type="hidden" id="mnum" name="mnum" value=<%=sessionNum%>>
         <div class="formrow">
            <label for="otherID1" class="rowlabel">제목</label>
            <input type="text" id="atitle" name="atitle" placeholder="최대 40자" class="sitetxt form_ele_100">
         </div>
         <div class="formrow">
            <label for="otherID2" class="rowlabel">카테고리</label>
               <select name="cgnum" id="cgnum" class="siteselect form_ele_50"> 
                  <option> 대분류 </option>
                  <option value="CG01"> 패션잡화 </option>
                  <option value="CG02"> 여성의류 </option>
                  <option value="CG03"> 남성의류 </option>
                  <option value="CG04"> 디지털/가전 </option>
                  <option value="CG05"> 도서 </option>
                  <option value="CG06"> 생활 </option>
                  <option value="CG07"> 유아동 </option>
                  <option value="CG08"> 스포츠 </option>
                  <option value="CG09"> 뷰티 </option>
                  <option value="CG10"> 기타 </option>
               </select> 
         </div>
         <div class="formrow">
            <label for="otherID3" class="rowlabel">거래지역</label>
               <div class="form_ele_100">
                  <div class="form_ele_100">
                     <input type="button" id="whereInow" onclick="getLocation()" value="현위치" class="sitebtn"/> 
                     <input type="button" onclick="addrCheck()" value="주소검색" class="sitebtn"/>
                  </div>
                  <input type="text" id="aloc" name="aloc" placeholder="주소" class="sitetxt form_ele_75"/>
               </div>
         </div>
         <div class="formrow">
            <label for="otherID4" class="rowlabel">사진</label>
			<div class="form_ele_100">
				<img id="image_container" width="200" height="200" class="img_container"></img> 
				<input type="file" id="aphoto" name="aphoto"/>
			</div>
         </div>
         <div class="formrow">
            <label for="otherID1" class="rowlabel">시작가</label>
            <input type="text" id="apricemin" name="apricemin" class="sitetxt form_ele_50" onkeyup="inputNumberFormat(this)"/><span class="form_ele_onechar">원</span> 
         </div>

         <div class="formrow">
            <label for="otherID1" class="rowlabel">종료시간</label>
            <input type="text" id="aendtime" name="aendtime" class="sitetxt form_ele_50"/><span class="form_ele_onechar">시간</span> 
         </div>

         <div class="formrow">
            <label for="otherID1" class="rowlabel">상품설명</label>
            <textArea id="acontents" name="acontents" class="sitetxt form_ele_100" cols="50" rows="20" placeholder="상품설명 최대 2000자" ></textArea> 
         </div>
<%
         //세션이  끝났으면 ? 수정 불가능함 
%>         
         <div class="formrow formrow_center">
            <input type="button" id="insert" name="insert" value="작성" class="sitebtn"/>
            <input type="reset" value="다시쓰기" class="sitebtn"/>
         </div>
      </form>
   </div>
</div>

<!-- 하단 바. -->
<%@ include file="/WEB-INF/view/main/bottom.jsp" %>
</body>
</html>