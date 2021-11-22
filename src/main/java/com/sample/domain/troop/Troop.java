package com.sample.domain.troop;

public class Troop {
	private TroopType troopType;
	private int numberOfSoldiers;

	public Troop(TroopType troopType, int numberOfSoldiers) {
		super();
		this.troopType = troopType;
		this.numberOfSoldiers = numberOfSoldiers;
	}

	public TroopType getTroopType() {
		return troopType;
	}

	public int getNumberOfSoldiers() {
		return numberOfSoldiers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfSoldiers;
		result = prime * result + ((troopType == null) ? 0 : troopType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Troop other = (Troop) obj;
		if (numberOfSoldiers != other.numberOfSoldiers)
			return false;
		if (troopType != other.troopType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Troop [troopType=" + troopType + ", numberOfSoldiers=" + numberOfSoldiers + "]";
	}
}
