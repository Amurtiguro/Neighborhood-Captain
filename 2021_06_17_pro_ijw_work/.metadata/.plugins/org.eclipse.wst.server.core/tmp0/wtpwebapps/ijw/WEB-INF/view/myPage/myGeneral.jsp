<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ijw.general.vo.GeneralVO" %>
<%@ page import="com.ijw.member.vo.MemberVO" %>
<%
	request.setAttribute("siteTitle", "마이 페이지");
%>
<%
	// 사자, 판다 리스트.
	Object obj = request.getAttribute("generalList");
	List<GeneralVO> list = (List<GeneralVO>)obj;
	System.out.println("list : "+list);
	// 현재 로그인한 vo값.
	Object objMvo = request.getAttribute("mvo");
	MemberVO mvo = (MemberVO)objMvo;
	String mid = mvo.getMid();
%>

<%@include file="/WEB-INF/view/main/top1.jsp" %>
<link rel="stylesheet" href="./include/css/myPage.css">
<link rel="stylesheet" href="./include/css/mypagetable.css">
<script type="text/javascript">
	$(document).ready(function(){
		// 회원 수정 버튼.
		$('#myUpdate').click(function(){
			//console.log("수정버튼 실행 : ");
			$('#myPageForm').attr('action','/ijw/myInfo.ijw');
			$('#myPageForm').submit();
		});
		var urls="/ijw/myNotice.ijw";
		var datas;
		$.ajax({
			url:urls,
			type:"GET",
			data:datas,
			success:whenSuccess,
			error:whenError
		});
		function whenSuccess(res){
			console.log("success");
			console.log(res);
			$('.notice_list').html(res);
		}
		function whenError(res){
			console.log("error");
			console.log(res);
		}
		// 삭제.
		$('#delGeneral').click(function(){
			var chkBox = document.getElementsByName("chkgnum");
			var gsort = document.getElementById('chkgsort').value;
			console.log("del gsort : "+gsort);
			var cbCnt = 0;
			var gnum;
			for(var i=0;i<chkBox.length;i++){
				
				if(chkBox[i].checked==true){
					console.log(chkBox[i].value);
					gnum = chkBox[i].value;
					cbCnt++;
				}
				
			}
			document.getElementById("gnum").setAttribute("value",gnum);
			document.getElementById("gsort").setAttribute("value",gsort);
			if(cbCnt==0){
				alert("체크박스를 선택하세요.");
			}else{
				var pick = confirm("삭제하시겠습니까?");
				if(pick==true){
					console.log("삭제");
					console.log("gnum : "+gnum);
					console.log("gsort : "+gsort);
					document.myPageForm.action="/ijw/myGeneralDel.ijw?gnum="+gnum+"&gsort="+gsort;
					document.myPageForm.submit();
				}
				
			}
		});
		// DatePicker Format.
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
	/* 날짜검색 */
	function searchDate(){
		//alert("날짜검색 >>> start  ");
	
		var from=document.getElementById("dateFrom").value;
		console.log("from :: "+from);
		var to=document.getElementById("dateTo").value;
		console.log("to :: "+to);
		var sort = document.getElementById("chkgsort").value;
		console.log("sort :: "+sort);
		var qStr = "gsort="+sort+"&dateFrom="+from+"&dateTo="+to;
		console.log("qStr :: "+qStr);
		location.href="/ijw/myGeneral.ijw?"+qStr;
	}
	// 체크 박스 1개 선택.
	function checkOnly(chk){
		var obj = document.getElementsByName("gnum");
		//console.log(chk.value);
		for (var i = 0; i < obj.length; i++) {
			if(obj[i]!=chk){
				obj[i].checked=false;
			}
			
		}
		
	}
	
</script>
<%@include file="/WEB-INF/view/main/top2.jsp" %>
<!-- 마이페이지.  -->
<div class="mypage_contents">
<h2 align="left">마이페이지</h2>
	<!-- 회원정보.  -->
	<div class="myinfo">
		<div class="myinfo_list">
			<form id="myPageForm" name="myPageForm">
			<%-- <input type="hidden" name="mnum" id="mnum" value="<%=sessionNum %>"/> --%>
			<input type="hidden" name="gsort" id="gsort">
			<input type="hidden" name="gnum" id="gnum">
			<h3>회원정보</h3>
			
			<div class="myinfo_pic">
				<img src="/ijw/include/img/mypage.png">
			</div>
			<br>
			<div class="myinfo_id">
				<span><%=mid %></span><br>
			</div>
			<div class="myinfo_btn">
				<input type="button" name="myUpdate" id="myUpdate" value="회원정보수정" class="sitebtn"/>
			</div>
			</form>
		</div>
		<!-- 알림목록.  -->
		<div class="mynotice_list">
			<h3>알림</h3>
			<hr>
			<div class="notice_list">
				
			</div>
		</div>
	</div>
</div>
<br>
<div class="btn_container">
	<div class="tab_sort tab_saja"><a href="/ijw/myGeneral.ijw?gsort=1">구매</a></div>
	<div class="tab_sort tab_panda"><a href="/ijw/myGeneral.ijw?gsort=2">판매</a></div>
	<div class="tab_sort tab_auction"><a href="/ijw/myAuction.ijw?asort=3">경매</a></div>
	<div class="tab_sort tab_pick"><a href="/ijw/myPick.ijw">찜</a></div>
</div>
<!-- 날짜검색 -->
<div class="search_by_date">
	날짜입력
	<input type="text" id="dateFrom" name="dateFrom" class="sitetxt" size="15">
	~
	<input type="text" id="dateTo" name="dateTo" class="sitetxt" size="15">
	<input type="button" value="조회" name="btnSerachByDate"id="btnSerachByDate" onclick="searchDate()" class="sitebtn">
</div>
<div class="del_btn">
	<input type="button" id="delGeneral" name="delGeneral" value="삭제" class="sitebtn"/>
</div>
<div class="list_contents">
<div class="list_top">
<form name="generalForm" id="generalForm">
<%
	String groupsize = "0";  // 그룹사이즈   
	String pagesize = "0"; 	 // 페이지사이즈 
	String curpage = "0"; 	 // 현재페이지   
	String totalcount = "0"; // 총데이터수

	if(list!=null && list.size()>0){
		//페이징변수 받아오기 
		int cur=Integer.parseInt(list.get(0).getCurpage());
		int total=Integer.parseInt(list.get(0).getTotalcount());
		int size=Integer.parseInt("16");
		//총 페이지 개수(총상품수 / 페이지 크기 )
		int count = (int)Math.ceil(total / (size+0.0));
		String qString="";
		String dateTo=request.getParameter("dateTo");
		String dateFrom=request.getParameter("dateFrom");
		System.out.println("1 :: dateTo :: "+dateTo+", dateFrom :: "+dateFrom);
		
		if(dateTo==null||dateFrom==null||dateTo==""||dateFrom==""){
			dateTo="";
			dateFrom="";
			System.out.println("2 :: dateTo :: "+dateTo+", dateFrom :: "+dateFrom);
		}else{
			qString="dateTo="+dateTo+"&dateFrom="+dateFrom;
		}
%>
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
			for(int i=0;i<list.size();i++){
				GeneralVO mgvo = (GeneralVO)list.get(i);
				groupsize = mgvo.getGroupsize();
				pagesize = mgvo.getPagesize();
				curpage = mgvo.getCurpage();        // 현재페이지 
				totalcount = mgvo.getTotalcount();  // 총데이터수 
				
				/* System.out.println("groupsize >>> " + groupsize);
				System.out.println("pagesize >>> " + pagesize);
				System.out.println("curpage >>> " + curpage);
				System.out.println("totalcount >>> " + totalcount); */
%>
				<li class="grid_item">
					<a href="/ijw/generalDetailForm.ijw?gnum=<%=mgvo.getGnum()%>">
						<div class="grid_item_box">
							<div class="grid_img">
<%
	// 구분을 통해 사자인지 판다인지.
	String gsort = mgvo.getGsort();	
/* 	System.out.println("gsort : "+gsort);
	System.out.println("gsort=='1' : "+gsort.equals("1")); */
	if(gsort!=null&&gsort.equals("1")){
%>
								<div class="grid_img_label label_saja">
<%	}else{
%>
								<div class="grid_img_label label_panda">
<%}%>
									<input type="checkbox" name="chkgnum" id="chkgnum" value="<%=mgvo.getGnum() %>" onclick="checkOnly(this)">
									<input type="hidden" name="chkgsort" id="chkgsort" value="<%=mgvo.getGsort() %>">
								</div>
								<img src="/ijw/editImages/Thumb_<%=mgvo.getGphoto() %>">
							</div>
							<div class="grid_label">
								<h3 class="grid_title">
									<%=mgvo.getGtitle() %>
								</h3>
								<p class="grid_local">
									<span><%=mgvo.getGloc() %></span>    <!-- 거래지역 -->    
								</p>
								<p class="grid_balance">
									<span><%=mgvo.getGprice() %></span>원
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
			<jsp:include page="myPaging.jsp" flush="true">
			<jsp:param name="url" value="/ijw/myGeneral.ijw"/>
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
		<div align="center">
			등록된 데이터가 존재하지 않습니다.
		</div>
<%
	}
%>

</div>
</div>
<%@include file="/WEB-INF/view/main/bottom.jsp" %>