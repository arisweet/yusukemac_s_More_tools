package com.github.yusukemac.MoreTools.item;

import com.github.yusukemac.MoreTools.Core;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Tool of The Earthの詳細設定
 * 持ってる時にポーション効果を与えたりしてる
 * 
 * @author yusukemac
 */
public class ItemToolOfTheEarth extends ItemToolOfNature
{
	public final Block[] blocksEffectiveAgainst = Block.blocksList;
	
	public float efficiencyOnProperMaterial = 5.0F;
	private static EntityPlayer player;
	private float weaponDamage;
	
	public ItemToolOfTheEarth(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.weaponDamage = 5.0F + par2EnumToolMaterial.getDamageVsEntity();
	}
	
	//ポーション効果を個々で与えます
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if (!par2World.isRemote)
		{
			//手に持っている場合
			if (par5)
			{
				player = ((EntityPlayer)par3Entity);	
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 10 * 20, 5));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 3));
				player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10 * 20, 2));
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 16 * 20, 1));
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 10 * 20, 2));
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 10 * 20, 255));
			}
		}
	}
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block, int meta)
	{
		return this.efficiencyOnProperMaterial;
	}
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		return this.efficiencyOnProperMaterial;
	}
	public boolean canHarvestBlock(Block par1Block)
	{
		return true;
	}
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
        	par1ItemStack.damageItem(1, par7EntityLivingBase);
        	
            if (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() == 0)
            	if (!par2World.isRemote)
            		((EntityPlayer)par7EntityLivingBase).dropItemWithOffset(Core.toolOfTheEarthDebris.itemID, 1, 1.0F);
        }

        return true;
    }

}
