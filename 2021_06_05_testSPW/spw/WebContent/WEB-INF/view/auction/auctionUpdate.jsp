<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spw.auction.vo.AuctionVO" %>
<!-- 상단 바. -->
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<title>update view form </title>
<style type="text/css">
span{
	color:red;
	font-size:8px;
}
#apricemin{
	text-align:right;
}
#aendtime{
	text-align:right;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
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
	
	$(document).ready(function(){
		var catNum=$("#category").val();
		$("#cgnum").val(catNum);	
		
		$("#update").click(function(){
			$("#updateForm").attr({
				"method":"POST",
				"enctype":"multipart/form-data",
				"action":"/spw/auctionUpdate.spw"
			}).submit();
		});
		
		//사진 미리보기 
		$("#aphoto").on("change", handleImgFileSelect);
	});
	
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
	
	
</script>
<%@include file="/WEB-INF/view/main/top2.jsp" %>
<div class="formbox formbox_75">
	<h3>상품 수정 페이지</h3>
<%
	Object obj=request.getAttribute("detailVO");
	if(obj!=null){
		AuctionVO auvo=(AuctionVO)obj;
%>
	<div class="formcontent">
		<form id="updateForm" name="updateForm">
		<input type="hidden" id="anum" name="anum" value="<%=auvo.getAnum()%>"/>
			<div class="formrow">
			<label for="otherID1" class="rowlabel">제목</label>
				<input type="text" id="atitle" name="atitle" value="<%=auvo.getAtitle()%>" class="sitetxt form_ele_100">
			</div>
			<div class="formrow">
				<label for="otherID2" class="rowlabel">카테고리</label>
					<input type="hidden" id="category" name="category" value="<%=auvo.getCgnum()%>"/>
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
							<input type="button" id="whereInow" onclick="getLocation()" value="현위치"  class="sitebtn"/>   
							<input type="button" onclick="addrCheck()" value="주소검색" class="sitebtn"/> <br>
						</div>
						<input type="text" id="aloc" name="aloc" value="<%=auvo.getAloc()%>" class="sitetxt form_ele_75"/>
					</div>
			</div>
			<div class="formrow">
				<label for="otherID4" class="rowlabel">사진</label>
				<img src="/spw/uploadImages/<%=auvo.getAphoto() %>" id="image_container" width="200" height="200" class="img_container"></img>
				<input type="file" id="aphoto" name="aphoto" value="<%=auvo.getAphoto()%>"/>
				<input type="hidden" id="aphoto1" name="aphoto1" value="<%=auvo.getAphoto()%>"/> 
			</div>
			<div class="formrow">
				<label for="otherID1" class="rowlabel">시작가</label>
				<input type="text" id="apricemin" name="apricemin" value="<%=auvo.getApricemin()%>" class="sitetxt form_ele_20" onkeyup="inputNumberFormat(this)"/> 원 
			</div>

			<div class="formrow"> 
				<label for="otherID1" class="rowlabel">종료시간</label>
				<input type="text" id="aendtime" name="aendtime" class="sitetxt form_ele_20"/> 시간 
			</div>

			<div class="formrow">
				<label for="otherID1" class="rowlabel">상품설명</label>
				<textArea id="acontents" name="acontents" cols="50" rows="20" placeholder="상품설명 최대 2000자" ><%=auvo.getAcontents()%></textArea>
			</div>
<%
			//세션이  끝났으면 ? 수정 불가능함 
%>			
			<div class="formrow formrow_center">
				<input type="button" id="update" name="update" value="수정" class="sitebtn"/>
			</div>
		</form>
	</div>
</div>

<%	
	}else{
		System.out.println("obj is null");
	}
%>	
</body>
<!-- 하단 바. -->
<%@ include file="/WEB-INF/view/main/bottom.jsp" %>
</html>