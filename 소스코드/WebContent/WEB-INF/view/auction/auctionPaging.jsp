<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿼리스트링
	String qString = "";
	
	Object obj = request.getParameter("qString");
	if(obj != null){
		qString = (String)obj;
	}
	
	if(qString != null && qString.length() > 0){
		qString = qString + "&";
	}

	String	url = null;
	url = "auctionList.spw";

	//페이징 데이터 받아오기
	int totalcount= Integer.parseInt(request.getParameter("totalcount"));
	int curPage= Integer.parseInt(request.getParameter("curpage"));
	int pagesize=16;
	int groupsize=5;
	int pageCount = 0;
	pageCount = (int)Math.ceil(totalcount / (pagesize+0.0));

	System.out.println("===================paging jsp===================");
	System.out.println("qString >> "+qString);
	System.out.println("totalcount >>> "+totalcount);
	System.out.println("curPage >>> "+curPage);
	System.out.println("pagesize >>> "+pagesize);
	System.out.println("groupsize >>> "+groupsize);
	System.out.println("pageCount >>> "+pageCount);
	System.out.println("===================paging jsp===================");
	
	int curGroup = (curPage-1) / groupsize;
	
	int linkPage = curGroup * groupsize;
%>
	<p align="right">
<%
	if(curGroup > 0) {
%>
	<span class="sitebtn"><a href="<%=url%>?<%=qString %>curpage=1">◁◁</a></span>
	<!-- 이전 그룹으로 이동  -->
	<span class="sitebtn"><a href="<%=url%>?<%=qString %>curpage=<%=linkPage%>">◀</a><span class="sitebtn">
<%
	}else{
%>
<!-- 현재 그룹 사이즈가 0이면 이전 값 없음  -->
<span class="sitebtn">◁◁</span>
<span class="sitebtn">◀</span>
<%
	}

	linkPage++;
	int loopCount = groupsize;
	while((loopCount > 0) && (linkPage <= pageCount)){
		//현재페이지랑 
		if(linkPage == curPage){
%>
	<span class="sitebtn paging_selected"><%=linkPage%></span>
<%
		}else{
%>

	<a href="<%=url%>?<%=qString%>curpage=<%=linkPage%>" class="sitebtn"><%=linkPage%></a>
<%
		}
		linkPage++;
		loopCount--;
	}
	
	// 다음그룹이 있는 경우
	if(linkPage <= pageCount){
%>
	<span class="sitebtn"><a href="<%=url%>?<%=qString %>curpage=<%=linkPage%>">▶</a></span>
	<span class="sitebtn"><a href="<%=url%>?<%=qString %>curpage=<%=pageCount%>">▷▷</a></span>
<%
	}else{
%>
	<span class="sitebtn">▶</span>
	<span class="sitebtn">▷▷</span>
<%
	}
%>

</p>
