/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.64
 * Generated at: 2021-06-05 08:03:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.spw.member.vo.MemberVO;
import java.util.List;
import javax.servlet.http.HttpSession;

public final class adminSelectAll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/view/main/top2.jsp", Long.valueOf(1622109146243L));
    _jspx_dependants.put("/WEB-INF/view/main/top1.jsp", Long.valueOf(1621935771264L));
    _jspx_dependants.put("/WEB-INF/view/main/bottom.jsp", Long.valueOf(1621935771214L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("javax.servlet.http.HttpSession");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("com.spw.member.vo.MemberVO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');

	// 타이틀 설정
	String siteTitle = "사자판다";

	String siteTitleParam = (String)request.getAttribute("siteTitle");

	if(siteTitleParam != null && siteTitleParam.length() > 0){
		siteTitle = siteTitleParam;
	}
	HttpSession hs =request.getSession();
	String sessionNum = (String)hs.getAttribute("mnum");
	//System.out.println("세션 회원번호 : "+sessionNum);

      out.write("\n");
      out.write("<!-- 버튼, 메뉴, 하단바, 검색창 색상은 아직 안정해짐 -->\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<title>");
      out.print(siteTitle );
      out.write("</title>\n");
      out.write("<link rel=\"shortcut icon\" href=\"/spw/include/img/favicon.ico\">\n");
      out.write("<link rel=\"icon\" href=\"/spw/include/img/favicon.ico\">\n");
      out.write("<script type=\"text/javascript\" src=\"/spw/include/js/jquery-1.12.0.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"/spw/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.css\">\n");
      out.write("<script src=\"/spw/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.js\"></script>\n");
      out.write("<script src=\"/spw/calendar_datepicker/jquery-ui-1.12.1/datepicker-ko.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"/spw/include/css/dimlayer.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/spw/include/css/mainbaner.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/spw/include/css/login.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/spw/include/css/mainstyle.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"/spw/include/css/memberinsert.css\">\n");
      out.write("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"/spw/include/css/adminform.css\">\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction chekOnly(chk){\n");
      out.write("\t\tconsole.log(chk.value);\n");
      out.write("\t\tvar obj = document.getElementsByName(\"chkInMnum\");\n");
      out.write("\t\tfor(var i=0; i<obj.length; i++){\n");
      out.write("\t\t\tif(obj[i] != chk ){\n");
      out.write("\t\t\t\tobj[i].checked = false;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\tfunction adminDel(){\n");
      out.write("\t\tdocument.adminSelectForm.action=\"/spw/adminDel.spw\";\n");
      out.write("\t\tdocument.adminSelectForm.submit();\n");
      out.write("\t}\n");
      out.write("\tfunction searchData(){\n");
      out.write("\t\t//검색할 아이디를 받아서 vo에 담아서 셀렉트로 가야한다.\n");
      out.write("\t\tdocument.adminSelectForm.method=\"get\"\n");
      out.write("\t\tdocument.adminSelectForm.action=\"/spw/adminSelectAll.spw\";\n");
      out.write("\t\tdocument.adminSelectForm.submit();\n");
      out.write("\t}     \n");
      out.write("</script>\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- 상단바와 내용 -->\r\n");
      out.write("<div id=\"sitearea\">\r\n");
      out.write("\t<!-- 상단바 -->\r\n");
      out.write("\t<header id=\"topbar\">\r\n");
      out.write("\t\t<div class=\"wrapper\">\r\n");
      out.write("\t\t\t<!-- 상단바 로고영역(로고, 검색) -->\r\n");
      out.write("\t\t\t<div id=\"logoarea\">\r\n");
      out.write("\t\t\t\t<!-- 로고 -->\r\n");
      out.write("\t\t\t\t<div id=\"toplogo\">\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/index.spw\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/spw/include/img/logo.png\" id=\"sitelogo\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"mobilebtns\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"◎\" class=\"sitebtn\" id=\"btnSearchBar\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"●\" class=\"sitebtn\" id=\"btnBtnArea\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"▤\" class=\"sitebtn\" id=\"btnNaviArea\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- 검색바 -->\r\n");
      out.write("\t\t\t\t<div id=\"searchbar\">\r\n");

	String topSearchText = "";
	String topAtitle = request.getParameter("atitle");
	String topGtitle = request.getParameter("gtitle");

	if(topGtitle != null && topGtitle.length() > 0){
		topSearchText = topGtitle;
	}else if(topAtitle != null && topAtitle.length() > 0){
		topSearchText = topAtitle;
	}

      out.write("\r\n");
      out.write("\t<form method=\"GET\" id=\"topSearchform\">\r\n");
      out.write("\t\t<!-- 드롭다운 -->\r\n");
      out.write("\t\t<select id=\"topSearchsel\">\r\n");
      out.write("\t\t\t<option value=\"1\">사자</option>\r\n");
      out.write("\t\t\t<option value=\"2\">판다</option>\r\n");
      out.write("\t\t\t<option value=\"3\">경매</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t<!-- 텍스트필드 -->\r\n");
      out.write("\t\t<div id=\"searchtext\">\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"topSearchtxt\" value=\"");
      out.print(topSearchText );
      out.write("\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 검색버튼 -->\r\n");
      out.write("\t\t<input type=\"submit\" value=\"검색\" id=\"searchbtn\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t$(\"form#topSearchform\").submit(function(){\r\n");
      out.write("\t\t\t\t// 폼\r\n");
      out.write("\t\t\t\tvar topSearchform = $(\"form#topSearchform\")\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// 셀렉트\r\n");
      out.write("\t\t\t\tvar topSearchSel = $(\"#topSearchsel\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// 텍스트\r\n");
      out.write("\t\t\t\tvar topSearchtxt = $(\"#topSearchtxt\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif(topSearchtxt.val() != null && topSearchtxt.val() != \"\"){\r\n");
      out.write("\t\t\t\t\t// 셀렉트 내용\r\n");
      out.write("\t\t\t\t\tvar selectVal = topSearchSel.val();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif(selectVal == \"3\"){\r\n");
      out.write("\t\t\t\t\t\t// 경매\r\n");
      out.write("\t\t\t\t\t\t// 텍스트필드 name속성 지정\r\n");
      out.write("\t\t\t\t\t\ttopSearchtxt.attr(\"name\", \"atitle\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t// 경로지정\r\n");
      out.write("\t\t\t\t\t\ttopSearchform.attr(\"action\", \"/spw/auctionList.spw\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t// 전송\r\n");
      out.write("\t\t\t\t\t\ttopSearchform.submit();\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t// 텍스트필드 name속성 지정\r\n");
      out.write("\t\t\t\t\t\ttopSearchtxt.attr(\"name\", \"gtitle\");\r\n");
      out.write("\t\t\t\t\t\tif(selectVal == \"1\"){\r\n");
      out.write("\t\t\t\t\t\t\t// 사자\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t// 경로지정\r\n");
      out.write("\t\t\t\t\t\t\ttopSearchform.attr(\"action\", \"/spw/generalSList.spw\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t// 전송\r\n");
      out.write("\t\t\t\t\t\t\ttopSearchform.submit();\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}else if(selectVal == \"2\"){\r\n");
      out.write("\t\t\t\t\t\t\t// 판다\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t// 경로지정\r\n");
      out.write("\t\t\t\t\t\t\ttopSearchform.attr(\"action\", \"/spw/generalPList.spw\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t// 전송\r\n");
      out.write("\t\t\t\t\t\t\ttopSearchform.submit();\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\talert(\"검색어를 입력해 주세요\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t$(\"#btnSearchBar\").click(function(){\r\n");
      out.write("\t\t\t\tif($(\"#searchbar\").css(\"display\") == \"none\"){\r\n");
      out.write("\t\t\t\t\t$(\"#btnarea\").slideUp(100);\r\n");
      out.write("\t\t\t\t\t$(\"#naviarea\").slideUp(100);\r\n");
      out.write("\t\t\t\t\t$(\"#searchbar\").slideDown(200);\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$(\"#searchbar\").slideUp(200);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#btnBtnArea\").click(function(){\r\n");
      out.write("\t\t\t\tif($(\"#btnarea\").css(\"display\") == \"none\"){\r\n");
      out.write("\t\t\t\t\t$(\"#searchbar\").slideUp(100);\r\n");
      out.write("\t\t\t\t\t$(\"#naviarea\").slideUp(100);\r\n");
      out.write("\t\t\t\t\t$(\"#btnarea\").slideDown(200);\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$(\"#btnarea\").slideUp(200);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$(\"#btnNaviArea\").click(function(){\r\n");
      out.write("\t\t\t\tif($(\"#naviarea\").css(\"display\") == \"none\"){\r\n");
      out.write("\t\t\t\t\t$(\"#searchbar\").slideUp(100);\r\n");
      out.write("\t\t\t\t\t$(\"#btnarea\").slideUp(100);\r\n");
      out.write("\t\t\t\t\t$(\"#naviarea\").slideDown(200);\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$(\"#naviarea\").slideUp(200);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"btnarea\">\r\n");

	HttpSession hs2 =request.getSession();
	String sessionNum2 = (String)hs2.getAttribute("mnum");
	System.out.println("세션 회원번호 : "+sessionNum2);

      out.write('\r');
      out.write('\n');
				
					
				String admin="M202007300001";
				if(sessionNum2!=null&&sessionNum2.length()>0){
					if(admin.equals(sessionNum2)){

      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/spw/logout.spw\" class=\"sitebtn\">로그아웃</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/spw/adminSelectAll.spw\" class=\"sitebtn\">관리자페이지</a> \r\n");
					
					}else{

      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/spw/logout.spw\" class=\"sitebtn\">로그아웃</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/spw/myPage.spw\" class=\"sitebtn\">마이페이지</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/spw/generalInsertForm.spw\" class=\"sitebtn\">글쓰기</a>\r\n");
					
					}
				}else{

      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/loginform.spw\" class=\"sitebtn\">로그인</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/meminsertform.spw\" class=\"sitebtn\">회원가입</a>\r\n");

				}

      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 메뉴 -->\r\n");
      out.write("\t\t<div id=\"naviarea\">\r\n");
      out.write("\t\t\t<ul class=\"wrapper\">\r\n");
      out.write("\t\t\t\t<!-- 메뉴버튼들 -->\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/generalSList.spw\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\r\n");
      out.write("\t\t\t\t\t\t\t사자\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/generalPList.spw\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\r\n");
      out.write("\t\t\t\t\t\t\t판다\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/local.spw\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\r\n");
      out.write("\t\t\t\t\t\t\t동네\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/auctionList.spw\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\r\n");
      out.write("\t\t\t\t\t\t\t경매\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<!-- 내용 -->\r\n");
      out.write(" \t<div id=\"sitecontent\">\r\n");
      out.write("\t\t<div class=\"wrapper\">\r\n");
      out.write('\n');

	int pageSize=0;
	int groupSize=0;
	int curPage=0;
	int totalCount=0;

      out.write("\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t<br>\n");
      out.write("\t<br> \n");
      out.write("\t<div class=\"list_sort\">\n");
      out.write("    \t<div class=\"tab_sort tab_panda tab_sel\">\n");
      out.write("    \t\t회원 관리\n");
      out.write("    \t</div>\n");
      out.write("    \t<div class=\"tab_sort tab_saja\">\n");
      out.write("    \t\t<a href=\"/spw/chartboard.spw\">상품등록 현황</a>\n");
      out.write("    \t</div>\n");
      out.write("    \t<div class=\"tab_sort tab_comment\">\n");
      out.write("    \t\t<a href=\"/spw/comment/listall.spw\">댓글 관리</a>\n");
      out.write("    \t</div>\n");
      out.write("    </div>\n");
      out.write("\t<br>\n");
      out.write("\t<br> \n");
      out.write("\t<div>\n");
      out.write("\t\t<h2 class=\"list_admin\" style=\"margin-block-start: 0.83em; margin-block-end: 0.83em;       margin: 0.5em 0; font-size: 1.75em; font-weight: bold;\">불량회원 관리</h2>\n");
      out.write("\t</div>\n");
      out.write("\t<form id=\"adminSelectForm\" name=\"adminSelectForm\" class=\"adminSelectForm\" method=\"get\" >\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<table class=\"adminSelectTable table_list table_hover\" >\n");
      out.write("\t\t<colgroup>\n");
      out.write("    \t<col width=\"49px\">\n");
      out.write("    \t<col width=\"125px\">\n");
      out.write("    \t<col width=\"120px\">\n");
      out.write("    \t<col width=\"100px\">\n");
      out.write("    \t<col width=\"70px\">\n");
      out.write("    \t<col width=\"140px\">\n");
      out.write("    \t<col width=\"200px\">\n");
      out.write("    \t<col width=\"120px\">\n");
      out.write("\t\t</colgroup>\n");
      out.write("\t\t<thead>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td colspan=\"12\" align=\"right\">\n");
      out.write("\t\t\t\t<input class=\"sitetxt\" type=\"text\" name=\"mid\" id=\"mid\" placeholder =\"검색할  id를 입력하세요\">\n");
      out.write("\t\t\t\t<input class=\"sitebtn\" type=\"button\" value=\"검색\"  onclick=\"searchData()\" height=\"5px\">\n");
      out.write("\t\t\t\t<input class=\"sitebtn\"type=\"button\" value=\"삭제\" onclick=\"adminDel()\" height=\"5px\">\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t<th>선택</th>\n");
      out.write("\t\t\t\t<th>회원번호</th>\n");
      out.write("\t\t\t\t<th>회원아이디</th>\n");
      out.write("\t\t\t\t<th>회원비밀번호</th>\n");
      out.write("\t\t\t\t<th>회원이름</th>\n");
      out.write("\t\t\t\t<th>연락처</th>\n");
      out.write("\t\t\t\t<th>Email</th>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<th>회원등록일</th>\n");
      out.write("\t\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t</thead>\n");
      out.write("\t\t\t<tbody>\n");
      out.write("\t\t\t");

		
			ArrayList list = (ArrayList) request.getAttribute("list");
			//MemberVO mvo1 =(MemberVO)request.getAttribute("mvo");
			if(list !=null&&list.size()>0){
				
			
			for (int i = 0; i < list.size(); i++) {
				MemberVO mvo = (MemberVO) list.get(i);
				pageSize =Integer.parseInt(mvo.getPageSize());
				groupSize =Integer.parseInt(mvo.getGroupSize());
				curPage =Integer.parseInt(mvo.getCurPage());
				totalCount =Integer.parseInt(mvo.getTotalCount());
			
      out.write("\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"center\"><input type=\"checkbox\" name=\"chkInMnum\" id=\"chkInMnum\" value=");
      out.print(mvo.getMnum() );
      out.write(" onclick=\"chekOnly(this)\"></td>\n");
      out.write("\t\t\t\t\t<td style=\"font-size:14px\" align=\"center\">");
      out.print( mvo.getMnum());
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td align=\"center\">");
      out.print( mvo.getMid());
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td align=\"center\">");
      out.print( mvo.getMpw());
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td align=\"center\">");
      out.print( mvo.getMname());
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td align=\"center\">");
      out.print( mvo.getMphone());
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td align=\"center\">");
      out.print( mvo.getMemail());
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td align=\"center\">");
      out.print( mvo.getMregdate());
      out.write("</td>\n");
      out.write("\t\t\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t");

				}
			}else{
			
      out.write("\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td colspan=\"9\">검색결과가 없습니다.\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t</tr>\t\t\t\t\n");
      out.write("\t\t\t");

			
			}
			
      out.write("\n");
      out.write("\t\t\t</tbody>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</table>\n");
      out.write("\t</div>\n");
      out.write("\t");
 if(list !=null&&list.size()>0){
	
      out.write("\n");
      out.write("\t<div class=\"admin_paging list_paging\" style=\"    text-align: center;    font-size: 1.2em;    padding: 0.5em 0;\"> \n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "paging.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("url", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("/spw/adminSelectAll.spw", request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("pageSize", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(pageSize), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("groupSize", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(groupSize), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("curPage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(curPage), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("totalCount", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(totalCount), request.getCharacterEncoding()), out, true);
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t\t");

		}else{
			
		}
	
      out.write("\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- 하단바 -->\r\n");
      out.write("<footer id=\"footerarea\">\r\n");
      out.write("\t<div class=\"wrapper\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t[안내]\r\n");
      out.write("\t\t\t<br>아이콘 제작자 :\r\n");
      out.write("\t\t\t<a href=\"http://www.freepik.com/\" title=\"Freepik\">Freepik</a>\r\n");
      out.write("\t\t\tfrom\r\n");
      out.write("\t\t\t<a href=\"https://www.flaticon.com/kr/\" title=\"Flaticon\"> www.flaticon.com</a><br>\r\n");
      out.write("\t\t\t이 사이트는 실제 서비스가 되지 않는 교육실습용 사이트입니다.<br>\r\n");
      out.write("\t\t\t메인 배너 출처 :\r\n");
      out.write("\t\t\t<a href=\"https://m.bunjang.co.kr\">번개장터</a><br>\r\n");
      out.write("\t\t\t고객센터문의 :\r\n");
      out.write("\t\t\tcom.sajapanda@gmail.com\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}