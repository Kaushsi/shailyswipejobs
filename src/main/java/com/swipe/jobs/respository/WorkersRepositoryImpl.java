package com.swipe.jobs.respository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.swipe.jobs.domain.Worker;

@Repository
public class WorkersRepositoryImpl implements WorkersRepository {

	@Override
	public Optional<Worker> findByWorkerById(String workerId) {
		List<Worker> workers = findAll();
		List<Worker> matchedWorkers = workers.stream().filter(w -> w.getGuid().equals(workerId)).collect(Collectors.toList());
		
		if (matchedWorkers.size() > 1) {
			throw new IllegalStateException(String.format("More than one worker exist for worker id [%s]", workerId));
		}
		return matchedWorkers.stream().findFirst();
	}

	@Override
	public List<Worker> findAll() {
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<List<Worker>> rateResponse =
		        template.exchange("http://test.swipejobs.com/api/workers",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Worker>>() {
		            });
		List<Worker> workers = rateResponse.getBody();
		
		return workers;
	}

}
