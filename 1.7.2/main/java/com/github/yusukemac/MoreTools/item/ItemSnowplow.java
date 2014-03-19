package com.github.yusukemac.MoreTools.item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

import com.github.yusukemac.MoreTools.Core;
import com.google.common.collect.Sets;

/**
 * 
 * @author yusukemac
 */
public class ItemSnowplow extends ItemTool {
	
	public static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] {Blocks.snow, Blocks.snow_layer});
	
	public float efficiencyOnProperMaterial;
	
	public ItemSnowplow(ToolMaterial par2EnumToolMaterial)
	{
		super(1.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
		this.toolMaterial = par2EnumToolMaterial;
		this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
		this.efficiencyOnProperMaterial = par2EnumToolMaterial.getEfficiencyOnProperMaterial();
		this.setCreativeTab(Core.tabYMTools);
	}

	public boolean canHarvestBlock(Block par1Block)
	{
		return par1Block == Blocks.snow ? true : par1Block == Blocks.snow_layer;
	}
}
