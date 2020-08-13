package com.poc.versioning.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.versioning.dto.v1.ManagedDbV1;
import com.poc.versioning.dto.v2.ManagedDbV2;
import com.poc.versioning.jpa.JpaManagedDb;
import com.poc.versioning.service.ManagedDbService;

import lombok.NoArgsConstructor;
import ma.glasnost.orika.MapperFacade;

@RestController
@NoArgsConstructor
@RequestMapping("/provider/managedDb")
public class ManagedDbController {

	@Autowired
	private ManagedDbService managedDbService;

	@Autowired
	private MapperFacade orikaModelMapper;

	@ResponseBody
	@PostMapping(value = "/create", produces = "application/vdm.poc.app-v1+json")
	public ResponseEntity<ManagedDbV1> createV1(@RequestBody ManagedDbV1 managedDbV1) {
		JpaManagedDb jpaManagedDb = managedDbService
				.creteManagedDb(orikaModelMapper.map(managedDbV1, JpaManagedDb.class));
		ManagedDbV1 managedDb = orikaModelMapper.map(jpaManagedDb, ManagedDbV1.class);
		return ResponseEntity.ok(managedDb);
	}

	@ResponseBody
	@PostMapping(value = "/create", produces = "application/vdm.poc.app-v2+json")
	public ResponseEntity<ManagedDbV1> createV2(@RequestBody ManagedDbV2 managedDbV2) {
		JpaManagedDb jpaManagedDb = managedDbService
				.creteManagedDb(orikaModelMapper.map(managedDbV2, JpaManagedDb.class));
		ManagedDbV2 managedDb = orikaModelMapper.map(jpaManagedDb, ManagedDbV2.class);
		return ResponseEntity.ok(managedDb);
	}

	@ResponseBody
	@GetMapping(value = "/retrieve/{UUID}", produces = "application/vdm.poc.app-v1+json")
	public ResponseEntity<ManagedDbV1> retrieveV1(@PathVariable(name = "UUID", required = true) UUID uuid) {

		JpaManagedDb jpaManagedDb = managedDbService.retrieveByUuid(uuid);
		ManagedDbV1 managedDb = orikaModelMapper.map(jpaManagedDb, ManagedDbV1.class);
		return ResponseEntity.ok(managedDb);
	}

	@ResponseBody
	@GetMapping(value = "/retrieve/{UUID}", produces = "application/vdm.poc.app-v2+json")
	public ResponseEntity<ManagedDbV2> retrieveV2(@PathVariable(name = "UUID", required = true) UUID uuid) {

		JpaManagedDb jpaManagedDb = managedDbService.retrieveByUuid(uuid);
		ManagedDbV2 managedDb = orikaModelMapper.map(jpaManagedDb, ManagedDbV2.class);
		return ResponseEntity.ok(managedDb);
	}
}
