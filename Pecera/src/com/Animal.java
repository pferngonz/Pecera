package com;

import acm.graphics.GImage;

public interface Animal {
	void reproducirse();
	void comer();
	void mover(int x, int y, GImage imagen);
	}

