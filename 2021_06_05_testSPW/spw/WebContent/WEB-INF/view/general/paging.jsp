<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String url=null;
	String qString=null;
	
	url=request.getParameter("url");
	qString=request.getParameter("qString");

	System.out.println("url : "+url);
	System.out.println("qString : "+qString);
	if(qString != null){
		qString=qString+"&";
	}//end of if
	
	int pagesize=0;   
	int groupsize=0;  
	int curpage=0;    
	int totalcount=0; 
	int pageCount=0;  
	
	/* String gupdate=request.getParameter("gupdate"); */
	
	if(request.getParameter("groupsize") !=null){
		groupsize=Integer.parseInt(request.getParameter("groupsize"));
	}
	
	if(request.getParameter("pagesize") !=null){
		pagesize=Integer.parseInt(request.getParameter("pagesize"));
	}
	
	if(request.getParameter("totalcount") !=null){
		totalcount=Integer.parseInt(request.getParameter("totalcount"));
	}
	
	if(request.getParameter("curpage") !=null){
		curpage=Integer.parseInt(request.getParameter("curpage"));
	}
	
	pageCount=(int)Math.ceil(totalcount/(pagesize+0.0));
	//System.out.println("pageCount==>>"+pageCount);
	
	int curGroup=(curpage-1)/groupsize;
	int linkPage=curGroup*groupsize;
	
	/* System.out.println("groupsize==>>"+groupsize);
	System.out.println("totalcount==>>"+totalcount);
	System.out.println("curpage==>>"+curpage);
	System.out.println("pageCount==>>"+pageCount);
	System.out.println("curGroup==>>"+curGroup);
	System.out.println("linkPage==>>"+linkPage); */
	
%>
<p align="right">
<%
	//System.out.println("curGroup_1==>>"+curGroup);
	if(curGroup >0){
%>
	<span class="sitebtn"><a href="<%=url%>?<%=qString%>curpage=1">◁◁</a></span>
	<span class="sitebtn"><a href="<%=url%>?<%=qString%>curpage=<%=linkPage%>">◀</a></span>
<%		
	}else{
%>
		<span class="sitebtn">◁◁</span>
		<span class="sitebtn">◀</span>
<%	
	}//end of if-else
		
	linkPage++;
	//System.out.println("linkPage_1==>>"+linkPage);
	
	int loopCount =groupsize;
	//System.out.println("loopCount_1==>>"+loopCount);
	
	//System.out.println(loopCount +" >0   && "+ linkPage+ " <= "+ pageCount);
	while(loopCount >0 && linkPage <= pageCount){
		if(linkPage == curpage){
		//System.out.println("linkPage==>"+linkPage);
%>
		<span class="sitebtn paging_selected"><%=linkPage %></span>
<%
		}else{
		//System.out.println("linkPage==>"+linkPage);
%>
		<a href="<%=url%>?<%=qString%>curpage=<%=linkPage%>" class="sitebtn"><%=linkPage%></a>
<%			
		}//end of if-else
			
		linkPage++;
		loopCount--;
		//System.out.println(">>>"+linkPage+" : "+loopCount);
	}//end of while
		
	//System.out.println("<<<>>>"+linkPage+" <= "+pageCount);	
	if(linkPage <=pageCount){
		//System.out.println("linkPage==>"+linkPage);
		//System.out.println("pageCount==>"+pageCount);
%>
		<span class="sitebtn"><a href="<%=url%>?<%=qString%>curpage=<%=linkPage%>">▶</a></span>
		<span class="sitebtn"><a href="<%=url%>?<%=qString%>curpage=<%=pageCount%>">▷▷</a></span>
<%		
	}else{
%>
		<span class="sitebtn">▶</span>
		<span class="sitebtn">▷▷</span>
<%			
	}//end of if-else	
		
%>
