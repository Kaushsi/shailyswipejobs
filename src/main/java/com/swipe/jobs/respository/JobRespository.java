package com.swipe.jobs.respository;

import java.util.List;

import com.swipe.jobs.domain.Job;

public interface JobRespository {
	
	List<Job> findAll();

}
