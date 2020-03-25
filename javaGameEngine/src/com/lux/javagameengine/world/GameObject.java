package com.lux.xplore.world;

import com.lux.xplore.graphics.Animation;
import com.lux.xplore.graphics.Graphics;

public class GameObject {

	//position
	public float x, y = 0f;
	//size
	public float width, height = 0f;
	//rotation
	public float rotation = 0f;
	
	//animations
	public Animation[] animations;
	public int currentAnimation = 0;
	
	public void update() {
		
	}
	
	public void render() {
		animations[currentAnimation].play();
		Graphics.setRotation(rotation);
		Graphics.drawImage(animations[currentAnimation].getImage(), x, y, width, height);
		Graphics.setRotation(0);
	}
	
}
