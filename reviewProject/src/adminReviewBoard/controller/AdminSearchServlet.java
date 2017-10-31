package adminReviewBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminReviewBoard.model.service.ReviewBoardService;
import memberReviewBoard.model.vo.ReviewBoard;

/**
 * Servlet implementation class AdminSearchServlet
 */
@WebServlet("/adminSearch")
public class AdminSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//검색 서블릿
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String searchLocation = request.getParameter("searchLocation");
		String searchCategory = request.getParameter("searchCategory");
		String storeName = request.getParameter("storeName");
		
		System.out.println("장소검색 : " + searchLocation + " 장소검색 길이 : " + searchLocation.length());
		System.out.println("카테고리 검색  : " + searchCategory);
		
		int listCount =0;
		
		int currentPage =Integer.parseInt(request.getParameter("page"));
		
		int limit = 9;
						
		ReviewBoardService rservice = new ReviewBoardService();
		ArrayList<ReviewBoard> list = new ArrayList<ReviewBoard>();
		
		if(searchLocation.length()==0){	//서울특별시... 없고 식당/카페/교통/숙박 으로 검색한 경우
			listCount = rservice.getSearchByCategoryCount(searchCategory,storeName);
			list = rservice.getSearchByCategoryList(currentPage,limit,searchCategory,storeName);System.out.println("장소 검색 카운트 : " + listCount);
			System.out.println("장소 검색 리스트 : " + list);
						
		}else if(searchCategory.length()==0){ //서울특별시...로 검색한 경우
			listCount = rservice.getSearchByLocationCount(searchLocation,storeName);
			list = rservice.getSearchByLocationList(currentPage,limit,searchLocation, storeName);
			
			System.out.println("카테고리 검색 카운트 : " + listCount);
			System.out.println("카테고리 검색 리스트 : " + list);
		
		}else{ //둘다 선택하고 검색한 경우
			listCount = rservice.getSearchAllCount(searchCategory,searchLocation,storeName);
			list = rservice.getSearchByAllList(currentPage,limit,searchCategory, searchLocation,storeName);
			System.out.println("둘다 검색 카운트 : " + listCount);
			System.out.println("둘다 검색 리스트 : " + list);
			
		}		
		
		int maxPage = (int)((double)listCount/limit + 0.9);
		
		int startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
	
		int endPage = startPage + limit - 1;
		
		if(maxPage < endPage){
			endPage = maxPage;
		}
			
		if(list!=null){
			RequestDispatcher view = request.getRequestDispatcher("views/admin/board/reviewboard/adminreviewboard.jsp");
			request.setAttribute("list", list);
			request.setAttribute("listCount", listCount);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("maxPage", maxPage);
			
			request.setAttribute("searchLocation", searchLocation);
			request.setAttribute("searchCategory", searchCategory);
			request.setAttribute("storeName", storeName);
			
			view.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
