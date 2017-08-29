package com.swipe.jobs.service;

import java.util.List;

import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.Worker;
import com.swipe.jobs.domain.WorkerMatchedJobs;

public interface MatchingService {
	
	WorkerMatchedJobs getMatchingJobForWorker(Worker worker, List<Job> jobs, int maxResult); 

}
