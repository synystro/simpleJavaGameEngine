package com.lux.test;

import com.jogamp.newt.event.KeyEvent;
import com.lux.xplore.Game;
import com.lux.xplore.graphics.Animation;
import com.lux.xplore.input.KeyInput;
import com.lux.xplore.input.MouseInput;
import com.lux.xplore.resources.Image;
import com.lux.xplore.world.GameObject;

public class Player extends GameObject {
	
	private int walkSpeed = 1;
	
	public Player(float x, float y, float rotation, float width, float height) {
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.width = width;
		this.height = height;
		
		animations = new Animation[1];
		animations[0] = new Animation();
		animations[0].frames = new Image[2];
		animations[0].frames[0] = new Image("/resources/cage_1.png");
		animations[0].frames[1] = new Image("/resources/cage_2.png");
		
	}
	
	public void update() {
		processInput();
	}
	
	private void processInput() {
		
		// movement input
		float xInput = 0f;
		float yInput = 0f;
		
		if(KeyInput.getKey(KeyEvent.VK_A))
			xInput--;
		if(KeyInput.getKey(KeyEvent.VK_D))
			xInput++;
		if(KeyInput.getKey(KeyEvent.VK_W))
			yInput++;
		if(KeyInput.getKey(KeyEvent.VK_S))
			yInput--;
		x += xInput * walkSpeed * Game.tickDelta();
		y += yInput * walkSpeed * Game.tickDelta();
		
		rotation = (float) Math.toDegrees(Math.atan2(MouseInput.getWorldX() - x, MouseInput.getWorldY() - y));
		
	}
	
}
