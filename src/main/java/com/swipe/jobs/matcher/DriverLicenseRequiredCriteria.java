package com.swipe.jobs.matcher;

import java.util.function.Predicate;

import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.Worker;

public class DriverLicenseRequiredCriteria implements Predicate<Job>{

	private Worker worker;

	public DriverLicenseRequiredCriteria(Worker worker) {
		this.worker = worker;
	}

	@Override
	public boolean test(Job job) {
		if (job.getDriverLicenseRequired()) {
			return worker.getHasDriversLicense();
		}
		return true;
	}

}
