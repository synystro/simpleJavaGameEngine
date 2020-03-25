package com.lux.xplore.graphics;

import com.lux.xplore.resources.Image;

public class Animation {
	//frames
	public Image[] frames;
	public int fps= 16;
	private int currentFrame = 0;
	private long lastFrameTime = 0;
	
	//should loop?
	public boolean loop = true;
	
	public void play() {
		long currentTime = System.nanoTime();
		
		if(currentTime > lastFrameTime + 1000000000 / fps) {
			
			currentFrame++;
			
			if(currentFrame >= frames.length)
				if(loop)
					currentFrame = 0;
				else
					currentFrame--;
			lastFrameTime = currentTime;
		}
	}
	
	public Image getImage() {
		return frames[currentFrame];
	}
	
}
