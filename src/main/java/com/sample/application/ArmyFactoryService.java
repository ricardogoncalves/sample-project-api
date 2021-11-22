package com.sample.application;

import java.util.List;

import com.sample.domain.army.Army;

public interface ArmyFactoryService {
	Army createOneArmy(String armyName, int soldiers);

	List<Army> createManyArmies(int numberOfArmies, int soldiersPerArmy);
}
