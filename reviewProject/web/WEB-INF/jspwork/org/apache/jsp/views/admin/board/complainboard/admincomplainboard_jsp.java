/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.46
 * Generated at: 2017-10-09 08:09:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.admin.board.complainboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import adminComplainBoard.model.vo.Notice;
import java.util.ArrayList;
import member.model.vo.Member;

public final class admincomplainboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/admin/board/complainboard/../../../../adminheader.jsp", Long.valueOf(1507535898000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("adminComplainBoard.model.vo.Notice");
    _jspx_imports_classes.add("java.util.ArrayList");
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
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
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

ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<!--<link rel=\"icon\" href=\"img/favicon.ico\">-->\r\n");
      out.write("\r\n");
      out.write("<!-- CSS Global -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/styles.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- CSS Plugins -->\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/fonts/font-awesome/css/font-awesome.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/animate.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Google Fonts -->\r\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("<link\r\n");
      out.write("\thref='http://fonts.googleapis.com/css?family=Roboto+Slab:100,300,400,700'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".btn {\r\n");
      out.write("\tbackground: #ff6347;\r\n");
      out.write("\tbackground-image: -webkit-linear-gradient(top, #ff6347, #ff6347);\r\n");
      out.write("\tbackground-image: -moz-linear-gradient(top, #ff6347, #ff6347);\r\n");
      out.write("\tbackground-image: -ms-linear-gradient(top, #ff6347, #ff6347);\r\n");
      out.write("\tbackground-image: -o-linear-gradient(top, #ff6347, #ff6347);\r\n");
      out.write("\tbackground-image: linear-gradient(to bottom, #ff6347, #ff6347);\r\n");
      out.write("\t-webkit-border-radius: 4;\r\n");
      out.write("\t-moz-border-radius: 4;\r\n");
      out.write("\tborder-radius: 4px;\r\n");
      out.write("\tfont-family: Arial;\r\n");
      out.write("\tcolor: #ffffff;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tpadding: 10px 20px 10px 20px;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn:hover {\r\n");
      out.write("\tbackground: #f75234;\r\n");
      out.write("\tbackground-image: -webkit-linear-gradient(top, #f75234, #f75234);\r\n");
      out.write("\tbackground-image: -moz-linear-gradient(top, #f75234, #f75234);\r\n");
      out.write("\tbackground-image: -ms-linear-gradient(top, #f75234, #f75234);\r\n");
      out.write("\tbackground-image: -o-linear-gradient(top, #f75234, #f75234);\r\n");
      out.write("\tbackground-image: linear-gradient(to bottom, #f75234, #f75234);\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write('\r');
      out.write('\n');

	Member member = (Member)session.getAttribute("member");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("<meta charset=utf-8>\r\n");
      out.write("<!--<link rel=\"icon\" href=\"img/favicon.ico\">-->\r\n");
      out.write("\r\n");
      out.write("<!-- CSS Global -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/styles.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- CSS Plugins -->\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/fonts/font-awesome/css/font-awesome.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/animate.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Google Fonts -->\r\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("<link\r\n");
      out.write("\thref='http://fonts.googleapis.com/css?family=Roboto+Slab:100,300,400,700'\r\n");
      out.write("\trel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("@font-face{font-family:'CoreGTM5'; src:url('/review/resources/fonts/CoreGTM5.woff')}\r\n");
      out.write("@font-face{font-family:'CoreGTM5'; src:url('/review/resources/fonts/CoreGTM5.otf.eot')}\r\n");
      out.write("\t\r\n");
      out.write("\tbody, table, div, p, a, h1, h2, h3, button, .header, li a.navbar-brand {\r\n");
      out.write("\tfont-family:'Nanum Gothic';\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write(".header {\r\n");
      out.write("\tpadding-bottom: 60;\r\n");
      out.write("\tmagin: 0;\r\n");
      out.write("\tbackground-image: url(\"/review/resources/img/새싹비빔밥.jpg\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.navi li {\r\n");
      out.write("\tlist-style-type: none;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\twidth: 20em;\r\n");
      out.write("\theight: 3em;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tfont-family: \"Lucida Grande\", sans-serif;\r\n");
      out.write("\tborder-right: 1px white solid;\r\n");
      out.write("\t-webkit-box-shadow: 1px 1px 1px white;\r\n");
      out.write("\t-moz-box-shadow: 1px 1px 1px white;\r\n");
      out.write("\tbox-shadow: 1px 1px 1px white;\r\n");
      out.write("\t/* background-color: #c9c9c9; */\r\n");
      out.write("\tbackground: -webkit-gradient(linear, left top, left bottom, from(tomato),\r\n");
      out.write("\t\tto(tomato));\r\n");
      out.write("\t/* background: -moz-linear-gradient(top, white, #a1a1a1, #848484); */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.navi li a {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tpadding: .8em .5em .5em .5em;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\t/* text-shadow: 1px 1px 0px white; */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.navi li:hover {\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("\tbackground: -webkit-gradient(linear, left top, left bottom, from(white),\r\n");
      out.write("\t\tto(white) /* , color-stop(0.6, #474747) */);\r\n");
      out.write("\t/* background: -moz-linear-gradient(top, #333333, #474747, #4c4c4c); */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul.navi li:hover>a {\r\n");
      out.write("\tcolor: tomato; /* 글자색*/\r\n");
      out.write("\t/* text-shadow: 0px 1px 0px #fff */; /* 텍스트그림자*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 첫번째항목의스타일*/\r\n");
      out.write("ul.navi li {\r\n");
      out.write("\t-webkit-border-top-left-radius: .5em; /* 왼쪽상단코너를부드럽게*/\r\n");
      out.write("\t-moz-border-radius-topleft: .5em;\r\n");
      out.write("\tborder-top-left-radius: .5em;\r\n");
      out.write("\t-webkit-border-bottom-left-radius: .5em; /* 왼쪽하단코너를부드럽게*/\r\n");
      out.write("\t-moz-border-radius-bottomleft: .5em;\r\n");
      out.write("\tborder-bottom-left-radius: .5em;\r\n");
      out.write("\t-webkit-border-top-right-radius: .5em; /*오른쪽상단코너를부드럽게*/\r\n");
      out.write("\t-moz-border-radius-topright: .5em;\r\n");
      out.write("\tborder-top-right-radius: .5em;\r\n");
      out.write("\t-webkit-border-bottom-right-radius: .5em; /* 오른쪽하단코너를부드럽게*/\r\n");
      out.write("\t-moz-border-radius-bottomright: .5em;\r\n");
      out.write("\tborder-bottom-right-radius: .5em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<h1 align=\"center\">\r\n");
      out.write("\t\t");
if(member.getUserType()==1){ 
      out.write("\r\n");
      out.write("  \t\t\t<a href=/review/views/main/main.jsp style=\"text-decoration: none\">Review</a></h1> \t<!-- 회원 -->\r\n");
      out.write("  \t\t");
}else{ 
      out.write("\r\n");
      out.write("\t  \t\t<a href=/review/views/admin/main/adminMain.jsp style=\"text-decoration: none\">Review</a></h1> <!-- 관리자 -->\r\n");
      out.write("  \t\t");
} 
      out.write("\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<ul class=\"topbar-nav topbar-nav_right\">\r\n");
      out.write("\t\t");
if(member != null && member.getUserType()==1){
      out.write("<!-- 회원 -->\r\n");
      out.write("\t\t\t<li><a class=\"navbar-brand\" style=\"color: black;\">");
      out.print(member.getName());
      out.write("회원님 환영합니다.</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"navbar-brand\" style=\"color: black;\" href=\"/review/logout\">Logout</a></li>\r\n");
      out.write("\t\t");
}else if(member !=null && member.getUserType()==0){ 
      out.write("<!-- 관리자 -->\r\n");
      out.write("\t\t\t<li><a class=\"navbar-brand\" style=\"color: black;\">");
      out.print(member.getName());
      out.write(" 관리자님 환영합니다.</a></li>\r\n");
      out.write("\t\t\t<li><a class=\"navbar-brand\" style=\"color: black;\" href=\"/review/logout\">Logout</a></li>\r\n");
      out.write("\t\t");
}else{
      out.write("\t<!-- 비회원 -->\r\n");
      out.write("\t\t\t<li><a class=\"navbar-brand\" style=\"color: black;\" href=\"views/member/login.jsp\">Login</a></li> \r\n");
      out.write("\t\t\t<li><a class=\"navbar-brand\" style=\"color: black;\" href=\"views/member/signup.jsp\">SignUp</a></li>\r\n");
      out.write("\t\t");
}
      out.write(" \r\n");
      out.write("\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");
if(member.getUserType() == 1){ 
      out.write("\r\n");
      out.write("\t\t\t<ul class=\"navi\" style=\"align-self: center;\">\r\n");
      out.write("\t\t\t\t <li><a href=\"/review/views/reviewboard/reviewboard.jsp\">리뷰게시판</a></li>\r\n");
      out.write("\t   <li><a href=\"/review/views/shareboard/shareboard.jsp\">정보공유게시판</a></li>\r\n");
      out.write("\t   <li><a href=\"/review/nlist\">신고게시판</a></li> \r\n");
      out.write("\t   <li><a href=\"/review/views/mypage/member/memberupdateview.jsp\">마이페이지</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t ");
}else{ 
      out.write("\r\n");
      out.write("\t  <ul class=\"navi\" style=\"align-self: center;\">\r\n");
      out.write("\t   <li><a href=\"/review/views/admin/board/reviewboard/adminreviewboard.jsp\">리뷰게시판</a></li>\r\n");
      out.write("\t   <li><a href=\"/review/views/admin/board/shareboard/adminshareboard.jsp\">정보공유게시판</a></li>\r\n");
      out.write("\t   <li><a href=\"/review/views/admin/board/complainboard/admincomplainboard.jsp\">신고게시판</a></li> \r\n");
      out.write("\t   <!-- <li><a href=\"/review/views/admin/memberManagement/memberManagement.jsp\">회원관리</a></li> -->\r\n");
      out.write("\t   <li><a href=\"/review/mlist\">회원관리</a></li> <!-- 관리자 MemberManagementServlet 호출 -->\r\n");
      out.write("\t  </ul>\r\n");
      out.write("  ");
} 
      out.write("\r\n");
      out.write("\t\t\t<!-- STATIC TOPBAR \r\n");
      out.write("    ============================== -->\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div align=\"left\" style=\"margin-left: 10%; margin-right: 10%\">\r\n");
      out.write("\t\t<div align=\"left\">\r\n");
      out.write("\t\t\t<form class=\"form-group\" role=\"form\">\r\n");
      out.write("\t\t\t\t<select class=\"btn\" id=\"findType\"\r\n");
      out.write("\t\t\t\t\tstyle=\"height: 30px; color: #ffffff;\">\r\n");
      out.write("\t\t\t\t\t<option value=\"findByTitle\">제목</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"findByWriter\">작성자</option>\r\n");
      out.write("\t\t\t\t</select> <input style=\"height: 25px; width: 200px;\" type=\"text\"\r\n");
      out.write("\t\t\t\t\tid=\"searchKeyWord\" name=\"searchKeyWord\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"제목 혹은 작성자로 검색 \" class=\"btn2\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<button type=\"button\" id=\"searchSubmit\" value=\"검색\" class=\"btn\"\r\n");
      out.write("\t\t\t\t\tstyle=\"color: #ffffff;\">검색</button>\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp; <a href=\"admincomplainNoticeWrite.jsp\"\r\n");
      out.write("\t\t\t\t\tclass=\"btn\" style=\"color: #ffffff;\">공지작성</a>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<!-- btn-primary class : style.css에 있음 -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--  공지등록 버튼 \t-->\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div align=\"left\" style=\"margin-left: 10%; margin-right: 10%\">\r\n");
      out.write("\t\t<h2>신고게시판</h2>\r\n");
      out.write("\t\t<div class=\"table-responsive\">\r\n");
      out.write("\t\t\t<table class=\"table table-striped table-bordered\">\r\n");
      out.write("\t\t\t\t<caption>불건전한 게시글 신고해주세요</caption>\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"background-color: tomato\">글번호</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"background-color: tomato\">제목</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"background-color: tomato\">작성자</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"background-color: tomato\">작성일</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"background-color: tomato\">조회수</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"background-color: tomato\">비고</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t");

					for (Notice notice : list) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(notice.getPostingNo());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
      out.print(notice.getTitle());
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(notice.getId());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(notice.getPostingDate());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(notice.getHits());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>삭제버튼 만들어야됨</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- / .table-responsive -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- paging -->\r\n");
      out.write("\t\t<div class=\"ui__section\" id=\"ui_pagination\" align=\"center\">\r\n");
      out.write("\t\t\t<nav>\r\n");
      out.write("\t\t\t\t<ul class=\"pagination\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\" aria-label=\"Previous\"><span\r\n");
      out.write("\t\t\t\t\t\t\taria-hidden=\"true\">«</span></a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li class=\"active\"><a href=\"\"> <span class=\"sr-only\">(current)</span></a></li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><a href=\"\" aria-label=\"Next\"><span aria-hidden=\"true\">»</span></a></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- / .ui__section -->\r\n");
      out.write("\t</div>\r\n");
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
