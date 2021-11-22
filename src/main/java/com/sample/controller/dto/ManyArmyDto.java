package com.sample.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class ManyArmyDto {
	@NotBlank
	private int numberOfArmies;
	@NotNull
	private int numberOfSoldiers;

	public int getNumberOfArmies() {
		return numberOfArmies;
	}

	public int getNumberOfSoldiers() {
		return numberOfSoldiers;
	}
}
