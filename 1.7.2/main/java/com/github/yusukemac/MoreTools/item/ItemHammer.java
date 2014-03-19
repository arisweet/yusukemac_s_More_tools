package com.github.yusukemac.MoreTools.item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.github.yusukemac.MoreTools.Core;
import com.google.common.collect.Sets;

/*
import com.github.yusukemac.MoreTools.Core;
import com.github.yusukemac.MoreTools.CreativeTabYMTools;

import net.minecraft.Blocks.Blocks;
import net.minecraft.Blocks.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ItemHammer extends ItemTool {
	
	public float efficiencyOnProperMaterial;
	
	public static final Blocks[] BlockssEffectiveAgainst = new Blocks[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow, Blocks.BlocksSnow, Blocks.BlocksClay, Blocks.tilledField, Blocks.slowSand, Blocks.mycelium, Blocks.cobblestone, Blocks.stoneDoubleSlab, Blocks.stoneSingleSlab, Blocks.stone, Blocks.sandStone, Blocks.cobblestoneMossy, Blocks.oreIron, Blocks.BlocksIron, Blocks.oreCoal, Blocks.BlocksGold, Blocks.oreGold, Blocks.oreDiamond, Blocks.BlocksDiamond, Blocks.ice, Blocks.netherrack, Blocks.oreLapis, Blocks.BlocksLapis, Blocks.oreRedstone, Blocks.oreRedstoneGlowing, Blocks.rail, Blocks.railDetector, Blocks.railPowered, Blocks.railActivator};
	private static EntityPlayer player;
	
	public ItemHammer(ToolMaterial par2ToolMaterial)
    {
        super(3.0F, par2ToolMaterial, BlockssEffectiveAgainst);
        this.toolMaterial = par2EnumToolMaterial;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.efficiencyOnProperMaterial = par2EnumToolMaterial.getEfficiencyOnProperMaterial();
        this.setCreativeTab(Core.tabYMTools);
    }ide
	public boolean canHarvestBlocks(Blocks par1Blocks)
    {
		if (par1Blocks == Blocks.snow ? true : par1Blocks == Blocks.BlocksSnow)
			return true;
		return par1Blocks == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (par1Blocks != Blocks.BlocksDiamond && par1Blocks != Blocks.oreDiamond ? (par1Blocks != Blocks.oreEmerald && par1Blocks != Blocks.BlocksEmerald ? (par1Blocks != Blocks.BlocksGold && par1Blocks != Blocks.oreGold ? (par1Blocks != Blocks.BlocksIron && par1Blocks != Blocks.oreIron ? (par1Blocks != Blocks.BlocksLapis && par1Blocks != Blocks.oreLapis ? (par1Blocks != Blocks.oreRedstone && par1Blocks != Blocks.oreRedstoneGlowing ? (par1Blocks.BlocksMaterial == Material.rock ? true : (par1Blocks.BlocksMaterial == Material.iron ? true : par1Blocks.BlocksMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }
	
	@Override
    public float getStrVsBlocks(ItemStack par1ItemStack, Blocks par2Blocks, int meta)
    {
		
		return par2Blocks != null && (par2Blocks.BlocksMaterial == Material.iron || par2Blocks.BlocksMaterial == Material.anvil || par2Blocks.BlocksMaterial == Material.rock || par2Blocks.BlocksMaterial == Material.sand) ? this.efficiencyOnProperMaterial : this.getStrVsBlocks(par1ItemStack, par2Blocks);

    }
	
	@Override
	public float getStrVsBlocks(ItemStack par1ItemStack, Blocks par2Blocks)
    {
        for (int i = 0; i < this.BlockssEffectiveAgainst.length; ++i)
        {
            if (this.BlockssEffectiveAgainst[i] == par2Blocks)
            {
                return this.efficiencyOnProperMaterial;
            }
        }
        
        return 1.0F;
    }
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if (!par2World.isRemote)
		{
			if (par5)
			{
				player = ((EntityPlayer)par3Entity);
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10 * 20, 0));
			}
		}
	}
}
*/

public class ItemHammer extends ItemTool {
	
	private static Set<Block> BlocksEffectiveAgainst = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.hardened_clay, Blocks.stained_hardened_clay, Blocks.sand, Blocks.mycelium, Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.coal_block, Blocks.gold_ore, Blocks.gold_block, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.redstone_block, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail, Blocks.brick_stairs, Blocks.stone_brick_stairs, Blocks.stone_stairs, Blocks.nether_brick_stairs, Blocks.quartz_stairs, Blocks.sandstone_stairs});
	
	public ItemHammer(ToolMaterial material) {
		
		super(3, material, BlocksEffectiveAgainst);
		setCreativeTab(Core.tabYMTools);
	}
	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if (!par2World.isRemote)
		{
			if (par5)
			{
				EntityPlayer player = ((EntityPlayer)par3Entity);
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10 * 20, 0));
			}
		}
	}
}
