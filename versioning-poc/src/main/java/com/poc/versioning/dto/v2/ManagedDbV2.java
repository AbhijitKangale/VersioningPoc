package com.poc.versioning.dto.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.poc.versioning.dto.v1.ManagedDbV1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagedDbV2 extends ManagedDbV1 {

	@NonNull
	private String type;
	private String dbVersion;
	@JsonProperty("userId")
	private String userId1;
}
