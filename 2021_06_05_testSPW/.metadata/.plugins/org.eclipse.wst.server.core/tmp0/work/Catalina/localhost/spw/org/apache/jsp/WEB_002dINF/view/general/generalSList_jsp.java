/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.64
 * Generated at: 2021-06-05 08:14:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.general;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.spw.general.vo.GeneralVO;
import java.util.List;
import javax.servlet.http.HttpSession;

public final class generalSList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      out.write('\n');

	request.setAttribute("siteTitle", "?????? ??????");

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
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t\n");
      out.write("\t/* ????????? : generalInsertForm */\n");
      out.write("\tfunction generalInsertForm(){\n");
      out.write("\t\t//console.log(\"generalInsertForm ??????\");\n");
      out.write("\t\tlocation.href=\"generalInsertForm.spw\";\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write(" \t/* ???????????? : generalDetailForm */\n");
      out.write("\tfunction generalDetailForm(){\n");
      out.write("\t\tvar gnum = $(\".chkInNo:checked\").val();\n");
      out.write("\t\t//console.log(\"gnum >> \" + gnum);\n");
      out.write("\t\t\n");
      out.write("\t\t$(\"#sList #gnum\").val(gnum);\n");
      out.write("\t\t$(\"#sList\").attr(\"action\", \"generalDetailForm.spw\");\n");
      out.write("\t\t$(\"#sList\").submit();\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t/* ???????????? */\n");
      out.write("\tfunction searchDate(){\n");
      out.write("\t\t//console.log(\"???????????? >>> start  \");\n");
      out.write("\t\n");
      out.write("\t\tvar from=document.getElementById(\"dateFrom\").value;\n");
      out.write("\t\tconsole.log(\"from :: \"+from);\n");
      out.write("\t\tvar to=document.getElementById(\"dateTo\").value;\n");
      out.write("\t\tconsole.log(\"to :: \"+to);\n");
      out.write("\t\n");
      out.write("\t\tvar urls=\"/spw/generalSList.spw\";\n");
      out.write("\t\t//var formData=$(\"form[name=detailForm]\").serialize();\n");
      out.write("\t\tvar formData={\n");
      out.write("\t\t\t\t\t\tdateFrom:from,\n");
      out.write("\t\t\t\t\t\tdateTo:to, }\n");
      out.write("\t\t\n");
      out.write("\t\tif(from!=null&&from!=''&&to!=null&&to!=''){\n");
      out.write("\t\t\tconsole.log(\"from/to ??? ?????? ?????? ?????? \");\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\ttype : \"get\",\n");
      out.write("\t\t\t\turl:urls,\n");
      out.write("\t\t\t\tdata : formData,\n");
      out.write("\t\t\t\tsuccess: whenSuccess,\n");
      out.write("\t\t\t\terror: whenError\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}else{\n");
      out.write("\t\t\tconsole.log(\"from/ to ?????? ?????? ?????????!\");\n");
      out.write("\t\t}\n");
      out.write("\t\t//???????????? ???\n");
      out.write("\t\tfunction whenSuccess(data){\n");
      out.write("\t\t\tconsole.log(\" ajax ?????? !!!! \");\n");
      out.write("\t\t\t//console.log(data);\n");
      out.write("\t\t    $(\"#sList div.list_grid\").replaceWith($(data).find(\"#sList div.list_grid\"));\n");
      out.write("\t\t    $(\"#sList div.list_paging paging_saja\").replaceWith($(data).find(\"#sList div.list_paging paging_saja\"));\n");
      out.write("\t\t}\n");
      out.write("\t\t//???????????? ???\n");
      out.write("\t\tfunction whenError(){\n");
      out.write("\t\t\tconsole.log(\"????????? ?????? !! \");\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t$(document).ready(function(){\n");
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
      out.write("\t\n");
      out.write("</script>\n");
      out.write("\n");
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
      out.write('\n');

	String groupsize = "0";  // ???????????????   
	String pagesize = "0"; 	 // ?????????????????? 
	String curpage = "0"; 	 // ???????????????   
	String totalcount = "0"; // ???????????????
	
	// Controller?????? setAttribute ?????? ??? sList ????????????.
	Object obj = request.getAttribute("sList");
	List<GeneralVO> sList = (List)obj;

      out.write("\n");
      out.write("\t<!-- ???????????????(?????????) -->\n");
      out.write("\t<div class=\"list_contents\">\n");
      out.write("\t<div class=\"list_top\">\n");
      out.write("\t<h2 class=\"list_title\">?????? ??????</h2>\n");
      out.write("\t\n");
      out.write("\t<!-- ???????????? -->\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/category/list.spw", out, false);
      out.write("\n");
      out.write("\t\n");
      out.write("\t<!-- ???????????? -->\n");
      out.write("\t<div class=\"search_by_date\">\n");
      out.write("\t\t????????????\n");
      out.write("\t\t<input type=\"text\" id=\"dateFrom\" name=\"dateFrom\" class=\"sitetxt\" size=\"15\">\n");
      out.write("\t\t~\n");
      out.write("\t\t<input type=\"text\" id=\"dateTo\" name=\"dateTo\" class=\"sitetxt\" size=\"15\">\n");
      out.write("\t\t<input type=\"button\" value=\"??????\" name=\"btnSerachByDate\"id=\"btnSerachByDate\" onclick=\"searchDate()\" class=\"sitebtn\">\n");
      out.write("\t</div>\n");
      out.write("\t<br>\n");
      out.write("\t\n");
      out.write("\t<div class=\"\" align=\"right\">\n");
      out.write("\t\t<input type=\"button\" value=\"????????????\" class=\"sitebtn\" onclick=\"generalInsertForm()\" />\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<form id=\"sList\" name=\"sList\" method=\"POST\">\n");

	if(sList != null&&sList.size()>0){
	//??????????????? ???????????? 
	int cur=Integer.parseInt(sList.get(0).getCurpage());
	int total=Integer.parseInt(sList.get(0).getTotalcount());
	int size=Integer.parseInt("16");
	//??? ????????? ??????(???????????? / ????????? ?????? )
	int count = (int)Math.ceil(total / (size+0.0));
	
	String qString=request.getParameter("cgnum");
	String dateTo=request.getParameter("dateTo");
	String dateFrom=request.getParameter("dateFrom");
	System.out.println("qString : "+qString);
	System.out.println("1 :: dateTo :: "+dateTo+", dateFrom :: "+dateFrom);
	
	//????????????, ?????? ?????? ??????????????? ??????
	if(qString == null){
		qString = "";
	}else{
		qString = "cgnum=" + qString;
	}
	if(dateTo==null||dateFrom==null||dateTo==""||dateFrom==""){
		dateTo="";
		dateFrom="";
		System.out.println("2 :: dateTo :: "+dateTo+", dateFrom :: "+dateFrom);
	}else{
		qString="dateTo="+dateTo+"&dateFrom="+dateFrom;
	}

      out.write("\n");
      out.write("\t<!-- ????????? ?????? -->\n");
      out.write("\t<div class=\"list_grid\">\n");
      out.write("\t<!-- ????????? ?????? ??? -->\n");
      out.write("\t\t<div class=\"grid_row\">\n");
      out.write("\t\t\t<div class=\"list_grid_count\">\n");
      out.write("\t\t\t\t????????? ?????? ??? : <span>");
      out.print(total);
      out.write("</span>???\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\t<h5> ??? ");
      out.print(count);
      out.write("????????? ??? ?????? ");
      out.print(cur);
      out.write("?????????</h5>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<ul>\n");

			for(int i=0; i<sList.size();i++){
				GeneralVO gvo = sList.get(i);
				
				groupsize = gvo.getGroupsize();
				pagesize = gvo.getPagesize();
				curpage = gvo.getCurpage();        // ??????????????? 
				totalcount = gvo.getTotalcount();  // ??????????????? 
				
				/* System.out.println("groupsize >>> " + groupsize);
				System.out.println("pagesize >>> " + pagesize);
				System.out.println("curpage >>> " + curpage);
				System.out.println("totalcount >>> " + totalcount); */

      out.write("\n");
      out.write("\t\t\t<li class=\"grid_item\">\n");
      out.write("\t\t\t\t<a href=\"/spw/generalDetailForm.spw?gnum=");
      out.print(gvo.getGnum());
      out.write("\">\n");
      out.write("\t\t\t\t\t<div class=\"grid_item_box\">\n");
      out.write("\t\t\t\t\t\t<div class=\"grid_img\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"grid_img_label label_saja\">\n");
      out.write("\t\t\t\t\t\t\t\t??????\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<img src=\"/spw/editImages/");
      out.print(gvo.getGrephoto() );
      out.write("\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"grid_label\">\n");
      out.write("\t\t\t\t\t\t\t<h3 class=\"grid_title\">\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print( gvo.getGtitle() );
      out.write("               <!-- ?????? --> \n");
      out.write("\t\t\t\t\t\t\t</h3>\n");
      out.write("\t\t\t\t\t\t\t<p class=\"grid_local\">\n");
      out.write("\t\t\t\t\t\t\t\t<span>");
      out.print( gvo.getGloc() );
      out.write("</span>    <!-- ???????????? -->    \n");
      out.write("\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t<p class=\"grid_balance\">    \n");
      out.write("\t\t\t\t\t\t\t\t<span>");
      out.print( gvo.getGprice() );
      out.write("</span>???  <!-- ?????? --> \n");
      out.write("\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t</li>\n");

			}

      out.write("\n");
      out.write("\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- ????????? -->\n");
      out.write("\t\t<div class=\"list_paging paging_saja\">\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "paging.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("url", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("/spw/generalSList.spw", request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("qString", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(qString ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("groupsize", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(groupsize ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("pagesize", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(pagesize ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("curpage", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(curpage ), request.getCharacterEncoding()) + "&" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("totalcount", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(totalcount ), request.getCharacterEncoding()), out, true);
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t</form>\n");

					
		}else{

      out.write("\n");
      out.write("\t\t<div class=\"list_msg\">\n");
      out.write("\t\t\t<h3>????????? ???????????? ???????????? ????????????.</h3>\n");
      out.write("\t\t</div>\n");

		}

      out.write("\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\t<!-- ?????? ???. -->\n");
      out.write("\t\t");
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
      out.write("\n");
      out.write("\t</body>\n");
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
