package com.niit.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.Dao.ForumDao;
import com.niit.collaborate.Model.Forum;

@Repository("forumDao")
public class ForumDaoImpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;

	public ForumDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public boolean createForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().save(forum);
			System.out.println("Insert the table");
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

	@Transactional
	@Override
	public Forum getForum(int forumId) {
		return (Forum) sessionFactory.getCurrentSession().get(Forum.class, forumId);
	}

	@Transactional
	@Override
	public List<Forum> getForums() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ForumTable where status='A'");
		List<Forum> listForum=query.list();
		session.close();
	
		return listForum;
}

	@Transactional
	@Override
	public boolean approveForum(Forum forum) {
		try {
			forum.setStatus("A");
			sessionFactory.getCurrentSession().save(forum);	
			System.out.println("Approve");
			return true;
		} catch(Exception e) {
			System.out.println("Exception Arised:"+e); 
			return false;
		}
		

}

	@Transactional
	@Override
	public boolean editForum(int forumId) {
		try
		  {
			
			 
		Session session = sessionFactory.openSession();	
		Forum forum = (Forum)session.get(Forum.class, forumId);
	
	    session.update(forumId);
		 System.out.println("Update the table");
		 session.close();
		 return true;
		  }
		  catch(Exception e) 
		  {
			 System.out.println("Exception Arised:"+e); 
			  return false; 
		  }
	}

	@Transactional
	@Override
	public boolean deleteForum(int forumId) {
		try {  
			Session session = sessionFactory.openSession();
			
			Forum forum = (Forum)session.get(Forum.class, forumId);
	        session.delete(forum);
	        session.flush();
	        session.close();
	        return true;
	      } catch(Exception e) {
				System.out.println("Exception Arised:"+e); 
				return false;
			}
	}
}

