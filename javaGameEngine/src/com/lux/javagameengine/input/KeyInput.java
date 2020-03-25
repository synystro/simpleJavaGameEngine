package com.lux.xplore.input;

import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyInput implements KeyListener {

	private static boolean[] keys = new boolean[256];
	
	public void keyPressed(KeyEvent e) {
		//keys[e.getKeyCode()] = true;
		if( 0 == ( InputEvent.AUTOREPEAT_MASK & e.getModifiers() ) )  { keys[e.getKeyCode()] = true;}
		double cash = 0f;
		float monthlyCash = 600f;
		int years = 12;
		float annualProfitRate = 0.26f;
		double salary;

		for(int i = 0; i < years * 12; i++) {
			cash += monthlyCash;
			salary = cash * (annualProfitRate / 12);
			cash += salary;
			System.out.println("month " + i + ": " + salary);
		}
	}

	public void keyReleased(KeyEvent e) {
		//keys[e.getKeyCode()] = false;
		if( 0 == ( InputEvent.AUTOREPEAT_MASK & e.getModifiers() ) )  { keys[e.getKeyCode()] = false;}
	}
	
	public static boolean getKey(int keyCode) {
		return keys[keyCode];
	}

}
