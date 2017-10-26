package com.niit.collaborate.Dao;

import java.util.List;

import com.niit.collaborate.Model.Job;

public interface JobDAO {

	public boolean createJob(Job job);

	void addJob(Job job);

	List<Job> getAllJobs();

	Job getJob(int jobId);

}
