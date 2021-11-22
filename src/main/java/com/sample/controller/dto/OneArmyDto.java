package com.sample.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class OneArmyDto {
	@NotBlank
	private String name;
	@NotNull
	private Integer numberOfSoldiers;

	public OneArmyDto() {}

	public OneArmyDto(@NotBlank String name, @NotNull Integer numberOfSoldiers) {
		super();
		this.name = name;
		this.numberOfSoldiers = numberOfSoldiers;
	}

	public String getName() {
		return name;
	}

	public Integer getNumberOfSoldiers() {
		return numberOfSoldiers;
	}
}
