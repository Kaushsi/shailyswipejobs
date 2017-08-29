package com.swipe.jobs.respository;

import java.util.List;
import java.util.Optional;

import com.swipe.jobs.domain.Worker;

public interface WorkersRepository {
	
	Optional<Worker> findByWorkerById(String workerId);
	
	List<Worker> findAll();

}
