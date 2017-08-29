package com.swipe.jobs.matcher;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.JobSearchAddress;
import com.swipe.jobs.domain.Location;
import com.swipe.jobs.domain.Worker;

public class DistanceCriteriaTest {
	
	
	@Test
	public void testJobDistanceIsWithinLimit() {
		
		Worker worker = new Worker();
		JobSearchAddress jobSearchAddress = new JobSearchAddress("km", 30, "13.971284", "49.782281");
		worker.setJobSearchAddress(jobSearchAddress);
		
		
		DistanceCriteria criteria =  new DistanceCriteria(worker);
		
		Job job = new Job();
		Location location = new Location();
		location.setLongitude("14.198133");
		location.setLatitude("49.769937");
		job.setLocation(location);
		
		assertTrue(criteria.test(job));
	}
	
	@Test
	public void testJobDistanceIsNotWithinLimit() {
		
		Worker worker = new Worker();
		JobSearchAddress jobSearchAddress = new JobSearchAddress("km", 30, "13.971284", "49.782281");
		worker.setJobSearchAddress(jobSearchAddress);
		
		
		DistanceCriteria criteria =  new DistanceCriteria(worker);
		
		Job job = new Job();
		Location location = new Location();
		location.setLongitude("13.810606");
		location.setLatitude("50.091271");
		job.setLocation(location);

		assertFalse(criteria.test(job));
	}

}
