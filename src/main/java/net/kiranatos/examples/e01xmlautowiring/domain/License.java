package net.kiranatos.examples.e01xmlautowiring.domain;

public class License {

	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "License [number=" + number + "]";
	}
	
}
