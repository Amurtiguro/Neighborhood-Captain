<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spw.general.vo.GeneralVO" %>
<%@ page import="java.util.List " %>
<%
	request.setAttribute("siteTitle", "사자 목록");
%>
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<script type="text/javascript">
	
	/* 글쓰기 : generalInsertForm */
	function generalInsertForm(){
		//console.log("generalInsertForm 클릭");
		location.href="generalInsertForm.spw";
	}
	
 	/* 상세보기 : generalDetailForm */
	function generalDetailForm(){
		var gnum = $(".chkInNo:checked").val();
		//console.log("gnum >> " + gnum);
		
		$("#sList #gnum").val(gnum);
		$("#sList").attr("action", "generalDetailForm.spw");
		$("#sList").submit();
	}
	
	/* 날짜검색 */
	function searchDate(){
		//console.log("날짜검색 >>> start  ");
	
		var from=document.getElementById("dateFrom").value;
		console.log("from :: "+from);
		var to=document.getElementById("dateTo").value;
		console.log("to :: "+to);
	
		var urls="/spw/generalSList.spw";
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
		    $("#sList div.list_grid").replaceWith($(data).find("#sList div.list_grid"));
		    $("#sList div.list_paging paging_saja").replaceWith($(data).find("#sList div.list_paging paging_saja"));
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
	         //$( "#dateFrom" ).val(date);	         
	
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
	         console.log("to >>>>>>"+date);
	         //$( "#dateTo" ).val(date);
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
<%
	String groupsize = "0";  // 그룹사이즈   
	String pagesize = "0"; 	 // 페이지사이즈 
	String curpage = "0"; 	 // 현재페이지   
	String totalcount = "0"; // 총데이터수
	
	// Controller에서 setAttribute 세팅 값 sList 받아온다.
	Object obj = request.getAttribute("sList");
	List<GeneralVO> sList = (List)obj;
%>
	<!-- 상품리스트(그리드) -->
	<div class="list_contents">
	<div class="list_top">
	<h2 class="list_title">사자 목록</h2>
	
	<!-- 카테고리 -->
	<jsp:include page="/category/list.spw"/>
	<!-- 날짜검색 -->
	<div class="search_by_date">
		날짜입력
		<input type="text" id="dateFrom" name="dateFrom" class="sitetxt" size="15">
		~
		<input type="text" id="dateTo" name="dateTo" class="sitetxt" size="15">
		<input type="button" value="조회" name="btnSerachByDate"id="btnSerachByDate" onclick="searchDate()" class="sitebtn">
	</div>
	<br>
	
	<div class="" align="right">
		<input type="button" value="상품등록" class="sitebtn" onclick="generalInsertForm()" />
	</div>

	<form id="sList" name="sList" method="POST">
<%
	if(sList != null&&sList.size()>0){
	//페이징변수 받아오기 
	int cur=Integer.parseInt(sList.get(0).getCurpage());
	int total=Integer.parseInt(sList.get(0).getTotalcount());
	int size=Integer.parseInt("16");
	//총 페이지 개수(총상품수 / 페이지 크기 )
	int count = (int)Math.ceil(total / (size+0.0));
	
	String qString=request.getParameter("cgnum");
	String dateTo=request.getParameter("dateTo");
	String dateFrom=request.getParameter("dateFrom");
	System.out.println("qString : "+qString);
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
%>
	<!-- 리스트 시작 -->
	<div class="list_grid">
	<!-- 조회된 상품 수 -->
		<div class="grid_row">
			<div class="list_grid_count">
				조회된 상품 수 : <span><%=total%></span>개
			</div>
				<h5> 총 <%=count%>페이지 중 현재 <%=cur%>페이지</h5>
		</div>
		<ul>
<%
			for(int i=0; i<sList.size();i++){
				GeneralVO gvo = sList.get(i);
				
				groupsize = gvo.getGroupsize();
				pagesize = gvo.getPagesize();
				curpage = gvo.getCurpage();        // 현재페이지 
				totalcount = gvo.getTotalcount();  // 총데이터수 
				
				/* System.out.println("groupsize >>> " + groupsize);
				System.out.println("pagesize >>> " + pagesize);
				System.out.println("curpage >>> " + curpage);
				System.out.println("totalcount >>> " + totalcount); */
%>
			<li class="grid_item">
				<a href="/spw/generalDetailForm.spw?gnum=<%=gvo.getGnum()%>">
					<div class="grid_item_box">
						<div class="grid_img">
							<div class="grid_img_label label_saja">
								사자
							</div>
							<img src="/spw/editImages/<%=gvo.getGrephoto() %>">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								<%= gvo.getGtitle() %>               <!-- 제목 --> 
							</h3>
							<p class="grid_local">
								<span><%= gvo.getGloc() %></span>    <!-- 거래지역 -->    
							</p>
							<p class="grid_balance">    
								<span><%= gvo.getGprice() %></span>원  <!-- 가격 --> 
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
		<!-- 페이징 -->
		<div class="list_paging paging_saja">
			<jsp:include page="paging.jsp" flush="true">
			<jsp:param name="url" value="/spw/generalSList.spw"/>
			<jsp:param name="qString" value="<%=qString %>"/>
			<jsp:param name="groupsize"   value="<%=groupsize %>"/>
			<jsp:param name="pagesize"    value="<%=pagesize %>"/>
			<jsp:param name="curpage"     value="<%=curpage %>"/>
			<jsp:param name="totalcount"  value="<%=totalcount %>"/>
			</jsp:include>			
		</div>
		</form>
<%
					
		}else{
%>
		<div class="list_msg">
			<h3>등록된 데이터가 존재하지 않습니다.</h3>
		</div>
<%
		}
%>

	</div>
</div>
	<!-- 하단 바. -->
		<%@ include file="/WEB-INF/view/main/bottom.jsp" %>
	</body>
</html>