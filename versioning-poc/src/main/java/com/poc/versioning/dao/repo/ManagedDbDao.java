package com.poc.versioning.dao.repo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poc.versioning.jpa.JpaManagedDb;

import lombok.NoArgsConstructor;

@Repository
@NoArgsConstructor
public class ManagedDbDao {

	@Autowired
	private ManagedDbRepository managedDbRepository;

	public JpaManagedDb saveManagedDb(JpaManagedDb jpaManagedDb) {
		return managedDbRepository.save(jpaManagedDb);
	}

	public JpaManagedDb getManagedDbByUuid(UUID id) {
		return managedDbRepository.getOne(id);
	}
}
