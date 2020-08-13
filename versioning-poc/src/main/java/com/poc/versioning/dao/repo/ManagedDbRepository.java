package com.poc.versioning.dao.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.versioning.jpa.JpaManagedDb;

public interface ManagedDbRepository extends JpaRepository<JpaManagedDb, UUID> {

}
