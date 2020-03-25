package com.lux.xplore.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;
import com.lux.xplore.graphics.Renderer;

public class Image {
	
	// the openGL texture object.
	private Texture texture = null;
	
	// the buffered sprite of this sprite.
	private BufferedImage image = null;
	
	
	public Image(String path) {
		URL url = Image.class.getResource(path);
		
		try {
			image = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		if(image != null)
			image.flush();
	}
	
	public Texture getTexture() {
		if(image == null)
			return null;
		if(texture == null)
			texture = AWTTextureIO.newTexture(Renderer.getProfile(), image, true);
		
		return texture;
	}
	
}
