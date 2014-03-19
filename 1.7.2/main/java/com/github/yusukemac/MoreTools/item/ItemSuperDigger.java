package com.github.yusukemac.MoreTools.item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

/**
 * 
 * @author yusukemac
 */
public final class ItemSuperDigger extends ItemHammer
{
	
	public static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] {Blocks.glass, Blocks.sand, Blocks.gravel, Blocks.snow, Blocks.snow_layer, Blocks.clay, Blocks.hardened_clay, Blocks.stained_hardened_clay, Blocks.mycelium, Blocks.cobblestone, Blocks.stone_slab, Blocks.double_stone_slab, Blocks.stone, Blocks.mossy_cobblestone, Blocks.iron_block, Blocks.iron_ore, Blocks.coal_ore, Blocks.coal_block, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_block, Blocks.diamond_ore, Blocks.ice, Blocks.netherrack, Blocks.nether_brick, Blocks.nether_brick_fence, Blocks.nether_brick_stairs, Blocks.lapis_block, Blocks.lapis_ore, Blocks.redstone_block, Blocks.redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail, Blocks.log, Blocks.planks});
	private static EntityPlayer player;
	
	public ItemSuperDigger(ToolMaterial toolMaterial) {
		super(toolMaterial);
	}
	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if (!par2World.isRemote)
		{
			if (par5)
			{
				player = ((EntityPlayer)par3Entity);	
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 2));
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10 * 20, 2));
			}
		}
	}
	
}
