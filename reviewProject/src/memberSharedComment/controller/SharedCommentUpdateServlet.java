package memberSharedComment.controller;

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

import memberSharedComment.model.service.SharedCommentService;
import memberSharedComment.model.vo.SharedComment;

/**
 * Servlet implementation class SharedCommentUpdateServlet
 */
@WebServlet("/smupdate.do")
public class SharedCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SharedCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		int sharedNo = Integer.parseInt(request.getParameter("sNo"));
		int commentNo = Integer.parseInt(request.getParameter("cNo"));
		String content = request.getParameter("scontent");
		
		System.out.println(sharedNo);
		System.out.println(commentNo);
		System.out.println(content);
		 
		SharedCommentService service= new SharedCommentService();
		
		int result = service.updateSharedComment(commentNo,sharedNo,content); 
		
		ArrayList<SharedComment> list = null;
		
		if(result > 0){
			list = service.sharedCommentList(sharedNo);
		}
		
		JSONObject job = new JSONObject();
		JSONArray jarr = new JSONArray(); 
		
		for(SharedComment comment : list){
			JSONObject j = new JSONObject(); 
			
			j.put("commentNo", comment.getCommentNo());
			j.put("postingNo", comment.getPostingNo()); 
			j.put("userId", URLEncoder.encode(comment.getId(),"UTF-8"));
			j.put("content",(comment.getCommentContent().replaceAll("\n", "<br>")));
			
			//Date from = new Date(); 
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String to = transFormat.format(comment.getCommentDate());
			j.put("timePosted", to);
			
			jarr.add(j);
		}
		
		job.put("list",jarr);
		System.out.println("job : " +job.toJSONString()); 
		PrintWriter pw = response.getWriter();
		pw.print(job.toJSONString());
		pw.flush();
		pw.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}