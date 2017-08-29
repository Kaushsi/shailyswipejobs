
package com.swipe.jobs.domain;

import java.time.DayOfWeek;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Availability {

    @JsonProperty("title")
    private String title;
    @JsonProperty("dayIndex")
    private Integer dayIndex;

    public Availability() {
	}
    public Availability(String title, Integer dayIndex) {
        super();
        this.title = title;
        this.dayIndex = dayIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(Integer dayIndex) {
        this.dayIndex = dayIndex;
    }

    @JsonIgnore
    public DayOfWeek getDayOfWeek() {
    	
    	return DayOfWeek.of(dayIndex);
    }
}
