package com.niit.collaborate.Dao;

import java.util.List;

import com.niit.collaborate.Model.BlogComment;

public interface BlogCommentDAO {
	
	public boolean createBlogComment(BlogComment blogComment);
	public boolean approveBlogComment(BlogComment blogComment);
	
	public boolean deleteBlogComment(int ID);
	
	public boolean editBlogComment(int ID);
	
	public BlogComment getBlogComment(int ID);
	
	public List<BlogComment> getBlogComments();


}
