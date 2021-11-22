package com.sample.domain.army;

import java.util.ArrayList;
import java.util.List;

import com.sample.domain.troop.Troop;

public class Army {
	private String name;
	private List<Troop> troops;

	private Army() {
	}

	public Army(String name) {
		super();
		this.name = name;
		this.troops = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<Troop> getTroops() {
		return troops;
	}

	public int totalOfSoldiers() {
		return this.troops.stream().mapToInt(Troop::getNumberOfSoldiers).sum();
	}

	void addTroop(Troop troop) {
		this.troops.add(troop);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((troops == null) ? 0 : troops.hashCode());
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
		Army other = (Army) obj;
		if (troops == null) {
			if (other.troops != null)
				return false;
		} else if (!troops.equals(other.troops))
			return false;
		return true;
	}
}
