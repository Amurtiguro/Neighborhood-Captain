/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.64
 * Generated at: 2021-06-13 06:58:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;

public final class listAll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/WEB-INF/view/main/top2.jsp", Long.valueOf(1623115930048L));
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1621935679339L));
    _jspx_dependants.put("jar:file:/C:/00.KOSMO78/30.web/testSPW/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/spw/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	// ???????????????
	String ccontents = request.getParameter("ccontents");
	
	String qStr = "";
	if(ccontents != null && ccontents.length() > 0){
		qStr = "ccontents=" + ccontents;
	}

	request.setAttribute("siteTitle", "????????? ?????????");

      out.write('\r');
      out.write('\n');
      out.write('\n');

	// ????????? ??????
	String siteTitle = "????????????";

	String siteTitleParam = (String)request.getAttribute("siteTitle");

	if(siteTitleParam != null && siteTitleParam.length() > 0){
		siteTitle = siteTitleParam;
	}
	HttpSession hs =request.getSession();
	String sessionNum = (String)hs.getAttribute("mnum");
	//System.out.println("?????? ???????????? : "+sessionNum);

      out.write("\n");
      out.write("<!-- ??????, ??????, ?????????, ????????? ????????? ?????? ???????????? -->\n");
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
      out.write("<script>\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t// ??????\r\n");
      out.write("\t\t$(\".delCmt\").click(function(){\r\n");
      out.write("\t\t\tif(confirm(\"?????????????????????????\") == true){\r\n");
      out.write("\t\t\t\tvar delURL = $(this).attr(\"href\");\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\tfunction delSuccess(data){\r\n");
      out.write("\t\t\t\t\tif(data.status == \"OK\"){\r\n");
      out.write("\t\t\t\t\t\tlocation.reload();\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\tconsole.log(data.msg);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\tfunction delFail(){\r\n");
      out.write("\t\t\t\t\tconsole.log(\"???????????? ???????????? ????????? ??????????????????.\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\turl: delURL,\r\n");
      out.write("\t\t\t\t\tdataType: \"JSON\",\r\n");
      out.write("\t\t\t\t\tmethod: \"GET\",\r\n");
      out.write("\t\t\t\t\tsuccess: delSuccess,\r\n");
      out.write("\t\t\t\t\terror: delFail\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#commSearch\").submit(function(){\r\n");
      out.write("\t\t\tif($(\"#ccontents\").val() == \"\"){\r\n");
      out.write("\t\t\t\talert(\"????????? ????????? ???????????????\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- ???????????? ?????? -->\r\n");
      out.write("<div id=\"sitearea\">\r\n");
      out.write("\t<!-- ????????? -->\r\n");
      out.write("\t<header id=\"topbar\">\r\n");
      out.write("\t\t<div class=\"wrapper\">\r\n");
      out.write("\t\t\t<!-- ????????? ????????????(??????, ??????) -->\r\n");
      out.write("\t\t\t<div id=\"logoarea\">\r\n");
      out.write("\t\t\t\t<!-- ?????? -->\r\n");
      out.write("\t\t\t\t<div id=\"toplogo\">\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/index.spw\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/spw/include/img/logo.png\" id=\"sitelogo\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"mobilebtns\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"???\" class=\"sitebtn\" id=\"btnSearchBar\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"???\" class=\"sitebtn\" id=\"btnBtnArea\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"???\" class=\"sitebtn\" id=\"btnNaviArea\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- ????????? -->\r\n");
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
      out.write("\t\t<!-- ???????????? -->\r\n");
      out.write("\t\t<select id=\"topSearchsel\">\r\n");
      out.write("\t\t\t<option value=\"1\">??????</option>\r\n");
      out.write("\t\t\t<option value=\"2\">??????</option>\r\n");
      out.write("\t\t\t<option value=\"3\">??????</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t<!-- ??????????????? -->\r\n");
      out.write("\t\t<div id=\"searchtext\">\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"topSearchtxt\" value=\"");
      out.print(topSearchText );
      out.write("\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- ???????????? -->\r\n");
      out.write("\t\t<input type=\"submit\" value=\"??????\" id=\"searchbtn\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t$(\"form#topSearchform\").submit(function(){\r\n");
      out.write("\t\t\t\t// ???\r\n");
      out.write("\t\t\t\tvar topSearchform = $(\"form#topSearchform\")\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// ?????????\r\n");
      out.write("\t\t\t\tvar topSearchSel = $(\"#topSearchsel\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// ?????????\r\n");
      out.write("\t\t\t\tvar topSearchtxt = $(\"#topSearchtxt\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif(topSearchtxt.val() != null && topSearchtxt.val() != \"\"){\r\n");
      out.write("\t\t\t\t\t// ????????? ??????\r\n");
      out.write("\t\t\t\t\tvar selectVal = topSearchSel.val();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif(selectVal == \"3\"){\r\n");
      out.write("\t\t\t\t\t\t// ??????\r\n");
      out.write("\t\t\t\t\t\t// ??????????????? name?????? ??????\r\n");
      out.write("\t\t\t\t\t\ttopSearchtxt.attr(\"name\", \"atitle\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t// ????????????\r\n");
      out.write("\t\t\t\t\t\ttopSearchform.attr(\"action\", \"/spw/auctionList.spw\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t// ??????\r\n");
      out.write("\t\t\t\t\t\ttopSearchform.submit();\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t// ??????????????? name?????? ??????\r\n");
      out.write("\t\t\t\t\t\ttopSearchtxt.attr(\"name\", \"gtitle\");\r\n");
      out.write("\t\t\t\t\t\tif(selectVal == \"1\"){\r\n");
      out.write("\t\t\t\t\t\t\t// ??????\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t// ????????????\r\n");
      out.write("\t\t\t\t\t\t\ttopSearchform.attr(\"action\", \"/spw/generalSList.spw\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t// ??????\r\n");
      out.write("\t\t\t\t\t\t\ttopSearchform.submit();\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}else if(selectVal == \"2\"){\r\n");
      out.write("\t\t\t\t\t\t\t// ??????\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t// ????????????\r\n");
      out.write("\t\t\t\t\t\t\ttopSearchform.attr(\"action\", \"/spw/generalPList.spw\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t// ??????\r\n");
      out.write("\t\t\t\t\t\t\ttopSearchform.submit();\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\talert(\"???????????? ????????? ?????????\");\r\n");
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
	System.out.println("?????? ???????????? : "+sessionNum2);

      out.write('\r');
      out.write('\n');
				
					
				String admin="M202007300001";
				if(sessionNum2!=null&&sessionNum2.length()>0){
					if(admin.equals(sessionNum2)){

      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/spw/logout.spw\" class=\"sitebtn\">????????????</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/spw/adminSelectAll.spw\" class=\"sitebtn\">??????????????????</a> \r\n");
					
					}else{

      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/spw/logout.spw\" class=\"sitebtn\">????????????</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/spw/myPage.spw\" class=\"sitebtn\">???????????????</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"/spw/generalInsertForm.spw\" class=\"sitebtn\">?????????</a>\r\n");
					
					}
				}else{

      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/loginform.spw\" class=\"sitebtn\">?????????</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/meminsertform.spw\" class=\"sitebtn\">????????????</a>\r\n");

				}

      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- ?????? -->\r\n");
      out.write("\t\t<div id=\"naviarea\">\r\n");
      out.write("\t\t\t<ul class=\"wrapper\">\r\n");
      out.write("\t\t\t\t<!-- ??????????????? -->\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/generalSList.spw\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\r\n");
      out.write("\t\t\t\t\t\t\t??????\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/generalPList.spw\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\r\n");
      out.write("\t\t\t\t\t\t\t??????\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/local.spw\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\r\n");
      out.write("\t\t\t\t\t\t\t??????\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a href=\"/spw/auctionList.spw\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\r\n");
      out.write("\t\t\t\t\t\t\t??????\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<!-- ?????? -->\r\n");
      out.write(" \t<div id=\"sitecontent\">\r\n");
      out.write("\t\t<div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<div class=\"list_sort\">\r\n");
      out.write("\t<div class=\"tab_sort tab_panda\">\r\n");
      out.write("\t\t<a href=\"/spw/adminSelectAll.spw\">????????????</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"tab_sort tab_saja\">\r\n");
      out.write("\t\t<a href=\"/spw/chartboard.spw\">???????????? ??????</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"tab_sort tab_comment tab_sel\">\r\n");
      out.write("\t\t?????? ??????\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<table class=\"table_list table_hover\">\r\n");
      out.write("\t<colgroup>\r\n");
      out.write("\t\t<col>\r\n");
      out.write("\t\t<col width=\"50%\">\r\n");
      out.write("\t\t<col>\r\n");
      out.write("\t\t<col>\r\n");
      out.write("\t\t<col width=\"10%\">\r\n");
      out.write("\t\t<col width=\"10%\">\r\n");
      out.write("\t\t<col>\r\n");
      out.write("\t</colgroup>\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td class=\"col_right\" colspan=\"7\">\r\n");
      out.write("\t\t\t\t<form method=\"GET\" action=\"/spw/comment/listall.spw\" id=\"commSearch\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"ccontents\" id=\"ccontents\" class=\"sitetxt\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.ccontents}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" class=\"sitebtn\" value=\"??????\">\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>?????? ??????</th>\r\n");
      out.write("\t\t\t<th>?????? ??????</th>\r\n");
      out.write("\t\t\t<th>?????? ??????</th>\r\n");
      out.write("\t\t\t<th>?????????</th>\r\n");
      out.write("\t\t\t<th>?????????</th>\r\n");
      out.write("\t\t\t<th>?????? ID</th>\r\n");
      out.write("\t\t\t<th>??????</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t<tbody>\r\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("<div class=\"list_paging\">\r\n");
      out.write("\t<p style=\"text-align: right;\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "paging.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("url", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("comment/listall.spw", request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("qStr", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(qStr), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("curpage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cmvo.curpage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("groupsize", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cmvo.groupsize}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("pagesize", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cmvo.pagesize}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("totalcount", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${totalcount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null), request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("\t</p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- ????????? -->\r\n");
      out.write("<footer id=\"footerarea\">\r\n");
      out.write("\t<div class=\"wrapper\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t[??????]\r\n");
      out.write("\t\t\t<br>????????? ????????? :\r\n");
      out.write("\t\t\t<a href=\"http://www.freepik.com/\" title=\"Freepik\">Freepik</a>\r\n");
      out.write("\t\t\tfrom\r\n");
      out.write("\t\t\t<a href=\"https://www.flaticon.com/kr/\" title=\"Flaticon\"> www.flaticon.com</a><br>\r\n");
      out.write("\t\t\t??? ???????????? ?????? ???????????? ?????? ?????? ??????????????? ??????????????????.<br>\r\n");
      out.write("\t\t\t?????? ?????? ?????? :\r\n");
      out.write("\t\t\t<a href=\"https://m.bunjang.co.kr\">????????????</a><br>\r\n");
      out.write("\t\t\t?????????????????? :\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/view/comment/listAll.jsp(102,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty commentList}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t<tr>\r\n");
          out.write("\t\t\t<td colspan=\"7\" align=\"center\">????????? ????????????.</td>\r\n");
          out.write("\t\t</tr>\r\n");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/view/comment/listAll.jsp(107,0) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${commentList}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      // /WEB-INF/view/comment/listAll.jsp(107,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("cvo");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t<tr>\r\n");
            out.write("\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cvo.cnum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\t\t\t<td class=\"col_left\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cvo.ccontents}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cvo.cpnum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\t\t\t<td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cvo.cindate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\t\t\t<td class=\"col_center\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cvo.mname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\t\t\t<td class=\"col_center\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cvo.mid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\t\t\t<td>\r\n");
            out.write("\t\t\t\t\t<a href=\"/spw/comment/delete.spw?cnum=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cvo.cnum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" class=\"delCmt sitebtn\">??????</a>\r\n");
            out.write("\t\t\t\t</td>\r\n");
            out.write("\t\t\t</tr>\r\n");
            out.write("\t\t\t");
            if (_jspx_meth_c_005fset_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
              return true;
            out.write('\r');
            out.write('\n');
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
      // /WEB-INF/view/comment/listAll.jsp(119,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("totalcount");
      // /WEB-INF/view/comment/listAll.jsp(119,3) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cvo.totalcount}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }
}
