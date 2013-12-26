package com.github.yusukemac.MoreTools.item;

import java.util.ArrayList;
import java.util.Random;

import com.github.yusukemac.MoreTools.Core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemToolOfNature extends ItemSword
{
	
	public float efficiencyOnProperMaterial = 4.0F;
	
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cloth, Block.leaves, Block.web, Block.pumpkin, Block.pumpkinLantern, Block.pumpkinStem, Block.carpet};
	
	public ItemToolOfNature(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.efficiencyOnProperMaterial = par2EnumToolMaterial.getEfficiencyOnProperMaterial();
		this.setCreativeTab(Core.tabYMTools);
	}
	
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block, int meta)
	{
		if (par2Block.blockMaterial == Material.cloth || par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.materialCarpet || par2Block.blockMaterial == Material.leaves || par2Block.blockMaterial == Material.pumpkin)
		{
			return this.efficiencyOnProperMaterial;
		}
		return this.getStrVsBlock(par1ItemStack, par2Block);
	}
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		for(int i = 0; i < this.blocksEffectiveAgainst.length; i++)
		{
			if (this.blocksEffectiveAgainst[i] == par2Block)
			{
				return this.efficiencyOnProperMaterial;
			}
		}
		return 2.0F;
	}
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
            }

            int i1 = par3World.getBlockId(par4, par5, par6);
            boolean air = par3World.isAirBlock(par4, par5 + 1, par6);

            if (par7 != 0 && air && (i1 == Block.grass.blockID || i1 == Block.dirt.blockID))
            {
                Block block = Block.tilledField;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block.blockID);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
    {
        if (entity.worldObj.isRemote)
        {
            return false;
        }
        if (entity instanceof IShearable)
        {
            IShearable target = (IShearable)entity;
            if (target.isShearable(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ))
            {
                ArrayList<ItemStack> drops = target.onSheared(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ,
                        EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));

                Random rand = new Random();
                for(ItemStack stack : drops)
                {
                    EntityItem ent = entity.entityDropItem(stack, 1.0F);
                    ent.motionY += rand.nextFloat() * 0.05F;
                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                }
                itemstack.damageItem(1, entity);
            }
            return true;
        }
        return false;
    }


}
