package com.example.TestExamples;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnfBuTestItemRequest  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@JsonProperty("name")
	private String name;


	@JsonProperty("NIC No.")
	private String nicNo;

}

