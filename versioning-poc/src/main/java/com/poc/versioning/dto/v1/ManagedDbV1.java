package com.poc.versioning.dto.v1;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagedDbV1 {

	private UUID id;
	private String name;
	private int userId;
}
