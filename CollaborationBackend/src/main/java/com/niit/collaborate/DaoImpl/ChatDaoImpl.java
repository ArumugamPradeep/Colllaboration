package com.niit.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.Dao.ChatDao;
import com.niit.collaborate.Model.Chat;

@Repository("chatDao")

public class ChatDaoImpl implements ChatDao {

	@Autowired
	SessionFactory sessionFactory;

	public ChatDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public boolean createChat(Chat chat) {
		try {
			sessionFactory.getCurrentSession().save(chat);
			System.out.println("Insert the table");
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

	@Transactional
	@Override
	public Chat getChat(int chatId) {
		return (Chat) sessionFactory.getCurrentSession().get(Chat.class, chatId);
	}

	@Transactional
	@Override
	public List<Chat> getChats() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ChatTable where status='A'");
		List<Chat> listChat = query.list();
		session.close();

		return listChat;
	}

	@Transactional
	@Override
	public boolean approveChat(Chat chat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public boolean editChat(int chatId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public boolean deleteChat(int chatId) {
		try {
			Session session = sessionFactory.openSession();

			Chat chat = (Chat) session.get(Chat.class, chatId);
			session.delete(chat);
			session.flush();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
			return false;
		}
	}

}
