
package com.swipe.jobs.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {

    @JsonProperty("last")
    private String lastName;
    @JsonProperty("first")
    private String firstName;

    public Name() {
	}
    /**
     * @param lastName
     * @param firstName
     */
    public Name(String lastName, String firstName) {
        super();
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @JsonProperty("last")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last")
    public void setLast(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("first")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("first")
    public void setFirst(String firstName) {
        this.firstName = firstName;
    }
}
