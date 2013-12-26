package com.github.yusukemac.MoreTools.item;

import com.github.yusukemac.MoreTools.Core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ItemSnowplow extends ItemTool {
	
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.snow, Block.blockSnow};
	
	public float efficiencyOnProperMaterial;
	
	public ItemSnowplow(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, 1.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
		this.toolMaterial = par2EnumToolMaterial;
		this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
		this.efficiencyOnProperMaterial = par2EnumToolMaterial.getEfficiencyOnProperMaterial();
		this.setCreativeTab(Core.tabYMTools);
	}

	public boolean canHarvestBlock(Block par1Block)
	{
		return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
	}
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block, int meta)
	{
		return getStrVsBlock(par1ItemStack, par2Block);
	}
	
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		return par2Block != null && par2Block.blockMaterial == Material.snow ? this.efficiencyOnProperMaterial : 1.0F;
	}
}
