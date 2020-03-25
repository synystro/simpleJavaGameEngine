package com.lux.xplore;

import com.lux.test.Player;
import com.lux.xplore.graphics.Renderer;
import com.lux.xplore.world.World;

public class Game {
	
	private static boolean running = false;
	
	private static int ticks = 0;
	private static final int MAX_TICKS = 5;
	
	private static long lastTickTime = 0;
	
	private static Thread thread = null;
	
	private static int targetFPS = 60;
	private static int targetTickTime = 1000000000 / targetFPS;
	
	public Game() {
	}
	
	public synchronized void start() {
		thread = new Thread();
		
		run();
		
		thread.setName("Game");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		running = true;
		
		//set last tick time to current time.
		lastTickTime = System.nanoTime();
		
		//long lastFpsCheck = System.nanoTime();
		
		while(running) {
			long currentTickTime = System.nanoTime();
			
			ticks = 0;
			
			while(currentTickTime - lastTickTime >= targetTickTime) {
				World.tick();
				lastTickTime += targetTickTime;
				ticks++;
				
				if(ticks > MAX_TICKS)
					break;
			}
			
			Renderer.render();
			/*
			fps++;
			if(System.nanoTime() >= lastFpsCheck + 1000000000) {
				fps = 0;
				lastFpsCheck = System.nanoTime();
			}
			*/
			long timeTaken = System.nanoTime() - currentTickTime;
			if(targetTickTime > timeTaken)
				try {
					Thread.sleep((targetTickTime - timeTaken) / 1000000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}			
		}
	}
	
	public static float tickDelta() {
		return 1.0f / 1000000000 * targetTickTime;
	}
	
	public static void main(String[] args) {
		Renderer.init();
		Game game = new Game();
		World.addObject(new Player(0,0,0,1,1));
		game.start();
		
		
	}
	
}
