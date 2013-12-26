package com.github.yusukemac.MoreTools.proxy;

import java.util.EnumSet;

import com.github.yusukemac.MoreTools.Core;
import com.github.yusukemac.MoreTools.OrePlastic;
import com.github.yusukemac.MoreTools.item.ItemHammer;
import com.github.yusukemac.MoreTools.item.ItemSnowplow;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		// TODO 自動生成されたメソッド・スタブ
		if (item.getItem() instanceof ItemSnowplow)
			player.addStat(Core.timeToSnowRemoval, 1);
		
		if (item.getItem() instanceof ItemHammer)
			player.addStat(Core.timeToDismantling, 1);
		
		if (item.getItem() == Core.toolOfTheEarth)
		{
			player.addStat(Core.craftToolOfTheEarth, 1);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		// TODO 自動生成されたメソッド・スタブ
		if (item.getItem() == Core.ingotPlastic)
			player.addStat(Core.getPlasticIngot, 1);
	}
	
}
