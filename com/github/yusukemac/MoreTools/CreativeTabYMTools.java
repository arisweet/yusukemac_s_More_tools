package com.github.yusukemac.MoreTools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * 新しいクリエイティブタブの設定
 * 
 * @author yusukemac
 */
public class CreativeTabYMTools extends CreativeTabs {

	public CreativeTabYMTools(String label) {
		super(label);
		//自動生成されたコンストラクター・スタブ
	}
	
	@Override @SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		//テクスチャには禁の除雪機を使っています
		return Core.snowplowGold;
	}
	
	/**
	 * ローカリゼーションについてはCoreで
	 * @see com.github.yusukemac.MoreTools.Core setTranslatedName(Privateのメソッド)
	 */
}
