package bravo.variachis.showon.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import bravo.variachis.showon.ShowOn;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "The Show Must Go On";
		config.width = 800;
		config.height = 600;
		new LwjglApplication(new ShowOn(), config);
	}
}
