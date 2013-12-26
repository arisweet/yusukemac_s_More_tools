package com.github.yusukemac.MoreTools;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 *
 * 	Register class.
 *
 *	@author yusuke
 *	@since 1
 *
 */
public class Register {
	
	public static void registerBlock(Block block, String name, String Jname)
	{
		GameRegistry.registerBlock(block, name);
		LanguageRegistry.addName(block, name);
		LanguageRegistry.instance().addNameForObject(block, "ja_JP", Jname);
	}
	public static void registerItem(Item item, String name, String Jname)
	{
		GameRegistry.registerItem(item, name);
		LanguageRegistry.addName(item, name);
		LanguageRegistry.instance().addNameForObject(item, "ja_JP", Jname);
	}

}
