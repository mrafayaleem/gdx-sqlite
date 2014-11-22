
package com.gdxsqlite.test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 640;
		config.height = 480;
		config.title = "DatabaseTest";
		config.forceExit = false;
		new LwjglApplication(new DatabaseTest(), config);
	}
}
