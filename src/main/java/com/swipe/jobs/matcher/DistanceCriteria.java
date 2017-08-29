package com.swipe.jobs.matcher;

import java.util.function.Predicate;

import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.JobSearchAddress;
import com.swipe.jobs.domain.Location;
import com.swipe.jobs.domain.Worker;
import com.swipe.jobs.utils.DistanceCalculatorUtil;

public class DistanceCriteria implements Predicate<Job>{

	private Worker worker;

	public DistanceCriteria(Worker worker) {
		this.worker = worker;
	}

	@Override
	public boolean test(Job job) {
		
		double distanceFromJob = getDistanceFromJob(job);
		return distanceFromJob <= worker.getJobSearchAddress().getMaxJobDistance() ;
	}

	private double getDistanceFromJob(Job job) {
		JobSearchAddress jobSearchAddress = worker.getJobSearchAddress();
		Location jobLocation = job.getLocation();
		return DistanceCalculatorUtil.getDistanceFromLatLonInKm(Double.valueOf(jobSearchAddress.getLatitude()),
				                                                Double.valueOf(jobSearchAddress.getLongitude()),
				                                                Double.valueOf(jobLocation.getLatitude()),
				                                                Double.valueOf(jobLocation.getLongitude()));
	}

}
