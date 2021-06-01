<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.spw.mypage.vo.MyPickVO" %>
<%@ page import="com.spw.member.vo.MemberVO" %>
<%
	request.setAttribute("siteTitle", "마이 페이지");
%>
<%
	// 찜.
	Object obj = request.getAttribute("pickList");
	List<MyPickVO> list = (List<MyPickVO>)obj;
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
			$('#myPageForm').attr('action','/spw/myInfo.spw');
			$('#myPageForm').submit();
		});
		var urls="/spw/myNotice.spw";
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
		$('#delPick').click(function(){
			var chkBox = document.getElementsByName("chkpnum");
			var gsort = document.getElementById('chkgsort').value;
			console.log("del gsort : "+gsort);
			var cbCnt = 0;
			var pnum;
			for(var i=0;i<chkBox.length;i++){
				
				if(chkBox[i].checked==true){
					//console.log(chkBox[i].value);
					pnum=chkBox[i].value;
					cbCnt++;
				}
				
			}
			document.getElementById("pnum").setAttribute("value",pnum);
			document.getElementById("gsort").setAttribute("value",gsort);
			if(cbCnt==0){
				alert("체크박스를 선택하세요.");
			}else{
				var pick = confirm("삭제하시겠습니까?");
				if(pick==true){
					console.log("삭제");
					location.href="/spw/myPickDel.spw?pnum="+pnum+"&gsort="+gsort;
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
		var qStr = "&dateFrom="+from+"&dateTo="+to;
		console.log("qStr :: "+qStr);
		location.href="/spw/myPick.spw?"+qStr;
	}	
	// 체크 박스 1개 선택.
	function checkOnly(chk){
		var obj = document.getElementsByName("pnum");
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
			<input type="hidden" name="pnum" id="pnum">
			<input type="hidden" name="gsort" id="gsort">
			<h3>회원정보</h3>
			
			<div class="myinfo_pic">
				<img src="/spw/include/img/mypage.png">
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
	<div class="tab_sort tab_saja"><a href="/spw/myGeneral.spw?gsort=1">사자</a></div>
	<div class="tab_sort tab_panda"><a href="/spw/myGeneral.spw?gsort=2">판다</a></div>
	<div class="tab_sort tab_auction"><a href="/spw/myAuction.spw?asort=3">경매</a></div>
	<div class="tab_sort tab_pick"><a href="/spw/myPick.spw">찜</a></div>
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
	<input type="button" id="delPick" name="delPick" value="삭제" class="sitebtn"/>
</div>
<div class="list_contents">
<div class="list_top">
<form name="pickForm" id="pickForm"> 
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
			MyPickVO mpvo = (MyPickVO)list.get(i);
			groupsize = mpvo.getGroupsize();
			pagesize = mpvo.getPagesize();
			curpage = mpvo.getCurpage();        // 현재페이지 
			totalcount = mpvo.getTotalcount();  // 총데이터수 
			
			/* System.out.println("groupsize >>> " + groupsize);
			System.out.println("pagesize >>> " + pagesize);
			System.out.println("curpage >>> " + curpage);
			System.out.println("totalcount >>> " + totalcount); */
%>
			<li class="grid_item">
				<a href="/spw/generalDetailForm.spw?gnum=<%=mpvo.getGnum()%>">
					<div class="grid_item_box">
						<div class="grid_img">
							<div class="grid_img_label label_pick">
								<input type="checkbox" name="chkpnum" id="chkpnum" value=<%=mpvo.getPnum() %> onclick="checkOnly(this)">
								<input type="hidden" name="chkgsort" id="chkgsort" value="<%=mpvo.getGsort() %>">
							</div>
							<img src="/spw/editImages/Thumb_<%=mpvo.getGphoto() %>">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								<%=mpvo.getGtitle() %>
							</h3>
							<p class="grid_local">
								<span><%=mpvo.getGloc() %></span>    <!-- 거래지역 -->    
							</p>
							<p class="grid_balance">
								<span><%=mpvo.getGprice() %></span>원
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
		<jsp:param name="url" value="/spw/myPick.spw"/>
		<jsp:param name="qString" value=""/>
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