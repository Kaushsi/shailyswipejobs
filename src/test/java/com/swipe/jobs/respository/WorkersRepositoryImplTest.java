package com.swipe.jobs.respository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swipe.jobs.domain.Worker;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties
public class WorkersRepositoryImplTest {

	@Autowired
	private WorkersRepository repository;

	@Test
	public void testFindByWorkerId() {
		Optional<Worker> worker = repository.findByWorkerById("562f6647410ecd6bf49146e9");

		assertNotNull(worker);
		assertTrue(worker.isPresent());

	}

	@Test
	public void testWorkerDoesNotExistForByWorkerId() {
		String workerGuid = "562f6647410ecd6bg49146e9";
		Optional<Worker> worker = repository.findByWorkerById(workerGuid);

		assertNotNull(worker);
		assertFalse(worker.isPresent());
	}
}
