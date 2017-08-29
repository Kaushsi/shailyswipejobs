package com.swipe.jobs.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.Worker;
import com.swipe.jobs.domain.WorkerMatchedJobs;
import com.swipe.jobs.respository.JobRespository;
import com.swipe.jobs.respository.WorkersRepository;
import com.swipe.jobs.service.MatchingService;

@RunWith(SpringRunner.class)
@WebMvcTest(JobMatchingController.class)
public class JobMatchingControllerMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MatchingService matchingService;
	@MockBean
	private WorkersRepository workerRepository;
	@MockBean
	private JobRespository jobService;

	private List<Job> jobs;

	@Before
	public void setUp() {
	
		Mockito.when(jobService.findAll()).thenReturn(getJobs());

	}

	@Test
	public void testWorkerDoesNotExist() throws Exception {
		Mockito.when(workerRepository.findByWorkerById("someWorkerId")).thenReturn(Optional.empty());

		this.mockMvc.perform(get("/matches/someWorkerId").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				            .andExpect(status().isNotFound());

	}

	@Test
	public void testWorkerTop3MatchedJob() throws Exception {
		Worker worker = new Worker();
		Mockito.when(workerRepository.findByWorkerById("someWorkerId")).thenReturn(Optional.of(worker));
		
		List<Job> topThreeJobs = jobs.stream().limit(3).collect(Collectors.toList());
		WorkerMatchedJobs matchedJobs = new WorkerMatchedJobs(worker, topThreeJobs);
		Mockito.when(matchingService.getMatchingJobForWorker(worker, jobs, 3)).thenReturn(matchedJobs);
		
		this.mockMvc.perform(get("/matches/someWorkerId").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				             .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith("application/json;charset=UTF-8"))
				             .andReturn();
		Mockito.verify(matchingService).getMatchingJobForWorker(worker, jobs, 3);
	}
	
	@Test
	public void testWorkerTop4MatchedJob() throws Exception {
		Worker worker = new Worker();
		Mockito.when(workerRepository.findByWorkerById("someWorkerId")).thenReturn(Optional.of(worker));
		
		List<Job> topThreeJobs = jobs.stream().limit(4).collect(Collectors.toList());
		WorkerMatchedJobs matchedJobs = new WorkerMatchedJobs(worker, topThreeJobs);
		Mockito.when(matchingService.getMatchingJobForWorker(worker, jobs, 4)).thenReturn(matchedJobs);
		
		this.mockMvc.perform(get("/matches/someWorkerId?maxResult=4").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				             .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith("application/json;charset=UTF-8"))
				             .andReturn();
		Mockito.verify(matchingService).getMatchingJobForWorker(worker, jobs, 4);
	}


	private List<Job> getJobs() {
		Job job1 = new Job();
		job1.setJobTitle("jobTitle1");
		Job job2 = new Job();
		job2.setJobTitle("jobTitle2");
		Job job3 = new Job();
		job3.setJobTitle("jobTitle3");
		Job job4 = new Job();
		job4.setJobTitle("jobTitle4");
		Job job5 = new Job();
		job4.setJobTitle("jobTitle5");
		jobs = Arrays.asList(job1, job2, job3, job4, job5);
		return jobs;
	}
}
