package com.github.yusukemac.MoreTools.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

/**
 * まったく触れてない。
 * 
 * @author yusukemac
 */
public class CommonProxy implements IGuiHandler {
 
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}
 
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}
 
	public void init() {
		
	}
}