package com.sample;

import static com.sample.domain.troop.TroopType.ARCHER;
import static com.sample.domain.troop.TroopType.SPEARMEN;
import static com.sample.domain.troop.TroopType.SWORDSMEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.sample.domain.army.Army;
import com.sample.domain.army.ArmyFactory;
import com.sample.domain.army.ArmyFactoryImpl;
import com.sample.domain.troop.Troop;
import com.sample.domain.troop.TroopType;

class ArmyFactoryTest {
	@Test
	void testArmyCreationManySoldiers() {
		ArmyFactory armyFactory = new ArmyFactoryImpl();

		var totalRequiredSoldiers = 5_000_000;

		Army army = armyFactory.createArmy("Brazilian", TroopType.values(), totalRequiredSoldiers);

		assertCreatedArmy(army, totalRequiredSoldiers);
	}

	@Test
	void testArmyCreationFewSoldiers() {
		ArmyFactory armyFactory = new ArmyFactoryImpl();

		var totalRequiredSoldiers = 3;

		Army army = armyFactory.createArmy("Brazilian", TroopType.values(), totalRequiredSoldiers);

		assertCreatedArmy(army, totalRequiredSoldiers);
	}

	private void assertCreatedArmy(Army army, int totalRequiredSoldiers) {
		// Assert that was created the required number of soldiers
		assertEquals(totalRequiredSoldiers, army.totalOfSoldiers());
		// Assert that was created the required number of troops
		assertEquals(TroopType.values().length, army.getTroops().size());
		// Assert that the archer troop was created
		assertNotEquals(0, army.getTroops().stream().filter(t -> ARCHER.equals(t.getTroopType())).count());
		// Assert that the spearmen troop was created
		assertNotEquals(0, army.getTroops().stream().filter(t -> SPEARMEN.equals(t.getTroopType())).count());
		// Assert that the swordsmen troop was created
		assertNotEquals(0, army.getTroops().stream().filter(t -> SWORDSMEN.equals(t.getTroopType())).count());
		// Assert that the archer troop is not empty
		assertNotEquals(0, army.getTroops().stream().filter(t -> ARCHER.equals(t.getTroopType()))
				.mapToInt(Troop::getNumberOfSoldiers).sum());
		// Assert that the spearmen troop is not empty
		assertNotEquals(0, army.getTroops().stream().filter(t -> SPEARMEN.equals(t.getTroopType()))
				.mapToInt(Troop::getNumberOfSoldiers).sum());
		// Assert that the spearmen troop is not empty
		assertNotEquals(0, army.getTroops().stream().filter(t -> SWORDSMEN.equals(t.getTroopType()))
				.mapToInt(Troop::getNumberOfSoldiers).sum());
	}

	@Test
	void testCreatingManyArmiesAndCheckTroopCombinations() {
		ArmyFactory armyFactory = new ArmyFactoryImpl();

		var armies = new ArrayList<Army>();

		var numberOfArmies = 100;

		for (int i = 0; i < numberOfArmies; i++) {
			Army army = armyFactory.createArmy("Army " + i + 1, TroopType.values(), 1000);

			armies.add(army);
		}

		// Assert that every army has a diferent combination of troops
		assertEquals(numberOfArmies, armies.stream().distinct().count());
	}
}
