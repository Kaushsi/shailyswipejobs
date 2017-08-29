package com.swipe.jobs.matcher;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.swipe.jobs.domain.Availability;
import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.Worker;

public class AvailabilityCriteriaTest {
	
	private AvailabilityCriteria criteria;
	
	@Before
	public void setUp() {
		Worker worker = new Worker();
		List<Availability> availability= new ArrayList<>();
		availability.add(new Availability("Monday", 1));
		availability.add(new Availability("Tuesday", 2));
		availability.add(new Availability("Thursday", 4));
		availability.add(new Availability("Sunday", 7));
		availability.add(null);
		availability.add(null);
		availability.add(null);
		
		worker.setAvailability(availability);
		criteria =  new AvailabilityCriteria(worker);
		
	}

	@Test
	public void testWorkerCanStartJob() {
		
		Job job = new Job();
		job.setStartDate("2015-11-08T12:56:53.087Z");
		
		assertTrue(criteria.test(job));
	}

	@Test
	public void testWorkerIsNotAvailableToStartJob() {
		
		Job job = new Job();
		job.setStartDate("2015-11-07T12:56:53.087Z");
		
		assertFalse(criteria.test(job));
	}

}
