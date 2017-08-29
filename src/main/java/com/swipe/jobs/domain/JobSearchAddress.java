
package com.swipe.jobs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobSearchAddress {

    private String unit;
    private Integer maxJobDistance;
    private String longitude;
    private String latitude;
    public JobSearchAddress() {
	}

    public JobSearchAddress(String unit, Integer maxJobDistance, String longitude, String latitude) {
        super();
        this.unit = unit;
        this.maxJobDistance = maxJobDistance;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getMaxJobDistance() {
        return maxJobDistance;
    }

    public void setMaxJobDistance(Integer maxJobDistance) {
        this.maxJobDistance = maxJobDistance;
    }

    public JobSearchAddress withMaxJobDistance(Integer maxJobDistance) {
        this.maxJobDistance = maxJobDistance;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public JobSearchAddress withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public JobSearchAddress withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }
}
