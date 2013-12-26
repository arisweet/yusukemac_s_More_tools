package com.github.yusukemac.MoreTools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabYMTools extends CreativeTabs {

	public CreativeTabYMTools(String label) {
		super(label);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	@Override @SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return Core.snowplowGold;
	}
	
	@Override @SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "Yusukemac's MoreTools";
	}

}
