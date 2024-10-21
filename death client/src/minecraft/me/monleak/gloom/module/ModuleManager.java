package me.monleak.gloom.module;

import java.util.ArrayList;

import me.monleak.gloom.module.combat.*;
import me.monleak.gloom.module.movement.*;

public class ModuleManager {
	
	private static ArrayList<Module> mods;
	
	public ModuleManager() {
		mods = new ArrayList<Module>();
		//cheat combat
		newMod(new FastBow());
		newMod(new KillAura());
		
		//cheat moviment
		newMod(new AutoSprint());
		
		//cheat player
		
		//cheat render
		
		//cheat misc
	}

	public static void newMod(Module m) {
		mods.add(m);
	}
	
	public static ArrayList<Module> getModules(){
		return mods;
	}
	
	public static void onUpdate() {
		for(Module m : mods) {
			m.onUpdate();
		}
	}
	
	public static void onRender() {
		for(Module m : mods) {
			m.onRender();
		}
	}
	
	public static void onKey(int k) {
		for(Module m : mods) {
			if(m.getKey() == k) {
				m.toggle();
			}
		}
	}

}