<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="memberReviewBoard.model.vo.ReviewBoard ,java.util.ArrayList, java.sql.Date"%>
<% 
	ArrayList<ReviewBoard> list = (ArrayList<ReviewBoard>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
%>
<!DOCTYPE html>
<html lang="en"> 
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta charset=utf-8>
    <!--<link rel="icon" href="img/favicon.ico">-->
	
	<!-- CSS Global -->
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">

    <!-- CSS Plugins -->
    <link href="${pageContext.request.contextPath}/resources/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/animate.css" rel="stylesheet">

    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Slab:100,300,400,700' rel='stylesheet' type='text/css'>

<!-- <script type="text/javascript" src="/review/js/jquery-3.2.1.min.js">   
 $(document).ready(function() {
	$('#searchSubmit').click(function() {
		var searchKeyWord = $('#searchKeyWord').val(); //검색어 값 받아오기
		if (searchKeyWord == "") {
			alert("검색어를 입력하세요!");
		} else {
			var command = $('#findType').val(); 
			console.log(searchKeyWord);
			location.href = "/review/reviewList?command=" + command + "&searchKeyWord=" + searchKeyWord;
		}
	});  
}); 
</script> -->

<!-- <script type="text/javascript">
	function search(){
		var searchKeyWord = document.getElementById('searchKeyWord').value;
		if(searchKeyWord == ""){
			alert("검색어를 입력하세요");
		}else{
			var command = document.getElementById('findType').value;
			location.href = "/review/reviewList?command="+command+"&searchKeyWord="+searchKeyWord;
		}
	}
</script> -->
</head>
<body>
<%@ include file="../../header.jsp"%>
<br><br>
<div class="row">
		<div class="col-sm-5">    
			<form class="form-inline topbar__search" role="form" action="/review/reviewList">
				<select class="selectpicker" name="findType">
					<option value="findByLocation">지역별</option>
					<option value="findByCategory">카테고리별</option>
				</select>
				<label class="sr-only" for="nav-search">Search</label>
				<input type="text" class="form-control" name="searchKeyWord">
				<button type="submit" id="searchSubmit">
					<i class="fa fa-search"></i>
				</button> 
			</form>
		</div>
</div>

<br>
<h2 class="header">리뷰 게시판</h2> 
<caption>리뷰를 남겨주세요</caption>
<div class="ui__section" id="ui_buttons" align="right">
		<a href="/review/views/reviewboard/reviewboardWriteForm.jsp" class="btn btn-sm btn-primary">글작성</a>
</div>

<!-- PAGE CONTENT
    ============================== -->

<div class="container">
	<!-- Portfolio -->
	<div class="portfolio__items">
	<%for(ReviewBoard r : list){%>
		<div class="cols">
			<div class="col-xs-12 col-sm-4 filter__item filter_modernism">
					<div class="portfolio__item">
						<!-- Image -->
						<div class="portfolio__img">
							<a href="portfolio-item.html"> 
							<img src="${pageContext.request.contextPath}/uploadfile/<%=r.getRenameImageName()%>" alt="Portfolio Image">
							</a>
						</div>
						<!-- Captions -->
						<div class="portfolio__caption">
							<h3 class="portfolio__title">
								<a href="/review/ReviewDetail?no=<%=r.getPosting_no()%>&page=<%=currentPage%>">글제목: <%=r.getTitle()%></a></h3> 
								<div class="portfolio__intro">
								<%if(r.getEvaluation() == 1){%>
									평점: <img src="/review/resources/img/one.PNG"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 2){%>
									평점: <img src="/review/resources/img/2점.PNG"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 3){%>
									평점: <img src="/review/resources/img/3점.PNG"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 4){%>
									평점: <img src="/review/resources/img/4점.PNG"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 5){%>
									평점: <img src="/review/resources/img/5점.PNG"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 6){%>
									평점: <img src="/review/resources/img/6점.PNG"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 7){%>
									평점: <img src="/review/resources/img/7점.PNG"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 8){%>
									평점: <img src="/review/resources/img/8점.PNG"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 9){%>
									평점: <img src="/review/resources/img/9점.PNG"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() ==10){%>
									평점: <img src="/review/resources/img/10점.PNG"> <%=r.getEvaluation()%>점<br>
								<%}%>
								가게명: <%=r.getStoreName()%> 
								</div>
						</div>
					</div>
				</div>
			</div>
		<%}%>
		<!-- / .row -->
	</div>
	<!-- / .portfolio__items -->
</div>

<!-- / .container -->

<!-- paging -->
      <div class="ui__section" id="ui_pagination" align="center">
         <nav>
            <ul class="pagination">
               <!-- 이전페이지 처리 -->
               <%if(currentPage<=1){ %> <!-- 현재 페이지가 1페이지면 이전페이지 못하게 -->
                  <li><span aria-hidden="true">«««</span></li>
               <%}else{ %>   <!-- 현재 페이지가 2페이지면 이전페이지 누룰 수 있음 할 수 있음 -->
                  <li><a href="/review/reviewList?page=<%= currentPage-1 %>" aria-label="Previous"><span
                        aria-hidden="true">«««</span></a></li>   
               <%} %>
               
               <!-- 페이지 보여주기 -->
               <%for(int p = startPage; p<=endPage; p++){ 
                  if(p==currentPage){%>
                     <li class="active"><a><%=p %></a></li>               
                  <%}else{ %> 
                     <li><a href = "/review/reviewList?page=<%=p %>"><%=p %></a></li>
                  <%} %>
               <%} %>
               
               <!-- 다음페이지 처리 -->
               <%if(currentPage>=maxPage){ %>
                  <li><span aria-hidden="true">»»»</span></li>               
               <%}else{ %>
                  <li><a href="/review/reviewList?page=<%= currentPage+1 %>" aria-label="Next">
                     <span aria-hidden="true">»»»</span></a></li>
               <%} %>
            </ul>
         </nav>
      </div>
</body>
</html>