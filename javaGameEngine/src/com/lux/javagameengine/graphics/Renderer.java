package com.lux.xplore.graphics;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.lux.xplore.input.KeyInput;
import com.lux.xplore.input.MouseInput;

public class Renderer {

	private static GLProfile profile = null;
	
	public static GLWindow window = null;
	
	public static int screenWidth = 1280;
	public static int screenHeight = screenWidth / 16 * 9;
	
	public static float unitsWide = 10f;
	
	public static float cameraX = 0f;
	public static float cameraY = 0f;
	
	public static void init() {
		GLProfile.initSingleton();
		profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);
		
		window = GLWindow.create(caps);
		window.setSize(screenWidth, screenHeight);
		//window.setResizable(false);
		window.addGLEventListener(new EventListener());
		window.addMouseListener(new MouseInput());
		window.addKeyListener(new KeyInput());
		
		window.setVisible(true);
		window.requestFocus();
	}
	
	public static void render() {
		if(window == null)
			return;
		
		window.display();
	}
	
	public static GLProfile getProfile() {
		return profile;
	}
	
}
