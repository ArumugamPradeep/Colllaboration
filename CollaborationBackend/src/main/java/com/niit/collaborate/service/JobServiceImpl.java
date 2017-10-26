package com.niit.collaborate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.collaborate.Dao.JobDAO;
import com.niit.collaborate.Model.Job;

@Service

public class JobServiceImpl implements JobService {

	@Autowired
	private JobDAO jobDAO;

	@Override
	public void addJob(Job job) {
		jobDAO.addJob(job);

	}

	@Override
	public List<Job> getAllJobs() {

		return jobDAO.getAllJobs();
	}

	@Override
	public Job getJob(int jobId) {
		return jobDAO.getJob(jobId);
	}

}
