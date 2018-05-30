package com;

import acm.graphics.GImage;

public interface Animal {
	void reproducirse(int x, int y);
	void comer(String [] turnopeces, int razapez);
	void mover(GImage imagen, int heigth, int width);
	}

