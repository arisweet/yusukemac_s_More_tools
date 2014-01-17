package com.github.yusukemac.MoreTools;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * このメソッドも同じようにどうにかする
 * 
 * @author yusukemac
 */
public class ToolHelper {
	
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
	 * 
	 * @param material tool material
	 * @param stick stick material
	 * 
	 * @usage: Item.ingotIron, Item.blazeRod
	 * 
	 * 
	 */
	
	
	public static Object[] createAxeObject(Object material, Object stick)
	{
		return new Object[] { "XX ",
							  "XS ",
							  " S ", 'X', material, 'S', stick };
	}
	
	public static Object[] createPickaxeObject(Object material, Object stick)
	{
		return new Object[] { "XXX",
							  " S ",
							  " S ", 'X', material, 'S', stick };
	}
	
    public static Object[] createShovelObject(Object material, Object stick)
    {
        return new Object[] { " X ",
        					  " S ",
        					  " S ", 'X', material, 'S', stick };
        
    }
    public static Object[] createHoeObject(Object material, Object stick)
    {
    	return new Object[] { "XX ",
    						  " S ",
    						  " S ", 'X', material, 'S', stick };
    }
    public static Object[] createSwordObject(Object material, Object stick)
    {
    	return new Object[] { " X ",
    						  " X ",
    						  " S ", 'X', material, 'S', stick };
    }
    public static Object[] createHammerObject(Object material, Object stick)
    {
    	return new Object[] { "XXX", "XSX", " S ", 'X', material, 'S', stick};
    }
    public static Object[] createSnowplowObject(Object material, Object stick)
    {
    	return new Object[] { " XX", " SX", " SX" , 'X', material, 'S', stick};
    }
    public static void addToolsRecipe(Item Axe, Item Pickaxe, Item Shovel, Item Hoe, Item Sword, Object material, Object stick)
    {
    	addToolsRecipe(Axe, Pickaxe, Shovel, Hoe, material, stick);
    	ymRegistry.addRecipe(Sword, 1, createSwordObject(material, stick));
    }
    public static void addToolsRecipe(Item Axe, Item Pickaxe, Item Shovel, Item Hoe, Object material, Object stick)
    {
    	ymRegistry.addRecipe(Axe, 1, createAxeObject(material, stick));
    	ymRegistry.addRecipe(Pickaxe, 1, createPickaxeObject(material, stick));
    	ymRegistry.addRecipe(Shovel, 1, createShovelObject(material, stick));
    	ymRegistry.addRecipe(Hoe, 1, createHoeObject(material, stick));
    	
    }
}
