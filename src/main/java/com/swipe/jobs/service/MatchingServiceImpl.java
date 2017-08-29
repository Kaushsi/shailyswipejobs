package com.swipe.jobs.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.Worker;
import com.swipe.jobs.domain.WorkerMatchedJobs;
import com.swipe.jobs.matcher.AvailabilityCriteria;
import com.swipe.jobs.matcher.DistanceCriteria;
import com.swipe.jobs.matcher.DriverLicenseRequiredCriteria;
import com.swipe.jobs.matcher.RequiredCertificatesCriteria;

@Service
public class MatchingServiceImpl implements MatchingService {

	@Override
	public WorkerMatchedJobs getMatchingJobForWorker(Worker worker, List<Job> jobs, int maxResult) {
		Optional<Predicate<Job>> allCriterias = matchingCriterias(worker).stream().reduce(Predicate :: and);
		
		List<Job> topMatchedJobs = jobs.stream().filter(allCriterias.get()).limit(maxResult).collect(Collectors.toList());
		return new WorkerMatchedJobs(worker, topMatchedJobs);
	}
	
	private List<Predicate<Job>> matchingCriterias(Worker worker) {
		List<Predicate<Job>> criterias = Arrays.asList(new DriverLicenseRequiredCriteria(worker), 
				                                       new RequiredCertificatesCriteria(worker),
				                                       new AvailabilityCriteria(worker),
				                                       new DistanceCriteria(worker));
		return criterias;
	}

}
