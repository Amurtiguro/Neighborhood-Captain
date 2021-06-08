<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ page import="com.spw.general.vo.GeneralVO" %>
<%@ page import="com.spw.general.dao.GeneralDaoImpl" %>
<%@ page import="java.util.List " %>

<% 
	String mnum = "M202007300001";
	String mid = "admin";
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사자, 판다 페이지</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	
	/* 글쓰기 : generalInsertForm */
	function generalInsertForm(){
		console.log("generalInsertForm 클릭");
		location.href="generalInsertForm.spw";
	}
	
	/* 상세보기 : generalDetailForm */
	function generalDetailForm(){
		var gnum = $(".chkInNo:checked").val();
		console.log("gnum >> " + gnum);
		
		$("#aList #gnum").val(gnum);
		$("#aList").attr("action", "generalDetailForm.spw");
		$("#aList").submit();
	} 
	
	/* 사자목록 : generalSList */
	function generalSList(){
		console.log("사자목록 : generalSList");
		location.href="generalSList.spw";
	}
	
	
	/* 판다목록 : generalPList */
	function generalPList(){
		console.log("판다목록 : generalPList")
		location.href="generalPList.spw";
	}
	
	
	/* 데이트피커 : datePicker*/
	var rangeDate = 31;  // 최대 범위 (한달)
	var setSdate;        // 시작일
	var detEdate;        // 종료일
	
	$(function(){
		$("#from").datepicker({
			dateFormat: 'yyyy/mm/dd',
		    minDate: 0,
		    onSelect: function(selectDate){
		        var stxt = selectDate.split("/");
		            stxt[1] = stxt[1] - 1;
		        var sdate = new Date(stxt[0], stxt[1], stxt[2]);
		        var edate = new Date(stxt[0], stxt[1], stxt[2]);
		            edate.setDate(sdate.getDate() + rangeDate);
		            
	            $('#to').datepicker('option', {
	                minDate: selectDate,
	                beforeShow : function () {
	                    $("#to").datepicker( "option", "maxDate", edate );
	                    setSdate = selectDate;
	                    console.log("setSdate : " + setSdate);
	            }});
		    }
		});
		
		
		$("#to").datepicker({
			dateFormat: 'yyyy/mm/dd',
		    onSelect : function(selectDate){
	        setEdate = selectDate;
	        console.log("setEdate : " + setEdate);
		    }
		});
		
		$(".btn").on('click', function(e){
			if($('input#from').value()==''){
				alert("시작일을 선택해주세요");
				$('input#from').focus();
				return false;
			}
		})
		
	});
	
</script>
</head>
<body>

<p>날짜검색 : <input type="text" name="from" id="from" > -
<input type="text" name="to" id="to" > 
<input type="button" name="dateSearch" id="dateSearch" value = "검색" > </p> 


<%
	String groupsize = "5";  // 그룹사이즈    --여기서 세팅
	String pagesize = "3"; 	 // 페이지사이즈  --여기서 세팅
	String curpage = "0"; 	 // 현재페이지    --db돌아 온 값
	String totalcount = "0"; // 총데이터수    --db돌아 온 값
	
	
	// Controller에서 setAttribute 세팅 값 aList을 받아온다.
	Object obj = request.getAttribute("aList");
	List<GeneralVO> aList = (List)obj;
	
	GeneralVO _gvo = new GeneralVO();
	System.out.println("jsp 페이지 >>> " );
	System.out.println("groupsize >>> " + groupsize);
    System.out.println("pagesize >>> " + pagesize);
    System.out.println("curpage >>> " + _gvo.getCurpage());
    System.out.println("totalcount >>> " + _gvo.getTotalcount());
	
	/* for(int i=0; i<aList.size();i++){
		GeneralVO _gvo = (GeneralVO)aList.get(i);
		
	    groupsize = _gvo.getGroupsize();
	    pagesize = _gvo.getPagesize();
	    curpage = _gvo.getCurpage();
	    totalcount = _gvo.getTotalcount();
	    
	    System.out.println("jsp 페이지 >>> " );
	    System.out.println("groupsize >>> " + groupsize);
	    System.out.println("pagesize >>> " + pagesize);
	    System.out.println("curpage >>> " + curpage);
	    System.out.println("totalcount >>> " + totalcount);
	}
	 */
	 
	if(obj != null){
			
%>

	<form id="aList" name="aList" method="POST">
		<input type="hidden" name="gnum" id="gnum"/>
	</form>

	<div>
		<table border="0">
			<tr>
				<th><h4>전체 리스트</h4></th>
			</tr>		
		</table>
	</div>
		
	<!-- 리스트 시작 -->
	<div>
		<tr>
			<td align="left">
			<input type="button" value="사자 목록" onclick="generalSList()" />
			<input type="button" value="판다 목록" onclick="generalPList()" /></td>
		</tr>
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th><input type="checkbox" name="chkALL" id="chkALL"></th>
					<th>회원번호</th>
					<th>카테고리 코드</th>
					<th>일반 상품번호</th>
					<th>구분</th>
					<th>제목</th>
					<th>거래지역</th>
					<th>법정동코드</th>
					<th>사진</th>
					<th>썸네일</th>
					<th>가격</th>
					<th>설명</th>
					<th>상태</th>
					<th>삭제여부</th>
					<th>등록일</th>
					<th>수정일</th>
				</tr>
			</thead>

		<tbody>
			
<%
	for(int i=0; i<aList.size();i++){
		GeneralVO gvo = aList.get(i);
		
		curpage = gvo.getCurpage();
		totalcount = gvo.getTotalcount();
		
		/*
		System.out.println("groupsize >>> " + groupsize);
		System.out.println("pagesize >>> " + pagesize);
		System.out.println("curpage >>> " + curpage);
		System.out.println("totalcount >>> " + totalcount);
		*/
%>
			
			<tr align="center">
				<td><input type="checkbox" name="chkInNo" class="chkInNo"
				value="<%= gvo.getGnum() %>" onclick="checkOnly(this)"></td>
				
				<td> <%= gvo.getMnum() %></td>        <!-- 회원번호 -->    
				<td> <%= gvo.getCgnum() %></td>       <!-- 카테고리 코드 --> 
				<td> <%= gvo.getGnum() %></td>        <!-- 일반 상품번호 --> 
				<td> <%= gvo.getGsort() %></td>       <!-- 구분  -->     
				<td> <%= gvo.getGtitle() %></td>      <!-- 제목 -->      
				<td> <%= gvo.getGloc() %></td>        <!-- 거래지역 -->    
				<td> <%= gvo.getGregcode() %></td>    <!-- 법정동코드 -->    
				<td><img src="/spw/uploadImages/<%=gvo.getGphoto() %>" border=0 width="100" ></td><!-- 사진 -->
				<td><img src="/spw/editImages/Thumb_<%=gvo.getGphoto() %>" border=0 width="50" ></td><!-- 썸네일 -->   
				<td> <%= gvo.getGprice() %></td>      <!-- 가격 -->      
				<td> <%= gvo.getGcontents() %></td>   <!-- 설명 -->      
				<td> <%= gvo.getGstatus() %></td>     <!-- 상태 -->      
				<td> <%= gvo.getGdelyn() %></td>      <!-- 삭제여부 -->    
				<td> <%= gvo.getGregdate() %></td>    <!-- 등록일 -->     
				<td> <%= gvo.getGupdate() %></td>     <!-- 수정일 -->   
			</tr>
			
<%
			}//end of for 
	
		}else{
%>
		<tr>
			<td colspan="5" align="center">등록된 데이터가 존재하지 않습니다.</td>
		</tr>
<%
	}//end of if
%>			
			<tr>
				<td colspan ="15" align="left">
				<input type="button" value="글쓰기" onclick="generalInsertForm()" />
				<input type="button" value="상세보기" onclick="generalDetailForm()" /></td>
			</tr>
			
			<tr>
				<td colspan = "15" align="right">
					<jsp:include page="paging.jsp" flush="true">
						<jsp:param name="url" value="/spw/generalAllList.spw"/>
						<jsp:param name="str" value=""/>
						<jsp:param name="groupsize"  value="<%=groupsize %>"/>
						<jsp:param name="pagesize"   value="<%=pagesize %>"/>
						<jsp:param name="curpage"    value="<%=curpage %>"/>
						<jsp:param name="totalcount"    value="<%=totalcount %>"/>
					</jsp:include>
				</td>
			</tr>
			
			</tbody>
		</table>
	</div>
</body>
</html>