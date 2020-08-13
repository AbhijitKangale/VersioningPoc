package com.poc.versioning.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.versioning.dao.repo.ManagedDbDao;
import com.poc.versioning.jpa.JpaManagedDb;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ManagedDbService {

	@Autowired
	private ManagedDbDao managedDbDao;

	public JpaManagedDb creteManagedDb(JpaManagedDb jpaManagedDb) {
		return managedDbDao.saveManagedDb(jpaManagedDb);
	}

	public JpaManagedDb retrieveByUuid(UUID id) {
		return managedDbDao.getManagedDbByUuid(id);
	}
}
