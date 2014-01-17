package com.github.yusukemac.MoreTools.proxy;

import java.util.EnumSet;

import com.github.yusukemac.MoreTools.Core;
import com.github.yusukemac.MoreTools.item.ItemHammer;
import com.github.yusukemac.MoreTools.item.ItemSnowplow;
import com.github.yusukemac.MoreTools.item.ItemToolOfTheEarth;

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

/**
 * ここで実績の設定をしています。
 * プレイヤーがクラフトした時・かまどからアイテムを出した時にどんなアイテムかを確認し、
 * 対象と一致していたらプレイヤーに実績を追加します。
 * 
 * @author yusukemac
 */
public class ClientTickHandler implements ICraftingHandler {

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) {
		
		if (item.getItem() instanceof ItemSnowplow)
			player.addStat(Core.timeToSnowRemoval, 1);
		
		if (item.getItem() instanceof ItemHammer)
			player.addStat(Core.timeToDismantling, 1);
		
		if (item.getItem() instanceof ItemToolOfTheEarth)
		{
			player.addStat(Core.craftToolOfTheEarth, 1);
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
		if (item.getItem() == Core.ingotPlastic)
			player.addStat(Core.getPlasticIngot, 1);
	}
	
}
