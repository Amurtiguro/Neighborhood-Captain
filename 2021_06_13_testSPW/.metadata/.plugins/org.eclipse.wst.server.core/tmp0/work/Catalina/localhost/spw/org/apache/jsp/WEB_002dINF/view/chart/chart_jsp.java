/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.64
 * Generated at: 2021-06-13 06:58:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.chart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;

public final class chart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/view/main/top2.jsp", Long.valueOf(1623115930048L));
    _jspx_dependants.put("/WEB-INF/view/main/top1.jsp", Long.valueOf(1623115881915L));
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

      out.write('\r');
      out.write('\n');
      out.write('\n');

	// 타이틀 설정
	String siteTitle = "구매판매";

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
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/spw/include/css/adminform.css\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//html을 동적으로 만들려면 제이쿼리 reay사용\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t//(실시간)년도를 계산하기 위한 변수 선언\r\n");
      out.write("\t\tvar year = new Date().getFullYear();\r\n");
      out.write("\t\tvar previousYear = \tyear-1;\r\n");
      out.write("\t\tvar twoYearsAgo = (year-2);\r\n");
      out.write("\t\tvar threeYearsAgo =( year-3);\r\n");
      out.write("\t\tvar FourYearsAgo = (year-4);\r\n");
      out.write("\t\r\n");
      out.write("\t\t//년도를 해당 html 태그(select태그 내부의 option태그)에 넣기\r\n");
      out.write("\t\tdocument.getElementById('thisYear').value = year;\r\n");
      out.write("\t\tdocument.getElementById('thisYear').innerText = year;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById('previousYear').value = previousYear;\r\n");
      out.write("\t\tdocument.getElementById('previousYear').innerText = previousYear;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById('twoYearsAgo').value = twoYearsAgo;\r\n");
      out.write("\t\tdocument.getElementById('twoYearsAgo').innerText = twoYearsAgo;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById('threeYearsAgo').value = threeYearsAgo;\r\n");
      out.write("\t\tdocument.getElementById('threeYearsAgo').innerText = threeYearsAgo;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById('FourYearsAgo').value = FourYearsAgo;\r\n");
      out.write("\t\tdocument.getElementById('FourYearsAgo').innerText = FourYearsAgo;\r\n");
      out.write("\t});//end of $(document).ready\r\n");
      out.write("\t\r\n");
      out.write("\tfunction cnt() {\r\n");
      out.write("\t\t//분기별 선택 값을 추출해서  분기해서 담기 \r\n");
      out.write("\t    var years = document.getElementById('selectYear').value;\r\n");
      out.write("\t\tvar start1 = years+\"0101\";\r\n");
      out.write("\t\tvar end1 = years+\"0331\";\r\n");
      out.write("\t\tvar start2 = years+\"0401\";\r\n");
      out.write("\t\tvar end2 = years+\"0630\";\r\n");
      out.write("\t\tvar start3 = years+\"0701\";\r\n");
      out.write("\t\tvar end3 = years+\"0930\";\r\n");
      out.write("\t\tvar star4 = years+\"1001\";\r\n");
      out.write("\t\tvar end4 = years+\"1231\";\r\n");
      out.write("\t\t}//end of cnt()\r\n");
      out.write("</script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    $(document).ready(function(){\r\n");
      out.write("    \t\r\n");
      out.write("    \t//제이쿼리는 태그선택을 name으로 선택하는게 아니라 id로 선택한다.\r\n");
      out.write(" \t\t$(\"#search\").on(\"click\",function(){\r\n");
      out.write(" \t\t\tvar cgNum = $(\"#cgNum\").val();\r\n");
      out.write(" \t\t\tif(cgNum == \"모두 선택\"){\r\n");
      out.write(" \t\t\t\tcgNum=null;\r\n");
      out.write(" \t\t\t}\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\t$.ajax({\r\n");
      out.write(" \t\t\t\turl :\"/spw/cntAllData.spw\" ,\r\n");
      out.write(" \t\t\t\ttype : \"post\",\r\n");
      out.write(" \t\t\t\tdataType : \"json\",\r\n");
      out.write(" \t\t\t\tdata : {\"selectYear\":$(\"#selectYear\").val(),\"cgNum\":cgNum}, //보내는 데이터를 어떻게 보낼지 생각해봐야 한다.\r\n");
      out.write(" \t\t\t\tsuccess : function(list, status, xhr){\r\n");
      out.write(" \t\t\t\t\tconsole.log(\"리스트 list :\", list);\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\tgoogle.charts.load('current', {'packages':['corechart']});\r\n");
      out.write(" \t\t\t\t\tgoogle.charts.setOnLoadCallback(drawChart);\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\tfunction drawChart(){\r\n");
      out.write(" \t\t\t\t\t\tvar data = google.visualization.arrayToDataTable(list);\r\n");
      out.write(" \t\t\t\t\t\tvar options = {\r\n");
      out.write(" \t\t\t\t\t\t          title : '년도 별 상품등록 현황',\r\n");
      out.write(" \t\t\t\t\t\t          vAxis: {title: '상품등록 수'},\r\n");
      out.write(" \t\t\t\t\t\t          hAxis: {title: '분기별'},\r\n");
      out.write(" \t\t\t\t\t\t          seriesType: 'bars',\r\n");
      out.write(" \t\t\t\t\t\t          series: {5: {type: 'line'}}     \r\n");
      out.write(" \t\t\t\t\t\t          };\r\n");
      out.write(" \t\t\t\t\t\tvar chart = new google.visualization.ComboChart(document.getElementById('chart_div'));\r\n");
      out.write(" \t\t\t\t        chart.draw(data, options);\r\n");
      out.write("\r\n");
      out.write(" \t\t\t\t\t}//deawChart 종료\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t\t\t\t},//success 종료\r\n");
      out.write(" \t\t\t\terror: function(xhr,status,error){\r\n");
      out.write(" \t\t\t\t\tconsole.log(error);\r\n");
      out.write(" \t\t\t\t}\r\n");
      out.write(" \t\t\t}) //ajax 종료\r\n");
      out.write(" \t\t\t\r\n");
      out.write(" \t\t\treturn false;\r\n");
      out.write(" \t\t});   \r\n");
      out.write("    });\r\n");
      out.write("    </script>\r\n");
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
      out.write("\t\t\t<option value=\"1\">구매</option>\r\n");
      out.write("\t\t\t<option value=\"2\">판매</option>\r\n");
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
      out.write("\t\t\t\t\t\t\t// 구매\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t// 경로지정\r\n");
      out.write("\t\t\t\t\t\t\ttopSearchform.attr(\"action\", \"/spw/generalSList.spw\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t// 전송\r\n");
      out.write("\t\t\t\t\t\t\ttopSearchform.submit();\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}else if(selectVal == \"2\"){\r\n");
      out.write("\t\t\t\t\t\t\t// 판매\r\n");
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
      out.write("\t\t\t\t\t\t\t구매\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/generalPList.spw\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\r\n");
      out.write("\t\t\t\t\t\t\t판매\r\n");
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
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div class=\"list_sort\">\r\n");
      out.write("    \t<div class=\"tab_sort tab_panda\">\r\n");
      out.write("    \t\t<a href=\"/spw/adminSelectAll.spw\">회원 관리</a>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t<div class=\"tab_sort tab_saja tab_sel\">\r\n");
      out.write("    \t\t상품등록 현황\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t<div class=\"tab_sort tab_comment\">\r\n");
      out.write("    \t\t<a href=\"/spw/comment/listall.spw\">댓글 관리</a>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </div>\r\n");
      out.write("\t<div class=\"chart\" align=\"center\" style=\"background-color: #EAEAEA\">\r\n");
      out.write("\t<div id=\"chart_div\" style=\"width: 900px; height: 500px;\"></div><br> \r\n");
      out.write("\t<form id=\"chartinput\" name=\"chartinput\">\r\n");
      out.write("\t카테고리 선택 <select id=\"cgNum\">\r\n");
      out.write("\t\t<option>모두 선택</option>\r\n");
      out.write("\t\t<option value=\"CG01\">패션잡화 </option>\r\n");
      out.write("\t\t<option value=\"CG02\">여성의류</option>\r\n");
      out.write("\t\t<option value=\"CG03\">남성의류</option>\r\n");
      out.write("\t\t<option value=\"CG04\">디지털/가전</option>\r\n");
      out.write("\t\t<option value=\"CG05\">도서/티켓/취미/애완</option>\r\n");
      out.write("\t\t<option value=\"CG06\">생활/문구/가구/식품</option>\r\n");
      out.write("\t\t<option value=\"CG07\">유아동/출산</option>\r\n");
      out.write("\t\t<option value=\"CG08\">스포츠/레저 </option>\r\n");
      out.write("\t\t<option value=\"CG09\">뷰티/미용</option>\r\n");
      out.write("\t\t<option value=\"CG10\">기타</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t연도선택\r\n");
      out.write("\t\t<select id=\"selectYear\" name=\"selectYear\">\r\n");
      out.write("\t\t\t<option id=\"thisYear\"></option>\r\n");
      out.write("\t\t\t<option id=\"previousYear\" ></option>\r\n");
      out.write("\t\t\t<option id=\"twoYearsAgo\"></option>\r\n");
      out.write("\t\t\t<option id=\"threeYearsAgo\"></option>\r\n");
      out.write("\t\t\t<option id=\"FourYearsAgo\"></option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t <input type=\"button\" id =\"search\" name=\"search\" value=\"조회\" onclick=\"cnt()\"> \r\n");
      out.write("\t\t <input type=\"hidden\" id =\"startDate\" name=\"startDate\" value=\"\">\r\n");
      out.write("\t\t <input type=\"hidden\" id=\"endDate\"name=\"endDate\" value=\"\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</div>\r\n");
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