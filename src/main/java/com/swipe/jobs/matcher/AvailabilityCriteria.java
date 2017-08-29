package com.swipe.jobs.matcher;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.swipe.jobs.domain.Job;
import com.swipe.jobs.domain.Worker;

public class AvailabilityCriteria implements Predicate<Job>{

	private Worker worker;

	public AvailabilityCriteria(Worker worker) {
		this.worker = worker;
	}

	@Override
	public boolean test(Job job) {
		DayOfWeek startDayOfJob = getStartDayOfJob(job);
		
		return getAvailableDays().contains(startDayOfJob);
	}

	private List<DayOfWeek> getAvailableDays() {
		
		return worker.getAvailability().stream().filter(a -> a != null).map(d -> d.getDayOfWeek()).collect(Collectors.toList());
	}
	
	DayOfWeek getStartDayOfJob(Job job) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime from = LocalDateTime.from(formatter.parse(job.getStartDate()));
		return from.getDayOfWeek();
	}

}
