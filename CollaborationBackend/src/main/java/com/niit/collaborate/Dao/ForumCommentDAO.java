package com.niit.collaborate.Dao;

import java.util.List;

import com.niit.collaborate.Model.ForumComment;

public interface ForumCommentDAO {
	
	public boolean createForumComment(ForumComment forumComment);
	public boolean approveForumComment(ForumComment forumComment);
	
	public boolean deleteForumComment(int ID);
	
	public boolean editForumComment(int ID);
	
	public ForumComment getForumComment(int ID);
	
	public List<ForumComment> getForumComments();
	


}
