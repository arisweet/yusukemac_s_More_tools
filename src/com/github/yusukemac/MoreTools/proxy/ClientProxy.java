package com.github.yusukemac.MoreTools.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void init()
	{
		GameRegistry.registerCraftingHandler(new ClientTickHandler());
	}
}
