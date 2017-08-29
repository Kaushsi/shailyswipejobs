package com.swipe.jobs.matcher;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.Worker;

public class RequiredCertificatesCriteriaTest {
	
	private RequiredCertificatesCriteria criteria;
	
	
	@Before
	public void setUp() {
		Worker worker = new Worker();
		worker.setCertificates(Arrays.asList("certificate1", "certificate2", "certificate3"));
		criteria = new RequiredCertificatesCriteria(worker);
	}
	
	
	@Test
	public void testWorkerContainsAllRequiredCertifcatesForJob() {
		
		Job job = new Job();
		job.setRequiredCertificates(Arrays.asList("certificate1", "certificate2", "certificate3"));
		assertTrue(criteria.test(job));
	}
	
	@Test
	public void testWorkerDoesNotContainsAllRequiredCertifcatesForJob() {
		
		Job job = new Job();
		job.setRequiredCertificates(Arrays.asList("certificate1", "certificate2", "certificate4"));
		assertFalse(criteria.test(job));
	}

}
