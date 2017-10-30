package memberReviewComment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import memberReviewComment.model.service.ReviewCommentService;
import memberReviewComment.model.vo.ReviewComment;

/**
 * Servlet implementation class updateReviewCommentServlet
 */
@WebServlet("/updateReviewCommentAjax")
public class updateReviewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateReviewCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 댓글 수정을 위한 서블릿
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; utf-8");
						
				int postNum = Integer.parseInt(request.getParameter("postNum"));
				int commentNum = Integer.parseInt(request.getParameter("commentNum"));
				String id = request.getParameter("id");
				String content = request.getParameter("content");
						
				new ReviewCommentService().updateComment(postNum,commentNum,id,content);
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
