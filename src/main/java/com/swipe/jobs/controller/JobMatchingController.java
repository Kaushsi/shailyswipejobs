package com.swipe.jobs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swipe.jobs.domain.Worker;
import com.swipe.jobs.domain.WorkerMatchedJobs;
import com.swipe.jobs.respository.JobRespository;
import com.swipe.jobs.respository.WorkersRepository;
import com.swipe.jobs.service.MatchingService;

@RestController
public class JobMatchingController {
	
	@Autowired
	private MatchingService matchingService;
	@Autowired
	private WorkersRepository workerRepository;
	@Autowired
	private JobRespository jobService;

	@RequestMapping("/")
    public String index() {
		
        return "Swipejob coding exercise by Shaily.";
    }
	
    @RequestMapping(value = "/matches/{workerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<WorkerMatchedJobs> topThreeJobMatches(@PathVariable(value="workerId") String workerId, @RequestParam(value = "maxResult", required = false, defaultValue = "3") int maxResult) {
    	
    	
    	Optional<Worker> worker = workerRepository.findByWorkerById(workerId);
    	
    	if (worker.isPresent()) {
    		WorkerMatchedJobs matchingJobForWorker = matchingService.getMatchingJobForWorker(worker.get(), jobService.findAll(), maxResult);
    		
    		return new ResponseEntity<WorkerMatchedJobs>(matchingJobForWorker, HttpStatus.OK);
    	}
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
