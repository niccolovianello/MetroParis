package it.polito.tdp.metroparis.model;

public class ConnessioneVelocita {
	
	private int stazP;
	private int stazA;
	private Double velocita;
	
	public ConnessioneVelocita(int stazP, int stazA, Double velocita) {
		this.stazP = stazP;
		this.stazA = stazA;
		this.velocita = velocita;
	}

	public int getStazP() {
		return stazP;
	}

	public void setStazP(int stazP) {
		this.stazP = stazP;
	}

	public int getStazA() {
		return stazA;
	}

	public void setStazA(int stazA) {
		this.stazA = stazA;
	}

	public Double getVelocita() {
		return velocita;
	}

	public void setVelocita(Double velocita) {
		this.velocita = velocita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stazA;
		result = prime * result + stazP;
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
		ConnessioneVelocita other = (ConnessioneVelocita) obj;
		if (stazA != other.stazA)
			return false;
		if (stazP != other.stazP)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConnessioneVelocita [stazP=" + stazP + ", stazA=" + stazA + ", velocita=" + velocita + "]";
	}
	
	
	

}
