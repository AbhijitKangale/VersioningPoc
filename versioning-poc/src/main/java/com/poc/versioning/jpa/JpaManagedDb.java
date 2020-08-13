package com.poc.versioning.jpa;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "managed_db")
@Data
@NoArgsConstructor
public class JpaManagedDb {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "type")
	private String type;

	@Column(name = "db_version")
	private String dbVersion;

	@Column(name = "user_id1")
	private String userId1;
}
