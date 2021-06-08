<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="com.spw.notice.vo.NoticeVO" %>
<%
	System.out.println("<myNotice>");
	Object obj = request.getAttribute("myNoticeList");
	List<NoticeVO> list = (List<NoticeVO>)obj;
%>
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		console.log("jQuery 실행 : ");
		
	});
	function Home(){
		document.noticeForm.method="POST";
		document.noticeForm.action="/spw/myPage.spw";
		document.noticeForm.submit();
	}
</script>

<div class="notice_contents" align="center">
<form name="noticeForm" id="noticeForm"> 
	<div class="notice_list">
		<ul>
	<%
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				NoticeVO mnvo = (NoticeVO)list.get(i);
	
	%>
				<li>
					<a href="<%=mnvo.getNurl() %>">
					<%=mnvo.getNsenddate() %>
					<%-- <%=mnvo.getNmnum() %> --%>
					<%=mnvo.getMid() %> 님이
<%
					String phone = mnvo.getNinfo();
					if(phone.indexOf("-")>0){
%>
						(<%=phone %>)
<%
					}else{
						int gprice = Integer.parseInt(phone);
						String price=""; 
						price= NumberFormat.getInstance().format(gprice);
%>
						(<%=price %>)
<%
					}
					String nsort= mnvo.getNsort();
					String sortStr=null;
					if(nsort.equals("1")&&nsort!=null){
						sortStr="거래신청하셨습니다.";
					}
					if(nsort.equals("2")&&nsort!=null){
						sortStr="원으로 낙찰하셨습니다.";
					}
					if(nsort.equals("3")&&nsort!=null){
						sortStr="입찰자가없습니다.";
					}
					if(nsort.equals("4")&&nsort!=null){
						sortStr="원으로 낙찰성공.";
					}
%>
					<%=sortStr %>
					</a>
				</li>
	<%
			}
		}
	%>
		</ul>
	</div>
</form>
</div>
