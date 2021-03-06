/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.64
 * Generated at: 2021-06-05 09:28:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.general;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;

public final class generalInsertForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	request.setAttribute("siteTitle", "사자판다 상품등록");

      out.write('\r');
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
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write(".img_container{\r\n");
      out.write("\t height: auto; \r\n");
      out.write("\t border:1px solid #eaeaea; \r\n");
      out.write("\t padding: 0px;\r\n");
      out.write("\t position:static;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"//dapi.kakao.com/v2/maps/sdk.js?appkey=9b4172322671d1cc9e49a261f3c75475&libraries=services\"></script>\r\n");
      out.write("<script src=\"https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar sel_file=null;\r\n");
      out.write("\tvar geocoder = new kakao.maps.services.Geocoder();\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#gphoto\").on(\"change\", handleImgFileSelect);\r\n");
      out.write("\t\t// 탭 선택\r\n");
      out.write("\t\tfunction selectTab(){\r\n");
      out.write("\t\t\t// 기존 선택 제거\r\n");
      out.write("\t\t\t$(\"#btnSaja, #btnPanda\").removeClass(\"tabbtn_sel\");\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t// 탭 선택\r\n");
      out.write("\t\t\t$(this).parent().addClass(\"tabbtn_sel\");\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t// 값 설정\r\n");
      out.write("\t\t\tvar tabSort = $(this).attr(\"data-tab-sort\");\r\n");
      out.write("\t\t\t$(\"#gsort\").val(tabSort);\r\n");
      out.write("\t\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\t$(\"#btnSaja > a\").click(selectTab);\r\n");
      out.write("\t\t$(\"#btnPanda > a\").click(selectTab);\r\n");
      out.write("\t\t$(\"#btnAuction > a\").click(function(){\r\n");
      out.write("\t\t\tif(confirm(\"작성중이던 내용을 버리고 경매글을 작성하시겠습니까?\") == false){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\t});\r\n");
      out.write("\t//숫자 천단위 콤마 형식 생성\r\n");
      out.write("\tfunction inputNumberFormat(obj) {\r\n");
      out.write("\t    obj.value = comma(uncomma(obj.value));\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//천단위 콤마 생성 \r\n");
      out.write("\tfunction comma(str) {\r\n");
      out.write("\t    var regexp = /\\B(?=(\\d{3})+(?!\\d))/g;\r\n");
      out.write("\t    return str.toString().replace(regexp, ',');\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//천단위 콤마 제거\r\n");
      out.write("\tfunction uncomma(str) {\r\n");
      out.write("\t    str = String(str);\r\n");
      out.write("\t    return str.replace(/[^\\d]+/g, '');\r\n");
      out.write("\t}\r\n");
      out.write("\t//현위치 주소 찾기 \r\n");
      out.write("\tfunction getLocation(){\r\n");
      out.write("\t\tconsole.log(\"---------- 현위치로 동 찾기 버튼 클릭 ----------\");\t\r\n");
      out.write("\t\tvar va1=null;\r\n");
      out.write("\t\tvar va2=null;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (navigator.geolocation) {\r\n");
      out.write("\t\t\tconsole.log(\"navigator.geoloaction :: \"+navigator.geolocation);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//watchposition :: 장치의 위치가 바뀔 때마다, 자동으로 새로운 위치를 사용해 호출할 처리기 함수를 등록\r\n");
      out.write("\t\t\tnavigator.geolocation.watchPosition(showPosition);\r\n");
      out.write("\t\t\tconsole.log(\"check >>>> \");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tconsole.log(\"Geolocation is not supported by this browser.\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction showPosition(position) {\r\n");
      out.write("\t\t\tconsole.log(\" 좌표 위도 변환 함수 start !! \");\r\n");
      out.write("\t\t\t//좌표 경도 \r\n");
      out.write("\t\t\tval1 = position.coords.longitude;\r\n");
      out.write("\t\t\t//좌표 위도\r\n");
      out.write("\t\t\tval2 = position.coords.latitude;\r\n");
      out.write("\t\t\tconsole.log(\"val1 >>> \" + val1); \r\n");
      out.write("\t\t\tconsole.log(\"val2 >>> \" + val2);\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tvar callback = function(result, status) {\r\n");
      out.write("\t\t\t\tconsole.log(\"status >>> \" + status);\r\n");
      out.write("\t\t\t\tif (status === kakao.maps.services.Status.OK) {\r\n");
      out.write("\t\t\t\t\t//법정동명\r\n");
      out.write("\t\t\t\t\tconsole.log(\"지역 명칭 : \" + result[0].address_name);\r\n");
      out.write("\t\t\t\t\t//법정동명 코드 (10자리 숫자 코드 2/3/3/2) \r\n");
      out.write("\t\t\t\t\tconsole.log(\"행정구역 코드 : \" + result[0].code);\r\n");
      out.write("\t\t\t\t\tdocument.insertForm.gloc.value = result[0].address_name;\r\n");
      out.write("\t\t\t\t\tdocument.insertForm.gregcode.value = result[0].code;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tgeocoder.coord2RegionCode(val1, val2, callback);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//첨부파일 validation \r\n");
      out.write("\tfunction handleImgFileSelect(e){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar files=e.target.files;\r\n");
      out.write("\t\tvar filesArr=Array.prototype.slice.call(files);\r\n");
      out.write("\t\tvar flag=true;\r\n");
      out.write("\t\tfilesArr.forEach(function(f){\r\n");
      out.write("\t\t\tif(!f.type.match(\"image.*\")){\r\n");
      out.write("\t\t\t\tconsole.log(\"f >>>> \"+f);\r\n");
      out.write("\t\t\t\tconsole.log(\"확장자는 이미지 확장자만 가능\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//이미지 확장자인 경우에만 미리보기 보여주기 \r\n");
      out.write("\t\t\tif(flag){\r\n");
      out.write("\t\t\t\tconsole.log(\"이미지 확장자임 !! \");\r\n");
      out.write("\t\t\t\tsel_file=f;\r\n");
      out.write("\t\t\t\tvar reader=new FileReader();\r\n");
      out.write("\t\t\t\treader.onload=function(e){\r\n");
      out.write("\t\t\t\t\t$(\"#image_container\").attr(\"src\",e.target.result);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treader.readAsDataURL(f);\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tconsole.log(\"이미지 확장자 입력하세요 !!\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t/* 게시글 등록 : generalInsert */\r\n");
      out.write("\tfunction generalInsert(){\r\n");
      out.write("\t\tconsole.log(\"generalInsert 클릭\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tinsertForm.method=\"POST\";\r\n");
      out.write("\t\tinsertForm.enctype = \"multipart/form-data\";\r\n");
      out.write("\t\tinsertForm.action=\"generalInsert.spw\";\r\n");
      out.write("\t\tinsertForm.submit();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* 전체 목록으로 : generalAllList */\r\n");
      out.write("\tfunction generalAllList(){\r\n");
      out.write("\t\t//console.log(\"generalAllList 클릭\");\r\n");
      out.write("\t\tvar sort = $('#gsort').val();\r\n");
      out.write("\t\tif(sort==\"1\"){\r\n");
      out.write("\t\t\tlocation.href=\"/spw/generalSList.spw\";\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tlocation.href=\"/spw/generalPList.spw\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* 주소 찾기 : glocFunc */\r\n");
      out.write("\tfunction glocFunc() {\r\n");
      out.write("       new daum.Postcode({\r\n");
      out.write("           oncomplete: function(data) {\r\n");
      out.write("               // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.\r\n");
      out.write("\r\n");
      out.write("               // 각 주소의 노출 규칙에 따라 주소를 조합한다.\r\n");
      out.write("               // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.\r\n");
      out.write("               var addr = ''; // 주소 변수\r\n");
      out.write("               var extraAddr = ''; // 참고항목 변수\r\n");
      out.write("\r\n");
      out.write("               //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.\r\n");
      out.write("               if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우\r\n");
      out.write("                   addr = data.roadAddress;\r\n");
      out.write("               } else { // 사용자가 지번 주소를 선택했을 경우(J)\r\n");
      out.write("                   addr = data.jibunAddress;\r\n");
      out.write("               }\r\n");
      out.write("\r\n");
      out.write("               // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.\r\n");
      out.write("               if(data.userSelectedType === 'R'){\r\n");
      out.write("                   // 법정동명이 있을 경우 추가한다. (법정리는 제외)\r\n");
      out.write("                   // 법정동의 경우 마지막 문자가 \"동/로/가\"로 끝난다.\r\n");
      out.write("                   if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){\r\n");
      out.write("                       extraAddr += data.bname;\r\n");
      out.write("                   }\r\n");
      out.write("                   // 건물명이 있고, 공동주택일 경우 추가한다.\r\n");
      out.write("                   if(data.buildingName !== '' && data.apartment === 'Y'){\r\n");
      out.write("                       extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);\r\n");
      out.write("                   }\r\n");
      out.write("                   // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.\r\n");
      out.write("                   if(extraAddr !== ''){\r\n");
      out.write("                       extraAddr = ' (' + extraAddr + ')';\r\n");
      out.write("                   }\r\n");
      out.write("                   // 조합된 참고항목을 해당 필드에 넣는다.\r\n");
      out.write("                   /* document.getElementById(\"sample6_extraAddress\").value = extraAddr; */\r\n");
      out.write("               \r\n");
      out.write("               } else {\r\n");
      out.write("                   /* document.getElementById(\"sample6_extraAddress\").value = ''; */\r\n");
      out.write("               }\r\n");
      out.write("\r\n");
      out.write("               // 우편번호와 주소 정보를 해당 필드에 넣는다.\r\n");
      out.write("              /*  document.getElementById('sample6_postcode').value = data.zonecode; */\r\n");
      out.write("               \r\n");
      out.write("               var sido = data.sido; // \r\n");
      out.write("               var sigungu = data.sigungu; // \r\n");
      out.write("               var bname = data.bname; //\r\n");
      out.write("               var fullloc = sido +\" \"+ sigungu +\" \"+ bname\r\n");
      out.write("               \r\n");
      out.write("               document.getElementById(\"gloc\").value = fullloc;\r\n");
      out.write("               document.getElementById(\"gregcode\").value = data.bcode;\r\n");
      out.write("               \r\n");
      out.write("               // 커서를 상세주소 필드로 이동한다.\r\n");
      out.write("               /* document.getElementById(\"sample6_detailAddress\").focus(); */\r\n");
      out.write("           }\r\n");
      out.write("       }).open();\r\n");
      out.write("   }\r\n");
      out.write("\t/* 숫자 천단위 입력 */\r\n");
      out.write("\tfunction numberWithCommas(x) {\r\n");
      out.write("\t    return x.toString().replace(/\\B(?=(\\d{3})+(?!\\d))/g, \",\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("</script>\r\n");
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
      out.write("\r\n");
      out.write("<div class=\"formbox formbox_75\">\r\n");
      out.write("\t<h3>상품 등록</h3>\r\n");
      out.write("\t<!-- 탭 -->\r\n");
      out.write("\t<div class=\"formtab\">\r\n");
      out.write("\t\t");

			// 종류(사자/판다)
			String gsort = "1";
			String genSort= request.getParameter("gsort");

			// 선택 클래스
			String tabselCls = "tabbtn_sel";

			if(genSort != null){
				gsort = genSort;
			}

			// 선택 클래스 설정
			String tab_saja = "";
			String tab_panda = "";
			if("1".equals(gsort)){
				tab_saja = " " + tabselCls;
			}else if("2".equals(gsort)){
				tab_panda = " " + tabselCls;
				
			}
		
      out.write("\r\n");
      out.write("\t\t<div class=\"tabbtn tabbtn_3 tabsaja");
      out.print(tab_saja);
      out.write("\" id=\"btnSaja\">\r\n");
      out.write("\t\t\t<a data-tab-sort=\"1\">사자</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"tabbtn tabbtn_3 tabpanda");
      out.print(tab_panda);
      out.write("\" id=\"btnPanda\">\r\n");
      out.write("\t\t\t<a data-tab-sort=\"2\">판다</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"tabbtn tabbtn_3 tabauction\" id=\"btnAuction\">\r\n");
      out.write("\t\t\t<a href=\"/spw/auctionWrite.spw\">경매</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 폼 -->\r\n");
      out.write("\t<div class=\"formcontent\">\r\n");
      out.write("\t\t<form id=\"insertForm\" name=\"insertForm\">\r\n");
      out.write("\t\t\t<div class=\"formrow\">\r\n");
      out.write("\t\t\t\t<label for=\"gtitle\" class=\"rowlabel\">제목</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"gtitle\" name=\"gtitle\" class=\"sitetxt form_ele_100\" placeholder=\"최대 40자\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"formrow\">\r\n");
      out.write("\t\t\t\t<label for=\"cgnum\" class=\"rowlabel\">카테고리</label>\r\n");
      out.write("\t\t\t\t<select id=\"cgnum\" name=\"cgnum\" class=\"sitetxt form_ele_50\" id=\"form_ele_50\">\r\n");
      out.write("\t\t\t\t\t<option>대분류</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"CG01\">패션잡화</option>                                    \r\n");
      out.write("\t\t\t\t    <option value=\"CG02\">여성의류</option>\r\n");
      out.write("\t\t\t\t    <option value=\"CG03\">남성의류</option>\r\n");
      out.write("\t\t\t\t    <option value=\"CG04\">디지털/가전</option>\r\n");
      out.write("\t\t\t\t    <option value=\"CG05\">도서/티켓/취미/애완</option>\r\n");
      out.write("\t\t\t\t    <option value=\"CG06\">생활/문구/가전/식품</option>\r\n");
      out.write("\t\t\t\t    <option value=\"CG07\">유아동/출산</option>\r\n");
      out.write("\t\t\t\t    <option value=\"CG08\">스포츠/레저</option>\r\n");
      out.write("\t\t\t\t    <option value=\"CG09\">뷰티/미용</option>\r\n");
      out.write("\t\t\t\t    <option value=\"CG10\">기타</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"formrow\">\r\n");
      out.write("\t\t\t\t<label for=\"gloc\" class=\"rowlabel\">거래지역</label>\r\n");
      out.write("\t\t\t\t<div class=\"form_ele_100\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form_ele_100\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" id=\"whereInow\" onclick=\"getLocation()\" value=\"현위치\" class=\"sitebtn\"/> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" onclick=\"glocFunc()\" value=\"주소검색\" class=\"sitebtn\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" id=\"gloc\" name=\"gloc\" placeholder=\"주소\" class=\"sitetxt form_ele_75\"/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"formrow\">\r\n");
      out.write("\t\t\t\t<label for=\"gphoto\" class=\"rowlabel\">사진</label>\r\n");
      out.write("\t\t\t\t<div class=\"form_ele_100\">\r\n");
      out.write("\t\t\t\t\t<img id=\"image_container\" width=\"150\" height=\"150\" class=\"img_container\"></img>\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" name=\"gphoto\" id=\"gphoto\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"formrow\">\r\n");
      out.write("\t\t\t\t<label for=\"gprice\" class=\"rowlabel\">가격</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"gprice\" name=\"gprice\" class=\"sitetxt form_ele_50\" onkeyup=\"inputNumberFormat(this)\">\r\n");
      out.write("\t\t\t\t<span class=\"form_ele_onechar\">원</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"formrow\">\r\n");
      out.write("\t\t\t\t<label for=\"gcontents\" class=\"rowlabel\">설명</label>\r\n");
      out.write("\t\t\t\t<textarea name=\"gcontents\" id=\"gcontents\" class=\"sitetxt form_ele_100\" placeholder=\"2,000자 제한\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- <div class=\"formrow\">\r\n");
      out.write("\t\t\t\t<label for=\"gstatus\" class=\"rowlabel\">판매 상태</label>\r\n");
      out.write("\t\t\t\t<select name=\"gstatus\" id=\"gstatus\" class=\"siteselect form_ele_100\">\r\n");
      out.write("\t\t\t\t    <option value=\"1\">거래중</option>                                    \r\n");
      out.write("\t\t\t\t    <option value=\"2\">거래완료</option>\r\n");
      out.write("\t\t\t\t    <option value=\"3\">거래취소</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div> -->\r\n");
      out.write("\t\t\t<div class=\"formrow formrow_center\">\r\n");
      out.write("\t\t\t\t<!-- 사자/판다 -->\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"gstatus\" id=\"gstatus\" value=\"1\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"gsort\" id=\"gsort\" value=\"");
      out.print(gsort);
      out.write("\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"gregcode\" id=\"gregcode\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"게시글 등록\" class=\"sitebtn\" onclick=\"generalInsert()\">\r\n");
      out.write("\t\t\t\t<input type=\"button\" value=\"목록으로\" class=\"sitebtn\" onclick=\"generalAllList()\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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
