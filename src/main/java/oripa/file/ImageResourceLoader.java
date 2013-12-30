package oripa.file;

import java.net.URL;

import javax.swing.ImageIcon;



public class ImageResourceLoader {

	public ImageIcon loadAsIcon(String name){
		return this.loadAsIcon(name, getClass());
	}

	public ImageIcon loadAsIcon(String name, Class<?> c){
		ClassLoader classLoader = c.getClassLoader();
		URL url=classLoader.getResource(name);
		
    // If the file is not in the jar, get it straight from file
		if (url == null) {
			try {
				url = new java.io.File("src/main/resources/"+name).toURI().toURL();
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}		
		}
		
		ImageIcon icon=new ImageIcon(url);
		
		return icon;

	}
}
