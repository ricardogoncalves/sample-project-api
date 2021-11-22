package com.sample.controller;

import java.util.List;

import javax.validation.Valid;

import com.sample.application.ArmyFactoryService;
import com.sample.controller.dto.ManyArmyDto;
import com.sample.controller.dto.OneArmyDto;
import com.sample.domain.army.Army;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/army/factory")
public class ArmyController {
	private ArmyFactoryService armyFactoryService;

	public ArmyController(ArmyFactoryService armyFactoryService) {
		this.armyFactoryService = armyFactoryService;
	}

	@Post("/one")
	public Army createArmy(@Valid @Body OneArmyDto armyDto) {
		return armyFactoryService.createOneArmy(armyDto.getName(), armyDto.getNumberOfSoldiers());
	}

	@Post("/many")
	public List<Army> createArmies(@Valid @Body ManyArmyDto armiesDto) {
		return armyFactoryService.createManyArmies(armiesDto.getNumberOfArmies(), armiesDto.getNumberOfSoldiers());
	}
}
