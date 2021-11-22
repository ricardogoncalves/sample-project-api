package com.sample.domain.army;

import com.sample.domain.troop.TroopType;

public interface ArmyFactory {
	Army createArmy(String armyName, TroopType[] troopTypes, int totalSoldiers);
}
