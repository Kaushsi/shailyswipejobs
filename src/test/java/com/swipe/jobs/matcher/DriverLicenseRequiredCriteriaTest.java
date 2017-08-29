package com.swipe.jobs.matcher;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.Worker;

public class DriverLicenseRequiredCriteriaTest {
 
	@Test
	public void testLicenseRequiredForJobWorkerHasLicense() {
		Worker worker = new Worker();
		worker.setHasDriversLicense(true);
		DriverLicenseRequiredCriteria criteria = new DriverLicenseRequiredCriteria(worker);
		Job job = new Job();
		job.setDriverLicenseRequired(true);
		assertTrue(criteria.test(job));
	}

	@Test
	public void testLicenseNotRequiredWorkerHasLicense() {
		Worker worker = new Worker();
		worker.setHasDriversLicense(true);
		DriverLicenseRequiredCriteria criteria = new DriverLicenseRequiredCriteria(worker);
		Job job = new Job();
		job.setDriverLicenseRequired(false);
		assertTrue(criteria.test(job));
	}
	
	@Test
	public void testLicenseRequiredWorkerHasNoLicense() {
		Worker worker = new Worker();
		worker.setHasDriversLicense(false);
		DriverLicenseRequiredCriteria criteria = new DriverLicenseRequiredCriteria(worker);
		Job job = new Job();
		job.setDriverLicenseRequired(true);
		assertFalse(criteria.test(job));
	}
	
	@Test
	public void testLicenseNotRequiredWorkerHasNotLicense() {
		Worker worker = new Worker();
		worker.setHasDriversLicense(false);
		DriverLicenseRequiredCriteria criteria = new DriverLicenseRequiredCriteria(worker);
		Job job = new Job();
		job.setDriverLicenseRequired(false);
		assertTrue(criteria.test(job));
	}
}

