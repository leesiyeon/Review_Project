package memberReviewComment.model.vo;

import java.sql.Date;

public class ReviewComment implements java.io.Serializable{
	private int commentNo;
	private int postingNo;
	private String id;
	private String commentContent;
	private Date commentDate;
	
	public ReviewComment(){
		
	}

	public ReviewComment(int commentNo, int postingNo, String id, String commentContent, Date commentDate) {
		super();
		this.commentNo = commentNo;
		this.postingNo = postingNo;
		this.id = id;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getPostingNo() {
		return postingNo;
	}

	public void setPostingNo(int postingNo) {
		this.postingNo = postingNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "SharedComment [commentNo=" + commentNo + ", postingNo=" + postingNo + ", id=" + id + ", commentContent="
				+ commentContent + ", commentDate=" + commentDate + "]";
	}
	
}