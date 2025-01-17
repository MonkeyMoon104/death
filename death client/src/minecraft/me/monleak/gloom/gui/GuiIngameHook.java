package me.monleak.gloom.gui;

import me.monleak.gloom.Gloom;
import me.monleak.gloom.module.Module;
import me.monleak.gloom.utils.ColorUtils;
import me.monleak.gloom.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;

public class GuiIngameHook extends GuiIngame{

	public GuiIngameHook(Minecraft mcIn) {
		super(mcIn);
	}
	
	public void renderGameOverlay(float p_175180_1_) {
		super.renderGameOverlay(p_175180_1_);
		
	     
	    	 drawRect(2, 2, 100, 14, 0x80000000);
		     Wrapper.fr.drawString("Death", 10, 4, 0x4F0381);
		     Wrapper.fr.drawString("FPS: " + mc.getDebugFPS(), 50, 4, -1);
		     renderArrayList();
	     
	     
	}
	private void renderArrayList() {
		int yCount = 0;
		int index = 0;
		long x = 0;
		for(Module m : Gloom.instance.moduleManager.getModules()) {
			m.onRender();
			
			if(m.isToggled()) {
				Wrapper.fr.drawString("-" + m.getName(), 5, yCount + 17, ColorUtils.rainbowEffect(index + x*2000000000L, 1.0F).getRGB());
				yCount += 10;
				index++;
				x++;
			}
		}
	}

}
