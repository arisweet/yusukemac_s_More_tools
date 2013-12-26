package com.github.yusukemac.MoreTools.item;

import com.github.yusukemac.MoreTools.Core;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemStoneBreaker extends ItemHammer
{
	
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.stone, Block.cobblestone};
	private static EntityPlayer player;
	private static NBTTagList list;
	
	public ItemStoneBreaker(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		for (int i = 0; i < Core.IDs.length; i++)
			System.out.println(Core.IDs[i]);
        return false;
    }
	public boolean canHarvestBlock(Block par1Block)
	{
		if (par1Block == Block.stone || par1Block == Block.cobblestone)
			return true;
		return false;
	}
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block, int meta)
	{
		return getStrVsBlock(par1ItemStack, par2Block);
	}
	
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		for (int i = 0; i < this.blocksEffectiveAgainst.length; i++)
		{
			if (this.blocksEffectiveAgainst[i] == par2Block)
				return this.efficiencyOnProperMaterial;
		}
		return 0F;
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
	/*public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par1ItemStack.addEnchantment(Enchantment.efficiency, 5);
	}
	*/
	

}
