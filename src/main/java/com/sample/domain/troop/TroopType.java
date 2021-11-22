package com.sample.domain.troop;

public enum TroopType {
	ARCHER("ARCHER"), SPEARMEN("SPEARMEN"), SWORDSMEN("SWORDSMEN");

	TroopType(String type) {
		this.type = type;
	}

	private String type;

	public String getType() {
		return type;
	}
}
