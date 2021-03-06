/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.64
 * Generated at: 2021-06-05 06:05:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.myPage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.spw.general.vo.GeneralVO;
import com.spw.member.vo.MemberVO;
import javax.servlet.http.HttpSession;

public final class myGeneral_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.spw.general.vo.GeneralVO");
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

	request.setAttribute("siteTitle", "마이 페이지");

      out.write('\n');

	// 사자, 판다 리스트.
	Object obj = request.getAttribute("generalList");
	List<GeneralVO> list = (List<GeneralVO>)obj;
	System.out.println("list : "+list);
	// 현재 로그인한 vo값.
	Object objMvo = request.getAttribute("mvo");
	MemberVO mvo = (MemberVO)objMvo;
	String mid = mvo.getMid();

      out.write('\n');
      out.write('\n');
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
      out.write("<link rel=\"stylesheet\" href=\"./include/css/myPage.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"./include/css/mypagetable.css\">\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function(){\n");
      out.write("\t\t// 회원 수정 버튼.\n");
      out.write("\t\t$('#myUpdate').click(function(){\n");
      out.write("\t\t\t//console.log(\"수정버튼 실행 : \");\n");
      out.write("\t\t\t$('#myPageForm').attr('action','/spw/myInfo.spw');\n");
      out.write("\t\t\t$('#myPageForm').submit();\n");
      out.write("\t\t});\n");
      out.write("\t\tvar urls=\"/spw/myNotice.spw\";\n");
      out.write("\t\tvar datas;\n");
      out.write("\t\t$.ajax({\n");
      out.write("\t\t\turl:urls,\n");
      out.write("\t\t\ttype:\"GET\",\n");
      out.write("\t\t\tdata:datas,\n");
      out.write("\t\t\tsuccess:whenSuccess,\n");
      out.write("\t\t\terror:whenError\n");
      out.write("\t\t});\n");
      out.write("\t\tfunction whenSuccess(res){\n");
      out.write("\t\t\tconsole.log(\"success\");\n");
      out.write("\t\t\tconsole.log(res);\n");
      out.write("\t\t\t$('.notice_list').html(res);\n");
      out.write("\t\t}\n");
      out.write("\t\tfunction whenError(res){\n");
      out.write("\t\t\tconsole.log(\"error\");\n");
      out.write("\t\t\tconsole.log(res);\n");
      out.write("\t\t}\n");
      out.write("\t\t// 삭제.\n");
      out.write("\t\t$('#delGeneral').click(function(){\n");
      out.write("\t\t\tvar chkBox = document.getElementsByName(\"chkgnum\");\n");
      out.write("\t\t\tvar gsort = document.getElementById('chkgsort').value;\n");
      out.write("\t\t\tconsole.log(\"del gsort : \"+gsort);\n");
      out.write("\t\t\tvar cbCnt = 0;\n");
      out.write("\t\t\tvar gnum;\n");
      out.write("\t\t\tfor(var i=0;i<chkBox.length;i++){\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tif(chkBox[i].checked==true){\n");
      out.write("\t\t\t\t\tconsole.log(chkBox[i].value);\n");
      out.write("\t\t\t\t\tgnum = chkBox[i].value;\n");
      out.write("\t\t\t\t\tcbCnt++;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tdocument.getElementById(\"gnum\").setAttribute(\"value\",gnum);\n");
      out.write("\t\t\tdocument.getElementById(\"gsort\").setAttribute(\"value\",gsort);\n");
      out.write("\t\t\tif(cbCnt==0){\n");
      out.write("\t\t\t\talert(\"체크박스를 선택하세요.\");\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\tvar pick = confirm(\"삭제하시겠습니까?\");\n");
      out.write("\t\t\t\tif(pick==true){\n");
      out.write("\t\t\t\t\tconsole.log(\"삭제\");\n");
      out.write("\t\t\t\t\tconsole.log(\"gnum : \"+gnum);\n");
      out.write("\t\t\t\t\tconsole.log(\"gsort : \"+gsort);\n");
      out.write("\t\t\t\t\tdocument.myPageForm.action=\"/spw/myGeneralDel.spw?gnum=\"+gnum+\"&gsort=\"+gsort;\n");
      out.write("\t\t\t\t\tdocument.myPageForm.submit();\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t\t// DatePicker Format.\n");
      out.write("\t\t var dateFormat = \"yy/mm/dd\",\n");
      out.write("\t     \n");
      out.write("\t\t from = $( \"#dateFrom\" )\n");
      out.write("\t        .datepicker({\n");
      out.write("\t          defaultDate: \"+1w\",\n");
      out.write("\t          changeMonth: true,\n");
      out.write("\t          numberOfMonths: 1,\n");
      out.write("\t          dateFormat: dateFormat\n");
      out.write("\t        })\n");
      out.write("\t        .on( \"change\", \n");
      out.write("\t        \t\tfunction() {\n");
      out.write("\t          to.datepicker( \"option\", \"minDate\", getDate( this ) );\n");
      out.write("\t         \n");
      out.write("\t         var date= $.datepicker.formatDate('yy/mm/dd', new Date(getDate(this)));\n");
      out.write("\t         console.log(\"from >>>>>>\"+date);\n");
      out.write("\t         //$( \"#dateFrom\" ).val(date);\t         \n");
      out.write("\t\n");
      out.write("\t        }),\n");
      out.write("\t        \n");
      out.write("\t      to = $( \"#dateTo\" ).datepicker({\n");
      out.write("\t        defaultDate: \"+1w\",\n");
      out.write("\t        changeMonth: true,\n");
      out.write("\t        numberOfMonths: 1,\n");
      out.write("\t        dateFormat: dateFormat\n");
      out.write("\t      })\n");
      out.write("\t      .on( \"change\", function() {\n");
      out.write("\t        from.datepicker( \"option\", \"maxDate\", getDate( this ) );\n");
      out.write("\t        \n");
      out.write("\t        var date= $.datepicker.formatDate('yy/mm/dd', new Date(getDate(this)));\n");
      out.write("\t         console.log(\"to >>>>>>\"+date);\n");
      out.write("\t         //$( \"#dateTo\" ).val(date);\n");
      out.write("\t      });\n");
      out.write("\t \n");
      out.write("\t    function getDate( element ) {\n");
      out.write("\t      var date;\n");
      out.write("\t      try {\n");
      out.write("\t        date = $.datepicker.parseDate( dateFormat, element.value );\n");
      out.write("\t      } catch( error ) {\n");
      out.write("\t        date = null;\n");
      out.write("\t        console.log(error);\n");
      out.write("\t      }\n");
      out.write("\t \n");
      out.write("\t      return date;\n");
      out.write("\t    }\n");
      out.write("\t});\n");
      out.write("\t/* 날짜검색 */\n");
      out.write("\tfunction searchDate(){\n");
      out.write("\t\t//alert(\"날짜검색 >>> start  \");\n");
      out.write("\t\n");
      out.write("\t\tvar from=document.getElementById(\"dateFrom\").value;\n");
      out.write("\t\tconsole.log(\"from :: \"+from);\n");
      out.write("\t\tvar to=document.getElementById(\"dateTo\").value;\n");
      out.write("\t\tconsole.log(\"to :: \"+to);\n");
      out.write("\t\tvar sort = document.getElementById(\"chkgsort\").value;\n");
      out.write("\t\tconsole.log(\"sort :: \"+sort);\n");
      out.write("\t\tvar qStr = \"gsort=\"+sort+\"&dateFrom=\"+from+\"&dateTo=\"+to;\n");
      out.write("\t\tconsole.log(\"qStr :: \"+qStr);\n");
      out.write("\t\tlocation.href=\"/spw/myGeneral.spw?\"+qStr;\n");
      out.write("\t}\n");
      out.write("\t// 체크 박스 1개 선택.\n");
      out.write("\tfunction checkOnly(chk){\n");
      out.write("\t\tvar obj = document.getElementsByName(\"gnum\");\n");
      out.write("\t\t//console.log(chk.value);\n");
      out.write("\t\tfor (var i = 0; i < obj.length; i++) {\n");
      out.write("\t\t\tif(obj[i]!=chk){\n");
      out.write("\t\t\t\tobj[i].checked=false;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
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
      out.write("\n");
      out.write("<!-- 마이페이지.  -->\n");
      out.write("<div class=\"mypage_contents\">\n");
      out.write("<h2 align=\"left\">마이페이지</h2>\n");
      out.write("\t<!-- 회원정보.  -->\n");
      out.write("\t<div class=\"myinfo\">\n");
      out.write("\t\t<div class=\"myinfo_list\">\n");
      out.write("\t\t\t<form id=\"myPageForm\" name=\"myPageForm\">\n");
      out.write("\t\t\t");
      out.write("\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"gsort\" id=\"gsort\">\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"gnum\" id=\"gnum\">\n");
      out.write("\t\t\t<h3>회원정보</h3>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div class=\"myinfo_pic\">\n");
      out.write("\t\t\t\t<img src=\"/spw/include/img/mypage.png\">\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<div class=\"myinfo_id\">\n");
      out.write("\t\t\t\t<span>");
      out.print(mid );
      out.write("</span><br>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"myinfo_btn\">\n");
      out.write("\t\t\t\t<input type=\"button\" name=\"myUpdate\" id=\"myUpdate\" value=\"회원정보수정\" class=\"sitebtn\"/>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- 알림목록.  -->\n");
      out.write("\t\t<div class=\"mynotice_list\">\n");
      out.write("\t\t\t<h3>알림</h3>\n");
      out.write("\t\t\t<hr>\n");
      out.write("\t\t\t<div class=\"notice_list\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<br>\n");
      out.write("<div class=\"btn_container\">\n");
      out.write("\t<div class=\"tab_sort tab_saja\"><a href=\"/spw/myGeneral.spw?gsort=1\">사자</a></div>\n");
      out.write("\t<div class=\"tab_sort tab_panda\"><a href=\"/spw/myGeneral.spw?gsort=2\">판다</a></div>\n");
      out.write("\t<div class=\"tab_sort tab_auction\"><a href=\"/spw/myAuction.spw?asort=3\">경매</a></div>\n");
      out.write("\t<div class=\"tab_sort tab_pick\"><a href=\"/spw/myPick.spw\">찜</a></div>\n");
      out.write("</div>\n");
      out.write("<!-- 날짜검색 -->\n");
      out.write("<div class=\"search_by_date\">\n");
      out.write("\t날짜입력\n");
      out.write("\t<input type=\"text\" id=\"dateFrom\" name=\"dateFrom\" class=\"sitetxt\" size=\"15\">\n");
      out.write("\t~\n");
      out.write("\t<input type=\"text\" id=\"dateTo\" name=\"dateTo\" class=\"sitetxt\" size=\"15\">\n");
      out.write("\t<input type=\"button\" value=\"조회\" name=\"btnSerachByDate\"id=\"btnSerachByDate\" onclick=\"searchDate()\" class=\"sitebtn\">\n");
      out.write("</div>\n");
      out.write("<div class=\"del_btn\">\n");
      out.write("\t<input type=\"button\" id=\"delGeneral\" name=\"delGeneral\" value=\"삭제\" class=\"sitebtn\"/>\n");
      out.write("</div>\n");
      out.write("<div class=\"list_contents\">\n");
      out.write("<div class=\"list_top\">\n");
      out.write("<form name=\"generalForm\" id=\"generalForm\">\n");

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

      out.write("\n");
      out.write("\t\t<div class=\"list_grid\">\n");
      out.write("\t\t\t<!-- 조회된 상품 수 -->\n");
      out.write("\t\t\t<div class=\"grid_row\">\n");
      out.write("\t\t\t\t<div class=\"list_grid_count\">\n");
      out.write("\t\t\t\t\t조회된 상품 수 : <span>");
      out.print(total);
      out.write("</span>개\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<h5> 총 ");
      out.print(count);
      out.write("페이지 중 현재 ");
      out.print(cur);
      out.write("페이지</h5>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<ul>\n");

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

      out.write("\n");
      out.write("\t\t\t\t<li class=\"grid_item\">\n");
      out.write("\t\t\t\t\t<a href=\"/spw/generalDetailForm.spw?gnum=");
      out.print(mgvo.getGnum());
      out.write("\">\n");
      out.write("\t\t\t\t\t\t<div class=\"grid_item_box\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"grid_img\">\n");

	// 구분을 통해 사자인지 판다인지.
	String gsort = mgvo.getGsort();	
/* 	System.out.println("gsort : "+gsort);
	System.out.println("gsort=='1' : "+gsort.equals("1")); */
	if(gsort!=null&&gsort.equals("1")){

      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"grid_img_label label_saja\">\n");
	}else{

      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"grid_img_label label_panda\">\n");
}
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"chkgnum\" id=\"chkgnum\" value=\"");
      out.print(mgvo.getGnum() );
      out.write("\" onclick=\"checkOnly(this)\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"chkgsort\" id=\"chkgsort\" value=\"");
      out.print(mgvo.getGsort() );
      out.write("\">\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"/spw/editImages/Thumb_");
      out.print(mgvo.getGphoto() );
      out.write("\">\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"grid_label\">\n");
      out.write("\t\t\t\t\t\t\t\t<h3 class=\"grid_title\">\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(mgvo.getGtitle() );
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t</h3>\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"grid_local\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>");
      out.print(mgvo.getGloc() );
      out.write("</span>    <!-- 거래지역 -->    \n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"grid_balance\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>");
      out.print(mgvo.getGprice() );
      out.write("</span>원\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</li>\n");

		}

      out.write("\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\t\n");
      out.write("\t\t<!-- 페이징 -->\n");
      out.write("\t\t<div class=\"list_paging paging_saja\">\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "myPaging.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("url", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("/spw/myGeneral.spw", request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("qString", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(qString ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("groupsize", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(groupsize ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("pagesize", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(pagesize ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("curpage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(curpage ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("totalcount", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(totalcount ), request.getCharacterEncoding()), out, true);
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t</form>\n");

	}else{

      out.write("\n");
      out.write("\t\t<div align=\"center\">\n");
      out.write("\t\t\t등록된 데이터가 존재하지 않습니다.\n");
      out.write("\t\t</div>\n");

	}

      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</div>\n");
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
