package me.monleak.gloom;

import org.lwjgl.opengl.Display;

import de.Hero.clickgui.ClickGUI;
import de.Hero.settings.SettingsManager;
import me.monleak.gloom.module.ModuleManager;

public class Gloom {
	
	public static Gloom instance = new Gloom();
	
	public static SettingsManager settingsManager;
	
	public static String name = "Death Client", version = "1.8.9", creator = "Monleak";
	
	public static ModuleManager moduleManager;
	
	public static ClickGUI clickGui;
	
	public static void startClient() {
		settingsManager = new SettingsManager();
		moduleManager = new ModuleManager();
		clickGui = new ClickGUI();
		
		
		
		
		
		Display.setTitle(name + " " + version + " by " + creator);
	}

}