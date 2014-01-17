/*****
 * 
 * @author yusuke
 * created by 2013/11/15 (Year/Month/Day)
 *
 *****/

package com.github.yusukemac.MoreTools;

/**
 * 今度このクラス消そうと思う
 * 
 * @author yusukemac
 */
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.ItemStack;

public class ymRegistry
{
	public static void registerItem(net.minecraft.item.Item item, String name)
	{
		GameRegistry.registerItem(item, name);
		item.setUnlocalizedName(name);
	}
	public static void registerBlock(net.minecraft.block.Block block, String name)
	{
		GameRegistry.registerBlock(block, name);
		block.setUnlocalizedName(name);
	}
	/**
	 * @param output output's item
	 * @param stackSize output Stack size
	 * @param params recipe object
	 * 
	 * @usage: Item.stick, 1, new Object[] {"XXX", 'X', Block.dirt}
	 * 
	 * */
	public static void addRecipe(net.minecraft.item.Item output, int stackSize, Object... params)
	{
		ItemStack itemstack = new ItemStack(output, stackSize);
		
		GameRegistry.addRecipe(itemstack, params);
	}
	/**
	 * **
	 * @param output output's block
	 * @param stackSize output Stack size
	 * @param params recipe object
	 * 
	 * @usage: Block.grass, 1, new Object[] {"SSS", 'S', Item.stick}
	 * 
	 */
	public static void addRecipe(net.minecraft.block.Block output, int stackSize, Object... params)
	{
		ItemStack itemstack = new ItemStack(output, stackSize);
		
		GameRegistry.addRecipe(itemstack, params);
	}
	
	/**
	 * **
	 * @param output output's item
	 * @param stackSize output Stack size
	 * @param params recipe object
	 * 
	 * @usage: Item.stick, 1, new Object[] { new ItemStack(Block.dirt, 1) }
	 * 
	 */
	public static void addShapelessRecipe(net.minecraft.item.Item output, int stackSize, Object... param)
	{
		ItemStack itemstack = new ItemStack(output, stackSize);
		
		GameRegistry.addShapelessRecipe(itemstack, param);
	}
	
	/**
	 * **
	 * @param output output's block
	 * @param stackSize output Stack size
	 * @param params recipe object
	 * 
	 * @usage: Block.dirt, 1, new Object[] { new ItemStack(Item.stick, 1) }
	 * 
	 */
	public static void addShapelessRecipe(net.minecraft.block.Block output, int stackSize, Object... param)
	{
		ItemStack itemstack = new ItemStack(output, stackSize);
		
		GameRegistry.addShapelessRecipe(itemstack, param);
	}
	
	/**
	 * **
	 * @param yourObject Item, Block, Entity...More
	 * @param en_USname English(US) name
	 * @param ja_JPname 日本語(日本) name
	 */
	public static void addName(Object yourObject, String en_USname, String ja_JPname)
	{
		LanguageRegistry.addName(yourObject, en_USname);
		LanguageRegistry.instance().addNameForObject(yourObject, "ja_JP", ja_JPname);
		
	}

}
