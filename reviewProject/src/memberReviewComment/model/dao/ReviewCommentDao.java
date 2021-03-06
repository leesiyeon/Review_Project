package memberReviewComment.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import memberReviewComment.model.vo.ReviewComment;

public class ReviewCommentDao {

	public int insertReviewComment(Connection con, int reviewNo, String id, String content) {
		PreparedStatement pstmt = null;
		String query="insert into review_comment values(review_comment_seq.nextval,?,?,?,default)";
		int result = 0;
		
		try{
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			pstmt.setString(2, id);
			pstmt.setString(3, content);
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}

	public ArrayList<ReviewComment> selectReviewComment(Connection con, int reviewNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReviewComment> list = new ArrayList<ReviewComment>();
		ReviewComment comment = null;
		String query = "select * from review_comment where posting_no = ? order by comment_no desc";
		
		try{
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reviewNo); 
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				comment = new ReviewComment();
				comment.setCommentNo(rset.getInt("comment_no"));
				comment.setPostingNo(rset.getInt("posting_no"));
				comment.setId(rset.getString("id"));
				comment.setCommentContent(rset.getString("comment_content"));
				comment.setCommentDate(rset.getDate("comment_date"));
				list.add(comment);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int deleteReviewComment(Connection con, int commentNo, int reviewNo) {
		PreparedStatement pstmt = null;
		String query = "delete from review_comment where comment_no = ? and posting_no = ?";
		int result = 0;
		
		try{
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, commentNo);
			pstmt.setInt(2, reviewNo);
			
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int updateReviewComment(Connection con, int commentNo, int reviewNo, String content) {
		PreparedStatement pstmt = null;
		String query = "update review_comment set comment_content = ? where comment_no = ? and posting_no = ?";
		int result = 0;
		
		try{
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, content);
			pstmt.setInt(2, commentNo);
			pstmt.setInt(3, reviewNo); 
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}

	public ArrayList<ReviewComment> viewReviewComment(Connection con, int postNum) {
		// 리뷰게시판 댓글 불러오는 메서드
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				ArrayList<ReviewComment> list = new ArrayList<ReviewComment>();
				ReviewComment comment = null;
				
				String query ="select comment_no,rc.posting_no,rc.id,comment_content, to_char(comment_date,'yyyy-MM-dd hh24:mi:ss') as comment_date"
						+" from review_comment rc" 
						+" join review_board rb" 
						+" on (rc.posting_no = rb.posting_no)" 
						+" where rc.posting_no=?"
						+" order by comment_date desc";
				
				
				try{
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, postNum);
					pstmt.executeQuery();
					
					rset = pstmt.executeQuery();
					
					if(rset!=null){
						while(rset.next()){
							comment = new ReviewComment(rset.getString("comment_date"));
							comment.setCommentNo(rset.getInt("comment_no"));
							comment.setPostingNo(rset.getInt("posting_no"));
							comment.setId(rset.getString("id"));
							comment.setCommentContent(rset.getString("comment_content"));
							
							
							list.add(comment);
						}
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					close(rset);
					close(pstmt);
				}
			
				return list;
	}

	public int updateComment(Connection con, int postNum, int commentNum, String id, String content) {
		// 댓글 수정
				PreparedStatement pstmt = null;
				int result = 0;
				String query = "update review_comment set comment_content =? where posting_no = ? and comment_no =? and id =?";

				try {

					pstmt = con.prepareStatement(query);
					pstmt.setString(1, content);
					pstmt.setInt(2, postNum);
					pstmt.setInt(3, commentNum);
					pstmt.setString(4, id);

					result = pstmt.executeUpdate();

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}

				return result;
			}

	public int insertComment(Connection con, int postNum, String id, String content) {
		//리뷰게시판 댓글 입력
				PreparedStatement pstmt = null;
				int result =0;
				
				String query = "insert into review_comment values (review_comment_seq.nextval,?,?,?,default)";
				try{
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, postNum);
					pstmt.setString(2, id);
					pstmt.setString(3, content);
					
					result = pstmt.executeUpdate();
					
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					close(pstmt);
				}
				
				return result;
	}

	public int deleteComment(Connection con, int postNum, int commentNum, String id) {
		//리뷰게시판 댓글 삭제
				int result = 0;
				PreparedStatement pstmt = null;
				String query = "delete from review_comment where posting_no=? and comment_no=? and id=?";
				
				try{
					pstmt = con.prepareStatement(query);
					pstmt.setInt(1, postNum);
					pstmt.setInt(2, commentNum);
					pstmt.setString(3, id);
					
					result = pstmt.executeUpdate();
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					close(pstmt);
				}
				
				return result;
	}
	}

