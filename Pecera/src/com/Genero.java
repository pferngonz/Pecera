
package com;

public enum Genero {
	HEMBRA(1),
	MACHO(0);
	private final int generovalor;
	Genero (int generovalor){
		this.generovalor = generovalor;
	}
	public int getGenerovalor() {
		return generovalor;
	}
	
}


