package com;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Main {
	public static void main(String[] args) {
		new App().start(args);
	}
	public static class App extends GraphicsProgram{
		@Override
		public void run() {
			GImage fondo=new GImage("https://rawgit.com/pferngonz/Pecera/master/imagenes/Bettahembra.png");
			setSize(1280,720);
			fondo.setSize(1280,720);
			add(fondo, 0, 0);
		}
	}
}
