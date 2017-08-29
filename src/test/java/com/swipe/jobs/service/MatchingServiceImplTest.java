package com.swipe.jobs.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.Worker;
import com.swipe.jobs.domain.WorkerMatchedJobs;
import com.swipe.jobs.respository.JobRespository;
import com.swipe.jobs.respository.WorkersRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties
public class MatchingServiceImplTest {
	
	@Autowired
	private JobRespository jobRepository;
	@Autowired
	private MatchingService service;
	@Autowired
	private WorkersRepository workersRepository;
	private List<Job> allJobs;
	
	@Before
	public void setUp() {
		allJobs = jobRepository.findAll();
	}


	@Test
	public void testReturnTopThreeJobMatchForWorker() {
		Optional<Worker> worker = workersRepository.findByWorkerById("562f6647410ecd6bf49146e9");
		assertTrue(worker.isPresent());
		int maxResult = 3;
		WorkerMatchedJobs matchingJobForWorker = service.getMatchingJobForWorker(worker.get(), allJobs, maxResult);
		
		assertNotNull(matchingJobForWorker);
		assertThat(matchingJobForWorker.getWorker(), equalTo(worker.get()));
		assertFalse(matchingJobForWorker.getMatchedJobs().isEmpty());
		assertThat(matchingJobForWorker.getMatchedJobs().size(), lessThanOrEqualTo(maxResult));
	}

}
