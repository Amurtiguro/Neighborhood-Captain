/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.64
 * Generated at: 2021-06-17 08:58:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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

      out.write('\n');
      out.write('\n');

	HttpSession hs =request.getSession();
	String sessionNum = (String)hs.getAttribute("mnum");
	System.out.println("세션 회원번호 : "+sessionNum);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"./include/css/mainstyle.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<!-- 상단바와 내용 -->\n");
      out.write("<div id=\"sitearea\">\n");
      out.write("\t<!-- 상단바 -->\n");
      out.write("<!-- \t<header id=\"topbar\"> -->\n");
      out.write("\t\t<div class=\"wrapper\">\n");
      out.write("\t\t\t<!-- 상단바 로고영역(로고, 검색) -->\n");
      out.write("\t\t\t<div id=\"logoarea\">\n");
      out.write("\t\t\t\t<!-- 로고 -->\n");
      out.write("\t\t\t\t<div id=\"toplogo\">\n");
      out.write("\t\t\t\t\t<a href=\"/ijw/index.ijw\">\n");
      out.write("\t\t\t\t\t\t<!-- 로고이미지 위치 확정되면 변경 -->\n");
      out.write("\t\t\t\t\t\t<img src=\"./include/img/logo.png\" id=\"sitelogo\">\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<!-- 검색바 -->\n");
      out.write("\t\t\t\t<div id=\"searchbar\">\n");
      out.write("\t\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t\t<!-- 드롭다운 -->\n");
      out.write("\t\t\t\t\t\t<select>\n");
      out.write("\t\t\t\t\t\t\t<option>구매</option>\n");
      out.write("\t\t\t\t\t\t\t<option>판매</option>\n");
      out.write("\t\t\t\t\t\t\t<option>경매</option>\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t<!-- 텍스트필드 -->\n");
      out.write("\t\t\t\t\t\t<div id=\"searchtext\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<!-- 검색버튼 -->\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"검색\" id=\"searchbtn\">\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"btnarea\">\n");

				if(sessionNum!=null&&sessionNum.length()>0){

      out.write("\n");
      out.write("\t\t\t\t\t<a href=\"/ijw/logout.ijw\" class=\"sitebtn\">로그아웃</a>\n");
      out.write("\t\t\t\t\t<a href=\"/ijw/myPage.ijw\" class=\"sitebtn\">마이페이지</a>\n");
      out.write("\t\t\t\t\t<a href=\"#임시\" class=\"sitebtn\">글쓰기</a>\n");
					
				}else{

      out.write("\n");
      out.write("\t\t\t\t\t<a href=\"loginform.ijw\" class=\"sitebtn\">로그인</a>\n");
      out.write("\t\t\t\t\t<a href=\"/ijw/meminsertform.ijw\" class=\"sitebtn\">회원가입</a>\n");

				}

      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- 메뉴 -->\n");
      out.write("\t\t<div id=\"naviarea\">\n");
      out.write("\t\t\t<ul class=\"wrapper\">\n");
      out.write("\t\t\t\t<!-- 메뉴버튼들 -->\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<a href=\"/ijw/generalSList.ijw\">\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\n");
      out.write("\t\t\t\t\t\t\t구매\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<a href=\"/ijw/generalPList.ijw\">\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\n");
      out.write("\t\t\t\t\t\t\t판매\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<a href=\"/ijw/local.ijw\">\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\n");
      out.write("\t\t\t\t\t\t\t동네\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<a href=\"/ijw/auctionList.ijw\">\n");
      out.write("\t\t\t\t\t\t<div class=\"nav_btn\">\n");
      out.write("\t\t\t\t\t\t\t경매\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t</header>\n");
      out.write("\t<!-- 내용 -->\n");
      out.write("\t<div id=\"sitecontent\">\n");
      out.write("\t\t<div class=\"wrapper\">\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t[내용]\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- 하단바 -->\n");
      out.write("<footer id=\"footerarea\">\n");
      out.write("\t<div class=\"wrapper\">\n");
      out.write("\t\t<div>\n");
      out.write("\t\t\t[하단바]\n");
      out.write("\t\t\t<br>아이콘 제작자 :\n");
      out.write("\t\t\t<a href=\"http://www.freepik.com/\" title=\"Freepik\">Freepik</a>\n");
      out.write("\t\t\tfrom\n");
      out.write("\t\t\t<a href=\"https://www.flaticon.com/kr/\" title=\"Flaticon\"> www.flaticon.com</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</footer>\n");
      out.write("</body>\n");
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
