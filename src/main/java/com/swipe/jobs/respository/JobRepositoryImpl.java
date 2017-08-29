package com.swipe.jobs.respository;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.swipe.jobs.domain.Job;

@Repository
public class JobRepositoryImpl implements JobRespository {

	@Override
	public List<Job> findAll() {
	RestTemplate template = new RestTemplate();
		
		ResponseEntity<List<Job>> rateResponse =
		        template.exchange("http://test.swipejobs.com/api/jobs",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Job>>() {
		            });
		List<Job> jobs = rateResponse.getBody();
		
		return jobs;
	}

}
