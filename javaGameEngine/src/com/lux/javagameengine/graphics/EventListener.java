package com.lux.xplore.graphics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.lux.xplore.resources.Image;
import com.lux.xplore.world.World;

public class EventListener implements GLEventListener {

	public static GL2 gl = null;
	public static Image image = null;
	
	public void display(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		gl.glTranslatef(-Renderer.cameraX, Renderer.cameraY, 0);
		World.render();
		gl.glTranslatef(Renderer.cameraX, Renderer.cameraY, 0);
	}
	
	public void dispose(GLAutoDrawable drawable) {
		System.exit(1);
	}

	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glClearColor(0, 0, 0, 1);
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		
		float unitsTall = Renderer.window.getHeight() /
				(Renderer.window.getWidth() / Renderer.unitsWide );
		
		gl.glOrtho(
				-Renderer.unitsWide/2,
				Renderer.unitsWide/2,
				-unitsTall/2,
				unitsTall/2,
				-1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}
	
}
