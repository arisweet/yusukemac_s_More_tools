package com.github.yusukemac.MoreTools.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

/**
 * まったく触れてない。
 * @author yusukemac
 */

public class ClientProxy extends CommonProxy {
	
	@Override
	public void init()
	{
        FMLCommonHandler.instance().bus().register(new ClientTickHandler());
	}
}