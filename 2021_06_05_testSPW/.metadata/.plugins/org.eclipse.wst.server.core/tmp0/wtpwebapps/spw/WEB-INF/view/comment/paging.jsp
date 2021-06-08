<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String p_url = request.getParameter("url");
	String p_qStr = request.getParameter("qStr");
	String p_curpage = request.getParameter("curpage");
	String p_groupsize = request.getParameter("groupsize");
	String p_pagesize = request.getParameter("pagesize");
	String p_totalcount = request.getParameter("totalcount");

	// URL
	String url = "";
	if(p_url != null && p_url.length() > 0){
		url = p_url;
	}

	// 쿼리스트링
	String qStr = "";
	if(p_qStr != null && p_qStr.length() > 0){
		qStr = p_qStr + "&";
	}

	int curpage = 1;
	int groupsize = 0;
	int pagesize = 0;
	int totalcount = 0;

	// 현재 페이지
	if(p_curpage != null && p_curpage.length() > 0){
		try{
			curpage = Integer.parseInt(p_curpage);
		}catch(NumberFormatException e){}
	}

	// 그룹 사이즈
	if(p_groupsize != null && p_groupsize.length() > 0){
		try{
			groupsize = Integer.parseInt(p_groupsize);
		}catch(NumberFormatException e){}
	}

	// 페이지 사이즈
	if(p_pagesize != null && p_pagesize.length() > 0){
		try{
			pagesize = Integer.parseInt(p_pagesize);
		}catch(NumberFormatException e){}
	}

	// 글 수
	if(p_totalcount != null && p_totalcount.length() > 0){
		try{
			totalcount = Integer.parseInt(p_totalcount);
		}catch(NumberFormatException e){}
	}

	System.out.println("[i] curpage    -> " + curpage);
	System.out.println("[i] groupsize  -> " + groupsize);
	System.out.println("[i] pagesize   -> " + pagesize);
	System.out.println("[i] totalcount -> " + totalcount);

	// 페이지 개수
	int pagecount = (int)Math.ceil(totalcount / (double)pagesize);

	// 그룹시작점
	int groupstart = (curpage / groupsize) * groupsize + 1;

	if(pagecount > 0){
		// 1 페이지로, 이전그룹으로
		if(groupstart > 1){
%>
	<a href="/spw/<%=url%>?<%=qStr%>curpage=1" class="sitebtn">◁◁</a>
	<a href="/spw/<%=url%>?<%=qStr%>curpage=<%=(groupstart - groupsize)%>" class="sitebtn">◀</a>
<%
		}else{
%>
	<span class="sitebtn">◁◁</span>
	<span class="sitebtn">◀</span>
<%
		}

		// 1, 2, 3, ...

		for(int i = 0; i < groupsize; i++){
			int pageNum = groupstart + i;
	
			if(pageNum > pagecount){
				break;
			}
	
			if(pageNum == curpage){
%>
	<span class="sitebtn paging_selected"><%=pageNum%></span>
<%
			}else{
%>
	<a href="/spw/<%=url%>?<%=qStr%>curpage=<%=pageNum%>" class="sitebtn"><%=pageNum%></a>
<%
			
			}
		}

		// 다음그룹으로, 마지막 페이지로
		if(groupstart < (pagecount - groupsize)){
%>
	<a href="/spw/<%=url%>?<%=qStr%>curpage=<%=(groupstart + groupsize)%>" class="sitebtn">▶</a>
	<a href="/spw/<%=url%>?<%=qStr%>curpage=<%=pagecount%>" class="sitebtn">▷▷</a>
<%
		}else{
%>
	<span class="sitebtn">▶</span>
	<span class="sitebtn">▷▷</span>
<%
		}
		
	}
%>