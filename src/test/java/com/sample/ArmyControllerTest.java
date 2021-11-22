package com.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.sample.application.ArmyFactoryService;
import com.sample.application.ArmyFactoryServiceImpl;
import com.sample.controller.dto.OneArmyDto;
import com.sample.domain.army.Army;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

@MicronautTest(packages = "com.sample")
class ArmyControllerTest {
	@Inject
	ArmyFactoryService armyFactoryService;

	@Inject
	@Client("/")
	HttpClient client;

	@Test
	void testCreateArmy() {
		var name = "Army 01";
		var numberOfSoldiers = 100;

		when(armyFactoryService.createOneArmy(name, 100)).then(invocation -> new Army(name));

		final Army army = client.toBlocking()
				.retrieve(HttpRequest.POST("/army/factory/one", new OneArmyDto(name, numberOfSoldiers)), Army.class);

		assertEquals(name, army.getName());
	}

	@MockBean(ArmyFactoryService.class)
	ArmyFactoryService mathService() {
		return mock(ArmyFactoryServiceImpl.class);
	}
}
