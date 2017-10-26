package com.niit.collaborate.service;

import java.util.List;

import com.niit.collaborate.Model.Job;

public interface JobService {

	void addJob(Job job);

	List<Job> getAllJobs();

	Job getJob(int jobId);

}
