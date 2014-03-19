package com.github.yusukemac.MoreTools.item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

public class ItemStoneBreaker extends ItemHammer
{
	
	public static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] {Blocks.stone, Blocks.cobblestone});
	private static EntityPlayer player;
	private static NBTTagList list;
	
	public ItemStoneBreaker(ToolMaterial ToolMaterial) {
		
		super(ToolMaterial);
	}
	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if (!par2World.isRemote)
		{
			if (par5)
			{
				player = ((EntityPlayer)par3Entity);
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1 * 20, 3));
			}
		}
	}
}
