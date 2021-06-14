<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ page import="com.spw.general.vo.GeneralVO" %>
<%@ page import="java.util.ArrayList " %>
<%@ page import="java.util.List " %>

<%
	request.setAttribute("siteTitle", "상세보기");
%>

<%@include file="/WEB-INF/view/main/top1.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		/* 거래신청 */
		$('.deal-btn').click(function(){
			//alert("gd");
	    	var mnum = "<%=sessionNum%>";
	    	//alert(mnum);
	       	//alert(mnum.length);
	    	if(mnum!=null&&mnum.length>4){
	    		var $id = $(this).attr('id');
		        var id = '#'+$id+'Layer';
		        //alert(id);
		        layer_popup(id);
	    	}else{
	    		alert("로그인하세요.");
	    	}
	    });
		
		// 레이어팝업 생성.
	    function layer_popup(el){
	        var $el = $(el);        //레이어의 id를 $el 변수에 저장
	        // prev() - 이전요소를 선택하도록 반환. 
	        // hasClass() - 클래스가 있냐 없냐?
       		//dimmed 레이어를 감지하기 위한 boolean 변수
	        var isDim = $el.prev().hasClass('dimBg');
	        
	        //alert(isDim);
	        // true 일경우 .dim-layer을 페이드인 아닐경우 $el을 페이드인.
	        // 링크를 페이드인 하거나 아님 클래스를 페이드인.
	        isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();
	        
	        var $elWidth = ~~($el.outerWidth()),
	            $elHeight = ~~($el.outerHeight()),
	            docWidth = $(document).width(), 
	            docHeight = $(document).height();
			//alert($elWidth);
			//alert($elHeight);
			
	        // 화면의 중앙에 레이어를 띄운다.
	        if ($elHeight < docHeight || $elWidth < docWidth) {
	            $el.css({
	                marginTop: -$elHeight /2,
	                marginLeft: -$elWidth/2
	            })
	        } else {
	            $el.css({top: 0, left: 0});
	        }

	        $el.find('.btn-layerClose').click(function(){
	            isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
	            return false;
	        });

	        $('.layer .dimBg').click(function(){
	            $('.dim-layer').fadeOut();
	            return false;
	        });

	    }
	    // 거래 전송버튼.
	    $('#dealFunc').click(function(){
	    	//alert("전송");
		    $("#detailList").attr("action", "/spw/dealInsert.spw");	    		
			$("#detailList").submit();	    		
	    });
	   
	    // 찜하기.
	    $('#pick').click(function(){
	    	//alert("찜하기");
	    	var mnum = "<%=sessionNum%>";
	    	if(mnum!=null&&mnum.length>4){
	    		var gnum = $("#gnum").val();
	    	 	$("#detailList").attr("action", "/spw/myPick.spw?gnum"+gnum);
				$("#detailList").submit();
	    	}else{
	    		alert("로그인하세요.");
	    	}
	    });
	});
	/*	수정 클릭 : generalUpdateForm */
	function generalUpdateForm(){
		var gnum = $("#gnum").val();
		//alert("gnum >> " + gnum);
		
		$("#gnum").val(gnum);
		$("#detailList").attr("action", "generalUpdateForm.spw");
		$("#detailList").submit();
		
	} 
	
	/* 삭제 클릭 : generalDeleteOK */
	function generalDeleteOK(){
		//alert("generalDeleteOK : 삭제 함수 시작");
		console.log("generalDeleteOK : 삭제 함수 시작");
		$("#detailList").attr("action", "generalDeleteOK.spw");
		$("#detailList").submit();
	}
	
	/* 취소 클릭 : cancel() */
	function cancel(){
		//alert("cancel : 목록으로")
		console.log("cancel : 취소 함수 시작")
		history.back();
		/* location.href="generalAllList.spw"; */
		
	}
	
	
</script>
<%@include file="/WEB-INF/view/main/top2.jsp" %>
<body>

<%
	// Controller에서 setAttribute 세팅 값을 받아온다.
	Object obj = request.getAttribute("detailDate");
	System.out.println("obj >> " + obj);
	if(obj != null){
			GeneralVO gvo = (GeneralVO)obj;
			String gsort = gvo.getGsort();
%>
<form id="detailList" name="detailList" method="POST" >
<div class="product_detail">
	<div class="product_top">
		<h2 class="product_title">
			<%=gvo.getGtitle() %>
		</h2>
		<div class="product_info_mini">
			<%-- <span class="product_status">
				<%=gvo.getGstatus() %>
			</span> --%>
			<span class="product_writer">
				아이디 : <%=gvo.getMid() %> 
			</span>
			<span class="product_date">
				(<%=gvo.getGregdate() %>)
			</span>
		</div>
		<!-- 이미지 -->
		<!-- product_info_images의 style와 내부의 img태그의 src에 동일한 이미지 경로 입력 -->
		<div class="product_info_images" style="background-image: url('/spw/uploadImages/<%=gvo.getGphoto()%>');" alt="상품 이미지">
			<img src="/spw/uploadImages/<%=gvo.getGphoto() %>">
		</div>
		<div class="product_info_side">
<%
			if(gsort.equals("1")){
%>
				<div class="product_sort_label label_saja">구매</div>
<%
			}else{
%>
				<div class="product_sort_label label_panda">판매</div>
<%
			}
%>
			<div class="product_info_detail">
				<p>카테고리 : <span><%=gvo.getCgname() %></span></p>
				<p>거래지역 : <span><%=gvo.getGloc() %></span></p>
<%
				String status = gvo.getGstatus();
				String str="";
				if(status.equals("1")){
					str="거래중";
				}
				if(status.equals("2")){
					str="거래완료";
				}
				if(status.equals("3")){
					str="거래취소";
				}
%>
				<p>거래상태 : <span><%=str %></span></p>
			</div>
			<div class="product_info_bottom">
				<div class="product_info_price">
					<span><%=gvo.getGprice() %></span>원
				</div>
				<div class="product_action">
					<a id="deal" class="sitebtn label_default deal-btn">거래신청</a>
					<a id="pick" class="sitebtn">찜하기</a>
				</div>
			</div>
		</div>
	</div>
	<div class="product_content">
		<h4>상세 설명</h4>
		<div class="product_content_txt">
			<%=gvo.getGcontents() %>
		</div>
			<div class="product_content_btn">	
<%
		String mnum = gvo.getMnum();

		String url;
		if(gsort.equals("1")){
			url="/spw/generalSList.spw";
		}else{
			url="/spw/generalPList.spw";
		}
		if(mnum.equals(sessionNum)){
%>
				<a href="/spw/generalUpdateForm.spw?gnum=<%=gvo.getGnum() %>" class="sitebtn">수정</a>
				<a href="/spw/generalDeleteOK.spw?gnum=<%=gvo.getGnum() %>&gsort=<%=gvo.getGsort() %>" class="sitebtn">삭제</a>
				<a href="<%=url %>" class="sitebtn">목록</a>
<%
		}else{
%>
				<a href="<%=url %>" class="sitebtn">목록</a>		
<%
		}
%>
		</div>
	</div>
</div>
<div class="dim-layer">
    <div class="dimBg"></div>
    <div id="dealLayer" class="pop-layer">
        <div class="pop-container">
            <div class="pop-conts">
                <!--content //-->
                <h3>거래신청 - 전화번호입력란</h3>
                <div class="phoneForm">
                	전화번호 : <input type="text" name="phone0" id="phone0" size="3"/>-
                			 <input type="text" name="phone1" id="phone1" size="4"/>-
                			 <input type="text" name="phone2" id="phone2" size="4"/>
                </div>

                <div class="btn-r"> 
                	<input type="hidden" name="mnum" id="mnum" value="<%=gvo.getMnum() %>">
                	<input type="hidden" name="gnum" id="gnum" value="<%=gvo.getGnum() %>">
                	<input type="submit" name="dealFunc" id="dealFunc" value="전송"/>
                	<input type="button" class="btn-layerClose" value="취소"/>
                    <a href="#" class="btn-layerClose">Close</a>
                </div>
                <!--// content-->
            </div>
        </div>
    </div>
</div>	
<%	
	}
%>
		
	</form>
	<%-- 댓글 --%>
	<jsp:include page="/comment/list.spw">
		<jsp:param value="${param.gnum}" name="cpnum"/>
	</jsp:include>
	
<%@ include file="/WEB-INF/view/main/bottom.jsp" %>
</body>
</html>