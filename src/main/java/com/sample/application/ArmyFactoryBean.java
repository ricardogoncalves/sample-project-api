package com.sample.application;

import com.sample.domain.army.ArmyFactory;
import com.sample.domain.army.ArmyFactoryImpl;

import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class ArmyFactoryBean {
	@Singleton
	ArmyFactory get() {
		return new ArmyFactoryImpl();
	}
}
