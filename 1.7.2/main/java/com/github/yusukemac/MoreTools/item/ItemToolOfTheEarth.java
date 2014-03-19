package com.github.yusukemac.MoreTools.item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.github.yusukemac.MoreTools.Core;
import com.google.common.collect.Sets;

/**
 * @author yusukemac
 */
public class ItemToolOfTheEarth extends ItemToolOfNature
{
	public final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] {Blocks.acacia_stairs});

	public float efficiencyOnProperMaterial = 5.0F;
	private static EntityPlayer player;
	private float weaponDamage;

	public ItemToolOfTheEarth(ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.weaponDamage = 5.0F + par2EnumToolMaterial.getDamageVsEntity();
	}

	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		if (!par2World.isRemote)
		{
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

	@Override
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
	{
		if (par3.getBlockHardness(par2World, par4, par5, par6) != 0.0D) {
			par1ItemStack.damageItem(1, par7EntityLivingBase);
		}
		if (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() == 0)
			if (!par2World.isRemote)
				((EntityPlayer)par7EntityLivingBase).dropItem(Core.toolOfTheEarthDebris, 1);

	return true;
}

}
