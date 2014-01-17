package com.github.yusukemac.MoreTools.item;

import com.github.yusukemac.MoreTools.Core;
import com.github.yusukemac.MoreTools.CreativeTabYMTools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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

/**
 * Pickaxe+Shovel的なアイテム
 * 
 * すごいblocksEffectiveAgainstの追加めんどいとおもったけどそうでもなかった
 * 
 * @author yusukemac
 */
public class ItemHammer extends ItemTool {
	
	public float efficiencyOnProperMaterial;
	
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium, Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator};
	private static EntityPlayer player;
	
	public ItemHammer(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, 3.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.toolMaterial = par2EnumToolMaterial;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.efficiencyOnProperMaterial = par2EnumToolMaterial.getEfficiencyOnProperMaterial();
        this.setCreativeTab(Core.tabYMTools);
    }

	/**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
	@Override
	public boolean canHarvestBlock(Block par1Block)
    {
		if (par1Block == Block.snow ? true : par1Block == Block.blockSnow)
			return true;
		return par1Block == Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (par1Block != Block.blockDiamond && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald && par1Block != Block.blockEmerald ? (par1Block != Block.blockGold && par1Block != Block.oreGold ? (par1Block != Block.blockIron && par1Block != Block.oreIron ? (par1Block != Block.blockLapis && par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone && par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true : (par1Block.blockMaterial == Material.iron ? true : par1Block.blockMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }
	
	@Override
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block, int meta)
    {
		/*if (ForgeHooks.isToolEffective(par1ItemStack, par2Block, meta))
		{
			this.toolMaterial.getEfficiencyOnProperMaterial();
		}
        return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
        */
		
		return par2Block != null && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock || par2Block.blockMaterial == Material.sand) ? this.efficiencyOnProperMaterial : this.getStrVsBlock(par1ItemStack, par2Block);

    }
	
	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        for (int i = 0; i < this.blocksEffectiveAgainst.length; ++i)
        {
            if (this.blocksEffectiveAgainst[i] == par2Block)
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
