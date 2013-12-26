package com.github.yusukemac.MoreTools.material;

import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class ToolMaterials {
	
	public static EnumToolMaterial PLASTIC, SUPERDIGGER, TOOLOFNATURE, TOOLOFTHEEARTH, STONEBREAKER;
	public static EnumToolMaterial WOOD_snowplow, STONE_snowplow, IRON_snowplow, GOLD_snowplow, DIAMOND_snowplow;
	
	public static void setToolMaterial()
	{
		PLASTIC = EnumHelper.addToolMaterial("PLASTIC", 2, 510, 7.0F, 3.0F, 16);
		SUPERDIGGER = EnumHelper.addToolMaterial("SUPERDIGGER", 3, 2400, 11.0F, 4.0F, 13);
		TOOLOFNATURE = EnumHelper.addToolMaterial("TOOLOFNATURE", 1, 2400, 11.0F, 4.0F, 13);
		TOOLOFTHEEARTH = EnumHelper.addToolMaterial("TOOLOFTHEEARTH", 3, 4500, 15.0F, 4.0F, 20);
		STONEBREAKER = EnumHelper.addToolMaterial("STONEBREAKER", 1, 7500, 11.0F, 3.0F, 18);
		
		WOOD_snowplow = EnumHelper.addToolMaterial("WOOD_snowplow", 0, 163, 3.0F, 0.0F, 15);
		STONE_snowplow = EnumHelper.addToolMaterial("STONE_snowplow", 1, 271, 5.0F, 1.0F, 5);
		IRON_snowplow = EnumHelper.addToolMaterial("IRON_snowplow", 2, 450, 7.0F, 2.0F, 14);
		GOLD_snowplow = EnumHelper.addToolMaterial("GOLD_snowplow", 0, 123, 13.0F, 0.0F, 22);
		DIAMOND_snowplow = EnumHelper.addToolMaterial("DIAMOND_snowplow", 3, 2416, 9.0F, 3.0F, 10);
	}
}
