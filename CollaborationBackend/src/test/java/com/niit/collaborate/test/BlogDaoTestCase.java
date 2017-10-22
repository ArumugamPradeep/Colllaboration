package com.niit.collaborate.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.Dao.BlogDao;
import com.niit.collaborate.Model.Blog;

public class BlogDaoTestCase {

	static BlogDao blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext = new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit.collaborate");
		annotationConfigAppContext.refresh();
		
		blogDAO = (BlogDao)annotationConfigAppContext.getBean("blogDAO");
	}
	
	@Ignore
	@Test
	public void createBlogTest()
	{
		Blog blog = new Blog();
		
		blog.setBlogId(1001);
		blog.setBlogName("selenium");
		blog.setBlogContent("selenium is a testing tool");
		blog.setUserid("pradeep@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		
		assertTrue("Problem in Blog creation",blogDAO.createBlog(blog));
		
		
	}

	@Ignore
	@Test
	public void approveBlogTest() {
		
		Blog blog = new Blog();
		
		blog.setBlogId(1001);
		blog.setBlogName("selenium");
		blog.setBlogContent("selenium is a testing tool");
		blog.setUserid("pradeep@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		
		assertTrue("Problem in Blog creation",blogDAO.approveBlog(blog));
		
	}
	@Ignore
	@Test
	public void getAllApprovedBlogTest() 
	{
		
		List<Blog> listBlog=blogDAO.getBlogs();
		assertTrue("No Approved Blogs", listBlog.size()>0);
	}
	
	@Test
	public void deleteBlogTest() {
		assertTrue("problem in deleting", blogDAO.deleteBlog(1001));
		
	}
	
	

	/*
	 * @Test public void test() { fail("Not yet implemented"); }
	 */
}
