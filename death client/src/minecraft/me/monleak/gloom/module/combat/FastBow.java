package me.monleak.gloom.module.combat;

import org.lwjgl.input.Keyboard;

import me.monleak.gloom.module.Category;
import me.monleak.gloom.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBow;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;;

public class FastBow extends Module{

	public FastBow() {
		super("FastBow", Keyboard.KEY_B, Category.COMBAT);
	}
	
	@Override 
	public void onUpdate() {
		if(this.isToggled()) {
			if(Minecraft.getMinecraft().thePlayer.getHealth() > 0
					&&(Minecraft.getMinecraft().thePlayer.onGround || Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode)
					&& Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem() != null
					&& mc.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemBow
					&& Minecraft.getMinecraft().gameSettings.keyBindUseItem.isPressed()) {
				
				Minecraft.getMinecraft().playerController.sendUseItem(mc.thePlayer, mc.theWorld, mc.thePlayer.inventory.getCurrentItem()
						);
				Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().getItem().onItemRightClick(mc.thePlayer.inventory.getCurrentItem(), mc.theWorld, mc.thePlayer);
				
				for(int i = 0; i < 20; i++)
					mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(false));
				Minecraft.getMinecraft().getNetHandler().addToSendQueue(new C07PacketPlayerDigging(Action.RELEASE_USE_ITEM, new BlockPos(0, 0, 0), EnumFacing.DOWN));
				mc.thePlayer.inventory.getCurrentItem().getItem().onPlayerStoppedUsing(mc.thePlayer.inventory.getCurrentItem(), mc.theWorld, mc.thePlayer, 10);
			}
					
		}
	}

}
