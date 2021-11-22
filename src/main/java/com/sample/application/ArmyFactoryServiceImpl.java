package com.sample.application;

import java.util.ArrayList;
import java.util.List;

import com.sample.domain.army.Army;
import com.sample.domain.troop.TroopType;

import io.micronaut.context.annotation.Bean;

@Bean
public class ArmyFactoryServiceImpl implements ArmyFactoryService {
	private ArmyFactoryBean armyFactoryBean;

	public ArmyFactoryServiceImpl(ArmyFactoryBean armyFactoryBean) {
		this.armyFactoryBean = armyFactoryBean;
	}

	public Army createOneArmy(String armyName, int soldiers) {
		return armyFactoryBean.get().createArmy(armyName, TroopType.values(), soldiers);
	}

	public List<Army> createManyArmies(int numberOfArmies, int soldiersPerArmy) {
		var armies = new ArrayList<Army>();

		for (var i = 0; i < numberOfArmies; i++) {
			armies.add(armyFactoryBean.get().createArmy("Army " + i + 1, TroopType.values(), soldiersPerArmy));
		}

		return armies;
	}
}
