package com.swipe.jobs.domain;

import java.util.List;

public class WorkerMatchedJobs {
	
	private final Worker worker;
	private final List<Job> matchedJobs;
	
	public WorkerMatchedJobs(Worker worker, List<Job> matchedJobs) {
		this.worker = worker;
		this.matchedJobs = matchedJobs;
	}
	
	public Worker getWorker() {
		return worker;
	}

	public List<Job> getMatchedJobs() {
		return matchedJobs;
	}

}
