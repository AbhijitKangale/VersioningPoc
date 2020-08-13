package com.poc.versioning.config;

import com.poc.versioning.dto.v1.ManagedDbV1;
import com.poc.versioning.dto.v2.ManagedDbV2;
import com.poc.versioning.jpa.JpaManagedDb;

import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

public class ModelMapperConfig implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(MapperFactory orikaMapperFactory) {

		orikaMapperFactory.classMap(ManagedDbV1.class, JpaManagedDb.class).mapNulls(false).byDefault().register();

		orikaMapperFactory.classMap(ManagedDbV2.class, JpaManagedDb.class).mapNulls(false).byDefault().register();
	}
}
