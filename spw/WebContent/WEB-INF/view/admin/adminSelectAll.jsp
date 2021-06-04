<%@page import="java.util.ArrayList"%>
<%@page import="com.spw.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ include file="/WEB-INF/view/main/top1.jsp"%>
<link rel="stylesheet" href="/spw/include/css/adminform.css">
<script type="text/javascript">
	function chekOnly(chk){
		console.log(chk.value);
		var obj = document.getElementsByName("chkInMnum");
		for(var i=0; i<obj.length; i++){
			if(obj[i] != chk ){
				obj[i].checked = false;
			}
		}
	}
	function adminDel(){
		document.adminSelectForm.action="/spw/adminDel.spw";
		document.adminSelectForm.submit();
	}
	function searchData(){
		//검색할 아이디를 받아서 vo에 담아서 셀렉트로 가야한다.
		document.adminSelectForm.method="get"
		document.adminSelectForm.action="/spw/adminSelectAll.spw";
		document.adminSelectForm.submit();
	}     
</script>
<%@ include file="/WEB-INF/view/main/top2.jsp"%>
<%
	int pageSize=0;
	int groupSize=0;
	int curPage=0;
	int totalCount=0;
%>
	
	

	<br>
	<br> 
	<div class="list_sort">
    	<div class="tab_sort tab_panda tab_sel">
    		회원 관리
    	</div>
    	<div class="tab_sort tab_saja">
    		<a href="/spw/chartboard.spw">상품등록 현황</a>
    	</div>
    	<div class="tab_sort tab_comment">
    		<a href="/spw/comment/listall.spw">댓글 관리</a>
    	</div>
    </div>
	<br>
	<br> 
	<div>
		<h2 class="list_admin" style="margin-block-start: 0.83em; margin-block-end: 0.83em;       margin: 0.5em 0; font-size: 1.75em; font-weight: bold;">불량회원 관리</h2>
	</div>
	<form id="adminSelectForm" name="adminSelectForm" class="adminSelectForm" method="get" >
	<div class="container">
		<table class="adminSelectTable table_list table_hover" >
		<colgroup>
    	<col width="49px">
    	<col width="125px">
    	<col width="120px">
    	<col width="100px">
    	<col width="70px">
    	<col width="140px">
    	<col width="200px">
    	<col width="120px">
		</colgroup>
		<thead>
		<tr>
			<td colspan="12" align="right">
				<input class="sitetxt" type="text" name="mid" id="mid" placeholder ="검색할  id를 입력하세요">
				<input class="sitebtn" type="button" value="검색"  onclick="searchData()" height="5px">
				<input class="sitebtn"type="button" value="삭제" onclick="adminDel()" height="5px">
			</td>
		</tr>
			<tr>
			<th>선택</th>
				<th>회원번호</th>
				<th>회원아이디</th>
				<th>회원비밀번호</th>
				<th>회원이름</th>
				<th>연락처</th>
				<th>Email</th>
			
				<th>회원등록일</th>
	
			</tr>
			</thead>
			<tbody>
			<%
		
			ArrayList list = (ArrayList) request.getAttribute("list");
			//MemberVO mvo1 =(MemberVO)request.getAttribute("mvo");
			if(list !=null&&list.size()>0){
				
			
			for (int i = 0; i < list.size(); i++) {
				MemberVO mvo = (MemberVO) list.get(i);
				pageSize =Integer.parseInt(mvo.getPageSize());
				groupSize =Integer.parseInt(mvo.getGroupSize());
				curPage =Integer.parseInt(mvo.getCurPage());
				totalCount =Integer.parseInt(mvo.getTotalCount());
			%>
				<tr>
					<td align="center"><input type="checkbox" name="chkInMnum" id="chkInMnum" value=<%=mvo.getMnum() %> onclick="chekOnly(this)"></td>
					<td style="font-size:14px" align="center"><%= mvo.getMnum()%></td>
					<td align="center"><%= mvo.getMid()%></td>
					<td align="center"><%= mvo.getMpw()%></td>
					<td align="center"><%= mvo.getMname()%></td>
					<td align="center"><%= mvo.getMphone()%></td>
					<td align="center"><%= mvo.getMemail()%></td>
					<td align="center"><%= mvo.getMregdate()%></td>
		
				</tr>
				
			<%
				}
			}else{
			%>
					<tr>
					<td colspan="9">검색결과가 없습니다.
					
					</td>
					</tr>				
			<%
			
			}
			%>
			</tbody>
			
		</table>
	</div>
	<% if(list !=null&&list.size()>0){
	%>
	<div class="admin_paging list_paging" style="    text-align: center;    font-size: 1.2em;    padding: 0.5em 0;"> 
	<jsp:include page="paging.jsp" flush="true">
			<jsp:param name="url" value="/spw/adminSelectAll.spw"/>
			<jsp:param name="pageSize" value="<%=pageSize%>"/>
			<jsp:param name="groupSize" value="<%=groupSize%>"/>
			<jsp:param name="curPage" value="<%=curPage%>"/>
			<jsp:param name="totalCount" value="<%=totalCount%>"/>
	</jsp:include>
	</div>

		<%
		}else{
			
		}
	%>

</form>
<%@ include file="/WEB-INF/view/main/bottom.jsp"%>