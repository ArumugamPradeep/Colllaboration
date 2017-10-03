package com.niit.collaborate.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.Dao.UserFormDao;
import com.niit.collaborate.Model.UserForm;

@Repository("userDao")
@Transactional

public class UserFormDaoImpl implements UserFormDao {

	@Autowired
	SessionFactory sessionFactory;
	
	/*public UserDaoImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory=sessionFactory;
	}
	*/
	
	@Override
	public boolean createUserForm(UserForm userForm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserForm getUserForm(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserForm> getUserForms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveUserForm(UserForm userForm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editUserForm(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserForm(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
