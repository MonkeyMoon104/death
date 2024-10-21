package de.Hero.clickgui.util;

import java.awt.Color;

//Deine Imports
import me.monleak.gloom.Gloom;

/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit me
 *
 *  @author HeroCode
 */
public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int)Gloom.instance.settingsManager.getSettingByName("GuiRed").getValDouble(), (int)Gloom.instance.settingsManager.getSettingByName("GuiGreen").getValDouble(), (int)Gloom.instance.settingsManager.getSettingByName("GuiBlue").getValDouble());
	}
}
