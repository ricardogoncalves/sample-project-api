package com.sample.domain.army;

import java.util.Random;

import com.sample.domain.troop.Troop;
import com.sample.domain.troop.TroopType;

public class ArmyFactoryImpl implements ArmyFactory {
	private final Random random = new Random();

	public Army createArmy(String armyName, TroopType[] troopTypes, int totalSoldiers) {
		var army = new Army(armyName);

		var recrutedSoldiers = 0;

		if (totalSoldiers < troopTypes.length) {
			totalSoldiers = troopTypes.length;
		}

		var remainingTroops = troopTypes.length;

		for (TroopType troopType : troopTypes) {
			var troopSize = totalSoldiers - recrutedSoldiers;

			if (army.getTroops().size() < troopTypes.length - 1) {
				troopSize = generateTroopSize(totalSoldiers - recrutedSoldiers - --remainingTroops);
				recrutedSoldiers += troopSize;
			}

			army.addTroop(new Troop(troopType, troopSize));
		}

		return army;
	}

	private int generateTroopSize(int maxSoldiers) {
		var minTroopSize = 1;
		var generatedTroopSize = random.nextInt(maxSoldiers);

		return generatedTroopSize >= minTroopSize ? generatedTroopSize : minTroopSize;
	}
}
