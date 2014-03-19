package com.github.yusukemac.MoreTools.proxy;

import java.util.EnumSet;

import com.github.yusukemac.MoreTools.Core;
import com.github.yusukemac.MoreTools.item.ItemHammer;
import com.github.yusukemac.MoreTools.item.ItemSnowplow;
import com.github.yusukemac.MoreTools.item.ItemToolOfTheEarth;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
/**
 * ここで実績の設定をしています。
 * プレイヤーがクラフトした時・かまどからアイテムを出した時にどんなアイテムかを確認し、
 * 対象と一致していたらプレイヤーに実績を追加します。
 * 
 * @author yusukemac
 */

public class ClientTickHandler
{
    @SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event)
    {
        System.out.println("ONCRAFTING");
        if (event.crafting.getItem() instanceof ItemSnowplow)
            event.player.addStat(Core.timeToSnowRemoval, 1);

        else
            if (event.crafting.getItem() instanceof ItemHammer)
                event.player.addStat(Core.timeToDismantling, 1);
        else
            if (event.crafting.getItem() instanceof ItemToolOfTheEarth)
                event.player.addStat(Core.craftToolOfTheEarth, 1);
    }
    @SubscribeEvent
    public void onSmelting(PlayerEvent.ItemSmeltedEvent event)
    {
        if (event.smelting.getItem() == Core.ingotPlastic)
            event.player.addStat(Core.getPlasticIngot, 1);
    }

}