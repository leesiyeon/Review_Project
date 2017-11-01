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
   
   
   String location = (String)request.getAttribute("location");
   if(location == null){
      location = "";
   }
   String category = (String)request.getAttribute("category");
   if(category == null){
      category = "";
   }
   String searchKeyWord = (String)request.getAttribute("searchKeyWord");
   if(searchKeyWord == null){
      searchKeyWord = "";
   }
   
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

 <style type="text/css">
 	.stylish-input-group .input-group-addon {
	background: white !important;
}

.stylish-input-group .form-control {
	border-right: 0;
	box-shadow: 0 0 0;
	border-color: #ccc;
}

.stylish-input-group button {
	border: 0;
	background: transparent;
}

.btn {
	background: #4D81B0;
	background-image: -webkit-linear-gradient(top, #4D81B0, #4D81B0);
	background-image: -moz-linear-gradient(top, #4D81B0, #4D81B0);
	background-image: -ms-linear-gradient(top, #4D81B0, #4D81B0);
	background-image: -o-linear-gradient(top, #4D81B0, #4D81B0);
	background-image: linear-gradient(to #4D81B0, #4D81B0, #4D81B0);
	-webkit-border-radius: 4;
	-moz-border-radius: 4;
	border-radius: 4px;
	font-family: Arial;
	color: #ffffff;
	font-size: 20px;
	padding: 10px 20px 10px 20px;
	text-decoration: none;
}

.btn:hover {
	background: #C2D6E9;
	background-image: -webkit-linear-gradient(top, #C2D6E9, #C2D6E9);
	background-image: -moz-linear-gradient(top, #C2D6E9, #C2D6E9);
	background-image: -ms-linear-gradient(top, #C2D6E9, #C2D6E9);
	background-image: -o-linear-gradient(top, #C2D6E9, #C2D6E9);
	background-image: linear-gradient(to bottom, #C2D6E9, #C2D6E9);
	text-decoration: none;
}
 
 </style>

</head>
<body>
<%@ include file="../../header.jsp"%>
<script type=text/javascript>

function inputPleaseMessage(){
   if($("#searchsearchKeyWord").val()==""){
      alert("검색할 장소를 입력해 주세요");
      return false;
   }
}
</script>
<br>
<div align="left" style="margin-left: 10%; margin-right:10%">
	
	<form class="form-inline topbar__search" role="form" action="/review/reviewSearchList" onsubmit="return inputPleaseMessage();">
				<div style="float: left; width: 12%;">    
					<input type = "hidden" name="page" value=<%=currentPage %>>
					
				
					<select class="btn" id="findLocationType" name="location" style="color: white">
						<option value="">지역별</option>
						<option value="서울특별시">서울특별시</option>
						<option value="부산광역시">부산광역시</option>
						<option value="대구광역시">대구광역시</option>
						<option value="인천광역시">인천광역시</option>
						<option value="광주광역시">광주광역시</option>
						<option value="대전광역시">대전광역시</option>
						<option value="울산광역시">울산광역시</option>
						<option value="경기도">경기도</option>
						<option value="제주도">제주도</option>
						
					</select> 
					
					</div>
					<div style="float: left; width: 12%;">
					<select class="btn" id="findCategoryType" name="category" style="color: white">
						<option value="">카테고리별</option>
						<option value="식당">식당</option>
						<option value="카페">카페</option>
						<option value="교통">교통</option>
						<option value="숙박">숙박</option>
					</select> 
				</div>
			
				<div class="col-lg-16" align ="right"> 			
					<div align="left" style="margin-left: 20%; margin-right: 0%">
						<div class="input-group stylish-input-group">
							<input type="text" class="form-control" placeholder="가게 이름 검색" name="searchKeyWord" id="searchsearchKeyWord">
							<span class="input-group-addon">
								<button type="submit">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>
					</div>
				</div>
			</form>
			
	<br>
	<h2>리뷰 게시판</h2> 
		<div>
			<caption>회원님의 소중한 리뷰를 남겨주세요</caption>
		
			<div id="ui_buttons" align="left">
    	  		<a href="/review/views/reviewboard/reviewboardWriteForm.jsp" class="btn" style="background:red; color: white">글작성</a>
			</div>
		</div>	
</div>
<hr>



<!-- PAGE CONTENT
    ============================== -->
<div class="container" align="left" style="margin-left:8%; margin-right:10%">
	<!-- Portfolio -->
	<div class="portfolio__items">
	
	<%for(ReviewBoard r : list){ %>
		<div class="cols">
			<div class="col-xs-12 col-sm-4 filter__item filter_modernism">
					<div class="portfolio__item">
						<!-- Image -->
						<div class="portfolio__img">
							<a> 
							<img src="${pageContext.request.contextPath}/uploadfile/<%=r.getRenameImageName() %>" alt="Portfolio Image" width="350px" height="300px">
							</a>
						</div>
						<!-- Captions -->
						<div class="portfolio__caption">
							<h3 class="portfolio__title">
								<a href="/review/adminReviewDetail?postNo=<%=r.getPosting_no()%>&page=<%=currentPage%>"><font color="red"><%=r.getTitle() %></font></a>
								
							</h3>  
							
								<div class="portfolio__intro">
								<%if(r.getEvaluation() == 1){%>
									평점 : <img src="/review/resources/img/one.PNG" width="100px" height="25px"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 2){%>
									평점 : <img src="/review/resources/img/2점.PNG" width="100px" height="25px"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 3){%>
									평점 : <img src="/review/resources/img/3점.PNG" width="100px" height="25px"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 4){%>
									평점 : <img src="/review/resources/img/4점.PNG" width="100px" height="25px"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 5){%>
									평점 : <img src="/review/resources/img/5점.PNG" width="100px" height="25px"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 6){%>
									평점 : <img src="/review/resources/img/6점.PNG" width="100px" height="25px"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 7){%>
									평점 : <img src="/review/resources/img/7점.PNG" width="100px" height="25px"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 8){%>
									평점 : <img src="/review/resources/img/8점.PNG" width="100px" height="25px"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() == 9){%>
									평점 : <img src="/review/resources/img/9점.PNG" width="100px" height="25px"> <%=r.getEvaluation()%>점<br>
								<%}else if(r.getEvaluation() ==10){%>
									평점 : <img src="/review/resources/img/10점.PNG" width="100px" height="25px"> <%=r.getEvaluation()%>점<br>
								<%}%>
								가게명 : <%=r.getStoreName()%> <br>	
								지역 : <%=r.getLocation() %>	<br>
								카테고리 : <%=r.getCategory() %> <br>
								작성자 :<%=r.getId() %>
							
								</div>
						</div>
					</div>
				</div>
			</div> 
			<%} %>
		<!-- / .row -->
	</div>
	<!-- / .portfolio__items -->
</div>
<!-- / .container -->

	<!-- paging -->
	<%if(location.trim()=="" && category.trim()=="" &&searchKeyWord.trim()==""){ %>
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
                  <li><a href="/review/reviewList?page=<%=currentPage+1%>" aria-label="Next">
                     <span aria-hidden="true">»»»</span></a></li>
               <%} %>
            </ul>
         </nav>
      </div>           
      <!-- 장소 검색한경우 paging -->
      <%}else if(location.trim() !="" && category.trim() == "" && searchKeyWord.trim()!=""){%>	<!-- 로케이션으로 검색 -->
     
      <div class="ui__section" id="ui_pagination" align="center">
         <nav>
            <ul class="pagination">
               <!-- 이전페이지 처리 -->
               <%if(currentPage<=1){ %> <!-- 현재 페이지가 1페이지면 이전페이지 못하게 -->
                  <li><span aria-hidden="true">«««</span></li>
               <%}else{ %>   <!-- 현재 페이지가 2페이지면 이전페이지 누룰 수 있음 할 수 있음 -->
                  <li><a href="/review/reviewSearchList?page=<%= currentPage-1 %>&location=<%=location%>&searchKeyWord=<%=searchKeyWord%>" aria-label="Previous"><span
                        aria-hidden="true">«««</span></a></li>   
               <%} %>
               
               <!-- 페이지 보여주기 -->
               <%for(int p = startPage; p<=endPage; p++){ 
                  if(p==currentPage){%>
                     <li class="active"><a><%=p %></a></li>               
                  <%}else{ %> 
                     <li><a href = "/review/reviewSearchList?page=<%=p %>&location=<%=location%>&searchKeyWord=<%=searchKeyWord%>"><%=p %></a></li>
                  <%} %>
               <%} %>
               
               <!-- 다음페이지 처리 -->
               <%if(currentPage>=maxPage){ %>
                  <li><span aria-hidden="true">»»»</span></li>               
               <%}else{%>
                  <li><a href="/review/reviewSearchList?page=<%=currentPage+1%>&location=<%=location %>&searchKeyWord=<%=searchKeyWord %>" aria-label="Next">
                     <span aria-hidden="true">»»»</span></a></li>
               <%} %>
            </ul>
         </nav>
      </div>      
      <!-- 카테고리 검색 -->
      <%}else if(location.trim() =="" && category.trim() != "" && searchKeyWord.trim()!=""){ %>
      	 <div class="ui__section" id="ui_pagination" align="center">
         <nav>
            <ul class="pagination">
               <!-- 이전페이지 처리 -->
               <%if(currentPage<=1){ %> <!-- 현재 페이지가 1페이지면 이전페이지 못하게 -->
                  <li><span aria-hidden="true">«««</span></li>
               <%}else{ %>   <!-- 현재 페이지가 2페이지면 이전페이지 누룰 수 있음 할 수 있음 -->
                  <li><a href="/review/reviewSearchList?page=<%= currentPage-1 %>&category=<%=category %>&searchKeyWord=<%=searchKeyWord %>" aria-label="Previous"><span
                        aria-hidden="true">«««</span></a></li>   
               <%} %>
               
               <!-- 페이지 보여주기 -->
               <%for(int p = startPage; p<=endPage; p++){ 
                  if(p==currentPage){%>
                     <li class="active"><a><%=p %></a></li>               
                  <%}else{ %> 
                     <li><a href = "/review/reviewSearchList?page=<%=p %>&category=<%=category%>&searchKeyWord=<%=searchKeyWord%>"><%=p %></a></li>
                  <%} %>
               <%} %>
               
               <!-- 다음페이지 처리 -->
               <%if(currentPage>=maxPage){%>
                  <li><span aria-hidden="true">»»»</span></li>               
               <%}else{ System.out.println("다음페이지 넘어가는"+location);%>
                  <li><a href="/review/reviewSearchList?page=<%=currentPage+1%>&category=<%=category%>&searchKeyWord=<%=searchKeyWord %>" aria-label="Next">
                     <span aria-hidden="true">»»»</span></a></li>
               <%} %>
            </ul>
         </nav>
      </div>      
      <!-- 둘다검색 -->
      <%}else if(location.trim() !="" && category.trim() != "" && searchKeyWord.trim()!=""){ %>
      	 <div class="ui__section" id="ui_pagination" align="center">
         <nav>
            <ul class="pagination">
               <!-- 이전페이지 처리 -->
               <%if(currentPage<=1){ %> <!-- 현재 페이지가 1페이지면 이전페이지 못하게 -->
                  <li><span aria-hidden="true">«««</span></li>
               <%}else{ %>   <!-- 현재 페이지가 2페이지면 이전페이지 누룰 수 있음 할 수 있음 -->
                  <li><a href="/review/reviewSearchList?page=<%= currentPage-1 %>&location=<%=location%>&category=<%=category%>&searchKeyWord=<%=searchKeyWord %>" aria-label="Previous"><span
                        aria-hidden="true">«««</span></a></li>   
               <%} %>
               
               <!-- 페이지 보여주기 -->
               <%for(int p = startPage; p<=endPage; p++){ 
                  if(p==currentPage){%>
                     <li class="active"><a><%=p %></a></li>               
                  <%}else{ %> 
                     <li><a href = "/review/reviewSearchList?page=<%=p %>&location=<%=location%>&category=<%=category%>&searchKeyWord=<%=searchKeyWord%>"><%=p %></a></li>
                  <%} %>
               <%} %>
               
               <!-- 다음페이지 처리 -->
               <%if(currentPage>=maxPage){%>
                  <li><span aria-hidden="true">»»»</span></li>               
               <%}else{%>
                  <li><a href="/review/reviewSearchList?page=<%=currentPage+1%>&location=<%=location %>&category=<%=category%>&searchKeyWord=<%=searchKeyWord %>" aria-label="Next">
                     <span aria-hidden="true">»»»</span></a></li>
               <%} %>
            </ul>
         </nav>
      </div>      
      <%} %>
      

      <%@ include file="../../footer.jsp"%>
</body>
</html>