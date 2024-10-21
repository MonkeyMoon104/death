package me.monleak.gloom.module.movement;

import org.lwjgl.input.Keyboard;

import me.monleak.gloom.module.Category;
import me.monleak.gloom.module.Module;

public class AutoSprint extends Module{

	public AutoSprint() {
		super("AutoSprint" , Keyboard.KEY_F, Category.MOVEMENT);
	}
	
	public void onEnable() {
		if(this.isToggled()) {
			mc.thePlayer.setSprinting(true);
			super.onEnable();
		}
	}
	
	public void onDisable() {
		mc.thePlayer.setSprinting(false);
		super.onDisable();
	}
}
