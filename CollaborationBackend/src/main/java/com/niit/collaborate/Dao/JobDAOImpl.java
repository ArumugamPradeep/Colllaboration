package com.niit.collaborate.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.Model.Job;

@Repository("jobDAO")

public class JobDAOImpl implements JobDAO {

	@Override
	public boolean createJob(Job job) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addJob(Job job) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Job getJob(int jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
