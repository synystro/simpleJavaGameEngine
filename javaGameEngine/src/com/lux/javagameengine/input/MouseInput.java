package com.lux.xplore.input;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.lux.xplore.graphics.Renderer;

public class MouseInput implements MouseListener {
	
	public static int x = 0;
	public static int y = 0;
	
	public static float getWorldX() {
		return (Renderer.unitsWide / Renderer.screenWidth * x - Renderer.unitsWide / 2) + Renderer.cameraX;
	}
	public static float getWorldY() {
		float unitsTall = Renderer.unitsWide * (float) (float)Renderer.screenHeight / (float)Renderer.screenWidth;
		return -(unitsTall / Renderer.screenHeight * y - unitsTall / 2) + Renderer.cameraY;
	}
	
	public void mouseClicked(MouseEvent e) {
		//
	}

	public void mouseDragged(MouseEvent e) {
		//
	}

	public void mouseEntered(MouseEvent e) {
		//
		
	}

	public void mouseExited(MouseEvent e) {
		//
	}

	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mousePressed(MouseEvent e) {
		//
	}

	public void mouseReleased(MouseEvent e) {
		//
	}

	public void mouseWheelMoved(MouseEvent e) {
		//
	}
	
	
	
}
