package com.swipe.jobs.matcher;

import java.util.function.Predicate;

import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.Worker;

public class RequiredCertificatesCriteria implements Predicate<Job> {
	
	private Worker worker;

	public RequiredCertificatesCriteria(Worker worker) {
          this.worker  = worker;
	}

	@Override
	public boolean test(Job job) {
		return worker.getCertificates().containsAll(job.getRequiredCertificates());
	}

}
