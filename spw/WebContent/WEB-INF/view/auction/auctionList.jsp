 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.spw.auction.vo.AuctionVO" %>
<%
	request.setAttribute("siteTitle", "경매 목록");
%>
<!-- 상단 바. -->
<%@include file="/WEB-INF/view/main/top1.jsp" %>

<%
	System.out.println("목록 페이지 세션 회원번호 : "+sessionNum);
%>
<link rel="stylesheet" href="./include/css/mainstyle.css">
<script type="text/javascript" src="/spw/include/js/autciontList.js"></script>
<script type="text/javascript">
	
	function auctionInsert(){
		console.log("insert btn click >>> ");
		document.detailForm.method="GET";
		document.detailForm.action="/spw/auctionWrite.spw";
		document.detailForm.submit();
	}
	
	function detailAuction(){
		console.log("detail auction btn click >>> ");
		document.detailForm.method="GET";
		document.detailForm.action="/spw/auctionViewDetail.spw";
		document.detailForm.submit();
	}
	
	
	function searchDate(){
		console.log("날짜검색 >>> start  ");
	
		var from=document.getElementById("dateFrom").value;
		console.log("from :: "+from);
		var to=document.getElementById("dateTo").value;
		console.log("to :: "+to);

		var urls="/spw/auctionList.spw";
		//var formData=$("form[name=detailForm]").serialize();
		var formData={
						dateFrom:from,
						dateTo:to, }
		
		if(from!=null&&from!=''&&to!=null&&to!=''){
			console.log("from/to 값 모두 입력 했음 ");
			$.ajax({
				type : "get",
				url:urls,
				data : formData,
				success: whenSuccess,
				error: whenError
			});
		}else{
			console.log("from/ to 둘다 입력 하세요!");
		}
		//성공했을 때
		function whenSuccess(data){
			console.log(" ajax 성공 !!!! ");
			//console.log(data);
		    $("#detailForm div.list_grid").replaceWith($(data).find("#detailForm div.list_grid"));
		    $("#detailForm div.list_paging paging_saja").replaceWith($(data).find("#detailForm div.list_paging paging_saja"));
		}
		//실패했을 때
		function whenError(){
			console.log("데이터 없음 !! ");
		}
		
	}
	
	$(document).ready(function(){
		 var dateFormat = "yy/mm/dd",
	     
		 from = $( "#dateFrom" )
	        .datepicker({
	          defaultDate: "+1w",
	          changeMonth: true,
	          numberOfMonths: 1,
	          dateFormat: dateFormat
	        })
	        .on( "change", 
	        		function() {
	          to.datepicker( "option", "minDate", getDate( this ) );
	         
	         var date= $.datepicker.formatDate('yy/mm/dd', new Date(getDate(this)));
	         console.log("from >>>>>>"+date);
	        }),
	        
	      to = $( "#dateTo" ).datepicker({
	        defaultDate: "+1w",
	        changeMonth: true,
	        numberOfMonths: 1,
	        dateFormat: dateFormat
	      })
	      .on( "change", function() {
	        from.datepicker( "option", "maxDate", getDate( this ) );
	        
	        var date= $.datepicker.formatDate('yy/mm/dd', new Date(getDate(this)));
	      });
	 
	    function getDate( element ) {
	      var date;
	      try {
	        date = $.datepicker.parseDate( dateFormat, element.value );
	      } catch( error ) {
	        date = null;
	        console.log(error);
	      }
	 
	      return date;
	    }
	});
	
</script>
<%@include file="/WEB-INF/view/main/top2.jsp" %>
<!-- 상품리스트(그리드) -->
<div class="list_contents">
	<div class="list_top">
		<h2 class="list_title">경매 목록</h2>
		
		<!-- 카테고리 -->
		<jsp:include page="/category/list.spw"/>

		<div class="search_by_date">
			날짜입력 <input type="text" name="dateFrom" id="dateFrom" size="15" value="" class="sitetxt"/> ~
			<input type="text" name="dateTo" id="dateTo" size="15" value="" class="sitetxt"/> 
			<input type="button" name="dateSearch" id="dateSearch" onclick="searchDate()"value="조회" class="sitebtn"/> 
		</div> 
		<br> 
		<div class="" align="right">
			<input type="button" value="상품등록" onclick="auctionInsert()" class="sitebtn"/>
		</div>
	</div> 
		
	<form name="detailForm" id="detailForm"> 
	
<%
	Object obj=request.getAttribute("auctionList");
	System.out.println("auctionList : "+obj);
	List<AuctionVO> alist=(List<AuctionVO>)obj;
	System.out.println("alist : "+alist);
	if(alist!=null&&alist.size()>0){
		System.out.println("alist size >>> "+alist.size());
	//페이징변수 받아오기 
	int curpage=Integer.parseInt(alist.get(0).getCurpage());
	int totalcount=Integer.parseInt(alist.get(0).getTotalcount());
	int pagesize=Integer.parseInt("16");

	//총 페이지 개수(총상품수 / 페이지 크기 )
	int pageCount = (int)Math.ceil(totalcount / (pagesize+0.0));
	System.out.println("페이지 크키는 >>> "+pageCount);
	
	String qString=request.getParameter("cgnum");
	String dateTo=request.getParameter("dateTo");
	String dateFrom=request.getParameter("dateFrom");
	System.out.println("1 :: dateTo :: "+dateTo+", dateFrom :: "+dateFrom);
	
	//카테고리, 날짜 검색 쿼리스트링 설정
	if(qString == null){
		qString = "";
	}else{
		qString = "cgnum=" + qString;
	}
	if(dateTo==null||dateFrom==null||dateTo==""||dateFrom==""){
		dateTo="";
		dateFrom="";
		System.out.println("2 :: dateTo :: "+dateTo+", dateFrom :: "+dateFrom);
	}else{
		qString="dateTo="+dateTo+"&dateFrom="+dateFrom;
	}

	String aTitle = request.getParameter("atitle");
	if(aTitle != null && aTitle.length() > 0){

		if(qString.length() > 0){
			qString = qString + "&";
		}

		qString = qString + "atitle=" + aTitle;
	}
%>

		<div class="list_grid">

			<div class="grid_row">
				<div class="list_grid_count">
					조회된 상품 수 : <span><%=totalcount%></span>개
				</div>
				<h5> 총 <%=pageCount%>페이지 중 현재 <%=curpage%>페이지</h5>
			</div>
			<ul>
<%

				for(int i=0;i<alist.size();i++){
%>
				<li class="grid_item">
					<a href="/spw/auctionViewDetail.spw?anum=<%=alist.get(i).getAnum() %>">
						<div class="grid_item_box">
							<div class="grid_img">
								<div class="grid_img_label label_auction">
									경매
								</div>
								<img src="/spw/editImages/<%=alist.get(i).getArephoto()%>" width="192"/>
							</div>
							<div class="grid_label">
								<h3 class="grid_title">
									<%=alist.get(i).getAtitle() %>
								</h3>
								<p class="grid_local">
									<span><%=alist.get(i).getAloc() %></span>
								</p>
								<p class="grid_balance">
									현재 최고가 <span><%=alist.get(i).getBidhighprice()%></span>원
								</p>
							</div>
						</div>
					</a>
				</li>
<%
				}	
%>
			</ul>
		</div>

		<div class="list_paging paging_saja">
			<jsp:include page="auctionPaging.jsp">
				<jsp:param value="<%=qString%>" name="qString"/>
				<jsp:param value="<%=curpage%>" name="curpage"/>
				<jsp:param value="<%=totalcount%>" name="totalcount"/>
			</jsp:include>
		</div>
	</form>
<%
			}else{
				System.out.println("데이터 없음");
%>
		<div class="list_msg">
			<h3>등록된 데이터가 존재하지 않습니다.</h3>
		</div>
<%
			}
%>
</div>
<!-- 하단 바. -->
<%@ include file="/WEB-INF/view/main/bottom.jsp" %>	