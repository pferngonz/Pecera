package com;

import acm.graphics.GImage;

public interface Animal {
	void reproducirse();
	void comer();
	void mover(GImage imagen, int heigth, int width);
	}

